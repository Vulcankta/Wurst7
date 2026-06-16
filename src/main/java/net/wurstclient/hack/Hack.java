/*
 * Copyright (c) 2014-2026 Wurst-Imperium and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package net.wurstclient.hack;

import java.util.Locale;
import java.util.Objects;

import net.wurstclient.Category;
import net.wurstclient.Feature;
import net.wurstclient.hacks.ClickGuiHack;
import net.wurstclient.hacks.NavigatorHack;
import net.wurstclient.hacks.TooManyHaxHack;

public abstract class Hack extends Feature
{
	private final String name;
	private final String description;
	private final String translationKey;
	private Category category;
	
	private boolean enabled;
	private final boolean stateSaved =
		!getClass().isAnnotationPresent(DontSaveState.class);
	
	public Hack(String name)
	{
		this.name = Objects.requireNonNull(name);
		translationKey = "hack.wurst." + name.toLowerCase(Locale.ROOT);
		description = "description.wurst.hack." + name.toLowerCase(Locale.ROOT);
		addPossibleKeybind(name,
			WURST.translate("gui.wurst.generic.toggle", name));
	}
	
	@Override
	public final String getName()
	{
		return name;
	}
	
	@Override
	public final String getDisplayName()
	{
		String translated = WURST.translatePlain(translationKey);
		return translated.equals(translationKey) ? name : translated;
	}
	
	/**
	 * Returns the name of the hack to be displayed in HackList.
	 *
	 * <p>
	 * WARNING: This method can be called while <code>MC.player</code> is null.
	 */
	public String getRenderName()
	{
		return getDisplayName();
	}
	
	@Override
	public final String getDescription()
	{
		return WURST.translate(description);
	}
	
	public final String getDescriptionKey()
	{
		return description;
	}
	
	@Override
	public final Category getCategory()
	{
		return category;
	}
	
	protected final void setCategory(Category category)
	{
		this.category = category;
	}
	
	@Override
	public final boolean isEnabled()
	{
		return enabled;
	}
	
	public final void setEnabled(boolean enabled)
	{
		if(this.enabled == enabled)
			return;
		
		TooManyHaxHack tooManyHax = WURST.getHax().tooManyHaxHack;
		if(enabled && tooManyHax.isEnabled() && tooManyHax.isBlocked(this))
			return;
		
		this.enabled = enabled;
		
		if(!(this instanceof NavigatorHack || this instanceof ClickGuiHack))
			WURST.getHud().getHackList().updateState(this);
		
		if(enabled)
			onEnable();
		else
			onDisable();
		
		if(stateSaved)
			WURST.getHax().saveEnabledHax();
	}
	
	@Override
	public final String getPrimaryAction()
	{
		return WURST.translatePlain(
			enabled ? "gui.wurst.generic.disable" : "gui.wurst.generic.enable");
	}
	
	@Override
	public final void doPrimaryAction()
	{
		setEnabled(!enabled);
	}
	
	public final boolean isStateSaved()
	{
		return stateSaved;
	}
	
	protected void onEnable()
	{
		
	}
	
	protected void onDisable()
	{
		
	}
}

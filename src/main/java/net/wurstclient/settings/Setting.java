/*
 * Copyright (c) 2014-2026 Wurst-Imperium and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package net.wurstclient.settings;

import java.util.Locale;
import java.util.Objects;
import java.util.Set;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.wurstclient.WurstClient;
import net.wurstclient.clickgui.Component;
import net.wurstclient.keybinds.PossibleKeybind;
import net.wurstclient.util.ChatUtils;
import net.wurstclient.util.text.WText;

public abstract class Setting
{
	protected static final WurstClient WURST = WurstClient.INSTANCE;
	
	private final String name;
	private final WText description;
	private String parentFeatureName;
	private String translationKey;
	
	public Setting(String name, WText description)
	{
		this.name = Objects.requireNonNull(name);
		this.description = Objects.requireNonNull(description);
	}
	
	public final String getName()
	{
		return name;
	}
	
	public String getDisplayName()
	{
		if(translationKey == null)
			return getName();
		
		String translated = WURST.translatePlain(translationKey);
		return translated.equals(translationKey) ? name : translated;
	}
	
	/**
	 * Sets the parent feature name used to construct the translation key for
	 * {@link #getDisplayName()}. This must only be called once by the
	 * framework during {@code Feature.addSetting()}. Re-assignment is not
	 * allowed and will throw {@link IllegalStateException}.
	 */
	public void setParentFeatureName(String parentFeatureName)
	{
		if(this.parentFeatureName != null)
			throw new IllegalStateException(
				"parentFeatureName already set for setting: " + name);
		
		this.parentFeatureName = Objects.requireNonNull(parentFeatureName);
		translationKey =
			"setting.wurst." + parentFeatureName.toLowerCase(Locale.ROOT) + "."
				+ name.toLowerCase(Locale.ROOT).replace(" ", "_");
	}
	
	public final String getDescription()
	{
		return description.toString();
	}
	
	public final String getWrappedDescription(int width)
	{
		return ChatUtils.wrapText(getDescription(), width);
	}
	
	public abstract Component getComponent();
	
	public abstract void fromJson(JsonElement json);
	
	public abstract JsonElement toJson();
	
	/**
	 * Exports this setting's data to a {@link JsonObject} for use in the
	 * Wurst Wiki. Must always specify the following properties:
	 * <ul>
	 * <li>name
	 * <li>description
	 * <li>type
	 * </ul>
	 */
	public abstract JsonObject exportWikiData();
	
	public void update()
	{
		
	}
	
	public abstract Set<PossibleKeybind> getPossibleKeybinds(
		String featureName);
}

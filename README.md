# Wurst Client v7（中文漢化分支）

> **此為 [Wurst Client](https://github.com/Wurst-Imperium/Wurst7) 的非官方中文漢化 Fork。**
>
> 除 zh_cn（簡體中文）、zh_tw（繁體中文-台灣）、zh_hk（繁體中文-香港）翻譯外，其餘功能與上游完全一致，無任何功能性修改。
>
> 本分支的翻譯涵蓋所有 hack 名稱、描述、設定項、分類標籤及 UI 介面文字，共計 **1,090 個翻譯鍵**。
>
> 對於功能本身有任何問題，請前往原專案的 [Forum](https://wurstforum.net/) 討論。

![Wurst Client logo](https://img.wimods.net/github.com/Wurst-Imperium/Wurst7?to=https://wurst.wiki/_media/logo/wurst_758x192.webp)

- **原版下載 / Original Downloads:** [https://www.wurstclient.net/download/](https://go.wimods.net/from/github.com/Wurst-Imperium/Wurst7?to=https%3A%2F%2Fwww.wurstclient.net%2Fdownload%2F%3Futm_source%3DGitHub%26utm_medium%3DWurst7%2Brepo)

- **Installation guide:** [https://www.wurstclient.net/tutorials/how-to-install/](https://go.wimods.net/from/github.com/Wurst-Imperium/Wurst7?to=https%3A%2F%2Fwww.wurstclient.net%2Ftutorials%2Fhow-to-install%2F%3Futm_source%3DGitHub%26utm_medium%3DWurst7%2Brepo)

- **Feature list:** [https://www.wurstclient.net/](https://go.wimods.net/from/github.com/Wurst-Imperium/Wurst7?to=https%3A%2F%2Fwww.wurstclient.net%2F%3Futm_source%3DGitHub%26utm_medium%3DWurst7%2Brepo)

- **Wiki:** [https://wurst.wiki/](https://go.wimods.net/from/github.com/Wurst-Imperium/Wurst7?to=https%3A%2F%2Fwurst.wiki%2F%3Futm_source%3DGitHub%26utm_medium%3DWurst7%2Brepo)

- **Forum:** [https://wurstforum.net/](https://go.wimods.net/from/github.com/Wurst-Imperium/Wurst7?to=https%3A%2F%2Fwurstforum.net%2F%3Futm_source%3DGitHub%26utm_medium%3DWurst7%2Brepo)	

- **Twitter/X:** [https://x.com/Wurst_Imperium](https://go.wimods.net/from/github.com/Wurst-Imperium/Wurst7?to=https://x.com/Wurst_Imperium)

- **YouTube:** [https://www.youtube.com/@Alexander01998](https://go.wimods.net/from/github.com/Wurst-Imperium/Wurst7?to=https://www.youtube.com/@Alexander01998)

- **Donations/Perks:** [https://ko-fi.com/wurst](https://go.wimods.net/from/github.com/Wurst-Imperium/Wurst7?to=https://ko-fi.com/wurst)

## Installation

Wurst 7 can be installed just like any other Fabric mod. Here are the basic installation steps:

1. Run the Fabric installer.
2. Add the Wurst Client and Fabric API to your mods folder.

Please refer to the [full Wurst 7 installation guide](https://go.wimods.net/from/github.com/Wurst-Imperium/Wurst7?to=https%3A%2F%2Fwww.wurstclient.net%2Ftutorials%2Fhow-to-install%2F%3Futm_source%3DGitHub%26utm_medium%3DWurst7%2Brepo) if you need more detailed instructions or run into any problems.

Also, this should be obvious, but you do need to have a licensed copy of Minecraft Java Edition in order to use Wurst. Wurst is a cheat client, not a pirate client.

## Development Setup

> [!IMPORTANT]
> Make sure you have [Java Development Kit 21](https://go.wimods.net/from/github.com/Wurst-Imperium/Wurst7?to=https%3A%2F%2Fadoptium.net%2F%3Fvariant%3Dopenjdk21%26jvmVariant%3Dhotspot) installed. It won't work with other versions.

### Development using Eclipse

1. Clone the repository:

   ```pwsh
   git clone https://github.com/Wurst-Imperium/Wurst7.git
   cd Wurst7
   ```

2. Generate the sources:

   ```pwsh
   ./gradlew genSources eclipse
   ```

3. In Eclipse, go to `Import...` > `Existing Projects into Workspace` and select this project.

4. **Optional:** Right-click on the project and select `Properties` > `Java Code Style`. Then under `Clean Up`, `Code Templates`, `Formatter`, import the respective files in the `codestyle` folder.

### Development using VSCode / Cursor

> [!TIP]
> You'll probably want to install the [Extension Pack for Java](https://go.wimods.net/from/github.com/Wurst-Imperium/Wurst7?to=https%3A%2F%2Fmarketplace.visualstudio.com%2Fitems%3FitemName%3Dvscjava.vscode-java-pack) to make development easier.

1. Clone the repository:

   ```pwsh
   git clone https://github.com/Wurst-Imperium/Wurst7.git
   cd Wurst7
   ```

2. Generate the sources:

   ```pwsh
   ./gradlew genSources vscode
   ```

3. Open the `Wurst7` folder in VSCode / Cursor.

4. **Optional:** In the VSCode settings, set `java.format.settings.url` to `https://raw.githubusercontent.com/Wurst-Imperium/Wurst7/master/codestyle/formatter.xml` and `java.format.settings.profile` to `Wurst-Imperium`.

### Development using IntelliJ IDEA

I don't use or recommend IntelliJ, but the commands to run would be:

```pwsh
git clone https://github.com/Wurst-Imperium/Wurst7.git
cd Wurst7
./gradlew genSources idea --no-configuration-cache
```

**Note:** IntelliJ IDEA is [not yet compatible](https://github.com/FabricMC/fabric-loom/issues/1349) with Gradle's configuration cache. You will run into issues.

Possible workarounds:
- Turn off args files ([this setting](https://i.imgur.com/zHqIOYg.png)). Won't work for some users because of a command length limit.
- Add `--no-configuration-cache` to all of your Gradle commands.

## Contributing

Please always [contact me](https://go.wimods.net/from/github.com/Wurst-Imperium/Wurst7?to=https%3A%2F%2Fwww.wurstclient.net%2Fcontact%2F%3Futm_source%3DGitHub%26utm_medium%3DWurst7%2Brepo) before opening a Pull Request. Any method works. That way we can discuss your ideas early and avoid wasting your time working on unwanted features or having to make lots of changes later.

We also have [contributing guidelines](https://go.wimods.net/from/github.com/Wurst-Imperium/Wurst7?to=https://github.com/Wurst-Imperium/Wurst7/blob/master/CONTRIBUTING.md) to help you get started.

> **注意：** 以上為原專案（Wurst-Imperium）的貢獻說明，僅供參考。**本 Fork 不接受 Pull Request。**

## 中文翻譯 / Chinese Translations

本 Fork 已包含完整的繁體/簡體中文翻譯。啟用方式：

1. 遊戲內開啟 ClickGUI → **Wurst Options** → **Translations** → **ON**
2. 將 Minecraft 語言設為 **简体中文 (中国大陆)**、**繁體中文 (台灣)** 或 **繁體中文 (香港)**

翻譯覆蓋範圍：
- ✅ 所有 hack 名稱與描述
- ✅ 所有設定項名稱
- ✅ ClickGUI / Navigator / TabGUI 等所有 UI 介面
- ✅ HackList 側邊欄狀態標籤
- ✅ 分類標籤（方塊、移動、戰鬥、渲染、聊天、娛樂、物品、其他）

> **注意：** hack 的內部名稱（用於指令、按鍵綁定）仍保留英文，以確保指令與按鍵設定在不同語言使用者之間互通。

### 翻譯貢獻 / Contributing Translations

如果你發現翻譯錯誤或有更好的翻譯建議，歡迎在 [Issues](https://github.com/Vulcankta/Wurst7/issues) 提出。**本 Fork 不接受 Pull Request。**

翻譯檔案位於 [`src/main/resources/assets/wurst/translations/`](src/main/resources/assets/wurst/translations/)。

## License

This code is licensed under the GNU General Public License v3. **You can only use this code in open-source clients that you release under the same license! Using it in closed-source/proprietary clients is not allowed!**

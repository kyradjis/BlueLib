package software.bluelib.test.markdown.syntax;

import net.minecraft.gametest.framework.GameTestHelper;
import software.bluelib.test.utils.MessageUtils;

public class StrikethroughTest {

    public static void strikethrough(GameTestHelper pHelper) {
        MessageUtils.sendMessageToPlayers(pHelper, "§6 This is a strikethrough test: §r ~~Strikethrough~~");
    }

    public static void strikethroughBold(GameTestHelper pHelper) {
        MessageUtils.sendMessageToPlayers(pHelper, "§6 This is a strikethrough/bold test: §r ~~Strikethrough~~ **bold**");
    }

    public static void strikethroughItalic(GameTestHelper pHelper) {
        MessageUtils.sendMessageToPlayers(pHelper, "§6 This is an strikethrough/italic test: §r ~~Strikethrough~~ *italic*");
    }

    public static void strikethroughUnderline(GameTestHelper pHelper) {
        MessageUtils.sendMessageToPlayers(pHelper, "§6 This is an strikethrough/underline test: §r ~~Strikethrough~~ __Underline__");
    }

    public static void strikethroughStrikethrough(GameTestHelper pHelper) {
        MessageUtils.sendMessageToPlayers(pHelper, "§6 This is an strikethrough/strikethrough test: §r ~~Strikethrough~~ ~~Strikethrough~~");
    }

    public static void strikethroughHyperlink(GameTestHelper pHelper) {
        MessageUtils.sendMessageToPlayers(pHelper, "§6 This is a strikethrough/hyperlink test: §r ~~Strikethrough~~ [Hyperlink](https://www.curseforge.com/minecraft/mc-mods/bluelib)");
    }

    public static void strikethroughColor(GameTestHelper pHelper) {
        MessageUtils.sendMessageToPlayers(pHelper, "§6 This is a strikethrough/color test: §r ~~Strikethrough~~ -#" + MessageUtils.getRandomHex() + "-(Color)");
    }

    public static void strikethroughSpoiler(GameTestHelper pHelper) {
        MessageUtils.sendMessageToPlayers(pHelper, "§6 This is a strikethrough/spoiler test: §r ~~Strikethrough~~ ||spoiler||");
    }

    public static void strikethroughCancel(GameTestHelper pHelper) {
        MessageUtils.sendMessageToPlayers(pHelper, "§6 This is a canceled strikethrough test: §r \\~~Strikethrough~~");
    }
}

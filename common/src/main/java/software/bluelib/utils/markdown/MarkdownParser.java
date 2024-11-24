// Copyright (c) BlueLib. Licensed under the MIT License.

package software.bluelib.utils.markdown;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerPlayer;
import software.bluelib.utils.logging.BaseLogLevel;
import software.bluelib.utils.logging.BaseLogger;

/**
 * A {@code public class} responsible for parsing and formatting Markdown into Minecraft's {@link Component}.
 * <p>
 * This class processes text components and applies Markdown-style formatting (bold, italic, strikethrough, and underline) to
 * the text. The formatting is controlled globally or individually through the {@link EnableMarkdownFor} and {@link DisableMarkdownFor} inner classes.
 * </p>
 * <p>
 * Key Methods:
 * <ul>
 * <li>{@link #parseMarkdown(Component, ServerPlayer)} - Parses and applies Markdown formatting to a given message component.</li>
 * <li>{@link #enableMarkdown()} - Enables global Markdown formatting.</li>
 * <li>{@link #disableMarkdown()} - Disables global Markdown formatting.</li>
 * <li>{@link #enableMarkdownFor()} - Returns an instance of {@link EnableMarkdownFor} to enable specific Markdown features.</li>
 * <li>{@link #disableMarkdownFor()} - Returns an instance of {@link DisableMarkdownFor} to disable specific Markdown features.</li>
 * </ul>
 *
 * @author MeAlam
 * @version 1.4.0
 * @since 1.1.0
 */
public class MarkdownParser {

    /**
     * A {@code private static boolean} indicating whether global markdown processing is enabled.
     *
     * @since 1.1.0
     */
    private static boolean globalMarkdownEnabled = true;

    /**
     * A {@code private static} to escape special characters in the input string using regular expressions.
     * <p>
     * This method escapes characters that have special meaning in regex, such as asterisks, brackets, parentheses, etc.
     * </p>
     *
     * @param pInput {@link String} - The input string to escape.
     * @return A {@link String} with the special characters escaped.
     * @author MeAlam
     * @since 1.1.0
     */
    private static String escapeRegex(String pInput) {
        BaseLogger.log(BaseLogLevel.INFO, "Escaping special characters for regex", true);
        return pInput.replaceAll("([\\\\*+\\[\\](){}|.^$?])", "\\\\$1");
    }

    /**
     * A {@code public static} that parses and applies Markdown formatting to a given {@link Component} message.
     * <p>
     * This method checks if global markdown formatting is enabled, then applies the relevant formats (bold, italic,
     * strikethrough, and underline) to the string content of the component.
     * </p>
     *
     * @param pMessage {@link Component} - The message component containing the text to format.
     * @return A {@link MutableComponent} with the Markdown formatting applied.
     * @author MeAlam
     * @since 1.1.0
     */
    public static MutableComponent parseMarkdown(Component pMessage) {
        if (!globalMarkdownEnabled) {
            BaseLogger.log(BaseLogLevel.INFO, "Global markdown is disabled, returning original message", true);
        }

        String text = pMessage.getString();
        text = new Bold().apply(text);
        text = new Italic().apply(text);
        text = new Strikethrough().apply(text);
        text = new Underline().apply(text);
        MutableComponent formattedMessage = new Hyperlink().applyLast(text);
        BaseLogger.log(BaseLogLevel.INFO, "Markdown applied to message: " + text, true);
        return formattedMessage;
    }

    /**
     * A {@code public static} method that enables global markdown formatting.
     * <p>
     * This method sets the {@code globalMarkdownEnabled} flag to {@code true}, allowing markdown formatting to be applied globally.
     * </p>
     *
     * @since 1.1.0
     */
    public static void enableMarkdown() {
        globalMarkdownEnabled = true;
        BaseLogger.log(BaseLogLevel.INFO, "Global markdown enabled", true);
    }

    /**
     * A {@code public static} method that disables global markdown formatting.
     * <p>
     * This method sets the {@code globalMarkdownEnabled} flag to {@code false}, preventing any markdown formatting from being applied globally.
     * </p>
     *
     * @since 1.1.0
     */
    public static void disableMarkdown() {
        globalMarkdownEnabled = false;
        BaseLogger.log(BaseLogLevel.INFO, "Global markdown disabled", true);
    }

    /**
     * A {@code public static} method that returns a new instance of {@link EnableMarkdownFor} to enable markdown for specific formats.
     * <p>
     * This method is used to selectively enable markdown formatting for individual features (e.g., bold, italic, etc.).
     * </p>
     *
     * @return A new {@link EnableMarkdownFor} instance.
     * @author MeAlam
     * @since 1.1.0
     */
    public static EnableMarkdownFor enableMarkdownFor() {
        BaseLogger.log(BaseLogLevel.INFO, "Returning EnableMarkdownFor instance", true);
        return new EnableMarkdownFor();
    }

    /**
     * A {@code public static} method that returns a new instance of {@link DisableMarkdownFor} to disable markdown for specific formats.
     * <p>
     * This method is used to selectively disable markdown formatting for individual features (e.g., bold, italic, etc.).
     * </p>
     *
     * @return A new {@link DisableMarkdownFor} instance.
     * @author MeAlam
     * @since 1.1.0
     */
    public static DisableMarkdownFor disableMarkdownFor() {
        BaseLogger.log(BaseLogLevel.INFO, "Returning DisableMarkdownFor instance", true);
        return new DisableMarkdownFor();
    }

    /**
     * A {@code public static inner class} used to enable markdown formatting for specific features.
     * <p>
     * The methods in this class allow you to enable individual Markdown features (bold, italic, etc.) without affecting others.
     * </p>
     *
     * @author MeAlam
     * @version 1.1.0
     * @since 1.1.0
     */
    public static class EnableMarkdownFor {

        /**
         * A {@code public} method that enables bold Markdown formatting.
         *
         * @return The {@link EnableMarkdownFor} instance to allow method chaining.
         * @author MeAlam
         * @since 1.1.0
         */
        public EnableMarkdownFor bold() {
            Bold.isBoldEnabled = true;
            BaseLogger.log(BaseLogLevel.INFO, "Enabled bold markdown", true);
            return this;
        }

        /**
         * A {@code public} method that enables italic Markdown formatting.
         *
         * @return The {@link EnableMarkdownFor} instance to allow method chaining.
         * @author MeAlam
         * @since 1.1.0
         */
        public EnableMarkdownFor italic() {
            Italic.isItalicEnabled = true;
            BaseLogger.log(BaseLogLevel.INFO, "Enabled italic markdown", true);
            return this;
        }

        /**
         * A {@code public} method that enables strikethrough Markdown formatting.
         *
         * @return The {@link EnableMarkdownFor} instance to allow method chaining.
         * @author MeAlam
         * @since 1.1.0
         */
        public EnableMarkdownFor strikethrough() {
            Strikethrough.isStrikethroughEnabled = true;
            BaseLogger.log(BaseLogLevel.INFO, "Enabled strikethrough markdown", true);
            return this;
        }

        /**
         * A {@code public} method that enables underline Markdown formatting.
         *
         * @return The {@link EnableMarkdownFor} instance to allow method chaining.
         * @author MeAlam
         * @since 1.1.0
         */
        public EnableMarkdownFor underline() {
            Underline.isUnderlineEnabled = true;
            BaseLogger.log(BaseLogLevel.INFO, "Enabled underline markdown", true);
            return this;
        }
    }

    /**
     * A {@code public static inner class} used to disable markdown formatting for specific features.
     * <p>
     * The methods in this class allow you to disable individual Markdown features (bold, italic, etc.) without affecting others.
     * </p>
     *
     * @author MeAlam
     * @version 1.1.0
     * @since 1.1.0
     */
    public static class DisableMarkdownFor {

        /**
         * A {@code public} method that disables bold Markdown formatting.
         *
         * @return The {@link DisableMarkdownFor} instance to allow method chaining.
         * @author MeAlam
         * @since 1.1.0
         */
        public DisableMarkdownFor bold() {
            Bold.isBoldEnabled = false;
            BaseLogger.log(BaseLogLevel.INFO, "Disabled bold markdown", true);
            return this;
        }

        /**
         * A {@code public} method that disables italic Markdown formatting.
         *
         * @return The {@link DisableMarkdownFor} instance to allow method chaining.
         * @author MeAlam
         * @since 1.1.0
         */
        public DisableMarkdownFor italic() {
            Italic.isItalicEnabled = false;
            BaseLogger.log(BaseLogLevel.INFO, "Disabled italic markdown", true);
            return this;
        }

        /**
         * A {@code public} method that disables strikethrough Markdown formatting.
         *
         * @return The {@link DisableMarkdownFor} instance to allow method chaining.
         * @author MeAlam
         * @since 1.1.0
         */
        public DisableMarkdownFor strikethrough() {
            Strikethrough.isStrikethroughEnabled = false;
            BaseLogger.log(BaseLogLevel.INFO, "Disabled strikethrough markdown", true);
            return this;
        }

        /**
         * A {@code public} method that disables underline Markdown formatting.
         *
         * @return The {@link DisableMarkdownFor} instance to allow method chaining.
         * @author MeAlam
         * @since 1.1.0
         */
        public DisableMarkdownFor underline() {
            Underline.isUnderlineEnabled = false;
            BaseLogger.log(BaseLogLevel.INFO, "Disabled underline markdown", true);
            return this;
        }
    }
}

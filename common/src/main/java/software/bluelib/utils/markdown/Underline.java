// Copyright (c) BlueLib. Licensed under the MIT License.

package software.bluelib.utils.markdown;

/**
 * A {@code public class} representing the underline Markdown formatting feature.
 * <p>
 * This class applies underline formatting to text surrounded by double underscores (__). It extends the
 * {@link MarkdownFeature} class and overrides the {@link #applyFormat(String)} method to provide
 * the specific formatting logic for underlined text.
 * </p>
 *
 * @author MeAlam
 * @version 1.1.0
 * @see MarkdownFeature
 * @see #applyFormat(String)
 * @since 1.1.0
 */
public class Underline extends MarkdownFeature {

    /**
     * A {@code protected static} field representing the default prefix for Underline formatting.
     *
     * @since 1.2.0
     */
    protected static String Prefix = "__";

    /**
     * A {@code protected static} field representing the default suffix for Underline formatting.
     *
     * @since 1.2.0
     */
    protected static String Suffix = "__";

    /**
     * A {@code protected} {@link Boolean} that determines whether the underline formatting feature is enabled.
     *
     * @since 1.1.0
     */
    protected static Boolean isUnderlineEnabled = true;

    /**
     * A {@code public} constructor that initializes the prefix and suffix for the underline formatting feature.
     * <p>
     * The constructor sets the prefix and suffix to double underscores (__) for identifying content to be underlined.
     * </p>
     *
     * @author MeAlam
     * @since 1.1.0
     */
    public Underline() {
        prefix = Prefix;
        suffix = Suffix;
    }

    /**
     * A {@code protected} {@link String} that applies the specific underline formatting to the input content.
     * <p>
     * This method overrides the {@link #applyFormat(String)} method from the {@link MarkdownFeature} class
     * to add underline formatting to the content by wrapping it with the underline Minecraft format (§n and §r).
     * </p>
     *
     * @param pContent {@link String} - The content to be formatted with underline.
     * @return The content wrapped with underline formatting.
     * @author MeAlam
     * @see MarkdownFeature
     * @see #apply(String)
     * @since 1.1.0
     */
    @Override
    protected String applyFormat(String pContent) {
        if (!isUnderlineEnabled) {
            return prefix + pContent + suffix;
        }
        return "§n" + pContent + "§r";
    }


    /**
     * A {@code public static void} to update the prefix and suffix used for Underline formatting.
     *
     * @param pPrefix {@link String} - The new prefix for Underline formatting.
     * @param pSuffix {@link String} - The new suffix for Underline formatting.
     * @author MeAlam
     * @since 1.2.0
     */
    public static void setPrefixSuffix(String pPrefix, String pSuffix) {
        Prefix = pPrefix;
        Suffix = pSuffix;
    }

    /**
     * A {@code public static void} to update the prefix used for Underline formatting.
     *
     * @param pPrefix {@link String} - The new prefix for Underline formatting.
     * @author MeAlam
     * @since 1.2.0
     */
    public static void setPrefix(String pPrefix) {
        Prefix = pPrefix;
    }

    /**
     * A {@code public static void} to update the suffix used for Underline formatting.
     *
     * @param pSuffix {@link String} - The new suffix for Underline formatting.
     * @author MeAlam
     * @since 1.2.0
     */
    public static void setSuffix(String pSuffix) {
        Suffix = pSuffix;
    }

    /**
     * A {@code public static} {@link String} that retrieves the current prefix used for Underline formatting.
     *
     * @return The current prefix for Underline formatting.
     * @author MeAlam
     * @since 1.2.0
     */
    public static String getPrefix() {
        return Prefix;
    }

    /**
     * A {@code public static} {@link String} that retrieves the current suffix used for Underline formatting.
     *
     * @return The current suffix for Underline formatting.
     * @author MeAlam
     * @since 1.2.0
     */
    public static String getSuffix() {
        return Suffix;
    }

    /**
     * A {@code public static} {@link Boolean} that retrieves whether Underline formatting is enabled.
     *
     * @return {@code true} if Underline formatting is enabled, {@code false} otherwise.
     * @author MeAlam
     * @since 1.2.0
     */
    public static Boolean isUnderlineEnabled() {
        return isUnderlineEnabled;
    }
}

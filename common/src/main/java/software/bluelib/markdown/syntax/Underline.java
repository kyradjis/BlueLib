// Copyright (c) BlueLib. Licensed under the MIT License.

package software.bluelib.markdown.syntax;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import software.bluelib.markdown.MarkdownFeature;
import software.bluelib.utils.logging.BaseLogLevel;
import software.bluelib.utils.logging.BaseLogger;

/**
 * Handles the application of the underline feature to Markdown text.
 * <p>
 * Purpose: This class is responsible for adding underline formatting to text within markdown syntax.<br>
 * When: The underline is applied when the text is surrounded by a specified prefix and suffix.<br>
 * Where: Executed within the {@link software.bluelib.markdown.MarkdownParser#parseMarkdown(Component)} method when the feature is enabled.<br>
 * Additional Info: The default prefix and suffix are both set to "__". The feature is controlled by the {@link Underline#isUnderlineEnabled} flag.
 * </p>
 * <p>
 * Key Methods:
 * <ul>
 * <li>{@link #appendFormattedText(String, Style, MutableComponent)} - Applies the Underline formatting to the provided text.</li>
 * <li>{@link #isFeatureEnabled()} - Checks if the Underline feature is enabled.</li>
 * <li>{@link #getFeatureName()} - Retrieves the name of the Underline feature.</li>
 * <li>{@link #setPrefixSuffix(String, String)} - Updates the prefix and suffix used for Underline formatting.</li>
 * <li>{@link #setPrefix(String)} - Updates the prefix used for Underline formatting.</li>
 * <li>{@link #setSuffix(String)} - Updates the suffix used for Underline formatting.</li>
 * <li>{@link #getPrefix()} - Retrieves the current prefix used for Underline formatting.</li>
 * <li>{@link #getSuffix()} - Retrieves the current suffix used for Underline formatting.</li>
 * <li>{@link #isUnderlineEnabled()} - Retrieves whether Underline formatting is enabled.</li>
 * </ul>
 *
 * @author MeAlam
 * @version 1.6.0
 * @see software.bluelib.markdown.MarkdownParser
 * @see MarkdownFeature
 * @see Style
 * @see MutableComponent
 * @since 1.1.0
 */
public class Underline extends MarkdownFeature {

    /**
     * Default prefix for underline formatting.
     * <p>
     * Purpose: This variable stores the default prefix for applying underline formatting.<br>
     * When: It is used when checking for the start of an underline formatted section.<br>
     * Where: Used in the {@link Underline#prefix} and {@link Underline#suffix} logic.<br>
     * Additional Info: The default value is "__", but it can be modified using {@link Underline#setPrefix(String)} and {@link Underline#setSuffix(String)}.<br>
     * </p>
     *
     * @see Underline#setSuffix(String)
     * @see Underline#setPrefix(String)
     * @see Underline#Suffix
     * @see Underline#setPrefixSuffix(String, String)
     * @see Underline#getSuffix()
     * @see Underline#getPrefix()
     * @since 1.2.0
     */
    protected static String Prefix = "__";

    /**
     * Default suffix for underline formatting.
     * <p>
     * Purpose: This variable stores the default suffix for applying underline formatting.<br>
     * When: It is used when checking for the end of an underline formatted section.<br>
     * Where: Used in the {@link Underline#prefix} and {@link Underline#suffix} logic.<br>
     * Additional Info: The default value is "__", but it can be modified using {@link Underline#setPrefix(String)} and {@link Underline#setSuffix(String)}.<br>
     * </p>
     *
     * @see Underline#setSuffix(String)
     * @see Underline#setPrefix(String)
     * @see Underline#Prefix
     * @see Underline#setPrefixSuffix(String, String)
     * @see Underline#getSuffix()
     * @see Underline#getPrefix()
     * @since 1.2.0
     */
    protected static String Suffix = "__";

    /**
     * Flag that determines whether the underline feature is enabled.
     * <p>
     * Purpose: This variable holds the state of the underline feature (enabled or disabled).<br>
     * When: It is checked whenever the markdown text is processed to determine whether the underline should be applied.<br>
     * Where: It is used in the {@link Underline#isFeatureEnabled()} and {@link Underline#isUnderlineEnabled()} methods.<br>
     * Additional Info: This feature can be enabled or disabled globally through this flag.<br>
     * </p>
     *
     * @see Underline#isFeatureEnabled()
     * @see Underline#isUnderlineEnabled()
     * @since 1.1.0
     */
    public static Boolean isUnderlineEnabled = true;

    /**
     * Constructor that initializes the prefix and suffix for the underline feature.
     * <p>
     * Purpose: This constructor sets the default prefix and suffix values for the underline formatting.<br>
     * When: It is invoked when creating an instance of the {@link Underline} class.<br>
     * Where: Executed within the {@link Underline} constructor.<br>
     * Additional Info: The default prefix and suffix are both set to "__".<br>
     * </p>
     *
     * @author MeAlam
     * @see Underline#Prefix
     * @see Underline#Suffix
     * @see Underline#setPrefix(String)
     * @see Underline#setSuffix(String)
     * @see Underline#setPrefixSuffix(String, String)
     * @see Underline#getPrefix()
     * @see Underline#getSuffix()
     * @since 1.1.0
     */
    public Underline() {
        prefix = Prefix;
        suffix = Suffix;
    }

    /**
     * Appends the formatted text with the underline style to the result component.
     * <p>
     * Purpose: This method takes the provided text and applies the underline style, then appends it to the result.<br>
     * When: Called when processing a markdown string with underline syntax.<br>
     * Where: Executed in {@link MarkdownFeature#processComponentTextWithFormatting(String, Style, MutableComponent, java.util.regex.Pattern)}.<br>
     * Additional Info: The text is wrapped with a style that enables underlining.<br>
     * </p>
     *
     * @param pText          The text to be formatted with underline.
     * @param pOriginalStyle The original style applied to the text.
     * @param pResult        The mutable component that the formatted text will be appended to.
     * @author MeAlam
     * @see MarkdownFeature#processComponentTextWithFormatting(String, Style, MutableComponent, java.util.regex.Pattern)
     * @since 1.6.0
     */
    @Override
    protected void appendFormattedText(String pText, Style pOriginalStyle, MutableComponent pResult) {
        MutableComponent UnderlineText = Component.literal(pText)
                .setStyle(pOriginalStyle.withUnderlined(true));
        pResult.append(UnderlineText);
    }

    /**
     * Checks if the underline feature is enabled.
     * <p>
     * Purpose: Determines whether the underline feature is active based on the {@link #isUnderlineEnabled} flag.<br>
     * When: Called before processing the text to check if the feature should be applied.<br>
     * Where: Executed in {@link MarkdownFeature#apply(MutableComponent)}.<br>
     * Additional Info: This flag can be changed through {@link Underline#isUnderlineEnabled}.<br>
     * </p>
     *
     * @return {@code true} if underline is enabled, {@code false} otherwise.
     * @author MeAlam
     * @see Underline#isUnderlineEnabled
     * @see MarkdownFeature#apply(MutableComponent)
     * @since 1.6.0
     */
    @Override
    protected boolean isFeatureEnabled() {
        return isUnderlineEnabled;
    }

    /**
     * Gets the feature's name.
     * <p>
     * Purpose: Provides the name of this Markdown feature for display purposes.<br>
     * When: It is called to return the feature name in logs or debugging output.<br>
     * Where: Used in the {@link MarkdownFeature#apply(MutableComponent)}.<br>
     * Additional Info: The name is returned as a simple string.<br>
     * </p>
     *
     * @return The name of the feature, which is "Underline".
     * @author MeAlam
     * @see MarkdownFeature#apply(MutableComponent)
     * @since 1.6.0
     */
    @Override
    protected String getFeatureName() {
        return "Underline";
    }

    /**
     * Sets the prefix and suffix used for underline formatting.
     * <p>
     * Purpose: This method allows the user to set both the prefix and suffix for underline formatting.<br>
     * When: It is called to customize the prefix and suffix.<br>
     * Where: Can be invoked from any class or method.<br>
     * Additional Info: The updated prefix and suffix will affect all instances of the {@link Underline} feature.<br>
     * </p>
     *
     * @param pPrefix The new prefix for underline.
     * @param pSuffix The new suffix for underline.
     * @author MeAlam
     * @see Underline#setSuffix(String)
     * @see Underline#getSuffix()
     * @see Underline#setPrefix(String)
     * @see Underline#getPrefix()
     * @see Underline#Suffix
     * @see Underline#Prefix
     * @since 1.2.0
     */
    public static void setPrefixSuffix(String pPrefix, String pSuffix) {
        Prefix = pPrefix;
        Suffix = pSuffix;
        BaseLogger.log(BaseLogLevel.SUCCESS, "Underline prefix and suffix updated to: " + Prefix + " and " + Suffix, true);
    }

    /**
     * Sets the prefix used for underline formatting.
     * <p>
     * Purpose: This method allows the user to set the prefix for underline formatting.<br>
     * When: It is called to customize the prefix.<br>
     * Where: Can be invoked from any class or method.<br>
     * Additional Info: The updated prefix will affect all instances of the {@link Underline} feature.<br>
     * </p>
     *
     * @param pPrefix The new prefix for underline.
     * @author MeAlam
     * @see Underline#setSuffix(String)
     * @see Underline#setPrefixSuffix(String, String)
     * @see Underline#getSuffix()
     * @see Underline#getPrefix()
     * @see Underline#Suffix
     * @see Underline#Prefix
     * @since 1.2.0
     */
    public static void setPrefix(String pPrefix) {
        Prefix = pPrefix;
        BaseLogger.log(BaseLogLevel.SUCCESS, "Underline prefix updated to: " + Prefix, true);
    }

    /**
     * Sets the suffix used for underline formatting.
     * <p>
     * Purpose: This method allows the user to set the suffix for underline formatting.<br>
     * When: It is called to customize the suffix.<br>
     * Where: Can be invoked from any class or method.<br>
     * Additional Info: The updated suffix will affect all instances of the {@link Underline} feature.<br>
     * </p>
     *
     * @param pSuffix The new suffix for underline.
     * @author MeAlam
     * @see Underline#getSuffix()
     * @see Underline#setPrefixSuffix(String, String)
     * @see Underline#setPrefix(String)
     * @see Underline#getPrefix()
     * @see Underline#Suffix
     * @see Underline#Prefix
     * @since 1.2.0
     */
    public static void setSuffix(String pSuffix) {
        Suffix = pSuffix;
        BaseLogger.log(BaseLogLevel.SUCCESS, "Underline suffix updated to: " + Suffix, true);
    }

    /**
     * Gets the prefix used for underline formatting.
     * <p>
     * Purpose: This method returns the current prefix used for underline formatting.<br>
     * When: It is called to retrieve the prefix.<br>
     * Where: Can be invoked from any class or method.<br>
     * Additional Info: This returns the default or custom prefix depending on prior settings.<br>
     * </p>
     *
     * @return The current prefix used for underline.
     * @author MeAlam
     * @see Underline#setSuffix(String)
     * @see Underline#setPrefixSuffix(String, String)
     * @see Underline#setPrefix(String)
     * @see Underline#getSuffix()
     * @see Underline#Suffix
     * @see Underline#Prefix
     * @since 1.2.0
     */
    public static String getPrefix() {
        return Prefix;
    }

    /**
     * Gets the suffix used for underline formatting.
     * <p>
     * Purpose: This method returns the current suffix used for underline formatting.<br>
     * When: It is called to retrieve the suffix.<br>
     * Where: Can be invoked from any class or method.<br>
     * Additional Info: This returns the default or custom suffix depending on prior settings.<br>
     * </p>
     *
     * @return The current suffix used for underline.
     * @author MeAlam
     * @see Underline#setSuffix(String)
     * @see Underline#setPrefixSuffix(String, String)
     * @see Underline#setPrefix(String)
     * @see Underline#getPrefix()
     * @see Underline#Suffix
     * @see Underline#Prefix
     * @since 1.2.0
     */
    public static String getSuffix() {
        return Suffix;
    }

    /**
     * Checks if the underline feature is enabled.
     * <p>
     * Purpose: This method returns the current state of the underline feature (enabled or disabled).<br>
     * When: It is called to check if the underline feature is enabled.<br>
     * Where: Can be invoked from any class or method.<br>
     * Additional Info: This method reflects the current state of the {@link #isUnderlineEnabled} flag.<br>
     * </p>
     *
     * @return {@code true} if the underline feature is enabled, {@code false} otherwise.
     * @author MeAlam
     * @see Underline#isUnderlineEnabled
     * @since 1.2.0
     */
    public static Boolean isUnderlineEnabled() {
        return isUnderlineEnabled;
    }
}

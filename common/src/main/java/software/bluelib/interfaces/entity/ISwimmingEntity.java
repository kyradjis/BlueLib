// Copyright (c) BlueLib. Licensed under the MIT License.
package software.bluelib.interfaces.entity;

/**
 * An interface for swimming entities in the BlueLib library.
 * <p>
 * Purpose: This interface provides some basic methods to manage swimming-related behavior and properties of entities.<br>
 * When: These methods are utilized during interactions, AI logic, or gameplay mechanics involving swimming entities.<br>
 * Where: Implemented by entities that have the ability to swim.<br>
 * Additional Info: The interface supports features like swimming state, speed adjustments, dive cooldown, and depth management.<br>
 * </p>
 * Key Methods:
 * <ul>
 * <li>{@link #getSwimmingState()} - Retrieves the swimming state of the entity.</li>
 * <li>{@link #setSwimmingState(boolean)} - Sets the swimming state of the entity.</li>
 * <li>{@link #getSwimmingSpeedMultiplier()} - Retrieves the speed multiplier while swimming.</li>
 * <li>{@link #setSwimmingSpeedMultiplier(double)} - Sets the speed multiplier while swimming.</li>
 * <li>{@link #getDiveCooldown()} - Retrieves the cooldown period between dives.</li>
 * <li>{@link #setDiveCooldown(int)} - Sets the cooldown period between dives.</li>
 * <li>{@link #getDepth()} - Retrieves the current depth of the entity.</li>
 * <li>{@link #setDepth(int)} - Sets the current depth of the entity.</li>
 * </ul>
 *
 * @author Kyradjis
 * @version 1.7.0
 * @since 1.7.0
 */
@SuppressWarnings("unused")
public interface ISwimmingEntity {

    /**
     * Retrieves the swimming state of the entity.
     * <p>
     * Purpose: Determines whether the entity is currently swimming.<br>
     * When: Called during interactions or AI logic involving swimming behavior.<br>
     * Where: Used in gameplay mechanics for entities in water.<br>
     * </p>
     *
     * @return {@code true} if the entity is swimming; {@code false} otherwise.
     * @author Kyradjis
     * @since 1.7.0
     */
    default boolean getSwimmingState() {
        return false;
    }

    /**
     * Sets the swimming state of the entity.
     * <p>
     * Purpose: Updates the entity's state to indicate whether it is swimming.<br>
     * When: Invoked during gameplay or AI behavior changes.<br>
     * Where: Used in methods managing swimming logic.<br>
     * </p>
     *
     * @param pSwimming {@code true} to set the entity as swimming; {@code false} otherwise.
     * @author Kyradjis
     * @since 1.7.0
     */
    default void setSwimmingState(boolean pSwimming) {}

    /**
     * Retrieves the swimming speed multiplier for the entity.
     * <p>
     * Purpose: Determines the speed multiplier applied when the entity is swimming.<br>
     * When: Called during movement calculations for swimming entities.<br>
     * Where: Used in movement mechanics.<br>
     * </p>
     *
     * @return The swimming speed multiplier as a {@code double}.
     * @author Kyradjis
     * @since 1.7.0
     */
    default double getSwimmingSpeedMultiplier() {
        return 1.0;
    }

    /**
     * Sets the swimming speed multiplier for the entity.
     * <p>
     * Purpose: Updates the speed multiplier applied when the entity is swimming.<br>
     * When: Invoked during gameplay or entity configuration.<br>
     * Where: Used to adjust swimming behavior.<br>
     * </p>
     *
     * @param pSwimmingSpeedMultiplier The swimming speed multiplier as a {@code double}.
     * @author Kyradjis
     * @since 1.7.0
     */
    default void setSwimmingSpeedMultiplier(double pSwimmingSpeedMultiplier) {}

    /**
     * Retrieves the cooldown period between dives for the entity.
     * <p>
     * Purpose: Indicates the amount of time (in seconds) the entity must wait before diving again.<br>
     * When: Called to check or enforce dive cooldown periods.<br>
     * Where: Used in AI or gameplay mechanics involving water interaction.<br>
     * Additional Info: The library does not enforce the cooldown period; it is up to the developer to manage flight cooldowns.<br>
     * </p>
     *
     * @return The dive cooldown period (in seconds) as an {@code int}.
     * @author Kyradjis
     * @since 1.7.0
     */
    default int getDiveCooldown() {
        return 1;
    }

    /**
     * Sets the cooldown period between dives for the entity.
     * <p>
     * Purpose: Updates the amount of time (in seconds) the entity must wait before diving again.<br>
     * When: Invoked during gameplay or AI behavior updates.<br>
     * Where: Used in dive cooldown management logic.<br>
     * Additional Info: The library does not enforce the cooldown period; it is up to the developer to manage flight cooldowns.<br>
     * </p>
     *
     * @param pDiveCooldown The dive cooldown period (in seconds) as an {@code int}.
     * @author Kyradjis
     * @since 1.7.0
     */
    default void setDiveCooldown(int pDiveCooldown) {}

    /**
     * Retrieves the current depth of the entity.
     * <p>
     * Purpose: Indicates how deep the entity is underwater (measured in blocks).<br>
     * When: Called during calculations or checks involving underwater behavior.<br>
     * Where: Used in environmental logic.<br>
     * </p>
     *
     * @return The current depth (in blocks) of the entity as an {@code int}.
     * @author Kyradjis
     * @since 1.7.0
     */
    default int getDepth() {
        return 1;
    }

    /**
     * Sets the current depth of the entity.
     * <p>
     * Purpose: Updates the depth at which the entity is located underwater (measured in blocks).<br>
     * When: Invoked during gameplay or environmental adjustments.<br>
     * Where: Used in AI or movement logic for swimming entities.<br>
     * </p>
     *
     * @param pDepth The current depth (in blocks) of the entity as an {@code int}.
     * @author Kyradjis
     * @since 1.7.0
     */
    default void setDepth(int pDepth) {}
}

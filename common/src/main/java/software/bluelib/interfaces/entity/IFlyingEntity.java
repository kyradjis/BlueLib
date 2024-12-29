// Copyright (c) BlueLib. Licensed under the MIT License.
package software.bluelib.interfaces.entity;

/**
 * An interface for flying entities in the BlueLib library.
 * <p>
 * Purpose: This interface defines some basic methods for managing the behavior, state, and properties of entities capable of flight.<br>
 * When: These methods are invoked during interactions or gameplay mechanics for flying entities.<br>
 * Where: This interface is implemented by entities that are capable of flying.<br>
 * Additional Info: The interface provides default implementations for common flying-related features such as flight state, speed, and altitude.<br>
 * </p>
 * Key Methods:
 * <ul>
 * <li>{@link #getFlyingState()} - Retrieves the flying state of the entity.</li>
 * <li>{@link #setFlyingState(boolean)} - Sets the flying state of the entity.</li>
 * <li>{@link #getFlyingSpeedMultiplier()} - Retrieves the speed multiplier for the entity while flying.</li>
 * <li>{@link #setFlyingSpeedMultiplier(double)} - Sets the speed multiplier for the entity while flying.</li>
 * <li>{@link #canFly()} - Checks if the entity is capable of flight.</li>
 * <li>{@link #getFlightCooldown()} - Retrieves the cooldown period between flights.</li>
 * <li>{@link #setFlightCooldown(int)} - Sets the cooldown period between flights.</li>
 * <li>{@link #getAltitude()} - Retrieves the current altitude of the entity.</li>
 * <li>{@link #setAltitude(int)} - Sets the altitude of the entity.</li>
 * </ul>
 *
 * @author Kyradjis
 * @version 1.7.0
 * @since 1.7.0
 */
public interface IFlyingEntity {

    /**
     * Retrieves the flying state of the entity.
     * <p>
     * Purpose: Indicates whether the entity is currently flying.<br>
     * When: Called to check the entity's current flight status.<br>
     * Where: Used in interaction logic for flying behavior.<br>
     * </p>
     *
     * @return {@code true} if the entity is flying; {@code false} otherwise.
     * @author Kyradjis
     * @since 1.7.0
     * @version 1.7.0
     */
    default boolean getFlyingState() {
        return false;
    }

    /**
     * Sets the flying state of the entity.
     * <p>
     * Purpose: Updates the entity's state to indicate whether it is flying.<br>
     * When: Invoked during gameplay or AI behavior changes.<br>
     * Where: Used in methods controlling flight mechanics.<br>
     * </p>
     *
     * @param pFlying {@code true} to set the entity as flying; {@code false} otherwise.
     * @author Kyradjis
     * @since 1.7.0
     * @version 1.7.0
     */
    default void setFlyingState(boolean pFlying) {
    }

    /**
     * Retrieves the flying speed multiplier for the entity.
     * <p>
     * Purpose: Determines the speed multiplier applied when the entity is flying.<br>
     * When: Called during movement calculations for flying entities.<br>
     * Where: Used in movement logic.<br>
     * </p>
     *
     * @return The flying speed multiplier as a {@code double}.
     * @author Kyradjis
     * @since 1.7.0
     * @version 1.7.0
     */
    default double getFlyingSpeedMultiplier() {
        return 1.0;
    }

    /**
     * Sets the flying speed multiplier for the entity.
     * <p>
     * Purpose: Updates the speed multiplier applied when the entity is flying.<br>
     * When: Invoked during gameplay or entity configuration.<br>
     * Where: Used in methods controlling movement mechanics.<br>
     * </p>
     *
     * @param pFlyingSpeedMultiplier The desirable flying speed multiplier as a {@code double}.
     * @author Kyradjis
     * @since 1.7.0
     * @version 1.7.0
     */
    default void setFlyingSpeedMultiplier(double pFlyingSpeedMultiplier) {
    }

    /**
     * Checks if the entity is capable of flight.
     * <p>
     * Purpose: Determines whether the entity has the ability to fly.<br>
     * When: Called to validate the entity's flight capabilities.<br>
     * Where: Used in AI or interaction logic involving flight.<br>
     * </p>
     *
     * @return {@code true} if the entity can fly; {@code false} otherwise (e.g. when the entity is a baby).
     * @author Kyradjis
     * @since 1.7.0
     * @version 1.7.0
     */
    default boolean canFly() {
        return false;
    }

    /**
     * Retrieves the cooldown period between flights for the entity.
     * <p>
     * Purpose: Indicates the amount of time (in seconds) the entity must wait before flying again.<br>
     * When: Called during flight cooldown checks.<br>
     * Where: Used in gameplay mechanics.<br>
     * </p>
     *
     * @return The flight cooldown period (in seconds) as an {@code int}.
     * @author Kyradjis
     * @since 1.7.0
     * @version 1.7.0
     */
    default int getFlightCooldown() {
        return 1;
    }

    /**
     * Sets the cooldown period between flights for the entity.
     * <p>
     * Purpose: Updates the amount of time (in seconds) the entity must wait before flying again.<br>
     * When: Invoked during gameplay or entity configuration.<br>
     * Where: Used in cooldown management logic.<br>
     * </p>
     *
     * @param pFlightCooldown The flight cooldown period (in seconds) as an {@code int}.
     * @author Kyradjis
     * @since 1.7.0
     * @version 1.7.0
     */
    default void setFlightCooldown(int pFlightCooldown) {
    }

    /**
     * Retrieves the current altitude of the entity.
     * <p>
     * Purpose: Indicates the current height of the entity above the ground (measured in blocks).<br>
     * When: Called during calculations or checks involving altitude.<br>
     * Where: Used in AI and movement logic.<br>
     * </p>
     *
     * @return The current altitude (in blocks) of the entity as an {@code int}.
     * @author Kyradjis
     * @since 1.7.0
     * @version 1.7.0
     */
    default int getAltitude() {
        return 1;
    }

    /**
     * Sets the current altitude of the entity.
     * <p>
     * Purpose: Updates the height of the entity above the ground (measured in blocks).<br>
     * When: Invoked during gameplay or movement adjustments.<br>
     * Where: Used in AI or movement logic for flying entities.<br>
     * </p>
     *
     * @param pAltitude The current altitude (in blocks) of the entity as an {@code int}.
     * @author Kyradjis
     * @since 1.7.0
     * @version 1.7.0
     */
    default void setAltitude(int pAltitude) {
    }
}

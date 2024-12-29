// Copyright (c) BlueLib. Licensed under the MIT License.
package software.bluelib.interfaces.entity;

import net.minecraft.world.entity.OwnableEntity;
import net.minecraft.world.entity.player.Player;
import java.util.UUID;

/**
 * An interface for tamable entities in the BlueLib library.
 * <p>
 * Purpose: This interface defines some basic methods required to manage tamable entities, including taming, ownership, loyalty, and following behavior.<br>
 * When: These methods are invoked during interactions with players or gameplay mechanics for tamable entities.<br>
 * Where: This interface is implemented by entities that support taming and related features.<br>
 * Additional Info: This interface extends {@link OwnableEntity} and provides default implementations for common taming behaviors.<br>
 * </p>
 * Key Methods:
 * <ul>
 * <li>{@link #isTamed()} - Checks if the entity is tamed.</li>
 * <li>{@link #ownedBy(Player)} - Verifies if a specific player owns the entity.</li>
 * <li>{@link #getChangingOwner()} - Retrieves the ownership transfer status.</li>
 * <li>{@link #setChangingOwner(boolean)} - Sets the ownership transfer status.</li>
 * <li>{@link #getTamingFood()} - Gets the type of food required to tame the entity.</li>
 * <li>{@link #setTamingFood(String)} - Sets the type of food required to tame the entity.</li>
 * <li>{@link #getFollowingStatus()} - Checks if the entity is following its owner.</li>
 * <li>{@link #setFollowingStatus(boolean)} - Sets the following status of the entity.</li>
 * <li>{@link #getLoyaltyLevel()} - Retrieves the loyalty level of the entity.</li>
 * <li>{@link #setLoyaltyLevel(int)} - Sets the loyalty level of the entity.</li>
 * </ul>
 *
 * @author Kyradjis
 * @version 1.7.0
 * @since 1.7.0
 * @see OwnableEntity
 * @see Player
 * @see UUID
 */
public interface ITameableEntity extends OwnableEntity {

    /**
     * Checks whether the entity is tamed.
     * <p>
     * Purpose: Determines if the entity has been tamed by a player.<br>
     * When: Called during interactions to verify the entity's taming status.<br>
     * Where: Invoked in gameplay logic related to entity ownership and behavior.<br>
     * </p>
     *
     * @return {@code true} if the entity is tamed; {@code false} otherwise.
     * @since 1.7.0
     * @version 1.7.0
     * @author Kyradjis
     */
    default boolean isTamed() {
        return false;
    }

    /**
     * Checks if a specific player owns this entity.
     * <p>
     * Purpose: Verifies ownership by comparing the player's UUID with the entity's owner UUID.<br>
     * When: Triggered during interactions where ownership affects behavior.<br>
     * Where: Used in methods that require ownership validation.<br>
     * </p>
     *
     * @param pPlayer The player to check ownership for.
     * @return {@code true} if the player owns the entity; {@code false} otherwise.
     * @since 1.7.0
     * @version 1.7.0
     * @author Kyradjis
     * @see Player#getUUID()
     */
    default boolean ownedBy(Player pPlayer) {
        UUID ownerUUID = this.getOwnerUUID();
        return ownerUUID != null && ownerUUID.equals(pPlayer.getUUID());
    }

    /**
     * Gets the ownership transfer status of the entity.
     * <p>
     * Purpose: Indicates whether the entity is allowed to change ownership.<br>
     * When: Called to check the current state of ownership transfer.<br>
     * Where: Used in taming or trade scenarios.<br>
     * </p>
     *
     * @return {@code true} if changing ownership is allowed for the entity; {@code false} otherwise.
     * @since 1.7.0
     * @version 1.7.0
     * @author Kyradjis
     */
    default boolean getChangingOwner() {
        return false;
    }

    /**
     * Sets the ownership transfer status of the entity.
     * <p>
     * Purpose: Updates the entity's state to indicate whether it is allowed to change ownership.<br>
     * When: Invoked during taming or trade operations.<br>
     * Where: Used to control ownership transition logic.<br>
     * </p>
     *
     * @param pChanging {@code true} to indicate ownership can be transferred; {@code false} otherwise.
     * @since 1.7.0
     * @version 1.7.0
     * @author Kyradjis
     */
    default void setChangingOwner(boolean pChanging) {
    }

    /**
     * Gets the type of food required to tame the entity.
     * <p>
     * Purpose: Specifies the food or item needed to tame the entity.<br>
     * When: Called during taming interactions.<br>
     * Where: Used to determine the item required for taming.<br>
     * </p>
     *
     * @return The name of the taming food as a {@link String}.
     * @since 1.7.0
     * @version 1.7.0
     * @author Kyradjis
     */
    default String getTamingFood() {
        return "Wheat";
    }

    /**
     * Sets the type of food required to tame the entity.
     * <p>
     * Purpose: Updates the type of food or item needed for taming.<br>
     * When: Used during configuration or setup.<br>
     * Where: Called to modify taming requirements.<br>
     * </p>
     *
     * @param pTamingFood The name of the taming food as a {@link String}.
     * @since 1.7.0
     * @version 1.7.0
     * @author Kyradjis
     */
    default void setTamingFood(String pTamingFood) {
    }

    /**
     * Checks if the entity is following its owner.
     * <p>
     * Purpose: Determines if the entity should follow its owner.<br>
     * When: Checked during behavior logic.<br>
     * Where: Used in movement-related operations.<br>
     * </p>
     *
     * @return {@code true} if the entity should follow its owner; {@code false} otherwise.
     * @since 1.7.0
     * @version 1.7.0
     * @author Kyradjis
     */
    default boolean getFollowingStatus() {
        return false;
    }

    /**
     * Sets the following status of the entity.
     * <p>
     * Purpose: Updates whether the entity should follow its owner.<br>
     * When: Invoked during interactions or commands.<br>
     * Where: Used in movement behavior for tamable entities.<br>
     * </p>
     *
     * @param pFollowingStatus {@code true} to make the entity follow its owner; {@code false} otherwise.
     * @since 1.7.0
     * @version 1.7.0
     * @author Kyradjis
     */
    default void setFollowingStatus(boolean pFollowingStatus) {
    }

    /**
     * Gets the loyalty level of the entity.
     * <p>
     * Purpose: Retrieves the loyalty level, which determines the entity's level of loyalty to the owner (e.g., decreases if ignored or mistreated)<br>
     * Where: Used in loyalty-based mechanics.<br>
     * </p>
     *
     * @return The loyalty level as an {@code int}.
     * @since 1.7.0
     * @version 1.7.0
     * @author Kyradjis
     */
    default int getLoyaltyLevel() {
        return 1;
    }

    /**
     * Sets the loyalty level of the entity.
     * <p>
     * Purpose: Updates the loyalty level of the entity.<br>
     * When: Called during interactions or state updates.<br>
     * Where: Used to adjust loyalty-based behavior.<br>
     * </p>
     *
     * @param pLevel The loyalty level as an {@code int}.
     * @since 1.7.0
     * @version 1.7.0
     * @author Kyradjis
     */
    default void setLoyaltyLevel(int pLevel) {
    }
}

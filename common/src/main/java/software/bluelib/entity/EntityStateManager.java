// Copyright (c) BlueLib. Licensed under the MIT License.
package software.bluelib.entity;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.world.entity.LivingEntity;

/**
 * Manages the state of entities in the BlueLib library.
 * <p>
 * Purpose: This class provides methods to manage the flying state, flying capabilities, and flight cooldowns of entities.<br>
 * When: These methods are invoked during interactions or gameplay mechanics for entities.<br>
 * Where: This class is used by other classes to manage entity states.<br>
 * Additional Info: The class uses maps to store and retrieve the state information for entities.
 * </p>
 * Key Methods:
 * <ul>
 * <li>{@link #getFlyingState(LivingEntity)} - Retrieves the flying state of the entity.</li>
 * <li>{@link #setFlyingState(LivingEntity, boolean)} - Sets the flying state of the entity.</li>
 * <li>{@link #getCanFly(LivingEntity)} - Checks if the entity is capable of flight.</li>
 * <li>{@link #setCanFly(LivingEntity, boolean)} - Sets whether the entity can fly.</li>
 * <li>{@link #getFlyingCooldown(LivingEntity)} - Retrieves the cooldown period between flights for the entity.</li>
 * <li>{@link #setFlyingCooldown(LivingEntity, int)} - Sets the cooldown period between flights for the entity.</li>
 * </ul>
 *
 * @author MeAlam
 * @version 1.7.0
 * @see software.bluelib.interfaces.entity.IFlyingEntity
 * @see LivingEntity
 * @see Boolean
 * @see HashMap
 * @see Map
 * @see Integer
 * @since 1.7.0
 */
public class EntityStateManager {

    // Flying States

    /**
     * A map to store the flying state of entities.
     * <p>
     * Purpose: This map holds the flying state of entities.<br>
     * When: The map is populated when the {@link #setFlyingState(LivingEntity, boolean)} method is called.<br>
     * Where: The map is used to store the flying state of entities.<br>
     * Additional Info: The keys are the entities and the values are their flying states.
     * </p>
     *
     * @see Map
     * @see HashMap
     * @see LivingEntity
     * @see Boolean
     * @see #setFlyingState(LivingEntity, boolean)
     * @see #getFlyingState(LivingEntity)
     * @see software.bluelib.interfaces.entity.IFlyingEntity
     * @since 1.7.0
     */
    private static final Map<LivingEntity, Boolean> flyingStateMap = new HashMap<>();

    /**
     * Retrieves the flying state of the entity.
     * <p>
     * Purpose: Indicates whether the entity is currently flying.<br>
     * When: Called to check the entity's current flight status.<br>
     * Where: Used in interaction logic for flying behavior.<br>
     * </p>
     *
     * @param pEntity The entity to check the flying state for.
     * @return {@code true} if the entity is flying; {@code false} otherwise.
     * @author MeAlam
     * @see software.bluelib.interfaces.entity.IFlyingEntity
     * @see LivingEntity
     * @see Boolean
     * @see #setFlyingState(LivingEntity, boolean)
     * @see #flyingStateMap
     * @since 1.7.0
     */
    public static boolean getFlyingState(LivingEntity pEntity) {
        return flyingStateMap.getOrDefault(pEntity, false);
    }

    /**
     * Sets the flying state of the entity.
     * <p>
     * Purpose: Updates the entity's state to indicate whether it is flying.<br>
     * When: Invoked during gameplay or AI behavior changes.<br>
     * Where: Used in methods controlling flight mechanics.<br>
     * </p>
     *
     * @param pEntity The entity to set the flying state for.
     * @param pState  {@code true} to set the entity as flying; {@code false} otherwise.
     * @author MeAlam
     * @see software.bluelib.interfaces.entity.IFlyingEntity
     * @see LivingEntity
     * @see Boolean
     * @see #getFlyingState(LivingEntity)
     * @see #flyingStateMap
     * @since 1.7.0
     */
    public static void setFlyingState(LivingEntity pEntity, boolean pState) {
        flyingStateMap.put(pEntity, pState);
    }

    // Flying Speed Multipliers

    /**
     * A map to store the flying capability of entities.
     * <p>
     * Purpose: This map holds the flying capability of entities.<br>
     * When: The map is populated when the {@link #setCanFly(LivingEntity, boolean)} method is called.<br>
     * Where: The map is used to store the flying capability of entities.<br>
     * Additional Info: The keys are the entities and the values are their flying capabilities.
     * </p>
     *
     * @see Map
     * @see HashMap
     * @see LivingEntity
     * @see Boolean
     * @see #setCanFly(LivingEntity, boolean)
     * @see #getCanFly(LivingEntity)
     * @see software.bluelib.interfaces.entity.IFlyingEntity
     * @since 1.7.0
     */
    private static final Map<LivingEntity, Boolean> canFlyMap = new HashMap<>();

    /**
     * Checks if the entity is capable of flight.
     * <p>
     * Purpose: Determines whether the entity has the ability to fly.<br>
     * When: Called to validate the entity's flight capabilities.<br>
     * Where: Used in AI or interaction logic involving flight.<br>
     * </p>
     *
     * @param pEntity The entity to check the flying capability for.
     * @return {@code true} if the entity can fly; {@code false} otherwise.
     * @author MeAlam
     * @see software.bluelib.interfaces.entity.IFlyingEntity
     * @see LivingEntity
     * @see Boolean
     * @see #setCanFly(LivingEntity, boolean)
     * @see #canFlyMap
     * @since 1.7.0
     */
    public static Boolean getCanFly(LivingEntity pEntity) {
        return canFlyMap.getOrDefault(pEntity, true);
    }

    /**
     * Sets whether the entity can fly.
     * <p>
     * Purpose: Updates the entity's ability to fly.<br>
     * When: Invoked during gameplay or entity configuration.<br>
     * Where: Used in methods controlling flight mechanics.<br>
     * </p>
     *
     * @param pEntity The entity to set the flying capability for.
     * @param pCanFly {@code true} to enable flight for the entity; {@code false} otherwise.
     * @author MeAlam
     * @see software.bluelib.interfaces.entity.IFlyingEntity
     * @see LivingEntity
     * @see Boolean
     * @see #getCanFly(LivingEntity)
     * @see #canFlyMap
     * @since 1.7.0
     */
    public static void setCanFly(LivingEntity pEntity, boolean pCanFly) {
        canFlyMap.put(pEntity, pCanFly);
    }

    // Flight Cooldowns

    /**
     * A map to store the flight cooldowns of entities.
     * <p>
     * Purpose: This map holds the flight cooldowns of entities.<br>
     * When: The map is populated when the {@link #setFlyingCooldown(LivingEntity, int)} method is called.<br>
     * Where: The map is used to store the flight cooldowns of entities.<br>
     * Additional Info: The keys are the entities and the values are their flight cooldowns.
     * </p>
     *
     * @see Map
     * @see HashMap
     * @see LivingEntity
     * @see Integer
     * @see #setFlyingCooldown(LivingEntity, int)
     * @see #getFlyingCooldown(LivingEntity)
     * @see software.bluelib.interfaces.entity.IFlyingEntity
     * @since 1.7.0
     */
    private static final Map<LivingEntity, Integer> flyingCooldownMap = new HashMap<>();

    /**
     * Retrieves the cooldown period between flights for the entity.
     * <p>
     * Purpose: Indicates the amount of time (in seconds) the entity must wait before flying again.<br>
     * When: Called during flight cooldown checks. (Up to the Developer)<br>
     * Where: Used in {@link software.bluelib.interfaces.entity.IFlyingEntity}.<br>
     * Additional Info: The library does not enforce the cooldown period; it is up to the developer to manage flight cooldowns.<br>
     * </p>
     *
     * @param pEntity The entity to check the flight cooldown for.
     * @return The flight cooldown period (in seconds) as an {@code int}.
     * @author MeAlam
     * @see software.bluelib.interfaces.entity.IFlyingEntity
     * @see LivingEntity
     * @see #setFlyingCooldown(LivingEntity, int)
     * @see #flyingCooldownMap
     * @since 1.7.0
     */
    public static int getFlyingCooldown(LivingEntity pEntity) {
        return flyingCooldownMap.getOrDefault(pEntity, 1);
    }

    /**
     * Sets the cooldown period between flights for the entity.
     * <p>
     * Purpose: Updates the amount of time (in seconds) the entity must wait before flying again.<br>
     * When: Invoked during gameplay or entity configuration. (Up to the Developer)<br>
     * Where: Used in {@link software.bluelib.interfaces.entity.IFlyingEntity}.<br>
     * Additional Info: The library does not enforce the cooldown period; it is up to the developer to manage flight cooldowns.<br>
     * </p>
     *
     * @param pEntity   The entity to set the flight cooldown for.
     * @param pCooldown The flight cooldown period (in seconds) as an {@code int}.
     * @author MeAlam
     * @see software.bluelib.interfaces.entity.IFlyingEntity
     * @see LivingEntity
     * @see #getFlyingCooldown(LivingEntity)
     * @see #flyingCooldownMap
     * @since 1.7.0
     */
    public static void setFlyingCooldown(LivingEntity pEntity, int pCooldown) {
        flyingCooldownMap.put(pEntity, pCooldown);
    }
}

package com.github.ckblck.armor.hooks.api;

import com.github.ckblck.armor.tracker.calculation.piece.ArmorPiece;
import org.bukkit.entity.Player;

@FunctionalInterface
public interface ArmorEquipListenable {

    /**
     * Called when a player
     * has the equipment modified.
     * <p>
     * Note: A player will not be able to equip/remove more than one armor
     * at the same time in game. Nevertheless, plugins (or wear out!) are capable of doing such a modification.
     * The library contemplates this scenario.
     *
     * @param player    player involved
     * @param wornArmor complete set of player's armour
     */

    void onModification(Player player, ArmorPiece[] wornArmor);

}

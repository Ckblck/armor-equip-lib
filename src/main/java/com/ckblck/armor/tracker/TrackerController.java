package com.ckblck.armor.tracker;

import com.ckblck.armor.Bootstrap;
import com.ckblck.armor.triggers.Dispatcher;
import com.ckblck.armor.utils.ArmorModification;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TrackerController {
    private final Map<UUID, Tracker> trackedPlayers = new HashMap<>();
    private final Dispatcher dispatcher;

    public TrackerController(Bootstrap bootstrap) {
        this.dispatcher = bootstrap.getDispatcher();

        Bukkit.getOnlinePlayers().forEach(this::track); // Reload compatibility.
    }

    /**
     * Start tracking armor changes of
     * a {@link Player}.
     */

    public void track(Player player) {
        trackedPlayers.computeIfAbsent(player.getUniqueId(), player1 -> new Tracker(player1, this));
    }

    /**
     * Stop tracking armor changes of
     * a {@link Player}.
     */

    public void untrack(Player player) {
        trackedPlayers.remove(player.getUniqueId());
    }

    public Tracker getTracker(Player player) {
        return trackedPlayers.get(player.getUniqueId());
    }

    protected void callApi(Player player, ArmorModification modification) {
        dispatcher.dispatch(player, modification);
    }

}

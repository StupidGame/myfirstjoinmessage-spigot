package io.github.matsuo877.myfirstjoinmessage

import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class MyFirstJoinMessage : JavaPlugin(), Listener {
    override fun onEnable() {
        //処理を書く
        server.pluginManager.registerEvents(this, this)
        saveDefaultConfig()
    }

    override fun onDisable() {
        //処理を書く
    }

    @EventHandler
    fun onLoginEvent(event: PlayerJoinEvent) {
        var Login = config.getString("JoinMessage")!!
        Login = Login.replace("%pl%", event.player.name)
        Login = Login.replace("%n%".toRegex(), "\n")
        event.joinMessage = ChatColor.translateAlternateColorCodes('&', Login)
    }

    @EventHandler
    fun onLogoutEvent(event: PlayerQuitEvent) {
        var Logout = config.getString("LogoutMessage")!!
        Logout = Logout.replace("%pl%", event.player.name)
        Logout = Logout.replace("%n%".toRegex(), "\n")
        event.quitMessage = ChatColor.translateAlternateColorCodes('&', Logout)
    }
}
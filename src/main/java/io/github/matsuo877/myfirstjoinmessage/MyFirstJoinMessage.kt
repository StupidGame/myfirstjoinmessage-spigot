package io.github.matsuo877.myfirstjoinmessage

import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent
import org.bukkit.plugin.java.JavaPlugin

class MyFirstJoinMessage : JavaPlugin() , Listener{
    override fun onEnable() {
        server.pluginManager.registerEvents(this , this)
        saveDefaultConfig()
        logger.info("Enabled!")
    }

    override fun onDisable() {
        logger.info("Disabled!")
    }
    @EventHandler
    fun onLoginEvent(event: PlayerJoinEvent){
        var login = config.getString("JoinMessage")!!
        login = login.replace("%pl%" , event.player.name)
        login = login.replace("%n%" , "\n")
        event.joinMessage = ChatColor.translateAlternateColorCodes('&' , login)
    }
    @EventHandler
    fun onLogoutEvent(event: PlayerQuitEvent){
        var logout = config.getString("LogoutMessage")!!
        logout = logout.replace("%pl%" , event.player.name)
        logout = logout.replace("%n%" , "\n")
        event.quitMessage = ChatColor.translateAlternateColorCodes('&' , logout)
    }
}
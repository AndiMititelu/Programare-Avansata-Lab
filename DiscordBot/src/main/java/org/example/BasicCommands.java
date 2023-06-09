package org.example;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BasicCommands extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if(event.getName().equals("hello")) {
            String userTag = event.getUser().getAsTag();
            //System.out.println("Commanda /hello e aici!");
            //event.getChannel().sendMessage("Hello there!").queue();
            event.reply("Hi there! What can I do for you, **" + userTag + "**!").setEphemeral(true).queue();
        }
    }
}

package org.example;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Bot {
    private final Dotenv config;
    public Bot() {
        config = Dotenv.configure().load();
        JDA jda = JDABuilder.createDefault(config.get("TOKEN"))
                .enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MEMBERS, GatewayIntent.DIRECT_MESSAGES)
                .addEventListeners(new BasicCommands(), new UpdateEventCommand(), new AddEventCommand())
                .build();

        //OptionData optionDataAdd = new OptionData(OptionType.STRING, "addsubject", "Add an event with the subject...", true);
        //OptionData optionDataDelete = new OptionData(OptionType.STRING, "updatesubject", "Update the event with the subject...", true);

        jda.upsertCommand("hello", "JavaBOT will say hello!").setGuildOnly(true).queue();
        jda.upsertCommand("event", "Create a new event").setGuildOnly(true).queue();
        jda.upsertCommand("edit", "Modify an existing event").setGuildOnly(true).queue();
        //  jda.upsertCommand("event","An event").addOptions(optionDataAdd).setGuildOnly(true).queue();
        //jda.upsertCommand("event", "An event").addOptions(optionDataDelete).setGuildOnly(true).queue();
        //TODO: more commands soon
    }
    public static void main(String[] args) {
        Bot bot = new Bot();
    }
}
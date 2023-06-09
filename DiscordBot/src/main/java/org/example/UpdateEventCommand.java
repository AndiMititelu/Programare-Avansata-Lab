package org.example;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.PrivateChannel;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

import javax.sound.midi.Soundbank;
import java.awt.*;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class UpdateEventCommand extends ListenerAdapter {
    TimetableRepository timetableRepository = new TimetableRepository();
    Timetable updatedTimetable = new Timetable();

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        String command = event.getName();
        if (command.equals("edit")) {
            //OptionMapping eventOption = event.getOption("updatesubject");
            User user = event.getUser();
            PrivateChannel privateChannel = user.openPrivateChannel().complete();
            String username = user.getName();
            //if(eventOption != null) {
            //String userOption = eventOption.getAsString();
            List<Timetable> timetableList = timetableRepository.findAll();
            String subjectList = "";
            for (Timetable timetable : timetableList) {
                subjectList += timetable.getSubject();
                subjectList += " ";
            }
            //Timetable foundTimetable = timetableRepository.findBySubject(userOption);
            EmbedBuilder embedBuilder = new EmbedBuilder()
                    .setTitle("Enter the event you want to modify")
                    .setColor(Color.YELLOW)
                    .setDescription("Events: \n" + "[" + subjectList + "]\n");
            privateChannel.sendMessageEmbeds(embedBuilder.build()).queue();
            //System.out.println("Before waitForUserInput");
//            String userInput = waitForUserInput(privateChannel);
//            System.out.println("Am asteptat userInput");
//            Timetable foundTimetable = timetableRepository.findBySubject(userInput);
//            System.out.println("Am cautat findBySubject");
//            if(foundTimetable != null) {
//                System.out.println("Am gasit event-ul cu acel subject!");
//            }
//            String subject = foundTimetable.getSubject();
//            System.out.println("Subject = " + subject);
            if (true) {
                Thread thread = new Thread(() -> {
                    //--------------------------------------------------------------------------------------------------------
                    String userInput = waitForUserInput(privateChannel);
                    System.out.println("Am asteptat userInput");
                    Timetable foundTimetable = timetableRepository.findBySubject(userInput);
                    System.out.println("Am cautat findBySubject");
                    if(foundTimetable != null) {
                        System.out.println("Am gasit event-ul cu acel subject!");
                        updatedTimetable = foundTimetable;
                    }
                    String subject = foundTimetable.getSubject();
                    if(subject == null) {
                        privateChannel.sendMessage("No event with that subject!").queue();
                        return;
                    }
                    //------------------------------------------------------------------------------------------------------

                    TextChannel channel = event.getChannel().asTextChannel();
                    String userInput2 = "";
                    //updatedTimetable.setUpdatedBy(username);
                    while (true) {
                        EmbedBuilder embedBuilder1 = new EmbedBuilder()
                                .setTitle("What would you like to do?")
                                .setColor(Color.YELLOW)
                                .setDescription(
                                        "1) Modify the event\n" +
                                                "2) Remove a response\n" +
                                                "3) Add a response");
                        privateChannel.sendMessageEmbeds(embedBuilder1.build()).queue();
                        userInput2 = waitForUserInput(privateChannel);
                        //----------------------- Select what to modify ------------------------
                        if (userInput2.equals("1")) {
                            EmbedBuilder embedBuilder2 = new EmbedBuilder()
                                    .setTitle("What would u like to modify")
                                    .setColor(Color.YELLOW)
                                    .addField("1 - Subject", foundTimetable.getSubject(), true)
                                    .addField("2 - Start Time", foundTimetable.getDay().toString(), true)
                                    .addField("3 - Location", foundTimetable.getLocation(), true)
                                    .addField("4 - Details", foundTimetable.getDetails(), true);
                            privateChannel.sendMessageEmbeds(embedBuilder2.build()).queue();

                            userInput2 = waitForUserInput(privateChannel);
                            if (userInput2.equals("1")) {
                                EmbedBuilder embedBuilder3 = new EmbedBuilder()
                                        .setTitle("Enter the event title")
                                        .setColor(Color.YELLOW)
                                        .setDescription("Up to 200 characters are permitted\n")
                                        .setFooter("To exit, type 'cancel'");
                                privateChannel.sendMessageEmbeds(embedBuilder3.build()).queue();
                                userInput2 = waitForUserInput(privateChannel);
                                if (userInput2 != null)
                                    updatedTimetable.setSubject(userInput2);
                            } else if (userInput2.equals("2")) {
                                EmbedBuilder embedBuilder4 = new EmbedBuilder()
                                        .setTitle("When should the event start?")
                                        .setColor(Color.YELLOW)
                                        .setDescription(
                                                "Now\n" +
                                                        "In 1 hour\n" +
                                                        "dd/MM/yyy hh:mm");
                                privateChannel.sendMessageEmbeds(embedBuilder4.build()).queue();
                                userInput2 = waitForUserInput(privateChannel);
                                if (userInput2.equals("now") || userInput2.equals("Now")) {
                                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                                    LocalDateTime now = LocalDateTime.now();
                                    String formattedDate = dtf.format(now);
                                    updatedTimetable.setDay(now);
                                } else {
                                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                                    //SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                                    LocalDateTime dateTime = LocalDateTime.parse(userInput2, dtf);
                                    if (dateTime != null) {
                                        updatedTimetable.setDay(dateTime);
                                        System.out.println(dateTime);
                                    }

                                }
                            } else if (userInput2.equals("3")) {
                                EmbedBuilder embedBuilder5 = new EmbedBuilder()
                                        .setTitle("Where does the event take place?")
                                        .setColor(Color.YELLOW)
                                        .setDescription("Enter a location");
                                privateChannel.sendMessageEmbeds(embedBuilder5.build()).queue();
                                userInput2 = waitForUserInput(privateChannel);
                                if(userInput2 != null)
                                    updatedTimetable.setLocation(userInput2);
                            } else if (userInput2.equals("4")) {
                                EmbedBuilder embedBuilder3 = new EmbedBuilder()
                                        .setTitle("Any additional details?")
                                        .setColor(Color.YELLOW)
                                        .setDescription("Write anything that could be of interest");
                                privateChannel.sendMessageEmbeds(embedBuilder3.build()).queue();
                            }
                        } //TODO: else-if to remove a response

                        LocalDateTime now = LocalDateTime.now();
                        updatedTimetable.setUpdatedBy(username);
                        updatedTimetable.setUpdatedAt(now);
                        EmbedBuilder eb = new EmbedBuilder()
                                .setTitle("Would you like to keep editing?")
                                .setColor(Color.YELLOW)
                                .setDescription("1 - Nope, I'm done\n" + "2 - Yes, keep editing");
                        privateChannel.sendMessageEmbeds(eb.build()).queue();
                        userInput2 = waitForUserInput(privateChannel);
                        if(userInput2.equals("1")) {
                            break;
                        }
                        else if (userInput2.equals("2")) {
                            continue;
                        }

                        //break;
                    }
                    timetableRepository.update(updatedTimetable);
                    privateChannel.sendMessage("Cool! " + updatedTimetable.getSubject() + " event was successfully updated.").queue();
                    Emoji acceptedEmoji = Emoji.fromUnicode("U+1F44D"); // :accepted: emoji (thumbs up)
                    Emoji declinedEmoji = Emoji.fromUnicode("U+1F44E"); // :declined: emoji (thumbs down)
                    String time = updatedTimetable.getDay().toString();
                    EmbedBuilder embedBuilder4 = new EmbedBuilder()
                            .setTitle(updatedTimetable.getSubject())
                            .setColor(Color.YELLOW)
                            .setDescription("Starting at:\n" +
                                    time + " \n" +
                                    "Location: " + updatedTimetable.getLocation() + " \n" +
                                    "Details: " + updatedTimetable.getDetails()
                            )
                            .setFooter("Updated by: " + updatedTimetable.getUpdatedBy())
                            //.setTimestamp(timetable.getDay())
                            .addField("Accept", acceptedEmoji.getAsReactionCode(), true)
                            .addField("Decline", declinedEmoji.getAsReactionCode(), true);

                    channel.sendMessage("Event updated!").queue();
                    channel.sendMessageEmbeds(embedBuilder4.build()).queue(message -> {
                        message.addReaction(acceptedEmoji).queue();
                        message.addReaction(declinedEmoji).queue();
                    });
                });
                thread.start();
            } else {
                privateChannel.sendMessage("No event with this subject was found").queue();
            }

        }
    }

    private String waitForUserInput(MessageChannel textChannel) {
        //Holds the user's response
        CompletableFuture<String> userInputFuture = new CompletableFuture<>();

        ListenerAdapter listenerAdapter = new ListenerAdapter() {
            @Override
            public void onMessageReceived(@NotNull MessageReceivedEvent event) {
                if (event.getChannel().equals(textChannel) && event.getAuthor().equals(event.getJDA().getSelfUser())) {
                    //ignore messages from the bot itself
                    return;
                }
                String userInput = event.getMessage().getContentRaw();

                userInputFuture.complete(userInput);

                event.getJDA().removeEventListener(this);

            }
        };
        textChannel.getJDA().addEventListener(listenerAdapter);

        try {
            // Wait for the user's response
            return userInputFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            // Handle any exceptions that may occur
            e.printStackTrace();
            return null; // Or throw an exception, depending on your error handling approach
        }
    }
}

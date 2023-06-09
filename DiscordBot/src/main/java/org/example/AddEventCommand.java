package org.example;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.entities.channel.concrete.PrivateChannel;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class AddEventCommand extends ListenerAdapter {
    TimetableRepository timetableRepository = new TimetableRepository();
    Timetable timetable = new Timetable();
    private InputStream eventImage;
    private String imageFileName = "";
    private EventScheduler eventScheduler = new EventScheduler();
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        String command = event.getName();
        System.out.println("Command: " + command);
        if(command.equals("event")) {

                //event.deferReply().queue(); // Acknowledge the command to prevent timeout
                User user = event.getUser();
                String username = user.getName();
                System.out.println("Username: " + username);

                Thread thread = new Thread(() -> {
                    PrivateChannel privateChannel = user.openPrivateChannel().complete();
                    TextChannel channel = event.getChannel().asTextChannel();
                    System.out.println("Channel is: " + channel);
                    //Map<Date, String> timetable = new HashMap<>();
                    timetable.setUsername(username);
                    while(true) {
                        String userInput;

                        Date userDate;
                        //---------------------------- Enter the subject -----------------------------
                        EmbedBuilder embedBuilder = new EmbedBuilder()
                                .setTitle("Enter the event title")
                                .setColor(Color.YELLOW)
                                .setDescription("Up to 200 characters are permitted\n")
                                .setFooter("To exit, type 'cancel'");
                        privateChannel.sendMessageEmbeds(embedBuilder.build()).queue();
                        userInput = waitForUserInput(privateChannel);
                        if(userInput != null) {
                            timetable.setSubject(userInput);
                        }

                        //--------------------------- Enter the image ------------------------------
//                        System.out.println("Asteptam imaginea!!!");
//                        EmbedBuilder embedBuilder4 = new EmbedBuilder()
//                                .setTitle("Attach an image to the event(optional)")
//                                .setColor(Color.YELLOW)
//                                .setDescription("Please upload an image for the event or write 'none'");
//                        privateChannel.sendMessageEmbeds(embedBuilder4.build()).queue();
//                        CompletableFuture<String> imageFileNameFuture = waitForUserImage(privateChannel);
//                        System.out.println("Am terminat waitForUserImage()!");

                        //---------------------------- Enter the date --------------------------------
                        EmbedBuilder embedBuilder1 = new EmbedBuilder()
                                .setTitle("When should the event start?")
                                .setColor(Color.YELLOW)
                                .setDescription(
                                        "Now\n" +
                                        "In 1 hour\n" +
                                        "dd/MM/yyy 17:00");
                        privateChannel.sendMessageEmbeds(embedBuilder1.build()).queue();
                        userInput = waitForUserInput(privateChannel);
                        if(userInput.equals("now") || userInput.equals("Now")) {
                            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                            LocalDateTime now = LocalDateTime.now();
                            String formattedDate = dtf.format(now);
                            try {
                                userDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(formattedDate);
                                timetable.setDay(now);
                            } catch (ParseException e) {
                                throw new RuntimeException(e);
                            }

                        }
                        else {
                            try {
                                userDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(userInput);
                                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                                LocalDateTime dateTime = LocalDateTime.parse(userInput);
                                if(dateTime != null)
                                    timetable.setDay(dateTime);
                            } catch (ParseException e) {
                                throw new RuntimeException(e);
                            }
                        }

                        //--------------------------- Enter the location ------------------------------
                        //privateChannel.sendMessage("Please enter a location for your event").queue();
                        EmbedBuilder embedBuilder2 = new EmbedBuilder()
                                .setTitle("Where does the event take place?")
                                .setColor(Color.YELLOW)
                                .setDescription("Enter a location");

                        privateChannel.sendMessageEmbeds(embedBuilder2.build()).queue();
                        userInput = waitForUserInput(privateChannel);
                        if(userInput != null) {
                            timetable.setLocation(userInput);
                        }

                        //TODO: attach images


                        //--------------------------- Enter the details ---------------------------
                        EmbedBuilder embedBuilder3 = new EmbedBuilder()
                                .setTitle("Any additional details?")
                                .setColor(Color.YELLOW)
                                .setDescription("Write anything that could be of interest");

                        privateChannel.sendMessageEmbeds(embedBuilder3.build()).queue();
                        userInput = waitForUserInput(privateChannel);
                        if(userInput != null) {
                            timetable.setDetails(userInput);
                        }

                        //--------------------------- Set created_at ------------------------
                        LocalDateTime now = LocalDateTime.now();
                        timetable.setCreatedAt(now);
                        timetable.setUpdatedAt(now);
                        timetable.setUpdatedBy(username);
                        break; //TODO: ??


                    }

                    timetableRepository.create(timetable);
                    privateChannel.sendMessage("Cool! " + timetable.getSubject() +  " event was successfully added to the timetable.").queue();
                    Emoji acceptedEmoji = Emoji.fromUnicode("U+1F44D"); // :accepted: emoji (thumbs up)
                    Emoji declinedEmoji = Emoji.fromUnicode("U+1F44E"); // :declined: emoji (thumbs down)
                    String time = timetable.getDay().toString();
                    System.out.println("Image file name is: " + imageFileName);
                    EmbedBuilder embedBuilder4 = new EmbedBuilder()
                            .setTitle(timetable.getSubject())
                            .setColor(Color.YELLOW)
                            .setDescription("Time\n" +
                                            time
                            )
                            //.setImage(imageFileName)
                            //.setTimestamp(timetable.getDay())
                            .addField("Accept", acceptedEmoji.getAsReactionCode(), true)
                            .addField("Decline", declinedEmoji.getAsReactionCode(), true);

                    channel.sendMessageEmbeds(embedBuilder4.build()).queue(message -> {
                        //message.addFile(eventImage, imageFileName);
                        message.addReaction(acceptedEmoji).queue();
                        message.addReaction(declinedEmoji).queue();
                    });

                    //--------------------------- Notification freq -------------------------
                    LocalTime localTime = LocalTime.now();
                    eventScheduler.scheduleEventNotification(channel, embedBuilder4, localTime, 1);
                    //eventScheduler.stopScheduler();

                });
                thread.start();
        }
    }

    private String waitForUserInput(MessageChannel textChannel) {
        //Holds the user's response
        CompletableFuture<String> userInputFuture = new CompletableFuture<>();

        ListenerAdapter listenerAdapter = new ListenerAdapter() {
            @Override
            public void onMessageReceived(@NotNull MessageReceivedEvent event) {
                if(event.getChannel().equals(textChannel) && event.getAuthor().equals(event.getJDA().getSelfUser())) {
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
    private boolean hasRequiredRole(Member member, String role) {
        // Replace "ROLE_NAME" with the actual name of the role you want to check
        Role requiredRole = member.getGuild().getRolesByName(role, true).stream().findFirst().orElse(null);

        if (requiredRole != null) {
            return member.getRoles().contains(requiredRole);
        }

        return false;
    }

    private CompletableFuture<String> waitForUserImage(PrivateChannel privateChannel) {
        CompletableFuture<String> imageFileNameFuture = new CompletableFuture<>();
        //System.out.println("Helloooooooooooooooooooo");
        ListenerAdapter listenerAdapter = new ListenerAdapter() {
            @Override
            public void onMessageReceived(@NotNull MessageReceivedEvent event) {
                System.out.println("onMessageReceived!!!");
                if (event.getChannel().equals(privateChannel) && event.getAuthor().equals(event.getJDA().getSelfUser())) {
                    // Ignore messages from the bot itself
                    return;
                }
                System.out.println("Suntem in listener adapterrrr");

                String userInput = event.getMessage().getContentRaw();
                if (userInput.equals("none")) {
                    imageFileNameFuture.complete(null); // No image provided
                } else if (!event.getMessage().getAttachments().isEmpty()) {
                    Message.Attachment attachment = event.getMessage().getAttachments().get(0);
                    if (attachment.isImage()) {
                        attachment.retrieveInputStream().thenAccept(inputStream -> {
                            eventImage = inputStream; // Store the image input stream in the field
                            imageFileName = saveImageToDisk();
                            System.out.println("Image fileName in waitForUserImage method is: " + imageFileName);
                            imageFileNameFuture.complete(imageFileName);
                        });
                    }
                }

                event.getJDA().removeEventListener(this);
            }
        };

        privateChannel.getJDA().addEventListener(listenerAdapter);

        return imageFileNameFuture;
    }

    private String saveImageToDisk() {
        String fileName = generateUniqueFileName(); // Generate a unique file name for the image
        String filePath = "C:/Users/andim/OneDrive/Documente/AN 2/JAVA/BOTupdated/src/main/resources/Images" + fileName;
        System.out.println(filePath);
        try (OutputStream outputStream = new FileOutputStream(filePath)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = eventImage.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return fileName;
    }

    private String generateUniqueFileName() {
        String timestamp = Long.toString(System.currentTimeMillis());
        String random = Integer.toString(new Random().nextInt(10000));
        return timestamp + "_" + random + ".jpg"; // Change the extension according to the image format
    }
}

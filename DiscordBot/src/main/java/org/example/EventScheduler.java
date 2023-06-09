package org.example;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class EventScheduler {
    private ScheduledExecutorService scheduler;
    public EventScheduler() {
        scheduler = Executors.newScheduledThreadPool(1);
    }

    public void scheduleEventNotification(TextChannel channel, EmbedBuilder eventEmbed, LocalTime notificationTime, int frequencyDays) {
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime initialNotificationTime = getInitialNotificationTime(currentTime, notificationTime);

        long initialDelay = ChronoUnit.SECONDS.between(currentTime, initialNotificationTime);
        long interval = calculateInterval(frequencyDays);
        System.out.println("Notificare la: " + interval);
        Runnable task = () -> {
            // Send the embed message to the channel
            channel.sendMessageEmbeds(eventEmbed.build()).queue();
        };
        scheduler.scheduleAtFixedRate(task, initialDelay, interval, TimeUnit.SECONDS);
    }

    private LocalDateTime getInitialNotificationTime(LocalDateTime currentTime, LocalTime notificationTime) {
        LocalDateTime todayNotificationTime = LocalDateTime.of(currentTime.toLocalDate(), notificationTime);

        if (todayNotificationTime.isAfter(currentTime)) {
            return todayNotificationTime;
        } else {
            // Add a day to the current time to ensure the next notification time is in the future
            return todayNotificationTime.plusDays(1);
        }
    }

    private long calculateInterval(int frequencyDays) {
        // Calculate the interval based on the frequency in days
        //return TimeUnit.DAYS.toSeconds(frequencyDays);
        return TimeUnit.SECONDS.toSeconds(60); //TODO: change!!
    }
    public void stopScheduler() {
        scheduler.shutdown();
    }

}

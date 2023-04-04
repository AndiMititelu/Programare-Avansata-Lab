package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        var explore = new Exploration(5, 2);
        explore.addRobot(new Robot("Optimus Prime"));
        explore.addRobot(new Robot("Chat GPT"));
        explore.start();

        Thread.sleep(1000);
        System.out.println("exploration done");
        System.out.println(explore.getMap());

    }
}
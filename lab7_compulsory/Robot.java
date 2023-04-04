package org.example;

import java.util.Random;

public class Robot implements Runnable {
    private final String name;
    private boolean running;
    private Exploration explore;
    private final Random random;

    public Robot(String name) {
        this.name = name;
        running = true;
        random = new Random();
    }
    public void setExplore(Exploration explore) {
        this.explore = explore;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        while (running) {
            int row = random.nextInt(5);
            int col = random.nextInt(5);
            boolean success = explore.getMap().visit(row, col, this);
            if(!success)
                running = false;
            else
                running = true;

            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {}
        }
    }
}

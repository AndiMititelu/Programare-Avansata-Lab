package org.example;

import java.util.ArrayList;
import java.util.List;

public class Exploration {
    //private final SharedMemory mem;
    private final ExplorationMap map;
    private final List<Robot> robots;

    public Exploration(int n, int numRobots) {
      //  mem = new SharedMemory(n * n);
        map = new ExplorationMap(n);
        robots = new ArrayList<>(numRobots);
    }

    public void addRobot(Robot robot) {
        robots.add(robot);
        robot.setExplore(this);
    }

    public void start() {
        for (Robot robot : robots) {
            new Thread(robot).start();
        }
    }

    public ExplorationMap getMap() {
        return map;
    }
}

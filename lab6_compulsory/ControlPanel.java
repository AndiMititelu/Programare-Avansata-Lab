package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    JButton exitBtn = new JButton("Exit");
    JButton resetBtn = new JButton("Reset");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        // change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));

        // add all buttons
        add(loadBtn);
        add(saveBtn);
        add(resetBtn);
        add(exitBtn);


        // configure listeners for all buttons
        loadBtn.addActionListener(this::loadGame);
        saveBtn.addActionListener(this::saveGame);
        saveBtn.addActionListener(this::resetGame);
        exitBtn.addActionListener(this::exitGame);
    }

    private void loadGame(ActionEvent e) {
        // TODO: implement load game functionality
    }

    private void saveGame(ActionEvent e) {
        // TODO: implement save game functionality
    }
    private void resetGame(ActionEvent e) {
        // TODO: implement reset game functionality
    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }
}

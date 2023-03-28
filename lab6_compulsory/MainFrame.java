package org.example;
import javax.swing.*;

import java.awt.*;

import static javax.swing.SwingConstants.CENTER;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        configPanel = new ConfigPanel(this);
        add(configPanel, BorderLayout.NORTH); // Add the panel to the top part of the frame

        // Create the canvas (drawing panel)
        canvas = new DrawingPanel(this);
        add(canvas, BorderLayout.CENTER); // Add the panel to the center part of the frame

        // Create the control panel
        controlPanel = new ControlPanel(this);
        add(controlPanel, BorderLayout.SOUTH); // Add the panel to the bottom part of the frame

        //invoke the layout manager
        pack();
    }
}

package org.example;

import javax.swing.*;
import java.awt.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox<Double> linesCombo;
    JButton createButton;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //create the label and the spinner
        dotsLabel = new JLabel("Number of dots:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));

        //create the label and the combo box for the lines
        linesLabel = new JLabel("Line probability:");
        linesCombo = new JComboBox<>(new Double[]{1.0, 0.5, 0.1});

        //create the button
        createButton = new JButton("Create");
        createButton.addActionListener(e -> {
            int dots = (Integer) dotsSpinner.getValue();
            double lineProbability = (Double) linesCombo.getSelectedItem();

            DrawingPanel drawingPanel = new DrawingPanel(frame);
            drawingPanel.setNumVertices(dots);
            drawingPanel.setEdgeProbability(lineProbability);

            frame.add(drawingPanel, BorderLayout.CENTER);
            frame.setVisible(true);
        });

        add(dotsLabel); //JPanel uses FlowLayout by default
        add(dotsSpinner);
        add(linesLabel);
        add(linesCombo);
        add(createButton);
    }
}

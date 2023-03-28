package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    private int numVertices;
    private double edgeProbability;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        initPanel();
    }

    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
    }

    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    public void setEdgeProbability(double edgeProbability) {
        this.edgeProbability = edgeProbability;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Compute the coordinates of the dots
        int dotSize = 10;
        int margin = dotSize;
        int width = getWidth() - 2 * margin;
        int height = getHeight() - 2 * margin;
        int x0 = margin;
        int y0 = margin;
        int x1 = margin + width;
        int y1 = margin + height;
        int cx = (x0 + x1) / 2;
        int cy = (y0 + y1) / 2;
        int r = Math.min(width, height) / 2 - dotSize;
        int[] x = new int[numVertices];
        int[] y = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            double angle = 2 * Math.PI * i / numVertices;
            x[i] = (int) (cx + r * Math.cos(angle));
            y[i] = (int) (cy + r * Math.sin(angle));
        }

        // Draw the dots
        g.setColor(Color.BLACK);
        for (int i = 0; i < numVertices; i++) {
            g.fillOval(x[i] - dotSize / 2, y[i] - dotSize / 2, dotSize, dotSize);
        }

        // Draw the lines
        Random random = new Random();
        for (int i = 0; i < numVertices; i++) {
            for (int j = i + 1; j < numVertices; j++) {
                if (random.nextDouble() < edgeProbability) {
                    g.drawLine(x[i], y[i], x[j], y[j]);
                }
            }
        }
    }
}

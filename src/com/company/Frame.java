package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import static com.company.Main;

class Event extends MouseAdapter {

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        JLbl lbl = (JLbl) mouseEvent.getSource();
        if(lbl.isChecked) {
            lbl.isChecked = false;
            lbl.setBackground(Frame.unchecked);
        }
        else {
            lbl.isChecked = true;
            lbl.setBackground(Frame.checked);
        }
    }

}
class JLbl extends JLabel {
    boolean isChecked;
}
public class Frame extends JFrame {
    public static JLbl[][] label;
    JButton startButton, stopButton, nextButton;
    final static Color unchecked = Color.LIGHT_GRAY, checked = Color.RED;
    public Frame() {
        label = new JLbl[Main.WIDTH][Main.HEIGHT];
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setSize(1200, 640);
        Main.isStop = true;
        for (int i = 0; i < Main.WIDTH; i++) {
            for (int j = 0; j < Main.HEIGHT; j++) {
                label[i][j] = new JLbl();
                label[i][j].isChecked = false;
                label[i][j].setSize(Main.CELL_SIZE, Main.CELL_SIZE);
                label[i][j].setLocation(i * Main.CELL_SIZE + 5, j * Main.CELL_SIZE + 5);
                label[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                label[i][j].setBackground(unchecked);
                label[i][j].setOpaque(true);
                label[i][j].addMouseListener(new Event());
                add(label[i][j]);
            }
        }

        startButton = new JButton("START");
        startButton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        startButton.setBounds(Main.WIDTH * Main.CELL_SIZE + 15, 5, 120, 40);
        startButton.setFocusPainted(false);
        startButton.addActionListener(e -> {Main.isStop = false;});
        add(startButton);

        stopButton = new JButton("STOP");
        stopButton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        stopButton.setBounds(Main.WIDTH * Main.CELL_SIZE + 15, 50, 120, 40);
        stopButton.setFocusPainted(false);
        stopButton.addActionListener(e -> {Main.isStop = true;});
        add(stopButton);

        nextButton = new JButton("NEXT");
        nextButton.setFocusPainted(false);
        nextButton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        nextButton.setBounds(Main.WIDTH * Main.CELL_SIZE + 15, 95, 120, 40);
        nextButton.addActionListener(e -> {Main.repaint();});
        add(nextButton);

        setVisible(true);
    }
}

package com.company;

import java.awt.*;

public class Main {
    public static final int HEIGHT = 40, WIDTH = 70, CELL_SIZE = 15;
    public static boolean isStop = false;
    public static void main(String[] args) {
        new Frame();
        repaint();
        while (true) {
            System.out.close();
            if (!isStop) {
                repaint();
                try {
                    Thread.sleep(400);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void repaint() {
        boolean[][] lbl = new boolean[Main.WIDTH][Main.HEIGHT];
        for (int i = 0; i < Main.WIDTH; i++) {
            for (int j = 0; j < Main.HEIGHT; j++) {
                int cnt = 0;
                if (i > 0 && j > 0 && Frame.label[i - 1][j - 1].isChecked)
                    cnt++;
                if (i > 0 && Frame.label[i - 1][j].isChecked)
                    cnt++;
                if (j < Main.HEIGHT - 1 && i > 0 && Frame.label[i - 1][j + 1].isChecked)
                    cnt++;
                if (j > 0 && Frame.label[i][j - 1].isChecked)
                    cnt++;
                if (j < Main.HEIGHT - 1 && Frame.label[i][j + 1].isChecked)
                    cnt++;
                if (i < Main.WIDTH - 1 && j > 0 && Frame.label[i + 1][j - 1].isChecked)
                    cnt++;
                if (i < Main.WIDTH - 1 && Frame.label[i + 1][j].isChecked)
                    cnt++;
                if (i < Main.WIDTH - 1 && j < Main.HEIGHT - 1 && Frame.label[i + 1][j + 1].isChecked)
                    cnt++;
                lbl[i][j] = Frame.label[i][j].isChecked;
                if (lbl[i][j] && (cnt < 2 || cnt > 3))
                    lbl[i][j] = false;
                else if (!lbl[i][j] && cnt == 3)
                    lbl[i][j] = true;
            }
        }
        for (int i = 0; i < Main.WIDTH; i++) {
            for (int j = 0; j < Main.HEIGHT; j++) {
                Frame.label[i][j].isChecked = lbl[i][j];
                if (lbl[i][j]) {
                    Frame.label[i][j].setBackground(Frame.checked);
                } else {
                    Frame.label[i][j].setBackground(Frame.unchecked);
                }
            }
        }
    }
}

package Lesson_1;

import javax.swing.*;
import java.awt.*;

public class MainCanvas extends JPanel {

    MainWindow gameController;
    long lastFrame;
    private int count = 0;
    private boolean checkCount = true;



    MainCanvas(MainWindow gameController) {
        this.gameController = gameController;
        lastFrame = System.nanoTime();
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrame) * 0.000000001f;
        gameController.onDrawFrame(this, g, deltaTime);
        lastFrame = currentTime;
        Background bg = new Background(this);
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        repaint();
    }


    public int getLeft() { return 0; }

    public int getRight() { return getWidth() - 1; }

    public int getTop() { return 0; }

    public int getBottom() { return getHeight() - 1; }

    public int getCount() {
        return count;
    }

    public boolean isCheckCount() {
        return checkCount;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setCheckCount(boolean checkCount) {
        this.checkCount = checkCount;
    }
}

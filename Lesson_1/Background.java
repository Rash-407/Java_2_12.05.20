package Lesson_1;

import java.awt.*;

public class Background {

    public Background(MainCanvas mc) {

        if (mc.isCheckCount()) {
            mc.setCount(mc.getCount()+1);
        } else {
            mc.setCount(mc.getCount()-1);
        }
        if (mc.getCount() == 255) {
            mc.setCheckCount(false);
        }
        if (mc.getCount() == 0){
            mc.setCheckCount(true);
        }

        Color color = new Color (mc.getCount(),mc.getCount(),mc.getCount());
        mc.setBackground(color);

    }
}

package io.github.confuser2188.launcherpac.misc;

import java.awt.*;

public class Calc {

    public static boolean isInBounds(int x, int y, int width, int height, Point mousePos){
        double mouseX = mousePos.getX();
        double mouseY = mousePos.getY();

        return mouseX > x && mouseX < x + width && mouseY > y && mouseY < y + height;
    }
}

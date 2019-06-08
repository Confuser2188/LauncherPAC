package io.github.confuser2188.launcherpac.design.component;

import io.github.confuser2188.launcherpac.design.frame.MainMenu;

import java.awt.*;

public abstract class Component implements IComponent {

    private int x;
    private int y;
    private Color color;
    private int[] tabIndex;

    public Component(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Component(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean canDraw(){
        if(this.getTabIndex() != null)
            for(int i : this.tabIndex)
                if(MainMenu.tabIndex == i)
                    return true;
        return this.getTabIndex() == null || this.getTabIndex()[0] == 0;
    }

    public void setTabIndex(int... tabIndex) {
        this.tabIndex = tabIndex;
    }

    public int[] getTabIndex() {
        return tabIndex;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }
}

package io.github.confuser2188.launcherpac.design.component;

import java.awt.*;

public abstract class Component implements IComponent {

    private String name;
    private int x;
    private int y;
    private Color color;

    public Component(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Component(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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

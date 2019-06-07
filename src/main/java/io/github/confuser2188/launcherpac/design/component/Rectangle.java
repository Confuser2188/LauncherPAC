package io.github.confuser2188.launcherpac.design.component;

import java.awt.*;

public class Rectangle extends Component {

    private int width, height;

    public Rectangle(int x, int y, int width, int height, Color color) {
        super(x, y, color);

        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics graphics) {
        if(!this.canDraw()) return;

        graphics.setColor(this.getColor());
        graphics.drawRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

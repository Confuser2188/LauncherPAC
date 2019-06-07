package io.github.confuser2188.launcherpac.design.component;

import io.github.confuser2188.launcherpac.design.frame.MainMenu;

import java.awt.*;

public class FilledRectangle extends Component {

    private int width, height;

    public FilledRectangle(int x, int y, int width, int height, Color color) {
        super(x, y, color);

        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics graphics) {
        if(!this.canDraw()) return;

        graphics.setColor(this.getColor());
        graphics.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

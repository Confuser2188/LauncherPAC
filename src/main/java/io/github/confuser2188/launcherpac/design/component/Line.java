package io.github.confuser2188.launcherpac.design.component;

import java.awt.*;

public class Line extends Component {

    private int targetX, targetY;

    public Line(int x, int y, int targetX, int targetY, Color color) {
        super(x, y, color);

        this.targetX = targetX;
        this.targetY = targetY;
    }

    @Override
    public void draw(Graphics graphics) {
        if(!this.canDraw()) return;

        graphics.setColor(this.getColor());
        graphics.drawLine(this.getX(), this.getY(), this.targetX, this.targetY);
    }
}

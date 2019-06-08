package io.github.confuser2188.launcherpac.design.component;

import io.github.confuser2188.launcherpac.misc.Calc;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class Slider extends Component implements ISlider {

    private transient int SLIDER_WIDTH = 10, SLIDER_HEIGHT = 25;
    private int length, value, maxValue;

    public Slider(int x, int y, int length, int value, int maxValue, Color color) {
        super(x, y, color);

        this.length = length;
        this.value = value;
        this.maxValue = maxValue;
    }

    @Override
    public void draw(Graphics graphics) {
        if(!this.canDraw()) return;

        // Back
        graphics.setColor(new Color(80, 80, 80, 255));
        graphics.fillRect(this.getX(), this.getY(), length, 5);

        // Progress
        double addX = this.value * ((double)this.length / (double)this.maxValue) - 5;
        graphics.setColor(new Color(130, 255, 130));
        graphics.fillRect(this.getX(), this.getY(), this.length - (int) (length - addX), 5);

        // Outline
        graphics.setColor(Color.BLACK);
        graphics.drawRect(this.getX(), this.getY(), length, 5);

        // Slider
        graphics.setColor(Color.WHITE);
        graphics.fillRect((int) (this.getX() + addX), this.getY() - SLIDER_HEIGHT / 4, SLIDER_WIDTH, SLIDER_HEIGHT);
        graphics.setColor(Color.BLACK);
        graphics.drawRect((int) (this.getX() + addX), this.getY() - SLIDER_HEIGHT / 4, SLIDER_WIDTH, SLIDER_HEIGHT);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(!this.canDraw()) return;

        if(Calc.isInBounds(this.getX(), this.getY() - SLIDER_HEIGHT / 4, this.length, this.SLIDER_HEIGHT, e.getPoint())) {
            this.value = (int) ((e.getX() - this.length) / ((double)this.length / (double)this.maxValue));
            this.valueChanged(this.value);
        }
    }
}

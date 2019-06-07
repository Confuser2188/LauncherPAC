package io.github.confuser2188.launcherpac.design.component;

import io.github.confuser2188.launcherpac.design.frame.MainMenu;
import io.github.confuser2188.launcherpac.misc.Calc;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class Button extends Component implements IMouseEvents {

    private boolean enabled = true, isInBounds;
    private Color drawColor;
    private int width, height, alpha;

    public Button(int x, int y, int width, int height, Color color) {
        super(x, y, color);

        this.drawColor = color;

        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics graphics) {
        if(!this.canDraw()) return;

        if(isInBounds) addAlpha(5);
        else subAlpha(5);

        drawColor = new Color(drawColor.getRed(), drawColor.getGreen(), drawColor.getBlue(), alpha);
        graphics.setColor(drawColor);
        graphics.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        if(Calc.isInBounds(this.getX(), this.getY(), this.getWidth(), this.getHeight(), event.getPoint()))
            this.click();
    }

    @Override
    public boolean mouseMoved(MouseEvent event) {
        isInBounds = Calc.isInBounds(this.getX(), this.getY(), this.getWidth(), this.getHeight(), event.getPoint());

        if(isInBounds)
            MainMenu.menu.setCursor(new Cursor(Cursor.HAND_CURSOR));

        return isInBounds;
    }

    @Override
    public void mouseExit(MouseEvent event) {
        isInBounds = false;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private void addAlpha(int i){
        alpha += i;
        if(alpha > 255)
            alpha = 255;
    }

    private void subAlpha(int i){
        alpha -= i;
        if(alpha < this.getColor().getAlpha())
            alpha = this.getColor().getAlpha();
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }
}

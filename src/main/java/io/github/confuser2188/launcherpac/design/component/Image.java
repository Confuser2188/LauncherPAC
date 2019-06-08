package io.github.confuser2188.launcherpac.design.component;

import java.awt.*;

public class Image extends Component {

    private java.awt.Image image;
    private int width, height;

    public Image(java.awt.Image image, int x, int y) {
        super(x, y);

        this.image = image;
    }

    public Image(java.awt.Image image, int x, int y, int width, int height) {
        super(x, y);

        this.image = image;
        this.width = width;
        this.height = height;
    }

    public void setImg(java.awt.Image img){
        this.image=img;
    }

    @Override
    public void draw(Graphics graphics) {
        if(width == 0 && height == 0) graphics.drawImage(this.image, this.getX(), this.getY(), null);
        else graphics.drawImage(this.image, this.getX(), this.getY(), this.getWidth(), this.getHeight(), null);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

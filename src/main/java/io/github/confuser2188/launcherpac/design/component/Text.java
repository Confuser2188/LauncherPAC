package io.github.confuser2188.launcherpac.design.component;

import io.github.confuser2188.launcherpac.misc.StringObject;

import java.awt.*;

public class Text extends Component {

    private Font font;
    private String text, prefix = "", suffix = "";
    private StringObject string;
    private boolean centered, mirror;

    public Text(String text, int x, int y, Color color) {
        super(x, y, color);

        this.font = new Font(Font.SERIF, Font.PLAIN, 12);
        this.text = text;
    }

    public Text(StringObject string, int x, int y, Color color) {
        super(x, y, color);

        this.string = string;
        this.font = new Font(Font.SERIF, Font.PLAIN, 12);
    }

    public Text(String text, int x, int y, Font font, Color color) {
        super(x, y, color);

        this.text = text;
        this.font = font;
    }

    public Text(StringObject string, int x, int y, Font font, Color color) {
        super(x, y, color);

        this.string = string;
        this.font = font;
    }

    @Override
    public void draw(Graphics graphics) {
        if(!this.canDraw()) return;

        if(this.font != null)
            graphics.setFont(this.font);
        graphics.setColor(this.getColor());

        if(this.centered) {
            if(string != null) graphics.drawString(this.prefix + this.string.getString() + this.suffix, this.getX() - graphics.getFontMetrics().stringWidth(this.string.getString()) / 2, this.getY());
            else graphics.drawString(this.prefix + this.getText() + this.suffix, this.getX() - graphics.getFontMetrics().stringWidth(this.getText()) / 2, this.getY());
        }else if(this.mirror){
            if(string != null) graphics.drawString(this.prefix + this.string.getString() + this.suffix, this.getX() - graphics.getFontMetrics().stringWidth(this.string.getString()), this.getY());
            else graphics.drawString(this.prefix + this.getText() + this.suffix, this.getX() - graphics.getFontMetrics().stringWidth(this.getText()), this.getY());
        }else{
            if(string != null) graphics.drawString(this.prefix + this.string.getString() + this.suffix, this.getX(), this.getY());
            else graphics.drawString(this.prefix + this.getText() + this.suffix, this.getX(), this.getY());
        }
    }

    public void setCentered(boolean centered) {
        this.centered = centered;
    }

    public void setMirror(boolean mirror) {
        this.mirror = mirror;
    }

    public Font getFont() {
        return font;
    }

    public String getText() {
        return text;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}

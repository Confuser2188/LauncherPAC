package io.github.confuser2188.launcherpac.design.component;

import io.github.confuser2188.launcherpac.misc.StringUtils;

import java.awt.*;
import java.awt.event.KeyEvent;

public class TextBox extends Component implements IKeyboardEvent {

    protected String text;
    private int length, maxCharacters;
    private transient int TEXTBOX_HEIGHT = 20;

    public TextBox(String text, int x, int y, int length, int maxCharacters) {
        super(x, y);

        this.text = text;
        this.length = length;
        this.maxCharacters = maxCharacters;
    }

    @Override
    public void draw(Graphics graphics) {
        if(!this.canDraw()) return;

        graphics.setColor(Color.WHITE);
        graphics.fillRect(this.getX(), this.getY(), length, TEXTBOX_HEIGHT);
        graphics.setColor(new Color(255, 70, 0));
        graphics.drawRect(this.getX(), this.getY(), length, TEXTBOX_HEIGHT);

        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font("Arial", Font.PLAIN, 16));
        graphics.drawString(this.text, this.getX() + 5, this.getY() + TEXTBOX_HEIGHT / 2 + 5);
    }

    @Override
    public void dispatchKeyEvent(KeyEvent e) {
        if(!this.canDraw() || e.getID() != KeyEvent.KEY_PRESSED) return;

        if(e.getKeyCode() == 8)
            if(!this.text.isEmpty()){
                this.text = this.text.substring(0, this.text.length() - 1);
                return;
            }

        if(!StringUtils.isValidUsername(this.text + e.getKeyChar()) || this.text.length() + 1 > this.maxCharacters)
            return;

        this.text += e.getKeyChar();
    }
}

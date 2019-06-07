package io.github.confuser2188.launcherpac.misc;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public enum CustomFont {

    AGENCY_FB("AgencyFB");

    private String fontName;
    CustomFont(String fontName){
        this.fontName = fontName;
    }

    public Font getFont(float size) {
        try {
            InputStream is = this.getClass().getResourceAsStream("/assets/fonts/" + this.fontName + ".ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            return font.deriveFont(size);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            throw new NullPointerException("Cannot find " + this.fontName + ".ttf");
        }
    }
}

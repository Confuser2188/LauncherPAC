package io.github.confuser2188.launcherpac.design.tab;

import io.github.confuser2188.launcherpac.design.component.Button;
import io.github.confuser2188.launcherpac.design.component.Line;
import io.github.confuser2188.launcherpac.design.component.Rectangle;
import io.github.confuser2188.launcherpac.design.component.Text;
import io.github.confuser2188.launcherpac.design.frame.MainMenu;
import io.github.confuser2188.launcherpac.language.langAPI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class LanguageSettings extends Tab {

    public LanguageSettings() {
        super(4);
    }

    @Override
    public void load() {
        add(new Text("Language / Dil", 350, 225, new Font("Arial", Font.PLAIN, 16), Color.WHITE));
        add(new Line(350, 240, 700, 240, Color.GRAY));
        add(new Text(MainMenu.selectedLang, 350, 270, new Font("Arial", Font.PLAIN, 16), Color.WHITE));
        add(new Button(350, 285, 100, 40, new Color(255, 72, 0, 100)) {
            private String LANG = "TR";
            @Override
            public void draw(Graphics graphics) {
                if(MainMenu.selectedLangShort.getString().equalsIgnoreCase(this.LANG))
                    this.setAlpha(255);
                super.draw(graphics);
            }

            @Override
            public void click() {
                langAPI.changeLang("tr");
            }
        });
        add(new Rectangle(350, 285, 100, 40, Color.WHITE));
        add(new Button(450, 285, 100, 40, new Color(255, 72, 0, 100)) {
            private String LANG = "EN";
            @Override
            public void draw(Graphics graphics) {
                if(MainMenu.selectedLangShort.getString().equalsIgnoreCase(this.LANG))
                    this.setAlpha(255);
                super.draw(graphics);
            }

            @Override
            public void click() {
                langAPI.changeLang("en");
            }
        });
        add(new Rectangle(450, 285, 100, 40, Color.WHITE));

        // Texts over change language buttons
        add(new Text("Türkçe", 375, 310, new Font("Arial", Font.PLAIN, 16), Color.WHITE));
        add(new Text("English", 475, 310, new Font("Arial", Font.PLAIN, 16), Color.WHITE));
    }
}

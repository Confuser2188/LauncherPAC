package io.github.confuser2188.launcherpac.design.tab;

import io.github.confuser2188.launcherpac.design.component.Button;
import io.github.confuser2188.launcherpac.design.component.Line;
import io.github.confuser2188.launcherpac.design.component.Rectangle;
import io.github.confuser2188.launcherpac.design.component.Text;
import io.github.confuser2188.launcherpac.settings.SettingsManager;
import io.github.confuser2188.launcherpac.settings.language.Language;
import io.github.confuser2188.launcherpac.settings.language.list.English;
import io.github.confuser2188.launcherpac.settings.language.list.Turkish;

import javax.swing.*;
import java.awt.*;

public class LanguageSettings extends Tab {

    public LanguageSettings() {
        super(4);
    }

    @Override
    public void load() {
        add(new Text("Language / Dil", 350, 225, new Font("Arial", Font.PLAIN, 16), Color.WHITE));
        add(new Line(350, 240, 700, 240, Color.GRAY));
        add(new Text(Language.selected.getValue("selectedLanguage") + " " + Language.selected.getLanguageName(), 350, 270, new Font("Arial", Font.PLAIN, 16), Color.WHITE));
        add(new Button(350, 285, 100, 40, new Color(255, 72, 0, 100)) {
            @Override
            public void draw(Graphics graphics) {
                if(SettingsManager.getProperties().getProperty("language").equals("tr"))
                    this.setAlpha(255);
                super.draw(graphics);
            }

            @Override
            public void click() {
                SettingsManager.setProperty("language", "tr");
                new Thread(() -> JOptionPane.showMessageDialog(null, "You must restart PAC launcher for the changes to take effect", "PAC", JOptionPane.INFORMATION_MESSAGE)).start();
            }
        });
        add(new Rectangle(350, 285, 100, 40, Color.WHITE));
        add(new Button(450, 285, 100, 40, new Color(255, 72, 0, 100)) {
            @Override
            public void draw(Graphics graphics) {
                if(SettingsManager.getProperties().getProperty("language").equals("en"))
                    this.setAlpha(255);
                super.draw(graphics);
            }

            @Override
            public void click() {
                SettingsManager.setProperty("language", "en");
                new Thread(() -> JOptionPane.showMessageDialog(null, "You must restart PAC launcher for the changes to take effect", "PAC", JOptionPane.INFORMATION_MESSAGE)).start();
            }
        });
        add(new Rectangle(450, 285, 100, 40, Color.WHITE));

        // Texts over change language buttons
        add(new Text("Türkçe", 375, 310, new Font("Arial", Font.PLAIN, 16), Color.WHITE));
        add(new Text("English", 475, 310, new Font("Arial", Font.PLAIN, 16), Color.WHITE));
    }
}

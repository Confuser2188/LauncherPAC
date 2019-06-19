package io.github.confuser2188.launcherpac.design.tab;

import io.github.confuser2188.launcherpac.design.component.Button;
import io.github.confuser2188.launcherpac.design.component.Rectangle;
import io.github.confuser2188.launcherpac.design.component.*;
import io.github.confuser2188.launcherpac.design.frame.MainMenu;
import io.github.confuser2188.launcherpac.misc.SystemInfo;
import io.github.confuser2188.launcherpac.settings.SettingsManager;
import io.github.confuser2188.launcherpac.settings.language.Language;

import java.awt.*;

public class LauncherSettings extends Tab {

    public LauncherSettings() {
        super(3);
    }

    @Override
    public void load() {
        add(new Text(Language.selected.getValue("launcherTab_javaSettings"), 350, 150, new Font("Arial", Font.PLAIN, 16), Color.WHITE));
        add(new Line(350, 165, 700, 165, Color.GRAY));
        add(new Text("RAM", 350, 210, new Font("Arial", Font.PLAIN, 12), Color.WHITE));

        Text ramValueText = new Text(MainMenu.ramValueString, 700, 210, new Font("Arial", Font.PLAIN, 12), Color.WHITE); ramValueText.setTabIndex(2); ramValueText.setMirror(true);
        add(ramValueText);
        add(new Slider(350, 220, 350, 10, (int)(Double.parseDouble(SystemInfo.getMaxRAM().replace(",", ".")) * 10), Color.WHITE) {
            @Override
            public void valueChanged(double newValue) {
                // TODO: fix this
                /*MainMenu.ramValueString.setString(newValue / 10 + "/" + SystemInfo.getMaxRAM() + " GB");
                settingsAPI.setVal("ram", (int)newValue + "");*/
            }
        });

        add(new Text(Language.selected.getValue("launcherTab_version"), 350, 300, new Font("Arial", Font.PLAIN, 16), Color.WHITE));
        add(new Line(350, 315, 700, 315, Color.GRAY));
        Text selectedMCVersion = new Text(MainMenu.mcVersion, 350, 345, new Font("Arial", Font.PLAIN, 16), Color.WHITE); selectedMCVersion.setPrefix(Language.selected.getValue("launcherTab_selectedVersion") + " ");
        add(selectedMCVersion);

        add(new Button(350, 360, 100, 40, new Color(255, 72, 0, 100)) {
            private String VERSION = "1.8.9";
            @Override
            public void draw(Graphics graphics) {
                if(MainMenu.mcVersion.getString().equals(this.VERSION))
                    this.setAlpha(255);
                super.draw(graphics);
            }

            @Override
            public void click() {
                SettingsManager.setProperty("mcVersion", this.VERSION);
                MainMenu.mcVersion.setString(this.VERSION);
            }
        });
        add(new Rectangle(350, 360, 100, 40, Color.WHITE));

        add(new Button(450, 360, 100, 40, new Color(255, 72, 0, 100)) {
            private String VERSION = "1.12.2";
            @Override
            public void draw(Graphics graphics) {
                if(MainMenu.mcVersion.getString().equals(this.VERSION))
                    this.setAlpha(255);
                super.draw(graphics);
            }

            @Override
            public void click() {
                SettingsManager.setProperty("mcVersion", this.VERSION);
                MainMenu.mcVersion.setString(this.VERSION);
            }
        });
        add(new Rectangle(450, 360, 100, 40, Color.WHITE));

        add(new Button(550, 360, 100, 40, new Color(255, 72, 0, 100)) {
            private String VERSION = "1.13.2";
            @Override
            public void draw(Graphics graphics) {
                if(MainMenu.mcVersion.getString().equals(this.VERSION))
                    this.setAlpha(255);
                super.draw(graphics);
            }

            @Override
            public void click() {
                SettingsManager.setProperty("mcVersion", this.VERSION);
                MainMenu.mcVersion.setString(this.VERSION);
            }
        });
        add(new Rectangle(550, 360, 100, 40, Color.WHITE));

        add(new Text("1.8.9", 375, 387, new Font("Arial", Font.PLAIN, 20), Color.WHITE));
        add(new Text("1.12.2", 472, 387, new Font("Arial", Font.PLAIN, 20), Color.WHITE));
        add(new Text("1.13.2", 572, 387, new Font("Arial", Font.PLAIN, 20), Color.WHITE));
    }
}

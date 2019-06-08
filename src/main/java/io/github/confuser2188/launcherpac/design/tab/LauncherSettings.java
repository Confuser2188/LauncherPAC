package io.github.confuser2188.launcherpac.design.tab;

import io.github.confuser2188.launcherpac.design.component.*;
import io.github.confuser2188.launcherpac.design.frame.MainMenu;
import io.github.confuser2188.launcherpac.fileBaseSettings.settingsAPI;
import io.github.confuser2188.launcherpac.language.langAPI;
import io.github.confuser2188.launcherpac.misc.SystemInfo;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;

public class LauncherSettings extends Tab {

    public LauncherSettings() {
        super(3);
    }

    @Override
    public void load() {
        add(new Text(MainMenu.langJavaSettings, 350, 150, new Font("Arial", Font.PLAIN, 16), Color.WHITE));
        add(new Line(350, 165, 700, 165, Color.GRAY));
        add(new Text("RAM", 350, 210, new Font("Arial", Font.PLAIN, 12), Color.WHITE));

        Text ramValueText = new Text(MainMenu.ramValueString, 700, 210, new Font("Arial", Font.PLAIN, 12), Color.WHITE); ramValueText.setTabIndex(2); ramValueText.setMirror(true);
        add(ramValueText);
        add(new Slider(350, 220, 350, settingsAPI.getIntVal("ram"), (int)(Double.parseDouble(SystemInfo.getMaxRAM().replace(",", ".")) * 10), Color.WHITE) {
            @Override
            public void valueChanged(double newValue) {
                MainMenu.ramValueString.setString(newValue / 10 + "/" + SystemInfo.getMaxRAM() + " GB");
                settingsAPI.setVal("ram", (int)newValue + "");
            }
        });

        add(new Text(MainMenu.langVersion, 350, 300, new Font("Arial", Font.PLAIN, 16), Color.WHITE));
        add(new Line(350, 315, 700, 315, Color.GRAY));
        add(new Text(MainMenu.selectedMCVersion, 350, 345, new Font("Arial", Font.PLAIN, 16), Color.WHITE));
        add(new Button(350, 360, 100, 40, new Color(255, 72, 0, 100)) {
            private String VERSION = "1.8.9";
            @Override
            public void draw(Graphics graphics) {
                if(MainMenu.selectedMCVersion.getString().endsWith(this.VERSION))
                    this.setAlpha(255);
                super.draw(graphics);
            }

            @Override
            public void click() {
                MainMenu.mcVersion.setString(this.VERSION);
                MainMenu.selectedMCVersion.setString(langAPI.usingLang.selectedMinecraftVersion + this.VERSION);
                settingsAPI.setVal("selectedMCVersion", this.VERSION);
            }
        });
        add(new Rectangle(350, 360, 100, 40, Color.WHITE));
        add(new Button(450, 360, 100, 40, new Color(255, 72, 0, 100)) {
            private String VERSION = "1.12.2";
            @Override
            public void draw(Graphics graphics) {
                if(MainMenu.selectedMCVersion.getString().endsWith(this.VERSION))
                    this.setAlpha(255);
                super.draw(graphics);
            }

            @Override
            public void click() {
                MainMenu.mcVersion.setString(this.VERSION);
                MainMenu.selectedMCVersion.setString(langAPI.usingLang.selectedMinecraftVersion + this.VERSION);
                settingsAPI.setVal("selectedMCVersion", this.VERSION);
            }
        });
        add(new Rectangle(450, 360, 100, 40, Color.WHITE));
        add(new Button(550, 360, 100, 40, new Color(255, 72, 0, 100)) {
            private String VERSION = "1.13.2";
            @Override
            public void draw(Graphics graphics) {
                if(MainMenu.selectedMCVersion.getString().endsWith(this.VERSION))
                    this.setAlpha(255);
                super.draw(graphics);
            }

            @Override
            public void click() {
                MainMenu.mcVersion.setString(this.VERSION);
                MainMenu.selectedMCVersion.setString(langAPI.usingLang.selectedMinecraftVersion + this.VERSION);
                settingsAPI.setVal("selectedMCVersion", this.VERSION);
            }
        });
        add(new Rectangle(550, 360, 100, 40, Color.WHITE));

        add(new Text("1.8.9", 375, 387, new Font("Arial", Font.PLAIN, 20), Color.WHITE));
        add(new Text("1.12.2", 472, 387, new Font("Arial", Font.PLAIN, 20), Color.WHITE));
        add(new Text("1.13.2", 572, 387, new Font("Arial", Font.PLAIN, 20), Color.WHITE));
    }
}

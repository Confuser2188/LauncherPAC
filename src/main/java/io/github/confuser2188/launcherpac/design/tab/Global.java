package io.github.confuser2188.launcherpac.design.tab;

import io.github.confuser2188.launcherpac.Main;
import io.github.confuser2188.launcherpac.design.component.*;
import io.github.confuser2188.launcherpac.design.frame.MainMenu;
import io.github.confuser2188.launcherpac.game.MinecraftBuilder;
import io.github.confuser2188.launcherpac.misc.CustomImage;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;

public class Global extends Tab {

    public Global() {
        super(0);
    }

    @Override
    public void load() {
        // Background
        add(new Image(CustomImage.WALLPAPER.getImage(), 0, 0, 0, 0));

        // Top
        add(new FilledRectangle(0, 0, 1000, 30, new Color(15, 15, 15, 255)));
        add(new Button(5, 5, 20, 20, new Color(15, 15, 15, 255)) {
            @Override
            public void click() {
                MainMenu.tabIndex = (MainMenu.tabIndex == 1) ? 3 : 1;
            }
        });
        add(new Image(CustomImage.COG.getImage(), 5, 5, 20, 20));
        add(new Button(940, 5, 20, 20, new Color(15, 15, 15, 255)) {
            @Override
            public void click() {
                MainMenu.menu.setState(Frame.ICONIFIED);
            }
        });
        add(new Image(CustomImage.MINIMIZE.getImage(), 940, 5, 20, 20));
        add(new Button(970, 5, 20, 20, new Color(15, 15, 15, 255)) {
            @Override
            public void click() {
                System.exit(0);
            }
        });
        add(new Image(CustomImage.CLOSE.getImage(), 970, 5, 20, 20));

        // Bottom
        add(new FilledRectangle(0, 532, 1000, 68, new Color(255, 72, 0, 150)));
        add(new Button(381, 532, 237, 381, new Color(21, 21, 21, 150)) {
            @Override
            public void click() {
                MainMenu.tabIndex = 1;

                this.setEnabled(false);
                drawQueue.add(new Rectangle(282, 441, 435, 63, new Color(240, 90, 35)));
                drawQueue.add(new Rectangle(281, 440, 437, 65, new Color(240, 90, 35)));
                drawQueue.add(new FilledRectangle(283, 442, 434, 62, new Color(0, 0, 0, 200)));
                drawQueue.add(new Text(MainMenu.status, 300, 475, new Font("Arial", Font.PLAIN, 14), Color.WHITE));

                MinecraftBuilder.launch(MainMenu.mcVersion.getString(), MainMenu.USERNAME);
            }
        });
        Text playText = new Text(MainMenu.langPlayButton, 500, 570, new Font("Arial", Font.BOLD, 35), Color.WHITE); playText.setCentered(true);
        add(playText);
        Text mcVersionText = new Text(MainMenu.mcVersion, 500, 590, new Font("Arial", Font.PLAIN, 16), Color.WHITE); mcVersionText.setCentered(true);
        add(mcVersionText);

        Text version = new Text(Main.VERSION, 998, 595, new Font("Arial", Font.PLAIN, 12), Color.WHITE);
        version.setMirror(true);
        add(version);

        //add(new FilledRectangle(8, 538, 54, 54, new Color(0, 0, 0, 255)));
        add(new Image(CustomImage.getImageFromURL(MainMenu.USERNAME), 10, 540, 50, 50));
        add(new Text(MainMenu.USERNAME, 70, 570, new Font("Arial", Font.PLAIN, 16), Color.WHITE));
    }
}

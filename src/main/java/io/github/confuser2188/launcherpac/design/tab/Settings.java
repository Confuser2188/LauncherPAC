package io.github.confuser2188.launcherpac.design.tab;

import io.github.confuser2188.launcherpac.design.component.Button;
import io.github.confuser2188.launcherpac.design.component.FilledRectangle;
import io.github.confuser2188.launcherpac.design.component.Rectangle;
import io.github.confuser2188.launcherpac.design.component.Text;
import io.github.confuser2188.launcherpac.design.frame.MainMenu;

import java.awt.*;

public class Settings extends Tab {

    public Settings() {
        super(2, 3, 4);
    }

    @Override
    public void load() {
       add(new FilledRectangle(150, 100, 700, 370, new Color(0, 0, 0, 200)));
       add(new Rectangle(150, 100, 700, 370, Color.WHITE));
       add(new Text(MainMenu.langSettings, 170, 130, new Font("Arial", Font.BOLD, 21), Color.WHITE));

       add(new Text(MainMenu.langAccount, 180, 190, new Font("Arial", Font.PLAIN, 14), Color.GRAY));
       add(new Text("Launcher", 180, 220, new Font("Arial", Font.PLAIN, 14), Color.WHITE));
       add(new Text("Language / Dil", 180, 250, new Font("Arial", Font.PLAIN, 14), Color.WHITE));

       // LauncherSettings button
       add(new Button(180, 205, 95, 20, new Color(0, 0, 0, 0)) {
            @Override
            public void click() {
                MainMenu.tabIndex = 3;
            }

           @Override
           public void draw(Graphics graphics) { }
       });

        // LanguageSettings button
        add(new Button(180, 235, 95, 20, new Color(0, 0, 0, 0)) {
            @Override
            public void click() {
                MainMenu.tabIndex = 4;
            }

            @Override
            public void draw(Graphics graphics) { }
        });
    }
}

package io.github.confuser2188.launcherpac.design.tab;

import io.github.confuser2188.launcherpac.design.component.Line;
import io.github.confuser2188.launcherpac.design.component.Rectangle;
import io.github.confuser2188.launcherpac.design.component.Button;
import io.github.confuser2188.launcherpac.design.component.Text;
import io.github.confuser2188.launcherpac.design.component.TextBox;
import io.github.confuser2188.launcherpac.design.frame.MainMenu;
import io.github.confuser2188.launcherpac.misc.CustomImage;

import java.awt.*;
import java.awt.event.KeyEvent;

public class AccountSettings extends Tab {

    public AccountSettings() {
        super(5);
    }

    public static TextBox userNameInput;

    @Override
    public void load() {
        add(new Text(MainMenu.langAccount, 350, 225, new Font("Arial", Font.PLAIN, 16), Color.WHITE));
        add(new Line(350, 240, 700, 240, Color.GRAY));

        add(new Text(MainMenu.langUserName, 350, 285, new Font("Arial", Font.PLAIN, 16), Color.WHITE));
        userNameInput = new TextBox(MainMenu.USERNAME, 450, 270, 150, 16){
            @Override
            public void dispatchKeyEvent(KeyEvent e) {
                super.dispatchKeyEvent(e);
                MainMenu.USERNAME = this.text;
            }
        };

        add(userNameInput);

        /*add(new Button(430, 360, 120, 40, new Color(255, 72, 0, 100)) {
            @Override
            public void click() {
                MainMenu.tabIndex = 1;
                MainMenu.userNameStringObject.setString(MainMenu.USERNAME);
                Global.bustImage.setImage(CustomImage.getImageFromURL(MainMenu.USERNAME));
            }
        });


        add(new Rectangle(430, 360, 120, 40, Color.WHITE));
        add(new Text(MainMenu.langLoginButton, 466, 387, new Font("Arial", Font.PLAIN, 20), Color.WHITE));*/
    }
}

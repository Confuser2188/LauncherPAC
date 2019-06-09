package io.github.confuser2188.launcherpac.design.tab;

import io.github.confuser2188.launcherpac.design.component.*;
import io.github.confuser2188.launcherpac.design.component.Button;
import io.github.confuser2188.launcherpac.design.component.Rectangle;
import io.github.confuser2188.launcherpac.design.frame.MainMenu;
import io.github.confuser2188.launcherpac.language.langAPI;
import io.github.confuser2188.launcherpac.misc.CustomImage;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Login extends Tab {

    public Login() {
        super(6);
    }

    @Override
        public void load() {
            add(new FilledRectangle(150, 150, 700, 290, new Color(0, 0, 0, 200)));
            add(new Rectangle(150, 150, 700, 290, Color.WHITE));

            add(new Text(MainMenu.langLoginButton, 250, 225, new Font("Arial", Font.PLAIN, 16), Color.WHITE));
            add(new Line(250, 240, 750, 240, Color.GRAY));

            add(new Text(MainMenu.langUserName, 363, 285, new Font("Arial", Font.PLAIN, 16), Color.WHITE));
            add(new TextBox(MainMenu.USERNAME, 463, 270, 150, 16){
                @Override
                public void dispatchKeyEvent(KeyEvent e) {
                    super.dispatchKeyEvent(e);
                    MainMenu.USERNAME = this.text;
                }
            });

            add(new Button(405, 350, 170, 40, new Color(255, 72, 0, 150)) {
                @Override
                public void click() {
                    Global.bustImage.setImage(CustomImage.getImageFromURL(MainMenu.USERNAME));
                    MainMenu.userNameStringObject.setString(MainMenu.USERNAME);
                    MainMenu.tabIndex = 1;
                    AccountSettings.userNameInput.setText(MainMenu.USERNAME);
                }
            });
            add(new Rectangle(405, 350, 170, 40, Color.WHITE));
            add(new Text(langAPI.usingLang.loginButton, 466, 377, new Font("Arial", Font.PLAIN, 20), Color.WHITE));
    }
}

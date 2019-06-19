package io.github.confuser2188.launcherpac.design.tab;

import io.github.confuser2188.launcherpac.design.component.*;
import io.github.confuser2188.launcherpac.design.component.Button;
import io.github.confuser2188.launcherpac.design.component.Rectangle;
import io.github.confuser2188.launcherpac.design.frame.MainMenu;
import io.github.confuser2188.launcherpac.misc.CustomImage;
import io.github.confuser2188.launcherpac.settings.language.Language;

import java.awt.*;

public class Login extends Tab {

    public Login() {
        super(6);
    }

    @Override
        public void load() {
            add(new FilledRectangle(150, 150, 700, 290, new Color(0, 0, 0, 200)));
            add(new Rectangle(150, 150, 700, 290, Color.WHITE));

            add(new Text(Language.selected.getValue("loginTab"), 250, 225, new Font("Arial", Font.PLAIN, 16), Color.WHITE));
            add(new Line(250, 240, 750, 240, Color.GRAY));

            add(new Text(Language.selected.getValue("accountTab_username"), 363, 285, new Font("Arial", Font.PLAIN, 16), Color.WHITE));
            TextBox userNameTextBox = new TextBox(MainMenu.USERNAME.getString(), 463, 270, 150, 16);
            add(userNameTextBox);

            add(new Button(405, 350, 170, 40, new Color(255, 72, 0, 150)) {
                @Override
                public void click() {
                    MainMenu.tabIndex = 1;

                    MainMenu.USERNAME.setString(userNameTextBox.getText());
                    Global.bustImage.setImage(CustomImage.getImageFromURL(MainMenu.USERNAME.getString()));
                    AccountSettings.userNameInput.setText(MainMenu.USERNAME.getString());
                }
            });
            add(new Rectangle(405, 350, 170, 40, Color.WHITE));
            add(new Text(Language.selected.getValue("loginTab"), 466, 377, new Font("Arial", Font.PLAIN, 20), Color.WHITE));
    }
}

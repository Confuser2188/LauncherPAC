package io.github.confuser2188.launcherpac.design.tab;

import io.github.confuser2188.launcherpac.design.component.Line;
import io.github.confuser2188.launcherpac.design.component.Text;
import io.github.confuser2188.launcherpac.design.component.TextBox;
import io.github.confuser2188.launcherpac.design.frame.MainMenu;
import io.github.confuser2188.launcherpac.settings.language.Language;

import java.awt.*;

public class AccountSettings extends Tab {

    public AccountSettings() {
        super(5);
    }

    public static TextBox userNameInput;

    @Override
    public void load() {
        add(new Text(Language.selected.getValue("accountTab"), 350, 225, new Font("Arial", Font.PLAIN, 16), Color.WHITE));
        add(new Line(350, 240, 700, 240, Color.GRAY));

        add(new Text(Language.selected.getValue("accountTab_username"), 350, 285, new Font("Arial", Font.PLAIN, 16), Color.WHITE));
        userNameInput = new TextBox(MainMenu.USERNAME.getString(), 450, 270, 150, 16);
        add(userNameInput);
    }
}

package io.github.confuser2188.launcherpac.design.tab;

import io.github.confuser2188.launcherpac.design.component.FilledRectangle;
import io.github.confuser2188.launcherpac.design.component.Text;
import io.github.confuser2188.launcherpac.misc.CustomFont;

import java.awt.*;

public class MainTab extends Tab {

    public MainTab() {
        super(1);
    }

    @Override
    public void load() {
        add(new FilledRectangle(406, 191, 186, 59, new Color(255, 72, 0, 255)));
        add(new FilledRectangle(381, 260, 236, 59, new Color(25, 25, 25, 255)));
        add(new Text("PHOENIX", 430, 239, CustomFont.AGENCY_FB.getFont(52F), Color.WHITE));
        add(new Text("ANTI-CHEAT", 408, 310, CustomFont.AGENCY_FB.getFont(52F), Color.WHITE));
    }
}

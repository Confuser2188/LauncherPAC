package io.github.confuser2188.launcherpac.design.component;

import java.awt.event.MouseEvent;

public interface IButton {

    void mouseClicked(MouseEvent event);
    boolean mouseMoved(MouseEvent event);
    void mouseExit(MouseEvent event);
    void click();

}

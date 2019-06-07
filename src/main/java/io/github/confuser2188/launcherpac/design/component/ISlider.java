package io.github.confuser2188.launcherpac.design.component;

import java.awt.event.MouseEvent;

public interface ISlider {

    void valueChanged(double newValue);
    void mouseDragged(MouseEvent e);

}

package io.github.confuser2188.launcherpac.misc;

import io.github.confuser2188.launcherpac.design.component.Component;

import java.util.ArrayList;

public class ComponentArrayList extends ArrayList<Component> {
    
    public void add(Component comp, int tabIndex){
        comp.setTabIndex(tabIndex);
        this.add(comp);
    }
}

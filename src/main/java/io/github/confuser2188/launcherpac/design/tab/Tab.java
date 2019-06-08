package io.github.confuser2188.launcherpac.design.tab;

import io.github.confuser2188.launcherpac.design.component.Component;
import io.github.confuser2188.launcherpac.misc.ComponentArrayList;

import java.util.ArrayList;

public abstract class Tab implements ITab {

    public ComponentArrayList components = new ComponentArrayList();
    public ArrayList<Component> drawQueue = new ArrayList<>();
    private int[] tabIndex;

    public Tab(int... tabIndex){
        this.tabIndex = tabIndex;
    }

    void add(Component comp){
        components.add(comp, this.tabIndex);
    }

    public int[] getTabIndex() {
        return tabIndex;
    }
}

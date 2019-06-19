package io.github.confuser2188.launcherpac;

import io.github.confuser2188.launcherpac.design.frame.MainMenu;
import io.github.confuser2188.launcherpac.settings.SettingsManager;
import io.github.confuser2188.launcherpac.settings.language.Language;
import io.github.confuser2188.launcherpac.settings.language.list.English;
import io.github.confuser2188.launcherpac.settings.language.list.Turkish;

import javax.swing.*;
import java.util.Properties;


public class Main {

    public static final transient String VERSION = "1.0.0-dev";

    public static void main(String[] args){
        Properties prop = SettingsManager.setup();
        if(prop == null) throw new NullPointerException("Failed to setup properties");

        if(!System.getProperty("os.name").toLowerCase().contains("windows")){
            JOptionPane.showMessageDialog(null, "PAC only runs on Windows OS", "PAC", JOptionPane.ERROR_MESSAGE);
            return;
        }

        switch (prop.getProperty("language")){
            case "en":
                new English().load();
                break;
            case "tr":
                new Turkish().load();
                break;
            default:
                throw new NullPointerException("Unknown language");
        }

        new MainMenu(prop.getProperty("username"));
    }
}

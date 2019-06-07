package io.github.confuser2188.launcherpac;

import io.github.confuser2188.launcherpac.design.frame.Login;

import javax.swing.*;

public class Main {

    public static final transient String VERSION = "1.0.0-dev";

    public static void main(String[] args){
        if(!System.getProperty("os.name").toLowerCase().contains("windows")){
            JOptionPane.showMessageDialog(null, "PAC only runs on Windows OS", "PAC", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        new Login();
    }
}

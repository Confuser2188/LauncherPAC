package io.github.confuser2188.launcherpac.language;

public class en extends mainLang {


    public static mainLang getLang(){
        en x = new en();
        x.langName="English";
        x.playButton="PLAY";
        x.username="Username:";
        x.loginButton="Login";
        x.settings="Settings";
        x.Account="Account";
        x.javaSettings="Java Settings";
        x.version="Version";
        x.selectedMinecraftVersion="Selected Minecraft version: ";
        return x;
    }

}

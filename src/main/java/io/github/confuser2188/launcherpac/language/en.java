package io.github.confuser2188.launcherpac.language;

public class en extends mainLang {


    public static mainLang getLang(){
        en x = new en();
        x.shortlangName="en";
        x.langName="English";
        x.playButton="PLAY";
        x.username="Username:";
        x.loginButton="Login";
        x.settings="Settings";
        x.Account="Account";
        x.javaSettings="Java Settings";
        x.version="Version";
        x.selectedMinecraftVersion="Selected Minecraft version: ";
        x.selectedLang="Selected Language: ";
        x.usernameLenghtError="Username must be at least three characters.";
        x.firstLogin="You can't start game without login.";
        x.saveButton="Save";
        return x;
    }

}

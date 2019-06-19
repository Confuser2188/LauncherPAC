package io.github.confuser2188.launcherpac.settings.language.list;

import io.github.confuser2188.launcherpac.settings.language.Language;

public class English extends Language {

    public English() {
        super("English");
    }

    @Override
    public void load() {
        this.setValue("playButton", "PLAY");
        this.setValue("loginRequired", "You have to login before starting game.");
        this.setValue("accountTab", "Account");
        this.setValue("accountTab_username", "Username:");
        this.setValue("settings", "Settings");
        this.setValue("saveSettings", "Save");
        this.setValue("selectedLanguage", "Selected Language:");
        this.setValue("launcherTab", "Launcher");
        this.setValue("launcherTab_javaSettings", "Java Settings");
        this.setValue("launcherTab_version", "Version");
        this.setValue("launcherTab_selectedVersion", "Selected Minecraft version:");
        this.setValue("loginTab", "Login");

        this.useLanguage();
    }
}

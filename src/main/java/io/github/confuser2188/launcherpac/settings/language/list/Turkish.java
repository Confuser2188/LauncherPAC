package io.github.confuser2188.launcherpac.settings.language.list;

import io.github.confuser2188.launcherpac.settings.language.Language;

public class Turkish extends Language {

    public Turkish() {
        super("Türkçe");
    }

    @Override
    public void load() {
        this.setValue("playButton", "OYNA");
        this.setValue("loginRequired", "Oyunu başlatmadan önce giriş yapmalısın.");
        this.setValue("accountTab", "Hesap");
        this.setValue("accountTab_username", "Kullanıcı adı:");
        this.setValue("settings", "Ayarlar");
        this.setValue("saveSettings", "Kaydet");
        this.setValue("selectedLanguage", "Seçilen Dil:");
        this.setValue("launcherTab", "Başlatıcı");
        this.setValue("launcherTab_javaSettings", "Java Ayarları");
        this.setValue("launcherTab_version", "Versiyon");
        this.setValue("launcherTab_selectedVersion", "Seçilen Minecraft sürümü:");
        this.setValue("loginTab", "Giriş");

        this.useLanguage();
    }
}

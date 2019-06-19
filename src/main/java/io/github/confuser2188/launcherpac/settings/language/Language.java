package io.github.confuser2188.launcherpac.settings.language;

import java.util.HashMap;

public abstract class Language implements ILanguage {

    public static Language selected;

    private HashMap<String, String> values = new HashMap<>();
    private String languageName;

    public Language(String languageName) {
        this.languageName = languageName;
    }

    public String getLanguageName() {
        return languageName;
    }

    protected void setValue(String key, String value) {
        this.values.put(key, value);
    }

    public String getValue(String key) {
        if(!values.containsKey(key)) throw new NullPointerException("Cannot find key name!");
        return values.get(key);
    }

    protected void useLanguage() {
        selected = this;
    }
}

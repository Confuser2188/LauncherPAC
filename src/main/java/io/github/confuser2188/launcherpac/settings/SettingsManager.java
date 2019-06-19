package io.github.confuser2188.launcherpac.settings;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class SettingsManager {

    private static transient String PROP_PATH = System.getenv("homedrive") + File.separator + "PAC" + File.separator + "pac.properties";
    private static Properties prop;

    public static Properties setup() {
        try {
            File settingsFile = new File(PROP_PATH);
            if(!settingsFile.exists()) settingsFile.getParentFile().mkdirs();

            prop = new Properties();
            if(settingsFile.exists()) prop.load(new FileInputStream(settingsFile));

            for(Map.Entry<String, String> defaultProp : getDefaultProperties().entrySet())
                if(prop.getProperty(defaultProp.getKey()) == null) prop.put(defaultProp.getKey(), defaultProp.getValue());

            prop.store(new FileOutputStream(settingsFile), null);

            return prop;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static HashMap<String, String> getDefaultProperties() {
        HashMap<String, String> defaultProperties = new HashMap<>();
        defaultProperties.put("language", "en");
        defaultProperties.put("username", "Phoenix");
        defaultProperties.put("mcVersion", "1.13.2");

        return defaultProperties;
    }

    public static Properties getProperties(){
        return prop;
    }

    public static void setProperty(String key, String value) {
        try {
            prop.setProperty(key, value);
            saveProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveProperties() throws IOException {
        File settingsFile = new File(PROP_PATH);
        if(!settingsFile.exists()) settingsFile.getParentFile().mkdirs();

        prop.store(new FileOutputStream(settingsFile), null);
    }
}

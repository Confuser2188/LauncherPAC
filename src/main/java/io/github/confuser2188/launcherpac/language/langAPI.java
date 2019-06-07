package io.github.confuser2188.launcherpac.language;

import io.github.confuser2188.launcherpac.fileBaseSettings.settingsAPI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class langAPI {

    public static HashMap<String,mainLang> langs= new HashMap<String,mainLang>();
    public static mainLang usingLang=null;

    public static void setupLangAPI(){
        langs.put("en",en.getLang());
        langs.put("tr",tr.getLang());
        if(langs.get(settingsAPI.getVal("selectedLang"))==null){
            if (langAPI.systemLangIsTurkish())
                settingsAPI.setVal("selectedLang", "tr");
            else
                settingsAPI.setVal("selectedLang", "en");
        }
        usingLang=langs.get(settingsAPI.getVal("selectedLang"));
    }

    public static void changeLang(String targetLang){
        settingsAPI.setVal("selectedLang",targetLang);
        usingLang=langs.get(targetLang);
    }


    public static boolean systemLangIsTurkish(){
        if (System.getProperty("user.language").equalsIgnoreCase("tr")){
            return true;
        }
        return false;
    }

}
package io.github.confuser2188.launcherpac.fileBaseSettings;

import javax.swing.*;
import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Properties;

public class settingsAPI {

    public static Properties properties = null;
    public static String[] versionList={"1.8.9","1.12.2","1.13.2"};

    public static void setupSettingsAPI(){
        try  {
            // file
            File settingsFile = new File(System.getenv("SystemDrive")+File.separator+"PAC"+File.separator+"settings.txt");
            settingsFile.getParentFile().mkdirs();
            settingsFile.createNewFile();
            InputStream input = new FileInputStream(System.getenv("SystemDrive")+File.separator+"PAC"+File.separator+"settings.txt");
            //props
            Properties prop = new Properties();
            prop.load(input);
            input.close();
            //default
            if (!prop.containsKey("selectedLang")) {
                prop.setProperty("selectedLang", "tr");
            }
            if (!prop.containsKey("selectedMCVersion")) {
                prop.setProperty("selectedMCVersion", "1.8.9");
            }
            if(!Arrays.asList(versionList).contains(prop.getProperty("selectedMCVersion"))){
                prop.setProperty("selectedMCVersion", "1.8.9");
            }
            OutputStream output = new FileOutputStream(System.getenv("SystemDrive")+File.separator+"PAC"+File.separator+"settings.txt");
            prop.store(output,null);
            output.close();
            properties=prop;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static String getVal(String key){
        return properties.getProperty(key);
    }

    public static void setVal(String key,String value){
        properties.setProperty(key,value);
        try {
            OutputStream output = new FileOutputStream(System.getenv("SystemDrive")+File.separator+"PAC"+File.separator+"settings.txt");
            properties.store(output,null);
            output.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

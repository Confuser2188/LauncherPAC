package io.github.confuser2188.launcherpac.game;

import io.github.confuser2188.launcherpac.Main;
import io.github.confuser2188.launcherpac.design.frame.MainMenu;
import io.github.confuser2188.launcherpac.misc.StringUtils;

import java.io.*;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class MinecraftBuilder {

    public static void launch(String version, String username) {
        new Thread(() ->{
            try {
                // Listen output of LoaderPAC as status
                PrintStream printStream = new PrintStream(System.out){
                    @Override
                    public void println(String x) {
                        super.println(x);
                        MainMenu.status.setString(StringUtils.fixLength(x.replace("[PAC] ", ""), 55, true));
                    }
                };
                System.setOut(printStream);

                MainMenu.status.setString("Extracting PAC...");
                String pacPath = extract();
                if(pacPath == null) {
                    MainMenu.status.setString("Something went wrong while extracting loader.lib");
                    throw new NullPointerException("Path of LoaderPAC");
                }

                MainMenu.status.setString("Loading Minecraft. This may take a while...");

                File pacJar = new File(pacPath);
                URLClassLoader child = new URLClassLoader(
                        new URL[] {pacJar.toURI().toURL()},
                        Main.class.getClassLoader()
                );

                String[] args = new String[] {
                        "-launchmc",
                        version,
                        "-username",
                        username,
                        "-customparameter",
                        "-Xmx" + (int)(Double.parseDouble(MainMenu.ramValueString.getString().split("/")[0].replace(",", ".")) * 1024) + "M",
                };

                // Call main method of LoaderPAC to launch Minecraft
                Class<?> classToLoad = Class.forName("io.github.confuser2188.loaderpac.Main", true, child);
                Method method = classToLoad.getDeclaredMethod("main", String[].class);
                method.setAccessible(true);
                method.invoke(null, (Object) args); // invoke using args
            } catch (Exception e) {
                e.printStackTrace();
                MainMenu.status.setString("Failed to launch Minecraft.");
            }
        }).start();
    }

    /**
     * Extracts LoaderPAC file
     * @return path of extracted LoaderPAC file
     */
    private static String extract(){
        try {
            InputStream fileStream = Main.class.getResourceAsStream("/assets/anticheat/LoaderPAC.lib");

            File file = new File(new File(".").getCanonicalPath() + File.separator + "lib" + File.separator + "loader.lib");
            file.getParentFile().mkdirs();

            OutputStream out = new FileOutputStream(file);

            byte[] buffer = new byte[1024];
            int len = fileStream.read(buffer);
            while (len != -1) {
                out.write(buffer, 0, len);
                len = fileStream.read(buffer);
            }

            fileStream.close();
            out.close();

            return file.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

package io.github.confuser2188.launcherpac.misc;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public enum CustomImage {

    WALLPAPER("twal1"),
    COG("cog"),
    MINIMIZE("minimize"),
    CLOSE("close");

    private String imageName;
    CustomImage(String imageName){
        this.imageName = imageName;
    }

    public Image getImage(){
        return this.getImageIcon().getImage();
    }

    public ImageIcon getImageIcon(){
        return new ImageIcon(this.getPNG(imageName));
    }

    private BufferedImage getPNG(String str) {
        try{
            return ImageIO.read(this.getClass().getResource("/assets/pictures/" + str + ".png"));
        }catch (Exception ex){
            try {
                return ImageIO.read(this.getClass().getResource("/assets/pictures/" + str + ".jpg"));
            }catch (Exception e){
                e.printStackTrace();
                throw new NullPointerException("Cannot find " + str + ".png/" + str + ".jpg");
            }
        }
    }

    public static Image getImageFromURL(String username){
        try {
            URL url = new URL("https://minotar.net/bust/" + username + ".png");
            return ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
            throw new NullPointerException("Failed to parse image!");
        }
    }
}

package io.github.confuser2188.launcherpac.design.frame;

import io.github.confuser2188.launcherpac.Main;
import io.github.confuser2188.launcherpac.design.component.Button;
import io.github.confuser2188.launcherpac.design.component.Component;
import io.github.confuser2188.launcherpac.design.component.*;
import io.github.confuser2188.launcherpac.design.component.Image;
import io.github.confuser2188.launcherpac.design.component.Rectangle;
import io.github.confuser2188.launcherpac.game.MinecraftBuilder;
import io.github.confuser2188.launcherpac.misc.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

public class MainMenu extends JFrame {

    public static StringObject status = new StringObject("");
    public static StringObject mcVersion = new StringObject("1.8.9");
    public static StringObject ramValueString = new StringObject("1.0/" + SystemInfo.getMaxRAM() + " GB");

    public static MainMenu menu;
    private boolean dragging;
    private Point point;
    private ComponentArrayList components = new ComponentArrayList();
    private ArrayList<Component> drawQueue = new ArrayList<>();
    public static int tabIndex = 1;

    private JPanel panel = new JPanel(){
        @Override
        protected void paintComponent(Graphics g) {
            // Anti Aliasing
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(
                    RenderingHints.KEY_TEXT_ANTIALIASING,
                    RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2d.setRenderingHint(
                    RenderingHints.KEY_RENDERING,
                    RenderingHints.VALUE_RENDER_QUALITY);

            // Load new components
            components.addAll(drawQueue);
            drawQueue.clear();

            // Draw components
            for(Component comp : components)
                comp.draw(g);
        }
    };

    public MainMenu(String username) {
        try {
            menu = this;

            this.setUndecorated(true);
            this.setTitle("Phoenix Anti-Cheat Launcher");
            this.setSize(1000, 600);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
            this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            this.setResizable(false);
            setDefaultLookAndFeelDecorated(true);

            panel.addMouseListener(new MouseAdapter() {

                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);

                    for(Component comp : components){
                        if(comp instanceof Button && ((Button)comp).isEnabled())
                            ((Button)comp).mouseClicked(e);
                    }

                    if(Calc.isInBounds(0, 0, 1000, 35, e.getPoint())){
                        point = e.getPoint();
                        dragging = true;
                    }
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    super.mouseReleased(e);
                    point = null;
                    dragging = false;
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    super.mouseExited(e);

                    for(Component comp : components){
                        if(comp instanceof Button)
                            ((Button)comp).mouseExit(e);
                    }
                }
            });

            panel.addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    super.mouseMoved(e);

                    boolean setCursorToDefault = true;
                    for(Component comp : components){
                        if(comp instanceof Button)
                            if(((Button)comp).mouseMoved(e))
                                setCursorToDefault = false;
                    }

                    if(setCursorToDefault)
                        menu.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }

                @Override
                public void mouseDragged(MouseEvent e) {
                    super.mouseDragged(e);

                    for(Component comp : components)
                        if(comp instanceof Slider)
                            ((Slider)comp).mouseDragged(e);

                    if(point == null) return;
                    Point cur = e.getLocationOnScreen();
                    menu.setLocation(cur.x - point.x, cur.y - point.y);
                }
            });

            getContentPane().add(panel);

            // Background
            this.components.add(new Image(CustomImage.WALLPAPER.getImage(), 0, 0, 0, 0));

            // Top
            this.components.add(new FilledRectangle(0, 0, 1000, 30, new Color(15, 15, 15, 255)));
            this.components.add(new Button(5, 5, 20, 20, new Color(15, 15, 15, 255)) {
                @Override
                public void click() {
                    MainMenu.tabIndex = (MainMenu.tabIndex == 1) ? 2 : 1;
                }
            });
            this.components.add(new Image(CustomImage.COG.getImage(), 5, 5, 20, 20));
            this.components.add(new Button(940, 5, 20, 20, new Color(15, 15, 15, 255)) {
                @Override
                public void click() {
                    menu.setState(Frame.ICONIFIED);
                }
            });
            this.components.add(new Image(CustomImage.MINIMIZE.getImage(), 940, 5, 20, 20));
            this.components.add(new Button(970, 5, 20, 20, new Color(15, 15, 15, 255)) {
                @Override
                public void click() {
                    System.exit(0);
                }
            });
            this.components.add(new Image(CustomImage.CLOSE.getImage(), 970, 5, 20, 20));

            // Middle Text
            FilledRectangle rect1 = new FilledRectangle(406, 191, 186, 59, new Color(255, 72, 0, 255)); rect1.setTabIndex(1);
            FilledRectangle rect2 = new FilledRectangle(381, 260, 236, 59, new Color(25, 25, 25, 255)); rect2.setTabIndex(1);
            this.components.add(rect1);
            this.components.add(rect2);
            Text text1 = new Text("PHOENIX", 430, 239, CustomFont.AGENCY_FB.getFont(52F), Color.WHITE); text1.setTabIndex(1);
            Text text2 = new Text("ANTI-CHEAT", 408, 310, CustomFont.AGENCY_FB.getFont(52F), Color.WHITE); text2.setTabIndex(1);
            this.components.add(text1);
            this.components.add(text2);

            // Bottom
            this.components.add(new FilledRectangle(0, 532, 1000, 68, new Color(255, 72, 0, 150)));
            this.components.add(new Button(381, 532, 237, 381, new Color(21, 21, 21, 150)) {
                @Override
                public void click() {
                    this.setEnabled(false);
                    drawQueue.add(new Rectangle(282, 441, 435, 63, new Color(240, 90, 35)));
                    drawQueue.add(new Rectangle(281, 440, 437, 65, new Color(240, 90, 35)));
                    drawQueue.add(new FilledRectangle(283, 442, 434, 62, new Color(0, 0, 0, 200)));
                    drawQueue.add(new Text(status, 300, 475, new Font("Arial", Font.PLAIN, 14), Color.WHITE));

                    MinecraftBuilder.launch(mcVersion.getString(), username);
                }
            });
            this.components.add(new Text("PLAY", 455, 570, new Font("Arial", Font.BOLD, 35), Color.WHITE));
            this.components.add(new Text(mcVersion, 478, 590, new Font("Arial", Font.PLAIN, 16), Color.WHITE));

            Text version = new Text(Main.VERSION, 998, 595, new Font("Arial", Font.PLAIN, 12), Color.WHITE);
            version.setMirror(true);
            this.components.add(version);

            //this.components.add(new FilledRectangle(8, 538, 54, 54, new Color(0, 0, 0, 255)));
            this.components.add(new Image(CustomImage.getImageFromURL(username), 10, 540, 50, 50));
            this.components.add(new Text(username, 70, 570, new Font("Arial", Font.PLAIN, 16), Color.WHITE));

            // Settings Menu
            this.components.add(new FilledRectangle(150, 100, 700, 370, new Color(0, 0, 0, 200)), 2);
            this.components.add(new Rectangle(150, 100, 700, 370, Color.WHITE), 2);
            this.components.add(new Text("Settings", 170, 130, new Font("Arial", Font.BOLD, 21), Color.WHITE), 2);
            this.components.add(new Text("Account", 180, 190, new Font("Arial", Font.PLAIN, 14), Color.GRAY), 2);
            this.components.add(new Text("Launcher", 180, 220, new Font("Arial", Font.PLAIN, 14), Color.WHITE), 2);

            // Settings Menu -> Launcher
            this.components.add(new Text("Java Settings", 350, 150, new Font("Arial", Font.PLAIN, 16), Color.WHITE), 2);
            this.components.add(new Line(350, 165, 700, 165, Color.GRAY), 2);
            this.components.add(new Text("RAM", 350, 210, new Font("Arial", Font.PLAIN, 12), Color.WHITE), 2);

            Text ramValueText = new Text(ramValueString, 700, 210, new Font("Arial", Font.PLAIN, 12), Color.WHITE); ramValueText.setTabIndex(2); ramValueText.setMirror(true);
            this.components.add(ramValueText);
            this.components.add(new Slider(350, 220, 350, 10, (int)(Double.parseDouble(SystemInfo.getMaxRAM().replace(",", ".")) * 10), Color.WHITE) {
                @Override
                public void valueChanged(double newValue) {
                    ramValueString.setString(newValue / 10 + "/" + SystemInfo.getMaxRAM() + " GB");
                }
            }, 2);

            this.components.add(new Text("Version", 350, 300, new Font("Arial", Font.PLAIN, 16), Color.WHITE), 2);
            this.components.add(new Line(350, 315, 700, 315, Color.GRAY), 2);
            StringObject selectedMCVersion = new StringObject(mcVersion.getString()); selectedMCVersion.setPrefix("Selected Minecraft version: ");
            this.components.add(new Text(selectedMCVersion, 350, 350, new Font("Arial", Font.PLAIN, 16), Color.WHITE), 2);
            this.components.add(new Button(350, 360, 100, 40, new Color(255, 72, 0, 100)) {
                private String VERSION = "1.8.9";
                @Override
                public void draw(Graphics graphics) {
                    if(selectedMCVersion.getString().endsWith(this.VERSION))
                        this.setAlpha(255);
                    super.draw(graphics);
                }

                @Override
                public void click() {
                    mcVersion.setString(this.VERSION);
                    selectedMCVersion.setString(this.VERSION);
                }
            }, 2);
            this.components.add(new Rectangle(350, 360, 100, 40, Color.WHITE), 2);
            this.components.add(new Button(450, 360, 100, 40, new Color(255, 72, 0, 100)) {
                private String VERSION = "1.12.2";
                @Override
                public void draw(Graphics graphics) {
                    if(selectedMCVersion.getString().endsWith(this.VERSION))
                        this.setAlpha(255);
                    super.draw(graphics);
                }

                @Override
                public void click() {
                    mcVersion.setString(this.VERSION);
                    selectedMCVersion.setString(this.VERSION);
                }
            }, 2);
            this.components.add(new Rectangle(450, 360, 100, 40, Color.WHITE), 2);
            this.components.add(new Button(550, 360, 100, 40, new Color(255, 72, 0, 100)) {
                private String VERSION = "1.13.2";
                @Override
                public void draw(Graphics graphics) {
                    if(selectedMCVersion.getString().endsWith(this.VERSION))
                        this.setAlpha(255);
                    super.draw(graphics);
                }

                @Override
                public void click() {
                    mcVersion.setString(this.VERSION);
                    selectedMCVersion.setString(this.VERSION);
                }
            }, 2);
            this.components.add(new Rectangle(550, 360, 100, 40, Color.WHITE), 2);

            this.components.add(new Text("1.8.9", 375, 387, new Font("Arial", Font.PLAIN, 20), Color.WHITE), 2);
            this.components.add(new Text("1.12.2", 472, 387, new Font("Arial", Font.PLAIN, 20), Color.WHITE), 2);
            this.components.add(new Text("1.13.2", 572, 387, new Font("Arial", Font.PLAIN, 20), Color.WHITE), 2);

            // Last things (end)
            this.setVisible(true);
            new Timer(10, (actionEvent) -> {
                if(!dragging) panel.repaint();
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
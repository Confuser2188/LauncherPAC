package io.github.confuser2188.launcherpac.design.frame;

import io.github.confuser2188.launcherpac.Main;
import io.github.confuser2188.launcherpac.design.component.Button;
import io.github.confuser2188.launcherpac.design.component.Component;
import io.github.confuser2188.launcherpac.design.component.*;
import io.github.confuser2188.launcherpac.design.component.Image;
import io.github.confuser2188.launcherpac.design.component.Rectangle;
import io.github.confuser2188.launcherpac.game.MinecraftBuilder;
import io.github.confuser2188.launcherpac.misc.Calc;
import io.github.confuser2188.launcherpac.misc.CustomFont;
import io.github.confuser2188.launcherpac.misc.CustomImage;
import io.github.confuser2188.launcherpac.misc.StringObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

public class MainMenu extends JFrame {

    public static MainMenu menu;
    public static StringObject status = new StringObject("");
    private boolean dragging;
    private Point point;
    private ArrayList<Component> components = new ArrayList<>();
    private ArrayList<Component> queue = new ArrayList<>();

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
            components.addAll(queue);
            queue.clear();

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
                    System.out.println("SETTINGS MENU");
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
            this.components.add(new FilledRectangle(406, 191, 186, 59, new Color(255, 72, 0, 255)));
            this.components.add(new FilledRectangle(381, 260, 236, 59, new Color(25, 25, 25, 255)));
            this.components.add(new Text("PHOENIX", 430, 239, CustomFont.AGENCY_FB.getFont(52F), Color.WHITE));
            this.components.add(new Text("ANTI-CHEAT", 408, 310, CustomFont.AGENCY_FB.getFont(52F), Color.WHITE));

            // Bottom
            this.components.add(new FilledRectangle(0, 532, 1000, 68, new Color(255, 72, 0, 150)));
            this.components.add(new Button(381, 532, 237, 381, new Color(21, 21, 21, 150)) {
                @Override
                public void click() {
                    this.setEnabled(false);
                    queue.add(new Rectangle(282, 441, 435, 63, new Color(240, 90, 35)));
                    queue.add(new Rectangle(281, 440, 437, 65, new Color(240, 90, 35)));
                    queue.add(new FilledRectangle(283, 442, 434, 62, new Color(0, 0, 0, 200)));
                    queue.add(new Text(status, 300, 475, new Font("Arial", Font.PLAIN, 14), Color.WHITE));

                    MinecraftBuilder.launch("1.8.9", username);
                }
            });
            this.components.add(new Text("PLAY", 455, 570, new Font("Arial", Font.BOLD, 35), Color.WHITE));
            this.components.add(new Text("1.8.9", 478, 590, new Font("Arial", Font.PLAIN, 16), Color.WHITE));

            Text version = new Text(Main.VERSION, 998, 595, new Font("Arial", Font.PLAIN, 12), Color.WHITE);
            version.setMirror(true);
            this.components.add(version);

            //this.components.add(new FilledRectangle(8, 538, 54, 54, new Color(0, 0, 0, 255)));
            this.components.add(new Image(CustomImage.getImageFromURL(username), 10, 540, 50, 50));
            this.components.add(new Text(username, 70, 570, new Font("Arial", Font.PLAIN, 16), Color.WHITE));

            this.setVisible(true);

            new Timer(10, (actionEvent) -> {
                if(!dragging) panel.repaint();
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
package io.github.confuser2188.launcherpac.design.frame;

import io.github.confuser2188.launcherpac.design.component.Button;
import io.github.confuser2188.launcherpac.design.component.Component;
import io.github.confuser2188.launcherpac.design.component.Slider;
import io.github.confuser2188.launcherpac.design.component.TextBox;
import io.github.confuser2188.launcherpac.design.tab.*;
import io.github.confuser2188.launcherpac.misc.Calc;
import io.github.confuser2188.launcherpac.misc.StringObject;
import io.github.confuser2188.launcherpac.misc.SystemInfo;
import io.github.confuser2188.launcherpac.settings.SettingsManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

public class MainMenu extends JFrame {

    public static StringObject status = new StringObject("");
    public static StringObject mcVersion = new StringObject(SettingsManager.getProperties().getProperty("mcVersion"));
    public static StringObject ramValueString = new StringObject("1.0/" + SystemInfo.getMaxRAM() + " GB");

    public static MainMenu menu;
    public static StringObject USERNAME;
    private boolean dragging;
    private Point point;
    public static int tabIndex = 6;

    private ArrayList<Tab> tabs = new ArrayList<>();

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
            for(Tab tab : tabs){
                tab.components.addAll(tab.drawQueue);
                tab.drawQueue.clear();
            }

            // Draw components
            for(Tab tab : tabs)
                for(Component comp : tab.components)
                    comp.draw(g);
        }
    };

    public MainMenu(String username) {
        USERNAME = new StringObject(username);

        try {
            menu = this;

            // Setup tabs
            tabs.add(new Global());
            tabs.add(new MainTab());
            tabs.add(new Settings());
            tabs.add(new LauncherSettings());
            tabs.add(new LanguageSettings());
            tabs.add(new AccountSettings());
            tabs.add(new Login());

            for(Tab tab : tabs)
                tab.load();

            // Setup GUI settings
            this.setUndecorated(true);
            this.setTitle("Phoenix Anti-Cheat Launcher");
            this.setSize(1000, 600);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
            this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            this.setResizable(false);
            setDefaultLookAndFeelDecorated(true);

            KeyEventDispatcher keyEventDispatcher = e -> {
                for(Tab tab : tabs)
                    for(Component comp : tab.components){
                        if(comp instanceof TextBox)
                            ((TextBox)comp).dispatchKeyEvent(e);
                    }
                return true;
            };
            KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(keyEventDispatcher);

            panel.addMouseListener(new MouseAdapter() {

                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);

                    for(Tab tab : tabs)
                        for(Component comp : tab.components){
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

                    for(Tab tab : tabs)
                        for(Component comp : tab.components){
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
                    for(Tab tab : tabs)
                        for(Component comp : tab.components){
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

                    for(Tab tab : tabs)
                        for(Component comp : tab.components)
                            if(comp instanceof Slider)
                                ((Slider)comp).mouseDragged(e);

                    if(point == null) return;
                    Point cur = e.getLocationOnScreen();
                    menu.setLocation(cur.x - point.x, cur.y - point.y);
                }
            });

            getContentPane().add(panel);

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
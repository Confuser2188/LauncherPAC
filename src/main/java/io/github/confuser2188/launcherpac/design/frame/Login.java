package io.github.confuser2188.launcherpac.design.frame;

import io.github.confuser2188.launcherpac.language.langAPI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    private JTextField userTextField = new JTextField();
    private JButton loginButton = new JButton(langAPI.usingLang.loginButton);


    public Login() {
        this.setTitle("PAC Launcher");
        this.setVisible(true);
        this.setBounds(10, 10, 280, 150);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((int)screenSize.getWidth() / 2 - (int)this.getBounds().getWidth() / 2, (int)screenSize.getHeight() / 2 - (int)this.getBounds().getHeight() / 2);

        JLabel userLabel = new JLabel(langAPI.usingLang.username);
        userLabel.setBounds(20, 15, 100, 30);
        userTextField.setBounds(110, 20, 150, 25);
        loginButton.setBounds(20, 70, 240, 30);

        Container container = getContentPane();
        container.add(userLabel);
        container.add(userTextField);
        container.add(loginButton);

        loginButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = userTextField.getText();
            if(!isStringOnlyAlphabetAndNum(username)){
                JOptionPane.showMessageDialog(this,"Invalid username", "PAC Launcher", JOptionPane.ERROR_MESSAGE);
            }else if(username.length() > 16){
                JOptionPane.showMessageDialog(this,"Invalid username", "PAC Launcher", JOptionPane.ERROR_MESSAGE);
            }else{
                new MainMenu(username);
                dispose();
            }
        }
    }

    // TODO: Better validity check
    private static boolean isStringOnlyAlphabetAndNum(String str)
    {
        return ((!str.equals(""))
                && (str
                .replace("1", "")
                .replace("2", "")
                .replace("3", "")
                .replace("4", "")
                .replace("5", "")
                .replace("6", "")
                .replace("7", "")
                .replace("8", "")
                .replace("9", "")
                .replace("0", "")
                .replace("_", "")

                .matches("^[a-zA-Z]*$")));
    }
}
package Ui;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SplashScreenPanel extends JPanel {

    private JButton startBtn;

    public SplashScreenPanel(){
        Font myFont = new Font("Calibri", Font.BOLD, 28);

        setLayout(null);
        setVisible(true);

        // Title
        JLabel title = new JLabel("RPG Adventure!");
        title.setFont(new Font("Calibri", Font.BOLD, 36));
        title.setBounds(250, 40, 400, 60);
        add(title);

        //add the image label
        JLabel imgLabel = new JLabel();
        imgLabel.setBounds(50, 120, 700, 300);

        // Pick random image
        String[] images = {"MainMenu1.png", "MainMenu2.png"};
        String chosen = images[new Random().nextInt(images.length)];

        // Load + scale image
        ImageIcon icon = new ImageIcon("src/Images/" + chosen);
        Image scaled = icon.getImage().getScaledInstance(700, 300, Image.SCALE_SMOOTH);
        imgLabel.setIcon(new ImageIcon(scaled));

        add(imgLabel);


        // Start button
        startBtn = new JButton("Build A Character");
        startBtn.setFont(myFont);
        startBtn.setBounds(200, 500, 350, 60);
        startBtn.addActionListener(e -> MainFrame.switchToCharacterCreation());
        add(startBtn);

    }
}

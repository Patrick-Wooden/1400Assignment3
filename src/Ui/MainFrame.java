package Ui;

import Models.PlayerCharacter;

import javax.swing.*;

public class MainFrame extends JFrame{

    private static MainFrame instance;
    public MainFrame(){
        super("RPG Adventure");
        instance = this;

        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setContentPane(new SplashScreenPanel());
        setVisible(true);
    }
    public static void switchToSplash() {
        instance.setContentPane(new SplashScreenPanel());
        instance.revalidate();
        instance.repaint();
    }

    public static void switchToCharacterCreation() {
        instance.setContentPane(new CharacterCreationPanel());
        instance.revalidate();
        instance.repaint();
    }

    public static void switchToBattle(PlayerCharacter pc) {
        instance.setContentPane(new BattleSummaryPanel(pc));
        instance.revalidate();
        instance.repaint();
    }
}

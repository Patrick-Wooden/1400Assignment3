package Ui;

import Models.PlayerCharacter;
import Models.Monster;
import Models.StatGenerator;
import javax.swing.*;
import java.awt.*;

public class BattleSummaryPanel extends JPanel{

    private PlayerCharacter player;
    private Monster monster;

    public BattleSummaryPanel(PlayerCharacter pc){
        //get the player and make a monster first
        this.player = pc;
        this.monster = generateRandomMonster();

        Font titleFont = new Font("Calibri", Font.BOLD, 32);
        Font labelFont = new Font("Calibri", Font.BOLD, 22);

        setLayout(null);
        setVisible(true);

        // Title
        JLabel title = new JLabel("Fight to the Death!");
        title.setFont(titleFont);
        title.setBounds(200 + 50, 20, 400, 50);
        add(title);

        //Adding the player image
        JLabel playerImg = new JLabel();
        playerImg.setBounds(50, 80, 150, 150);

        String className = player.getClass().getSimpleName();
        ImageIcon pIcon = new ImageIcon("src/Images/" + className + ".png");
        Image pScaled = pIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        playerImg.setIcon(new ImageIcon(pScaled));

        add(playerImg);


        //Adding monster image
        JLabel monsterImg = new JLabel();
        monsterImg.setBounds(575, 80, 150, 150);

        String mType = monster.getMonsterType();
        ImageIcon mIcon = new ImageIcon("src/Images/" + mType + ".png");
        Image mScaled = mIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        monsterImg.setIcon(new ImageIcon(mScaled));

        add(monsterImg);



        //Add in the player stats
        JLabel pHeader = new JLabel("Player: " + player.getName());
        pHeader.setFont(labelFont);
        pHeader.setBounds(50, 250, 300, 30);
        add(pHeader);

        JLabel pLine = new JLabel("-----------------------------");
        pLine.setFont(labelFont);
        pLine.setBounds(50, 280, 300, 30);
        add(pLine);

        addStatLabel("Class: " + player.getClass().getSimpleName(), 50, 320, labelFont);

        // First row of stats
        addStatLabel("HP: " + player.getHitPoints(), 50, 360, labelFont);
        addStatLabel("Defense: " + player.getDefense(), 200, 360, labelFont);
        addStatLabel("Agility: " + player.getAgility(), 380, 360, labelFont);
        addStatLabel("Base Attack: " + player.getBaseAttack(), 550, 360, labelFont);

        // Second row of stats
        addStatLabel("Weapon: " + player.getWeapon().getName(), 50, 400, labelFont);
        addStatLabel("Weight: " + player.getWeapon().getWeight(), 380, 400, labelFont);
        addStatLabel("Attack Mod: " + player.getWeapon().getAttackModifier(), 550, 400, labelFont);

        //Add in all the monster stats
        JLabel mHeader = new JLabel("Monster: " + monster.getName());
        mHeader.setFont(labelFont);
        mHeader.setBounds(50, 450, 300, 30);
        add(mHeader);

        JLabel mLine = new JLabel("-----------------------------");
        mLine.setFont(labelFont);
        mLine.setBounds(50, 480, 300, 30);
        add(mLine);

        addStatLabel("HP: " + monster.getHitPoints(), 50, 520, labelFont);
        addStatLabel("Defense: " + monster.getDefense(), 200, 520, labelFont);
        addStatLabel("Agility: " + monster.getAgility(), 380, 520, labelFont);
        addStatLabel("Base Attack: " + monster.getBaseAttack(), 550, 520, labelFont);

        //last add the play again button
        JButton backBtn = new JButton("Play Again");
        backBtn.setFont(labelFont);
        backBtn.setBounds(275, 580, 220, 50);
        backBtn.addActionListener(e -> MainFrame.switchToSplash());
        add(backBtn);



    }

    private void addStatLabel(String text, int x, int y, Font font) {
        JLabel lbl = new JLabel(text);
        lbl.setFont(font);
        lbl.setBounds(x, y, 300, 40);
        add(lbl);
    }
    //this method returns a random monster from 3 types and give random attributes
    private Monster generateRandomMonster(){

        int roll = StatGenerator.randomStat(1,3);
        String type;
        switch(roll){
            case 1: type = "Goblin"; break;
            case 2: type = "Dragon"; break;
            default: type = "White Walker"; break;
        }
        //get a random name for the monster
        String[] names = {
                "Gnarclaw", "Bonegnasher", "Skulkfang",
                "Frostmaw", "Rattlehide", "Nightstalker",
                "Grimtooth", "Blightborn"
        };
        String name = names[StatGenerator.randomStat(0, names.length - 1)];

        //now we return a new monster by calling statgernator methods for the values and using the type and name we got before
        return new Monster(
                name,
                StatGenerator.generateHP(),
                StatGenerator.generateDefense(),
                StatGenerator.generateAgility(),
                StatGenerator.generateBaseAttack(),
                type

        );
    }



}

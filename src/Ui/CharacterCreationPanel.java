package Ui;

import Models.StatGenerator;
import Models.PlayerCharacter;
import Models.Warrior;
import Models.Wizard;

import Weapons.Weapon;
import Weapons.Sword;
import Weapons.Staff;

import javax.swing.*;
import java.awt.*;

public class CharacterCreationPanel extends JPanel {

    private JTextField nameText;

    private JRadioButton rdoWarrior;
    private JRadioButton rdoWizard;

    private JRadioButton rdoSword;
    private JRadioButton rdoStaff;

    private JTextField hpField;
    private JTextField defField;
    private JTextField agiField;
    private JTextField atkField;

    private JTextField weaponAtkField;
    private JTextField weaponWeightField;

    private JLabel classImage;
    private JLabel weaponImage;

    private JLabel classDescription;
    private JLabel weaponDescription;

    public CharacterCreationPanel() {

        setLayout(null);
        //first set the font (I know size 22 was required but I made some bigger since it seemed to small)
        Font titleFont = new Font("Calibri", Font.BOLD, 32);
        Font sectionFont = new Font("Calibri", Font.BOLD, 22);
        Font textFont = new Font("Calibri", Font.PLAIN, 22);

        //First we make the title and set it
        JLabel title = new JLabel("Character Generator");
        title.setFont(titleFont);
        title.setBounds(250, 10, 400, 40);
        add(title);

        //Next I added the name field for users to enter the name.
        JLabel nameLabel = new JLabel("Enter Name:");
        nameLabel.setFont(sectionFont);
        nameLabel.setBounds(50, 70, 200, 40);
        add(nameLabel);

        nameText = new JTextField();
        nameText.setFont(textFont);
        nameText.setBounds(200, 70, 200, 40);
        add(nameText);

        //Next I added the character type and the buttons and text field for going between both options
        JLabel classLabel = new JLabel("Character Type:");
        classLabel.setFont(sectionFont);
        classLabel.setBounds(50, 130, 200, 40);
        add(classLabel);

        //set text and font for the raido buttons
        rdoWarrior = new JRadioButton("Warrior");
        rdoWizard = new JRadioButton("Wizard");

        rdoWarrior.setFont(textFont);
        rdoWizard.setFont(textFont);

        rdoWarrior.setBounds(50, 170, 150, 30);
        rdoWizard.setBounds(50, 200, 150, 30);

        //make a button group so only one button can be selected at once
        ButtonGroup classGroup = new ButtonGroup();
        classGroup.add(rdoWarrior);
        classGroup.add(rdoWizard);

        //make the warrior class selected as default when its loaded, and add both btns to panel
        rdoWarrior.setSelected(true);

        add(rdoWarrior);
        add(rdoWizard);

        // -------------------------
        // Now we load the correct image based on the selected class. Below are my sources for the images
        // Image attribution:
        // Wizard.png: "Magnifying Glass Vectors" by Vecteezy — https://www.vecteezy.com
        // Warrior.png: Generated from https://deepai.org/machine-learning-model/text2img
        // -------------------------
        classImage = new JLabel();
        classImage.setBounds(220, 150, 150, 150);
        add(classImage);

        //Below is the code for making the character stats fields where they will display. Also the reroll button
        JLabel statsLabel = new JLabel("Character Stats:");
        statsLabel.setFont(sectionFont);
        statsLabel.setBounds(400, 130, 200, 40);
        add(statsLabel);

        hpField = createStatField("Hit Points:", 400, 170, textFont);
        defField = createStatField("Defense:", 400, 210, textFont);
        agiField = createStatField("Agility:", 400, 250, textFont);
        atkField = createStatField("Base Attack:", 400, 290, textFont);

        JButton rerollBtn = new JButton("Reroll");
        rerollBtn.setFont(sectionFont);
        rerollBtn.setBounds(450, 340, 150, 40);
        //add a listener so when button is clicked reroll stats method is called
        rerollBtn.addActionListener(e -> rerollStats());
        //add reroll stats btn to panel and call the method to get us some values when it loads the first time
        add(rerollBtn);

        rerollStats();

        //next I added the class description to the panel
        classDescription = new JLabel();
        classDescription.setFont(textFont);
        classDescription.setBounds(50, 330, 350, 80);
        classDescription.setOpaque(true);
        classDescription.setBackground(Color.WHITE);

        // Add border + padding
        classDescription.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 2),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        //add description to screen
        add(classDescription);

        //add listeners for the two class buttons that will reroll the stats when the user changes between classes so they do not get a warrior with high agility for example or wizard with high hp
        rdoWarrior.addActionListener(e -> rerollStats());
        rdoWizard.addActionListener(e -> rerollStats());


        //next I created the weapon part, including label radiobuttons, text, etc
        JLabel weaponLabel = new JLabel("Select Your Weapon:");
        weaponLabel.setFont(sectionFont);
        weaponLabel.setBounds(50, 420, 250, 40);
        add(weaponLabel);

        //next add text and font for the two buttons
        rdoSword = new JRadioButton("Sword");
        rdoStaff = new JRadioButton("Staff");

        rdoSword.setFont(textFont);
        rdoStaff.setFont(textFont);

        rdoSword.setBounds(50, 460, 150, 30);
        rdoStaff.setBounds(50, 490, 150, 30);

        //make a button group so only one button can be selected at once
        ButtonGroup weaponGroup = new ButtonGroup();
        weaponGroup.add(rdoSword);
        weaponGroup.add(rdoStaff);

        rdoSword.setSelected(true);

        add(rdoSword);
        add(rdoStaff);

        // WEAPON IMAGES
        // Staff: 8‑bit vector artwork by Vecteezy — https://www.vecteezy.com/free-vector/8-bit
        // Sword: Generated from https://deepai.org/machine-learning-model/text2img


        weaponImage = new JLabel();
        weaponImage.setBounds(220, 470, 150, 150);
        add(weaponImage);

        //Below I set the weapon stats
        JLabel weaponStatsLabel = new JLabel("Weapon Stats:");
        weaponStatsLabel.setFont(sectionFont);
        weaponStatsLabel.setBounds(400, 420, 200, 40);

        add(weaponStatsLabel);

        weaponAtkField = createStatField("Attack Modifier:", 400, 460, textFont);
        weaponWeightField = createStatField("Weight:", 400, 500, textFont);

        //Next we set the weapon description
        weaponDescription = new JLabel();
        weaponDescription.setFont(textFont);
        weaponDescription.setBounds(50, 650, 350, 80);
        weaponDescription.setOpaque(true);
        weaponDescription.setBackground(Color.WHITE);

        //added a border to make it look nicer
        weaponDescription.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 2),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        add(weaponDescription);

        //Lastly I add the start battle button
        JButton startBtn = new JButton("Start Battle");
        startBtn.setFont(sectionFont);
        startBtn.setBounds(450, 580, 200, 50);
        startBtn.addActionListener(e -> createCharacter());
        add(startBtn);

        // I decided to make warrior and sword be the default when the create Character screen is loaded
        updateClassInfo("warrior");
        updateWeaponInfo("sword");

        //Listeners that when are clicked change the info for the class or weapon
        rdoWarrior.addActionListener(e -> updateClassInfo("warrior"));
        rdoWizard.addActionListener(e -> updateClassInfo("wizard"));

        rdoSword.addActionListener(e -> updateWeaponInfo("sword"));
        rdoStaff.addActionListener(e -> updateWeaponInfo("staff"));
    }

    private JTextField createStatField(String label, int x, int y, Font font) {
        JLabel lbl = new JLabel(label);
        lbl.setFont(font);
        lbl.setBounds(x, y, 200, 30);
        add(lbl);

        JTextField field = new JTextField();
        field.setFont(font);
        field.setEditable(false);
        field.setBounds(x + 200, y, 100, 30);
        field.setOpaque(true);
        field.setBackground(Color.WHITE);
        add(field);

        return field;
    }

    //this method is called when the user clicks the warrior or wizard radio and then sets the accurate
    private void updateClassInfo(String type) {
        ImageIcon icon = new ImageIcon("src/Images/" + type + ".png");
        Image scaled = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        classImage.setIcon(new ImageIcon(scaled));
        //if statement to check what class has been selected then set the class description
        if (type.equals("warrior")) {
            classDescription.setText("<html>Fighters are often human.High HP & defense, low agility.</html>");
        } else {
            classDescription.setText("<html>Wizards are fragile but deal high magical damage.</html>");
        }
    }

    // Updates the weapon image, description, and stats when the user selects a new weapon.
    private void updateWeaponInfo(String type) {
        ImageIcon icon = new ImageIcon("src/Images/" + type + ".png");
        Image scaled = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        weaponImage.setIcon(new ImageIcon(scaled));
        //run a if statement and depending on what weapon it is set the text and update the weapon stats by passing that weapon type to updateWeaponStats
        if (type.equals("sword")) {
            weaponDescription.setText("<html>A sword is a good all-round weapon. Not too heavy, high damage.</html>");
            updateWeaponStats(new Sword());
        } else {
            weaponDescription.setText("<html>A staff is light and boosts magical abilities.</html>");
            updateWeaponStats(new Staff());
        }
    }

    // Fills the weapon stat text fields using the given Weapon object's values.
    private void updateWeaponStats(Weapon w) {
        weaponAtkField.setText(String.valueOf(w.getAttackModifier()));
        weaponWeightField.setText(String.valueOf(w.getWeight()));
    }

    // Generates new stats based on the selected class, giving Warriors tanky stats and Wizards lighter, agile stats.
    private void rerollStats() {
        //I use if else checks because depending on the selected class they should have different stats, like wizard having lower hp
        if (rdoWarrior.isSelected()) {
            // Warrior stats
            hpField.setText(String.valueOf(StatGenerator.randomStat(80, 120)));
            defField.setText(String.valueOf(StatGenerator.randomStat(10, 20)));
            agiField.setText(String.valueOf(StatGenerator.randomStat(1, 5)));
            atkField.setText(String.valueOf(StatGenerator.randomStat(8, 15)));

        } else {
            // Wizard stats
            hpField.setText(String.valueOf(StatGenerator.randomStat(40, 70)));
            defField.setText(String.valueOf(StatGenerator.randomStat(5, 10)));
            agiField.setText(String.valueOf(StatGenerator.randomStat(8, 15)));
            atkField.setText(String.valueOf(StatGenerator.randomStat(10, 25)));
        }

    }

    //The method below creates the selected character using the entered stats and weapon, then loads the battle screen
    private void createCharacter() {
        String name = nameText.getText().trim();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a name.");
            return;
        }
        //get the weapon and all values from text fields
        Weapon weapon = rdoSword.isSelected() ? new Sword() : new Staff();

        int hp = Integer.parseInt(hpField.getText());
        int def = Integer.parseInt(defField.getText());
        int agi = Integer.parseInt(agiField.getText());
        int atk = Integer.parseInt(atkField.getText());

        PlayerCharacter pc;
        //depending on what button was selected make that class
        if (rdoWarrior.isSelected()) {
            pc = new Warrior(name, hp, def, agi, atk, weapon);
        } else {
            pc = new Wizard(name, hp, def, agi, atk, weapon);
        }

        MainFrame.switchToBattle(pc);
    }
}
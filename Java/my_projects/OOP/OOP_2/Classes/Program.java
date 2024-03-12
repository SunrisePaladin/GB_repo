package OOP.OOP_2.Classes;

import java.util.ArrayList;
import java.util.List;

import OOP.OOP_2.Classes.*;
import OOP.OOP_2.Classes.Infantry.Sniper;
import OOP.OOP_2.Classes.Infantry.Spearman;
import OOP.OOP_2.Classes.Infantry.Wizard;
import OOP.OOP_2.Classes.Villagers.Crossbowman;
import OOP.OOP_2.Classes.Villagers.Monk;
import OOP.OOP_2.Classes.Villagers.Peasant;
import OOP.OOP_2.Classes.Villagers.Rogue;

public class Program {
    public static void main(String[] args) {
        List<TemplatePerson> Villagers = new ArrayList<>();
        Villagers.add(new Peasant("John"));
        Villagers.add(new Crossbowman("Oleg"));
        Villagers.add(new Rogue("Dany"));
        Villagers.add(new Monk("Bo Rai'Cho"));

        List<TemplatePerson> Infantry = new ArrayList<>();
        Infantry.add(new Sniper("Glaz"));
        Infantry.add(new Spearman("Homer"));
        Infantry.add(new Wizard("Gandalf"));

        
    }
}

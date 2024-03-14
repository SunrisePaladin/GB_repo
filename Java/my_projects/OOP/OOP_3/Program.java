package OOP.OOP_3;

import java.util.ArrayList;
import java.util.List;

import OOP.OOP_3.Heroes.TemplatePerson;
import OOP.OOP_3.Heroes.Crossbowman;
import OOP.OOP_3.Heroes.Sniper;
import OOP.OOP_3.Heroes.Wizard;
import OOP.OOP_3.Heroes.Monk;
import OOP.OOP_3.Heroes.Rogue;
import OOP.OOP_3.Heroes.Spearman;
import OOP.OOP_3.Heroes.Peasant;

public class Program {
    public static void main(String[] args) {
        ArrayList<TemplatePerson> TeamRed = new ArrayList<>();
        TeamRed.add(new Peasant("John"));
        TeamRed.add(new Rogue("Dany"));
        TeamRed.add(new Monk("Bo Rai'Cho"));
        TeamRed.add(new Sniper("Glaz"));

        ArrayList<TemplatePerson> TeamBlu = new ArrayList<>();
        Infantry.add(new Spearman("Homer"));
        Infantry.add(new Wizard("Gandalf"));
        TeamRed.add(new Crossbowman("Oleg"));

        // for (TemplatePerson person : Villagers){
        //     System.out.println("Команда деревенщин: " + person.getClass().getSimpleName() + " " + person.toString());
        // }

        // for (TemplatePerson person : Infantry){
        //     System.out.println("Команда бойцов: " + person.getClass().getSimpleName() + " " + person.toString());
        // }

    }
}

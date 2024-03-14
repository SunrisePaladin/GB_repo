package OOP.OOP_2.Classes;

import java.util.ArrayList;

import OOP.OOP_2.Classes.MeleeClass.Monk;
import OOP.OOP_2.Classes.MeleeClass.Rogue;
import OOP.OOP_2.Classes.MeleeClass.Spearman;
import OOP.OOP_2.Classes.RangeClass.Crossbowman;
import OOP.OOP_2.Classes.RangeClass.Sniper;
import OOP.OOP_2.Classes.RangeClass.Wizard;

public class Program {
    public static void main(String[] args) {
        ArrayList<TemplatePerson> TeamRed = new ArrayList<>();
        TeamRed.add(new Peasant("John"));
        TeamRed.add(new Rogue("Greyhood"));
        TeamRed.add(new Monk("Bo Rai'Cho"));
        TeamRed.add(new Sniper("Glaz"));

        ArrayList<TemplatePerson> TeamBlu = new ArrayList<>();
        TeamBlu.add(new Spearman("Homer"));
        TeamBlu.add(new Wizard("Gandalf"));
        TeamBlu.add(new Crossbowman("Oleg"));
        TeamBlu.add(new Peasant("Kel'tuzad"));

        for (TemplatePerson person : TeamRed){
            System.out.println("Команда красных бойцов: " + person.getClass().getSimpleName() + " " + person.toString());
        }

        for (TemplatePerson person : TeamBlu){
            System.out.println("Команда синих бойцов: " + person.getClass().getSimpleName() + " " + person.toString());
        }

    }
}

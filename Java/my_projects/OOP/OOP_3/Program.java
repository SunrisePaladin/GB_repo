package OOP.OOP_3;

import java.util.ArrayList;

import OOP.OOP_3.Heroes.TemplatePerson;
import OOP.OOP_3.Heroes.MeleeClass.*;
import OOP.OOP_3.Heroes.RangeClass.*;
import OOP.OOP_3.Heroes.Peasant;

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

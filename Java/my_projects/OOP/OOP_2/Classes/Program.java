package OOP.OOP_2.Classes;

import java.util.ArrayList;
import java.util.Random;

import OOP.OOP_2.Classes.MeleeClass.Monk;
import OOP.OOP_2.Classes.MeleeClass.Rogue;
import OOP.OOP_2.Classes.MeleeClass.Spearman;
import OOP.OOP_2.Classes.RangeClass.Crossbowman;
import OOP.OOP_2.Classes.RangeClass.Sniper;
import OOP.OOP_2.Classes.RangeClass.Wizard;

public class Program {

    static ArrayList<TemplatePerson> TeamRed = new ArrayList<>();
    static ArrayList<TemplatePerson> TeamBlu = new ArrayList<>();
    public static void main(String[] args) {

        createTeam(TeamBlu, 10, true);
        createTeam(TeamRed, 10, false);

        for (TemplatePerson person : TeamRed) {
            System.out.println("Команда красных бойцов: " + person.getClass().getSimpleName() + " " + person.toString());
        }

        for (TemplatePerson person : TeamBlu) {
            System.out.println("Команда синих бойцов: " + person.getClass().getSimpleName() + " " + person.toString());
        }
    }

    public static void createTeam(ArrayList<TemplatePerson> team, int num, boolean start){

        String[] blue_teamnames = {"Mario", "Link", "Master Chief", "Kratos", "Nathan Drake", 
        "Geralt_of_Rivia", "Lara Croft", "Samus Aran", "Solid Snake", "Aloy"};
        String[] red_teamnames = { "John", "Greyhood", "Bo Rai'Cho", "Glaz", "Homer", "Gandalf", "Oleg",
                "Kel'tuzad", "Shikimori", "Kalbasan" };

        int unit = 0;
        
        Random rand = new Random();
        for (int i = 0; i < num; i++) {
            if (start) unit = rand.nextInt(0, 4);
            else unit = rand.nextInt(4, 8);
            switch (unit) {
                case 0:
                    team.add(new Sniper(red_teamnames[i], new Coord(rand.nextInt(0,9), 9)));
                    break;
                case 1:
                    team.add(new Monk(red_teamnames[i], new Coord(rand.nextInt(0,9), 9)));
                    break;
                case 2:
                    team.add(new Rogue(red_teamnames[i], new Coord(rand.nextInt(0,9), 9)));
                    break;
                case 3:
                    team.add(new Peasant(red_teamnames[i], new Coord(rand.nextInt(0,9), 9)));
                    break;
                case 4:
                    team.add(new Wizard(blue_teamnames[i], new Coord(rand.nextInt(0,9), 0)));
                    break;
                case 5:
                    team.add(new Crossbowman(blue_teamnames[i], new Coord(rand.nextInt(0,9), 0)));
                    break;
                case 6:
                    team.add(new Spearman(blue_teamnames[i], new Coord(rand.nextInt(0,9), 0)));
                    break;
                case 7:
                    team.add(new Peasant(blue_teamnames[i], new Coord(rand.nextInt(0,9), 0)));
                    break;
            }
        }
    }
}

package OOP.OOP_3;

import java.util.ArrayList;
import java.util.Random;

import OOP.OOP_3.src.Coord;
import OOP.OOP_3.Heroes.MageClass.Monk;
import OOP.OOP_3.Heroes.MageClass.Wizard;
import OOP.OOP_3.Heroes.MeleeClass.Rogue;
import OOP.OOP_3.Heroes.MeleeClass.Spearman;
import OOP.OOP_3.Heroes.RangeClass.Crossbowman;
import OOP.OOP_3.Heroes.RangeClass.Sniper;
import OOP.OOP_3.Heroes.Peasant;
import OOP.OOP_3.Heroes.TemplatePerson;

public class Program {

    static ArrayList<TemplatePerson> TeamRed = new ArrayList<>();
    static ArrayList<TemplatePerson> TeamBlu = new ArrayList<>();
    static ArrayList<TemplatePerson> all = new ArrayList<>();
    public static void main(String[] args) {

        createTeam(TeamBlu, 10, true); //как в тимфортесс 2
        createTeam(TeamRed, 10, false);

        all.addAll(TeamBlu);
        all.addAll(TeamRed);
        all.sort((o1, o2) -> Integer.compare(o2.initiative, o1.initiative));

        for (TemplatePerson person : TeamRed) {
            System.out.println("Команда красных бойцов: " + person.getClass().getSimpleName() + " " + person.toString());
        }

        for (TemplatePerson person : TeamBlu) {
            System.out.println("Команда синих бойцов: " + person.getClass().getSimpleName() + " " + person.toString());
        }

        for (TemplatePerson p : all)
        {
            System.out.print(p + " ходит. ");
            if (TeamRed.contains(p))
            {
                //добавить проверку на классы ради будущих действий
                p.step(TeamBlu);

            } else {
                p.step(TeamRed);
            }
            System.out.println();
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

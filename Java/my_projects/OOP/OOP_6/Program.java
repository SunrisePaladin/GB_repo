package OOP.OOP_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Collections;

import OOP.OOP_6.src.Coord;
import OOP.OOP_6.Heroes.MageClass.MageHero;
import OOP.OOP_6.Heroes.MeleeClass.MeleeHero;
import OOP.OOP_6.Heroes.RangeClass.RangeHero;
import OOP.OOP_6.Heroes.MageClass.Monk;
import OOP.OOP_6.Heroes.MageClass.Wizard;
import OOP.OOP_6.Heroes.MeleeClass.Rogue;
import OOP.OOP_6.Heroes.MeleeClass.Spearman;
import OOP.OOP_6.Heroes.RangeClass.Crossbowman;
import OOP.OOP_6.Heroes.RangeClass.Gunslinger;

import OOP.OOP_6.src.View;
import OOP.OOP_6.Heroes.Peasant;
import OOP.OOP_6.Heroes.TemplatePerson;

public class Program {
    static Random rand = new Random();
    public static ArrayList<TemplatePerson> TeamRed = new ArrayList<>();
    public static ArrayList<TemplatePerson> TeamBlu = new ArrayList<>();
    public static ArrayList<TemplatePerson> TeamAll = new ArrayList<>();
    protected static int turn = 0;

    public static void main(String[] args) {
        //long s = 5599872; 
        //rand.setSeed(s); 
        createTeam(TeamBlu, 10, true); // как в тимфортесс 2
        createTeam(TeamRed, 10, false);

        TeamAll.addAll(TeamBlu);
        TeamAll.addAll(TeamRed);
        TeamAll.sort((o1, o2) -> Integer.compare(o2.initiative, o1.initiative));

        for (TemplatePerson person : TeamRed) {
            System.out.println("Команда красных бойцов: " + person.getClass().getSimpleName() + " " + person.name);
        }

        for (TemplatePerson person : TeamBlu) {
            System.out.println("Команда синих бойцов: " + person.getClass().getSimpleName() + " " + person.name);
        }

        View.view();
        Scanner ifstream = new Scanner(System.in);
        ifstream.nextLine();

        while (true) {
            turn++;
            for (TemplatePerson p : TeamAll) {
                if (p.isActive == true) System.out.print(p.name + " ходит. ");

                if (TeamRed.contains(p)) {
                    p.step(TeamBlu, TeamRed);
                    switch (turn % 3) {
                        case 0:
                            if (p instanceof MageHero)
                                ((MageHero) p).refresh_mana();
                            if (p instanceof RangeHero)
                                ((RangeHero) p).prepare();
                            if (p instanceof MeleeHero)
                                ((MeleeHero) p).rise_defence();
                            if (p instanceof Peasant)
                                ((Peasant) p).rise_defence();
                            break;
                        case 1:
                            if (p instanceof RangeHero)
                                ((RangeHero) p).longshot(TeamBlu.get(rand.nextInt(0, 9)));
                            if (p instanceof Peasant)
                                ((Peasant) p).hide();
                            break;
                        case 2:
                            if (p instanceof Spearman)
                                ((Spearman) p).throw_spear(TeamBlu.get(rand.nextInt(0, 9)));
                            if (p instanceof Rogue)
                                ((Rogue) p).steal(TeamBlu.get(rand.nextInt(0, 9)));
                            break;
                    }
                } 
                else {
                    p.step(TeamRed, TeamBlu);
                    switch (turn % 3) {
                        case 0:
                            if (p instanceof MageHero)
                                ((MageHero) p).refresh_mana();
                            if (p instanceof RangeHero)
                                ((RangeHero) p).prepare();
                            if (p instanceof MeleeHero)
                                ((MeleeHero) p).rise_defence();
                            if (p instanceof Peasant)
                                ((Peasant) p).rise_defence();
                        case 1:
                            if (p instanceof RangeHero)
                                ((RangeHero) p).longshot(TeamRed.get(rand.nextInt(0, 9)));
                            if (p instanceof Peasant)
                                ((Peasant) p).hide();
                            break;
                        case 2:
                            if (p instanceof Spearman)
                                ((Spearman) p).throw_spear(TeamRed.get(rand.nextInt(0, 9)));
                            if (p instanceof Rogue)
                                ((Rogue) p).steal(TeamRed.get(rand.nextInt(0, 9)));
                    }
                }

                System.out.println();
            }

            View.view();

            String com = ifstream.nextLine();

            if (!isLiving(TeamRed)) {
                System.out.println("Победа синих!");
                break;
            }

            if (!isLiving(TeamBlu)) {
                System.out.println("Победа красных!");
                break;
            }

            if (com == "exit" || com == "e")
                break;
        }

        ifstream.close();
    }

    public static void createTeam(ArrayList<TemplatePerson> team, int num, boolean start) {

        String[] red_teamnames = { "Leon", "Greyhood", "Bo Rai'Cho", "Glaz", "Homer", "Gandalf", "Oleg",
                "Kel'tuzad", "Shikimori", "Kalbasan" };
        String[] blue_teamnames = { "Mario", "Link", "Master Chief", "Kratos", "Nathan Drake",
                "Geralt", "Lara Croft", "Samus Aran", "Solid Snake", "Aloy" };

        ArrayList<String> red_names = new ArrayList<>(Arrays.asList(red_teamnames));
        ArrayList<String> blue_names = new ArrayList<>(Arrays.asList(blue_teamnames));
        Collections.shuffle(red_names);
        Collections.shuffle(blue_names);

        int unit = 0;

        Random rand = new Random();
        for (int i = 0; i < num; i++) {
            if (start)
                unit = rand.nextInt(0, 4);
            else
                unit = rand.nextInt(4, 8);
            switch (unit) {
                case 0:
                    team.add(new Gunslinger(red_names.get(i), new Coord(i, 9)));
                    break;
                case 1:
                    team.add(new Monk(red_names.get(i), new Coord(i, 9)));
                    break;
                case 2:
                    team.add(new Rogue(red_names.get(i), new Coord(i, 9)));
                    break;
                case 3:
                    team.add(new Peasant(red_names.get(i), new Coord(i, 9)));
                    break;
                case 4:
                    team.add(new Wizard(blue_names.get(i), new Coord(i, 0)));
                    break;
                case 5:
                    team.add(new Crossbowman(blue_names.get(i), new Coord(i, 0)));
                    break;
                case 6:
                    team.add(new Spearman(blue_names.get(i), new Coord(i, 0)));
                    break;
                case 7:
                    team.add(new Peasant(blue_names.get(i), new Coord(i, 0)));
                    break;
            }
        }
    }

    private static boolean isLiving(ArrayList<TemplatePerson> team) {
        for (TemplatePerson tmp : team) {
            if (tmp.isActive) {
                return true;
            }
        }
        return false;
    }

}

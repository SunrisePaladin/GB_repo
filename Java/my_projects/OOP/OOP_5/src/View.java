package OOP.OOP_5.src;

import OOP.OOP_5.Program;
import OOP.OOP_5.Design.AnsiColor;
import OOP.OOP_5.Heroes.TemplatePerson;
import java.util.Collections;

public class View {
    private static int step = 1;
    private static int l = 0;
    private static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(9, formatDiv("-b"))) + formatDiv("-c");
    private static final String midl10 = formatDiv("d") + String.join("", Collections.nCopies(9, formatDiv("-e"))) + formatDiv("-f");
    private static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(9, formatDiv("-h"))) + formatDiv("-i");
    private static void tabSetter(int cnt, int max){
        int dif = max - cnt + 2;
        if (dif>0) System.out.printf("%" + dif + "s", ":\t"); else System.out.print(":\t");
    }
    private static String formatDiv(String str) {
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500');
    }
    private static String getChar(int x, int y){
        String out = "| ";
        for (TemplatePerson human: Program.TeamAll) {
            if (human.pos.getX() == x && human.pos.getY() == y){
                if (human.isActive == false) {
                    out = "|" + (AnsiColor.ANSI_RED + human.getInfo().charAt(0) + AnsiColor.ANSI_RESET);
                    break;
                }
                if (Program.TeamRed.contains(human)) out = "|" + (AnsiColor.ANSI_RED + human.getInfo().charAt(0) + AnsiColor.ANSI_RESET);
                if (Program.TeamBlu.contains(human)) out = "|" + (AnsiColor.ANSI_BLUE + human.getInfo().charAt(0) + AnsiColor.ANSI_RESET);
                break;
            }
        }
        return out;
    }
    public static void view() {
        if (step == 1 ){
            System.out.print(AnsiColor.ANSI_BLACK + "First step" + AnsiColor.ANSI_RESET);
        } else {
            System.out.print(AnsiColor.ANSI_BLACK + "Step:" + step + AnsiColor.ANSI_RESET);
        }
        step++;
        Program.TeamAll.forEach((v) -> l = Math.max(l, v.toString().length()));
        System.out.print("_".repeat(l*2));
        System.out.println();
        System.out.print(top10 + "    ");
        System.out.print("Команда синих");
        //for (int i = 0; i < l[0]-9; i++)
        System.out.print(" ".repeat(l-9));
        System.out.println(":\tКоманда красных");
        for (int i = 1; i < 11; i++) {
            System.out.print(getChar(1, i));
        }
        System.out.print("|    ");
        System.out.print(Program.TeamBlu.get(0));
        tabSetter(Program.TeamBlu.get(0).toString().length(), l);
        System.out.println(Program.TeamRed.get(0));
        System.out.println(midl10);

        for (int i = 2; i < 10; i++) {
            for (int j = 1; j < 11; j++) {
                System.out.print(getChar(i, j));
            }
            System.out.print("|    ");
            System.out.print(Program.TeamBlu.get(i-1));
            tabSetter(Program.TeamBlu.get(i-1).toString().length(), l);
            System.out.println(Program.TeamRed.get(i-1));
            System.out.println(midl10);
        }
        for (int j = 1; j < 11; j++) {
            System.out.print(getChar(10, j));
        }
        System.out.print("|    ");
        System.out.print(Program.TeamBlu.get(9));
        tabSetter(Program.TeamBlu.get(9).toString().length(), l);
        System.out.println(Program.TeamRed.get(9));
        System.out.println(bottom10);
    }
}

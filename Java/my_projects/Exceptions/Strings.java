package Exceptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.io.File.*;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Strings {
    // public static HashMap<String, String> struct = new HashMap<String, String>();

    public static int checkUnparsedLine(String[] lines) {
        if (lines.length != 6)  return -1;
        for (int i = 0; i < lines.length; i++) {
            if (lines[i] == "" || lines[i] == " ") return -3;
        }

        //аргументы 0,1,2 - любые

        //аргумент 3 - дата 
        Date date;
        SimpleDateFormat parser = new SimpleDateFormat("dd.MM.yyyy");
        parser.setLenient(false);
        try {
            date = parser.parse(lines[3]);
        }
        catch (ParseException e) {
            System.err.println("Дата не распознана");
            return -2;
        }

        //аргумент 4 - телефон
        try {
            long res = Long.parseLong(lines[4]);
            if (res < 0) throw new NumberFormatException("Меньше 0???");
        }
        catch (NumberFormatException e){
            System.err.println("Телефон не распознан");
            return -2;
        }

        //аргумент 5 - пол
        if (lines[5].equals("f") || lines[5].equals("m")) return 0;
        else{
            System.err.println("Пол не распознан");
            return -2;
        }
    }

    public static int writeProfile(String[] fields) throws Exception {

        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("Фамилия", fields[0]);
        hashMap.put("Имя", fields[1]);
        hashMap.put("Отчество", fields[2]);
        hashMap.put("Дата", fields[3]);
        hashMap.put("Номер телефона", fields[4]);
        hashMap.put("Пол", fields[5]);

        Path currentRelativePath = Paths.get("");
        String fold = currentRelativePath.toAbsolutePath().toString() + "\\" + "People";
        File file = new File(fold);
        if (!file.exists()) {
            file.mkdirs();
            System.err.println("Папка была создана!");
        } 
        else System.out.println("Папка существует");

        String s = fold + "\\" + fields[0] + ".txt";
        File tmp = new File(s);
        boolean append = true;
        if (!tmp.exists()) {
            System.out.println(s);
            append = !append;
            tmp.createNewFile();
            System.err.println("Файл был создан!");
        } 
        else System.out.println("Файл существует");

        try (FileWriter fw = new FileWriter(s, append)) {
            fw.write(hashMap.toString());
            fw.write('\n');
            fw.close();
        } 
        catch (IOException e) {
            System.err.println("Что-то не так с файлом!");
        }

        return 0;
    }

    public static void main(String[] args) throws Exception {
        String[] info;
        System.out.println("Введите данные через пробел");
        Scanner ifstream = new Scanner(System.in);
        while (true) {
            info = ifstream.nextLine().split(" ");
            int res = checkUnparsedLine(info);
            boolean fine = false;
            switch (res) {
                case -3:
                    System.err.println("Ошибка");
                    break;
                case -2:
                    System.err.println("Плохой аргумент найден");
                    break;
                case -1:
                    System.err.println("Неверное количество слов!");
                    break;
                case 0:
                    fine = true;
                    System.out.println("Ok!");
                    break;
            }
            if (fine) writeProfile(info);
            else System.err.println("Ошибка парсинга!");
        }
    }
}

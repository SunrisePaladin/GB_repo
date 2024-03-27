package OOP.OOP_6.Heroes.MeleeClass;

import OOP.OOP_6.src.Coord;
import OOP.OOP_6.Heroes.TemplatePerson;
import java.util.ArrayList;

//типичный класс бойцов ближнего боя

public abstract class MeleeHero extends TemplatePerson {

    public MeleeHero(String name, int health, int attack, int reflectance, int pierce, int defence, int LoS,
            int initiative, Coord pos) {
        super(name, health, attack, reflectance, pierce, defence, LoS, initiative, pos);
    }

    public void rise_defence() {
    };

    public void melee_attack(TemplatePerson target) {
    };

    public void move(TemplatePerson target, ArrayList<TemplatePerson> enemies, ArrayList<TemplatePerson> teammates) {
        ArrayList<Coord> possible_move = new ArrayList<>();
        ArrayList<TemplatePerson> heroes = new ArrayList<>();
        heroes.addAll(enemies);
        heroes.addAll(teammates);
        ArrayList<Coord> heroes_pos = new ArrayList<>();
        for (TemplatePerson tmp : heroes) {
            if (tmp.isActive)
                heroes_pos.add(tmp.pos);
            if (enemies.contains(tmp)) System.out.printf("\n%d %d | %f | %s ", tmp.pos.getX(), tmp.pos.getY(), pos.find_distance(tmp.pos), tmp.name);
        }

        // перебираю точки и смотрю подходящие
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Coord point = new Coord(i, j);
                double dist_to_point = pos.find_distance(point);
                boolean is_clear = true;
                // проверяю 3 условия: клетка свободна, дистанция между персонажами уменьшится и
                // ход в пределах ±1 клетки
                for (Coord c : heroes_pos)
                if (point.equals(c) || dist_to_point > pos.find_distance(target.pos) 
                    || (double)LoS < dist_to_point) {
                    is_clear = false;
                }
                if (is_clear) possible_move.add(point);
            }
        }

        // итоговая точка
        Coord res = null;

        for (Coord p : possible_move) {
            System.out.printf("\n%d %d | %f | %s ", p.getX(), p.getY(), pos.find_distance(p), target.name);
            if (p.find_distance(target.pos) < pos.find_distance(target.pos) && pos.find_distance(p) <= LoS) {
                res = p;
            }
        }

        if (res != null) {
            pos.move_to(res);
        } else {
            System.out.print("Не могу ходить туда. ");
        }
    }

    public TemplatePerson find_enemy(ArrayList<TemplatePerson> enemies, ArrayList<TemplatePerson> teammates) {
        TemplatePerson target = null;
        double nearest = Double.MAX_VALUE;
        for (TemplatePerson enemy : enemies) {
            if (enemy.isActive) {
                if (pos.find_distance(enemy.pos) <= nearest) {
                    nearest = pos.find_distance(enemy.pos);
                    target = enemy;
                }
            }
        }
        if (target == null) {
            return null;
        }
        if (nearest <= (double) LoS) {
            System.out.println("Цель найдена!");
            return target;
        } else {
            System.out.print("Цели вне зоны действия кулаков, выдвигаюсь.");

            // for (int i=0; i < 2; i++)
            move(target, enemies, teammates);

            // boolean is_clear = true;
            // for (int i = 0; i < 2; i++) {
            // if (this.pos.move_direction_x(target.pos)) {
            // int new_x = target.pos.getX() > pos.getX() ? pos.getX() + 1 : pos.getX() - 1;
            // for (TemplatePerson friend : teammates) {
            // if (friend.pos.equals(new Coord(new_x, pos.getY())) && friend.isActive) {
            // is_clear = false;
            // }
            // }
            // for (TemplatePerson enemy : enemies) {
            // if (enemy.pos.equals(new Coord(new_x, pos.getY())) && enemy.isActive) {
            // is_clear = false;
            // }
            // }
            // if (is_clear)
            // pos.move_to(new_x, pos.getY());
            // else {
            // System.out.print(" Там уже занято ");
            // }
            // }
            // else {
            // int new_y = target.pos.getY() > pos.getY() ? pos.getY() + 1 : pos.getY() - 1;
            // for (TemplatePerson friend : teammates) {
            // if (friend.pos.equals(new Coord(pos.getX(), new_y))) {
            // is_clear = false;
            // }
            // }
            // for (TemplatePerson enemy : enemies) {
            // if (enemy.pos.equals(new Coord(pos.getX(), new_y))) {
            // is_clear = false;
            // }
            // }
            // if (is_clear)
            // pos.move_to(pos.getX(), new_y);
            // else{
            // System.out.print("Там уже занято ");
            // }
            // }
            // }
            return null;
        }
    }

    @Override
    public void step(ArrayList<TemplatePerson> enemies, ArrayList<TemplatePerson> teammates) {
        if (!isActive) {
            die("Уже умер");
            return;
        }
        TemplatePerson target = this.find_enemy(enemies, teammates);
        if (target != null) {
            melee_attack(target);
        }
    }
}

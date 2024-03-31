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

    public void rise_defence() {};

    public void melee_attack(TemplatePerson target) {};

    public void move(TemplatePerson target, ArrayList<TemplatePerson> enemies, ArrayList<TemplatePerson> teammates) {
        ArrayList<Coord> possible_move = new ArrayList<>();
        ArrayList<TemplatePerson> heroes = new ArrayList<>();
        heroes.addAll(enemies);
        heroes.addAll(teammates);
        ArrayList<Coord> heroes_pos = new ArrayList<>();
        for (TemplatePerson tmp : heroes) {
            if (tmp.isActive) heroes_pos.add(tmp.pos);
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
                if (point.equals(c) || dist_to_point > pos.find_distance(target.pos) || (double)LoS < dist_to_point) {
                    is_clear = false;
                }
                if (is_clear) possible_move.add(point);
            }
        }

        // итоговая точка
        Coord res = null;
        for (Coord p : possible_move) {
            if (p.find_distance(target.pos) < pos.find_distance(target.pos) && pos.find_distance(p) <= LoS) {
                res = p;
            }
        }
        if (res != null) {
            pos.move_to(res);
        } 
        else {
            logger += "Не могу ходить туда\n";
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
            logger += "Цель найдена!\n";
            return target;
        } 
        else {
            logger += "Цели вне зоны действия кулаков, выдвигаюсь\n";
            move(target, enemies, teammates);
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

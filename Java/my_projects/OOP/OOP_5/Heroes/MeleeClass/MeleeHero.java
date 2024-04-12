package OOP.OOP_5.Heroes.MeleeClass;

import OOP.OOP_5.src.Coord;

import java.util.ArrayList;

import OOP.OOP_5.Heroes.TemplatePerson;
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

    public TemplatePerson find_enemy(ArrayList<TemplatePerson> enemies, ArrayList<TemplatePerson> teammates) {
        TemplatePerson target = null;
        int nearest = Integer.MAX_VALUE;
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
        if (nearest <= LoS) {
            System.out.println("Цель найдена!");
            return target;
        } 
        else {
            System.out.print("Цели вне зоны действия кулаков, выдвигаюсь.");
            boolean is_clear = true;
            // бойцы ближнего боя ходят 2 раза
            for (int i = 0; i < 2; i++) {
                if (this.pos.move_direction_x(target.pos)) {
                    int new_x = target.pos.getX() > pos.getX() ? pos.getX() + 1 : pos.getX() - 1;
                    for (TemplatePerson friend : teammates) {
                        if (friend.pos.equals(new Coord(new_x, pos.getY())) && friend.isActive) {
                            is_clear = false;
                        }
                    }
                    for (TemplatePerson enemy : enemies) {
                        if (enemy.pos.equals(new Coord(new_x, pos.getY())) && enemy.isActive) {
                            is_clear = false;
                        }
                    }
                    if (is_clear)
                        pos.move_to(new_x, pos.getY());
                    else {
                        System.out.print(" Там уже занято");
                    }
                } 
                else {
                    int new_y = target.pos.getY() > pos.getY() ? pos.getY() + 1 : pos.getY() - 1;
                    for (TemplatePerson friend : teammates) {
                        if (friend.pos.equals(new Coord(pos.getX(), new_y))) {
                            is_clear = false;
                        }
                    }
                    for (TemplatePerson enemy : enemies) {
                        if (enemy.pos.equals(new Coord(pos.getX(), new_y))) {
                            is_clear = false;
                        }
                    }
                    if (is_clear)
                        pos.move_to(pos.getX(), new_y);
                    else
                        System.out.print("Там уже занято ");
                }
            }
            return null;
        }
    }

    @Override
    public void step(ArrayList<TemplatePerson> enemies, ArrayList<TemplatePerson> teammates) {
        if (health <= 0) {
            die("Уже умер");
            return;
        }
        TemplatePerson target = this.find_enemy(enemies, teammates);
        if (target != null) {
            melee_attack(target);
        }
    }
}

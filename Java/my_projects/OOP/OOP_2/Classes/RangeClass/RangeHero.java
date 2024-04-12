package OOP.OOP_2.Classes.RangeClass;

import java.util.ArrayList;

import OOP.OOP_2.Classes.Coord;
import OOP.OOP_2.Classes.TemplatePerson;

public abstract class RangeHero extends TemplatePerson{
    protected int ammo;

    public RangeHero(String name, int health, int attack, int reflectance, int pierce, int defence, int LoS, int initiative, Coord pos)
    {
        super(name, health, attack, reflectance, pierce, defence, LoS, initiative, pos);
        ammo = 5;
    }

    public void find_enemy(ArrayList<TemplatePerson> enemies){
        TemplatePerson target = enemies.get(0);
        int nearest = pos.find_distance(target.pos);
        for (TemplatePerson enemy : enemies){
            if (pos.find_distance(enemy.pos) < nearest){
                nearest = pos.find_distance(enemy.pos);
                target = enemy;
            }
        }
        if (nearest <= LoS){
            System.out.println("Цель найдена!");
            range_attack(target);
        }
        else System.out.println("Цели вне зоны стрельбы");
    }

    void range_attack(TemplatePerson target){};
    void prepare(){};
    void longshot(TemplatePerson target){};

    @Override
    public String toString() {
        return name;
    }
}

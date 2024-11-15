package OOP.OOP_4.Heroes.RangeClass;

import java.util.ArrayList;

import OOP.OOP_4.src.Coord;
import OOP.OOP_4.Heroes.TemplatePerson;

public abstract class RangeHero extends TemplatePerson{
    protected int ammo;

    public RangeHero(String name, int health, int attack, int reflectance, int pierce, int defence, int LoS, int initiative, Coord pos)
    {
        super(name, health, attack, reflectance, pierce, defence, LoS, initiative, pos);
        ammo = 5;
    }

    void range_attack(TemplatePerson target){};
    void prepare(){};
    void longshot(TemplatePerson target){};
    
    public TemplatePerson find_enemy(ArrayList<TemplatePerson> enemies){
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
            return target;
        }
        else{
            System.out.println("Цели вне зоны стрельбы");
            return null;
        } 
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void step(ArrayList<TemplatePerson> enemies) {
        if (health <= 0)
        {
            this.die("Уже умер");
            return;
        }
        TemplatePerson target = this.find_enemy(enemies);
        if (target != null)
        {
            range_attack(target);
        }
    }
}

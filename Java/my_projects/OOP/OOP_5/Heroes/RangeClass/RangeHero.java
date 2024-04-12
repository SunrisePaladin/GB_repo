package OOP.OOP_5.Heroes.RangeClass;

import java.util.ArrayList;

import OOP.OOP_5.src.Coord;
import OOP.OOP_5.Heroes.TemplatePerson;

public abstract class RangeHero extends TemplatePerson{
    protected int ammo;

    public RangeHero(String name, int health, int attack, int reflectance, int pierce, int defence, int LoS, int initiative, Coord pos)
    {
        super(name, health, attack, reflectance, pierce, defence, LoS, initiative, pos);
        ammo = 5;
    }

    public void setAmmo(int x){
        ammo = x;
    };

    public int getAmmo(){
        return ammo;
    }
    
    void range_attack(TemplatePerson target){};
    public void prepare(){};
    public void longshot(TemplatePerson target){};
    
    public TemplatePerson find_enemy(ArrayList<TemplatePerson> enemies, ArrayList<TemplatePerson> teammates){
        TemplatePerson target = enemies.get(0);
        int nearest = pos.find_distance(target.pos);
        for (TemplatePerson enemy : enemies){
            if (enemy.isActive == false) continue;
            if (pos.find_distance(enemy.pos) < nearest){
                nearest = pos.find_distance(enemy.pos);
                target = enemy;
            }
        }
        if (nearest <= LoS && target.isActive){
            System.out.println("Цель найдена!");
            return target;
        }
        else if (nearest > LoS){
            System.out.println("Цели вне зоны стрельбы");
            return null;
        } 
        else {
            System.out.println("Все цели в радиусе неактивны");
            return null;
        }
    }

    @Override
    public void step(ArrayList<TemplatePerson> enemies, ArrayList<TemplatePerson> teammates) {
        if (health <= 0)
        {
            die("Уже умер");
            return;
        }
        TemplatePerson target = this.find_enemy(enemies, teammates);
        if (target != null)
        {
            range_attack(target);
        }
    }
    
}

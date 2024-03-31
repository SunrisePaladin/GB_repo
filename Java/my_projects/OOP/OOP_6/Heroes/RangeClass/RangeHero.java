package OOP.OOP_6.Heroes.RangeClass;

import java.util.ArrayList;

import OOP.OOP_6.src.Coord;
import OOP.OOP_6.Heroes.TemplatePerson;

public abstract class RangeHero extends TemplatePerson{
    protected int ammo;

    public RangeHero(String name, int health, int attack, int reflectance, int pierce, int defence, int LoS, int initiative, Coord pos)
    {
        super(name, health, attack, reflectance, pierce, defence, LoS, initiative, pos);
        ammo = 3;
    }

    public void setAmmo(int x){
        ammo = x;
    };

    public int getAmmo(){
        return ammo;
    }

    //использую интерфейс
    void range_attack(TemplatePerson target){}; 
    
    public void prepare(){};
    public void longshot(TemplatePerson target){};
    
    public TemplatePerson find_enemy(ArrayList<TemplatePerson> enemies, ArrayList<TemplatePerson> teammates){
        TemplatePerson target = null;
        double nearest = Double.MAX_VALUE; //pos.find_distance(target.pos);
        for (TemplatePerson enemy : enemies){
            if (enemy.isActive == false) continue;
            if (pos.find_distance(enemy.pos) < nearest){
                nearest = pos.find_distance(enemy.pos);
                target = enemy;
            }
        }
        if (nearest <= LoS && target != null){
            logger += "Цель найдена!\n";
            return target;
        }
        else {
            logger += "Не получется выстрелить!\n";
            return null;
        }
    }

    @Override
    public void step(ArrayList<TemplatePerson> enemies, ArrayList<TemplatePerson> teammates) {
        if (!isActive)
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

package OOP.OOP_6.Heroes;

import java.util.ArrayList;

import OOP.OOP_6.Heroes.MeleeClass.Spearman;
import OOP.OOP_6.Heroes.RangeClass.RangeHero;
import OOP.OOP_6.src.Coord;

public class Peasant extends TemplatePerson{

    public Peasant(String name, Coord pos) {
        super(name, 130, 20, 5, 2, 10,
                1, 0, pos);
    }

    //не используется?
    // public void main_attack(TemplatePerson target) {
    //     int damage = attack * rand.nextInt(1, pierce);
    //     System.out.printf("%s %s готов атаковать на %d\n", this.getClass().getSimpleName(), name);
    //     target.take_damage(damage);
    // }

    @Override
    public void take_damage(int damage) {
        int res_damage = damage * (rand.nextInt(100) < reflectance ? 0 : 1) - 2 * defence; // имеет удвоенную защиту
        if (res_damage <= 0) {
            logger += (this.getClass().getSimpleName() + " " + name + " не получает урона\n");
            res_damage = 0;
        } 
        else {
            health -= res_damage;
            logger += (this.getClass().getSimpleName() + " " + name + " получает урон " + res_damage + "\n");
        }
        if (health <= 0) {
            die("От полученного урона");
        }
    }

    // укрепление
    public void rise_defence() {
        if (defence + 10 <= 30)
            defence += 10;
        if (health + 20 <= healthMax)
            health += 20;
        else
            health = healthMax;
    }

    // скрыться
    public void hide() {
        if (reflectance <= 20)
            reflectance += 5;
        else reflectance = 20;
        if (rand.nextInt(2) == 1) {
            rise_defence();
        }
    }

    @Override
    public void step(ArrayList<TemplatePerson> enemies, ArrayList<TemplatePerson> teammates) {
        if (!isActive) {
            die("Уже умер");
            return;
        }

        ArrayList<RangeHero> shooters = new ArrayList<RangeHero>();
        for (TemplatePerson p: teammates) {
            if (p instanceof RangeHero){
                if (p.isActive) shooters.add((RangeHero)p);
            }
        }

        ArrayList<Spearman> spearmen = new ArrayList<Spearman>();
        for (TemplatePerson p: teammates) {
            if (p instanceof Spearman){
                if (p.isActive) spearmen.add((Spearman)p);
            }
        }

        RangeHero target_range = null;
        Spearman target_spear = null;

        int min_ammo = Integer.MAX_VALUE;

        for (RangeHero rh: shooters) {
            if (rh.getAmmo() < min_ammo)
            min_ammo = rh.getAmmo();
            target_range = rh;
        }
        
        int min_spears = Integer.MAX_VALUE;
        
        for (Spearman sm: spearmen) {
            if (sm.getSpears() < min_spears)
            min_spears = sm.getSpears();
            target_spear = sm;
        }

        if(target_range != null) {
            int new_ammo = target_range.getAmmo()+2;
            target_range.setAmmo(new_ammo);
        }
        else {
            //System.out.println("Не осталось стрелков!");
            logger += ("Не осталось стрелков!\n");
        }

        if(target_spear != null){
            int new_spears = target_spear.getSpears()+1;
            target_spear.setSpears(new_spears);
        }
        else {
            //System.out.println("Не осталось копейщиков!");
            logger += ("Не осталось копейщиков!\n");
        }
    }
}

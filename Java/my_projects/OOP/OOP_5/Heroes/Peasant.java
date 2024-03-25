package OOP.OOP_5.Heroes;

import java.util.ArrayList;
//import java.util.Collections;

import OOP.OOP_5.Heroes.RangeClass.RangeHero;
// import OOP.OOP_5.Heroes.MeleeClass.MeleeHero;
//import OOP.OOP_5.Heroes.MeleeClass.Spearman;
// import OOP.OOP_5.Heroes.MageClass.MageHero;

import OOP.OOP_5.src.Coord;

public class Peasant extends TemplatePerson {

    public Peasant(String name, Coord pos) {
        super(name, 130, 25, 5, 2, 10,
                1, 0, pos);
    }

    void attack(TemplatePerson target) {
        int damage = attack * rand.nextInt(1, pierce);
        System.out.printf("%s %s готов атаковать на %d\n", this.getClass().getSimpleName(), name);
        target.take_damage(damage);
    }

    @Override
    public void take_damage(int damage) {
        int res_damage = damage * (rand.nextInt(100) < reflectance ? 0 : 1) - 2 * defence; // имеет удвоенную защиту
        if (res_damage <= 0) {
            System.out.printf("%s %s не получает урона", this.getClass().getSimpleName(), name, res_damage);
            res_damage = 0;
        } else {
            health -= res_damage;
            System.out.printf("%s %s получает урон %d", this.getClass().getSimpleName(), name, res_damage);
        }
        if (health <= 0) {
            die("От полученного урона");
        }
    }

    // TO DO поменять методы крестьянина в будущем

    // укрепление
    public void rise_defence() {
        if (defence + 10 <= 50)
            defence += 10;
        if (health + 20 <= healthMax)
            health += 20;
        else
            health = healthMax;
    }

    // скрыться
    public void hide() {
        if (reflectance < 20)
            reflectance += 5;
        if (rand.nextInt(2) == 1) {
            rise_defence();
        }
    }

    @Override
    public void step(ArrayList<TemplatePerson> enemies, ArrayList<TemplatePerson> teammates) {
        
        //добавить копья копейщикам!
        int min = Integer.MAX_VALUE;
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

        RangeHero target = null;
        for (RangeHero rh: shooters) {
            if (rh.getAmmo() < min)
            min = rh.getAmmo();
            target = rh;
        }

        if(target != null){
            int new_ammo = target.getAmmo()+1;
            target.setAmmo(new_ammo);
        }
        else System.out.println("Не осталось стрелков!");
    }
}

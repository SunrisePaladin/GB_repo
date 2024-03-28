package OOP.OOP_6.Heroes.RangeClass;

import java.util.HashMap;

import OOP.OOP_6.src.Coord;
import OOP.OOP_6.Heroes.TemplatePerson;

public class Crossbowman extends RangeHero {

    public Crossbowman(String name, Coord pos) {
        super(name, 120, 20, 20, 3, 10,
        10, 3, pos);
    }

    @Override
    public void range_attack(TemplatePerson target){
        if (ammo > 0) {
            int damage = attack * rand.nextInt(2, pierce); // всегда минимум 2 атаки
            logger += (this.getClass().getSimpleName() + " " + name + " готов атаковать на " + damage + "\n");
            //System.out.printf("%s %s готов атаковать на %d \n", this.getClass().getSimpleName(), name, damage);
            target.take_damage(damage);
        }
        else {
            logger += (this.getClass().getSimpleName() + " " + name + " говорит: Не хватает стрел!\n");
            //System.out.printf("%s %s говорит: Не хватает стрел!", this.getClass().getSimpleName(), name);
        }
        //super.range_attack(target);
    }

    // подготовка
    @Override
    public void prepare() {
        if (reflectance < 30) reflectance += 10;
        else reflectance = 30;
        if (pierce +1 <= 5) pierce += 1; else pierce = 5;
        if (LoS +1 <= 15) LoS += 1; else LoS = 15;
        //super.prepare();
    }

    // пробивной выстрел
    public void longshot(TemplatePerson target) {
        boolean chance = rand.nextInt(100) >= target.getStats().get("defence") ? true : false;
        if (chance) {
            HashMap<String, Integer> tmp = target.getStats();
            if (tmp.get("reflectance") - 15 > 0) {
                tmp.replace("reflectance", tmp.get("reflectance") - 15);
                target.change_stats(tmp);
            } 
            else {
                tmp.replace("reflectance", 0);
                target.change_stats(tmp);
            }
        } 
        else {
            logger += ("Пометка неуспешна!\n");
            //System.out.println("Пометка неуспешна!");
        }
        //super.longshot(target);
    }
}

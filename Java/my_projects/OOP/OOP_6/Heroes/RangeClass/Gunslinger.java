package OOP.OOP_6.Heroes.RangeClass;

import java.util.HashMap;

import OOP.OOP_6.src.Coord;
import OOP.OOP_6.Heroes.TemplatePerson;

public class Gunslinger extends RangeHero {

    public Gunslinger(String name, Coord pos) {
        super(name, 100, 20, 10, 3, 10,
        9, 3, pos);
    }

    @Override
    public void range_attack(TemplatePerson target) {
        if (ammo > 0) {
            int damage = attack * rand.nextInt(2, pierce); // всегда минимум 2x атака
            logger += (this.getClass().getSimpleName() + " " + name + " готов атаковать на " + damage + "\n");
            //System.out.printf("%s %s готов атаковать на %d \n", this.getClass().getSimpleName(), name, damage);
            target.take_damage(damage);
        }
        else {
            logger += (this.getClass().getSimpleName() + " " + name + " говорит: Не хватает пуль!\n");
            //System.out.printf("%s %s говорит: Не хватает пуль!", this.getClass().getSimpleName(), name);
        }
        //super.range_attack(target);
    }

    // подготовка
    @Override
    public void prepare() {
        if (reflectance < 40) reflectance += 10; 
        else reflectance = 40;
        if (health + 20 <= healthMax) health += 20;
        else health = healthMax;
        attack += 10;
        if (defence +5 <= 30) defence += 5; else defence = 30;
        //super.prepare();
    }

    // пробивной выстрел
    @Override
    public void longshot(TemplatePerson target) {
        int damage = attack;
        HashMap<String, Integer> tmp = target.getStats();
        if (tmp.get("defence") <= damage) {
            if (tmp.get("defence") - 20 > 0) {
                tmp.replace("defence", tmp.get("defence") - 20);
                target.change_stats(tmp);
                logger += (target.getClass().getSimpleName() + " " + target.name + " потерял защиту!\n");
                //System.out.printf("\n%s %s потерял защиту!", target.getClass().getSimpleName(), target.name);
            } 
            else {
                tmp.replace("defence", 0);
                target.change_stats(tmp);
            }
            target.take_damage(damage);
        }
        else {
            //System.out.printf("Защита %s выдержала выстрел!", target.name);
            logger += ("Защита " + target.getClass().getSimpleName() + " " + target.name + " выдержала выстрел!\n");
            if (pierce + 1 <= 5) pierce += 1;
        }
        //super.longshot(target);
    }
}

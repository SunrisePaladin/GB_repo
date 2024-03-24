package OOP.OOP_4.Heroes.RangeClass;

import java.util.HashMap;

import OOP.OOP_4.src.Coord;
import OOP.OOP_4.Heroes.TemplatePerson;

public class Sniper extends RangeHero {

    public Sniper(String name, Coord pos) {
        super(name, 100, 40, 10, 3, 10,
        9, 3, pos);
    }

    @Override
    public void range_attack(TemplatePerson target) {
        if (ammo > 0) {
            int damage = attack * rand.nextInt(2, pierce); // всегда минимум 2 атаки
            System.out.printf("%s %s готов атаковать на %d \n", this.getClass().getSimpleName(), this.toString(), damage);
            target.take_damage(damage);
        }
        else System.out.printf("%s %s говорит: Не хватает пуль!", this.getClass().getSimpleName(), this.toString());
        //super.range_attack(target);
    }

    // подготовка
    @Override
    public void prepare() {
        if (reflectance < 40) reflectance += 10; 
        else reflectance = 40;
        if (health + 20 <= healthMax) health += 20;
        else health = healthMax;
        //super.prepare();
    }

    // пробивной выстрел
    @Override
    public void longshot(TemplatePerson target) {
        int damage = (int)Math.round((double)attack*0.75);
        HashMap<String, Integer> tmp = target.getStats();
        if (tmp.get("defence") <= damage) {
            if (tmp.get("defence") - 20 > 0) {
                tmp.replace("defence", tmp.get("defence") - 20);
                target.change_stats(tmp);
            } 
            else {
                tmp.replace("defence", 0);
                target.change_stats(tmp);
            }
            target.take_damage(damage);
        }
        else {
            System.out.printf("Защита %s выдержала выстрел!", target.name);
            if (pierce + 1 <= 4) pierce += 1;
        }
        //super.longshot(target);
    }
}

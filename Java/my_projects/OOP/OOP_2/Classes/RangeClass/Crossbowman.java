package OOP.OOP_2.Classes.RangeClass;

import java.util.HashMap;

import OOP.OOP_2.Classes.Coord;
import OOP.OOP_2.Classes.TemplatePerson;

public class Crossbowman extends RangeHero {

    public Crossbowman(String name, Coord pos) {
        super(name, 120, 20, 20, 4, 15,
        6, 3, pos);
    }

    @Override
    public void range_attack(TemplatePerson target){
        if (ammo > 0) {
            int damage = attack * rand.nextInt(1, pierce);
            System.out.printf("%s %s готов атаковать на %d \n", this.getClass().getSimpleName(), this.toString());
            target.take_damage(damage);
        }
        else System.out.printf("%s %s говорит: Не хватает стрел!", this.getClass().getSimpleName(), this.toString());
        super.range_attack(target);
    }

    // подготовка
    @Override
    public void prepare() {
        if (reflectance < 30) reflectance += 10;
        else reflectance = 30;
        if (health + 20 <= healthMax) health += 20;
        else health = healthMax;
        super.prepare();
    }

    // пробивной выстрел
    public void longshot(TemplatePerson target) {
        Boolean chance = rand.nextInt(100) <= target.getStats().get("defence") ? true : false;
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
        else System.out.println("Пометка неуспешна!");
        super.longshot(target);
    }
}

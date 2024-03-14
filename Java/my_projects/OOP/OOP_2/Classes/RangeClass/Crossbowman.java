package OOP.OOP_2.Classes.RangeClass;

import java.util.HashMap;

import OOP.OOP_2.Classes.TemplatePerson;

public class Crossbowman extends TemplatePerson implements RangeHero {
    @Override
    public String toString() {
        return name;
    }

    int arrows = 3;

    public Crossbowman(String name) {
        super(name, 120, 20, 20, 4, 15,
        6, 3);
    }

    public void range_attack(TemplatePerson target) {
        if (arrows > 0) {
            int damage = attack * rand.nextInt(2, pierce); // всегда минимум 2 атаки
            System.out.printf("%s %s готов атаковать на %d \n", this.getClass().getSimpleName(), this.toString());
            target.take_damage(damage);
        }
        else System.out.printf("%s %s говорит: Не хватает стрел!", this.getClass().getSimpleName(), this.toString());
    }

    public void take_damage(int damage) {
        int res_damage = damage * (rand.nextInt(100) < reflectance ? 0 : 1) - defence;
        if (res_damage <= 0) {
            System.out.printf("%s %s не получает урона \n", this.getClass().getSimpleName(), this.toString(),
                    res_damage);
            res_damage = 0;
        } 
        else {
            health -= res_damage;
            System.out.printf("%s %s получает урон %d \n", this.getClass().getSimpleName(), this.toString(),
                    res_damage);
        }
        if (health <= 0) {
            die("От полученного урона");
        }
    }

    // укрыться
    public void prepare() {
        if (reflectance < 30) reflectance += 10;
        else reflectance = 30;
        if (health + 20 <= healthMax) health += 20;
        else health = healthMax;
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
    }
}

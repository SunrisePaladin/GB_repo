package OOP.OOP_3.Heroes.RangeClass;

import java.util.HashMap;

import OOP.OOP_3.Heroes.TemplatePerson;

public class Sniper extends TemplatePerson implements RangeHero {

    @Override
    public String toString() {
        return name;
    }

    public Sniper(String name) {
        super(name, 100, 40, 10, 2, 15,
        9, 3);
    }

    public void range_attack(TemplatePerson target) {
        int damage = this.attack * rand.nextInt(1, pierce);
        System.out.printf("%s %s готов атаковать на %d \n", this.getClass().getSimpleName(), this.toString());
        target.take_damage(damage);
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
        if (reflectance < 40) reflectance += 10; 
        else reflectance = 40;
        if (health + 20 <= healthMax) health += 20;
        else health = healthMax;
    }

    // пометка персонажа
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
    }
}

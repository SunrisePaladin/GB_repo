package OOP.OOP_2.Classes.MeleeClass;

import java.util.HashMap;

import OOP.OOP_2.Classes.Coord;
import OOP.OOP_2.Classes.TemplatePerson;

public class Rogue extends MeleeHero {
    
    public Rogue(String name, Coord pos) {
        super(name, 75, 30, 20, 2, 0,
        2, 2, pos); // высокая атака, нет защиты
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void melee_attack(TemplatePerson target) {
        int damage = attack;
        System.out.printf("%s %s готов атаковать на %d \n", this.getClass().getSimpleName(), this.toString());
        int attacks = rand.nextInt(1, pierce+1); // может быть несколько атак
        for (int i = 0; i < attacks; i++){
            System.out.printf("Атака №{d}", i+1);
            target.take_damage(damage);
        }
        super.melee_attack(target);
    }

    // усиление
    @Override
    public void rise_defence() {
        if (reflectance < 40)
            reflectance += 10;
        else
            reflectance = 40;
        LoS += 1;
        pierce += 1;
        super.rise_defence();
    }

    // кража статистик
    public void steal(TemplatePerson target) {
        Boolean chance = rand.nextInt(100) <= target.getStats().get("reflectance") ? true : false;
        if (chance) {
            HashMap<String, Integer> tmp = target.getStats();
            if (tmp.get("health") - 30 > 0) {
                tmp.replace("health", tmp.get("health") - 30);
                target.change_stats(tmp);
            } 
            else {
                target.die("Ограблен до смерти");
                tmp.replace("health", 0);
                target.change_stats(tmp);
            }
            if (tmp.get("healthMax") - 30 > 0) {
                tmp.replace("healthMax", tmp.get("healthMax") - 30);
                target.change_stats(tmp);
            } 
            else {
                target.die("Ограблен до смерти");
                tmp.replace("health", 0);
                target.change_stats(tmp);
            }
            healthMax += 30;
            health += 30;
        } 
        else System.out.printf("%s %s сообщает: кража неуспешна!", this.getClass().getSimpleName(), name);
    }
}

package OOP.OOP_6.Heroes.MeleeClass;

import java.util.HashMap;

import OOP.OOP_6.src.Coord;
import OOP.OOP_6.Heroes.TemplatePerson;

public class Rogue extends MeleeHero {
    
    public Rogue(String name, Coord pos) {
        super(name, 100, 40, 20, 2, 0,
        1, 2, pos); // высокая атака, нет защиты
    }

    @Override
    public void melee_attack(TemplatePerson target) {
        int damage = attack * rand.nextInt(1, pierce);
        logger += (this.getClass().getSimpleName() + " " + name + " готов атаковать на " + damage + "\n");
        //System.out.printf("%s %s готов атаковать на %d", this.getClass().getSimpleName(), name, damage);
        int attacks = rand.nextInt(1, pierce+2); // может быть несколько атак
        for (int i = 0; i < attacks; i++){
            logger += ("Атака №" + i+1 + "\n");
            //System.out.printf("\nАтака № %d: ", i+1);
            target.take_damage(damage);
        }
        //super.melee_attack(target);
    }

    // усиление
    @Override
    public void rise_defence() {
        if (reflectance < 40)
            reflectance += 10;
        else
            reflectance = 40;
        pierce += 1;
        attack += 10;
        //super.rise_defence();
    }

    // кража статистик
    public void steal(TemplatePerson target) {
        boolean chance = rand.nextInt(100) > target.getStats().get("reflectance") ? true : false;
        if (chance) {
            HashMap<String, Integer> tmp = target.getStats();
            if (tmp.get("health") - 30 > 0) {
                tmp.replace("health", tmp.get("health") - 30);
                target.change_stats(tmp);
            } 
            else {
                target.die("Ограблен до смерти\n");
                tmp.replace("health", 0);
                target.change_stats(tmp);
            }
            if (tmp.get("healthMax") - 30 > 0) {
                tmp.replace("healthMax", tmp.get("healthMax") - 30);
                target.change_stats(tmp);
            } 
            else {
                target.die("Ограблен до смерти\n");
                tmp.replace("health", 0);
                target.change_stats(tmp);
            }
            if (healthMax +10 <= 200) healthMax += 10; else healthMax = 200;
            if (health + 10 < healthMax) health += 10; else health = healthMax;
        } 
        
        else {
            //System.out.println("Кража неуспешна!");
            logger += "Кража неуспешна!\n";
        }
    }
}

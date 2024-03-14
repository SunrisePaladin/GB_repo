package OOP.OOP_2.Classes.MeleeClass;

import java.util.HashMap;

import OOP.OOP_2.Classes.TemplatePerson;

public class Monk extends TemplatePerson implements MeleeHero{

    @Override
    public String toString() {
        return name;
    }

    int mana = 100;
    int manaMax = 100;

    public Monk(String name) {
        super(name, 150, 30, 10, 1, 20,
        1, 1);
    }

    public void melee_attack(TemplatePerson target) {
        int damage = attack;
        System.out.printf("%s %s готов атаковать на %d \n", this.getClass().getSimpleName(), this.toString());
        target.take_damage(damage);
    }

    public void take_damage(int damage) {
        int res_damage = damage * ( rand.nextInt(100)<reflectance?0:1) - defence;
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

    //усиление
    public void rise_defence(){
        if (defence + 15 <= 100) defence += 15; else defence =100; 
        attack += 15;
        if (mana < manaMax) mana += 25;
        if (reflectance + 5 <= 30) reflectance += 5; else reflectance = 30;
    }

    //лечение союзника
    public void cast_spell(TemplatePerson target){
        if (mana >= 50) {
            mana -=50;
            HashMap<String, Integer> tmp = target.getStats();
            if (tmp.get("health")+50 <= tmp.get("healthMax")) tmp.replace("health", health+50);
            else tmp.replace("health", tmp.get("healthMax"));
            target.change_stats(tmp);
            if (health + 50 <= healthMax) health += 50; else health = healthMax;
            System.out.printf("%s %s вылечил %s %s", this.getClass().getSimpleName(), name,
            target.getClass().getSimpleName(), target.name);
        }
        else System.out.printf("У %s %s не хватает маны!", this.getClass().getSimpleName(), name);
    }
}

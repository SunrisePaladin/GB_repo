package OOP.OOP_5.Heroes.MageClass;

import java.util.HashMap;

import OOP.OOP_5.src.Coord;
import OOP.OOP_5.Heroes.TemplatePerson;

public class Monk extends MageHero {

    public Monk(String name, Coord pos) {
        super(name, 150, 30, 10, 2, 20,
                1, 1, pos);
    }

    @Override
    public void magic_attack(TemplatePerson target) {
        int damage = attack;
        System.out.printf("%s %s готов атаковать на %d \n", this.getClass().getSimpleName(), name, damage);
        // target.take_damage(damage);
        // super.magic_attack(target);
    }

    // усиление
    @Override
    public void refresh_mana() {
        if (defence + 15 <= 50)
            defence += 15;
        else
            defence = 50;
        attack += 15;
        if (mana + 5 < manaMax)
            mana += 5;
        else
            mana = manaMax;
        if (reflectance + 5 <= 30)
            reflectance += 5;
        else
            reflectance = 30;
        // super.refresh_mana();
    }

    // лечение союзника
    // @Override
    // public void cast_spell(TemplatePerson target){
    // if (mana >= 50) {
    // mana -=50;
    // HashMap<String, Integer> tmp = target.getStats();
    // if (tmp.get("health")+50 <= tmp.get("healthMax")) tmp.replace("health",
    // health+50);
    // else tmp.replace("health", tmp.get("healthMax"));
    // target.change_stats(tmp);
    // if (health + 50 <= healthMax) health += 50; else health = healthMax;
    // System.out.printf("%s %s вылечил %s %s", this.getClass().getSimpleName(),
    // name,
    // target.getClass().getSimpleName(), target.name);
    // }
    // else System.out.printf("У %s %s не хватает маны!",
    // this.getClass().getSimpleName(), name);
    // //super.cast_spell(target);
    // }

    // новый метод усиления на друга
    @Override
    public void cast_spell(TemplatePerson target) {
        if (mana >= 50) {
            mana -= 50;
            HashMap<String, Integer> tmp = target.getStats();
            if (tmp.get("defence") + 15 <= 100)
                tmp.replace("defence", tmp.get("defence") + 15);
            else
                tmp.replace("defence", 100);
            tmp.replace("attack", tmp.get("attack") + 15);
            target.change_stats(tmp);
            System.out.printf("%s %s усилил %s %s", this.getClass().getSimpleName(), name,
                    target.getClass().getSimpleName(), target.name);
        }
    }
}

package OOP.OOP_6.Heroes.MageClass;

import java.util.HashMap;

import OOP.OOP_6.src.Coord;
import OOP.OOP_6.Heroes.TemplatePerson;

public class Monk extends MageHero {

    public Monk(String name, Coord pos) {
        super(name, 150, 30, 10, 2, 20,
                1, 1, pos);
    }

    @Override
    public void magic_attack(TemplatePerson target) {
        int damage = attack;
        System.out.printf("%s %s готов атаковать на %d\n", this.getClass().getSimpleName(), name, damage);
        target.take_damage(damage);
        // super.magic_attack(target);
    }

    // усиление
    @Override
    public void refresh_mana() {
        if (defence + 5 <= 30)
            defence += 5;
        else
            defence = 30;
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

    // новый метод усиления на друга
    @Override
    public void cast_spell(TemplatePerson target) {
        if (mana >= 50) {
            mana -= 50;
            HashMap<String, Integer> tmp = target.getStats();
            if (tmp.get("defence") + 5 <= 30)
                tmp.replace("defence", tmp.get("defence") + 5);
            else
                tmp.replace("defence", 30);
            tmp.replace("attack", tmp.get("attack") + 15);
            target.change_stats(tmp);
            System.out.printf("%s %s усилил %s %s", this.getClass().getSimpleName(), name,
                    target.getClass().getSimpleName(), target.name);
        }
    }
}

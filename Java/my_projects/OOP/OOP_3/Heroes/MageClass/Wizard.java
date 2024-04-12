package OOP.OOP_3.Heroes.MageClass;

import java.util.HashMap;

import OOP.OOP_3.src.Coord;
import OOP.OOP_3.Heroes.TemplatePerson;


public class Wizard extends MageHero {

    public Wizard(String name, Coord pos) {
        super(name, 120, 35, 10, 2, 0,
        7, 1, pos);
    }

    @Override
    public void magic_attack(TemplatePerson target) {
        int damage = attack;
        System.out.printf("%s %s готов атаковать на %d \n", this.getClass().getSimpleName(), this.toString(), damage);
        target.take_damage(damage);
        super.magic_attack(target);
    }

    // подготовка
    @Override
    public void refresh_mana() {
        if (health + 40 <= healthMax) health += 40;
        else health = healthMax;
        if (mana + 50 <= manaMax) mana += 50;
        super.refresh_mana();
    }

    // проклятье + чёрная магия
    @Override
    public void cast_spell(TemplatePerson target) {
        Boolean chance = rand.nextInt(100) <= target.getStats().get("reflectance") ? true : false;
        if (chance) {
            mana -= 100;

            if (health - 30 > 0) {
                health -= 30;
            } 
            else {
                die("Сожжён своим заклинанием");
                health = 0;
            }

            String s = this.toString() + "проклинает персонажа " + target.toString() + " на ";
            int curse = rand.nextInt(4);
            HashMap<String, Integer> tmp = target.getStats();
            switch (curse) {
                case 0:
                    s += "слабость";
                    if (tmp.get("attack") - 30 > 0) {
                        tmp.replace("attack", tmp.get("attack") - 30);
                        target.change_stats(tmp);
                    } 
                    else {
                        tmp.replace("attack", 0);
                        target.change_stats(tmp);
                    }
                    break;
                case 1:
                    s += "ослабление защиты";
                    if (tmp.get("defence") - 30 > 0) {
                        tmp.replace("defence", tmp.get("defence") - 30);
                        target.change_stats(tmp);
                    } else {
                        tmp.replace("defence", 0);
                        target.change_stats(tmp);
                    }
                    break;
                case 2:
                    s += "замедление";
                    if (tmp.get("speed") - 20 > 10) {
                        tmp.replace("defence", tmp.get("speed") - 20);
                        target.change_stats(tmp);
                    } else {
                        tmp.replace("speed", 10);
                        target.change_stats(tmp);
                    }
                    break;
                case 3:
                    s += "поджог";
                    if (tmp.get("health") - 40 > 0) {
                        tmp.replace("health", tmp.get("health") - 40);
                        target.change_stats(tmp);
                    } else {
                        target.die("Сожжён заклинанием");
                        tmp.replace("health", 0);
                        target.change_stats(tmp);
                    }
                    break;
            }
            System.out.println(s);
        }
        else System.out.println("Противник уклонился от заклинания!");
        super.cast_spell(target);
    }
}
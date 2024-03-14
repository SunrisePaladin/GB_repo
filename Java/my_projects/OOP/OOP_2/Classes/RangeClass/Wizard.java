package OOP.OOP_2.Classes.RangeClass;

import java.util.HashMap;

import OOP.OOP_2.Classes.TemplatePerson;

public class Wizard extends TemplatePerson implements RangeHero {

    @Override
    public String toString() {
        return name;
    }

    int mana = 100;
    int manaMax = 100;

    public Wizard(String name) {
        super(name, 100, 35, 10, 2, 0,
        7, 1);
        mana = 100;
        manaMax = 100;
    }

    public void range_attack(TemplatePerson target) {
        int damage = attack * rand.nextInt(1, pierce);
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
        if (health <= 0)
        {
            die("От полученного урона");
        }
    }

    // подготовка
    public void prepare() {
        if (health + 40 <= healthMax) health += 40;
        else health = healthMax;
        if (mana + 50 <= manaMax) mana += 50;
        if (pierce < 4) pierce += 1;
    }

    // проклятье + чёрная магия
    public void longshot(TemplatePerson target) {
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
            int curse = rand.nextInt(6);
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
    }
}
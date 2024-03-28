package OOP.OOP_6.Heroes.MeleeClass;

import OOP.OOP_6.src.Coord;
import OOP.OOP_6.Heroes.TemplatePerson;

public class Spearman extends MeleeHero {
    private int spears = 3;

    public Spearman(String name, Coord pos) {
        super(name, 150, 20, 10, 2, 20,
                1, 2, pos);
    }

    @Override
    public void melee_attack(TemplatePerson target) {
        int damage = attack * rand.nextInt(1, pierce);
        logger += (this.getClass().getSimpleName() + " " + name + " готов атаковать на " + damage + "\n");
        //System.out.printf("%s %s готов атаковать на %d \n", this.getClass().getSimpleName(), name, damage);
        target.take_damage(damage);
        // super.melee_attack(target);
    }

    // защититься
    @Override
    public void rise_defence() {
        if (pierce < 5)
            pierce += 1;
        if (healthMax + 10 <= 200)
            healthMax += 10;
        else
            healthMax = 200;
        if (defence < 30)
            defence += 5;
        else
            defence = 30;
        // super.rise_defence();
    }

    public void setSpears(int x) {
        spears = x;
    };

    public int getSpears() {
        return spears;
    }

    // кинуть снаряд
    public void throw_spear(TemplatePerson target) {
        int damage = attack;
        if (spears > 1) {
            int num_throws = rand.nextInt(1, spears);
            for (int i = 0; i < num_throws; i++) {
                logger += "Атака копьём №" + i + "\n";
                //System.out.printf("Атака копьём %d\n", i + 1);
                target.take_damage(damage);
                spears -= 1;
            }
        }
    }
}

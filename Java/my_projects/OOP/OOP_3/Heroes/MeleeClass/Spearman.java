package OOP.OOP_3.Heroes.MeleeClass;

import OOP.OOP_3.src.Coord;
import OOP.OOP_3.Heroes.TemplatePerson;

public class Spearman extends MeleeHero {
    public int spears = 3;

    public Spearman(String name, Coord pos) {
        super(name, 150, 15, 30, 2, 20,
        2, 2, pos);
    }

    @Override
    public void melee_attack(TemplatePerson target) {
        if (spears > 0){
            int damage = attack * rand.nextInt(1, pierce);
            System.out.printf("%s %s готов атаковать на %d \n", this.getClass().getSimpleName(), this.toString(), damage);
            target.take_damage(damage);
        }
        else {
            System.out.printf("У %s %s закончились копья! (для ближнего боя тоже)");
        }
        super.melee_attack(target);
    }

    // защититься
    @Override
    public void rise_defence() {
        if (pierce < 5) pierce += 1;
        healthMax += 20;
        defence += 15;
        // spears += 1; под вопросом
        super.rise_defence();
    }

    //кинуть снаряд
    public void throw_spear(TemplatePerson target) {
        int damage = attack;
        if (spears > 0){
            int num_throws = rand.nextInt(1, spears+1);
            for (int i = 0; i < num_throws; i++){
                System.out.printf("Атака копьём №{d}!", i+1);
                target.take_damage(damage);
                spears -= 1;
            }
            if (spears < 0) spears = 0;
        }
    }
}

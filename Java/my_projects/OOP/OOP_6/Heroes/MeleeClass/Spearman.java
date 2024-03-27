package OOP.OOP_6.Heroes.MeleeClass;

import OOP.OOP_6.src.Coord;
import OOP.OOP_6.Heroes.TemplatePerson;

public class Spearman extends MeleeHero {
    public int spears = 3;

    public Spearman(String name, Coord pos) {
        super(name, 150, 20, 10, 2, 20,
        1, 2, pos);
    }

    @Override
    public void melee_attack(TemplatePerson target) {
        if (spears > 0){
            int damage = attack * rand.nextInt(1, pierce);
            System.out.printf("%s %s готов атаковать на %d \n", this.getClass().getSimpleName(), name, damage);
            target.take_damage(damage);
        }
        else {
            System.out.printf("У %s %s закончились копья! (для ближнего боя тоже)", this.getClass().getSimpleName(), name);
        }
        //super.melee_attack(target);
    }

    // защититься
    @Override
    public void rise_defence() {
        if (pierce < 5) pierce += 1;
        healthMax += 20;
        if (defence<30) defence += 5; else defence = 30;
        //super.rise_defence();
    }

    //кинуть снаряд
    public void throw_spear(TemplatePerson target) {
        int damage = attack;
        if (spears > 1){
            int num_throws = rand.nextInt(1, spears);
            System.out.println();
            for (int i = 0; i < num_throws; i++){
                System.out.printf("Атака копьём %d\n", i+1);
                target.take_damage(damage);
                spears -= 1;
            }
        }
    }
}

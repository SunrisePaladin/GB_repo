package OOP.OOP_3.Heroes.MeleeClass;

import OOP.OOP_3.Heroes.TemplatePerson;

public class Spearman extends TemplatePerson implements MeleeHero {

    @Override
    public String toString() {
        return name;
    }

    int spears = 3;

    public Spearman(String name) {
        super(name, 150, 15, 30, 2, 20,
        2, 2);
    }

    public void melee_attack(TemplatePerson target) {
        if (spears > 0){
            int damage = attack * rand.nextInt(1, pierce);
            System.out.printf("%s %s готов атаковать на %d \n", this.getClass().getSimpleName(), this.toString());
            target.take_damage(damage);
        }
        else {
            System.out.printf("У %s %s закончились копья! (для ближнего боя тоже)");
        }
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
        if (health <= 0) {
            die("От полученного урона");
        }
    }

    // защититься
    public void rise_defence() {
        if (pierce < 5) pierce += 1;
        healthMax += 20;
        defence += 15;
        // spears += 1; под вопросом
    }

    public void throw_spear(TemplatePerson target) {
        int damage = attack;
        if (spears > 0){
            int num_throws = rand.nextInt(1, spears+1);
            for (int i = 0; i < num_throws; i++){
                target.take_damage(damage);
                spears -= 1;
            }
            if (spears < 0) spears = 0;
        }
    }
}

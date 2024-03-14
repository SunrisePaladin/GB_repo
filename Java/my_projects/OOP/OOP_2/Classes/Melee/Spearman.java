package OOP.OOP_2.Classes.Melee;

import OOP.OOP_2.Classes.TemplatePerson;

public class Spearman extends TemplatePerson{
    @Override
    public String toString() {
        return name;
    }

    public Spearman(String name) {
        super(name, 150, 40, 15, 30, 1, 20); 
    }

    public void attack(TemplatePerson target) {
        int damage = this.attack * rand.nextInt(1, pierce);
        System.out.printf("%s %s готов атаковать на %d \n", this.getClass().getSimpleName(), this.toString());
        target.take_damage(damage);
    }

    public void take_damage(int damage) {
        int res_damage = damage * ( rand.nextInt(100)<reflectance?0:1) - defence;
        if (res_damage <= 0) {
            System.out.printf("%s %s не получает урона \n", this.getClass().getSimpleName(), this.toString(), res_damage);
            res_damage = 0;
        }
        else{
            if (protection - res_damage >= 0) {
                protection -= res_damage;
            }
            else{
                int diff = res_damage-protection;
                health -= diff;
            }
            System.out.printf("%s %s получает урон %d \n", this.getClass().getSimpleName(), this.toString(), res_damage);
        }
        if (health <= 0) {
            die("От полученного урона");
        }
    }

    //заклинание
    public void cast_spell(){
        if (pierce +1 < 5) pierce += 1; else pierce=5;
        healthMax+=30;
        protectionMax+=30;
        attack += 10;
    }

    //защититься
    public void rise_defence(){
        if (defence + 15 <= 50) defence +=15 ;
        if (reflectance + 10 <= 50) reflectance +=10 ;
    }
}

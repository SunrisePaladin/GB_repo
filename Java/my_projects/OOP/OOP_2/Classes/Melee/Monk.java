package OOP.OOP_2.Classes.Melee;

import OOP.OOP_2.Classes.TemplatePerson;

public class Monk extends TemplatePerson implements MeleeHero{

    @Override
    public String toString() {
        return name;
    }

    public Monk(String name) {
        super(name, 130, 30, 30, 10, 1, 20);
    }

    public void melee_attack(TemplatePerson target) {
        int damage = attack; //монах не бьёт сильно
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

    //усиление
    public void rise_defence(){
        if (defence + 15 <= 100) defence += 15; else defence =100; 
        if (protection + 20 <= protectionMax) protection += 20; else protection = protectionMax;
        attack += 10;
        speed += 15;
    }

    //лечение
    public void cast_spell(){
        healthMax += 25;
        if (health + 50 <= healthMax) health += 50; else health = healthMax;
        protectionMax += 15;
        if (protection + 20 <= protectionMax) protection += 20; else protection = protectionMax;
    }
}

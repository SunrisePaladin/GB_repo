package OOP.OOP_2.Classes.Infantry;

import java.util.HashMap;

import OOP.OOP_2.Classes.TemplatePerson;

public class Wizard extends TemplatePerson{

    @Override
    public String toString() {
        return name;
    }

    public Wizard(String name) {
        super(name, 150, 0, 30, 10, 1, 0);
    }

    public void attack(TemplatePerson target ) {
        int damage = this.attack * rand.nextInt(1, pierce); //монах не бьёт сильно
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

    //чёрная магия
    public void steal(TemplatePerson target){
        Boolean chance = rand.nextInt(100)<=target.getStats().get("reflectance")?true:false;
        if (chance) {
            HashMap<String, Integer> tmp = target.getStats();
            if (tmp.get("protection")-30 > 0){
                tmp.replace("protection", tmp.get("protection")-30);
                target.change_stats(tmp);
            }
            else tmp.replace("protection", 0);
            if (tmp.get("defence")-30 > 0){
                tmp.replace("defence", tmp.get("defence")-30);
                target.change_stats(tmp);
            }
            else tmp.replace("defence", 0);
            if (tmp.get("health")-50 > 0){
                tmp.replace("health", tmp.get("health")-50);
                target.change_stats(tmp);
            }
            else {
                target.die("Сожжён заклинанием");
                tmp.replace("health", 0);
                target.change_stats(tmp);
            }

            //маг получает урон от своего заклинания
            if (health-30 > 0){
                health-=30;
            }
            else {
                die("Сожжён своим заклинанием");
                health = 0;
            }

        }
        else System.out.println("Противник уклонился от заклинания!");
    }

    //лечение
    public void heal(){
        if (health + 40 <= healthMax) health += 40; else health = healthMax;
        if (protection + 40 <= protectionMax) protection += 40; else protection = protectionMax;
    }
}
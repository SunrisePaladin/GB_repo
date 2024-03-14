package OOP.OOP_2.Classes.Melee;

import java.util.HashMap;

import OOP.OOP_2.Classes.TemplatePerson;

public class Rogue extends TemplatePerson implements MeleeHero{
    @Override
    public String toString() {
        return name;
    }

    public Rogue(String name) {
        super(name, 75, 15, 35, 20, 2, 0); //высокая атака, нет защиты
    }

    public void melee_attack(TemplatePerson target) {
        int damage = attack * rand.nextInt(1, pierce); 
        System.out.printf("%s %s готов атаковать на %d \n", this.getClass().getSimpleName(), this.toString());
        int attacks = rand.nextInt(1, 3); //может быть несколько атак
        for (int i=0; i<attacks; i++) target.take_damage(damage);
    }

    public void take_damage(int damage) {
        int res_damage = damage * (rand.nextInt(100)<reflectance?0:1);
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
        if (reflectance < 40) reflectance += 10; else reflectance = 40;
        speed += 10;
        pierce += 1;
    }

    //кража статистик
    public void steal(TemplatePerson target){
        Boolean chance = rand.nextInt(100)<=target.getStats().get("reflectance")?true:false;
        if (chance) {
            HashMap<String, Integer> tmp = target.getStats();
            if (tmp.get("protectionMax")-30 > 0){
                tmp.replace("protectionMax", tmp.get("protectionMax")-30);
                target.change_stats(tmp);
            }
            else tmp.replace("protectionMax", 0);
            if (tmp.get("healthMax")-30 > 0){
                tmp.replace("healthMax", tmp.get("healthMax")-30);
                target.change_stats(tmp);
            }
            else {
                target.die("Ограблен до смерти");
                tmp.replace("health", 0);
                target.change_stats(tmp);
            }
        }
        else System.out.printf("%s %s сообщает: кража неуспешна!", this.getClass().getSimpleName(), name);
    }
}

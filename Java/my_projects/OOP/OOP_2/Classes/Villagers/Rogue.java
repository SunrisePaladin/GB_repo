package OOP.OOP_2.Classes.Villagers;

import java.util.HashMap;

import OOP.OOP_2.Classes.TemplatePerson;

public class Rogue extends TemplatePerson{
    @Override
    public String toString() {
        return name;
    }

    public Rogue(String name) {
        super(name, 75, 15, 35, 20, 2, 0); //высокая атака, нет защиты
    }

    public void attack(TemplatePerson target) {
        int damage = this.attack * rand.nextInt(1, pierce); 
        System.out.printf("%s %s готов атаковать на %d \n", this.getClass().getSimpleName(), this.toString());
        int attacks = rand.nextInt(1, 3); //может быть несколько атак
        for (int i=0; i<attacks; i++) target.take_damage(damage);
    }

    public void take_damage(int damage) {
        int res_damage = this.attack * ( rand.nextInt(100)<reflectance?0:1) - defence;
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
    }

    //усиление
    public void cast_spell(){
        if (reflectance < 30) reflectance += 10; else reflectance = 30;
        if (health + 20 <= healthMax) health+=20; else health = healthMax;
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
        else System.out.println("Кража неуспешна!");
    }
}

package OOP.OOP_2.Classes.Villagers;

import java.util.HashMap;

import OOP.OOP_2.Classes.TemplatePerson;

public class Crossbowman extends TemplatePerson{
    @Override
    public String toString() {
        return name;
    }

    public Crossbowman(String name) {
        super(name, 120, 20, 20, 20, 3, 15); 
    }

    public void attack(TemplatePerson target) {
        int damage = this.attack * rand.nextInt(2, pierce); //всегда минимум 2 атаки
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

    //укрыться
    public void hide(){
        if (reflectance < 30) reflectance += 10; else reflectance = 30;
        if (health + 20 <= healthMax) health+=20; else health = healthMax;
        if (protection + 20 <= protectionMax) protection+=20; else protection = protectionMax;
    }

    //пометка персонажа
    public void longshot(TemplatePerson target){
        Boolean chance = rand.nextInt(100)<=target.getStats().get("defence")?true:false;
        if (chance) {
            HashMap<String, Integer> tmp = target.getStats();
            if (tmp.get("reflectance")-15 > 0){
                tmp.replace("reflectance", tmp.get("reflectance")-15);
                target.change_stats(tmp);
            }
            else {
                tmp.replace("reflectance", 0);
                target.change_stats(tmp);
            }
        }
        else System.out.println("Пометка неуспешна!");
    }
}

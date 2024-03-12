package OOP.OOP_2.Classes.Infantry;

import java.util.HashMap;

import OOP.OOP_2.Classes.TemplatePerson;

public class Sniper extends TemplatePerson{
    @Override
    public String toString() {
        return name;
    }

    public Sniper(String name) {
        super(name, 100, 20, 40, 10, 1, 15); 
    }

    public void attack(TemplatePerson target) {
        int damage = this.attack * rand.nextInt(1, pierce);
        System.out.printf("%s %s готов атаковать на %d \n", this.getClass().getSimpleName(), this.toString());
        target.take_damage(damage);
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

    //укрыться
    public void hide(){
        if (reflectance < 30) reflectance += 10; else reflectance = 30;
        if (health + 20 <= healthMax) health+=20; else health = healthMax;
        if (protection + 20 <= protectionMax) protection+=20; else protection = protectionMax;
    }

    //пометка персонажа
    public void longshot(TemplatePerson target){
        int damage = this.attack * rand.nextInt(1, pierce);
        HashMap<String, Integer> tmp = target.getStats();
        if (tmp.get("protection")<=0) {
            target.take_damage(damage);
        }
        else {
            System.out.println("Защита врага выдержала выстрел!");
            if (pierce+1<4) pierce+=1;
        }
    }
}

package OOP.OOP_3.Heroes;

import java.util.HashMap;
import java.util.Random;

import OOP.OOP_3.src.Coord;
import OOP.OOP_3.src.ActionInterface;

public abstract class TemplatePerson implements ActionInterface{
    public String name;
    public Random rand = new Random();
    protected int health = 100;
    protected int healthMax = 200;
    public boolean isActive = true;

    public Coord pos;

    public int initiative = 0; //право хода
    protected int LoS = 1; //влияет на атаки (line of sight)
    protected int attack = 25; //атака
    protected int reflectance = 10; //шанс отражения
    protected int pierce = 3; //количество атак
    protected int defence = 10; //защита

    public TemplatePerson(String name, Coord pos){
        this.name = name;
        this.pos = pos;
    }

    public TemplatePerson(String name, int health, int attack, int reflectance, int pierce, int defence, int LoS, int initiative, Coord pos) {
        this.name  = name;
        this.health = health;
        this.attack = attack;
        this.reflectance = reflectance;
        this.pierce = pierce;
        this.defence = defence;
        this.LoS = LoS;
        this.initiative = initiative;
        this.pos = pos;
    }
    
    public void die(String reason){
        System.out.printf("%s %s погиб по причине: %s", this.getClass().getSimpleName(), this.toString(), reason);
        isActive = false;
    }

    public void change_stats(HashMap<String, Integer> hm){
        this.health = hm.get("health");
        this.healthMax = hm.get("healthMax");
        this.attack = hm.get("attack");
        this.reflectance = hm.get("reflectance");
        this.pierce = hm.get("pierce");
        this.defence = hm.get("defence");
        this.LoS = hm.get("LoS");
        this.initiative = hm.get("initiative");
    }
    public HashMap<String, Integer> getStats(){
        HashMap<String, Integer> stats = new HashMap<String, Integer>();
        stats.put("health", health);
        stats.put("healthMax", healthMax);
        stats.put("attack", attack);
        stats.put("reflectance", reflectance);
        stats.put("pierce", pierce);
        stats.put("defence", defence);
        stats.put("LoS", LoS);
        stats.put("initiative", initiative);
        return stats;
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
}

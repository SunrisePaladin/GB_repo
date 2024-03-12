package OOP.OOP_2.Classes;

import java.util.HashMap;
import java.util.Random;

public abstract class TemplatePerson {
    public String name;
    public Random rand = new Random();
    protected int health = 200;
    protected int healthMax = 200;
    protected int protection = 50;
    protected int protectionMax = 50;

    protected int attack = 25;
    protected int reflectance = 10;
    protected int pierce = 3;
    protected int defence = 10;

    public TemplatePerson(String name, int health, int healthMax, int protection, int protectionMax, 
    int attack, int reflectance, int pierce, int defence) {
        this.name  = name;

        this.health = health;
        this.healthMax = healthMax;
        this.protection = protection;
        this.protectionMax = protectionMax;
        this.attack = attack;
        this.reflectance = reflectance;
        this.pierce = pierce;
        this.defence = defence;
    }

    public TemplatePerson(String name, int health, int protection, int attack, int reflectance, int pierce, int defence) {
        this.name  = name;

        this.health = health;
        this.protection = protection;
        this.attack = attack;
        this.reflectance = reflectance;
        this.pierce = pierce;
        this.defence = defence;
    }

    public TemplatePerson(String name, int health, int protection){
        this.name  = name;
        this.health = health;
        this.protection = protection;
    }

    public void take_damage(int damage){}
    public void attack(){}
    public void cast_spell(){}
    public void die(String reason){
        System.out.printf("%s %s погиб по причине: %s", this.getClass().getSimpleName(), this.toString(), reason);
    }
    public void change_stats(HashMap<String, Integer> hm){
        this.health = hm.get("health");
        this.healthMax = hm.get("healthMax");
        this.protection = hm.get("protection");
        this.protectionMax = hm.get("protectionMax");
        this.attack = hm.get("attack");
        this.reflectance = hm.get("reflectance");
        this.pierce = hm.get("pierce");
        this.defence = hm.get("defence");
    }
    public HashMap<String, Integer> getStats(){
        HashMap<String, Integer> stats = new HashMap<String, Integer>();
        stats.put("health", health);
        stats.put("healthMax", healthMax);
        stats.put("protection", protection);
        stats.put("protectionMax", protectionMax);
        stats.put("attack", attack);
        stats.put("reflectance", reflectance);
        stats.put("pierce", pierce);
        stats.put("defence", defence);
        return stats;
    }
}

package OOP.OOP_5.Heroes;

import java.util.HashMap;
import java.util.Random;

import OOP.OOP_5.src.Coord;
import OOP.OOP_5.src.ActionInterface;

public abstract class TemplatePerson implements ActionInterface{
    public String name;
    public Random rand = new Random();
    public Coord pos;
    public boolean isActive = true; //менять, когда персонаж уже мёртв

    protected int health = 100;
    protected int healthMax = 200;
    public int initiative; //право хода
    protected int LoS; //влияет на атаки (line of sight)
    protected int attack; //атака
    protected int reflectance; //шанс отражения
    protected int pierce; //количество атак
    protected int defence; //защита

    // public TemplatePerson(String name, Coord pos){
    //     this.name = name;
    //     this.pos = pos;
    // }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append(" ")
        .append(name).append(" H:").append(health).append(" D:").append(defence)
        .append(" I:").append(initiative).append(" A:").append(attack).append(" Pos: ")
        .append(pos.getX()).append(" ").append(pos.getY());
        if (isActive) sb.append(" Awoken");
        else sb.append(" Fallen");
        return sb.toString();
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
        System.out.printf("%s %s погиб по причине: %s", this.getClass().getSimpleName(), name, reason);
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
            System.out.printf("%s %s не получает урона\n", this.getClass().getSimpleName(), name, res_damage);
            res_damage = 0;
        } 
        else {
            health -= res_damage;
            System.out.printf("%s %s получает урон %d\n", this.getClass().getSimpleName(), name, res_damage);
        }
        if (health <= 0) {
            die("От полученного урона");
        }
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName().charAt(0));
        return sb.toString();
    }
    
}

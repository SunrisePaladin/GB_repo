package OOP.OOP_6.Heroes.MageClass;

import OOP.OOP_6.src.Coord;

import java.util.ArrayList;
import java.util.HashMap;

import OOP.OOP_6.Heroes.TemplatePerson;
//данный класс имеет параметр мана,
//а атаки не зависят от параметра pierce

public abstract class MageHero extends TemplatePerson {
    protected int mana;
    protected int manaMax;

    public MageHero(String name, int health, int attack, int reflectance, int pierce, int defence, int LoS,
            int initiative, Coord pos) {
        super(name, health, attack, reflectance, pierce, defence, LoS, initiative, pos);
        mana = 100;
        manaMax = 100;
    }

    public void magic_attack(TemplatePerson target) {
    };

    public void cast_spell(TemplatePerson target) {
    };

    public void refresh_mana() {
    };

    public void heal(TemplatePerson target) {
    };

    // пассивное лечение?
    @Override
    public void step(ArrayList<TemplatePerson> enemies, ArrayList<TemplatePerson> teammates) {
        int min = Integer.MAX_VALUE;
        if (!isActive) {
            die("Уже умер");
            return;
        }
        mana += 5;
        System.out.println("Мана восстанавливается");
        
        TemplatePerson target = null;

        for (TemplatePerson fr : teammates) {
            if (fr.isActive) {
                HashMap<String, Integer> tmp = fr.getStats();
                if (tmp.get("health") <= min) {
                    min = tmp.get("health");
                    target = fr;
                }
            }
        }

        //унаследован от cast_spell лечения монаха
        if (target != null) {
            if (target.isActive) {
                mana -= 50;
                HashMap<String, Integer> tmp = target.getStats();
                if (tmp.get("health") + 20 <= tmp.get("healthMax"))
                    tmp.replace("health", health + 20);
                else
                    tmp.replace("health", tmp.get("healthMax"));
                target.change_stats(tmp);
                if (health + 20 <= healthMax)
                    health += 20;
                else
                    health = healthMax;
                System.out.printf("%s %s вылечил %s %s", this.getClass().getSimpleName(), name,
                        target.getClass().getSimpleName(), target.name);
            }
        }
    }
}

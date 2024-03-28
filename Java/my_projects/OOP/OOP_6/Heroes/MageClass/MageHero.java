package OOP.OOP_6.Heroes.MageClass;

import OOP.OOP_6.src.Coord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import OOP.OOP_6.Heroes.TemplatePerson;
//данный класс имеет параметр мана,
//а атаки не зависят от параметра pierce

public abstract class MageHero extends TemplatePerson {
    protected int mana;
    protected int manaMax;
    protected TemplatePerson target_res = null;

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

    public TemplatePerson find_enemy(ArrayList<TemplatePerson> enemies, ArrayList<TemplatePerson> teammates) {
        TemplatePerson target = enemies.get(0);
        double nearest = pos.find_distance(target.pos);
        for (TemplatePerson enemy : enemies) {
            if (enemy.isActive == false)
                continue;
            if (pos.find_distance(enemy.pos) < nearest) {
                nearest = pos.find_distance(enemy.pos);
                target = enemy;
            }
        }
        if (nearest <= LoS && target.isActive) {
            logger += "Цель найдена\n";
            //System.out.println("Цель найдена!");
            return target;
        } 
        else if (nearest > LoS) {
            logger += "Цели вне зоны действия магии\n";
            //System.out.println("Цели вне зоны действия магии");
            return null;
        } 
        else {
            logger += "Все цели в радиусе неактивны\n";
            //System.out.println("Все цели в радиусе неактивны");
            return null;
        }
    }

    public void heal(TemplatePerson target) {
        if (target != null) {
            if (target.isActive && mana >=30) {
                mana -= 10;
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
                logger += (this.getClass().getSimpleName() + " " + name + " вылечил " + target.getClass().getSimpleName() + " " + target.name +"\n");
                //System.out.printf("%s %s вылечил %s %s\n", this.getClass().getSimpleName(), name, target.getClass().getSimpleName(), target.name);
            }
        }
    }

    @Override
    public void step(ArrayList<TemplatePerson> enemies, ArrayList<TemplatePerson> teammates) {
        int min = Integer.MAX_VALUE;
        if (!isActive) {
            die("Уже умер");
            return;
        }
        if (mana + 10 <= manaMax)
            mana += 10;
        else
            mana = manaMax;
        //System.out.printf("Мана восстанавливается. Сейчас %d маны\n", mana);
        logger += ("Мана восстанавливается. Сейчас " + mana + " маны\n");
        //дружественная цель
        TemplatePerson target_heal = null;
        ArrayList<TemplatePerson> for_res = new ArrayList<TemplatePerson>();
        int body_count = 0;
        for (TemplatePerson fr : teammates) {
            if (fr.isActive) {
                HashMap<String, Integer> tmp = fr.getStats();
                if (tmp.get("health") <= min) {
                    min = tmp.get("health");
                    target_heal = fr;
                }
            }
            else {
                body_count++;
                for_res.add(fr);
            }
        }

        heal(target_heal);

        if (body_count>3){
            Random random = new Random();
            if (target_res == null) target_res = for_res.get(random.nextInt(0, for_res.size()-1));
            if (try_to_awake(target_res)){
                logger += (target_res.getClass().getSimpleName() + " " + target_res.name + " вернулся к нам!\n");
                //System.out.printf("\n%s %s вернулся к нам!", target_res.getClass().getSimpleName(), target_res.name);
                target_res = null;
            } 
            else {
                logger += "Не получилось использовать магию\n";
                //System.out.println("Не получилось использовать магию");
            }
        }

        TemplatePerson target_enemy = this.find_enemy(enemies, teammates);
        if (target_enemy != null)
        {
            magic_attack(target_enemy);
        }
    }

    private boolean try_to_awake(TemplatePerson target) {
        if (mana>=50){
            mana-=50;
            HashMap<String, Integer> tmp = target.getStats();
            tmp.replace("health",tmp.get("healthMax"));
            target.isActive = true;
            return true;
        }
        else return false;
    }
}


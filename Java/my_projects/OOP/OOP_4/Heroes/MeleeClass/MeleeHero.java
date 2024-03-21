package OOP.OOP_4.Heroes.MeleeClass;

import OOP.OOP_4.src.Coord;

import java.util.ArrayList;

import OOP.OOP_4.Heroes.TemplatePerson;
//типичный класс бойцов ближнего боя

public abstract class MeleeHero extends TemplatePerson{

    public MeleeHero(String name, int health, int attack, int reflectance, int pierce, int defence, int LoS, int initiative, Coord pos)
    {
        super(name, health, attack, reflectance, pierce, defence, LoS, initiative, pos);
    }

    public void rise_defence(){};
    public void melee_attack(TemplatePerson target){};

    //помним про LoS = 1
    public TemplatePerson find_enemy(ArrayList<TemplatePerson> enemies){
        TemplatePerson target = enemies.get(0);
        int nearest = pos.find_distance(target.pos);
        for (TemplatePerson enemy : enemies){
            if (pos.find_distance(enemy.pos) < nearest){
                nearest = pos.find_distance(enemy.pos);
                target = enemy;
            }
        }
        if (nearest <= LoS){
            System.out.println("Цель найдена!");
            return target;
        }
        else{
            System.out.print("Цели вне зоны действия кулаков, выдвигаюсь");
            if (this.pos.move_direction_x(target.pos)) {
                pos.move_to(target.pos.getX()>pos.getX()?pos.getX()+1:pos.getX()-1, pos.getY());
            }
            else {
                pos.move_to(pos.getX(), target.pos.getY()>pos.getY()?pos.getY()+1:pos.getY()-1);
            }
            return null;
        } 
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void step(ArrayList<TemplatePerson> enemies) {
        if (health <= 0)
        {
            this.die("Уже умер");
            return;
        }
        TemplatePerson target = this.find_enemy(enemies);
        if (target != null)
        {
            melee_attack(target);
        }
    }
}

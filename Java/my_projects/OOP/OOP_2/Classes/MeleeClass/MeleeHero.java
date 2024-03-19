package OOP.OOP_2.Classes.MeleeClass;

import OOP.OOP_2.Classes.Coord;
import OOP.OOP_2.Classes.TemplatePerson;
//типичный класс бойцов ближнего боя

public abstract class MeleeHero extends TemplatePerson{

    public MeleeHero(String name, int health, int attack, int reflectance, int pierce, int defence, int LoS, int initiative, Coord pos)
    {
        super(name, health, attack, reflectance, pierce, defence, LoS, initiative, pos);
    }

    public void rise_defence(){};
    public void melee_attack(TemplatePerson target){};

    @Override
    public String toString() {
        return name;
    }
}

package OOP.OOP_2.Classes.MageClass;

import OOP.OOP_2.Classes.TemplatePerson;
import OOP.OOP_2.Classes.Coord;
//данный класс имеет параметр мана,
//а атаки не зависят от параметра pierce

public abstract class MageHero extends TemplatePerson{
    protected int mana;
    protected int manaMax;

    public MageHero(String name, int health, int attack, int reflectance, int pierce, int defence, int LoS, int initiative, Coord pos)
    {
        super(name, health, attack, reflectance, pierce, defence, LoS, initiative, pos);
        mana = 100;
        manaMax = 100;
    }

    public void magic_attack(TemplatePerson target){};
    public void cast_spell(TemplatePerson target){};
    public void refresh_mana(){};

    @Override
    public String toString() {
        return name;
    }
}

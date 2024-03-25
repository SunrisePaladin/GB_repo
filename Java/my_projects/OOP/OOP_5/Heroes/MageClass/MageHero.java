package OOP.OOP_5.Heroes.MageClass;

import OOP.OOP_5.src.Coord;

import java.util.ArrayList;

import OOP.OOP_5.Heroes.TemplatePerson;
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
    public void step(ArrayList<TemplatePerson> enemies, ArrayList<TemplatePerson> teammates) {

    }
}

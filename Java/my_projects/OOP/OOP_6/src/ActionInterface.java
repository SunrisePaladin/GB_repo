package OOP.OOP_6.src;

import OOP.OOP_6.Heroes.TemplatePerson;

import java.util.ArrayList;

//Интерфейс взаимодействия персонажей

public interface ActionInterface {
    //Один шаг действия персонажа
    public void step(ArrayList<TemplatePerson> enemies, ArrayList<TemplatePerson> teammates);
}
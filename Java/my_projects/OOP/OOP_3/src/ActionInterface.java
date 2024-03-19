package OOP.OOP_3.src;

import OOP.OOP_3.Heroes.TemplatePerson;

import java.util.ArrayList;

//Интерфейс взаимодействия персонажей

public interface ActionInterface {
    //Один шаг действия персонажа
    void step(ArrayList<TemplatePerson> enemies);
}
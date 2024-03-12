package OOP.OOP_2.Classes.Villagers;

import OOP.OOP_2.Classes.TemplatePerson;

public interface Villager {
    void evade();
    void melee_attack(TemplatePerson target);
    void range_attack(TemplatePerson target);
    void cast_spell();
}

package OOP.OOP_2.Classes.Infantry;

import OOP.OOP_2.Classes.TemplatePerson;

public interface Infantry {
    void cast_spell();
    void cast_spell(TemplatePerson target);
    void melee_attack(TemplatePerson target);
    void range_attack(TemplatePerson target);
}

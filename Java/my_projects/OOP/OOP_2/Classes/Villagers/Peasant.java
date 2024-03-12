package OOP.OOP_2.Classes.Villagers;

import OOP.OOP_2.Classes.TemplatePerson;

public class Peasant extends TemplatePerson{

    @Override
    public String toString() {
        return name;
    }

    public Peasant(String name){
        super(name, 100, 0, 25, 5, 2, 10); 
    }

    public void attack(TemplatePerson target ) {
        int damage = this.attack * rand.nextInt(1, pierce);
        System.out.printf("%s %s готов атаковать на %d \n", this.getClass().getSimpleName(), this.toString());
        target.take_damage(damage);
    }

    public void take_damage(int damage) {
        int res_damage = damage * ( rand.nextInt(100)<reflectance?0:1) - 2 *defence; //имеет удвоенную защиту
        if (res_damage <= 0) {
            System.out.printf("%s %s не получает урона \n", this.getClass().getSimpleName(), this.toString(), res_damage);
            res_damage = 0;
        }
        else{
            if (protection - res_damage >= 0) {
                protection -= res_damage;
            }
            else{
                int diff = res_damage-protection;
                health -= diff;
            }
            System.out.printf("%s %s получает урон %d \n", this.getClass().getSimpleName(), this.toString(), res_damage);
        }
        if (health <= 0) {
            die("От полученного урона");
        }
    }

    //укрепления из всего, что можно найти
    public void rise_defence(){
        if (defence + 15 <= 50) defence +=15 ;
        if (protection + 15 <= protectionMax) protection +=15 ;
    }

    //скрыться в кустах
    public void hide(){
        if (reflectance < 20) reflectance +=5;
        Boolean visible = rand.nextInt(2)>0?false:true;
        if (!visible) {
            rise_defence();
        }
    }
}

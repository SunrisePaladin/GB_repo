package OOP.OOP_2.Classes;

public class Peasant extends TemplatePerson {

    @Override
    public String toString() {
        return name;
    }

    public Peasant(String name) {
        super(name, 100, 25, 5, 2, 10,
        1, 0);
    }

    void attack(TemplatePerson target) {
        int damage = attack * rand.nextInt(1, pierce);
        System.out.printf("%s %s готов атаковать на %d \n", this.getClass().getSimpleName(), this.toString());
        target.take_damage(damage);
    }

    public void take_damage(int damage) {
        int res_damage = damage * (rand.nextInt(100) < reflectance ? 0 : 1) - 2 * defence; // имеет удвоенную защиту
        if (res_damage <= 0) {
            System.out.printf("%s %s не получает урона \n", this.getClass().getSimpleName(), this.toString(),
                    res_damage);
            res_damage = 0;
        } 
        else {
            health -= res_damage;
            System.out.printf("%s %s получает урон %d \n", this.getClass().getSimpleName(), this.toString(),
                    res_damage);
        }
        if (health <= 0)
        {
            die("От полученного урона");
        }
    }

    // укрепление
    public void rise_defence() {
        if (defence + 10 <= 50)
            defence += 10;
        if (health + 20 <= healthMax) health += 20; else health = healthMax;
    }

    // скрыться
    public void hide() {
        if (reflectance < 20) reflectance += 5;
        if (rand.nextInt(2) == 1) {
            rise_defence();
        }
    }
}

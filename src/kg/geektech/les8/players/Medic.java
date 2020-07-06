package kg.geektech.les8.players;

public class Medic extends Hero{

    private int healPoint;

    public Medic(int damage, int health, int healPoint, String name) {
        super(damage, health, SuperAbility.HEAL, name);
        this.healPoint = healPoint;
    }

    public int getHealPoint() {
        return healPoint;
    }

    public void setHealPoint(int healPoint) {
        this.healPoint = healPoint;
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length ; i++) {
            if (heroes[i].getAbility() != SuperAbility.HEAL) {
                heroes[i].setHealth(heroes[i].getHealth() + healPoint);
            }
        }
    }
}

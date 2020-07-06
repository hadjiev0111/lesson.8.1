package kg.geektech.les8.players;

public class Boss extends GameEntity {
    private boolean isStun = false;

    public boolean isStun() {
        return isStun;
    }

    public void setStun(boolean stun) {
        isStun = stun;
    }

    public Boss(int damage, int health) {
        super(damage, health);
    }
}

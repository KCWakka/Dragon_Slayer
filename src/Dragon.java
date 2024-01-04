public class Dragon {
    private int dragonLevel;
    private int dragonHealth;
    public Dragon() {
        dragonHealth = 100;
        dragonLevel = (int) (Math.random() * 3) + 1;
    }

    public int dragonAttack() {
        return dragonLevel * (int) (Math.random() * 10) + 1;
    }

    public boolean dragonIsDead() {
        if (dragonHealth < 0) {
            return true;
        } else {
            return false;
        }
    }
}

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

    public boolean dragonIsDead(int damage) {
        dragonHealth -= damage;
        if (dragonHealth < 0) {
            return true;
        } else {
            return false;
        }
    }
    public String toString() {
        String str = "";
        str += "Dragon's healths: " + Colors.RED + dragonHealth + Colors.RESET;
        str += "\n Dragon's levels: " + Colors.PURPLE + dragonLevel + Colors.RESET;
        return str;
    }
}

public class Dragon {
    private int dragonLevel;
    private int dragonHealth;

    /** Create a dragon with a same health but randomized level
     *
     * @param limitbreak the increase amount of level a dragon can have above 3
     */
    public Dragon(int limitbreak) {
        dragonHealth = 100;
        dragonLevel = (int) (Math.random() * (3 + limitbreak)) + 1;
    }

    /** Return dragon's level for scoring
     * Each dragon give point, however the stronger the dragon is, the more point it give
     * @return dragonLevel
     */
    public int getDragonLevel() {
        return dragonLevel;
    }

    /** Return a value that show much a dragon attack for on te player
     * It a random value times its level
     * @return dragonLevel * (int) (Math.random() * 10) + 1
     */
    public int dragonAttack() {
        return dragonLevel * (int) (Math.random() * 10) + 1;
    }

    /** Deal damage to the dragon's health
     * Check if the dragon is dead by checking its health
     * @param damage the amount of damage the dragon take
     * @return true/false
     */
    public boolean dragonIsDead(int damage) {
        dragonHealth -= damage;
        if (dragonHealth <= 0) {
            return true;
        } else {
            return false;
        }
    }

    /** Return dragon as a string
     * Show dragon's Healths and levels
     * @return str
     */
    public String toString() {
        String str = "";
        str += "Dragon's healths: " + Colors.RED + dragonHealth + Colors.RESET;
        str += "\nDragon's levels: " + Colors.PURPLE + dragonLevel + Colors.RESET;
        return str;
    }
}

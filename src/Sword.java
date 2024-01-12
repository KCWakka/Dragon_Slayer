public class Sword {
    private int attackPower;
    private int dodgeValue;
    private int upgradeValue;

    /** Create the sword class with its base stat
     *
     */
    public Sword() {
        attackPower = 10;
        dodgeValue = 20;
        upgradeValue = 0;
    }

    /** Return the attackPower of the Sword class
     * Used to deal damage to the dragon
     * @return attackPower
     */
    public int getAttackPower() {
        return attackPower;
    }
    /** Return the dodgeValue of the Sword class
     * Used to see of the chance if the attack missed
     * @return dodgeValue
     */
    public int getDodgeValue() {
        return dodgeValue;
    }

    /** Return the amount of time that the sword's stat get change
     * Use to calculate the final score
     * @return upgradeValue
     */
    public int getUpgradeValue() {
        return upgradeValue;
    }

    /** Used to update the stat of the sword and the UpgradeValue by one
     *
     * @param stat use to tell which stat is getting upgraded!
     */
    public void upgradeStat (String stat) {
        stat = stat.toUpperCase();
        if (stat.equals("P")) {
            attackPower += 2;
            System.out.println(Colors.CYAN + "Your sword's attackpower got increase by 2" + Colors.RESET);
        } else if (stat.equals("D")) {
            dodgeValue += 4;
            System.out.println(Colors.CYAN + "Your sword's dodgeValue got increase by 4" + Colors.RESET);
        } else if (stat.equals("B")) {
            attackPower += 1;
            dodgeValue += 2;
            System.out.println(Colors.CYAN + "Your sword's attackpower got increase by 1" + Colors.RESET);
            System.out.println(Colors.CYAN + "Your sword's dodgeValue got increase by 2" + Colors.RESET);
        }
        upgradeValue ++;
    }

    /** Used to return the class as str
     * List the time it got upgrade, attackPower and DodgeValue
     * @return str
     */
    public String toString() {
        String str = Colors.PURPLE + "The amount of time sword have being upgraded: " + upgradeValue + Colors.RESET;
        str += Colors.RED +"\nAttack power: " + attackPower + Colors.RESET;
        str += Colors.BLUE + "\nDodge Chance: " + dodgeValue + "%" + Colors.RESET;
        return str;
    }
}

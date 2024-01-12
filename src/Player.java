public class Player {
    private String playerName;
    private int playerHealth;
    private int playerGold;
    private boolean hasHealthPot;

    /** Create the player class with its base information
     *
     * @param playerName set the playerName
     */
    public Player(String playerName) {
        this.playerName = playerName;
        playerHealth = 100;
        playerGold = 0;
        hasHealthPot = false;
    }

    /** Check if player has a healthPot as a boolean value
     *
     * @return hasHealthPot
     */
    public boolean isHasHealthPot() {
        return hasHealthPot;
    }

    /** Return player's name
     *
     * @return playerName
     */
    public String getPlayerName() {
        return playerName;
    }

    /** Return player's missing Health
     * Use to calculate healing items
     * @return 100 - playerHealth
     */
    public int getPlayerMissingHealth() {
        return 100 - playerHealth;
    }

    /** Return the amount of gold the player has
     *  Used to see if player can upgrade the sword and use for scoring
     * @return playerGold
     */
    public int getPlayerGold() {
        return playerGold;
    }

    /** Setting the hasHealthPot so once it use, it becomes false or once it was gotten it become true
     *
     * @param hasHealthPot to set the hasHealthPot to true or false to see if it was used
     */
    public void setHasHealthPot(boolean hasHealthPot) {
        this.hasHealthPot = hasHealthPot;
    }

    /** Add a number to playerGold base on what happen
     *
     * @param playerGold amount of gold being added
     */
    public void addPlayerGold(int playerGold) {
        this.playerGold += playerGold;
    }

    /** Changing playerHealth base on if player has taken damage or is healing
     *
     * @param health the value that is used to change playerHealth
     */
    public void changePlayerHealth(int health) {
        playerHealth += health;
    }

    /** Return if player is dead or not
     * Use to end the game
     * @return true/false
     */
    public boolean isDead() {
        if (playerHealth <= 0) {
            return true;
        } else {
            return false;
        }
    }

    /** Return player as a String
     * Contain player's name, health, gold and if it have health pot
     * @return str
     */
    public String toString() {
        String str = Colors.CYAN + "Player's name: " + playerName + Colors.RESET;
        str += Colors.RED + "\nPlayer's Health: " + playerHealth + Colors.RESET;
        str += Colors.YELLOW + "\nPlayer's gold: " + playerGold + Colors.RESET;
        str += Colors.GREEN + "\nHas Health Pot: " + hasHealthPot + Colors.RESET;
        return str;
    }
}

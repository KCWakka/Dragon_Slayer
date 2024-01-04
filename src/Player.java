public class Player {
    private String playerName;
    private int playerHealth;
    private int playerGold;
    private boolean hasHealthPot;
    public Player(String playerName) {
        this.playerName = playerName;
        playerHealth = 100;
        playerGold = 0;
        hasHealthPot = false;
    }

    public boolean isHasHealthPot() {
        return hasHealthPot;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public int getPlayerGold() {
        return playerGold;
    }

    public void setHasHealthPot(boolean hasHealthPot) {
        this.hasHealthPot = hasHealthPot;
    }

    public void addPlayerGold(int playerGold) {
        this.playerGold += playerGold;
    }

    public void changePlayerHealth(int health) {
        playerHealth += health;
    }
    public boolean isDead() {
        if (playerHealth < 0) {
            return true;
        } else {
            return false;
        }
    }
}

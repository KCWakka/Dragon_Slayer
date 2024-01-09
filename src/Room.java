public class Room {
    private boolean searchOrNot;
    private int dragonAmount;
    private boolean roomCleared;
    private int roomNumber;
    private String printMessage;
    private Player player;
    private Sword sword;
    private int damageTaken;
    private Dragon dragon;
    public Room(int roomNumber) {
        searchOrNot = false;
        this.roomNumber = roomNumber;
        dragonAmount = (int) (Math.random() * (2 + roomNumber));
        roomCleared = false;
        printMessage = "";
        player = null;
        sword = null;
        damageTaken = 0;
        dragon = new Dragon();
    }

    public void dragonSlayed() {
        dragonAmount--;
        if (dragonAmount == 0) {
            roomCleared = true;
        } else {
            dragon = new Dragon();
        }
    }

    public void searchRoom() {
        if (!searchOrNot) {
            int value = (int) (Math.random() * 10) + 1;
            if (value <= 2) {
                printMessage = Colors.GREEN + "You found a potion!" + Colors.RESET;
                player.setHasHealthPot(true);
                searchOrNot = true;
            } else if (value <= 4) {
                printMessage = Colors.YELLOW + "You found some gold!" + Colors.RESET;
                player.addPlayerGold((int) (Math.random() * 15) + 1);
                searchOrNot = true;
            } else if (value <= 9) {
                printMessage = "You found nothing!";
                searchOrNot = true;
            } else {
                damageTaken = (int) (Math.random() * 10) + 1;
                player.changePlayerHealth(damageTaken);
                printMessage = "You found a trap and injured yourself! You lost " + Colors.RED + damageTaken + "health!" + Colors.RESET;
                searchOrNot = true;
            }
        } else {
            printMessage = "You already have searched this room";
        }
    }
    public void playerHasArrived(Player player, Sword sword) {
        this.player = player;
        this.sword = sword;
        printMessage = "Welcome to Den-" + roomNumber + ", " + player.getPlayerName() + ".";
        printMessage += "\nMenacing aura is surrounding you, as you enter the room!";

    }

    public void useHealthPot() {
        if (player.isHasHealthPot()) {
            printMessage = "You use a health pot and regain";
            int healthGain = player.getPlayerMissingHealth() / 2;
            printMessage += Colors.RED + healthGain + Colors.RESET;
            player.changePlayerHealth(healthGain);
            player.setHasHealthPot(false);
        } else {
            printMessage = "You don't have a health pot to use.";
        }
    }

    public void inspectDragon() {
        printMessage = dragon.toString();
    }
    public void fightDragon() {
        printMessage = Colors.CYAN + player.getPlayerName() + Colors.RESET + " attacked for ";
        damageTaken = sword.getAttackPower() * (int) (Math.random() * 10) + 1;
        printMessage += Colors.RED + damageTaken + Colors.RESET;
        if (!dragon.dragonIsDead(damageTaken)) {
            if ((int) (Math.random() * 100) + 1 >= sword.getDodgeValue()) {
                printMessage += "\nThe dragon land its attacked and dealt ";
                damageTaken = dragon.dragonAttack();
                printMessage += Colors.RED + damageTaken + Colors.RESET;
                player.changePlayerHealth(-damageTaken);
            } else {
                printMessage += "\nThe dragon try to attacked but missed.";
            }
        } else {
            printMessage += Colors.GREEN +"\nYou have killed the dragon before it attacked you. It had drop some loots." + Colors.RESET;
            int chances = (int) (Math.random() * 4) + 1;
            if (chances < 2) {
                printMessage += Colors.YELLOW + "\nIt drop ";
                int gold = (int) (Math.random() * 50) + 1;
                printMessage += gold + " golds." + Colors.RESET;
            } else if (chances < 3) {
                printMessage += Colors.PURPLE + "Your sword got upgraded!" + Colors.RESET;
                chances = (int) (Math.random() * 3) + 1;
                if (chances == 1) {
                    sword.upgradeStat("P");
                } else if (chances == 2) {
                    sword.upgradeStat("D");
                } else {
                    sword.upgradeStat("B");
                }
            } else if (chances < 4) {
                printMessage += Colors.RED + "You regain some of your health." + Colors.RESET;
                player.changePlayerHealth(player.getPlayerMissingHealth()/4);
            } else {
                printMessage += "You got nothing.";
            }
        }
    }
    public String getPrintMessage() {
        return printMessage;
    }
    public String toString() {
        String str = "This Den is filled with many dragons! The total amount of dragon here is: " + Colors.PURPLE + dragonAmount + Colors.RESET;
        return str;
    }
}

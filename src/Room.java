public class Room {
    private boolean searchOrNot;
    private int dragonAmount;
    private boolean roomCleared;
    private int roomNumber;
    private String printMessage;
    private Player player;
    private int damageTaken
    public Room(int roomNumber) {
        searchOrNot = false;
        this.roomNumber = roomNumber;
        dragonAmount = (int) (Math.random() * (2 + roomNumber));
        roomCleared = false;
        printMessage = "";
        this.player = null;
        damageTaken = 0;
    }

    public void dragonSlayed() {
        dragonAmount--;
        if (dragonAmount == 0) {
            roomCleared = true;
        }
    }
    public void refreshRoom() {
        searchOrNot = false;
        dragonAmount = (int) (Math.random() * 4);
        roomCleared = false;
    }

    public void searchRoom() {
        if (!searchOrNot) {
            int value = (int) (Math.random() * 10) + 1;
            if (value <= 2) {
                printMessage = Colors.GREEN + "You found a potion!" + Colors.RESET;
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
    public void playerHasArrived(Player player) {
        this.player = player;
        printMessage = "Welcome to Den-" + roomNumber + ", " + player.getPlayerName() + ".";
        printMessage += "\nMenacing aura is surrounding you, as you enter the room!";

    }
    public String getPrintMessage() {
        return printMessage;
    }
    public String toString() {
        String str =
        return str;
    }
}

public class Room {
    private boolean searchOrNot;
    private int dragonAmount;
    private boolean roomCleared;
    private int roomNumber;
    private String printMessage;
    private Player player;
    public Room(int roomNumber) {
        searchOrNot = false;
        dragonAmount = (int) (Math.random() * 4);
        roomCleared = false;
        this.roomNumber = roomNumber;
        printMessage = "";
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
                printMessage = "You found a potion!";
            }
        } else {
            printMessage = "You already have searched this room";
        }
    }

    public String getPrintMessage() {
        return printMessage;
    }
}

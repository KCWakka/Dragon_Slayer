public class Room {
    private boolean searchOrNot;
    private int dragonAmount;
    private boolean roomCleared;
    private int roomNumber;
    private String printMessage;
    public Room() {
        searchOrNot = false;
        dragonAmount = (int) (Math.random() * 4);
        roomCleared = false;
        roomNumber = 1;
        printMessage = "";
    }

    public void changeRoomNumber() {
        roomNumber++;
    }
    public void dragonSlayed() {
        dragonAmount --;
        if (dragonAmount == 0) {
            roomCleared = true;
        }
    }
    public void refreshRoom() {
        searchOrNot = false;
        dragonAmount = (int) (Math.random() * 4);
        roomCleared = false;
        roomNumber++;
    }

    public void searchRoom() {
        if (!searchOrNot) {
            int value = (int) (Math.random() * 10) + 1;
            if (value <= 2) {

            }
        }
    }
}

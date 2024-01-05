import java.util.Scanner;
public class DragonSlayer {
    private Player player;
    private Sword sword;
    private static final Scanner scan = new Scanner(System.in);
    private Room currentRoom;
    private int roomNumber;


    public DragonSlayer() {
        player = null;
        sword = null;
    }
    public void play() {
        startingGame();
        enterRoom();
    }

    private void startingGame() {
        System.out.println("Enter player's name");
        String name = scan.nextLine();
        player = new Player(name);
        sword = new Sword();
        roomNumber = 0;
    }
    private void enterRoom() {
        roomNumber++;
        currentRoom = new Room(roomNumber);
        currentRoom.playerHasArrived(player);
    }


    private void processChoices(String choices) {

    }

}

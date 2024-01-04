import java.util.Scanner;
public class DragonSlayer {
    private Player player;
    private Sword sword;
    private static final Scanner scan = new Scanner(System.in);
    private Room room;
    private int roomNumber;


    public DragonSlayer() {
        player = null;
        sword = null;
    }
    public void play() {
        startingGame();
        enterRoom();
        showMenu();
    }

    private void startingMenu() {

    }
    private void startingGame() {
        System.out.println("Enter player's name");
        player = new Player(scan.nextLine());
        sword = new Sword();
    }
    private void enterRoom() {

    }

    private void gameMenu() {
        String choices = "";
        while (choices)
    }

    private void processChoices(String choices) {

    }

}

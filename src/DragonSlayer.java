import java.util.Scanner;
public class DragonSlayer {
    private Player player;
    private Sword sword;
    private static final Scanner scan = new Scanner(System.in);
    private Room currentRoom;
    private int roomNumber;
    private int[] top3Score;


    public DragonSlayer() {
        player = null;
        sword = null;
        top3Score = new int[3];
    }
    public void play() {
        startingGame();
        enterRoom();
        gameMenu();
    }

    private void startingGame() {
        System.out.println( Colors.CYAN +"Welcome to the Dragon Slayer game where the goal is to defeat the dungeon by defeat the dragon in each room the dugneon has." + Colors.RESET);
        System.out.println("Some dragon are tougher are other so you can achieve your goals by scavenging for resources and upgrading your sword!");
        System.out.print("Enter player's name: ");
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
    private void gameMenu() {
        String choice = "";
        while (!choice.equals("g")) {
            System.out.println();
            System.out.println(currentRoom.getPrintMessage());
            System.out.println("***");
            System.out.println(player);
            System.out.println(currentRoom);
            System.out.println("(E)nter the next room.");
            System.out.println("(S)earch the room.");
            System.out.println("(F)ight the dragon.");
            System.out.println("(I)nspect the dragon.");
            System.out.println("(U)se health pot.(Only if you have one)");
            System.out.println("(L)ook at your weapon's stat.");
            System.out.println("(B)uy an weapon upgrade!");
            choice = scan.nextLine().toLowerCase();
        }
    }

    private void processChoices(String choices) {

    }

}

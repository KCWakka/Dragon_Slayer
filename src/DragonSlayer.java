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
            System.out.println("(G)ive up on this current run.");
            choice = scan.nextLine().toLowerCase();
            processChoices(choice);
        }
    }

    private void processChoices(String choices) {
        if (choices.equals("e")) {

        } else if (choices.equals("s")) {
            currentRoom.searchRoom();
        } else if (choices.equals("f")) {

        } else if (choices.equals("i")) {

        } else if (choices.equals("u")) {

        } else if (choices.equals("l")) {
            System.out.println(sword);
        } else if (choices.equals("b")) {
            System.out.println("Do you want to upgrade your sword? Each upgrade cost more even if you didn't buy an upgrade.(Y/N): ");
            String choice = scan.nextLine().toLowerCase();
            if (choice.equals("y") && player.getPlayerGold() >= sword.getUpgradeValue() * 10) {
                System.out.println("Select the upgrade you want:\n(P)ower(add attackpower)\n(D)odge(increase your chances of dodging attack)\n(B)oth(you add a bit of attackPower and dodge");
                choice = scan.nextLine().toLowerCase();
                while (!(choice.equals("p") || choice.equals("d") || choice.equals("b"))) {
                    System.out.println("Please select an valid option");
                    choice = scan.nextLine().toLowerCase();
                }
                sword.upgradeStat(choice);
            } else {
                System.out.println("Sorry, you either don't have enough gold or select an invalid option.");
            }
        }
    }

}

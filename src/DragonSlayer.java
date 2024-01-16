import java.util.Scanner;
public class DragonSlayer {
    private Player player;
    private Sword sword;
    private static final Scanner scan = new Scanner(System.in);
    private Room currentRoom;
    private int roomNumber;
    private int[] top3Score;
    private int victory;
    private int victoryCount;

    public DragonSlayer() {
        player = null;
        sword = null;
        top3Score = new int[3];
        victory = 0;
        victoryCount = 0;
    }
    public void play() {
        startingGame();
        enterRoom();
        gameMenu();
    }

    private void startingGame() {
        System.out.println( Colors.CYAN +"Welcome to the Dragon Slayer game where the goal is to defeat the dungeon by defeat the dragon in each room the dugneon has." + Colors.RESET);
        System.out.println("Some dragon are tougher other so you can achieve your goals by scavenging for resources and upgrading your sword!");
        System.out.print("Enter player's name: ");
        String name = scan.nextLine();
        player = new Player(name);
        sword = new Sword();
        roomNumber = 0;
        ConsoleUtility.delay(1000);
    }
    private void enterRoom() {
        boolean newGame = false;
        roomNumber++;
        if (victory > victoryCount) {
            victoryCount++;
            newGame = true;
        }
        currentRoom = new Room(roomNumber, victory, newGame);
        ConsoleUtility.delay(1000);
        currentRoom.playerHasArrived(player, sword);
    }
    private void gameMenu() {
        String choice = "";
        while (!choice.equals("g")) {
            if (player.isDead() || roomNumber == 6) {
                ConsoleUtility.delay(2000);
                ConsoleUtility.clearScreen();
                choice = "g";
            } else {
                if (!choice.equals("b")) {
                    ConsoleUtility.clearScreen();
                }
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
                System.out.println();
                System.out.print("What's your next move? ");
                choice = scan.nextLine().toLowerCase();
                ConsoleUtility.delay(500);
                processChoices(choice);
            }
        }
        if (player.isDead() || roomNumber == 6) {
            endingPhase();
        }
    }

    private void processChoices(String choices) {
        if (choices.equals("e")) {
            ConsoleUtility.delay(500);
            if (currentRoom.leaveRoom()) {
                System.out.println(currentRoom.getPrintMessage());
                player.addPlayerGold(roomNumber * 10);
                System.out.println(Colors.YELLOW + "You gain some gold as you cleared the room!" + Colors.YELLOW);
                enterRoom();
            }
        } else if (choices.equals("s")) {
            ConsoleUtility.delay(500);
            currentRoom.searchRoom();
        } else if (choices.equals("f")) {
            ConsoleUtility.delay(500);
            currentRoom.fightDragon();
        } else if (choices.equals("i")) {
            currentRoom.inspectDragon();
        } else if (choices.equals("u")) {
            ConsoleUtility.delay(500);
            currentRoom.useHealthPot();
        } else if (choices.equals("l")) {
            currentRoom.inspectSword();
        } else if (choices.equals("b")) {
            System.out.println("Do you want to upgrade your sword? The first upgrade of your sword is free! Each upgrade cost more even if you didn't buy an upgrade.(Y/N): ");
            String choice = scan.nextLine().toLowerCase();
            ConsoleUtility.delay(1000);
            while (!choice.equals("y") && !choice.equals("n")) {
                System.out.print("That is a invalid option, please choose again:");
                choice = scan.nextLine().toLowerCase();
            }
            if (choice.equals("y") && player.getPlayerGold() >= sword.getUpgradeValue() * 10) {
                System.out.println("Select the upgrade you want:\n(P)ower(add attackpower)\n(D)odge(increase your chances of dodging attack)\n(B)oth(you add a bit of attackPower and dodge)");
                choice = scan.nextLine().toLowerCase();
                while (!(choice.equals("p") || choice.equals("d") || choice.equals("b"))) {
                    System.out.println("Please select an valid option");
                    choice = scan.nextLine().toLowerCase();
                }
                ConsoleUtility.delay(1000);
                player.addPlayerGold(-sword.getUpgradeValue() * 10);
                sword.upgradeStat(choice);
                System.out.println("Next upgrade cost is " + Colors.YELLOW + sword.getUpgradeValue() * 10 + " golds" + Colors.RESET);
            } else {
                System.out.println("Sorry, you either don't have enough gold or decide not to buy an upgrade.");
            }
        } else if (choices.equals("g")) {
            System.out.println("Goodbye " + Colors.CYAN + player.getPlayerName() + Colors.RESET + ". Hope you have a nice time playing this game. Have a nice day and hope that you play again!");
        } else {
            System.out.println("Yikes that is not an option on the list, please select again!");
        }
    }
    private void endingPhase() {
        setTop3Score(currentRoom.calculateScore("n"));
        ConsoleUtility.delay(1000);
        if (player.isDead()) {
            System.out.println(Colors.CYAN + "Game over, player is dead");
        } else {
            System.out.println(Colors.CYAN + "Game over, you beat the dungeon!");
            victory++;
            currentRoom.setVictory(victory);
        }
        endingPhaseMenu();
    }
    private void endingPhaseMenu() {
        String choice = "";
        while (!choice.equals("l") && !choice.equals("p")) {
            ConsoleUtility.clearScreen();
            System.out.println("(V)iew your top 3's score");
            System.out.println("(S)ee the point breakdown for this run.");
            System.out.println("(P)lay again");
            System.out.println("(L)eave the game");
            System.out.print(Colors.RED + "What is your choices: " + Colors.RESET);
            choice = scan.nextLine().toLowerCase();
            endingPhaseProcessChoices(choice);
        }
    }

    private void endingPhaseProcessChoices(String choice) {
        if (choice.equals("v")) {
            for (int i = 0; i < top3Score.length; i++) {
                ConsoleUtility.delay(1000);
                System.out.println(i + "." + Colors.PURPLE + top3Score[i] + " points" + Colors.RESET);
            }
        } else if (choice.equals("s")) {
            ConsoleUtility.delay(1000);
            currentRoom.calculateScore("y");
        } else if (choice.equals("p")) {
            play();
            ConsoleUtility.delay(1000);
        } else if (choice.equals("l")){
            ConsoleUtility.delay(1000);
            System.out.println("Goodbye " + Colors.CYAN + player.getPlayerName() + Colors.RESET + ". Hope you have a nice time playing this game. Have a nice day and hope that you play again!");
        } else {
            System.out.println("Yikes that is not an option on the list, please select again!");
        }
    }

    private void setTop3Score(int score) {
        for (int i = 0; i < top3Score.length; i++) {
            if (score > top3Score[i]) {
                top3Score[i] = score;
                break;
            }
        }
    }
}

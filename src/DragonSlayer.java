import java.util.Scanner;
public class DragonSlayer {
    private Player player;
    private Sword sword;
    private Scanner scan;
    private Room room;


    public DragonSlayer() {
        scan = new Scanner(System.in);
    }
    public void play() {

    }

    public void startingGame() {
        System.out.println("Enter player's name");
        player = new Player(scan.nextLine());
        sword = new Sword();
    }

}

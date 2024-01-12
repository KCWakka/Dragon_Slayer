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
    private String roomName;
    private int victory;
    private int score;
    private static int dragonScore = 0;
    public Room(int roomNumber, int victory, boolean newGame) {
        searchOrNot = false;
        this.roomNumber = roomNumber;
        dragonAmount = (int) (Math.random() * (1 + roomNumber)) + 1;
        roomCleared = false;
        printMessage = "";
        player = null;
        sword = null;
        damageTaken = 0;
        dragon = new Dragon(victory);
        this.victory = victory;
        if (newGame) {
            dragonScore = 0;
        }
        if (roomNumber < 2) {
            roomName = Colors.YELLOW + "Wyverns' den" + Colors.RESET;
        } else if (roomNumber < 3) {
            roomName = Colors.GREEN +  "Ladons' den" + Colors.RESET;
        } else if (roomNumber < 4) {
            roomName = Colors.BLUE +  "Leviathans' den" + Colors.RESET;
        } else if (roomNumber < 5) {
            roomName = Colors.PURPLE + "Hydras' den" + Colors.RESET;
        } else {
            roomName = Colors.BLACK + "Typhons' den" + Colors.RESET;
        }
    }

    public void dragonSlayed() {
        dragonAmount--;
        if (dragonAmount == 0) {
            roomCleared = true;
        } else {
            dragonScore += dragon.getDragonLevel();
            dragon = new Dragon(victory);
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
                value = (int) (Math.random() * 3) + 1;
                if (value < 3) {
                    printMessage = Colors.YELLOW + "You found some gold!" + Colors.RESET;
                    player.addPlayerGold((int) (Math.random() * 30) + 1);
                } else {
                    printMessage = Colors.YELLOW + "Jackpot! You found a secret sash of the dragon's treausre!";
                    player.addPlayerGold((int) (Math.random() * 40) + 20);
                }
                searchOrNot = true;
            } else if (value <= 9) {
                printMessage = "You found nothing!";
                searchOrNot = true;
            } else {
                damageTaken = (int) (Math.random() * 10) + 1;
                player.changePlayerHealth(damageTaken);
                printMessage = "You found a trap and injured yourself! You lost " + Colors.RED + damageTaken + " health!" + Colors.RESET;
                searchOrNot = true;
            }
        } else {
            printMessage = "You already have searched this room";
        }
    }
    public void playerHasArrived(Player player, Sword sword) {
        this.player = player;
        this.sword = sword;
        printMessage = "Welcome to " + roomName + ", " + player.getPlayerName() + ".";
        if (victory < 1) {
            printMessage += "\nMenacing aura is surrounding you, as you enter the room!";
        } else {
            printMessage += "\n" + Colors.RED + "The dungeon seem to reject your existence. It seem alive as it send you malice aura.";
        }
    }

    public void useHealthPot() {
        if (player.isHasHealthPot()) {
            printMessage = "You use a health pot and regain ";
            int healthGain = player.getPlayerMissingHealth() / 2;
            printMessage += Colors.RED + healthGain + "healths" + Colors.RESET;
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
        if (!roomCleared) {
            printMessage = Colors.CYAN + player.getPlayerName() + Colors.RESET + " attacked for ";
            damageTaken = sword.getAttackPower() * ((int) (Math.random() * 5) + 1);
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
                printMessage += Colors.GREEN + "\nYou have killed the dragon before it attacked you. It had drop some loots." + Colors.RESET;
                dragonSlayed();
                int chances = (int) (Math.random() * 4) + 1;
                if (chances < 2) {
                    printMessage += Colors.YELLOW + "\nIt drop ";
                    int gold = (int) (Math.random() * 50) + 1;
                    printMessage += gold + " golds." + Colors.RESET;
                    player.addPlayerGold(gold);
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
                    player.changePlayerHealth(player.getPlayerMissingHealth() / 4);
                } else {
                    printMessage += "You got nothing.";
                }
            }
        } else {
            printMessage = Colors.CYAN + "You killed all the dragon in the room, there is no more to killed!" + Colors.RESET;
        }
    }
    public String getPrintMessage() {
        return Colors.WHITE + printMessage + Colors.RESET;
    }
    public String toString() {
        String str = "This dungeon have 5 room and is filled with many dragons! You are in " + Colors.CYAN + roomName + Colors.RESET;
        str += " The total amount of dragon here is: " + Colors.PURPLE + dragonAmount + Colors.RESET;
        return str;
    }

    public void inspectSword() {
        printMessage = sword.toString();
    }

    public boolean leaveRoom() {
        if (roomCleared) {
            printMessage = Colors.CYAN + "You entered to the next room of the dungeon" + Colors.RESET;
            return true;
        }
        printMessage = Colors.CYAN + "Sorry you can't leave the den yet, there are still dragon guarding it." + Colors.RESET;
        return false;
    }

    public int calculateScore(String breakdown) {
        if (breakdown.equals("y")) {
            System.out.println(Colors.PURPLE + "Here is the breakdown of your points. There might be some hidden achievement that can boost your scores!" + Colors.RESET);
            ConsoleUtility.delay(1000);
            System.out.println(Colors.GREEN + "You get " + Colors.PURPLE + dragonScore * 3 + Colors.GREEN +" points for the diffcult of each dragon slayed and amount of dragon.");
            System.out.println("You get " + Colors.PURPLE + sword.getUpgradeValue() + Colors.GREEN + " points for upgrading your sword");
            if (sword.getAttackPower() >= 30 || sword.getDodgeValue() >= 60) {
                System.out.print("You get ");
                System.out.print(Colors.PURPLE + (sword.getAttackPower() + sword.getDodgeValue()) * 4);
                System.out.println(Colors.GREEN + " points for breaking a certain stat limit on the sword");
            }
            System.out.println("You get " + Colors.PURPLE + player.getPlayerGold() * 2 + Colors.GREEN + " points for the amount of gold you have.");
            System.out.println("You get " + (100 - player.getPlayerMissingHealth()) * 5 + Colors.GREEN + " points for the amount of health you have at the end of the game!");
            if (player.isHasHealthPot()) {
                System.out.println("You get " + Colors.PURPLE + 50 + Colors.GREEN + " points for having a health pot at the end of the game!");
            }
            System.out.println("You get " + Colors.PURPLE + victory * 150 + Colors.GREEN + " points for each victory you have!" + Colors.RESET);
        } else {
            score += dragonScore * 3;
            score += sword.getUpgradeValue();
            if (sword.getAttackPower() >= 30 || sword.getDodgeValue() >= 60) {
                score += (sword.getAttackPower() + sword.getDodgeValue()) * 4;
            }
            score += player.getPlayerGold() * 2;
            score += (100 - player.getPlayerMissingHealth()) * 5;
            score += victory * 150;
            if (player.isHasHealthPot()) {
                score += 50;
            }
        }
        return score;
    }
    public void setVictory(int victory) {
        this.victory = victory;
    }
}

public class Sword {
    private int attackPower;
    private int dodgeValue;
    private int upgradeValue;
    public Sword() {
        attackPower = 100;
        dodgeValue = 20;
        upgradeValue = 0;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getDodgeValue() {
        return dodgeValue;
    }
    public int getUpgradeValue() {
        return upgradeValue;
    }

    public void upgradeStat (String stat) {
        stat = stat.toUpperCase();
        if (stat.equals("P")) {
            attackPower += 2;
            System.out.println(Colors.CYAN + "Your sword's attackpower got increase by 2" + Colors.RESET);
        } else if (stat.equals("D")) {
            dodgeValue += 4;
            System.out.println(Colors.CYAN + "Your sword's dodgeValue got increase by 4" + Colors.RESET);
        } else if (stat.equals("B")) {
            attackPower += 1;
            dodgeValue += 2;
            System.out.println(Colors.CYAN + "Your sword's attackpower got increase by 1" + Colors.RESET);
            System.out.println(Colors.CYAN + "Your sword's dodgeValue got increase by 2" + Colors.RESET);
        }
        upgradeValue ++;
    }

    public String toString() {
        String str = Colors.PURPLE + "The amount of time sword have being upgraded: " + upgradeValue + Colors.RESET;
        str += Colors.RED +"\nAttack power: " + attackPower + Colors.RESET;
        str += Colors.BLUE + "\nDodge Chance: " + dodgeValue + "%" + Colors.RESET;
        return str;
    }
}

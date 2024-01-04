public class Sword {
    private int attackPower;
    private int dodgeValue;
    private int upgradeValue;
    public Sword() {
        attackPower = 10;
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
        stat.toUpperCase();
        if (stat.equals("P")) {
            attackPower += 2;
        } else if (stat.equals("D")) {
            dodgeValue += 4;
        } else if (stat.equals("B")) {
            attackPower += 1;
            dodgeValue += 2;
        }
        upgradeValue ++;
    }
}

package kg.geektech.les8.game;

import kg.geektech.les8.players.*;

public class RPG_Game {
    public static void start() {
        Boss boss = new Boss(50, 5000);
        Warrior warrior = new Warrior(15, 250, "Warrior");
        Magic magic = new Magic(15, 250, "Joldow-Alladin");
        Medic medic = new Medic(0, 230, 20, "Aibolit");
        Medic youngMedic = new Medic(0, 260, 5, "Med brat");
        Hunter hunter = new Hunter(25, 270, "Hunter");
        Thor thor = new Thor(20, 240, "God of thunder");

        Hero[] heroes = {warrior, magic, medic, youngMedic, hunter, thor};

        printStatistics(boss, heroes);
        while (!isGameFinished(boss, heroes)) {
            round(boss, heroes);
        }
    }

    private static void round(Boss boss, Hero[] heroes) {
        if (boss.getHealth() > 0) {
            if (boss.isStun()) {
                heroesHit(boss, heroes);
                heroesApplySuperAbilities(boss, heroes);
                boss.setStun(false);
            } else {
                bossHit(boss, heroes);
                heroesHit(boss, heroes);
                heroesApplySuperAbilities(boss, heroes);
            }
        }
        printStatistics(boss, heroes);
    }

    private static void bossHit(Boss boss, Hero[] heroes) {
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                hero.setHealth(hero.getHealth() - boss.getDamage());
            }
        }
    }

    private static void heroesHit(Boss boss, Hero[] heroes) {
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && boss.getHealth() > 0) {
                boss.setHealth(boss.getHealth() - hero.getDamage());
            }
        }
    }

    private static void heroesApplySuperAbilities(Boss boss, Hero[] heroes) {
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                hero.applySuperAbility(boss, heroes);
            }
        }
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("_______________");
        System.out.println("Boss health: " + boss.getHealth());
        for (Hero hero : heroes) {
            System.out.println(hero.getName() + " health: " + hero.getHealth());

        }
        System.out.println("_______________");
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes wos!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }
}

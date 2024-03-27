import java.util.ArrayList;
import java.util.Scanner;

class teamTest {
    public static void main(String[] args) {

        Manager manager = new Manager();
        Team team1 = new Team(manager);
        Batter batter1 = new Batter();
        team1.addPlayer(batter1);
        Batter batter2 = new Batter();
        team1.addPlayer(batter2);
        Batter pitcher1 = new Batter();
        team1.addPlayer(pitcher1);
        Batter pitcher2 = new Batter();
        team1.addPlayer(pitcher2);

        Team team2 = new Team(manager);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Team 1 or 2? Select 1 or 2: ");
        int teamNum = scanner.nextInt();
        Team selectedTeam = new Team(manager);
        if (teamNum == 1) {
            selectedTeam = team1;
        } else {
            selectedTeam = team2;
        }

        System.out.print("What do you want to do? ");
        System.out.println("1. Get number of players on team");
        System.out.println("2. Get select player informatiom");
        System.out.println("3. Add a player");
        System.out.println("4. Remove a player");
        System.out.println("5. Replace the manager");
        System.out.println("6. Get team batting average");
        System.out.println("7. Get team home runs");
        System.out.println("8. Get team ERA");
        System.out.println("9. Get team strikeouts");
        System.out.println("10. Get team salary");
        System.out.println("11. Get team value");

        int answer = scanner.nextInt();
        // Team selectedTeam =;
        switch (answer) {
            case 1:
                selectedTeam.getNumPlayers();
                break;
            case 2:
                System.out.print("What is the players name: ");
                String name = scanner.next();
                selectedTeam.getPlayer(name);
                break;
            case 3:
                System.out.print("What type of player? 1 for batter 2 for pitcher: ");
                int typePlayer = scanner.nextInt();
                if (typePlayer == 1) {
                    Batter nPlayer = new Batter();
                    selectedTeam.addPlayer(nPlayer);
                } else {
                    Pitcher nPlayer = new Pitcher();
                    selectedTeam.addPlayer(nPlayer);
                }
                break;
            case 4:
                System.out.println("What player do you want to remove? ");
                name = scanner.next();
                selectedTeam.removePlayer(selectedTeam.getPlayer(name));
            case 5:
                selectedTeam.replaceManager(manager);
                break;
            case 6:
                selectedTeam.battingAverage();
                break;
            case 7:
                selectedTeam.homeRuns();
                break;
            case 8:
                selectedTeam.ERA();
                break;
            case 9:
                selectedTeam.strikeouts();
                break;
            case 10:
                selectedTeam.salary();
                break;
            case 11:
                selectedTeam.getValue();
                break;
            default:
                break;
        }

    }
}

class Team {
    ArrayList<Player> players;
    Manager manager;
    int numPitchers;
    int numBatters;

    public Team(Manager _manager) {

        players = new ArrayList<Player>();
        manager = _manager;
        numPitchers = 0;
        numBatters = 0;
    }

    public Manager getManager() {
        return manager;
    }

    public int getNumPitchers() {
        return numPitchers;
    }

    public int getNumBatters() {
        return numBatters;
    }

    public int getNumPlayers() {
        return players.size();
    }

    public Player getPlayer(String name) {
        for (int i = 0; i < getNumPlayers(); i++) {
            String playerName = players.get(i).getName();
            if (name.equals(playerName)) {
                return players.get(i);

            }
        }
        return null;
    }

    public void addPlayer(Player newPlayer) {
        players.add(newPlayer);

    }

    public void removePlayer(Player newPlayer) {
        players.remove(newPlayer);
    }

    public void replaceManager(Manager newManager) {
        manager = newManager;
    }

    public double battingAverage() {
        int totalHits = 0;
        for (int i = 0; i < getNumPlayers(); i++) {
            totalHits += players.get(i).hits();
        }
        int totalBats = 0;
        for (int i = 0; i < getNumPlayers(); i++) {
            totalBats += players.get(i).bats();
        }

        return (double) totalHits / totalBats;
    }

    public int homeRuns() {
        int homeRuns = 0;
        for (int i = 0; i < getNumPlayers(); i++) {
            homeRuns += players.get(i).homeRuns();
        }
        return homeRuns;
    }

    public double ERA() {
        int totalEarned = 0;
        for (int i = 0; i < getNumPlayers(); i++) {
            totalEarned += players.get(i).earnedRuns();
        }
        int totalInnings = 0;
        for (int i = 0; i < getNumPlayers(); i++) {
            totalInnings += players.get(i).innings();
        }
        return (double) totalEarned / totalInnings;
    }

    public int strikeouts() {
        int strikeouts = 0;
        for (int i = 0; i < getNumPlayers(); i++) {
            strikeouts += players.get(i).strikeouts();
        }
        return strikeouts;
    }

    public double salary() {
        int totalSalary = 0;
        for (int i = 0; i < getNumPlayers(); i++) {
            totalSalary += players.get(i).getSalary();
        }
        totalSalary += manager.getSalary();
        return totalSalary;
    }

    public double getValue() {
        double totalValue = 0;
        for (int i = 0; i < players.size(); i++) {

            totalValue += players.get(i).getValue();
        }
        double value = totalValue / getNumPlayers();
        return value;
    }

    public String toString() {
        String s = "";
        return s;
    }

}

abstract class Employee {
    String name;
    double salary;
    int years;

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getYears() {
        return years;
    }

    public String toString() {
        return "Name: " + name + "\tSalary: " + salary + "\tYears: " + years;
    }
}

class Manager extends Employee {
    int careerWins;
    int careerGames;

    public Manager() {
        // super(name);
        careerWins = 0;
        careerGames = 0;
    }

    public int getWins() {
        return careerWins;
    }

    public int getGames() {
        return careerGames;
    }

    public void yearlyUpdate(int numGames, int numWins) {
        careerGames += numGames;
        careerWins += numWins;
    }

    public double careerWinPercent() {
        return careerWins / careerGames;
    }

    public String toString() {
        String s = super.toString() + " Career wins: " + careerWins + "\tCareer games: " + careerGames;
        return s;
    }
}

abstract class Player extends Employee {
    int numGames;

    public int getGames() {
        return numGames;
    }

    public int hits() {
        return 0;
    }

    public int bats() {
        return 0;
    }

    public int innings() {
        return 0;
    }

    public int homeRuns() {
        return 0;
    }

    public int earnedRuns() {
        return 0;
    }

    public int strikeouts() {
        return strikeouts();
    }

    public void yearlyUpdate(int _numGames) {
        numGames += _numGames;
    }

    abstract double getValue();

    public String toString() {
        return " Games: " + numGames;
    }
}

class Pitcher extends Player {
    int innings;
    int earnedRuns;
    int strikeouts;

    public Pitcher() {
        innings = 0;
        earnedRuns = 0;
        strikeouts = 0;
    }

    public int getInnings() {
        return innings;
    }

    public int getEarnedRuns() {
        return earnedRuns;
    }

    public int getStrikeouts() {
        return strikeouts;
    }

    public void yearlyUpdate(int numGames, int _innings, int _earnedRuns, int _strikeouts) {
        super.numGames += numGames;
        innings += _innings;
        earnedRuns += _earnedRuns;
        strikeouts += _strikeouts;
    }

    public double ERA() {
        return (9 * earnedRuns) / innings;
    }

    public double getValue() {
        return ((ERA() - 2) / 3) + ((strikeouts - 200) / 200);
    }

    public String toString() {
        String s = "Games: " + super.numGames + "\tInnings: " + innings + "\tEarned Runs: " + earnedRuns
                + "\tStrikeouts: " + strikeouts;
        return s;
    }

}

class Batter extends Player {
    int bats;
    int homeRuns;
    int hits;

    public Batter() {
        bats = 0;
        homeRuns = 0;
        hits = 0;
    }

    public void yearlyUpdate(int numGames, int _bats, int _homeRuns, int _hits) {
        super.numGames += numGames;
        bats += _bats;
        homeRuns += _homeRuns;
        hits += _hits;
    }

    public double battingAverage() {
        return hits / bats;
    }

    public double getValue() {
        return ((battingAverage() - 0.3) / 0.3) + ((homeRuns - 40) / 40);
    }

    public String toString() {
        String s = "Games: " + super.numGames + "\tBats: " + bats + "\tHome Runs: " + homeRuns + "\tHits: " + hits;
        return s;
    }
}
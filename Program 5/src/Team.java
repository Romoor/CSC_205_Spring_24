import java.util.ArrayList;
import java.util.Scanner;

class teamTest {
    public static void main(String[] args) {
        System.out.println("\nTeam Program");
        System.out.println("Make and change a baseball team\n");

        Manager manager = new Manager("Jake Manajer", 75000, 9, 75, 103);
        Team team1 = new Team(manager);
        Batter batter1 = new Batter("Lewis Radler", 60000, 3, 15, 60, 7, 34);
        team1.addPlayer(batter1);
        Batter batter2 = new Batter("Rodney Mack", 90000, 7, 42, 231, 23, 172);
        team1.addPlayer(batter2);
        Pitcher pitcher1 = new Pitcher("Paul Gradney", 82000, 6, 30, 120, 18, 49);
        team1.addPlayer(pitcher1);
        Pitcher pitcher2 = new Pitcher("Mitch Gradney", 82000, 6, 32, 122, 20, 51);
        team1.addPlayer(pitcher2);

        Team team2 = new Team(manager);
        Scanner scanner = new Scanner(System.in);
        Boolean quitLoop = false;
        while (!quitLoop) {
            System.out.println("Team Manager Platform");
            System.out.print("Do you wish to edit team 1 or 2? Select 1 or 2: ");
            int teamNum = scanner.nextInt();
            while (teamNum != 1 && teamNum != 2) {
                System.out.println("Invalid input. Select 1 or 2: ");
                teamNum = scanner.nextInt();
            }
            Team selectedTeam = new Team(manager);
            if (teamNum == 1) {
                selectedTeam = team1;
            } else {
                selectedTeam = team2;
            }

            System.out.println("What do you want to do? ");
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
            System.out.println("12. Replace current team with new team");
            System.out.println("13. Get manager");
            System.out.println("14. Get number of Pitchers");
            System.out.println("15. Get number of Batters");
            System.out.println("16. Get list of players");
            System.out.println("17. Quit");

            int answer = scanner.nextInt();
            scanner.nextLine();
            // Team selectedTeam =;
            switch (answer) {
                case 1:
                    System.out.println("Number of Players: " + selectedTeam.getNumPlayers());
                    break;
                case 2:
                    System.out.println("What is the player's full name: ");
                    String name = scanner.nextLine();
                    // System.out.println(name);
                    Player gotPlayer = selectedTeam.getPlayer(name);
                    if (gotPlayer == null) {
                        System.out.println("That player is not a memeber of the team");
                    } else {
                        System.out.println(gotPlayer.toString());
                    }
                    break;
                case 3:
                    System.out.print("What type of player? 1 for batter 2 for pitcher: ");
                    int typePlayer = scanner.nextInt();
                    scanner.nextLine();
                    if (typePlayer == 1) {
                        System.out.print("Name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Salary: ");
                        double salary = scanner.nextDouble();
                        System.out.print("Years: ");
                        int years = scanner.nextInt();
                        System.out.print("Games: ");
                        int games = scanner.nextInt();
                        System.out.print("Bats: ");
                        int bats = scanner.nextInt();
                        System.out.print("Home Runs: ");
                        int homeRuns = scanner.nextInt();
                        System.out.print("Hits: ");
                        int hits = scanner.nextInt();
                        Batter nPlayer = new Batter(newName, salary, years, games, bats, homeRuns, hits);
                        selectedTeam.addPlayer(nPlayer);
                    } else {
                        System.out.print("Name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Salary: ");
                        double salary = scanner.nextDouble();
                        System.out.print("Years: ");
                        int years = scanner.nextInt();
                        System.out.print("Games: ");
                        int games = scanner.nextInt();
                        System.out.print("Innings: ");
                        int innings = scanner.nextInt();
                        System.out.print("Earned Runs: ");
                        int earnedRuns = scanner.nextInt();
                        System.out.print("Strikeouts: ");
                        int strikeouts = scanner.nextInt();
                        Pitcher nPlayer = new Pitcher(newName, salary, years, games, innings, earnedRuns,
                                strikeouts);
                        selectedTeam.addPlayer(nPlayer);
                    }
                    break;
                case 4:
                    System.out.println("What player do you want to remove? ");
                    name = scanner.nextLine();
                    Player remPlayer = selectedTeam.getPlayer(name);
                    selectedTeam.removePlayer(remPlayer);
                    // add plaer tostring?
                    System.out.println("Removed " + remPlayer);
                    break;
                case 5:
                    System.out.print("New manager name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Salary: ");
                    double salary = scanner.nextDouble();
                    System.out.print("Years: ");
                    int years = scanner.nextInt();
                    System.out.print("Career Wins: ");
                    int careerWins = scanner.nextInt();
                    System.out.print("Career Games: ");
                    int careerGames = scanner.nextInt();

                    Manager newManager = new Manager(newName, salary, years, careerWins, careerGames);
                    selectedTeam.replaceManager(newManager);
                    System.out.println("New manager:" + selectedTeam.getManager());
                    break;
                case 6:
                    System.out.println("Batting Average: " + selectedTeam.battingAverage());
                    break;
                case 7:
                    System.out.println("Home Runs: " + selectedTeam.homeRuns());
                    break;
                case 8:
                    System.out.println("ERA: " + selectedTeam.ERA());
                    break;
                case 9:
                    System.out.println("Strikeouts: " + selectedTeam.strikeouts());
                    break;
                case 10:
                    System.out.println("Salary: " + selectedTeam.salary());
                    break;
                case 11:
                    System.out.println("Value: " + selectedTeam.getValue());
                    break;
                case 12:
                    System.out.print("New Manager name: ");
                    newName = scanner.nextLine();
                    System.out.print("New Manager salary: ");
                    salary = scanner.nextDouble();
                    System.out.print("New Manager years: ");
                    years = scanner.nextInt();
                    System.out.print("New Manager career wins: ");
                    careerWins = scanner.nextInt();
                    System.out.print("New Manager career games: ");
                    careerGames = scanner.nextInt();
                    Manager newManager2 = new Manager(newName, salary, years, careerWins, careerGames);
                    Team nTeam = new Team(newManager2);
                    if (teamNum == 1) {
                        team1 = nTeam;
                    } else {
                        team2 = nTeam;
                    }
                    selectedTeam = nTeam;
                    break;
                case 13:
                    System.out.println(selectedTeam.getManager());
                    break;
                case 14:
                    System.out.println(selectedTeam.getNumPitchers() + " pitchers");
                    break;
                case 15:
                    System.out.println(selectedTeam.getNumBatters() + " batters");
                    break;
                case 16:
                    ArrayList<Player> playersList = selectedTeam.getPlayers();
                    for (int i = 0; i < playersList.size(); i++) {
                        System.out.println(playersList.get(i) + "\n");
                    }
                    break;
                case 17:
                    quitLoop = true;
                    break;
                default:
                    System.out.println("Not an option");
                    break;
            }
            System.out.println();

        }
        System.out.println("Goodbye!");

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

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Manager getManager() {
        return manager;
    }

    public int getNumPitchers() {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i) instanceof Pitcher) {
                numPitchers++;
            }
        }
        return numPitchers;
    }

    public int getNumBatters() {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i) instanceof Batter) {
                numBatters++;
            }
        }
        return numBatters;
    }

    public int getNumPlayers() {
        return players.size();
    }

    public Player getPlayer(String name) {
        String playerName = "";
        int i = 0;
        while (!name.equals(playerName) && i < players.size()) {
            playerName = players.get(i).getName();
            // System.out.println("Player name loop: " + playerName);
            // System.out.println("get name: " + name + " current name" + playerName);
            if (name.equals(playerName)) {
                // System.out.println("Player: " + playerName);
                return players.get(i);
            }
            i++;
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
            // System.out.println("total hits loop called");
            totalHits += players.get(i).hits();
        }
        // System.out.println("Total hits: " + totalHits);
        int totalBats = 0;
        for (int i = 0; i < getNumPlayers(); i++) {
            totalBats += players.get(i).bats();
        }
        // System.out.println("Total bats: " + totalBats);
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
        for (int i = 0; i < players.size(); i++) {
            // System.out.println(players.get(i).earnedRuns() + " runs");
            totalEarned += players.get(i).earnedRuns();
        }
        int totalInnings = 0;
        for (int i = 0; i < getNumPlayers(); i++) {
            // System.out.println(players.get(i).innings() + " innings");
            totalInnings += players.get(i).innings();
        }
        double ERA = (double) totalEarned / totalInnings;
        // System.out.println("era: " + ERA);
        return ERA;
    }

    public int strikeouts() {
        int strikeouts = 0;
        for (int i = 0; i < players.size(); i++) {
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
        String s = "Players: ";
        for (int i = 0; i < players.size(); i++) {
            s += players.get(i).getName() + "\n";
        }
        s += "Manager" + manager + "\nNumber of Pitchers" + numPitchers + "\nNumber of Batters" + numBatters;
        return s;
    }

}

abstract class Employee {
    String name;
    double salary;
    int years;

    public Employee(String _name, double _salary, int _years) {
        name = _name;
        salary = _salary;
        years = _years;
    }

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
        return "Name: " + name + "\tSalary: " + salary + "\t\tYears: " + years;
    }
}

class Manager extends Employee {
    int careerWins;
    int careerGames;

    public Manager(String _name, double _salary, int _years, int _careerWins, int _careerGames) {
        super(_name, _salary, _years);
        careerWins = _careerWins;
        careerGames = _careerGames;
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
        String s = super.toString() + "\tCareer wins: " + careerWins + "\tCareer games: " + careerGames;
        return s;
    }
}

abstract class Player extends Employee {
    int numGames;

    public Player(String _name, double _salary, int _years, int _numGames) {
        super(_name, _salary, _years);
        numGames = _numGames;
    }

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
        return 0;
    }

    public void yearlyUpdate(int _numGames) {
        numGames += _numGames;
    }

    abstract double getValue();

    public String toString() {
        return super.toString() + "\tGames: " + numGames;
    }
}

class Pitcher extends Player {
    int innings;
    int earnedRuns;
    int strikeouts;

    public Pitcher(String _name, double _salary, int _years, int _numGames, int _innings, int _earnedRuns,
            int _strikeouts) {
        super(_name, _salary, _years, _numGames);
        innings = _innings;
        earnedRuns = _earnedRuns;
        strikeouts = _strikeouts;
    }

    public int innings() {
        return innings;
    }

    public int earnedRuns() {
        return earnedRuns;
    }

    public int strikeouts() {
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
        String s = super.toString() + "\tInnings: " + innings + "\t\tEarned Runs: "
                + earnedRuns
                + "\tStrikeouts: " + strikeouts;
        return s;
    }

}

class Batter extends Player {
    int bats;
    int homeRuns;
    int hits;

    public Batter(String _name, double _salary, int _years, int _numGames, int _bats, int _homeRuns,
            int _hits) {
        super(_name, _salary, _years, _numGames);
        bats = _bats;
        homeRuns = _homeRuns;
        hits = _hits;
    }

    public void yearlyUpdate(int numGames, int _bats, int _homeRuns, int _hits) {
        super.numGames += numGames;
        bats += _bats;
        homeRuns += _homeRuns;
        hits += _hits;
    }

    public int years() {
        return years;
    }

    public int numGames() {
        return numGames;
    }

    public int bats() {
        return bats;
    }

    public int homeRuns() {
        return homeRuns;
    }

    public int hits() {
        return hits;
    }

    public double battingAverage() {
        return hits / bats;
    }

    public double getValue() {
        return ((battingAverage() - 0.3) / 0.3) + ((homeRuns - 40) / 40);
    }

    public String toString() {
        String s = super.toString() + "\tBats: " + bats + "\tHome Runs: " + homeRuns + "\tHits: " + hits;
        return s;
    }
}
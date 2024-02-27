public class soccerPlayer {
    private String name;
    private String team;
    private int gamesPlayed;
    private int goalsScored;

    public soccerPlayer(String _name, String _team) {
        name = _name;
        team = _team;
        gamesPlayed = 0;
        goalsScored = 0;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public int getGames() {
        return gamesPlayed;
    }

    public int getGoals() {
        return goalsScored;
    }

    public double averageGoals() {
        return (double) goalsScored / gamesPlayed;
    }

    public void updateGoals(int newGoals) {
        goalsScored += newGoals;
        gamesPlayed++;
    }

    public void setTeam(String newTeam) {
        team = newTeam;
    }

    public String toString() {
        return "\nName: " + name + "\nTeam: " + team + "\nGames: " + gamesPlayed + "\nGoals: " + goalsScored;
    }

}

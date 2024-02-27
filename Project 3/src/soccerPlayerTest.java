public class soccerPlayerTest {
    public static void main(String[] args) {
        soccerPlayer Ronaldo = new soccerPlayer("Cristiano Ronaldo", "Manchester United");
        System.out.println(Ronaldo.toString());

        Ronaldo.updateGoals(3);
        Ronaldo.updateGoals(2);
        System.out.println("Average Goals: " + Ronaldo.averageGoals());
        System.out.println("Current Team: " + Ronaldo.getTeam());
        Ronaldo.setTeam("Al Nassr");
        System.out.println(Ronaldo.toString());

    }
}

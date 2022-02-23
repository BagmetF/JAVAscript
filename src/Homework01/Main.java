package Homework01;

import Homework01.Actions.JumpAction;
        import Homework01.Actions.PlayerAction;
        import Homework01.Actions.RunAction;
        import Homework01.Actions.SwimAction;
        import Homework01.Actions.CrawlAction;
import Homework01.Obstacles.Obstacle;
        import Homework01.Obstacles.Pool;
        import Homework01.Obstacles.Racetrack;
        import Homework01.Obstacles.Wall;
        import Homework01.Obstacles.BarbedWire;
        import java.util.Random;

public class Main {
    private static final int POOL_DISTANCE = 100;
    private static final int RACETRACK_DISTANCE = 100;
    private static final int WALL_DISTANCE = 5;
    private static final int BARBEDWIRE_DISTANCE = 7;

    public static void main(String[] args) {

        Course course = new Course(makeObstacles());
        Player[] players = makePlayers();
        Team team = new Team("GeekBrains", players);
        team.printAllPlayers();
        course.doIt(team);
        team.printWinners();
    }

    public static Obstacle[] makeObstacles() {
        return new Obstacle[]{
                new Pool(POOL_DISTANCE),
                new Racetrack(RACETRACK_DISTANCE),
                new Wall(WALL_DISTANCE),
                new BarbedWire(BARBEDWIRE_DISTANCE)
        };
    }

    public static Player[] makePlayers() {
        return new Player[] {
                new Player("Петя", new PlayerAction[] { getSwimAction(), getJumpAction(), getCrawlAction() }),
                new Player("Ваня", new PlayerAction[] { getRunAction(), getCrawlAction()}),
                new Player("Аня", new PlayerAction[] { getRunAction(), getJumpAction(), getSwimAction() }),
                new Player("Лена", new PlayerAction[] { getSwimAction(), getCrawlAction() }),
                new Player("Фёдор", new PlayerAction[] { getSwimAction(), getCrawlAction(), getJumpAction(), getRunAction() }),
        };
    }

    public static PlayerAction getSwimAction() {
        Random random = new Random();
        SwimAction swimAction = new SwimAction(random.nextInt(POOL_DISTANCE + 50));
        return swimAction;
    }

    public static PlayerAction getJumpAction() {
        Random random = new Random();
        JumpAction jumpAction = new JumpAction(random.nextInt(WALL_DISTANCE + 2));
        return jumpAction;
    }

    public static PlayerAction getRunAction() {
        Random random = new Random();
        RunAction runAction = new RunAction(random.nextInt(RACETRACK_DISTANCE + 50));
        return runAction;
    }

    public static PlayerAction getCrawlAction() {
        Random random = new Random();
        CrawlAction crawlAction = new CrawlAction(random.nextInt(BARBEDWIRE_DISTANCE + 5));
        return crawlAction;
    }
}
package Homework01.Actions;

    import Homework01.Obstacles.Obstacle;

public interface PlayerAction {
    void pass(Obstacle obstacle);
    ActionState getActionState();
}
package Actions;

    import Obstacles.Obstacle;
    import Obstacles.BarbedWire;

public class CrawlAction implements PlayerAction {
    private int maxDistance;
    private ActionState actionState;

    public CrawlAction(int maxDistance) {
        this.maxDistance = maxDistance;
        actionState = ActionState.NONE;
    }

    @Override
    public void pass(Obstacle obstacle) {
        if (obstacle instanceof BarbedWire) {
            BarbedWire barbedwire = (BarbedWire) obstacle;
            if (barbedwire.getDistance() <= maxDistance) {
                System.out.println("Игрок прополз.");
                actionState = ActionState.VICTORY;
            } else {
                System.out.println("Игрок не смог проползти. Может проползти максимум: " + maxDistance);
                actionState = ActionState.DEFEAT;
            }
        }
    }

    @Override
    public ActionState getActionState() {
        return actionState;
    }
}
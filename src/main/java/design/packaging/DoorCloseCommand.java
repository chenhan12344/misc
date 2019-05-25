package design.packaging;

/**
 * Created by DJH on 2019/1/2
 */
public class DoorCloseCommand implements Command {

    private GarageDoor door;

    public DoorCloseCommand(GarageDoor door) {
        this.door = door;
    }

    @Override
    public void execute() {
        door.close();
    }
}

package design.packaging;

/**
 * Created by DJH on 2019/1/2
 */
public class DoorOpenCommand implements Command {

    private GarageDoor door;

    public DoorOpenCommand(GarageDoor door) {
        this.door = door;
    }

    public void execute() {
        door.open();
    }
}

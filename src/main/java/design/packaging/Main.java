package design.packaging;

/**
 * Created by DJH on 2019/1/2
 */
public class Main {

    public static void main(String[] args) {
        GarageDoor door = new GarageDoor("back garage door");
        DoorOpenCommand doorOpenCommand = new DoorOpenCommand(door);
        DoorCloseCommand doorCloseCommand = new DoorCloseCommand(door);
        DoorRemoteControl remoteControl = new DoorRemoteControl(doorOpenCommand, doorCloseCommand);
        remoteControl.pressOpenButton();
        remoteControl.pressCloseButton();
    }
}

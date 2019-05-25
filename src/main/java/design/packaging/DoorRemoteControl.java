package design.packaging;

/**
 * Created by DJH on 2019/1/2
 */
public class DoorRemoteControl {

    private Command slot1;
    private Command slot2;

    public DoorRemoteControl(Command open, Command close) {
        this.slot1 = open;
        this.slot2 = close;
    }

    public void pressOpenButton() {
        slot1.execute();
    }

    public void pressCloseButton() {
        slot2.execute();
    }

}

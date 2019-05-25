package design.packaging;

/**
 * Created by DJH on 2019/1/2
 */
public class SimpleRemoteControl {

    private Command slot;

    public SimpleRemoteControl() {
    }

    public void setSlot(Command slot) {
        this.slot = slot;
    }

    public void click() {
        slot.execute();
    }
}

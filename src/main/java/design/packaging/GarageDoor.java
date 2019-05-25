package design.packaging;

/**
 * Created by DJH on 2019/1/2
 */
public class GarageDoor extends ElectricalAppliance {

    public GarageDoor(String name) {
        super(name);
    }

    public void open() {
        System.out.println(this.name + " is open!");
    }

    public void close() {
        System.out.println(this.name + " is closed!");
    }
}

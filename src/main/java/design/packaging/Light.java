package design.packaging;

/**
 * Created by DJH on 2019/1/2
 */
public class Light extends ElectricalAppliance {

    public Light(String name) {
        super(name);
    }

    public void on() {
        System.out.println(this.name + " is on!");
    }

}

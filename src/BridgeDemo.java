interface Device {
    void turnOn();
    void turnOff();
    void setVolume(int level);
}

class TV implements Device {
    @Override
    public void turnOn() {
        System.out.println("TV is ON");
    }

    @Override
    public void turnOff() {
        System.out.println("TV is OFF");
    }

    @Override
    public void setVolume(int level) {
        System.out.println("TV volume set to " + level);
    }
}

class Radio implements Device {
    @Override
    public void turnOn() {
        System.out.println("Radio is ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Radio is OFF");
    }

    @Override
    public void setVolume(int level) {
        System.out.println("Radio volume set to " + level);
    }
}


abstract class RemoteControl {
    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    public abstract void operate();
}

class AdvancedRemote extends RemoteControl {
    public AdvancedRemote(Device device) {
        super(device);
    }

    @Override
    public void operate() {
        device.turnOn();
        device.setVolume(10);
        device.turnOff();
    }
}


public class BridgeDemo {

	  public static void main(String[] args) {
	        Device tv = new TV();
	        Device radio = new Radio();

	        RemoteControl remote1 = new AdvancedRemote(tv);
	        RemoteControl remote2 = new AdvancedRemote(radio);

	        remote1.operate();
	        remote2.operate();
	    }

}

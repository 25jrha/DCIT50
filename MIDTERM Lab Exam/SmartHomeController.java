package SmartHomeLabExam;

// Main program: SmartHomeMain.java

// SmartHomeController class
class SmartHomeController {
    private Device[] devices;

   
    public SmartHomeController(Device[] devices) {
        this.devices = devices;
    }

    // Turn the devices on
    public void turnAllOn() {
        for (Device device : devices) {
            device.turnOn();
        }
    }

    // Turn the devices off
    public void turnAllOff() {
        for (Device device : devices) {
            device.turnOff();
        }
    }
}

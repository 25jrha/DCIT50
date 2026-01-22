package SmartHomeLabExam;

// Main program
public class SmartHomeMain {
    public static void main(String[] args) {
       
        LightBulb bulb = new LightBulb("Living Room Light", "Living Room");

        
        Thermostat thermostat1 = new Thermostat("Thermostat 1", "OFF", "Room 1", 22.5, "heating");
        Thermostat thermostat2 = new Thermostat("Thermostat 2", "OFF", "Room 2", 20.0, "cooling");

        // For creating the array of devices
        Device[] devices = {bulb, thermostat1, thermostat2};

        // To display the device count
        Device.showDeviceCount();

        // For loop to display info of all devices
        System.out.println("\nDevice Information:");
        for (Device device : devices) {
            device.displayInfo();
            System.out.println();
        }

        // Create SmartHomeController instance
        SmartHomeController controller = new SmartHomeController(devices);

        // Turn all devices ON
        controller.turnAllOn();

        // To display info again when turning ON
        System.out.println("After turning all devices ON:");
        for (Device device : devices) {
            device.displayInfo();
            System.out.println();
        }
    }
}

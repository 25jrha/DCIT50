package SmartHomeLabExam;

// Main program: SmartHomeMain.java

// Contains the Subclass LightBulb

class LightBulb extends Device {
    private int brightnessLevel; // 0 to 100
    private String color;

    // Constructor with the parameters
    public LightBulb(String deviceName, String status, String location, int brightnessLevel, String color) {
        super(deviceName, status, location);
        this.brightnessLevel = brightnessLevel;
        this.color = color;
    }

    // Overloaded constructor with deviceName and location only
    public LightBulb(String deviceName, String location) {
        super(deviceName, "OFF", location);
        this.brightnessLevel = 50;
        this.color = "Warm White";
    }

    // Method to adjust the brightness
    public void adjustBrightness(int level) {
        if (level >= 0 && level <= 100) {
            brightnessLevel = level;
        } else {
            System.out.println("Invalid brightness level. Must be between 0 and 100.");
        }
    }
  
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Brightness Level: " + brightnessLevel);
        System.out.println("Color: " + color);
    }
}

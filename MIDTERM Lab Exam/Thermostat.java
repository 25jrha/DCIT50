package SmartHomeLabExam;

// Main program: SmartHomeMain.java

// Contains the Subclass Thermostat

class Thermostat extends Device {
    private double temperature; // in Celsius
    private String mode; // cooling or heating

   
    public Thermostat(String deviceName, String status, String location, double temperature, String mode) {
        super(deviceName, status, location);
        this.temperature = temperature;
        this.mode = mode;
    }

    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Temperature: " + temperature + " °C");
        System.out.println("Mode: " + mode);
    }

   
    public void setTemperature(double temp) {
        this.temperature = temp;
    }

    
    public void setTemperature(double temp, String mode) {
        this.temperature = temp;
        this.mode = mode;
    }
}

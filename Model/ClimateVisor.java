package Model;

import java.util.Locale;
import java.util.Random;

public class ClimateVisor extends Widget implements Interactive {

    private String city;
    private double temperature;
    private String condition;
    private final Random azar = new Random();

    public ClimateVisor(String name, int memoryKB, String city, double temperature, String condition) {
        super(name, memoryKB);
        this.city = city;
        this.temperature = temperature;
        this.condition = condition;
    }

    public String getCiudad() { return city; }

    public void setCity(String city) { this.city = city; }

    public double getTemperature() { return temperature; }

    public String getCondition() { return condition; }

    public void setCondition(String condition) { this.condition = condition; }

    private String formatTemperature() {
        return String.format(Locale.US, "%.1f °C", temperature);
    }

    @Override
    public String render() {
        return "Clima en " + city + ": " + formatTemperature() + ", " + condition;
    }

    @Override
    public String responseClic() {
        return "Pronóstico de " + city + ": se espera " + condition.toLowerCase()
                + " con máxima de " + String.format(Locale.US, "%.1f °C", temperature + 3);
    }

    @Override
    public String actulization() {
        temperature += (azar.nextDouble() * 3) - 1.5; // varía entre -1.5 y +1.5
        return "Temperatura actualizada en " + city + ": " + formatTemperature();
    }

    @Override
    public String getConfiguration() {
        return "Ciudad: " + city + " | Condición actual: " + condition;
    }
}

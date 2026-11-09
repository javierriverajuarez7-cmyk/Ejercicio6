package Model;
import java.time.LocalTime;

public class AnalogicClock extends Clock {
    
    private boolean withSecond;

    public AnalogicClock(String name, int memoryKB, String zoneHour, boolean withSecond) {
        super(name, memoryKB, zoneHour);
        this.withSecond = withSecond;
    }

    public boolean isWithSecond() { return withSecond; }

    public void setWithSecond(boolean withSecond) { this.withSecond = withSecond; }

    @Override
    public String render() {
        LocalTime hora = getHour();
        int gradosHora = (hora.getHour() % 12) * 30 + hora.getMinute() / 2;
        int gradosMinuto = hora.getMinute() * 6;
        String resultado = "Reloj analógico: horario a " + gradosHora + "°, minutero a " + gradosMinuto + "°";
        if (withSecond) {
            resultado += ", segundero a " + (hora.getSecond() * 6) + "°";
        }
        return resultado;
    }

    @Override
    public String getConfiguration() {
        return super.getConfiguration() + " | Segundero: " + (withSecond ? "sí" : "no");
    }
    
}

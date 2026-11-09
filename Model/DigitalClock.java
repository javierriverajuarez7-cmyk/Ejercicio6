package Model;
import java.time.format.DateTimeFormatter;

public class DigitalClock extends Clock {
    
    private boolean format24h;

    public DigitalClock(String name, int memoryKB, String zoneHour, boolean format24h) {
        super(name, memoryKB, zoneHour);
        this.format24h = format24h;
    }

    public boolean isFormat24h() { return format24h; }

    public void setFormat24h(boolean format24h) { this.format24h = format24h; }

    @Override
    public String render() {
        String pattern = format24h ? "HH:mm:ss" : "hh:mm:ss a";
        return "Hora digital: " + getHour().format(DateTimeFormatter.ofPattern(pattern));
    }

    @Override
    public String getConfiguration() {
        return super.getConfiguration() + " | Formato: " + (format24h ? "24 horas" : "12 horas");
    }
    
}

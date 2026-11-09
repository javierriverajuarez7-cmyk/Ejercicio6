package Model;

import java.time.LocalTime;
import java.time.ZoneId;

public abstract class Clock extends Widget {

    private String zoneHour;

    protected Clock(String name, int memoryKB, String zoneHour){
        super(name,memoryKB);
        this.zoneHour = zoneHour; 
    }
    public String getZoneHour() { return zoneHour; }

    public void setZonaHoraria(String zoneHour) { this.zoneHour = zoneHour; }

    protected LocalTime getHour() {
        return LocalTime.now(ZoneId.of(zoneHour));
    }

    @Override
    public String getConfiguration() {
        return "Zona horaria: " + zoneHour;
    }

    
}

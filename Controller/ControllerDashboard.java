package Controller;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import Model.*;

public class ControllerDashboard {

    private final Dashboard dashboard;

    public ControllerDashboard(){
        this.dashboard= new Dashboard();
        chargeInitialCataloge();
    }
    private void chargeInitialCataloge(){
        dashboard.add(new DigitalClock("Reloj Guatemala", 120, "America/Guatemala", true));
        dashboard.add(new DigitalClock("Reloj Tokio", 125, "Asia/Tokyo", false));
        dashboard.add(new AnalogicClock("Reloj Analógico Madrid", 210, "Europe/Madrid", true));
        dashboard.add(new ClimateVisor("Clima Guatemala", 480, "Ciudad de Guatemala", 22.5, "Parcialmente nublado"));
        dashboard.add(new ClimateVisor("Clima Madrid", 470, "Madrid", 14.0, "Lluvia ligera"));
        dashboard.add(new TaskList("Tareas del Día", 350, "Entregar Ejercicio 6", "Estudiar para el parcial", "Hacer el UML"));
        dashboard.add(new AlertNotification("Alerta de Servidor", 90, "Servidor sin respuesta", AlertLevel.CRITICA));
        dashboard.add(new AlertNotification("Aviso de Reunión", 85, "Reunión a las 3 pm", AlertLevel.INFO));
        dashboard.add(new Calendary("Calendario", 260, Locale.forLanguageTag("es-GT")));
        dashboard.add(new InformativeBann("Banner Bienvenida", 40, "Bienvenido al Dashboard"));
        dashboard.add(new SistemMonitor("Monitor del Sistema", 640, 35, 58));
        dashboard.add(new SalesChart("Gráfico de Ventas", 720, 40, 65, 50, 80, 95));
        dashboard.add(new MusicReproductor("Reproductor", 560, "Lo-fi para estudiar"));

    }
    public int getTotalWidgets() {
        return dashboard.getWidgets().size();
    }

    public Map<Widget, String> listWidgets() {
        return dashboard.renderAll();
    }

    public Optional<Widget> foundWidget(String entrance) {
        try {
            return dashboard.found(Integer.parseInt(entrance.trim()));
        } catch (NumberFormatException e) {
            return dashboard.found(entrance);
        }
    }

    public List<Widget> orderByMemory(boolean falling) {
        return dashboard.orderByMemory(falling);
    }

    public Map<Widget, String> interactWithWidgets() {
        return dashboard.interactWithAll();
    }
    
}

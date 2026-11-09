package View;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

import Model.Widget;

public class View {

    private final Scanner scanner = new Scanner(System.in);

    /** @return opción numérica*/
    public int readOption() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public String readText() {
        return scanner.nextLine().trim();
    }

    public boolean readComfirmation() {
        return scanner.nextLine().trim().equalsIgnoreCase("s");
    }


    public String welcome(int totalWidgets) {
        return "Dashboard iniciado con " + totalWidgets + " widgets cargados.";
    }

    public String menu() {
        return "\n===== DASHBOARD MODULAR =====\n"
                + "1. Listar widgets activos\n"
                + "2. Buscar widget por ID o nombre\n"
                + "3. Ordenar widgets por memoria (KB)\n"
                + "4. Interactuar con los widgets\n"
                + "5. Salir\n"
                + "Seleccione una opción:";
    }

    public String askFound() {
        return "Ingrese el ID o el nombre del widget:";
    }

    public String arkOrdn() {
        return "¿Orden descendente (mayor consumo primero)? (s/n):";
    }

    public String invalidOption() {
        return "Opción inválida. Intente de nuevo.";
    }

    public String fired() {
        return "Cerrando el dashboard. ¡Hasta luego!";
    }

    public String formaterList(Map<Widget, String> widgets) {
        StringBuilder sb = new StringBuilder("\n--- WIDGETS ACTIVOS ---");
        for (Map.Entry<Widget, String> entrada : widgets.entrySet()) {
            sb.append("\n").append(entrada.getKey())
              .append("\n   ").append(entrada.getValue().replace("\n", "\n   "));
        }
        return sb.toString();
    }

    public String formaterBusqueda(Optional<Widget> result, String entrance) {
        if (!result.isPresent()) {
            return "No se encontró ningún widget con ID o nombre \"" + entrance + "\".";
        }
        Widget w = result.get();
        return "\n--- WIDGET ENCONTRADO ---\n" + w
                + "\n   Configuración: " + w.getConfiguration()
                + "\n   Vista actual: " + w.render().replace("\n", "\n   ");
    }

    public String formaterRanK(List<Widget> widgets, boolean falling) {
        StringBuilder sb = new StringBuilder("\n--- WIDGETS POR MEMORIA ("
                + (falling ? "mayor a menor" : "menor a mayor") + ") ---");
        int posicion = 1;
        for (Widget w : widgets) {
            sb.append("\n").append(posicion++).append(". ").append(w);
        }
        return sb.toString();
    }

    public String formaterInteraccions(Map<Widget, String> results) {
        StringBuilder sb = new StringBuilder("\n--- INTERACCIÓN CON LOS WIDGETS ---");
        for (Map.Entry<Widget, String> entrada : results.entrySet()) {
            sb.append("\n").append(entrada.getKey().getName())
              .append(": ").append(entrada.getValue());
        }
        return sb.toString();
    }
}


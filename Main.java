import Controller.ControllerDashboard;
import View.View;

public class Main {

    private static final int SALIR = 5;

    public static void main(String[] args) {
        ControllerDashboard controller = new ControllerDashboard();
        View view = new View();
        int option;

        System.out.println(view.welcome(controller.getTotalWidgets()));
        do {
            System.out.println(view.menu());
            option = view.readOption();
            ejecutarOption(option, controller, view);
        } while (option != SALIR);
    }

    private static void ejecutarOption(int option, ControllerDashboard controller, View view) {
        switch (option) {
            case 1:
                System.out.println(view.formaterList(controller.listWidgets()));
                break;
            case 2:
                System.out.println(view.askFound());
                String entrance = view.readText();
                System.out.println(view.formaterBusqueda(controller.foundWidget(entrance), entrance));
                break;
            case 3:
                System.out.println(view.arkOrdn());
                boolean falling = view.readComfirmation();
                System.out.println(view.formaterRanK(controller.orderByMemory(falling), falling));
                break;
            case 4:
                System.out.println(view.formaterInteraccions(controller.interactWithWidgets()));
                break;
            case SALIR:
                System.out.println(view.fired());
                break;
            default:
                System.out.println(view.invalidOption());
        }
    }
}


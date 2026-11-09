package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskList extends Widget implements Interactive {

    private final List<String> pendings;
    private int completed;

    public TaskList(String name, int memoryKB, String... tasks){
        super(name, memoryKB);
        this.pendings = new ArrayList<>(Arrays.asList(tasks));
        this.completed = 0;
    }
    public int getCountofPendings(){return pendings.size();}
    public int getCompleted(){return completed;}

     @Override
    public String render() {
        if (pendings.isEmpty()) {
            return "Tareas: ¡todo al día!";
        }
        return "Tareas pendientes (" + pendings.size() + "): " + String.join(" | ", pendings);
    }

    @Override 
    public String responseClic(){
        if(pendings.isEmpty()){
            return "No hay tareas pendientes.";
        }
        String done = pendings.remove(0);
        completed++;
        return "Tarea completada :" + done;
    }
    @Override 
    public String actulization(){
        return "Pendientes: " + pendings.size() + ", completadas: " + completed;

    }
    @Override 
    public String getConfiguration(){
        return "Tareas pendientes: " + pendings.size() + "| Completadas: " + completed;

    }
    


    
}

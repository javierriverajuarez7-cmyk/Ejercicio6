package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Dashboard {
    private final List<Widget> widgets;

    public Dashboard(){
        this.widgets = new ArrayList<>();
    }

    public void add(Widget widget){
        if(widget != null && !widgets.contains(widget)){
            widgets.add(widget);
        }
    }
    public List<Widget> getWidgets(){
        return Collections.unmodifiableList(widgets);
    }

    public Optional<Widget>found(int id){
        for(Widget w : widgets){
            if(w.getId() == id){
                return Optional.of(w);
            }
        }
        return Optional.empty();
    }
    public Optional<Widget> found(String name){
        if(name == null || name.trim().isEmpty()){
            return Optional.empty();
        }
        String finded = name.trim().toLowerCase();
        for(Widget w : widgets){
            if(w.getName().toLowerCase().contains(finded)){
                return Optional.of(w);
            }
        }
        return Optional.empty();
    }
    public List<Widget> orderByMemory(){
        List<Widget> copy = new ArrayList<>(widgets);
        Collections.sort(copy);
        return copy;
    }
    public List<Widget> orderByMemory(boolean descendent ){
        List<Widget> copy = orderByMemory();
        if(descendent){
            Collections.reverse(copy);
        }
        return copy;
    }

    public String render(Render element){
        return element.render();
    }
    public String interact(Interactive element){
        return "Clic ->" + element.responseClic() + "\n Actualización ->" + element.actulization();
    }

    public Map<Widget, String> renderAll(){
        Map<Widget, String> result = new LinkedHashMap<>();
        for(Widget w : widgets){
            result.put(w, render(w));
        }
        return result;
    }
    public Map<Widget, String> interactWithAll(){
        Map<Widget, String> result = new LinkedHashMap<>();
        for(Widget w : widgets){
            if(w instanceof Interactive){
                result.put(w, interact((Interactive) w));
            } else {
                result.put(w, "Widget estático: no soportara la interacción.");
            }
        }
        return result;
    }
        

    
}

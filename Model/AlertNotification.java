package Model;

public class AlertNotification extends Widget implements Interactive {
    private String mesaje;
    private AlertLevel level;
    private boolean read;

    public AlertNotification(String name, int memoryKB, String mesaje, AlertLevel level ){
        super(name, memoryKB);
        this.mesaje = mesaje;
        this.level = level;
        this.read = false;



    }
    public String getMesaje(){return mesaje;}

    public void setMesaje(String mesaje){this.mesaje = mesaje;}

    public AlertLevel getLevel(){return level;}

    public void setLevel(AlertLevel level){this.level = level;}

    public boolean isRead(){return read;}

    @Override
    public String render(){
        return "(" + level + ") " + mesaje + (read ? "[leída]" : "[NUEVA]");
    }
    @Override 
    public String responseClic(){
        if(read){
            return "La alerta ya estaba marcada como leída.";
        }
        read = true;
        return "Alerta marcada como leída: " + mesaje;
    }
    @Override 
    public String actulization(){
        return "Estado de la alerta: " +(read ? "leida" :"sin leer");
        
    }
    @Override 
    public String getConfiguration(){
        return "Nivel: " + level + "| Leída: " + (read ? "si" : "no");

    }
    
}

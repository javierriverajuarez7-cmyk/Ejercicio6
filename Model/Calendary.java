package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Calendary extends Widget {

    private Locale lenguage;

    public Calendary(String name, int memoryKB, Locale lenguage){
        super(name, memoryKB);
        this.lenguage=lenguage;
    }
    public Locale getLenguage(){return lenguage;}
    
    public void setLenguage(Locale lenguage){this.lenguage = lenguage;}

    @Override 
    public String render(){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("EEEE d 'de' MMMM 'de' yyyy", lenguage);
        return "Hoy es " + LocalDate.now().format(format);
    }
    @Override 
    public String getConfiguration(){
        return "Idioma:" + lenguage.toLanguageTag();
    }
    
}

package Model;

public class InformativeBann extends Widget {
    private String text;

    public InformativeBann(String name, int memoryKB, String text ){
        super(name, memoryKB);
        this.text = text;
    }
    public String getText(){return text;}
    public void setText(String text){this.text = text;}

    @Override 
    public String render(){
        return "*** " + text + " ***";
    }
    @Override 
    public String getConfiguration(){
        return "Texto: \"" + text + "\"";
    }
    
}

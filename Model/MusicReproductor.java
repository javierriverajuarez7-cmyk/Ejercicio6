package Model;

public class MusicReproductor extends Widget implements Interactive {

    private String pist;
    private boolean reproducer;

    public MusicReproductor(String name, int memoryKB, String pist) {
        super(name, memoryKB);
        this.pist = pist;
        this.reproducer = false;
    }

    public String getPist() { return pist; }

    public void setPist(String pist) { this.pist = pist; }

    public boolean isReproducer() { return reproducer; }

    @Override
    public String render() {
        return (reproducer ? "▶ Reproduciendo: " : "⏸ En pausa: ") + pist;
    }

    @Override
    public String responseClic() {
        reproducer = !reproducer;
        return reproducer ? "Reproduciendo \"" + pist + "\"" : "Pausado \"" + pist + "\"";
    }

    @Override
    public String actulization() {
        return "Estado del reproductor: " + (reproducer ? "reproduciendo" : "en pausa");
    }

    @Override
    public String getConfiguration() {
        return "Pista cargada: " + pist;
    }
}

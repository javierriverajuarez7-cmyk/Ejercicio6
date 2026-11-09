package Model;

import java.util.Random;

public class SistemMonitor extends Widget implements Interactive{
    
    private int useCpu;
    private int useRam;
    private final Random azar = new  Random();

    public SistemMonitor(String name, int memoryKB, int useCpu, int useRam){
        super(name, memoryKB);
        this.useCpu = useCpu;
        this.useRam = useRam;
    }
    public int getUseCpu(){return useCpu;}
    public int getUseRam(){return useRam;}

    @Override 
    public String render(){
        return "CPU: " + useCpu + "% | RAM: " + useRam + "%";
    }
    @Override 
    public String responseClic(){
        return "Detalle del sistema -> CPU al " + useCpu + "%, RAM al" + useRam + "%";
    }
    @Override 
    public String actulization(){
        useCpu = azar.nextInt(101);
        useRam = azar.nextInt(101);
        return "Metricas actualizadas: " + render();


    }
    @Override 
    public String getConfiguration(){
        return "Metricras: CPU y RAM | Valores actuales: " + render();
    }
    
}

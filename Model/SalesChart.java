package Model;

public class SalesChart extends Widget {
    
    private final int[] salesByMonth;

    public SalesChart(String name, int memoryKB, int ... salesByMonth){
        super(name, memoryKB);
        this.salesByMonth = salesByMonth.clone();
    }

    @Override 
    public String render(){
        StringBuilder sb = new StringBuilder("Ventas por mes: ");
        for(int i = 0; i< salesByMonth.length; i++){
        sb.append("\n Mes ").append(i + 1).append(": ").append("#".repeat(salesByMonth[i] / 10)).append(" (").append(salesByMonth[i]).append(")");
        }
        return sb.toString();
    }
    @Override 
    public String getConfiguration(){
        return "Meses graficados: " + salesByMonth.length;
    }
    
}

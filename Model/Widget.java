package Model;

public abstract class Widget implements Render, Comparable<Widget> {

    private static int nextId = 1; // generador automático de IDs

    private final int id;
    private String name;
    private int memoryKB;

    protected Widget(String name, int memoryKB) {
        this.id = nextId++;
        this.name = name;
        this.memoryKB = Math.max(0, memoryKB);
    }

    /** @return configuracion de los widgets */
    public abstract String getConfiguration();

    public int getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getMemoryKB() { return memoryKB; }

    public void setMemoryKB(int memoryKB) { this.memoryKB = Math.max(0, memoryKB); }

    public String getTipy() { return getClass().getSimpleName(); }

    public boolean isInteractive() { return this instanceof Interactive; }

    @Override
    public int compareTo(Widget other) {
        int porMemoria = Integer.compare(this.memoryKB, other.memoryKB);
        if (porMemoria != 0) {
            return porMemoria;
        }
        return this.name.compareToIgnoreCase(other.name);
    }

    /** Dos widgets son iguales si tienen el mismo ID. */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return id == ((Widget) obj).id;
    }

    @Override
    public int hashCode() { return Integer.hashCode(id); }

    @Override
    public String toString() {
        return "[ID " + id + "] " + name + " (" + getTipy() + ", "
                + (isInteractive() ? "interactivo" : "estático") + ") - " + memoryKB + " KB";
    }
}

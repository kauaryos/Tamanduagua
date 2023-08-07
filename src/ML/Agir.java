package ML;

public class Agir {
    private int totalAguaConsumida;

    public Agir() {
        totalAguaConsumida = 0;
    }

    public void registrarAgua(int ml) {
        totalAguaConsumida += ml;
    }

    public int getTotalAguaConsumida() {
        return totalAguaConsumida;
    }
}

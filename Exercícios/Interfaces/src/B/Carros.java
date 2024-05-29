package B;

public class Carros implements Veiculo{
    String marca;
    String modelo;
    String cor;
    int potencial;
    public Carros(String marca, String modelo, String cor, int potencial){
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.potencial = potencial;
    }

    @Override
    public String marca() {
        return this.marca;
    }

    @Override
    public String modelo() {
        return this.modelo;
    }

    @Override
    public String cor() {
        return this.cor;
    }

    @Override
    public int potencial() {
        return this.potencial;
    }

    @Override
    public void mostraDados() {

    }
}

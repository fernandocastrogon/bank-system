public class ContaCorrente extends Conta{

    private double limite;
    private double taxa;

    ContaCorrente(Cliente cliente, int numero, int agencia){
        super(cliente, numero, agencia);

    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }


}

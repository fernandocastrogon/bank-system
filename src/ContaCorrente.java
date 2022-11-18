public class ContaCorrente extends Conta {

    private double limite;
    private double taxa;

    ContaCorrente(Cliente cliente, int numero, int agencia, double taxa, double limite) {
        super(cliente, numero, agencia);
        setTaxa(taxa);
        setLimite(limite);

    }


    @Override
    public boolean transferir(double valor, Conta destino) {
        return super.transferir(valor, destino);
    }

    @Override
    public boolean sacar(double valor) {

        if (valor < getLimite() && super.saldo > valor) {
            super.saldo -= valor + getTaxa();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean depositar(double valor) {

        try {
            super.saldo += (valor - getTaxa());
            return true;
        } catch (Exception ex) {
            return false;
        }

    }

    @Override
    public double getSaldo() {
        return super.getSaldo();
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

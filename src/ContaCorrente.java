import java.util.concurrent.ExecutionException;

public class ContaCorrente extends Conta{

    private double limite;
    private double taxa;

    ContaCorrente(Cliente cliente, int numero, int agencia, double taxa, double limite){
        super(cliente, numero, agencia);
        this.taxa = taxa;

    }


    @Override
    public boolean saca(double valor) {

        try {
            super.saldo -= valor + this.taxa;
        }
        catch (Exception ex){
            return false;
        }
        return true;

    }

    @Override
    public boolean deposita(double valor) {

        if (valor < getLimite()) {
            try {
                super.saldo += valor;
            } catch (Exception ex) {
                return false;
            }
            return true;
        }else {
            return false;
        }
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

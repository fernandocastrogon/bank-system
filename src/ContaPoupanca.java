public class ContaPoupanca extends Conta{

    ContaPoupanca(Cliente cliente, int numero, int agencia){
        super(cliente, numero, agencia);

    }

    @Override
    public boolean sacar(double valor) {

        if (super.saldo > 0) {
            super.saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean depositar(double valor) {
        try {
            super.saldo += valor;
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}

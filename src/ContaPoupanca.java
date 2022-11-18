public class ContaPoupanca extends Conta implements Rendimentos{

    ContaPoupanca(Cliente cliente, int numero, int agencia){
        super(cliente, numero, agencia);

    }

    @Override
    public boolean sacar(double valor) {

        if (super.saldo > valor) {
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

    @Override
    //A taxa de rendimento para a Conta Poupança é de 1% ao mes
    public void atualizar(Double taxaRendimento) {

        super.saldo += super.saldo * (taxaRendimento / 100);

    }
}

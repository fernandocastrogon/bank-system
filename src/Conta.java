public abstract class Conta{

    private Cliente cliente;
    private int numero;
    private int agencia;
    protected double saldo;



    Conta(Cliente cliente, int numero, int agencia){
        this.numero = numero;
        this.agencia = agencia;
        this.cliente = cliente;
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public Cliente getCliente(){
        return cliente;
    }


    abstract boolean sacar(double valor);

    abstract boolean depositar(double valor);

    public boolean transferir(double valor, Conta destino){
        if (sacar(valor)) return destino.depositar(valor);
        return false;

    }



    public int getNumero() {
        return numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public double getSaldo() {
        return saldo;
    }

}

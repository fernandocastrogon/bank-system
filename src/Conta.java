public abstract class Conta{

    private int numero;
    private int agencia;
    public double saldo;



    Conta(Cliente cliente, int numero, int agencia){
        this.numero = numero;
        this.agencia = agencia;
        setCliente(cliente);
    }

    public void setCliente(Cliente cliente){

    }


    public abstract boolean saca(double valor);

    public abstract boolean deposita(double valor);

    public boolean transfere(double valor, Conta destino){
        destino.deposita(valor);
        return true;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
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

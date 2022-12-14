public class Cliente {

    private String nome;
    private String email;
    private String endereco;

    Cliente(String nome, String email, String endereco){

        setNome(nome);
        setEmail(email);
        setEndereco(endereco);

    }

    public String[] getDadosCadastrais(){

        return new String[]{getNome(), getEmail(), getEndereco()};

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}

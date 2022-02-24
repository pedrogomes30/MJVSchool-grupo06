public class Pessoa {

    //Atributos
    String cpf;
    String nome;

    //Construtor -> Parametros
    public Pessoa(String cpf, String nome){
        this.cpf = cpf;
        this.nome = nome;
    }

    @Override //Sobrescrever o método
    public String toString(){
        return "CPF: " + cpf + ", Nome: " + nome;
    }
    
}

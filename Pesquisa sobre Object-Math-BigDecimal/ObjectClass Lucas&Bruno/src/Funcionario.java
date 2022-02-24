public class Funcionario {

    // Atributos

    String cpf;
    String nome;

    //Construtor -> Parametros

    public Funcionario(String cpf, String nome){
        this.cpf = cpf;
        this.nome = nome;
    } 
    
    @Override // Sobrescrever Equals
    public boolean equals(Object obj) {
        Funcionario f = (Funcionario) obj;
        return this.cpf == f.cpf;
    }           
}

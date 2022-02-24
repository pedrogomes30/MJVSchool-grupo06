public class App {
    public static void main(String[] args) {

        //Método toString
        Pessoa p = new Pessoa("111111", "Joao Silva");
        System.out.println(p); // Implicitamente ele chama o método

        //Método Equals
        Funcionario f1 = new Funcionario ("222222", "Max");
        Funcionario f2 = new Funcionario ("222222", "Max");

        System.out.println(f1.equals(f2));
    }
}

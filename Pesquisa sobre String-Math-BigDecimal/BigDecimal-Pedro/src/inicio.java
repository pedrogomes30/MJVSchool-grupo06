import java.util.Scanner;
import java.math.BigDecimal;

public class inicio {
    public static void main(String[] args) throws Exception {
        double numero1 = 0.1;
        double numero2 = 0.2;
        Double numero3 = 0.2;
        System.out.println("-- bem vindo a pesquisa sobre a classe java BigDecimal -- ");
        System.out.println("vamos começar utilizando os valores "+numero1+" e o valor"+numero2+"como exemplo.");
        //Exemplos.exemploDouble(numero1,numero2);  //exemplo de um double sendo calculado
        //Exemplos.exemploBigDecimal(numero1,numero2);  //exemplo de um Big decimal com o mesmo numeor enviado
        //Exemplos.exemploOperadores();
        //Exemplos.exemplosCotidianos();


        int precisao = 1000;
        Exemplos.calculoDoPi(precisao);
    }

}
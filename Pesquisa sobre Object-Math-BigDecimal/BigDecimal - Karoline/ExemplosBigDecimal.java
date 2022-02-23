import java.math.BigDecimal;
import java.math.RoundingMode;

 public class ExemplosBigDecimal {

//Fontes:
//https://docs-oracle-com.translate.goog/javase/8/docs/api/java/math/BigDecimal.html
//https://www.devmedia.com.br/java-bigdecimal-trabalhando-com-mais-precisao/30286

     public static void main(String[] args) {
         System.out.println("Subtrai");
         System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.1")));

         System.out.println("");
         System.out.println("Soma");
         System.out.println(new BigDecimal("2.00").add(new BigDecimal("1.2")));

         System.out.println("");
         System.out.println("Compara");
         System.out.println(new BigDecimal("22.00").compareTo(new BigDecimal("22.00")));

         //Para especificar a quantidade de casas decimais, informar quantos números após a vírgula deseja e utilizar o RoundingMode.UP
         System.out.println("");
         System.out.println("Divide com número espeficíco de números após a vírgula");
         System.out.println(new BigDecimal("5.00").divide(new BigDecimal("2.00"),3,RoundingMode.UP));
         
        //Pega o maior valor
         System.out.println("");
         System.out.println("Máximo");
         System.out.println(new BigDecimal("2.00").max(new BigDecimal("1.5")));

        //Pega o menor valor
         System.out.println("");
         System.out.println("Mínimo");
         System.out.println(new BigDecimal("2.00").min(new BigDecimal("1.6")));

         System.out.println("");
         System.out.println("Potência");
         System.out.println(new BigDecimal("2.00").pow(2));

         System.out.println("");
         System.out.println("Multiplica");
         System.out.println(new BigDecimal("2.00").multiply(new BigDecimal("1.8")));

        //Multiplicação passando double perde todo o objetivo de gerar valores precisos
         System.out.println("");
         System.out.println("Multiplição passando double");
         System.out.println(new BigDecimal(2.00).multiply(new BigDecimal(1.8)));

     }


}


import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

//Fontes:
//https://docs-oracle-com.translate.goog/javase/8/docs/api/java/math/BigDecimal.html
//https://www.devmedia.com.br/java-bigdecimal-trabalhando-com-mais-precisao/30286
//documentação da própria IDE (ctrl+clique)

public class Exemplos {
    
    public static void exemploDouble(double numero1, double numero2){
        double resultado = 0;

        System.out.println("-- Double primitivo -- ");
        System.out.println("devido a JVM transformar o valor double em um numero binário,"+
                        "\n valores deste tipo tendem a se tornar uma dizima periódica e se"+
                        "tornando infito com isso gera imprecisões,\n em sistemas onde cada "+
                        "centavo é importate em sistemas que tratam valores, pdv, sistemas bancários, etc-- ");
        System.out.println("Exemplo de imprecisão: ");
        for(int i = 0; i<=10; i++){
            resultado = i>1 ? numero1 + numero2 : numero1 + numero2;
            System.out.println(numero1+" + "+numero2+" = "+resultado);
            numero1 += numero1;
        }
        
    }
    
    public static void exemploBigDecimal(double numero1, double numero2){
        BigDecimal numero1B    = new BigDecimal(String.valueOf(numero1));
        BigDecimal numero2B    = new BigDecimal(String.valueOf(numero2));
        BigDecimal resultado;
        
        System.out.println("-- Big Decimal -- ");
        System.out.println("já a classe Big Decimal trabalha com pontos flutuantes"+
                            "com precisão arbitrária,\n ou seja é possivel definir o nivel"+
                            "da sua precisão para os calculos");
        System.out.println("Primeiro, é necessário converter os valores double do ultimo"+
                             "exemplo em string, pois é uma recomendação do JAVADOC");
        for(int i = 0; i<=10; i++){
            resultado = numero1B.add(numero2B);
            System.out.println(numero1B+" + "+numero2B+" = "+resultado);
            numero1B =  numero1B.add(numero1B);
        }
    }







/*
    public static void exemplosCotidianos(){
        Scanner entrada = new Scanner(System.in);
        String  valorProduto;
        String  quantidadeProduto;
        String  dinheiro;

        System.out.print("-> Valor do Produto: ");             
        valorProduto = entrada.next();
        System.out.print("\n-> Quantidade do Produto: ");      
        quantidadeProduto = entrada.next();
        System.out.println("\n= Total da Compra");
        System.out.println(new BigDecimal(valorProduto).multiply(new BigDecimal(quantidadeProduto)));
        System.out.print("\n-> Dinheiro: ");
        dinheiro = entrada.next();
        BigDecimal total = new BigDecimal(valorProduto).multiply(new BigDecimal(quantidadeProduto));
        String totalConvertido = total.toPlainString();
        System.out.println("\n= Troco");
        System.out.println(new BigDecimal(dinheiro).subtract(new BigDecimal(totalConvertido)));
        BigDecimal resultado = soma(dinheiro,totalConvertido);
        System.out.println("\nSoma do dinheiro + total da compra");
        System.out.println(resultado);
        System.out.println("\nComparação do dinheiro com o total da compra");
        System.out.println(new BigDecimal(dinheiro).compareTo(new BigDecimal(totalConvertido)));
    }

    public static BigDecimal soma(String dinheiro, String totalConvertido){
        return  new BigDecimal(dinheiro).add(new BigDecimal(totalConvertido));
    }
    public static void exemploOperadores(){
        System.out.println("\nSubtração de 1.1 no valor 2.00 -> bigDecimal.subtract()");
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.1")));
        System.out.println("\nSoma de 1.2 no valor 2.00 -> bigDecimal.add()");
        System.out.println(new BigDecimal("2.00").add(new BigDecimal("1.2")));
        System.out.println("\nCompara o valor 22.00 com 22.00 -> bigDecimal.compareTo() \n retorna um Boolean");
        System.out.println(new BigDecimal("22.00").compareTo(new BigDecimal("22.00")));
        System.out.println("\n Divide o valor 2.00 por 2.00 -> bigDecimal.divide()");
        System.out.println(new BigDecimal("2.00").divide(new BigDecimal("2.00")));
        System.out.println("\nPara especificar a quantidade de casas decimais, \ninformar quantos números após a vírgula deseja utilizar o RoundingMode.UP");
        System.out.println("\nDivisão com 3 casas decimais -> bigDecimal('valor','nºcasas',RoudingMode.UP)\n RoudingMode.UP = arredondar para cima \n RoudingMode.DOWN = arredondar para baixo");
        System.out.println(new BigDecimal("5.00").divide(new BigDecimal("2.00"),3,RoundingMode.UP));
        System.out.println("\npotenciação 2.00 elevado à 2 -> bigDecimal.pow(2)");
        System.out.println(new BigDecimal("2.00").pow(2));
        System.out.println("\nMultiplicão de 2.00 por 1.8");
        System.out.println(new BigDecimal("2.00").multiply(new BigDecimal("1.8")));

        System.out.println("Máximo");
        System.out.println(new BigDecimal("2.00").max(new BigDecimal("1.5")));

        //Pega o menor valor
        System.out.println("");
        System.out.println("Mínimo");
        System.out.println(new BigDecimal("2.00").min(new BigDecimal("1.6")));
     }*/
    public static void calculoDoPi(int precisao){//numero de precisão do PI, limite do calculo.
        /*
            'PI' = 4(1 - 1/3 + 1/5 - 1/7 + 1/9 ... )                         
        */                                                       
        MathContext mc          = new MathContext(precisao, RoundingMode.HALF_EVEN);    
        //contexto matematico, onde é definido a precisão e o tipo de arredondamento.

        //definição dos numeros iniciais
        BigDecimal quatro       = new BigDecimal(4,mc);
        BigDecimal pi           = new BigDecimal(0,mc);
        BigDecimal sinal        = new BigDecimal(1,mc);
        BigDecimal incremento   = new BigDecimal(2,mc);
        BigDecimal denominador  = new BigDecimal(1,mc);

        //inicio do calculo
        for(int i = 0; i < precisao ; i++){
            BigDecimal tmp          = quatro.divide(denominador,mc);
            tmp                     = tmp.multiply(sinal,mc);
            pi                      = pi.add(tmp,mc);
            sinal                   = sinal.negate();
            denominador             = denominador.add(incremento);
            System.out.println("\n -- COM "+i+" CASAS DECIMAIS  -- "+pi+"\n");
        }
    }
}

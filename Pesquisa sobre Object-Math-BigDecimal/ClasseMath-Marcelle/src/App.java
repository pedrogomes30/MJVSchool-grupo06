
import javax.swing.plaf.synth.SynthDesktopIconUI;

public class App {
    public static void main(String[] args) throws Exception {
        int catetoA = 2;
        int catetoO = 3;

        double somaCateto = (Math.pow(catetoA, 2)) + (Math.pow(catetoO, 2));
        System.out.println("Soma dos catetos: " + somaCateto);

        System.out.println("Hipotenusa = " + Math.sqrt(somaCateto));

        System.out.println("Hipotenusa = " + Math.hypot(catetoA, catetoO));
    }
}

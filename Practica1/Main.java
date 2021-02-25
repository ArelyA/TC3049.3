import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Ingresa un número: ");
        int num;
        try {
            num = input.nextInt();
            Num numero = new Num(num);
            System.out.println("El número que ingresaste fue:");
            System.out.println(numero);
        } catch(Exception e) {
            System.out.println("No es un número");
        }
        
        input.close();
    }
}
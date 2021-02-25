import java.util.Arrays;
public class Num {
    private int[] digitos; // {millares, centenas, decenas, unidades}

    /*
    Constructor default.
    Inicializa el arreglo de enteros digitos con valores -1.
    */
    public Num() {
        digitos = new int[4];
        Arrays.fill(digitos, -1);
    }

    /*
    Constructor con parametros.
    Inicializa el arreglo de enteros digitos y acomoda los digitos del entero num en él.
    En caso de recibir un número inválido (num < 0 || num > 9999), regresa un mensaje de error.
    */
    public Num(int num) {
        digitos = new int[4];
        Arrays.fill(digitos, -1);
        toArray(num);
    }

    /*
    Método de modificación.
    Recibe un entero num y acomoda sus digitos en el arreglo de enteros digitos.
    En caso de recibir un número inválido (num < 0 || num > 9999), regresa un mensaje de error.
    */
    public void setNum(int num) {
        toArray(num);
    }

    /*
    Override del método toString para poder imprimir con los métodos de System.out
    */
    @Override
    public String toString() {
        String numero = "";
        if(digitos[3] >= 0) {

            // Millares
            if(digitos[0] > 0) {
                numero += getMillares(digitos[0]);
            }

            // Centenas
            if(digitos[1] > 0) {
                if(digitos[1] == 1 && digitos[2] == 0 && digitos[3] == 0) // 100 sin decenas ni unidades.
                    numero += "cien";
                else
                    numero += getCentenas(digitos[1]);
            }

            // Decenas especiales (10 - 15)
            if(digitos[2] == 1 && digitos[3] < 6) {
                numero += getDecenas_Especial(digitos[3]);
                return numero;
            }
            
            // Decenas (16 - 90)
            if(digitos[2] > 0) {
                numero += getDecenas(digitos[2]);
                if(digitos[2] == 2) { // Determina terminación del 20.
                    numero += (digitos[3] > 0) ? "i" : "e";
                }
                if(digitos[2] > 2 && digitos[3] > 0) { // Agrega nexo.
                    numero += " y ";
                }
            }

            // Unidades (1 - 9)
            if(digitos[3] > 0) {
                numero += getUnidades(digitos[3]);
            }

            // Cero
            if(numero.isBlank()) {
                numero += "cero";
            }
        }
        return numero;
    }

    /*
    Acomoda los dígitos del entero num en el arreglo de enteros digitos.
    En caso de recibir un número inválido (num < 0 || num > 9999), regresa un mensaje de error.
    */
    private void toArray(int num) {
        if(num >= 0 && num <= 9999)
            for(int i = 0; i < digitos.length; i++) {
                int num_temp = (num == 0) ? 0 : num/(int)Math.pow(10, digitos.length - 1 - i);
                digitos[i] = num_temp;
                num -= num_temp * (int)Math.pow(10, digitos.length - 1 - i);
            }
        else
            System.out.println("Número inválido.");
    }
    /*
    Recibe un entero n y regresa nombres de las unidades del 1 al 9.
    */
    private String getUnidades(int n){
        String[] unidades = {"", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"};
        return unidades[n];
    }

    /*
    Recibe un entero n y regresa nombres de las decenas el 10 al 15.
    */
    private String getDecenas_Especial(int n) {
        String[] decenas_especial = {"diez", "once", "doce", "trece", "catorce", "quince"};
        return decenas_especial[n];
    }

    /*
    Recibe un entero n y regresa nombres de las decenas del 16 al 90.
    */
    private String getDecenas(int n) {
        String[] decenas = {"", "dieci", "veint", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa"};
        return decenas[n];
    }

    /* 
    Recibe un entero n y regresa nombres de las centenas del 100* al 900.
    Excluye el caso de 100 sin decenas ni unidades.
    */
    private String getCentenas(int n) {
        String numero = "";
        String[] centenas = {"", "c", "dosc", "tresc", "cuatroc", "quin", "seisc", "setec", "ochoc", "novec"};
        numero += centenas[n];
        if(n > 1)
            numero += "ientos ";
        else
            numero += "iento ";
        return numero;
    }

    /*
    Recibe un entero n y regresa nombres de los millares del 1000 al 9000
    */
    private String getMillares(int n) {
        String numero = "";
        if(digitos[0] > 1) {
            numero += getUnidades(n) + " ";
        }
        numero += "mil ";
        return numero;
    }
}

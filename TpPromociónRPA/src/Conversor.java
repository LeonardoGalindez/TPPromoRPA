import java.util.Scanner;

//Algoritmo para calculos, conversiones y verificaciones de numeros decimales y binario
public class Conversor {
    public static void main(String[] args) {
        int num, numDecimal, posicion1, posicion2, expo;
        float promedioDecimal;
        String subCadena, numBinario, elect, binario, c1, c2, binExpo;
        boolean valorMain, valorBinario;
        // valorBinario es la variable booleana donde se guarda el valor que retorna el modulo verificarBinario
        // valorMain es la variable que se utiliza para la operacion booleana del repetir hasta principal
        valorMain = false;
        Scanner obj = new Scanner(System.in);
        // menú de navegación
        do {
            System.out.println("Seleccione una de las opciones-----------------------'*'");
            System.out.println();
            System.out.println("Decimal a binario:-----------------------------------'1'");
            System.out.println("Binario a Decimal:-----------------------------------'2'");
            System.out.println("Seleccione Subcadena del binario:--------------------'3'");
            System.out.println("Promedio numeros Binarios:---------------------------'4'");
            System.out.println("Binario a Complemento a 1:---------------------------'5'");
            System.out.println("Binario a Complemento a 2:---------------------------'6'");
            System.out.println("Verificar si un binario es valido--------------------'7'");
            System.out.println("Multiplicar por 2 a la n por un binario--------------'8'");
            System.out.println("El binario representa un numero positivo o negativo--'9'");
            System.out.println();
            System.out.println("Terminar---------------------------------------------'0'");
            elect = obj.next();
            switch (elect) {
                case "1":
                    System.out.println("Ingrese numero Decimal");
                    num = obj.nextInt();
                    numBinario = decimalAbinario(num);
                    System.out.println("Binario:" + numBinario);
                    break;
                case "2":
                    // Esta verificacion la utilizamos en casi todos los casos donde se ingresa un binario
                    do {// Verificacion de que si el binario es valido, sino este se va a repetir hasta que lo sea
                        System.out.println("Ingrese Numero Binario");
                        binario = obj.next();
                        valorBinario = verificarBinario(binario);
                        if (valorBinario == false) {// si es verdadero que no es un binario se muestra ERROR
                            System.out.println("ERROR");
                        }
                    } while (valorBinario == false);// repite mientras sea verdadero que el binario es invalido
                    // valorBinario es donde se asigna el valor booleano que retorna el modulo verificarBinario
                    numDecimal = SignoMagDecimal(binario);
                    System.out.println("Decimal:" + numDecimal);
                    break;
                case "3":
                    do {
                        System.out.println("Ingrese Numero Binario");
                        binario = obj.next();
                        valorBinario = verificarBinario(binario);
                        if (valorBinario == false) {
                            System.out.println("ERROR");
                        }
                    } while (valorBinario == false);
                    System.out.println("Ingrese 1ra posicion");
                    posicion1 = obj.nextInt();
                    System.out.println("Ingrese 2da posicion");
                    posicion2 = obj.nextInt();
                    subCadena = Subcadena(binario, posicion1, posicion2);
                    System.out.println("Binario de la posicion:" + posicion1 + " hasta la posicion:" + posicion2
                            + " es:" + subCadena);
                    break;
                case "4":
                    promedioDecimal = IngresoBinario();
                    System.out.println("El promedio de numeros binarios ingresados en decimal es de:" + promedioDecimal);
                    break;
                case "5":
                    do {
                        System.out.println("Ingrese Numero Binario");
                        binario = obj.next();
                        valorBinario = verificarBinario(binario);
                        if (valorBinario == false) {
                            System.out.println("ERROR");
                        }
                    } while (valorBinario == false);
                    c1 = enComplementoA1(binario);
                    System.out.println("Complemento a 1:" + c1);
                    break;
                case "6":
                    do {
                        System.out.println("Ingrese Numero Binario");
                        binario = obj.next();
                        valorBinario = verificarBinario(binario);
                        if (valorBinario == false) {
                            System.out.println("ERROR");
                        }
                    } while (valorBinario == false);
                    c2 = enComplementoA2(binario);
                    System.out.println("Complemento a 2:" + c2);
                    break;
                case "7": // Este caso lo hicimos diferente al resto en la validacion del binario para que no repita si es invalido sino que muestre el mensaje por pantalla
                    System.out.println("Ingrese Numero Binario");
                    binario = obj.next();
                    valorBinario = verificarBinario(binario);
                    if (valorBinario == true) {
                        System.out.println("El binario es valido");
                    } else {
                        System.out.println("El binario es invalido");
                    }
                    break;
                case "8":
                    do {
                        System.out.println("Ingrese Numero Binario");
                        binario = obj.next();
                        valorBinario = verificarBinario(binario);
                        if (valorBinario == false) {
                            System.out.println("ERROR");
                        }
                    } while (valorBinario == false);
                    System.out.println("Ingrese exponenete");
                    expo = obj.nextInt();// expo es la variable entera el cual es 2 elevado ese valor ingresado
                    binExpo = base2PorBinario(binario, expo);
                    System.out.println("El binario:" + binExpo);
                    break;
                case "9":
                    do {
                        System.out.println("Ingrese Numero Binario");
                        binario = obj.next();
                        valorBinario = verificarBinario(binario);
                        if (valorBinario == false) {
                            System.out.println("ERROR");
                        }
                    } while (valorBinario == false);
                    valorBinario = verifiacarSigno(binario);
                    if (valorBinario) {
                        System.out.println(binario + " :Representa un numero positivo");
                    } else {
                        System.out.println(binario + " :Representa un numero negativo");
                    }
                    break;
                case "0":
                    valorMain = true;// valor main se le asigna true para parar la ejecucion
                    break;
                default:
                    System.out.println("ERROR");// Si se ingresa en un valor no valido para el switch en la variable elect se muestra ERROR
                    break;
            }
            System.out.println("");
        } while (valorMain == false);
    }
    

    
    public static boolean verificarBinario(String b) {
        // 1:Modulo para verificar si el numero binario ingresado es correcto
        //b es la cadena de caracteres que vamos a analizar para verificar si cada uno de sus caracteres son 1nos y 0ros
        boolean valorBin;
        int i, cadena;
        valorBin = false;
        i = 0;
        cadena = b.length();
        while (valorBin == false && i < cadena) {
            if (b.charAt(i) != '1' && b.charAt(i) != '0') {
                valorBin = true;
            }
            i++;
        }
        return !valorBin;
    }
    
    public static boolean verifiacarSigno(String b) {
        // 2:modulo para verificar si un numero es postivo o negativo
        //b es la cadena de caracteres que ingresa el usuario para analizar si el caracter en la posicion 0 es 1 que es negativo  o 0 que es positivo
        boolean valorSig;
        valorSig = false;
        if (b.charAt(0) == '0') {
            valorSig = true;
        }
        return valorSig;
    }

    
    public static String Subcadena(String b, int pos1, int pos2) {
        // 3:Modulo sub cadena
        //b es la cadenad e caracteres que ingresa el usuario
        //pos1 es la primera posicion 
        //pos2 es la segunda posicion
        //retorna la cadena de de pos1 hasta pos2 inclusive
        int i, cant;
        String bin;
        bin = "";
        cant = b.length();
        if (pos1 >= 0 && pos1 < cant && pos2 >= 0 && pos2 < cant && pos1<=pos2) {
            //Validacion para que las posiciones no sean menores a 0 ni mayores a cantidad de caracteres
            //pos1 siempre tiene que ser menor que pos2
            for (i = pos1; i <= pos2; i++) {
                bin = bin + b.charAt(i);
            }
        } else {
            bin = "ERROR";
        }
        return bin;
    }

    
    public static String enComplementoA1(String b) {
        // 4: Modulo para sacar el Complemento a 1 de un binario
        //b es la cadena de caracteres la cual vamos a convertir 0 por 1 y 1 por 0
        int i, pos;
        String binarioA1;
        binarioA1 = "";
        pos = b.length();
        for (i = 0; i < pos; i++) {
            if (b.charAt(i) == '1') {
                binarioA1 = binarioA1 + '0';
            } else {
                binarioA1 = binarioA1 + '1';  
            }
        }
        return binarioA1;
    }

    
    public static String enComplementoA2(String b) {
        // 5: Modulo para sacar el Complemento a 2 de un binario
        int posMain, posSub, i;
        String binC2, binarioC2;
        binC2 = "";
        binarioC2 = "";
        boolean valor;
        valor = false;
        posMain = b.length();
        i = posMain - 1; 
        while (valor == false && i >= 0) {
            // verifica de derecha a izquierda por recorrido parcial hasta encontrar el primer 1
                                          
            if (b.charAt(i) == '1') {
                valor = true;
                binC2 = b.charAt(i) + binC2;
            } else {
                binC2 = b.charAt(i) + binC2;
            }
            i--;
        }
        // bincC2 tiene la parte de la cadena ingresada hasta inclusive el primer 1
        posSub = binC2.length();
        posMain = posMain - posSub;
        // le restamos a posMain para obtener la cantidad de caracteres que tenemos en la cadena despues del primer 1
        

        binarioC2 = Subcadena(b, 0, posMain-1);
        
        binarioC2 = enComplementoA1(binarioC2);// llamamos al modulo c1 para invertir los valores a partir de la posicion del primer 1
        binarioC2 = binarioC2 + binC2;// Concatenamos la cadena despues del primer 1 y la cadena antes del primer 1 inclusive
        return binarioC2;
    }

    
    public static int SignoMagDecimal(String b) {
        // 6.1:modulo binario en signo magnitud a decimal
        //cadena de caracteres binario a convertir a decimal positivo o negativo
        String bin;
        int i, j, decimal,cant;
        boolean valorDec;
        i = 0;
        bin = "";
        valorDec = verifiacarSigno(b);// llamada al modulo verifiacarSigno para saber el signo del numero que representa el binario
        cant= b.length();                                             
        if (valorDec) {// si valorDec es true osea positivo
            for (j = i; j < cant; j++) {
                bin = bin + b.charAt(j);
            }
            decimal = BinarioADecimal(bin);//el modulo BinarioADecimal nos retorna un numero positivo
        } else {// si valorDec es false osea negativo
            i = 1;// a i lo inicializamos en 1 porque en la aposicion 0 esta el caracter 0
            for (j = i; j < cant; j++) {
                bin = bin + b.charAt(j);
            }
            decimal = BinarioADecimal(bin);// el modulo BinarioADecimal nos retorna un numero positivo
            decimal = decimal * -1; // pero como el binario ingresado representaba un numero negativo lo multiplicamos por -1
        }
        return decimal;
    }

    
    public static int BinarioADecimal(String b) {
        // 6.2:Modulo calculo Binario a Decimal
        //b cadena de caracteres ingresada para el usuario
        int i, pos, decimal, j;
        decimal = 0;
        pos = b.length();
        j = 0;
        for (i = pos - 1; i >= 0; i--) {// Para la conversion de binario a utilizamos un recorrido total de derecha a izquierda
            if (b.charAt(i) == '1') {
                decimal = decimal + 1 * (int) Math.pow(2, j);
            } else {
                decimal = decimal + 0 * (int) Math.pow(2, j);
            }
            j++;
        }
        return decimal;
    }

    
    public static String decimalAbinario(int nroDec) {
        // 7:Modulo Decimal a Binario
        //nroDec decimal ingresado por el usuario para convertira binario
        String binario;
        char signo;
        binario = "";
        if (nroDec >= 0) {//validacion de signo
            signo = '0';
        } else {
            signo = '1';
            nroDec = nroDec * -1;
        }
        while (nroDec > 0) {
            //uso un while porque no conozco la cantidad de veces que voy a dividir por 2 el decimal ingresado
            if (nroDec % 2 != 0) {
                binario = '1' + binario;
            } else {
                if (nroDec % 2 == 0) {
                    binario = '0' + binario;
                }
            }
            nroDec = nroDec / 2;
        }
        binario = signo + binario;
        return binario;
    }

    
    public static String base2PorBinario(String b, int n) {
        // 8:Modulo que retorna el binario ingresado con n ceros a la izquierda
        //b cadenad e caracteres 
        //n exponente 
        int i;
        for (i = 0; i < n; i++) {
            b = b + '0';
        }
        return b;
    }

    
    public static float IngresoBinario() {
        // 9:Modulo acumuldor de binarios
        boolean valor;
        int Decimal, cont;
        float promedio, acum;
        cont = 0;
        acum = 0;
        String b;
        valor = false;
        Scanner obj = new Scanner(System.in);
        while (valor == false) {
            do {
                System.out.println("Ingrese Numero Binario");
                b = obj.next();
                valor = verificarBinario(b);
            } while (valor == true);
            Decimal = SignoMagDecimal(b);
            acum = acum + Decimal;
            cont++;
            if (Decimal == 0) {
                valor = true;
                cont--;
            }
        }
        promedio = acum / cont;
        return promedio;
    }
}
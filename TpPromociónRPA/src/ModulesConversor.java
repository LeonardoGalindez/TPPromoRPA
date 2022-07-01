import java.util.Scanner;
public class ModulesConversor {
   
    //1:Modulo para verificar si el numero binario ingresado es correcto
    public static boolean esBinario(String bin){
        boolean valor;
        int i,cadena;
        valor=false;
        i=0;
        cadena=bin.length();
        while(valor==false && i<cadena){
            if(bin.charAt(i)!='1' && bin.charAt(i)!='0'){
               valor=true;
            }
            i++;
        }
        return valor;
    }
    //2:modulo para verificar si un numero decimal es negativo
    
    //3:Modulo sub cadena
    public static String Subcadena(String b, int pos1, int pos2){
        int i;
        String bin;
        bin="";
        for(i=pos1;i<=pos2;i++){
            bin=bin+b.charAt(i);
        }
        return bin;
    }
    //4: Modulo para sacar el Complemento a 1 de un binario
    public static String C1Binario(String b){
        int i,pos;
        String binario;
        binario="";
        pos=b.length();
        for(i=0;i<pos;i++){
            if(b.charAt(i)=='1'){
                binario=binario+'0';
            }else{
                if(b.charAt(i)=='0'){
                    binario=binario+'1';
                }
            }
        }
        return binario;
    }
    //Consultar si estaria bien
    //5: Modulo para sacar el Complemento a 2 de un binario
    public static String C2Binario(String b){
        int pos,i,j;
        String binarioC2;
        binarioC2="";
        boolean valor;
        valor=false;
        pos=b.length();
        i=pos-1;
        while( valor==false && i>=0){
            if(b.charAt(i)=='1'){
                valor=true;
                binarioC2= b.charAt(i)+binarioC2;
                for(j=i-1;j>=0;j--){
                    if(b.charAt(j)=='1'){
                        binarioC2='0'+binarioC2;
                    }else{
                        if(b.charAt(j)=='0'){
                            binarioC2='1'+binarioC2;
                        }
                    }
                }
            }else{
                binarioC2= b.charAt(i)+binarioC2;
            }
            i--;
        }
        return binarioC2;
    }   
    //7:modulo binario en signo magnitud a decimal
    public static int SignoMagDecimal(String b){
        String bin;
        int i,j,decimal;
        i=0;
        bin="";
        if(b.charAt(0)=='1'){
            i=1;
            for(j=i;j<b.length();j++){
                bin=bin+b.charAt(j);   
            }
            decimal=ModulesConversor.BinarioDecimal(bin);
            decimal=decimal*-1;
        }else{
            for(j=i;j<b.length();j++){
                bin=bin+b.charAt(j);
            }
            decimal=ModulesConversor.BinarioDecimal(bin);
        }
        return decimal;
    }
    //7:Modulo Binario a Decimal
    public static int BinarioDecimal(String b){
        int i,pos,decimal,j;
        decimal=0;
        pos=b.length();
        j=0;
        for(i=pos-1;i>=0;i--){
            if(b.charAt(i)=='1'){
                decimal=decimal+1*(int) Math.pow(2, j);
            }else{
                decimal=decimal+0*(int) Math.pow(2, j);
            }
            j++;
        }   
        return decimal;
    }
    //8:Modulo Decimal a Binario
    public static String DecimalBinario(int num){
        String binario;
        binario="";
        if(num<0){
            num=num*-1;
        }
        while (num>0){
            if(num%2!=0){
                binario =  '1'+binario ;
                      }else{
                if(num%2==0){
                    binario ='0'+ binario  ;
                }
            }
            num=num/2;
        }
        return binario;
    }
    //Modulo que retorna el binario ingresado con n ceros a la izquierda
    public static String base2PorBinario(String b,int n){
        int i;
        for(i=0;i<n;i++){
            b=b+'0';
        }
        return b;
    }
    //9:Modulo acumuldor de binarios
    //Consultar si se puede hacer asi
    public static void IngresoBinario(){
        boolean valor;
        int acumDecimal,acum,cont,promedio;
        cont=0;
        acumDecimal=0;
        acum=0;
        String b;
        valor=false;
        Scanner obj=new Scanner(System.in);
        while(valor==false){
            do{
            System.out.println("Ingrese Numero Binario");
            b=obj.next();
            valor=ModulesConversor.esBinario(b);
            }while(valor==true);
            acumDecimal=ModulesConversor.BinarioDecimal(b);
            acum=acum+acumDecimal;
            cont++;
            if(acumDecimal==0){
                valor=true;
                cont--;
            }
        }
        promedio=acum/cont;
        System.out.println("El promedio de numeros binarios ingresados en decimal es de:"+promedio);
    }    
}

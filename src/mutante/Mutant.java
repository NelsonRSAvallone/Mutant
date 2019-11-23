
package mutante;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Nelson
 */
public class Mutant {
    boolean bandera = true;
    ArrayList <String> cadena = new ArrayList();
    Scanner entrada = new Scanner (System.in);
    String aux="";
    char aux2;
    //      String[] cadena= {"ATGCGG","CAGTGC","TTAGGT","AGGAGG","CCCCTA","TCACTG"};//Esta cadena cumple todas
    //      String[] cadena= {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};//Cadena del ejemplo
    
    //------------------------------------------METODOS-------------------------
    public void obtenerDatos (){
    
        do{
            System.out.println("Ingrese cadena de ADN");
            aux=entrada.nextLine();
            if (aux.length()>6 || aux.length()<6) 
            {
                    System.out.println("Debe ingresar almenos 6 cadenas de ADN");
            }else
            {
                if(validarLetra(aux.toUpperCase().trim()))
                {
                    cadena.add(aux.toUpperCase());
                }
            }
                System.out.println("Desea ingresar mas cadenas? Y/N");
                aux2=entrada.nextLine().toLowerCase().charAt(0);
                if (aux2 == 'n') {
                bandera=false;
            }
        
        }while(bandera);
        if (cadena.size()>4) {
            isMutant(cadena);
        }
    }
        
        
    
    //---------------------------------ValidarLetra-----------------------------
    public boolean validarLetra(String aux){
    int cont=0;
    for (int i = 0; i < aux.length(); i++) {
        if (aux.charAt(i)=='A'||aux.charAt(i)=='C'||aux.charAt(i)=='T'||aux.charAt(i)=='G') {
            cont++;
        }
    }
    if(cont==aux.length()){
        return true;
    }else{
        System.out.println("Ingrese una cadena valida");
        return false;
    }

}
    //------------------isMutant------------------------------------------------
    public boolean isMutant(ArrayList <String> dna) {
        boolean bool;
        int f = dna.size();//cantidad de elementos
        int c = dna.get(0).length();//longitud del primer elemento, todos deberian ser igual.
        char[][] m = new char[f][c];
       // String aux = "";
        int cont = 0;
        int isMut = 0;
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                m[i][j] = dna.get(i).charAt(j);

            }

        }
        //Mostrar Matriz
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print("[" + m[i][j] + "]");
            }
            System.out.println(" ");
        }
        //inicio de for 
        for (int i = 0,x=f-1; i < f;i++,x--) {
            for (int j = 0,y=c-1; j < c; j++,y--) {
               //checkear Horizontal
                if (j + 3 < c) {
                    if (m[i][j] == m[i][j + 1] && m[i][j + 1] == m[i][j + 2] && m[i][j + 2] == m[i][j + 3]) {
                        cont++;
                        System.out.println("Horizontal");
                        
                    }
                }
                //checkear vertical
                if (i + 3 < f) {
                    if (m[i][j] == m[i + 1][j] && m[i + 1][j] == m[i + 2][j] && m[i + 2][j] == m[i + 3][j]) {
                        cont++;
                        System.out.println("Vertical");
                    }
                }
                //checkear diagonal
                 if (i + 3 < f && j+3<c) {
                    if (m[i][j] == m[i + 1][j+1] && m[i + 1][j+1] == m[i + 2][j+2] && m[i + 2][j+2] == m[i + 3][j+3]) {
                        cont++;
                        System.out.println("diagonal");
                    }
                }
                 //checkear diagonalInvertida
                    if (x-3>= 0 && y-3>=0) {
                    if (m[x][y] == m[x - 1][y-1] && m[x- 1][y-1] == m[x- 2][y-2] && m[x- 2][y-2] == m[x- 3][y-3]) {
                        cont++;
                        System.out.println("diagonal invertida");
                    }
                }//
                    
            }
        }//fin for
        if(cont>1){
            return true;
        }else{
        return false;
        }
    
    }//fin isMutant
    //--------------------------------------------------------------------------
}

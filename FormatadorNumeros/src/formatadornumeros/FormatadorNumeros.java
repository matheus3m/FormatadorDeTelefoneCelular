package formatadornumeros;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FormatadorNumeros {

    
    public static void main(String[] args) throws IOException {
       
        //LEITURA E ARMAZENAMENTO DOS NÚMEROS EM UMA LISTA
        
        ArrayList <String> ListaNumeros = new ArrayList();
        
        FileInputStream file = null;
        try {
            file = new FileInputStream("lista_de_numeros.txt");
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado");
        }
        Scanner scannum = new Scanner(file);
        
        String numeros;
        String numForm;
        
         while(scannum.hasNext()){
         
            numeros = scannum.nextLine();
            
            numForm = "0" + numeros.substring(1,3)+ " " + numeros.substring(5, 10) 
                    + numeros.substring(11, 15);
            
            ListaNumeros.add(numForm);    
        }
         
        FileWriter gravar = new FileWriter("numeros_formatados.txt");
        BufferedWriter s = new BufferedWriter(gravar);
        
        int tam = ListaNumeros.size();
        
        String num = null;

        for(int i = 0; tam > i; i++){

            num = ListaNumeros.get(i);
            
            s.write(num);
            s.write("\n");   
        }     
        s.flush();
        s.close();
        gravar.close(); 
        
        System.out.println("EXECUTADO COM SUCESSO");
    }  
}

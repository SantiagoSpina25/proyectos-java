

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Santiago Spina
 */
public class Controlador {
    
    
    ArrayList<Persona> personas = new ArrayList<>();
    
    
    public ArrayList<Persona> leerArchivo(){
        try{
            File file = new File("personas.txt");
            BufferedReader bR = new BufferedReader(new FileReader(file));
            String linea = bR.readLine();
            
            while(linea != null){
                String [] array = linea.split(" ");
                System.out.println(Arrays.toString(array));
                personas.add(new Persona(array[0],array[1]));
                linea= bR.readLine();
            }
            bR.close();
        }catch(IOException e){
            System.out.println(e);
        }
        
        return personas;
    }
    
    public void escribirArchivo(ArrayList<Persona> personasEnTabla){
        try{
            File file = new File("personas.txt");
            BufferedWriter bW = new BufferedWriter(new FileWriter(file,false));
            System.out.println(personasEnTabla);
            for (int i = 0; i < personasEnTabla.size(); i++) {
                bW.write(personasEnTabla.get(i).getNombre() + " " + personasEnTabla.get(i).getEdad());
                bW.newLine();
            }
            bW.close();
            
        }catch(IOException e){
            System.out.println(e);
        }
        

    }
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad12_2.pkg0;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author jc_ca
 */
public class AddressBook {

    public static HashMap<String , String> getContactos() {
        return contactos;
    }

    public static void setContactos(HashMap<String, String> contactos) {
        AddressBook.contactos = contactos;
    }
    public static HashMap <String, String> contactos = new HashMap<>();
    private static String nombre;
    private String telefono;

    public AddressBook(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public static void save(List <AddressBook> contactos) throws IOException{
        String salidaArchivo = "Contactos.csv";//Archivo
        boolean existe = new File(salidaArchivo).exists();
        if(existe){
            File archivoContactos = new File(salidaArchivo);
            archivoContactos.delete();       }
        try    {
            CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');
            salidaCSV.write("Número");
            salidaCSV.write("Nombre");
            salidaCSV.endRecord();//Deja de escribir en el archivo
            
            //Recorrer la lista e insertar en el archiovo
            for(AddressBook contacto : contactos){
               salidaCSV.write(contacto.getTelefono()); 
               salidaCSV.write(contacto.getNombre());
               
               salidaCSV.endRecord();
            }
            salidaCSV.close();
        }catch(IOException e){
            e.printStackTrace();
        }}

     

     public static void load() throws IOException{
         List<AddressBook> contactos = new ArrayList<AddressBook>();//Lista para guardar los datos
      
      CsvReader lectura = new CsvReader("Contactos.csv");//leerUsuarios= lectura
      lectura.readHeaders();
      
      //Mientras haya lineas, se obtendran datos del archivo
      while(lectura.readRecord()){
          String numero = lectura.get(0);
          String nombre = lectura.get(1);
          contactos.add(new AddressBook(numero,nombre));
          
      }
      lectura.close();

     

}
 
}

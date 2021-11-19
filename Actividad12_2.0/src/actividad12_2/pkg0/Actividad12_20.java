/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad12_2.pkg0;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jc_ca
 */
public class Actividad12_20 {
public static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in)); 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, Exception {
        
        String nombre= "";
        String numero="";
       showMenu();
      
        
        /*List<AddressBook>contactos = new ArrayList<AddressBook>();
        
        contactos.add(new AddressBook("Juan","8112767943"));
        contactos.add(new AddressBook("Luis","8115550917"));
        ExportarCSV(contactos);*/
    }
    
    
    
private static int showMenu() throws IOException,Exception {
                String nombre= " ";
                String numero = " ";
          int m;
          
          int opcion2 = 0;
    
    do{
        m = 0;
        boolean e = true;

System.out.println("Seleccione una opción en el menú");
System.out.println("1-Mostrar los contactos"); 
System.out.println("2-Crear un nuevo contacto");
System.out.println("3-borrar un contacto");
System.out.println("0-Salir");
int opcion = Integer.parseInt(entrada.readLine());

   
 
 switch(opcion){
       case 0:
           System.out.println("Haz elegido salir");
          return 0 ;
          
        case 1:  
           
             List();
   
           break;
           
    
      
           
        case 2:
         String c = create(nombre,numero);
           break;
            case 3:
           String d = delete(nombre,numero);

           break;
            
           
         default: 
             
         m = 1;
         e = false;
         //throw new Exception("Opción de figura no válida, vuelva a intentarlo");
   } 
   if(e ==true){
   System.out.println("Presione (1) para volver a elegir una opción del menú o cualquier otra para salir");
   int o =Integer.parseInt(entrada.readLine());
   if (o==1){
       m=1;
   }}
    }while(m==1);
        return 0;
         
     }  
    
      /* public static void ExportarCSV(List <AddressBook> contactos) throws IOException{
        String salidaArchivo = "Contactos.csv";//Archivo
        boolean existe = new File(salidaArchivo).exists();
        if(existe){
            File archivoContactos = new File(salidaArchivo);
            archivoContactos.delete();       }
        try    {
            CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');
            salidaCSV.write("numero");
            salidaCSV.write("nombre");
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
        }}*/
       private static  String create(String nombre, String numero) throws IOException{
           
        List<AddressBook>contactos = new ArrayList<AddressBook>();
   int o;
        do{
        
       
        System.out.println("Ingresa el número");
        numero= entrada.readLine();
        System.out.println("Ingresa el nombre");
        nombre = entrada.readLine();
        contactos.add(new AddressBook(nombre,numero));
         AddressBook.contactos.put(nombre,numero);
        System.out.println("Desea registrar otro contacto, presione (1) para si o cualquier otro número para no ");
        o =Integer.parseInt(entrada.readLine());
       
        
      } while(o==1);
        AddressBook.save(contactos);
       
        return nombre;
        /* private static  String create(String nombre, String numero) throws IOException{
        System.out.println("Ingresa el nombre");
        nombre = entrada.readLine();
        System.out.println("Ingresa el número");
        numero= entrada.readLine();
        AddressBook.contactos.put(nombre,numero);
         return nombre;*/
    //AddressBook= usuario y contactos =usuarios
}
       
       
private static  void List() throws IOException{
    try{
      List<AddressBook> contactos = new ArrayList<AddressBook>();//Lista para guardar los datos
      AddressBook.load();
      /*
      CsvReader lectura = new CsvReader("Contactos.csv");//leerUsuarios= lectura
      lectura.readHeaders();
      
      //Mientras haya lineas, se obtendran datos del archivo
      while(lectura.readRecord()){
          String numero = lectura.get(0);
          String nombre = lectura.get(1);
          contactos.add(new AddressBook(numero,nombre));
          
      }
      lectura.close();*/
      //Recorremos la lista y mostramos en pantalla
      //for(AddressBook contacto: contactos){
      for(Map.Entry<String, String>entry: AddressBook.contactos.entrySet()){
          System.out.println("Número: "+entry.getValue()+ " Nombre: "+entry.getKey());
      }
    }catch(FileNotFoundException e){
        e.printStackTrace();
    }catch(IOException e){
        e.printStackTrace();
    }
    
    /* private static String list(String nombre, String numero) throws IOException{
        System.out.println("List");
        for(Map.Entry<String, String>entry: AddressBook.contactos.entrySet()){
            System.out.println("Número: "+entry.getValue()+ " Nombre: "+entry.getKey());
        }
         return nombre;*/
    
}private static String delete(String nombre, String numero) throws IOException{
   
    List<AddressBook>contactos = new ArrayList<AddressBook>();
    CsvReader lectura = new CsvReader("Contactos.csv");//leerUsuarios= lectura
      lectura.readHeaders();
      
      while(lectura.readRecord()){
          numero = lectura.get(0);
          nombre = lectura.get(1);
          contactos.add(new AddressBook(numero,nombre));
          
      }
     lectura.close();
    System.out.println("Delete");
    System.out.println("Ingresa el nombre");
    nombre=entrada.readLine();
   for(int i=1; i<contactos.size();i++){
       String n = contactos.get(i).getNombre().toString();
       
       if(n.equals(nombre)){
        contactos.remove(i).getNombre();  
        
           
       }
       
       AddressBook.save(contactos);
         
   }
     
   AddressBook.contactos.remove(nombre);
 
    
         return nombre;

}}


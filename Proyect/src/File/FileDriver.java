/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import Domain.Driver;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class FileDriver {
 
    //atributos
    public RandomAccessFile randomAccessFile;
    private int regsQuantity;//cantidad de registro
    private int regSize;//tamaño de registro
    private String myFilePath;//ruta de mi file
    
    //construcotres
    public FileDriver(File file) throws IOException{
        start(file);
}//fin method

    private void start(File file) throws IOException{
        //ruta
         myFilePath=file.getPath();
         //tamaño maximo de los registros
         this.regSize=140;
         
         //validacion para comprobar la existencia del archivo sino se crea
         if(file.exists() && !file.isFile()){
             throw new IOException(file.getName()+" is an invalid file");
         }//fin if
         else{
             //crea la nueva instancia
             randomAccessFile= new RandomAccessFile(file, "rw");
             
             //se indica cuantos registros tiene el archivo
             this.regsQuantity= (int)Math.ceil((double)randomAccessFile.length() / (double)regSize);
         }//fin else
    }//fin method
    
    public void close() throws IOException{
        randomAccessFile.close();
}// fin close
   
    //indica la cantidad de registros del archivo actual retorna la cantida de registros
    public int fileSize(){
        return regsQuantity;
    }//fin metodo
    
    //inserta un nuevo registro pero en una posicion existente
    public boolean putValue(int position, Driver driver) throws IOException{
        //validacion antes de insertar
        if(position>=0 && position<=regsQuantity){
            if(driver.size() > regSize){
                System.err.println("10001 record size is out of bounds");
                return false;
            }else{
                //escribimos el archivo
                randomAccessFile.seek(position * regSize);
                randomAccessFile.writeUTF(driver.getName());
                randomAccessFile.writeUTF(driver.getSurname());
                randomAccessFile.writeInt(driver.getIdentification());
                randomAccessFile.writeInt(driver.getDayTimHours());
                randomAccessFile.writeInt(driver.getNigthHours());
                
                return true;
        }//fin else
    }//fin if
        else{
            System.err.print("1002 position is"
                             + "out of bounds of this file");
            return false;
        }//fin else   
    }//fin method
    
    //agrga registro nuevo pero al final del 
    public boolean addEndRecord(Driver driver) throws IOException{
        //insertar al final del archivo
        boolean success = putValue(regsQuantity, driver);
        
        if(success){
            ++regsQuantity;
        }//fin if
        return success;
    }//fin metodo
    
    //obtiene registro de una perosna en la posicion indicada
    
    public Driver getDriver(int position) throws IOException{
      //valida posicion
      if(position>=0 && position <= regsQuantity){
          //colocamos puntero en el lugar
          randomAccessFile.seek(position*regSize);
          
          //Instancia de Driver
          Driver myDriver= new Driver();
          
          //Se lee
          myDriver.setName(randomAccessFile.readUTF());
          myDriver.setSurname(randomAccessFile.readUTF());
          myDriver.setIdentification(randomAccessFile.readInt());
          myDriver.setDayTimHours(randomAccessFile.readInt());
          myDriver.setNigthHours(randomAccessFile.readInt());
          
          //si es delete no retorna
          if(myDriver.getName().equalsIgnoreCase("delete")){
              return null;
          }//fin if
          else{
              return myDriver;
          }//fin else
      }//fin if
      else{
          System.err.print("2001 position is out of bounds");
          return null;
      }//fin else
    }//fin method
    
    //consulta todos los registros de mi archivo
    public List<Driver> getAllDrivers() throws IOException{
       
        //variables a retornar
        List<Driver> drivers= new ArrayList<Driver>();
        
        //recorro todos mis registros y los inserto en la lista
        for (int i = 0; i < regsQuantity; i++) {
            Driver driverTemp= this.getDriver(i);
            
            if(driverTemp !=null){
                drivers.add(driverTemp);
            }//fin if
            
        }//fin for
        
        return drivers;
    }//fin metodo
    
    
    public boolean deleteRecord(int identification) throws IOException{
        Driver myDriver;
        
        //Busca el registro para eliminarlo
        for (int i = 0; i < regsQuantity; i++) {
            
           //obtengo a la persona de esa posicion
           myDriver= this.getDriver(i);
           
           //pregunto si es la persona que quiero eliminar
           if(myDriver.getIdentification()==identification){
               //marca esta persona como eliminada
               myDriver.setName("Deleted");
               
               return this.putValue(i, myDriver);
           }//fin if
            
        }//fin for
        //si llega a este punto no encontro a la persona
        return false;
    }//fin metodo delete
    
}//fin class


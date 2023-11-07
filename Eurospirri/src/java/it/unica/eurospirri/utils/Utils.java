
// pacchetto utils, usato per controlli su input

package it.unica.eurospirri.utils;

import it.unica.eurospirri.exceptions.InvalidParamException;
import java.time.*;
import java.lang.String;

public class Utils {
    
    // controlla se il valore del parametro e null
    public static void checkNull(String name, String param) throws InvalidParamException{
        if(param == null)
            throw new InvalidParamException("Valore del campo" + name + "mancante.");
    }
    
    // controlla dimensione stringhe
    public static void checkString(String name, String param, int min, int max)
            throws InvalidParamException{
            checkNull(name, param);
            if(param.length() < min || param.length() > max){
                throw new InvalidParamException("Il campo" + name + " non rispetta la"
                    + "dimensione richiesta tra " + min + " e " + max + " caratteri stringa non corretta: " + param );            
            }

    }
    
    // controlla valori interi, ha un minimo e un massimo
    public static void checkInteger(String name, String param, int min, int max)
            throws InvalidParamException{
        checkNull(name, param);
        try{
            int valore = Integer.valueOf(param);//cambia il tipo in intero da una stringa
            
            if(valore < min || valore > max)
                throw new InvalidParamException("Il campo" + name + " non rispetta la"
                    + "dimensione richiesta tra " + min + " e " + max + " ");
        } catch(NumberFormatException e){
            throw new InvalidParamException("Il campo " + name + "deve contenere un "
                    + "numero intero.");
        }
    }
    
    
    
    
    // converte date in formato digeribile da java
    public static String convertTime(long time){
        LocalDateTime localDt = LocalDateTime.ofInstant(
            Instant.ofEpochMilli(time),ZoneOffset.UTC);
        return localDt.toString();  
    }
    
    public static void checkFloat(String name, String param, int min, int max)
            throws InvalidParamException{
        checkNull(name, param);
        try{
            float valore = Float.valueOf(param);//cambia il tipo in intero da una stringa
            
             if(valore < min || valore > max)
                throw new InvalidParamException("Il campo" + name + " non rispetta la"
                    + "dimensione richiesta tra " + min + " e " + max + " ");
        } catch(NumberFormatException e){
            throw new InvalidParamException("Il campo " + name + "deve contenere un "
                    + "numero reale.");
        }
    }

    // controlla se la pass1 è uguale a pass2 (usata in registrazione nuovo utente)
    public static void checkNewPass(String name, String param,int min,String name2,String param2) 
            throws InvalidParamException{
        checkNull(name,param);
        checkNull(name2,param2);
        if(param.length()<min || param2.length()<min  || !(param.equals(param2))){
            throw new InvalidParamException("i valori dei campi "+name+" e "+ name2 +" sono diversi");
        }
    }
    
}



/*
    classe per la connnessione al db
*/


package it.unica.eurospirri.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class DatabaseManager {
    
    private static DatabaseManager instance;
    
    private DatabaseManager(){
        try{
            Class.forName("org.postgresql.Driver");
        } catch(ClassNotFoundException e){
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null,e);
        }
    }
    
     //funzione che fa in modo che ci sia solo un istanza di questa tipologia 
    //attiva per volta  
    public static DatabaseManager getInstance(){
        if(instance== null)
            instance= new DatabaseManager();
        return instance;
    }
    
    public Connection getdbConnection(){
        
        String db = "jdbc:postgresql://localhost/error404"; // indirizzo db
        String user="postgres"; // owner
        String pass="fondamenti"; // password
        
        // restituisce oggetto Connection per future connessioni
        try{
            Connection conn= DriverManager.getConnection(db,user,pass);
            return conn;
        }catch(SQLException e){
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE,null,e);
        }
        return null;
    }
}


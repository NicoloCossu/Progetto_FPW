
// classe di interrogazione db per dati utenti

package it.unica.eurospirri.model;

import it.unica.eurospirri.db.DatabaseManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UtenteFactory {
    
    private static UtenteFactory instance;
    
    private UtenteFactory(){}
    
    public static UtenteFactory getInstance(){
        if(instance == null)
            instance = new UtenteFactory();
        return instance;
    }
    
    // passati user e pass restituisce utente se si trova in db altrimenti null
    public Utente getUtenteByUsernamePassword(String username, String password){
        Connection conn= null;
        PreparedStatement stmt = null;
        ResultSet set= null;
        
        try{
            conn = DatabaseManager.getInstance().getdbConnection(); // connessione
            
            String query = "SELECT * FROM utenti WHERE username = ? AND password= ? "; // quey senza param
            stmt = conn.prepareStatement(query); // prepara query
            // imposta parametri
            stmt.setString(1,username);
            stmt.setString(2,password);
            // esegue query
            set = stmt.executeQuery();
            
            // ciclo su set per pescare i dati
            if(set.next()){
                Utente utente = new Utente();
                // setta attributi letti su oggetto utente
                utente.setUsername(set.getString("username"));
                utente.setPassword(set.getString("password"));
                utente.setNome(set.getString("nome"));
                utente.setCognome(set.getString("cognome"));
                utente.setEmail(set.getString("email"));
                
                // parte da aggiungere per chi siamo
                //utente.setFoto(set.getString("foto"));
                utente.setCitta(set.getString("citta"));                
                
                return utente;
            }else{
                return null;
            }
            
        }catch(SQLException e){
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE,null,e);
            
        }finally {
            try{set.close();}catch(Exception e){}
            try{stmt.close();}catch(Exception e){}
            try{conn.close();}catch(Exception e){}
        }
        return null;
    }
    
    
    
    // funzione per inserire un nuovo utente nel db
    public int insertUtente(Utente utente){
        
        
        int code=0;
        Connection conn= null;
        PreparedStatement stmt = null;
        ResultSet set= null;
        
        try{
            conn = DatabaseManager.getInstance().getdbConnection(); // connessione
            
            String query = "INSERT INTO utenti "
                    + "(id,username,password,nome,cognome,citta,email,creator)"
                    + "VALUES (default,?,?,?,?,?,?,?) "; // quey senza param
            stmt = conn.prepareStatement(query); // prepara query
            
            // il primo è l'id messo a default cosi da incrementare da solo
            // imposta parametri
            stmt.setString(1,utente.getUsername()); // username
            stmt.setString(2,utente.getPassword()); // password
            stmt.setString(3,utente.getNome()); // nome
            stmt.setString(4,utente.getCognome()); // cognome
            
            stmt.setString(5,utente.getCitta()); // citta
            stmt.setString(6,utente.getEmail()); // email
            stmt.setBoolean(7, false); // creator impostato auto a false
            // esegue query
            code=stmt.executeUpdate();
            
            
            
        }catch(SQLException e){
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE,null,e);
            
        }finally {
            try{set.close();}catch(Exception e){}
            try{stmt.close();}catch(Exception e){}
            try{conn.close();}catch(Exception e){}
        }
        return code;
        
        
    
    }
    
    
    public int getIdUtente(String username){
        Connection conn= null;
        PreparedStatement stmt = null;
        ResultSet set= null;
        int id=0;
        
        try{
            conn = DatabaseManager.getInstance().getdbConnection(); // connessione
            
            String query = "SELECT * FROM utenti WHERE username=?"; // quey senza param
            stmt = conn.prepareStatement(query); // prepara query
            
            
            // imposta parametri
            stmt.setString(1,username); // username
            
            set=stmt.executeQuery();
            
            if(set.next()){
                id = set.getInt("id");
            }else{
                return -1;
            }
            
            
            
        }catch(SQLException e){
            Logger.getLogger(UtenteFactory.class.getName()).log(Level.SEVERE,null,e);
            
        }finally {
            try{set.close();}catch(Exception e){}
            try{stmt.close();}catch(Exception e){}
            try{conn.close();}catch(Exception e){}
        }
        return id;
        
    }
    
    
    
}

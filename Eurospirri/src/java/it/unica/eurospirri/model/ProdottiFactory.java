
// classe per lettura da db dei prodotti

package it.unica.eurospirri.model;

import it.unica.eurospirri.db.DatabaseManager;
import java.sql.Connection;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Date;



public class ProdottiFactory {
    
    private static ProdottiFactory instance;
    
    private ProdottiFactory(){}
    //funzione che fa in modo che ci sia solo un istanza di questa tipologia 
    //attiva per volta  
    public static ProdottiFactory getInstance(){
        if(instance == null)
            instance = new ProdottiFactory();
        return instance;
    }
    
    // restituisce la lista intera dei prodotti
    public List<Prodotti> getAllProdotti(){
        Connection conn= null; 
        PreparedStatement stmt = null;
        ResultSet set= null; 
        List<Prodotti> prodotti = new ArrayList<>();
        
        try{
            conn= DatabaseManager.getInstance().getdbConnection(); // connessione a db
            String query = "SELECT * FROM prodotti"; // query senza parametri
            stmt = conn.prepareStatement(query); // prepara query
            
            set = stmt.executeQuery(); // esegue query, restituisce su oggetto set
            
            while(set.next()){ // scorre set per recuperare tutti i prodotti
                Prodotti prodotto = new Prodotti();
                // recupero info del singolo prodotto
                prodotto.setId(set.getLong("id"));
                prodotto.setNome(set.getString("nome"));
                prodotto.setDescrizione(set.getString("descrizione"));
                prodotto.setPrezzo(set.getFloat("prezzo"));
                prodotto.setQuantita(set.getInt("quantita"));
                prodotto.setUtente_id(set.getInt("id_utente"));
                prodotto.setFoto(set.getString("foto"));
                
                prodotto.setScadenza(set.getDate("data_scadenza"));
                
                // aggiunge prodotto a lista prodotti
                prodotti.add(prodotto);
                
            }
            // rende la lista di prodotti letti
            return prodotti;
        }catch(SQLException e){
            Logger.getLogger(ProdottiFactory.class.getName()).log(Level.SEVERE,null,e);
            
        }finally {
            try{set.close();}catch(Exception e){}
            try{stmt.close();}catch(Exception e){}
            try{conn.close();}catch(Exception e){}
        }
        return null;
    
    }
    
    
    
    

    // funzione che restituisce lista degli username degli utenti che hanno
    //inserito i prodotti data una lista di prodotti
    public List<String> getOwners(List<Prodotti> prodotti){
        
        List<String> listaUsernames = new ArrayList();
        
        
        // ciclare per tutti i prodotti TODO
        for(int i=0;i<prodotti.size();i++){
            listaUsernames.add(getOwner(prodotti.get(i)));
        }
        
            
        
        
        return listaUsernames;
    
    }
    




    // funzione che dato un prodotto restituisce l'username 
    // dell'utente che l'ha inserito 
    public String getOwner(Prodotti prodotto){
        
        Connection conn= null; 
        PreparedStatement stmt = null;
        ResultSet set= null; 
        String owner=null;
        
        try{
            conn= DatabaseManager.getInstance().getdbConnection(); // connessione a db
            String query = "SELECT prodotti.id_utente, utenti.username "
                    + "FROM prodotti JOIN utenti "
                    + "ON prodotti.id_utente=utenti.id WHERE prodotti.id= ? "; // query senza parametri
            stmt = conn.prepareStatement(query); // prepara query
            stmt.setLong(1,prodotto.getId()); // setto l'id da cercare
            set = stmt.executeQuery(); // esegue query, restituisce su oggetto set
            
            
            if(set.next()){
                owner=set.getString("username"); // recupera l'username
            }else{
                return null;
            }
            
            
           
               
            // rende l'username dell'utente
            return owner;
        }catch(SQLException e){
            Logger.getLogger(ProdottiFactory.class.getName()).log(Level.SEVERE,null,e);
            
        }finally {
            try{set.close();}catch(Exception e){}
            try{stmt.close();}catch(Exception e){}
            try{conn.close();}catch(Exception e){}
        }
        return owner;
        
    }
    
    
    // funzione che inserisce un nuovo prodotto nel db
    public int insertProdotto(Prodotti prodotto,int id_utente){
        
        
        int code=0;
        Connection conn= null;
        PreparedStatement stmt = null;
        ResultSet set= null;
        
        try{
            conn = DatabaseManager.getInstance().getdbConnection(); // connessione
            
            String query = "INSERT INTO prodotti (id,id_utente,nome,descrizione,foto,data_scadenza,quantita,prezzo) VALUES (default,?,?,?,?,?,?,?) "; // query senza param
            stmt = conn.prepareStatement(query); // prepara query
            
            // il primo è l'id messo a default cosi da incrementare da solo
            // imposta parametri
            stmt.setInt(1,id_utente); // id_utente
            stmt.setString(2,prodotto.getNome()); // nome
            stmt.setString(3,prodotto.getDescrizione()); // descrizione
            stmt.setString(4,prodotto.getFoto()); // foto
            stmt.setDate(5,Date.valueOf(prodotto.getScadenza()));
            stmt.setInt(6,prodotto.getQuantita()); // quantita
            stmt.setFloat(7,prodotto.getPrezzo()); // prezzo
            
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
    
    
    
    
    
    
    public Prodotti getProdotto(String nome){
        Connection conn= null; 
        PreparedStatement stmt = null;
        ResultSet set= null; 
        Prodotti prodotto = new Prodotti();
        
        try{
            conn= DatabaseManager.getInstance().getdbConnection(); // connessione a db
            String query = "SELECT * FROM prodotti WHERE nome=?"; // query senza parametri
            stmt = conn.prepareStatement(query); // prepara query
            stmt.setString(1,nome);
            set = stmt.executeQuery(); // esegue query, restituisce su oggetto set
            
            if(set.next()){ 
                // recupero info del singolo prodotto
                prodotto.setId(set.getLong("id"));
                prodotto.setNome(set.getString("nome"));
                prodotto.setDescrizione(set.getString("descrizione"));
                prodotto.setPrezzo(set.getFloat("prezzo"));
                prodotto.setQuantita(set.getInt("quantita"));
                prodotto.setUtente_id(set.getInt("id_utente"));
                prodotto.setFoto(set.getString("foto"));
                prodotto.setScadenza(set.getDate("data_scadenza"));
                
                /*Timestamp ts = set.getTimestamp("data_scadenza");
                LocalDateTime localDt = null;
                if(ts != null){
                    localDt = LocalDateTime.ofInstant(Instant.ofEpochMilli(ts.getTime()), ZoneOffset.UTC);
                    
                }
                prodotto.setScadenza(localDt);
                */
               
                
                
            }
            
            return prodotto;
        }catch(SQLException e){
            Logger.getLogger(ProdottiFactory.class.getName()).log(Level.SEVERE,null,e);
            
        }finally {
            try{set.close();}catch(Exception e){}
            try{stmt.close();}catch(Exception e){}
            try{conn.close();}catch(Exception e){}
        }
        return null;
    
    }
    
    
    
    public Prodotti getProdottoById(long id){
        Connection conn= null; 
        PreparedStatement stmt = null;
        ResultSet set= null; 
        Prodotti prodotto = new Prodotti();
        
        try{
            conn= DatabaseManager.getInstance().getdbConnection(); // connessione a db
            String query = "SELECT * FROM prodotti WHERE id=?"; // query senza parametri
            stmt = conn.prepareStatement(query); // prepara query
            stmt.setLong(1,id);
            set = stmt.executeQuery(); // esegue query, restituisce su oggetto set
            
            if(set.next()){ 
                // recupero info del singolo prodotto
                prodotto.setId(set.getLong("id"));
                prodotto.setNome(set.getString("nome"));
                prodotto.setDescrizione(set.getString("descrizione"));
                prodotto.setPrezzo(set.getFloat("prezzo"));
                prodotto.setQuantita(set.getInt("quantita"));
                prodotto.setUtente_id(set.getInt("id_utente"));
                prodotto.setFoto(set.getString("foto"));
                
                prodotto.setScadenza(set.getDate("data_scadenza"));
                
                /*Timestamp ts = set.getTimestamp("data_scadenza");
                LocalDateTime localDt = null;
                if(ts != null){
                    localDt = LocalDateTime.ofInstant(Instant.ofEpochMilli(ts.getTime()), ZoneOffset.UTC);
                    
                }
                prodotto.setScadenza(localDt);
                */
               
                
                
            }
            
            return prodotto;
        }catch(SQLException e){
            Logger.getLogger(ProdottiFactory.class.getName()).log(Level.SEVERE,null,e);
            
        }finally {
            try{set.close();}catch(Exception e){}
            try{stmt.close();}catch(Exception e){}
            try{conn.close();}catch(Exception e){}
        }
        return null;
    
    }
    
    
}


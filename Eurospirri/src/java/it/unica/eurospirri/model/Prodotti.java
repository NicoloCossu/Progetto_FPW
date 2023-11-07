

// modello dei prodotti

package it.unica.eurospirri.model;

import java.sql.Date;

import java.time.LocalDateTime;

public class Prodotti {
    
    // attrinuto di ogni prodotto
    
    private long id;
    private String nome;
    private float prezzo;
    private int quantita;
    private Date scadenza;
    private String descrizione;
    private int utente_id;
    private String foto;
    
    
    
    public Prodotti(){}
    
    // setters e getters per tutti gli attributi
    // va aggiunto equals e hashCode?
    
    public String getFoto(){return foto;}
    
    public void setFoto(String foto){this.foto=foto;}
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public String getScadenza() {
        return scadenza.toString();
    }

    public void setScadenza(Date scadenza) {
        this.scadenza = scadenza;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getUtente_id() {
        return utente_id;
    }

    public void setUtente_id(int utente_id) {
        this.utente_id = utente_id;
    }
    
    
    
    
}

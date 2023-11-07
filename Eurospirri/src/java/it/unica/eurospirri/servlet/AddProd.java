
// servlet per inserimento nuovo prodotto, manca il vero e proprio inserimento in db

package it.unica.eurospirri.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.unica.eurospirri.exceptions.InvalidParamException;
import it.unica.eurospirri.model.Prodotti;
import it.unica.eurospirri.model.ProdottiFactory;
import it.unica.eurospirri.model.UtenteFactory;
import it.unica.eurospirri.utils.Utils;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.servlet.http.HttpSession;

import java.sql.Date;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

@WebServlet(name = "AddProd", urlPatterns = {"/AddProd"})
@MultipartConfig
public class AddProd extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // recupero sessione per prendere Username dell'utente che ha inserito il prodotto
        HttpSession session = request.getSession(false);
        
        // prende i parametri dal form
        String nome= request.getParameter("nomeProdotto");
        String descrizione= request.getParameter("descrizione");
        String data = request.getParameter("data");
        String quantita = request.getParameter("quantita");
        String prezzo = request.getParameter("prezzo");
        
        
        Part file = request.getPart("file");
        
        int id_utente=0;
        
        
        
        try{
            // controllo sui dati inseriti
            Utils.checkString("nomeProdotto", nome, 1, 50);
            Utils.checkString("descrizione", descrizione, 1, 500);
            Utils.checkInteger("quantita", quantita, 0, 50);
            Utils.checkFloat("prezzo",prezzo,0,50);
            
            
            // inizializzo il nuovo prodotto da inserire
            Prodotti prodotto = new Prodotti();
            
            prodotto.setDescrizione(descrizione); // descrizione
            prodotto.setNome(nome); // nome
            prodotto.setQuantita(Integer.parseInt(quantita)); // quantita
            
            prodotto.setPrezzo(Float.parseFloat(prezzo)); // prezzo
            
            prodotto.setScadenza(Date.valueOf(data));// problema con le date TODO
            // in insert prodotto non inserisco data ma valore di default DA RISOLVERE
            
            
            // robeeeeeeeeeeeeeeeeeeeeeeeeeee
            InputStream contenutoFile = file.getInputStream();
            File daSalvare = new File("/home/fpw/Scrivania/proveraimo/web/img/"+file.getSubmittedFileName());
            Files.copy(contenutoFile, daSalvare.toPath(), StandardCopyOption.REPLACE_EXISTING);
            
            prodotto.setFoto("img/"+file.getSubmittedFileName()); // foto base
            // fine robeeeeeeeeeeeeeeeeeeeeee
            
            
            
            
            
            // devo recuperare id_utente
            // prendo username dalla sessione e faccio una ricerca per su db prendo l'id e lo rendo
            
            // username preso dalla sessione
            String username=session.getAttribute("user").toString();
            // cerco per username nel db in modo da trovare l'id e lo restituisco
            id_utente=UtenteFactory.getInstance().getIdUtente(username);
            
            prodotto.setUtente_id(id_utente); // id_utente
            
            // funz che agg prodotto a db
            ProdottiFactory.getInstance().insertProdotto(prodotto, id_utente);
            
            
            // controllo che il prodotto ci sia veramente
            Prodotti conferma_prodotto =ProdottiFactory.getInstance().getProdotto(nome);
            
            // recupero il proprietario dal db
            String owner=ProdottiFactory.getInstance().getOwner(conferma_prodotto);
            
            // setto attributi su request prodotto appena aggiunto e utente che lo ha inserito
            
            request.setAttribute("nuovo_prodotto", conferma_prodotto);
            request.setAttribute("owner",owner);
            
            request.getRequestDispatcher("confermaProdotto.jsp").forward(request, response);

            
        } catch(InvalidParamException e){
            request.setAttribute("nomeProdotto", nome);
            request.getRequestDispatcher("aggiungiprodotti.jsp").forward(request, response);
        }
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

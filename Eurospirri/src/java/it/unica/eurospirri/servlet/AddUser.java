
// servlet per aggiunta nuovi utenti, non implementata lato db

package it.unica.eurospirri.servlet;

import it.unica.eurospirri.exceptions.InvalidParamException;
import it.unica.eurospirri.model.Utente;
import it.unica.eurospirri.model.UtenteFactory;
import it.unica.eurospirri.utils.Utils;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AddUser", urlPatterns = {"/AddUser"})
public class AddUser extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InvalidParamException {
        
        
        String message="Registrazione avvenuta con successo";
        
        // prende i parametri del form
        String email= request.getParameter("email");
        String user= request.getParameter("user");
        String pass= request.getParameter("pass");
        String pass2= request.getParameter("pass2");
        
        String nome=request.getParameter("name");
        String cognome=request.getParameter("cognome");
        String citta=request.getParameter("citta");
        
        
        
        try{
            
            // controllo correttezza 
            Utils.checkString("email", email, 1, 50);
            Utils.checkString("user", user, 1, 50);
            Utils.checkNewPass("pass", pass, 5, "pass2", pass2);
            
            Utente nuovo_utente=new Utente();
            
            nuovo_utente.setUsername(user); // username
            nuovo_utente.setPassword(pass); // password
            nuovo_utente.setEmail(email); // email
            nuovo_utente.setNome(pass); // nome
            nuovo_utente.setCognome(pass); // cognome
            nuovo_utente.setCitta(pass); // citta
            
            // qui parte connessione al db per inserire i dati effettivamente
            if(UtenteFactory.getInstance().insertUtente(nuovo_utente)>0  ){
                
                // funzione che legge l'utente appena inserito in utenteFactory
                Utente conferma_utente= UtenteFactory.getInstance().getUtenteByUsernamePassword(user, pass);
                
                // imposto attributi di request in modo da visualizzarlo in confermaUtente.jsp
                request.setAttribute("nuovo_utente", conferma_utente);
                
                request.getRequestDispatcher("confermaUtente.jsp").forward(request, response);
            }
            
            
            request.getRequestDispatcher("confermaUtente.jsp").forward(request, response);
            
        } catch(InvalidParamException e){
            request.getRequestDispatcher("login.jsp").forward(request, response);

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
        try {
            processRequest(request, response);
        } catch (InvalidParamException ex) {
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (InvalidParamException ex) {
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
        }
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

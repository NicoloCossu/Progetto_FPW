
// servlet per il login dell'utente

package it.unica.eurospirri.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import it.unica.eurospirri.utils.*;
import it.unica.eurospirri.exceptions.InvalidParamException;
import it.unica.eurospirri.model.*;
/**
 *
 * @author nicos
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String user = request.getParameter("user");
        String password = request.getParameter("pass");
        
        try{
            // min e max per dimensione campi (controllo)
            int minSize = 5;
            int maxSize = 15;
            
            // controllo validita
            Utils.checkString("User", user, minSize, maxSize);
            Utils.checkString("Password", password, minSize, maxSize);
            
            // cerca l'utente, null se non trova(l'utente non esiste nel db percio login fallito)
            Utente utente= UtenteFactory.getInstance().getUtenteByUsernamePassword(user, password);
            
            if(utente!=null){ // if sul risultato della ricerca
                
                // setto attirbuti presi da db in sessione 
                session.setAttribute("name",utente.getNome());
                session.setAttribute("citta", utente.getCitta());
                session.setAttribute("cognome",utente.getCognome());
                session.setAttribute("email", utente.getEmail());
                session.setAttribute("user",utente.getUsername());
                
                // salvo il lastLogin
                session.setAttribute("lastLogin", Utils.convertTime(session.getLastAccessedTime()));
                
                // setto l'intervallo massimo di inattivita in sessione
                session.setMaxInactiveInterval(120);
                
                // mando a servlet "inutile" (pezzo da cambiare, meglio direttamente a jsp)
                request.getRequestDispatcher("user").forward(request, response);
    
            }
            
        
            else{
                throw new InvalidParamException("User o pass non validi");
            }
            
        } catch(InvalidParamException e){
            // invalido sessione
            session.invalidate();
            // setto su request gli attributi per la visualizzazzione dell'errore
            request.setAttribute("errorMessage", e.getMessage()); // meglio visualizzare questo messaggio in pagina di errore
            // l'attributo link sembra molto utile (DA USARE)
            request.setAttribute("link", "login.jsp"); // questa parte non viene utilizzata (meglio farlo) HINT IMPORTANTE
            request.getRequestDispatcher("errore.jsp").forward(request, response);
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

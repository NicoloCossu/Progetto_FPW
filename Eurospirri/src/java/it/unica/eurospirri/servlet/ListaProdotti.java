
// servlet per visualizzazione elenco prodotti

package it.unica.eurospirri.servlet;

import it.unica.eurospirri.model.Prodotti;
import it.unica.eurospirri.model.ProdottiFactory;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ListaProdotti", urlPatterns = {"/ListaProdotti"})
public class ListaProdotti extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // recupera da db la lista dei prodotti
        List<Prodotti> prodotti = ProdottiFactory.getInstance().getAllProdotti();
        
        // recupera nomi degli utenti che hanno inserito i prodotti
        List<String> owners = ProdottiFactory.getInstance().getOwners(prodotti);
         
        
        // setta attributo listaOwners e listaProdotti
        request.setAttribute("listaProdotti",prodotti);
        request.setAttribute("listaOwners",owners);
        
        // forward alla jsp
        request.getRequestDispatcher("prodotti.jsp").forward(request, response);
        
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

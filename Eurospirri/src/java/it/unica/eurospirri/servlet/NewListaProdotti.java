/*
 Pagina utilizzata per il nuovo elenco prodotti inviando json al client senza 
ricaricare la pagina.
 */
package it.unica.eurospirri.servlet;

import it.unica.eurospirri.model.Prodotti;
import it.unica.eurospirri.model.ProdottiFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "NewListaProdotti", urlPatterns = {"/NewListaProdotti"})
public class NewListaProdotti extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
   
        String cmd = request.getParameter("offsetId");
        if(cmd!=null){
       
            Prodotti prodotto = ProdottiFactory.getInstance().getProdottoById(Long.valueOf(cmd));
            String owner = ProdottiFactory.getInstance().getOwner(prodotto);
            request.setAttribute("prodotto", prodotto);
            request.setAttribute("owner", owner);
            response.setContentType("application/json"); 
            response.setHeader("Expires", "Sat, 6 May 1995 12:00:00 GMT");
            response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
            request.getRequestDispatcher("js/prodottoJSON.jsp").forward(request, response);
            
            
        }else{
            
            Prodotti prodotto = ProdottiFactory.getInstance().getProdottoById(Long.valueOf("1"));
            String owner = ProdottiFactory.getInstance().getOwner(prodotto);
            request.setAttribute("prodotto", prodotto);
            request.setAttribute("owner", owner);
            request.getRequestDispatcher("new_prodotti.jsp").forward(request, response);
            
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

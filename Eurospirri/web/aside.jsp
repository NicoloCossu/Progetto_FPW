<%-- 
l'aside viene sfruttato come spazio pubblicitario e informativo, come possiamo
notare, sono presenti gli orari di apertura  e delle varie foto che se cliccate
reindirizzano l'utente alla home del sito
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
    </head>
    <body>
        <div class="col-4" id="colonna_destra">
       <aside>
            <h2>Annunci</h2>
            <p>
                <b>Orari apertura:</b><br><br>
                LUN 8.00-20.00<br>
                MAR 8.00-20.00<br>
                MER 8.00-20.00<br>
                GIO 8.00-20.00<br>
                VEN 8.00-20.00<br>
                SAB 8.00-20.00<br>
                DOM 8.00-12.00<br>
            </p>
            <div class="col-12">
                <div class="col-6">
                    <a href="prodotti.jsp">
                    <img title="Volantino" alt="Volantino EuroSpirri" src="img/volantino.png" width="150" height="150">
                    </a>
                </div>
                <div class="col-6">
                    <a href="prodotti.jsp">
                    <img title="Offerta" alt="Offerta EuroSpirri" src="img/offerta.png" width="150" height="150">
                    </a>
                </div><!-- comment -->
                <div class="col-6">
                    <a href="prodotti.jsp">
                    <img title="Frutta Fresca" alt="Offerta Frutta" src="img/frutta_fresca.png" width="150" height="150">
                    </a>
                </div><!-- comment -->
                <div class="col-6">
                    <a href="prodotti.jsp">
                    <img title="Frutta Fresca" alt="Offerta Frutta" src="img/offerta4.png" width="150" height="150" >
                    </a>
                </div>
            </div>
        </aside>
        </div>
    </body>
</html>

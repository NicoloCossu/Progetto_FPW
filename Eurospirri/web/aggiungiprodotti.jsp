<%-- 
  aggiungi prodotto presenta le stesse caratteristiche dell'omonima pagina in 
html con la differenza che al suo interno sono collegate le varie pagine e
controlli creati tramite jsp
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <%--controllo sessione --%> 
        <c:if test="${empty user}">
            <c:redirect url="login.jsp"/>
        </c:if>
        <title>Aggiungi un prodotto</title>
            <jsp:include page="head.jsp" />
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="js/jquery_AddProd.js"></script>
    </head>
    
    <body>
        <header>
            
            <div class="col-2">
                <a href="index.jsp" id="torna">
                    <img title="Logo" alt="Logo EuroSpirri" src="img/nuovo logo progetto.png" width="150" height="150" id="logo">
                </a>
            </div>

            <div class="col-10">
                <h1>Aggiungi prodotti</h1>
            </div>
        
        </header>
         
        
        <jsp:include page="nav.jsp" />
         <%--qui di seguito è presente un controllo sull'attributo nome per 
        vedere se il prodotto è stato effettivamente inserito, in caso contrario
        viene visualizzata a schermo la scritta riportata sulla riga 43--%> 
         <c:if test="${not empty nome}">
              <h2>CARICAMENTO PRODOTTO FALLITO</h2>
         </c:if>
        <div class="col-8">
            <article>
                <form id="formProdotto" action="AddProd" method="post" enctype="multipart/form-data">
                    
                    <label for="prodotto">Nome Prodotto</label> 
                    <input type="text" id="nomeProdotto" name="nomeProdotto"/><br><br>
                    <p id="caratteriRimanenti"></p>
                    <h5 id="erroreNome"><h5/>
                            
                    <label for="Descrizione">Descrizione</label> 
                    <textarea rows="4" cols="20" name="descrizione" id="descrizione"></textarea><br><br>
                    <p id="caratteriRimanenti2"></p>
                    <h5 id="erroreDescrizione"><h5/>
                    
                    
                    <label for="myfile">Seleziona un file:</label>
                    <input type="file" id="file" name="file" accept="image/png, image/jpeg"><br><br>

                    <label for="Data">Data di scadenza:</label>
                    <input type="date" id="Data" name="data"><br><br>

                    <label for="quantity">Quantità:</label>
                    <input type="number" id="quantita" name="quantita" min="1" max="100"><br><br>
                    <h5 id="erroreQuantita"><h5/>
                        
                    <label for="quantity">Prezzo:</label>
                    <input type="number" min="0.00" max="10000.00" step="0.01" name="prezzo" id="prezzo" /><br><br>
                    <h5 id="errorePrezzo"><h5/>
                    
                    <input id="caricaProdotto" type="submit" value="Carica il prodotto"/><br><br>
                </form>
            </article>
        </div>

        <jsp:include page="aside.jsp" />
        <jsp:include page="footer.jsp" />

    </body>        
    
</html>
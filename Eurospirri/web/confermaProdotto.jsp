<%--
la pagina conferma prodotti visualizza a schermo i dati di un prodotto dopo che 
è stato inserito da un utente.
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <head>
            <jsp:include page="head.jsp" />
        <title>Benvenuto</title>
        </head>
        <body>
            <header>

                    <div class="col-2">
                        <a href="index.jsp" id="torna">
                            <img title="Logo" alt="Logo EuroSpirri" src="img/nuovo logo progetto.png" width="150" height="150" id="logo">
                        </a>
                    </div>

                    <div class="col-10">
                        <h1>Benvenuto </h1>
                    </div>

            </header>
            <jsp:include page="nav.jsp" />
            <div class="col-4"></div>
            <div id="userBox" class="col-4">
                    <h2>Nome: ${nuovo_prodotto.getNome()}</h2>
                    <h2>Descrizione: ${nuovo_prodotto.getDescrizione()}</h2>
                    <h2>Quantita: ${nuovo_prodotto.getQuantita()}</h2>
                    <h2>Foto: ${nuovo_prodotto.getFoto()}</h2>
                    <h2>Data scadenza: ${nuovo_prodotto.getScadenza()}</h2>
                    <h2>Prezzo: ${nuovo_prodotto.getPrezzo()}</h2>
                    <h2>Prodotto inserito da: ${owner}</h2>
            </div>
            <div class="col-4"></div>
            
            <jsp:include page="footer.jsp"/>
        </body>
</html>

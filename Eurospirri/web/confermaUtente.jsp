<%--
la pagina conferma utente visualizza a schermo i dati di un utente dopo che ha
eseguito la  registrazione.
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
                    <h2>Username: ${nuovo_utente.getUsername()}</h2>
                    <h2>Nome: ${nuovo_utente.getNome()}</h2>
                    <h2>Cognome: ${nuovo_utente.getCognome()}</h2>
                    <h2>Città: ${nuovo_utente.getCitta()}</h2>
                    <h2>Email: ${nuovo_utente.getEmail()}</h2>
            </div>
            <div class="col-4"></div>
            
            <jsp:include page="footer.jsp"/>
        </body>
</html>

<%-- 
controllo sul login tale che se quest'ultimo è non valido, errore.jsp fa 
visualizzare a schermo la scritta presente nella riga 12 mentre nella riga 13
abbiamo un link che riporta alla pagina di login
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="head.jsp" />
    <body>
        <h2>Login non valido</h2>
        <a href="login.jsp">Torna al login</a>
    </body>
</html>

<%-- 
  il nav è dedicato alla barra di selezione delle varie pagine, cliccando su
una delle voci l'utente verrà reindirizzato alla pagina menzionata. Il nav è 
composto da un form che comprende una lista non ordinata. Sempre nella barra
di navigazione sono presenti 3 tasti per la regolazione del font.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="js/jquery_Login.js"></script>
    </head>
    <body>
        <div class="col-12">
            <c:if test="${empty user}">
                <nav>
                <ul>
                    <li><a href="index.jsp"><mark>Home</mark></a></li>
                    <li><a href="login.jsp">Login</a></li>
                    <li><a href="aggiungiprodotti.jsp">Aggiungi Prodotti</a></li>
                    <li><a href="chisiamo.jsp">Chi Siamo</a></li>                
                    <li><img title="font_down" alt="font down button" src="img/font_down.png" width="50" height="50" id="font_down"></li>
                    <li><img title="font_normal" alt="font normal button" src="img/font_normal.png" width="50" height="50" id="font_normal"></li>
                    <li><img title="font_up" alt="font up button" src="img/font_up.png" width="50" height="50" id="font_up"></li>
                </ul>
                </nav>
            </c:if>
            
            <c:if test="${not empty user}">
                <nav>
                <ul>
                    <li><a href="index.jsp"><mark>Home</mark></a></li>
                    <li><a href="NewListaProdotti">Elenco Prodotti</a></li>
                    <li><a href="aggiungiprodotti.jsp">Aggiungi Prodotti</a></li>
                    <li><a href="chisiamo.jsp">Chi Siamo</a></li>
                    <li><a href="Logout">Logout</a></li>
                </ul>
                </nav>   
            </c:if>
            
        </div>
    </body>
</html>

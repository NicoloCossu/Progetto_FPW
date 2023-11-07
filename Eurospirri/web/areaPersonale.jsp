<%--
l'area personale visualizza i dati di un utente dopo che ha eseguito il login,
è presente un controllo sull'attributo user della sessione.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <c:if test="${empty user}">
        <c:redirect url="login.jsp"/>
    </c:if>
    <c:if test="${not empty user}">
        <c:set var="page" value="datiCorretti" scope="session"/>
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
                        <h1>Benvenuto ${name}</h1>
                    </div>

            </header>
            <jsp:include page="nav.jsp" />
            <div class="col-4"></div>
            <div id="userBox" class="col-4">
                    <h2>Nome: ${name}</h2>
                    <h2>Cognome: ${cognome}</h2>
                    <h2>E-mail: ${email}</h2>
                    <h2>Città: ${citta}</h2>
            </div>
            <div class="col-4"></div>
            
            <jsp:include page="footer.jsp"/>
        </body>
    </c:if> 
</html>

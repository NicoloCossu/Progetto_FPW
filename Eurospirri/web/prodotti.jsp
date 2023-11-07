<%-- 
prodotti presenta le stesse caratteristiche della pagina "elenco prodotti"
in html con la differenza che al suo interno sono collegate le varie pagine 
e controlli creati tramite jsp 
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <c:if test="${empty user}"> 
        <c:redirect url="login.jsp"/>
        </c:if><!-- comment -->
        
        <c:if test="${not empty user}">
            <head>
                <title>Elenco Prodotti</title>
                <jsp:include page="head.jsp" />
            </head>
            <body>
                 <header>
                    <div class="col-2">
                         <a href="index.jsp" id="torna">
                        <img title="Logo" alt="Logo EuroSpirri" src="img/nuovo logo progetto.png" width="150" height="150" id="logo">
                        </a>
                    </div>

                    <div class="col-10">
                         <h1>Elenco Prodotti</h1>
                    </div>
                </header>


                <jsp:include page="nav.jsp" />
                
                <div class="col-8">
                    <c:if test= "${empty listaProdotti}">
                        <c:redirect url="/index.jsp"/>
                    </c:if>
                    <c:if test = "${not empty listaProdotti}">
                        <article
                            <%-- per far scorre due liste assieme(listaProdotti e listaOwners):call varStatus.index to get the 
                                 index of the current round of iteration, and then use it as a lookup for the second list. --%>
                     
                            
                        <c:forEach items= "${listaProdotti}" var="prodotto" varStatus = "status" >
                            <section>
                                <h2>Prodotti inserito da : ${listaOwners[status.index]}</h2>

                                <img title="prodotto.title foto" alt="vefavef" src="${prodotto.getFoto()}" width="100" height="100">
                                <p><b>Nome:</b> ${prodotto.getNome()}
                                </p>
                                <p><b>Descrizione:</b> ${prodotto.getDescrizione()}
                                </p>
                                <p><b>Quantità:</b> ${prodotto.getQuantita()}</p>
                                <p><b>Scadenza:</b> ${prodotto.getScadenza()}</p>
                                <p><b>Prezzo:</b> ${prodotto.getPrezzo()}</p>
                        </section>
                        </c:forEach>
                        </article>
                    </c:if>
                </div>
                <jsp:include page="aside.jsp" />
                <jsp:include page="footer.jsp" />

            </body>

        </c:if>

</html>

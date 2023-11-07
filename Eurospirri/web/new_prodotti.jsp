<%-- 
  Jsp che permette la visualizzazione del singolo prodotto mediante scorrimento 
 con comandi ajax senza ricaricare la pagina
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
                <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
                <script type="text/javascript" src="js/ajax_script.js"></script>
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
                    <c:if test= "${empty prodotto}">
                        <c:redirect url="/index.jsp"/>
                    </c:if>
                    <c:if test = "${not empty prodotto}">
                        <article>
                            
                            
                        
                            <section>
                                <h2 id="owner" >Prodotto inserito da : ${owner}</h2>

                                <img id="foto" title="prodotto.title foto" alt="vefavef" src="${prodotto.getFoto()}" width="100" height="100">
                                <p id="nome" ><b>Nome:</b> ${prodotto.getNome()}
                                </p>
                                <p id="descrizione" ><b>Descrizione:</b> ${prodotto.getDescrizione()}
                                </p>
                                <p id="quantita" ><b>Quantità:</b> ${prodotto.getQuantita()}</p>
                                <p id="scadenza" ><b>Scadenza:</b> ${prodotto.getScadenza()}</p>
                                <p id="prezzo" ><b>Prezzo:</b> ${prodotto.getPrezzo()}</p>
                            </section>
                            <section>
                                <img id="tasto_freccia_su" src="img/freccia_su.png" alt="freccia su" width="50px" height="50px"/>
                                <img id="tasto_freccia_giu" src="img/freccia_giu.png" alt="freccia su" width="50px" height="50px"/>
                                
                            </section>
                        </article>
                    </c:if>
                </div>
                <jsp:include page="aside.jsp" />
                <jsp:include page="footer.jsp" />

            </body>

        </c:if>

</html>
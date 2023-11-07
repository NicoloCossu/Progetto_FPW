<%-- 
  index presenta le stesse caratteristiche dell'omonima pagina in html
con la differenza che al suo interno sono collegate le varie pagine e controlli
creati tramite jsp 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <title>EuroSpirri</title>
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
                 <h1>EuroSpirri</h1>
            </div>
        </header>
        
        <jsp:include page="nav.jsp" />
        
        <div class="col-8">
            <article>
            <section>
                <h2>Presentazione</h2>
                <p>
                    Siamo <strong>EuroSpirri</strong> <b>il più grande Gruppo sardo.</b>Lo siamo perchè
            1 milione di clienti ci hanno scelto e molti altri scoprono
            ,ogni giorno, l'unicità della nostra proposta.
            Lo siamo perchè abbiamo <b>50 punti vendita</b>
            ,più di <b>1000 dipendenti</b>
            e siamo presenti in <strong>Sardegna</strong> da 20 anni,
            sviluppando un fatturato che nel 2019 si è attestato 
            intorno agli <b>800 milioni di euro</b>.
                </p>
            </section>
            <section>
                <h2>Storia</h2>
                <p> <b>EuroSpirri nasce nel 2002</b> dall’idea di quattro imprenditori 
                sardi della grande distribuzione, che hanno voluto dare una risposta
                tutta sarda alla crescente richiesta di risparmio 
                da parte dei clienti.
                </p>
                </section>
            <section>
                <h2>Territorio</h2>
                <p> EuroSpirri è l’interpretazione sarda del discount. 
            <b>La proprietà è 100% sarda</b>, il punto vendita soddisfa 
            l’esigenza di un  ambiente familiare tipica del consumatore sardo,
            l’assortimento è costruito sui bisogni quotidiani legati
            alle abitudini gastronomiche sarde. </p>
           </section>
                <a href="#torna">Torna Su</a>
            </article>
        </div>
        
        
        <jsp:include page="aside.jsp" />
        <jsp:include page="footer.jsp" />
   
        
       
    </body>
</html>
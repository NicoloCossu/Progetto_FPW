<%-- 
  chi siamo presenta le stesse caratteristiche dell'omonima pagina in html
con la differenza che al suo interno sono collegate le varie pagine e controlli
creati tramite jsp 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Chi Siamo</title>
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
                 <h1>Chi siamo</h1>
            </div>
        </header>
        
        <jsp:include page="nav.jsp" />
        <div class="col-8">
            <article>
            <section>
                <h2>Riccardo Cadoni:</h2>
        <img title="Riccardo" alt="Immagine profilo" src="img/gigi.jpg" width="100" height="80">
        <p>
            Laureato ad Harvard con il massimo dei voti è tornato in sardegna
            per aprire insieme ai suoi colleghi la realtà di EuroSpirri.
        </p>
        </section>
        <section>
        <h2>Raimondo Masala:</h2>
        <img title="Raimondo" alt="Immagine profilo" src="img/gandalf.jpg" width="100" height="80">
        <p>
            Raimondo è un vecchio vestito di grigio, con un grande cappello blu a punta,
            una sciarpa argentata e stivali neri. Ha i capelli lunghi e bianchi, così come la barba,
            e caratteristica particolare del suo aspetto sono le sopracciglia
            particolarmente folte e talmente lunghe da spuntare dall'orlo del suo cappello.
            La sua saggezza è stata utilissima per mettere in piedi un impero economico
            come EuroSpirri.
        </p>
            </section>
            
            <section>
                <h2>Nicolò Cossu:</h2>
        <img title="Nicolò" alt="Immagine profilo" src="img/joker.jpg" width="100" height="80">
        <p>
           Nicolò è un individuo profondamente alienato che, nella
           Città del sole sempre più preda del degrado e della disuguaglianza sociale,
           vive con l'anziana madre Penny in un appartamento dei bassifondi.
           Ha sfruttato la sua rabbia nei confronti dellà società per sfondare 
           a livello economico unendosi al progetto di EuroSpirri.
        </p>
            </section>
         
        <section>
         <h2>Alessandro Tinti:</h2>
        <img title="alessandro" alt="Immagine profilo" src="img/tony.jpg" width="100" height="80">
        <p>
            Alessandro è considerato da tutti un genio, un playboy, 
            un filantropo e un inventore;La storia di EuroSpirri
           diventa il simbolo dell'ingegno e della creatività umana.
        </p>
        </section>
                
          <a href="#torna">Torna Su</a>
            </article>
        </div>
        
        <jsp:include page="aside.jsp" />
        <jsp:include page="footer.jsp" />
    </body>
</html>
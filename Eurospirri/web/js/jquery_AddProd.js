// il documento è pronto
$(document).ready(function () {
    
    
    
    
    // controlla il nomeProdotto
    $('#erroreNome').hide(); // hide del messaggio di errore
    let nomeCheck=true; // serve per la validate intera
    $('#nomeProdotto').keyup(function() {
       checkNomeProdotto(); 
    });
    function checkNomeProdotto(){
        let nome= $('#nomeProdotto').val();
        if(nome.length<=0){
            $("#erroreNome").show();
            $("#erroreNome").html("si deve inserire almeno un carattere");
            $("#erroreNome").css("color", "red");
            nomeCheck=false;
            return false;
        }else {
            if(nome.lenght>50){
                $("#erroreNome").show();
                $("#erroreNome").html("massimo 50 caratteri");
                $("#erroreNome").css("color", "red");
                nomeCheck=false;
                return false;
            }else{
                $('#erroreNome').hide();
                nomeCheck=true;
                return true;
            }
        }
        
    }
    
    // descrizione
    $('#erroreDescrizione').hide(); // hide del messaggio di errore
    let descrizioneCheck=true; // serve per la validate intera
    $('#descrizione').keyup(function() {
       checkDescrizione(); 
    });
    function checkDescrizione(){
        
        
        let descrizione=$('#descrizione').val();
        if(descrizione.length<=0){
            $("#erroreDescrizione").show();
            $("#erroreDescrizione").html("si deve inserire almeno un carattere");
            $("#erroreDescrizione").css("color", "red");
            descrizioneCheck=false;
            return false;
        }else {
            if(descrizione.lenght>50){
                $("#erroreDescrizione").show();
                $("#erroreDescrizione").html("massimo 50 caratteri");
                $("#erroreDescrizione").css("color", "red");
                descrizioneCheck=false;
                return false;
            }else{
                $('#erroreDescrizione').hide();
                descrizioneCheck=true;
                return true;
            }
        }
        
        
    }
    
    
    // quantita
    $('#erroreQuantita').hide(); // hide del messaggio di errore
    let quantitaCheck=true; // serve per la validate intera
    $('#quantita').keyup(function() {
       checkQuantita(); 
    });
    function checkQuantita(){
        
        
        let quantita=$('#quantita').val();
        if(quantita<=0){
            $("#erroreQuantita").show();
            $("#erroreQuantita").html("il valore deve essere maggiore di zero");
            $("#erroreQuantita").css("color", "red");
            quantitaCheck=false;
            return false;
        }else {
            if(quantita>50){
                $("#erroreQuantita").show();
                $("#erroreQuantita").html("massimo 50 pezzi");
                $("#erroreQuantita").css("color", "red");
                quantitaCheck=false;
                return false;
            }else{
                $('#erroreQuantita').hide();
                quantitaCheck=true;
                return true;
            }
        }
        
        
    }
    
    
    // prezzo
    $('#errorePrezzo').hide(); // hide del messaggio di errore
    let prezzoCheck=true; // serve per la validate intera
    $('#prezzo').keyup(function() {
       checkPrezzo(); 
    });
    function checkPrezzo(){
        
        
        let prezzo=$('#prezzo').val();
        if(prezzo<=0){
            $("#errorePrezzo").show();
            $("#errorePrezzo").html("il prezzo deve essere maggiore di zero");
            $("#errorePrezzo").css("color", "red");
            prezzoCheck=false;
            return false;
        }else {
            if(prezzo>50){
                $("#errorePrezzo").show();
                $("#errorePrezzo").html("il prezzo massimo e 50");
                $("#errorePrezzo").css("color", "red");
                prezzoCheck=false;
                return false;
            }else{
                $('#errorePrezzo').hide();
                prezzoCheck=true;
                return true;
            }
        }
        
        
    }
    
    $("#caricaProdotto").click(function () {
            // tutti i controlli
            checkNomeProdotto();
            checkDescrizione();
            checkQuantita();
            checkPrezzo();
            
            if ( nomeCheck == true && descrizioneCheck == true && quantitaCheck == true && prezzoCheck == true){
                return true;
            } 
            else {
                return false;
            }
    });
    
    
    
    
    
  
});
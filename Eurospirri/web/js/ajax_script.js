/*
 * Funzioni per scorrere i prodotti senza ricaricare la pagina, la variabile offset
 * viene inviata al server per specificare il prodotto da visualizzare.
 */
var offset = 1;
$(document).ready(function () {


$('#tasto_freccia_su').click(function()
{
    if(offset>1)
        offset--;
    $.ajax({
        url:"NewListaProdotti",
        data:{
            offsetId: offset
        },
        dataType: "json",
        success: function (data,state){
            aggiornaProdotto(data);
        },
        error: function(data,state){
        }
    });
});


$('#tasto_freccia_giu').click(function()
{
    offset++;
    $.ajax({
        url:"NewListaProdotti",
        data:{
            offsetId: offset
        },
        dataType: "json",
        success: function (data,state){
            if(data.nome === ""){
                offset--;
            } else
                aggiornaProdotto(data);
        },
        error: function(data,state){   
        }
    });
});

function aggiornaProdotto(data){
   
   $("#owner").text("Prodotto inserito da : "+data.owner);
   $("#foto").attr("src",data.foto);
   $("#nome").html("<b>Nome:</b> " + data.nomeProdotto);
   $("#descrizione").html("<b>Descrizione:</b> "+ data.descrizione);
   $("#quantita").html("<b>Quantità:</b> "+ data.quantita);
   $("#prezzo").html("<b>Prezzo:</b> "+ data.prezzo);
   
   
}




});
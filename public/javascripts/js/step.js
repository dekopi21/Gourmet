$(document).ready(function () {
    //declaration des variable au niveau du compte

    var email = $("#inputEmail2").val();
    var telephone = $("#Tel").val();
    var ville = $("#Ville").val();
    var quartier = $("#Quartier").val();
    var pass = $("#inputMdp").val();
    var pass1 = $("#pwd").val();
    var nom = $("#nom").val();
    var prenom = $("#prem").val();
    var login = $("#login").val();
    var sexe = $("#sexe").val();
    var nomUser = $("#nomUs").val();
    var passUser = $("#pass").val();

    // declaration des variable du mode de livraison

    var mode_livraison_retrait = $("#radioRetrait").val();
    var mode_livraison_domicile = $("#inputadr").val();

    // declaration de variable de mode de Facturation
    var adresse_de_facturation = $("#inputadrFac").val();


    $("#msform").submit(function () {

    });

    $("#btn-next-4").click(function () {
        recapitulatif();
    });
    
    function testUtilisateur() {
        
    }
});


function recapitulatif() {
    $("#adresseLiv").text($("#inputadrFac").val());
    if($("#inputadr").val() != null)
    $("#modeLivraison").text($("#inputadr").val());
    else
        $("#modeLivraison").text($("#radioRetrait").val());
    $("#modPaie").text();
}
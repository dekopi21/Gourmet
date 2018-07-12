$(document).ready(function () {
    $("#rd1").hide();
    $("#rd2").show();
    $("#sec2").hide();
    $("#sec3").hide();
    $("#sec4").hide();
    $("#colr").hide();

    $("#rad1").click(function () {
        $("#rd1").show();
        $("#rd2").hide();
    });
    $("#rad2").click(function () {
        $("#rd2").show();
        $("#rd1").hide();
    });

    $("#btn2,#btn1:not(#sec3,#sec4)").click(function () {
        $("#sec1").hide();
        $("#sec2").show();
    });

    $("#btn3:not(#sec1,#sec4)").click(function () {
            $("#sec2").hide();
            $("#sec3").show();
        }
    );


    $("#btn4:not(#sec1,#sec2)").click(function () {
            $("#panier").hide();
            $("#sec3").hide();
            $("#sec4").show();
            $("#txt").hide();
        }
    );

});


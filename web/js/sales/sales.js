$("#linkSales").click(function() {
    $("#title").html('<i class="bi bi-cart4"></i> Modulo de Ventas');
    $("#contenido").empty();
    $("#contenido").load("/app-web-sales/sale/",function (){
        getSale();
    });
});

function getSale(){
    alert("Iniciando nueva venta");
}

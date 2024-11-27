$("#linkProducts").click(function () {
    $("#title").html('<i class="bi bi-basket2"></i> Modulo de Productos');
    $("#contenido").empty();
    $("#contenido").load("/app-web-sales/mnto/product/", function () {
        getProducts();
    });
});

function getProducts() {
    var url = "/app-web-sales/mnto/product/obtain";
    fetch(url).then(response => {
        if (!response.ok) {
            throw new Error("Error al consumir el controlador");
        }
        return response.json();
    }).then(data => {
        if (data.code === "200") {
            showProducts(data.products);
        } else {
            showToast("error", data.message);
        }
    }).catch(error => {
        showToast("error", error);
    });
}

function showProducts(products) {
    $("#tableProducts tbody").empty();
    $.each(products, function (index, value) {
        var row = $('<tr>');
        row.append($('<td class="text-center">').text(index + 1));
        row.append($('<td class="text-center">').text(value.code));
        row.append($('<td>').text(value.name));
        row.append($('<td>').text(value.description));
        row.append($('<td class="text-center">').text(value.price));
        row.append($('<td class="text-center">').text(value.stock));
        row.append($('<td class="text-center">').text(value.state === 'A' ? 'ACTIVO' : 'INACTIVO'));
        row.append($('<td class="text-center">')
                .append('<a class="btn btn-warning btn-sm ms-1" onclick="editProduct(' + value.productId + ')"><i class="bi bi-pencil-square"></i></a>')
                .append('<a class="btn btn-danger btn-sm ms-1" onclick="deleteProduct(' + value.productId + ')"><i class="bi bi-trash"></i></a>'));
        $("#tableProducts tbody").append(row);
    });
}

$(document).on('click', "#btnSaveProduct", function () {
    saveProduct();
});

function saveProduct() {
    var formData = {};
    $("#productForm").find("input, select, textarea").each(function (index, element) {
        var fielName = $(element).attr("id");
        var fielValue = $(element).val();
        formData[fielName] = fielValue;
    });
    console.log(JSON.stringify(formData));
    var url = "/app-web-sales/mnto/product/save";
    fetch(url, {
        method: 'POST',
        body: JSON.stringify(formData),
        headers: {
            'Content-Type': 'application/json; charset=UTF-8'
        }
    }).then(response => {
        if (!response.ok) {
            throw new Error('Error al consumir el controlador');
        }
        return response.json();
    }).then(data => {
        if (data.code === "200") {
            showToast("success", data.message);
            showProducts(data.products);
            clearModalProduct();
        } else {
            showToast("error", data.message);
        }
    }).catch(error => {
        showToast("error", error);
    });
}

function editProduct(productId) {
    var url = "/app-web-sales/mnto/product/obtain/?id=" + productId;
    fetch(url, {
        method: 'GET'
    }).then(response => {
        if (!response.ok) {
            throw new Error('Error al consumir el controlador');
        }
        return response.json();
    }).then(data => {
        if (data.code === "200") {
            $("code").removeAttr("readonly");
            $("#modalCreateProduct").modal('show');

            $("#productId").val(data.product.productId);
            $("#code").val(data.product.code);
            $("#name").val(data.product.name);
            $("#description").val(data.product.description);
            $("#price").val(data.product.price);
            $("#stock").val(data.product.stock);

            $("#state option[value=" + data.product.state + "]").prop('selected', true);
        } else {
            showToast("warning", data.message);
        }
    }).catch(error => {
        showToast("error", error);
    });
    $("code").attr("readonly");
}

function  deleteProduct(productId) {
    var url = "/app-web-sales/mnto/product/delete/?id=" + productId;
    Swal.fire({
        title: "Estas seguro de eliminar?",
        text: "Recuerda! no podras recuperar.",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#3085d6",
        cancelButtonColor: "#d33",
        confirmButtonText: "SI",
        cancelButtonText: "NO"
    }).then((result) => {
        if (result.isConfirmed) {
            confirmDelete(url);
        }
    });
}
function confirmDelete(url){
    fetch(url,{
        method: 'GET'
    }).then(response=>{
        if(!response.ok){
            throw new Error('Error al consumir el controlador');
        }
        return response.json();
    }).then(data=>{
        if(data.code==="200"){
            getProducts();
            showToast("success",data.message);            
        }else{
            showToast("warning",data.message);
        }
    }).catch(error=>{
        showToast("error",error);
    });
}
function clearModalProduct() {
    $("#modalCreateProduct").modal('hide');
    $(".modal-backdrop").remove();
}

function showToast(type, message) {
    const Toast = Swal.mixin({
        toast: true,
        position: "top-end",
        showConfirmButton: false,
        timer: 2000,
        timerProgressBar: true,
        didOpen: (toast) => {
            toast.onmouseenter = Swal.stopTimer;
            toast.onmouseleave = Swal.resumeTimer;
        }
    });
    Toast.fire({
        icon: type,
        title: message
    });
}
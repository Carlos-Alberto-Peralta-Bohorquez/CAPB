<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
        <title>Login</title>
        <style>
            html,body{
                height: 100%;
            }
            body{
                display: flex;
                align-items: center;
                background-color: #F6F8FB;
            }
            .card{
                width: 100%;
                max-width: 330px;
                padding: 15px;
                margin: auto;
            }
        </style>
    </head>
    <body>
        <div class="card">
            <div class="card-body form-signin">
                <form id="loginForm" class="text-center">
                    <img class="mb-4" src="img/logo.png" width="72" height="72">
                    <h1 class="h3 mb-3 fw-normal">Iniciar Session</h1>
                    <div class="input-group mb-3">
                        <span class="input-group-text"><i class="bi bi-person-circle"></i></span>
                        <input type="text" class="form-control" name="username" value="admin" placeholder="Username">                         
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text"><i class="bi bi-lock-fill"></i></span>
                        <input type="password" class="form-control" name="password" value="123" placeholder="Password">                         
                    </div>
                    <button type="button" id="btnLogin" class="w-100 btn btn-primary"><i class="bi bi-arrow-return-right"></i> Ingresar</button>
                </form>
            </div>
        </div>        
    </body>
    <script src="js/jquery-3.7.1.min.js" type="text/javascript"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11" type="text/javascript"></script>
    <script>
        $("#btnLogin").click(function () {
            var formData = {};
            var context = "<%=request.getContextPath()%>";
            var url = context.concat("/").concat("login/login");
            $("#loginForm").find("input").each(function (index, element) {
                var fieldName = $(element).attr("name");
                var fieldValue = $(element).val();
                formData[fieldName] = fieldValue;
            });
            fetch(url, {
                method: "POST",
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(formData)
            }).then(response => {
                if (!response.ok) {
                    throw new Error('Error al consumir el controlador');
                }
                return response.json();
            }).then(data => {
                $("#btnLogin").prop('disabled', true).html('<span class="spinner-border spinner-border-sm" aria-hidden="true"></span><span role="status"> Ingresando...</span>');
                setTimeout(function () {
                    Swal.close();
                    if (data.code === "200") {
                        location.href = context.concat("/main/home");
                    } else {
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
                            icon: "error",
                            title: data.message
                        });
                        $("#btnLogin").prop('disabled', false).html('<i class="bi bi-arrow-return-right"></i> Ingresar');
                    }
                }, 1000);
            }).catch(error => {
                console.log("error:", error);
            });

        });
    </script>
</html>

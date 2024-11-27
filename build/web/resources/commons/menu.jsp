<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
    <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="#">SinFloo</a>
    <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
    <div class="navbar-brand d-lg-block dropdown collapse">
        <a href="#" class="ps-2 d-flex align-items-center text-white text-decoration-none dropdown-toggle" id="dropdownLogin" data-bs-toggle="dropdown" aria-expanded="false">
            <img src="${pageContext.request.contextPath}/img/user.jpg" width="32" height="32" class="rounded-circle me-2">
            <strong>Username</strong>
        </a>
        <ul class="dropdown-menu dropdown-menu-end text-small shadow text-center" aria-labelledby="dropdownLogin">
            <li>
                <a class="dropdown-item" href="#">
                    <img src="${pageContext.request.contextPath}/img/user.jpg" width="50" height="50" alt="" class="rounded-circle"/>
                </a>
            </li>
            <li><a class="dropdown-item" href="#">username</a></li>
            <li><a class="dropdown-item" href="#">example@gmail.com</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="../main/logout"><i class="bi bi-arrow-return-right pe-2"></i>Cerrar Session</a></li>
        </ul>
    </div>
</header>
<div class="container-fluid">
    <div class="row">
        <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
            <div style="height: 85vh; overflow-y: auto;">
                <div class="position-sticky pt-3 mt-3" id="menu">
                    <li class="list-group-item mb-2">
                        <h5 class="mt-1">Panel</h5>
                    </li>
                    <ul class="nav flex-column">
                        <li class="nav-item">
                            <a class="nav-link mouse" id="linkSales">
                                <i class="bi bi-cart-check"></i> Venta                           
                            </a>                        
                        </li>
                        <li class="nav-item">
                            <a class="nav-link mouse" id="linkProducts">
                                <i class="bi bi-basket"></i> Productos                           
                            </a>                        
                        </li>
                        <li class="nav-item">
                            <a class="nav-link mouse" id="linkCustomers">
                                <i class="bi bi-people-fill"></i> Clientes                           
                            </a>                        
                        </li>
                        <li class="nav-item">
                            <a class="nav-link mouse" id="linkReports">
                                <i class="bi bi-bar-chart"></i> Reporte de Ventas                           
                            </a>                        
                        </li>
                        <li class="nav-item">
                            <a class="nav-link mouse" id="linkCash">
                                <i class="bi bi-cash-coin"></i> Cierre de Caja                          
                            </a>                        
                        </li>
                    </ul>
                    <hr class="dropdown-divider">
                    <ul class="nav flex-column">
                        <li class="nav-item">
                            <a class="nav-link mouse" id="linkEployes">
                                <i class="bi bi-cart-check"></i> Empleados                           
                            </a>                        
                        </li>
                        <li class="nav-item">
                            <a class="nav-link mouse" id="linkPorfiles">
                                <i class="bi bi-basket"></i> Perfiles                           
                            </a>                        
                        </li>
                        <li class="nav-item">
                            <a class="nav-link mouse" id="linkConfigs">
                                <i class="bi bi-people-fill"></i> Configuciones                           
                            </a>                        
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4 " >
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h1 class="h2" id="title">Dashboard</h1>
                <div class="btn-toolbar mb-2 mb-md-0">
                    <div class="btn-group me-2">
                        <button type="button" class="btn btn-sm btn-outline-secondary">Share</button>
                        <button type="button" class="btn btn-sm btn-outline-secondary">Export</button>
                    </div>
                    <button type="button" class="btn btn-sm btn-outline-secondary dropdown-toggle">
                        <span data-feather="calendar"></span>
                        This week
                    </button>
                </div>
            </div>
            <div id="contenido">
                <canvas class="my-4 w-100" id="myChart" width="900" height="380"></canvas>
            </div>

        </main>
    </div>
</div>
<script>
    const menuItems = document.querySelectorAll('#menu ul .nav-link');
    menuItems.forEach(item => {
        item.addEventListener('click', () => {
            menuItems.forEach(i => i.classList.remove('active'));
            item.classList.add('active');
        });
    });
</script>

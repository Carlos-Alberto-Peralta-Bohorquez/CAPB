<jsp:include page="./../../../resources/commons/header.jsp"/>
<style>
    html, body{
        height: 100%;
    }
    body{
        display: flex;
        align-items: center;
        background-color: #F6F8FB;
    }
    .card{
        width: 100%;
        max-width: 50%;
        padding: 15px;
        margin: auto;
    }
</style>
<div class="container">
    <div class="card">
        <div class="card-body text-center">
            <h1>404</h1>
            <h5>${error}</h5>
            <div class="form-group">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/main/home"><i class="bi bi-arrow-return-left"></i> Volver</a>
            </div>
        </div>
    </div>
</div>
<jsp:include page="./../../../resources/commons/footer.jsp"/>

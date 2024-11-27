<div class="container">
    <a class="btn btn-info" id="btnCreateProduct" data-bs-toggle="modal" data-bs-target="#modalCreateProduct"><i class="bi bi-plus"></i> Nuevo</a>
    <div class="table-responsive-sm">
        <table class="table" id="tableProducts">
            <thead>
                <tr class="text-center">
                    <td>#</td>
                    <td>CODIGO</td>
                    <td>NOMBRE</td>
                    <td>DESCRIPCION</td>
                    <td>PRECIO</td>
                    <td>STOCK</td>
                    <td>ESTADO</td>
                    <td>ACCION</td>
                </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="modalCreateProduct" tabindex="-1" aria-labelledby="modalCreateProduct" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form id="productForm">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Modulo de Producto</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-sm-12">
                            <label class="form-label">Código</label>
                            <input type="text" id="code" class="form-control" readonly="">
                            <input type="hidden" id="productId" readonly="">
                        </div>
                        <div class="col-sm-12">
                            <label class="form-label">Nombre</label>
                            <input type="text" id="name" class="form-control">
                        </div>
                        <div class="col-sm-12">
                            <label class="form-label">Descripción</label>
                            <input type="text" id="description" class="form-control" >
                        </div>
                        <div class="col-sm-12">
                            <label class="form-label">Precio</label>
                            <input type="text" id="price" class="form-control" >
                        </div>
                        <div class="col-sm-12">
                            <label class="form-label">Stock</label>
                            <input type="text" id="stock" class="form-control">
                        </div>
                        <div class="col-sm-12">
                            <label class="form-label">Estado</label>
                            <select class="form-control" id="state">
                                <option value="A">ACTIVO</option>
                                <option value="I">INACTIVO</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" id="btnCancelSaveProduct" class="btn btn-danger" data-bs-dismiss="modal"><i class="bi bi-x-circle"></i> Close</button>
                    <button type="button" id="btnSaveProduct" class="btn btn-primary"><i class="bi bi-save"></i> Guardar</button>
                </div>
            </form>

        </div>
    </div>
</div>
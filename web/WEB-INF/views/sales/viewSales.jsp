<div class="m-2">
    <div class="card">
        <div class="card-body">
            <div class="row">
                <label class="form-label"><strong><i class="bi bi-person-vcard"></i> Datos del cliente</strong></label>
                <div class="mb-2 col-sm-2">
                    <div class="input-group">
                        <select class="form-control" id="typedoc">
                            <option value="1">DNI</option>
                            <option value="4">CE</option>
                            <option value="6">RUC</option>
                            <option value="7">PASAPORTE</option>
                        </select>
                    </div>
                </div>
                <div class="mb-2 col-sm-4">
                    <div class="input-group">
                        <input type="text" class="form-control" id="numdoc" placeholder="Ingrese numero de documento">
                        <button class="input-group-text" id="btnSearchCustomer"><i class="bi bi-search"></i></button>
                    </div>                    
                </div>
                <div class="mb-2 col-sm-6">                    
                    <div class="input-group">
                        <input type="text" class="form-control" id="name" placeholder="Nombre o Razon del cliente">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row mt-2">
        <div class="col-sm-4">
            <div class="card">
                <div class="card-body">
                    <div class="row">
                        <label class="form-label"><strong><i class="bi bi-archive"></i> Buscar Producto</strong></label>
                        <div class="mb-2 col-sm-12">
                            <label><i class="bi bi-qr-code"></i>Código</label>
                            <div class="input-group">
                                <input type="text" class="form-control" id="productCode" placeholder="Ingrese codigo del producto">
                                <button class="input-group-text"><i class="bi bi-search"></i></button>
                            </div>
                        </div>
                        <div class="mb-2 col-sm-12">
                            <label><i class="bi bi-arrow-right-circle"></i>Nombre</label>
                            <div class="input-group">
                                <input type="text" class="form-control" id="productName" placeholder="Teclado Logitech" readonly="">
                            </div>                            
                        </div>
                        <div class="mb-2 col-sm-12">
                            <label><i class="bi bi-arrow-right-circle"></i>Descripcion del producto</label>
                            <div class="input-group">
                                <input type="text" class="form-control" id="productDescription" placeholder="Teclado Logitech" readonly="">
                            </div> 
                        </div>
                        <div class="mb-2 col-sm-12">
                            <label><i class="bi bi-currency-exchange"></i>Precio</label>
                            <div class="input-group">
                                <input type="text" class="form-control" id="productPrice">
                            </div> 
                        </div>
                        <div class="mb-2 col-sm-12">
                            <label><i class="bi bi-arrow-down-up"></i>Cantidad</label>
                            <div class="input-group">
                                <input type="number" class="form-control" id="productQuanty">
                            </div> 
                        </div>
                        <div class="mb-2 col-sm-12">
                            <label><i class="bi bi-battery-half"></i>Stock</label>
                            <div class="input-group">
                                <input type="number" class="form-control" id="productStock" readonly="">
                            </div> 
                        </div>
                    </div>
                </div>
                <div class="card-footer">
                    <button class="btn btn-primary" id="btnAddProductoToCart"><i class="bi bi-cart-plus"></i> Agregar Producto</button>
                </div>
            </div>
        </div>
        <div class="col-sm-8">
            <div class="card">
                <div class="card-body">
                    <div class="table-responsive-sm">
                        <table class="table caption-top" id="tableCart">
                            <thead>
                                <tr class="text-center">
                                    <th>ID</th>
                                    <th>CODIGO</th>
                                    <th>PRODUCTO</th>
                                    <th>PRECIO</th>
                                    <th>CANTIDAD</th>
                                    <th>TOTAL</th>
                                    <th>ACCION</th>
                                </tr>
                            </thead>
                            <tbody>
                                
                            </tbody>
                        </table>
                    </div>
                    <div class="table-responsive-sm">
                        <table class="table d-flex justify-content-end" id="tableCartSumary">                            
                            <tbody>
                                <tr>
                                    <td class="text-end">Monto Neto :</td>
                                    <td class="fw-bold" id="montoNeto">0.00</td>
                                </tr>
                                <tr>
                                    <td class="text-end">Monto IGV :</td>
                                    <td class="fw-bold" id="montoIgv">0.00</td>
                                </tr>
                                <tr>
                                    <td class="text-end">Monto Total :</td>
                                    <td class="fw-bold" id="montoTotal">0.00</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="card-footer d-flex justify-content-end">
                    <button class="btn btn-danger" id="btnCancelarSale"><i class="bi bi-x-square"></i> Cancelar</button>
                    <button class="btn btn-primary ms-2" id="btnGenerarSale"><i class="bi bi-pc-display-horizontal"></i> Generar Venta</button>
                </div>
            </div>
        </div>
    </div>  
</div>
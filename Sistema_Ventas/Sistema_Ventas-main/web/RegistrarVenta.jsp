

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="col-sm-4">
                <div class="card">
                    <form action="Controlador?menu=NuevaVenta" method="POST">
                        
                    <div class="card-body">
                        <div class="form-group">
                            <label>Datos Del Cliente</label>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-6">
                                <input type="text" name="CodigoCliente" value="${c.getDni()}"class="form-control" placeholder="Codigo">
                                <input type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-info">
                            </div>
                            <div class="col-sm-6">
                                <input type="text" name="nombrescliente" value="${c.getNom()}" class="form-control col-sm-6">
                            </div>
                        </div>
                        <div class="form-group">
                            <label>Datos Producto</label>
                        </div>
                        <div class="form-group d-flex">
                              <div class="col-sm-6 d-flex">
                                  <input type="text" name="codigoproducto" value="${producto.getId()}"class="form-control" placeholder="Codigo">
                                  <button type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-info"></button>
                            </div>
                            <div class="col-sm-6">
                                <input type="text" name="nomproducto" value="${producto.getNom()}" class="form-control col-sm-6">
                            </div>
                        </div>
                        <div class="form-group d-flex">
                             <div class="col-sm-6 d-flex">
                                 <input type="text" name="Precio" value="${producto.getPrecio()}"class="form-control" placeholder="Codigo">
                            </div>
                            <div class="col-sm-3">
                                <input type="number" value="1" name="Cantidad" placeholder="" class="form-control">
                            </div>
                            <div class="col-sm-3">
                                <input type="text" name="Stock" value="${producto.getStock()}"placeholder="Stock Disponible" class="form-control">
                            </div>                            
                        </div> 
                        <div class="form-group">
                            <button type="submit" name="accion" value="Agregar " class="btn btn-outline-info">Agregar Producto</button>
                        </div>
                    </div>
                    </form>

                </div>
            </div>
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col-sm-6 ml-auto">
                             <label>NumeroSerie</label>       
                    <input type="text" name="Nro.Serie" class="form-control">
                </div>
                <br>  
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Nro</th>
                                    <th>Codigo</th>
                                    <th>Descripcion</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>Subtotal</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="list" items="${lista}">
                                <tr>
                                    <td>${list.getItem()}</td>
                                    <td>${list.getIdproducto()}</td>
                                    <td>${list.getDescripcionP()}</td>
                                    <td>${list.getPrecio()}</td>
                                    <td>${list.getCantidad()}</td>
                                    <td>${list.getSubtotal()}</td>
                                    <td class="d-flex">
                                        <a href="#" class="btn btn-warning">Editar</a>
                                        <a href="#" class="btn btn-danger" style="margin-left:10px ">Delete</a>
                                    </td>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>                        
                    </div>   
                    <div class="card-footer d-flex">
                        <div class="col-sm-6">
                            <input type="submit" name="acction" value="Generar venta" class="btn btn-success">
                            <input type="submit" name="acction" value="Cancelar" class="btn btn-danger">
                        </div>
                        <div class="col-sm-4 ml-auto">
                            <input type="text" name="txtTotal" value="${totalpagar()}"class="form-control">
                        </div>
                    </div>
                </div> 
            </div>
        </div>
        <h1>Registrar Venta</h1>
    </body>
    
</html>
3
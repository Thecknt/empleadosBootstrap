<%@include file="comunes/head.jsp"%>
<%@include file="comunes/nav.jsp"%>

<div class="container">
    <div class="text-center" style="margin: 30px">
        <h3>Editar Empleado</h3>
    </div>
    <form action="${urlEditar}" modelAttribute="empleadoForm" method="post">
    <input type="hidden" name="idEmpleado" value="${empleado.idEmpleado}"/>
        <div class="mb-3">
            <label for="nombreEmpleado" class="form-label">Nombre</label>
            <input type="text" class="form-control" id="nombreEmpleado" name="nombreEmpleado" required="true"
            value="${empleado.nombreEmpleado}">
        </div>
        <div class="mb-3">
            <label for="apellidoEmpleado" class="form-label">Apellido</label>
            <input type="text" class="form-control" id="apellidoEmpleado" name="apellidoEmpleado" required="true"
            value="${empleado.apellidoEmpleado}">
        </div>
        <div class="mb-3">
            <label for="dni" class="form-label">DNI</label>
            <input type="number" class="form-control" id="dni" name="dni" required="true"
            value="${empleado.dni}">
        </div>
        <div class="mb-3">
            <label for="departamento" class="form-label">Departamento</label>
            <input type="text" class="form-control" id="departamento" name="departamento" required="true"
            value="${empleado.departamento}">
        </div>
        <div class="mb-3">
            <label for="sueldo" class="form-label">Sueldo</label>
            <%-- step me permite ingresar numeros decimales por ejemplo, spring utiliza el name como id --%>
            <input type="number" step="any" class="form-control" id="sueldo" name="sueldo" required="true"
            value="${empleado.sueldo}">
        </div>
        <div class="text-center">
            <button type="submit" class="btn btn-success btn-sm me-3">Modificar</button>
<a href="${urlInicio}" class="btn btn-danger btn-sm">Regresar</a>
        </div>

    </form>
</div>
<%@include file="comunes/footer.jsp"%>
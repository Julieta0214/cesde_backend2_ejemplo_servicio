Solución Actividad



1. Validación implementada en el servicio

En la capa de servicio (ProveedorService) se implementó una validación de negocio que verifica que el número de teléfono del proveedor tenga exactamente 10 dígitos.

Si el teléfono es nulo o no cumple con la cantidad de dígitos, el sistema lanza una excepción con un mensaje descriptivo y no permite guardar el registro.

 2. Prueba del endpoint de búsqueda personalizada

Se implementó un método en el repositorio utilizando:

findByNombreContainingIgnoreCase

Este método permite buscar proveedores por nombre sin importar si se escriben en mayúsculas o minúsculas.

El endpoint utilizado fue:

GET /api/proveedores/buscar?nombre=

Este endpoint retorna una lista de proveedores que coinciden con el nombre ingresado.


3. Pruebas realizadas en Postman

Se realizaron las siguientes pruebas:

Crear proveedor
POST /api/proveedores

Se envió un JSON con los datos del proveedor y el sistema lo almacenó correctamente en la base de datos.


Listar proveedores
GET /api/proveedores

Retorna todos los proveedores registrados en el sistema.


 Buscar proveedor por ID
GET /api/proveedores/{id}

Retorna un proveedor específico según su ID.


 Eliminar proveedor
DELETE /api/proveedores/{id}

Elimina un proveedor de la base de datos si existe.


Buscar por nombre
GET /api/proveedores/buscar?nombre=juliana

Retorna los proveedores que coinciden con el nombre ingresado, sin importar mayúsculas o minúsculas.


Conclusión

Se implementó correctamente la arquitectura en capas (Entity, Repository, Service, Controller), aplicando lógica de negocio en el servicio y exposición de endpoints REST para la gestión de proveedores.
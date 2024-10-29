# ListaCompra
 
Link al repositorio: https://github.com/siraglez/ListaCompra.git

### Explicación Código

Este código implementa una aplicación básica para gestionar una lista de compras, permitiendo al usuario añadir productos con sus respectivos nombres, cantidades y precios. La interfaz de usuario muestra los productos agregados en una lista y calcula automáticamente el total de productos y el costo total de la compra.

#### Componentes y Funcionalidad

1. **Clase `MainActivity`**:
   - `MainActivity` es la actividad principal que inicializa y configura la interfaz de usuario de la aplicación. Aquí se encuentran los elementos visuales y la lógica para interactuar con ellos.
   - **Componentes visuales**:
     - `ListView` (`listViewProducts`): Muestra la lista de productos añadidos.
     - `EditText` (`editTextProductName`, `editTextQuantity`, `editTextPrice`): Campos de entrada de texto para el nombre, cantidad y precio del producto.
     - `Button` (`buttonAdd`): Botón para añadir un nuevo producto a la lista.
     - `TextView` (`textViewTotalItems`, `textViewTotalPrice`): Muestra el total de productos y el costo total de la lista de compras.
   - **Lógica de Adición de Productos**:
     - Al hacer clic en el botón `buttonAdd`, se llama al método `addProduct`. Este método:
       - Toma el nombre, cantidad y precio del producto de los campos de entrada.
       - Verifica si el nombre del producto no está vacío.
       - Crea una nueva instancia de `Product` y la añade a la lista `products`.
       - Notifica al adaptador que la lista ha cambiado para actualizar la vista.
       - Limpia los campos de entrada después de agregar el producto.
       - Llama al método `updateTotals` para recalcular el total de productos y el costo total.
   - **Cálculo de Totales**:
     - `updateTotals` calcula la cantidad total de productos y el costo acumulado de los productos en la lista, manejando posibles errores de conversión numérica y mostrando el total en los respectivos `TextView`.

2. **Clase `Product`**:
   - Es una `data class` que representa un producto en la lista de compras. Cada `Product` tiene tres atributos: `name` (nombre), `quantity` (cantidad) y `price` (precio).

3. **Clase `ProductAdapter`**:
   - `ProductAdapter` extiende `ArrayAdapter` y configura cómo se muestran los productos en el `ListView`.
   - En el método `getView`, el adaptador:
     - Obtiene el producto en la posición actual de la lista.
     - Formatea los detalles del producto como una cadena que incluye el nombre, cantidad y precio (si están presentes).
     - Configura el `TextView` del elemento de la lista para mostrar esta cadena formateada.
   - Este adaptador permite que cada elemento de la lista se muestre en el formato "Producto (Cantidad) = Precio€".

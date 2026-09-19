# Aplicación de Consola POO I

## 📋 Consigna y Pautas del Proyecto

> **Nota:** Todas las clases pertenecientes a este ejercicio deben crearse dentro del paquete llamado `ejercicio1`.

---

### 1. Definición de Clases y Propiedades

#### **Clase Persona**
Crear la clase `Persona` con las siguientes propiedades:
- `String dni`
- `String nombre`
- `String apellido`
- `LocalDate fechaNacimiento`
- `String genero`
- `String direccion`
- `String telefono`
- `String email`

* **Requisitos:** Aplicar el concepto de encapsulamiento (atributos privados, getters y setters) y sobrescribir el método `toString()`.

#### **Clase Empleado**
Crear la clase `Empleado` que herede de la clase `Persona` (`extends Persona`) con los siguientes atributos propios:
- `int legajo`
- `String puesto`

* **Requisitos:** Aplicar encapsulamiento y sobrescribir el método `toString()`.

---

### 2. Reglas de Negocio y Constructores

1. **Generación de Legajo:**
   - El legajo del empleado debe ser generado automáticamente a partir de la clase.
   - El primer legajo será el número **1000** e irá incrementando en 1 por cada nuevo empleado creado.
   - El legajo debe asignarse en el constructor de la clase y no podrá ser modificado posteriormente (variable/atributo constante/final por instancia).

2. **Constructores de `Persona`:**
   - **Constructor vacío:** Carga por defecto la variable `nombre` con `"sin nombre"` y la `fechaNacimiento` con `01/01/2025`.
   - **Constructor parametrizado:** Recibe todos sus atributos (`dni`, `nombre`, `apellido`, `fechaNacimiento`, `genero`, `direccion`, `telefono`, `email`).

3. **Constructores de `Empleado`:**
   - **Constructor vacío:** Llama explícitamente al constructor vacío de `Persona`.
   - **Constructor parametrizado:** Recibe los atributos de `Persona` y de `Empleado` (`dni`, `nombre`, `apellido`, `fechaNacimiento`, `genero`, `direccion`, `telefono`, `email`, `puesto`). No recibe el legajo, ya que este se genera automáticamente.

4. **Método Estático:**
   - Crear un método estático en la clase `Empleado` llamado `int devuelveProximoLegajo()`.
   - *Ejemplo:* Si el último legajo asignado fue el 1444, el método debe devolver 1445.

---

### 3. Clase Principal y Prueba

Crear una clase llamada `Principal` con el método `main`:
- Instanciar **5 empleados** con su información completa. Algunos deben crearse utilizando el constructor vacío y otros con el constructor parametrizado.
- Mostrar la información de cada uno mediante el método `toString()`.
- Probar el método estático `devuelveProximoLegajo()` e imprimir el resultado en consola (Ejemplo: *"El próximo legajo será el 1445"*).
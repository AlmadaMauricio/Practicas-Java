# Aplicacion de consola POO II

## 📋 Consigna y Pautas del Proyecto

---

### 🔹 Ejercicio 1: Excepciones Personalizadas y Colecciones

> **Nota:** Todas las clases pertenecientes a este ejercicio deben ubicarse dentro del paquete `ejercicio1`.

#### **A. Configuración Inicial**
- Copiar las clases `Persona` y `Empleado` desarrolladas en el TP N°1 dentro del paquete `ejercicio1`.

#### **B. Excepción Personalizada**
- Crear la clase `ExVerificarDNI` que extienda de `RuntimeException`.

#### **C. Validación de DNI**
- En la clase `Persona`, agregar un método estático `verificarDNI(String dni)`:
  - Debe validar que el parámetro `dni` contenga **exactamente 8 caracteres numéricos**.
  - En caso de no cumplir con la condición, debe lanzar la excepción `ExVerificarDNI`.

#### **D. Clase `MainEjercicio1_a` (Manejo de Excepciones)**
- Crear una `Persona` con el DNI `"AA202020"` y validar su DNI mediante el método anterior.
- Crear otra `Persona` con el DNI `"20202020"` y validar nuevamente.
- Implementar un bloque `try-catch`:
  - **DNI válido:** Mostrar en consola `"Persona agregada correctamente"`.
  - **DNI inválido:** Mostrar en consola `"Persona no agregada por no verificar el DNI"`.

#### **E. Clase `MainEjercicio1_b` (Uso de `ArrayList`)**
- Crear 5 instancias de `Empleado` y almacenarlas dentro de un `ArrayList`.
- Recorrer la colección y mostrar la información de cada empleado utilizando la interfaz `Iterator`.

#### **F. Clase `MainEjercicio1_c` (Uso de `TreeSet`)**
- Crear 5 instancias de `Empleado` y almacenarlas dentro de un `TreeSet`.
- Recorrer y mostrar la información utilizando un `Iterator`.
- *Requisito:* Para el correcto funcionamiento de `TreeSet`, la clase `Empleado` (o `Persona`) debe implementar la interfaz `Comparable` o proporcionar un `Comparator`.

#### **G. Clase `MainEjercicio1_d` (Uso de `HashSet`)**
- Crear 5 instancias de `Persona` y almacenarlas dentro de un `HashSet`.
- Recorrer la colección y mostrar la información mediante un `Iterator`.
- *Requisito:* Para evitar elementos duplicados en `HashSet`, implementar adecuadamente los métodos `equals()` y `hashCode()` en la jerarquía de clases.

---

### 🔹 Ejercicio 2: Interfaces y Jerarquía de Clases

> **Nota:** Todas las clases pertenecientes a este ejercicio deben ubicarse dentro del paquete `ejercicio2`.

Se solicita modelar en Java una estructura para representar instalaciones y construcciones mediante interfaces/clases abstractas:

- **Instalación Deportiva:** Recinto delimitado donde se practican deportes. Debe definir el método `int getTipoDeInstalacion()`.
- **Edificio:** Construcción cubierta. Debe definir el método `double getSuperficieEdificio()`.
- **Polideportivo:** Representa simultáneamente una *Instalación Deportiva* y un *Edificio*. Debe permitir conocer su superficie y su nombre.
- **Edificio de Oficinas:** Es un *Edificio*. Debe permitir conocer la cantidad de oficinas con las que cuenta.

#### **Clase `MainEjercicio2`**
- Crear una clase con el método `main`.
- Instanciar un `ArrayList` que contenga:
  - 3 `Polideportivo`
  - 2 `EdificioDeOficinas`
- Recorrer la colección utilizando un `Iterator` y mostrar los atributos correspondientes de cada objeto.

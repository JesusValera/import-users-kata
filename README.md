# Import Users Kata

> Esta kata está enfocada en refactoring

Tenemos un fichero que se encarga de leer usuarios desde distintas fuentes de origen (csv y red), queremos filtrar
y mostrar los datos por la consola.

El código es bastante simple, pero se está haciendo más y más complejo, por lo que se está acumulando bastante deuda técnica.

El objetivo de este refactor consistirá en mejorar el código de manera que sea mantenible en el futuro manteniendo
el comportamiento inicial.

## Algunas sugerencias

1. Considera legibilidad y buenas prácticas
2. Considera test coverage
3. _[OPCIONAL]_ Reemplaza el output en consola por escritura en fichero/SQLite...
4. _[OPCIONAL]_ Añade una nueva fuente de origen (fichero txt, XML, base de datos)...

# Instrucciones

### PHP

Entra en la carpeta php y ejecuta `php run.php`

### Javascript

Entra en la carpeta javascript y ejecuta los siguientes comandos

```javascript
npm install
node run.js
```

> Es necesario tener Node version 18 mínimo para tener acceso a la librería `fetch()`

### Java (en construcción)

Instala las dependencias Maven y ejecuta el programa desde el fichero `Main.java`

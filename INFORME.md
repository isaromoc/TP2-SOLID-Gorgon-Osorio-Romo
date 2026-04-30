# TP 2 - PRINCIPIOS SOLID
Grupo: Gorgon, Osorio, Romo

## <u>PARTE 1: REFACTORIZAR CÓDIGO</u>
El código presentaba una sola clase "CuentaBancaria" que manejaba 3 responsabilidades distintas: manejar el saldo de la cuenta, imprimir mensajes y enviar notificaciones. Para refactorizar el código, decidimos aplicar el Principio de Responsabilidad Única y separar esta clase principal en 3 distintas, cada una con su propia responsabilidad: CuentaBancaria que maneje el saldo de la cuenta, Impresos que maneje la impresión de mensajes, y Notificador que maneje el envío de notificaciones.
Además, agregamos 2 tipos de cuentas bancarias (cuenta de ahorro y cuenta corriente) y distintos tipos de notificaciones (email, WhatsApp), aplicando los principios de Abierto-Cerrado y Sustitución de Liskov al crear los objetos.  

## <u>PARTE 2: INFORME</u>

### "S" - Principio de Responsabilidad Única
Este principio sostiene que una clase jamás debería tener más de una razón por la cual cambiar, es decir, una responsabilidad. Cada módulo o clase debe encargarse de hacer una sola cosa.
### "O" - Principio Abierto-Cerrado
El principio Abierto-Cerrado define que entidades como funciones, clases, módulos, etc. deberían estar abiertas para extensión pero cerradas para modificación. El objetivo es diseñar módulos que nunca cambien el código fuente. Se debe poder agregar nuevas funcionalidades sin necesidad de alterar el código que ya funciona. Esto suele lograrse usando herencia o interfaces.
### "L" - Principio de Sustitución de Liskov
Este principio dice que las clases derivadas deben poder sustituir a sus clases base sin alterar el correcto funcionamiento del programa. Ejemplo: Si hay clase padre "Ave" y una clase hija "Pingüino", y el sistema espera que todas las aves puedan volar (usando un método volar()), el pingüino rompe el sistema. Las clases hijas deben comportarse como el padre.
### "I" - Principio de Segregación de Interfaces
Este principio sostiene que los "clientes" no deberían estar obligados a depender de interfaces que no utilizan. Esto quiere decir que es mejor tener muchas interfaces chicas y específicas que una sola interfaz gigante, ya que un "cliente" puede no utilizar todos los métodos de una interfaz, quedando estos vacíos o con errores.
### "D" - Principio de Inversión de Dependencias
El principio de Inversión de Dependencias dice que un módulo de alto nivel no debe depender de un módulo de bajo nivel, sino que ambos deben depender de abstracciones. Para ponerlo en un ejemplo, el código principal no debe depender directamente de herramientas específicas (como "BaseDeDatosMySQL"), sino de "contratos" o interfaces genéricas (como "ConexionBaseDeDatos"). Este principio se suele implementar con Inyección de Dependencias o IoC (inversión del control).

### <u>¿Cuándo conviene usar cada uno?</u>
| Principio                           | Conviene usarlo cuando...                                                                                                                                  | Cómo identificar cuándo hace falta aplicarlo                                                     |
|:------------------------------------|:-----------------------------------------------------------------------------------------------------------------------------------------------------------|:-------------------------------------------------------------------------------------------------|
| **"S"** - Responsabilidad Única     | El objetivo es código localizable, entendible y mantenible. También cuando van a estar trabajando en el mismo código varias personas.                      | La clase está intentando hacer demasiadas cosas distintas o tiene demasiadas líneas de código.   |
| **"O"** - Abierto-Cerrado           | El código debe admitir nuevas funcionalidades o cambios en un futuro, sin alterar lo que ya es estable.                                                    | Hay muchos `if` o `switch` que crecen cada vez que hay un nuevo tipo de dato.                    |
| **"L"** - Sustitución de Liskov     | Se están diseñando jerarquías de herencia (padres e hijos) y se quiere garantizar que cualquier subclase pueda usarse indistintamente sin lógica especial. | Una subclase lanza errores en métodos heredados o los deja vacíos porque no los usa.             |
| **"I"** - Segregación de Interfaces | Se quiere crear módulos livianos y específicos.                                                                                                            | Una clase se ve obligada a implementar métodos que devuelven `null` o errores.                   |
| **"D"** - Inversión de Dependencias | Se quiere que la lógica de negocio sea "ciega" a los detalles técnicos (como qué base de datos se usa) para que sea fácil de testear y cambiar.            | Se usa la palabra clave `new` para instanciar clases de bajo nivel dentro de clases principales. |
# CursoJava-ValidarContrasenas
Crear un sistema que gestione usuarios y valide contraseñas bajo múltiples reglas.
    - Diseña una clase Usuario con atributos nombreUsuario, contraseña y un array de tres para almacenar las ultimas tres contraseñas. Este array de primeras comenzará con todas sus posiciones vacías y se irá rellenando, implementa la lógica necesaria para que cuando se almacene la cuarta contraseña se borre la primera y la segunda pase a estar en primer lugar.
    - Implementa métodos para:
    - Validar que la contraseña tenga al menos 8 caracteres, incluya una letra mayúscula, un número y un carácter especial.
    - Cambiar la contraseña, validando que la nueva contraseña no sea igual a las últimas 3 usadas
    - Crea una clase Administrador que extienda Usuario y permita reiniciar contraseñas de cualquier usuario a una contraseña predeterminada.
    - En el main, permite al usuario:
    - Registrar nuevos usuarios.
    - Iniciar sesión, validando la contraseña.
    - Cambiar contraseñas según las reglas.
    - Crea un método en el main para precargar datos de forma automática al comenzar el proyecto y que las pruebas sean más rápidas y eficientes.
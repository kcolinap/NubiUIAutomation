Feature: Registro. Este feature sirve para implementar el test para modulo registro


  Scenario Outline: Prueba de mail valido(caso regresion)
    When el usuario ingrese en el campo de texto un "<email>" valido
    Then valida que el boton siguiente este habilitado con "<status>"
    Examples:
    |    email    | status  |
    |test@test.com| true    |
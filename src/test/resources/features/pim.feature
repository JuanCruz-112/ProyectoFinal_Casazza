Feature: Flujo completo en OrangeHRM

  Scenario: Buscar empleado
    Given estoy logueado con credenciales validas
    When navego a la sección de PIM
    And hago click en Employee Name, ingreso el nombre del empleado "John" y genero la busqueda
    Then deberia ver los resultados de busqueda que coincidan con el nombre





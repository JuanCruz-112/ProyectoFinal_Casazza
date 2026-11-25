Feature: Flujo completo en OrangeHRM

  Scenario: Flujo completo E2E
    Given estoy logueado
    When navego a la sección PIM
    And hago click en Employee Name, escribo "Ash" e inicio la busqueda
    And hago click en mi perfil de arriba a la derecha y selecciono Logout
    Then deberia ver la página de login
Feature: Flujo completo en OrangeHRM

  Scenario: Login exitoso
    Given estoy en la pagina de inicio de sesion de OrangeHRM
    When ingreso el usuario "Admin" e ingreso la contraseña "admin123"
    And hago clic en el boton Login
    Then debo ver el Dashboard
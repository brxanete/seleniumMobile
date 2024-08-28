package appmobile.exceptions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;


//public class HandleLoginAlerts implements Task {



//    @Override
//    public <T extends Actor> void performAs(T actor) {
//
//        try {
//            if (errorServerAlert.resolveFor(actor).isVisible()) {
//                CloseTestExecution.immediately().performAs(actor);
//                throw new LoginErrorExceptions("Error de servidor");
//            } else if (errorDataAlert.resolveFor(actor).isVisible()) {
//                throw new LoginErrorExceptions("Datos incorrectos");
//            } else if (errorBlockUserAlert.resolveFor(actor).isVisible()) {
//                throw new LoginErrorExceptions("Usuario bloqueado");
//            } else if (changePasswordBanner.resolveFor(actor).isVisible()) {
//                throw new LoginErrorExceptions("Se requiere cambiar la clave");
//            } else if (passInput.resolveFor(actor).isVisible()) {
//                throw new LoginErrorExceptions("Usuario ya registrado");
//            } else if (signUpButton.resolveFor(actor).isVisible()) {
//                throw new LoginErrorExceptions("Usuario no registrado");
//            } else if (yesCheck.resolveFor(actor).isVisible()) {
//                throw new LoginErrorExceptions("Usuario registrado requiere registrar dispositivo");
//            } else {
//                System.out.println("Continue");
//            }
//        } catch (LoginErrorExceptions e) {
//            System.out.println(e.getMessage());
//        }
//    }}












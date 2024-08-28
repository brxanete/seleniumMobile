package appmobile.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;

public class ReportDeletion {

    public void targetDeletion() {
        // Directorio de informes de Serenity (ajusta la ruta según tu configuración)
        String rutaDirectorioInformes = "target/site/serenity";

        try {
            // Eliminar el directorio de informes
            FileUtils.deleteDirectory(new File(rutaDirectorioInformes));
        } catch (Exception e) {
            // Manejar cualquier excepción que pueda ocurrir al eliminar el directorio
            e.printStackTrace();
        }
    }
}


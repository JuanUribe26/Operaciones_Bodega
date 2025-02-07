import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.auth.oauth2.GoogleCredentials;
import java.io.FileInputStream;
import java.io.IOException;

public class BodegaApp {
    public static void main(String[] args) {
        try {
            // Carga las credenciales de Firebase
            FileInputStream serviceAccount = new FileInputStream("C:\\Users\\gerqu\\Downloads\\operacionesbodega-c27f4-firebase-adminsdk-fbsvc-f406796039.json");
            FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount)) 
                .setDatabaseUrl("https://operacionesbodega-c27f4-default-rtdb.firebaseio.com/")
                .build();

            // Inicializar Firebase
            FirebaseApp.initializeApp(options);

            // Crea la instancia de la interfaz de usuario
            new InterfazBodega();
            
            System.out.println("Firebase inicializado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al inicializar Firebase: " + e.getMessage());
        }
    }
}

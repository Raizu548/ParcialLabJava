import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Archivo implements Impresion {
    @Override
    public void imprimir(String texto) {

        // Crea un referencia a archivo para comprobar si la direccion que busco existe
        File file = new File("contactos.txt");

        String nuevoTexto = "";
        // Si existe traigo lo que tiene adentro y le sumo lo nuevo.
        if (file.exists()){
            nuevoTexto += guardarTexto();
        }

        nuevoTexto += texto;

        try {
            FileWriter escritura = new FileWriter("contactos.txt");

            for (int i=0; i < nuevoTexto.length(); i++){
                escritura.write(nuevoTexto.charAt(i));
            }

            escritura.write("\n");

            escritura.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private String guardarTexto(){
        String nuevoTexto = "";

        try {
            FileReader entrada = new FileReader("archivo.txt");

            int caracter = entrada.read();
            char letra = (char)caracter;

            while (caracter != -1){
                nuevoTexto += letra;
                caracter = entrada.read();
                letra = (char)caracter;

            }
            entrada.close();
        } catch (Exception e){
            e.printStackTrace();
        }

        return nuevoTexto;
    }

    /*
    public static void escribir(ArrayList<Contacto> contactos){

        // Crea un referencia a archivo para comprobar si la direccion que busco existe
        File file = new File("archivo.txt");

        String nuevoTexto = "";
        // Si existe traigo lo que tiene adentro y le sumo lo nuevo.
        if (file.exists()){
            nuevoTexto += guardarTexto();
        }

        nuevoTexto += texto;

        try {
            FileWriter escritura = new FileWriter("archivo.txt");

            for (int i=0; i < nuevoTexto.length(); i++){
                escritura.write(nuevoTexto.charAt(i));
            }

            escritura.write("\n");

            escritura.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private String guardarTexto(){
        String nuevoTexto = "";

        try {
            FileReader entrada = new FileReader("archivo.txt");

            int caracter = entrada.read();
            char letra = (char)caracter;

            while (caracter != -1){
                nuevoTexto += letra;
                caracter = entrada.read();
                letra = (char)caracter;

            }
            entrada.close();
        } catch (Exception e){
            e.printStackTrace();
        }

        return nuevoTexto;
    }

     */
}

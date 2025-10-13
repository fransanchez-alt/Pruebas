
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;




public class EjecutarProceso1 {
 public static void main(String[] args) {
        try {
           // 1.abrir un proceso sin parámetros.
           // Runtime.getRuntime().exec("notepad.exe");

            //2. Con un parámetro en un String: 
            //Runtime.getRuntime().exec("notepad.exe notas.txt");
            
            //3. Con un array de Strings (más robusto): 
           //String[] infoProceso = {"notepad.exe", "notas.txt"};
           //Runtime.getRuntime().exec(infoProceso);
            /*
            //4. Obteniendo un objeto Process: 
            
             String[] infoProceso = {"Notepad.exe", "notas.txt"};
            Process proceso = Runtime.getRuntime().exec(infoProceso);

            System.out.println("Se ha lanzado el proceso: " + proceso);

            //espera a que el proceso termine
            int codigo = proceso.waitFor();
            System.out.println("Código de retorno: " + codigo);

             */

            //5. leer lo que devuelve el programa.
            
            //6.comando que produce salida en consola.veremos cómo leer desde Java lo que normalmente aparecería en la terminal
            /*

            // Lanzamos un comando que genera salida
            // En Windows:
            String comando = "ping -n 3 www.google.com";
            Process proceso = Runtime.getRuntime().exec(comando);

            // Leemos la salida estándar del proceso
            BufferedReader salida;
            salida = new BufferedReader(
                    new InputStreamReader(proceso.getInputStream()));

            String linea;
            System.out.println("---- SALIDA DEL PROCESO ----");
            while ((linea = salida.readLine()) != null) {
                System.out.println("Respuesta proceso "+linea);
            }

            // Esperamos a que el proceso termine
            int codigo = proceso.waitFor();
            System.out.println("Fin de la ejecución. Código de retorno: " + codigo);
            */

             
            //7. Guardar la salida de un proceso en un fichero
            // En Windows
            String comando = "ping -n 3 www.google.com";
            // En Linux/Mac usar: String comando = "ping -c 3 www.google.com";

            Process proceso = Runtime.getRuntime().exec(comando);

            // Leemos la salida estándar del proceso
            BufferedReader salida = new BufferedReader(
                    new InputStreamReader(proceso.getInputStream()));

            // Creamos un fichero para guardar el resultado
            PrintWriter escritor = new PrintWriter(new FileWriter("resultado.txt"));

            String linea;
            while ((linea = salida.readLine()) != null) {
                escritor.println(linea); // Guardamos en el archivo
            }

            // Cerramos el fichero
            escritor.close();

            // Esperamos a que el proceso termine
            int codigo = proceso.waitFor();
            System.out.println("Proceso terminado con código: " + codigo);
            System.out.println("La salida se ha guardado en resultado.txt");
         
        /*
        // 8. Usando Process Builder
         // Comando según el sistema operativo
            // En Windows:
            String[] comando = {"ping", "-n", "3", "www.google.com"};
            // En Linux/Mac sería: String[] comando = {"ping", "-c", "3", "www.google.com"};

            // Crear el proceso con ProcessBuilder
            Process proceso = new ProcessBuilder(comando).start();

            // Leer la salida del proceso
            BufferedReader salida = new BufferedReader(
                    new InputStreamReader(proceso.getInputStream()));

            String linea;
            System.out.println("---- SALIDA DEL PROCESO ----");
            while ((linea = salida.readLine()) != null) {
                System.out.println(linea);
            }

            // Esperar a que termine y mostrar código
            int codigo = proceso.waitFor();
            System.out.println("Fin de la ejecución. Código de retorno: " + codigo);
            */
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
}



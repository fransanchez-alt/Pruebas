import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class GestorFTP {

    private FTPClient clienteFTP;
    private static final String SERVIDOR = "localhost";
    private static final int PUERTO = 2121;
    private static final String USUARIO = "franFTP";
    private static final String PASSWORD = "pspFTP_2026";

    public GestorFTP() {
        clienteFTP = new FTPClient();
    }

    private void conectar() throws SocketException, IOException {
        clienteFTP.connect(SERVIDOR, PUERTO);
        int respuesta = clienteFTP.getReplyCode();

        if (!FTPReply.isPositiveCompletion(respuesta)) {
            clienteFTP.disconnect();
            throw new IOException("Error al conectar con el servidor FTP. Codigo de respuesta: " + respuesta);
        }

        boolean credencialesOK = clienteFTP.login(USUARIO, PASSWORD);

        if (!credencialesOK) {
            clienteFTP.disconnect();
            throw new IOException("Error al conectar con el servidor FTP. Credenciales incorrectas.");
        }

        clienteFTP.enterLocalPassiveMode();
        clienteFTP.setFileType(FTP.BINARY_FILE_TYPE);
    }

    private void desconectar() throws IOException {
        if (clienteFTP.isConnected()) {
            clienteFTP.logout();
            clienteFTP.disconnect();
        }
    }

    private boolean subirFichero(String path) throws IOException {
        File ficheroLocal = new File(path);
        try (InputStream is = new FileInputStream(ficheroLocal)) {
            boolean subido = clienteFTP.storeFile(ficheroLocal.getName(), is);
            if (!subido) {
                System.err.println("Respuesta FTP al subir: " + clienteFTP.getReplyString().trim());
            }
            return subido;
        }
    }

    private boolean descargarFichero(String ficheroRemoto, String pathLocal) throws IOException {
        try (OutputStream os = new BufferedOutputStream(new FileOutputStream(pathLocal))) {
            boolean descargado = clienteFTP.retrieveFile(ficheroRemoto, os);
            if (!descargado) {
                System.err.println("Respuesta FTP al descargar: " + clienteFTP.getReplyString().trim());
            }
            return descargado;
        }
    }

    public static void main(String[] args) {
        GestorFTP gestorFTP = new GestorFTP();

        try {
            gestorFTP.conectar();
            System.out.println("Conectado");
            System.out.println("Directorio remoto actual: " + gestorFTP.clienteFTP.printWorkingDirectory());

            String rutaSubida = "prueba.txt";
            String rutaDescarga = "prueba-descargado.txt";

            boolean subido = gestorFTP.subirFichero(rutaSubida);

            if (subido) {
                System.out.println("Fichero subido correctamente");
            } else {
                System.err.println("Ha ocurrido un error al intentar subir el fichero");
            }

            boolean descargado = gestorFTP.descargarFichero("prueba.txt", rutaDescarga);

            if (descargado) {
                System.out.println("Fichero descargado correctamente");
            } else {
                System.err.println("Ha ocurrido un error al intentar descargar el fichero");
            }

        } catch (Exception e) {
            System.err.println("Ha ocurrido un error: " + e.getMessage());
        } finally {
            try {
                gestorFTP.desconectar();
                System.out.println("Desconectado");
            } catch (IOException e) {
                System.err.println("No se pudo cerrar la conexion FTP: " + e.getMessage());
            }
        }
    }
}

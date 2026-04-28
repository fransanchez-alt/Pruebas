


import java.io.File;

import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.listener.ListenerFactory;
import org.apache.ftpserver.usermanager.impl.BaseUser;
import org.apache.ftpserver.usermanager.impl.WritePermission;

public class ServidorFTP {

    public static void main(String[] args) throws Exception {

        FtpServerFactory serverFactory = new FtpServerFactory();

        // Puerto
        ListenerFactory factory = new ListenerFactory();
        factory.setPort(2121); // puedes usar 2121 si da problemas

        serverFactory.addListener("default", factory.createListener());

        // Usuario
        BaseUser user = new BaseUser();
        user.setName("franFTP");
        user.setPassword("pspFTP_2026");

        // Carpeta raíz
        user.setHomeDirectory(new File("ftp-root").getAbsolutePath());

        // Permisos de escritura
        user.setAuthorities(java.util.Collections.singletonList(new WritePermission()));

        serverFactory.getUserManager().save(user);

        // Crear carpeta si no existe
        new File("ftp-root").mkdirs();

        // Arrancar servidor
        FtpServer server = serverFactory.createServer();
        server.start();

        System.out.println("Servidor FTP arrancado en puerto 21");
    }
}
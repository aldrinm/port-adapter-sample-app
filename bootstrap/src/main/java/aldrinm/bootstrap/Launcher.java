package aldrinm.bootstrap;

import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;

public class Launcher {

    private UndertowJaxrsServer server;

    public static void main(String[] args) {
        new Launcher().startServer();
    }

    private void startServer() {
        server = new UndertowJaxrsServer();
        server.start();
        server.deploy(MusicApplication.class);
    }

}

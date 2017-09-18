package web.server;

import com.ccl.rain.server.WebJettyServer;

/**
 * Created by ccl on 17/8/28.
 */
public class WebServer {
    public static void main(String[] args) throws Exception {
        WebJettyServer server = new WebJettyServer(new ApplicationConfig());
        server.start();
    }
}

package com.ccl.rain.server;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.DispatcherType;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by ccl on 17/8/28.
 */
public class WebJettyServer {
    private static final Logger logger = LoggerFactory.getLogger(WebJettyServer.class);
    private int port = 8080;
    private ResourceConfig config;
    private String apiPath = "/rest";
    private String webAppDir = "ccl-Jettyserver/src/main/webapp";
    //private String zookeeperAddr = "127.0.0.1:2181";
    //private String rpcAddr = "127.0.0.1:9101";

    public WebJettyServer() {
    }

    public WebJettyServer(int port, ResourceConfig config, String apiPath, String webAppDir) {
        this.port = port;
        this.config = config;
        this.apiPath = apiPath;
        this.webAppDir = webAppDir;
    }

    public WebJettyServer(ResourceConfig config, String webAppDir) {
        this.config = config;
        this.webAppDir = webAppDir;
    }

    public WebJettyServer(ResourceConfig config) {
        this.config = config;
    }

    public void start() throws Exception {
        try {
            //NettyRpcServer rpcServer = new NettyRpcServer();
            //rpcServer.start();
            Server server = new Server(port);//1.建立server，设置端口
            //3.请求处理资源
            ServletHolder sh = new ServletHolder(new ServletContainer(config));

            ServletContextHandler servletContext = new ServletContextHandler(ServletContextHandler.SESSIONS);
            servletContext.setContextPath(apiPath);
            servletContext.addServlet(sh,"/*");
            servletContext.addEventListener(new ContextLoaderListener());
            servletContext.addEventListener(new RequestContextListener());
            servletContext.setInitParameter("contextClass", AnnotationConfigWebApplicationContext.class.getName());
            servletContext.setInitParameter("contextConfigLocation", SpringRootConfiguration.class.getName());

            //添加乱码过滤
            FilterHolder filterHolder = new FilterHolder(new CharacterEncodingFilter());
            Map<String, String> initParams = new HashMap<>();
            initParams.put("encoding", "UTF-8");
            initParams.put("forceEncoding", "true");
            if (null != initParams) {
                for (Map.Entry<String, String> entry : initParams.entrySet()) {
                    filterHolder.setInitParameter(entry.getKey(), entry.getValue());
                }
            }
            servletContext.addFilter(filterHolder, "/*", EnumSet.of(DispatcherType.REQUEST));

            //web层设置
            WebAppContext webAppContext = new WebAppContext();
            webAppContext.setContextPath("/"); //4.上下文路径  http://localhost:8088/
            if (Objects.isNull(webAppDir)){
                String relativelyPath = System.getProperty("user.dir");
                webAppDir = relativelyPath + "/" + webAppDir;
            }
            webAppContext.setResourceBase(webAppDir); // 你的资源文件所在的路径   "ccl-Jettyserver/src/main/webapp"
            //webAppContext.setDefaultsDescriptor("ccl-jersey-jetty-web/src/main/webapp/WEB-INF/web.xml");
//            webAppContext.setDescriptor("ccl-jersey-jetty-web/src/main/webapp/WEB-INF/web.xml");
//            webAppContext.setWelcomeFiles(new String[] {"ccl-jersey-jetty-web/src/main/webapp/index.html"});
//            webAppContext.setWelcomeFiles(new String[] {"index.html"});
            webAppContext.setClassLoader(Thread.currentThread().getContextClassLoader());
            webAppContext.setConfigurationDiscovered(true);
            webAppContext.setParentLoaderPriority(true);

            ContextHandlerCollection contexts = new ContextHandlerCollection();

            contexts.setHandlers(new Handler[] { servletContext, webAppContext });

            server.setHandler(contexts);//6.server添加上下文

            logger.info("ContextPath: " + webAppContext.getContextPath());
            logger.info("Descriptor: " + webAppContext.getDescriptor());
            logger.info("DefaultsDescriptor: " + webAppContext.getDefaultsDescriptor());
            logger.info("--------ResourceBase: " + webAppContext.getResourceBase());
            logger.info("BaseResource: " + webAppContext.getBaseResource());
            logger.info("WelcomFiles: " + webAppContext.getWelcomeFiles());
            logger.info("servletContext ContextPath: " + servletContext.getContextPath());

            server.start();
            server.join();

        } catch (Exception e) {

        }
    }

    @Configuration
    @ComponentScan({"com.ccl"})
    @ImportResource({"classpath*:META-INF/spring/*.xml"})
    public static class SpringRootConfiguration {

    }

    public static void main(String[] args) throws Exception {
        WebJettyServer server = new WebJettyServer();
        server.start();
    }
}

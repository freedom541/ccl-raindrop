package web.server;

/**
 * Created by ccl on 17/8/14.
 */

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;


public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig() {
        packages("com.ccl");
        register(LoggingFilter.class);
        register(RequestContextFilter.class);
        register(JacksonFeature.class);
//        register(LoggerFilter.class);//过滤所有的请求和响应
//        register(LoggerAnnotationFilter.class);//过滤所有标注该类制定annotation的类或方法的请求和响应
//        register(LoggerDynaimcFeature.class);  //实现动态绑定过滤所有的请求和响应
//        register(JerseyFeature.class);  //使用注解绑定拦截器
//        register(AuthorizationFilterFeature.class);  //
        property(ServerProperties.METAINF_SERVICES_LOOKUP_DISABLE, true);
    }
}

import org.apache.coyote.http2.Http2Protocol;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.Ssl;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServerConfig {
    
    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> httpsRedirectCustomizer() {
        return (factory) -> {
            Ssl ssl = new Ssl();
            ssl.setKeyStoreType("PKCS12");
            ssl.setKeyStorePassword("2057532Mlv");
            ssl.setKeyStore("file:/Users/elias/Desktop/Sistemas/Desarrollo/DirectorioAdmin/src/main/resources/keystore.p12");
            factory.setSsl(ssl);
            factory.setPort(443);
            factory.addConnectorCustomizers(connector -> {
                connector.setPort(80);
                connector.setScheme("http");
                connector.setSecure(false);
                connector.setRedirectPort(443);
                connector.addUpgradeProtocol(new Http2Protocol());
            });
        };
    }
}

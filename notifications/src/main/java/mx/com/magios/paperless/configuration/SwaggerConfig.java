package mx.com.magios.paperless.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>Swagger configuration for UI request in the url http://host:ort/swagger-ui.html</p>
 *
 * @author Cristian Alanis {@literal <snake404@gmail.com>}
 * @since 1.0.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig{

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                       .select()
                       .apis(RequestHandlerSelectors.basePackage("mx.com.magios.paperless.controllers"))
                       .paths(PathSelectors.any())
                       .build();
    }
}

package org.arcelino.configuration;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.core.Application;

@OpenAPIDefinition(
        tags = {
                @Tag(name = "widget", description = "Widget operations." ),
                @Tag(name = "gasket", description = "Operations related to gaskets" )
        },
        info = @Info(
                title = "User REST API",
                version = "1.0.0",
                contact = @Contact(
                        name = "Matheus Arcelino"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0.html" ))
)
public class SwaggerConfiguration extends Application {
}

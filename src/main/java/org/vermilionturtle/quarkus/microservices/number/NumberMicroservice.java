package org.vermilionturtle.quarkus.microservices.number;

import org.eclipse.microprofile.openapi.annotations.ExternalDocumentation;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
@OpenAPIDefinition(
        info = @Info(
                title = "MİKROSERVİS TEST",
                description = "ISBN sayıları üreten mikroservis",
                version = "1.0v0",
                contact = @Contact(
                        name = "akcomak",
                        email = "031890029@ogr.uludag.edu.tr"
                )
        ),
        externalDocs = @ExternalDocumentation(
                url = "https://www.google.com",
                description = "Google"
        ),
        tags = {
                @Tag(
                        name = "API",
                        description = "Public API"
                ),
                @Tag(
                        name = "/numbers",
                        description = "isbn sayılarına erişmek için"
                )
        }

)
public class NumberMicroservice extends Application{

}

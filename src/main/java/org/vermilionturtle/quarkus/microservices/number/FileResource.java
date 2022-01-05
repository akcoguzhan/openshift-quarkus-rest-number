package org.vermilionturtle.quarkus.microservices.number;

import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Path("/file")
@Tag(name = "FileResource REST Endpoint")
public class FileResource {

    @SuppressWarnings("CdiInjectionPointsInspection")
    @Inject
    Logger logger;

    @GET
    @Path("/{fileName}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Uni<Response> getFile(@PathParam("fileName") String fileName) {
        File nf = new File(fileName);
        logger.info("file:" + nf.exists());
        Response.ResponseBuilder response = Response.ok((Object) nf);
        response.header("Content-Disposition", "attachment;filename=" + nf);
        return Uni.createFrom().item(response.build());
    }


    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Set<String>> listFiles(@QueryParam("directory") String dir) {
        logger.info("dir:" + dir);

        if (dir != null) {
            return Uni.createFrom().item(Stream.of(Objects.requireNonNull(new File("./" + dir).listFiles())).filter(file -> !file.isDirectory())
                    .map(File::getName).collect(Collectors.toSet()));
        } else {
            return Uni.createFrom().item(Stream.of(Objects.requireNonNull(new File(".").listFiles())).filter(file -> !file.isDirectory())
                    .map(File::getName).collect(Collectors.toSet()));
        }

    }

}

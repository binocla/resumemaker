package space.enthropy;

import io.quarkus.logging.Log;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Path("form-process")
public class ResumeResource {
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response resumePage(@MultipartForm ProfileMultipartForm profile) {
        try {
            Files.write(Paths.get("src/main/resources/" + UUID.randomUUID() + ".jpg"), profile.photo);
        } catch (IOException e) {
            Log.error("File wasn't saved");
        }
        Log.debug("Current new request " + profile);
        return Response.ok(profile).build();
    }
}

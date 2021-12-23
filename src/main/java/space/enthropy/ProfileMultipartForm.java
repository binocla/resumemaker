package space.enthropy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.jboss.resteasy.annotations.providers.multipart.PartType;

import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;

public class ProfileMultipartForm {

    @FormParam("photo")
    @JsonIgnore
    public byte[] photo;

    @FormParam("firstName")
    @PartType(MediaType.TEXT_HTML)
    public String firstName;

    @FormParam("lastName")
    @PartType(MediaType.TEXT_HTML)
    public String lastName;

    @FormParam("about")
    @PartType(MediaType.TEXT_HTML)
    public String about;

    @Override
    public String toString() {
        return "ProfileMultipartForm{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", about='" + about + '\'' +
                '}';
    }
}

package pierre.valentin.imt.ne.archedenoe;

import org.glassfish.jersey.servlet.ServletProperties;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import javax.ws.rs.ApplicationPath;

import org.springframework.web.bind.annotation.CrossOrigin;
import pierre.valentin.imt.ne.archedenoe.ressources.ArcheResource;
import pierre.valentin.imt.ne.archedenoe.ressources.AnimauxResource;

@Component
@ApplicationPath("api")
@Configuration
@CrossOrigin
public class JerseyConfiguration extends ResourceConfig {
    public JerseyConfiguration() {
        register(ArcheResource.class);
        register(AnimauxResource.class);
        register(CORSResponseFilter.class);
        property(ServletProperties.FILTER_FORWARD_ON_404, true);
    }
}

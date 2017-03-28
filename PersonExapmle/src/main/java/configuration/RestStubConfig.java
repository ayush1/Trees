package configuration;

import org.hibernate.validator.constraints.NotEmpty;
import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;


public class RestStubConfig extends Configuration {
	@NotEmpty
    private String version;
 
    @JsonProperty
    public String getVersion() {
        return version;
    }
 
    @JsonProperty
    public void setVersion(String version) {
        this.version = version;
    }
}

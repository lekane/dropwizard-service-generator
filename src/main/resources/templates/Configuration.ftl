package ${package};

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

public class ${classNamePrefix}Configuration extends Configuration {

	private String parameter;

	@JsonProperty
	public String getParameter() {
		return parameter;
	}

}

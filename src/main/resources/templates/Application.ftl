package ${package};

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.dropwizard.Application;
import io.dropwizard.lifecycle.Managed;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class ${classNamePrefix}Application extends Application<${classNamePrefix}Configuration> {
    private static final Logger LOG = LoggerFactory.getLogger( ${classNamePrefix}Application.class );

    public static void main(String[] args) throws Exception {
        new ${classNamePrefix}Application().run(args);
    }

    @Override
    public String getName() {
        return "${classNamePrefix?lower_case}";
    }

    @Override
    public void initialize(Bootstrap<${classNamePrefix}Configuration> bootstrap) {
    	//
    }

	@Override
    public void run(final ${classNamePrefix}Configuration configuration,
                    final Environment environment) throws ClassNotFoundException {

        final ${classNamePrefix}HealthCheck healthCheck = new ${classNamePrefix}HealthCheck();
        environment.healthChecks().register("${classNamePrefix}", healthCheck);

        final ${classNamePrefix}Resource resource = new ${classNamePrefix}Resource();
        environment.jersey().register(resource);

        environment.lifecycle().manage( new Managed() {
			@Override
			public void start() throws Exception {
				startService( environment, configuration );
			}

            @Override
			public void stop() throws Exception {
				stopService();
			}
		} );
    }

    private void startService( Environment environment, ${classNamePrefix}Configuration configuration ) {
    	//
    }

    private void stopService() {
    	//
    }

}
package ${package};

import com.codahale.metrics.health.HealthCheck;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ${classNamePrefix}HealthCheck extends HealthCheck {
    private static final Logger LOG = LoggerFactory.getLogger( ${classNamePrefix}HealthCheck.class );

    public ${classNamePrefix}HealthCheck() {
        //
    }

    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
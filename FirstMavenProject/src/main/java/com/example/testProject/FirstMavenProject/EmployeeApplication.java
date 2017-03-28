package com.example.testProject.FirstMavenProject;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class EmployeeApplication extends Application<EmployeeConfiguration>{

	public static void main(String[] args) throws Exception {
        new EmployeeApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<EmployeeConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(EmployeeConfiguration configuration,
                    Environment environment) {
        final EmployeeResource resource = new EmployeeResource(
            configuration.getMessage(),
            configuration.getDefaultText1(),configuration.getDefaultText2());
        environment.jersey().register(resource);
    }  

}

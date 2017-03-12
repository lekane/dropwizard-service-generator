package com.lekane.generators.dropwizard;

public class GenerationOptions {
    private String classNamePrefix;
    private String outputDirectory;
    private String packageName;
    private String serviceName;

    public GenerationOptions(String classNamePrefix, String outputDirectory, String packageName, String serviceName) {
        this.classNamePrefix = classNamePrefix;
        this.outputDirectory = outputDirectory;
        this.packageName = packageName;
        this.serviceName = serviceName;
    }

    public String getClassNamePrefix() {
        return classNamePrefix;
    }

    public String getOutputDirectory() {
        return outputDirectory;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getServiceName() {
        return serviceName;
    }
}

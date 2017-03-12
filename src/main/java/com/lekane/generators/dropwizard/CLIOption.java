package com.lekane.generators.dropwizard;

import java.io.File;

public enum CLIOption {
    ClassNamePrefix(false, "classNamePrefix", "PREFIX", "class name prefix\n[Default: Sample]", "Sample"),
    OutputDirectory(false, "outputDirectory", "DIRECTORY", "target directory for service output\n[Default: ./output]",
            System.getProperty("user.dir") + File.separator + "output"),
    Package(false, "package", "PACKAGE", "base package for service\n[Default: com.sample]", "com.sample");

    private String longOptionParam;
    private String longOption;
    private String description;
    private String defaultValue;
    private boolean required;

    CLIOption(final boolean required, final String longOption, final String longOptionParam, final String description, final String defaultValue) {
        this.longOption = longOption;
        this.longOptionParam = longOptionParam;
        this.description = description;
        this.defaultValue = defaultValue;
        this.required = required;
    }

    public boolean isRequired() {
        return required;
    }

    public String getLongOption() {
        return longOption;
    }

    public String getLongOptionParam() {
        return longOptionParam;
    }

    public String getDescription() {
        return description;
    }

    public String getDefaultValue() {
        return defaultValue;
    }
}

package com.lekane.generators.dropwizard;

import com.google.common.collect.Lists;

import java.io.File;
import java.util.List;

public class GeneratorConstants {

    public static final String MAIN_JAVA_DIR = File.separator + "src" + File.separator + "main" + File.separator + "java";
    public static final String MAIN_RESOURCES_DIR = File.separator + "src" + File.separator + "main" + File.separator + "resources";
    public static final String TEST_JAVA_DIR = File.separator + "src" + File.separator + "test" + File.separator + "java";
    public static final String TEST_RESOURCES_DIR = File.separator + "src" + File.separator + "test" + File.separator + "resources";
    public static final List<String> MAVEN_DIRS = Lists.newArrayList( MAIN_JAVA_DIR, MAIN_RESOURCES_DIR, TEST_JAVA_DIR, TEST_RESOURCES_DIR );

}

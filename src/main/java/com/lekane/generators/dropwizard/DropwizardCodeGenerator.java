package com.lekane.generators.dropwizard;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.util.Map;


public class DropwizardCodeGenerator extends DropwizardTemplateGenerator {

    public void generate( GenerationOptions opts ) throws IOException, TemplateException {
        generateDropwizardBase( opts );
    }

    private void generateDropwizardBase( final GenerationOptions opts ) throws IOException, TemplateException {
        File codeDir = createCodeDirectory( opts );
        Configuration cfg = initFreemarker();
        Map<String, Object> params = createFreemarkerParams(opts);

        writeTemplate( cfg, params, new File( codeDir + File.separator + opts.getClassNamePrefix() + "Application.java"), "Application.ftl" );
        writeTemplate( cfg, params, new File( codeDir + File.separator + opts.getClassNamePrefix() + "Configuration.java"), "Configuration.ftl" );
        writeTemplate( cfg, params, new File( codeDir + File.separator + opts.getClassNamePrefix() + "HealthCheck.java"), "HealthCheck.ftl" );
        writeTemplate( cfg, params, new File( codeDir + File.separator + opts.getClassNamePrefix() + "Resource.java"), "Resource.ftl" );

        writeTemplate( cfg, params, new File( opts.getOutputDirectory() + File.separator + opts.getClassNamePrefix().toLowerCase() + ".yaml" ),
                "ServiceYaml.ftl" );
    }

    private File createCodeDirectory(GenerationOptions options) {
        StringBuffer packagePath = new StringBuffer();
        String[] packages = options.getPackageName().split("\\.");
        for( String packageName : packages ) {
            packagePath.append( File.separator ).append( packageName );
        }
        File packageDir = new File( options.getOutputDirectory() + GeneratorConstants.MAIN_JAVA_DIR + packagePath.toString() );
        packageDir.mkdirs();
        return packageDir;
    }

}

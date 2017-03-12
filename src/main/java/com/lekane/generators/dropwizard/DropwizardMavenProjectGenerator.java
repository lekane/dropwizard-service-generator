package com.lekane.generators.dropwizard;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class DropwizardMavenProjectGenerator extends DropwizardTemplateGenerator {

    public void generate( final GenerationOptions options ) throws IOException, TemplateException {
        generateDirectories(options);
        generatePom( options );
    }

    private void generatePom( final GenerationOptions opts) throws IOException, TemplateException {
            Configuration cfg = initFreemarker();
            Map<String, Object> params = createFreemarkerParams(opts);
            writeTemplate( cfg, params, new File( opts.getOutputDirectory() + File.separator + "pom.xml" ), "MavenPomXml.ftl" );
    }

    private void generateDirectories(GenerationOptions options) {
        for( String dirSuffix : GeneratorConstants.MAVEN_DIRS ) {
            File newDir = new File(options.getOutputDirectory() + dirSuffix );
            newDir.mkdirs();
        }
    }

}

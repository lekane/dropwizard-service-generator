package com.lekane.generators.dropwizard;

import freemarker.template.TemplateException;
import org.apache.commons.cli.*;

import java.io.IOException;

public class DropwizardServiceGenerator {

    public static void main( String[] args ) {
        DropwizardServiceGenerator generator = new DropwizardServiceGenerator();
        generator.generate( args );
    }

    private void generate(String[] args) {
        CommandLineParser parser = new DefaultParser();
        Options options = createOptions();
        boolean displayHelp = true;

        try {
            CommandLine cl = parser.parse( options, args );

            try {
                processCommandLine( cl );
                displayHelp = false;
            } catch (IllegalArgumentException e) {
                System.err.println( "Unable to generate service.  Reason: " + e.getMessage() );
            } catch (IOException e) {
                System.err.println( "I/O error.  Reason: " + e.getMessage() );
                e.printStackTrace();
            } catch (TemplateException e) {
                System.err.println( "Template parsing failed.  Reason: " + e.getMessage() );
                e.printStackTrace();
            }


        } catch( ParseException exp ) {
            System.err.println( "Service generation failed.  Reason: " + exp.getMessage() );
        }

        if( displayHelp ) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp( "dropwizard-service-generator [OPTION]... <SERVICE_NAME>", options );
            System.exit(1);
        }

        System.exit(0);
    }

    private void processCommandLine( final CommandLine cl ) throws IOException, TemplateException {
        String serviceName = null;

        if( cl.getArgList().size() != 1) {
            throw new IllegalArgumentException("Missing required paramater <SERVICE_NAME>");
        } else {
            serviceName = cl.getArgs()[0];
        }

        String classNamePrefix = getOptionOrDefault( cl, CLIOption.ClassNamePrefix );
        String outputDirectory = getOptionOrDefault( cl, CLIOption.OutputDirectory );
        String packageName = getOptionOrDefault( cl, CLIOption.Package );

        GenerationOptions options = new GenerationOptions( classNamePrefix, outputDirectory, packageName, serviceName );
        DropwizardMavenProjectGenerator mavenGenerator = new DropwizardMavenProjectGenerator();
        DropwizardCodeGenerator  codeGenerator = new DropwizardCodeGenerator();
        mavenGenerator.generate( options );
        codeGenerator.generate( options );
    }

    private String getOptionOrDefault( final CommandLine cl, final CLIOption option ) {
        return cl.hasOption( option.getLongOption() )
                ? cl.getOptionValue(  option.getLongOption() )
                : option.getDefaultValue();
    }

    private Options createOptions() {
        Options options = new Options();
        for( CLIOption cliOption : CLIOption.values() ) {
            Option.Builder builder = Option.builder()
                    .longOpt(cliOption.getLongOption())
                    .hasArg()
                    .argName(cliOption.getLongOptionParam())
                    .desc(cliOption.getDescription());

            if (cliOption.isRequired()) {
                builder = builder.required(true);
            } else {
                builder = builder.required(false);
            }

            options.addOption( builder.build() );
        }

        return options;
    }

}

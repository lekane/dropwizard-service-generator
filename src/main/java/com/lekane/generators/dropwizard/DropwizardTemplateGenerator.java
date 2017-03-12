package com.lekane.generators.dropwizard;


import com.google.common.collect.Maps;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

public class DropwizardTemplateGenerator {

    protected Configuration initFreemarker() {
        Configuration cfg = new Configuration( Configuration.getVersion() );
        cfg.setClassForTemplateLoading( this.getClass(), "/templates");
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        return cfg;
    }

    protected void writeTemplate(final Configuration cfg, final Map<String, Object> params, File targetFile,
                               final String templateName) throws IOException, TemplateException {
        Template template = cfg.getTemplate( templateName );
        Writer fileWriter = new FileWriter( targetFile );

        try {
            template.process( params, fileWriter );
        } finally {
            fileWriter.close();
        }
    }

    protected Map<String, Object> createFreemarkerParams(GenerationOptions opts) {
        Map<String, Object> params = Maps.newHashMap();
        params.put( "package", opts.getPackageName() );
        params.put( "classNamePrefix", opts.getClassNamePrefix() );
        params.put( "serviceName", opts.getServiceName() );
        return params;
    }
}

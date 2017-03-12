server:
  rootPath: '/api/*'
  gzip:
    enabled: true

logging:
  level: INFO
  loggers:
    io.dropwizard.jersey.jackson.JsonProcessingExceptionMapper: DEBUG
  appenders:
    - type: console

parameter: parameterValue
# Overview

Simplistic Freemarker template-based Dropwizard (http://www.dropwizard.io/) service generator.
Resources structured in Maven format & pom.xml also generated, which outputs a runnable jar.

# Requirements

* Java 1.7+
* Maven

# Running

```
Run Maven:
mvn clean package

Run wrapper script for details:
./dropwizard-service-generator.sh

Unable to generate service.  Reason: Missing required paramater <SERVICE_NAME>
usage: dropwizard-service-generator [OPTION]... <SERVICE_NAME>
    --classNamePrefix <PREFIX>      class name prefix
                                    [Default: Sample]
    --outputDirectory <DIRECTORY>   target directory for service output
                                    [Default: ./output]
    --package <PACKAGE>             base package for service
                                    [Default: com.sample]

Run with custom parameters:

./dropwizard-service-generator.sh --package com.company.service --classNamePrefix TS TestService
```

# License

Copyright (c) 2017 Lekane Oy. All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are
met:

   * Redistributions of source code must retain the above copyright
notice, this list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above
copyright notice, this list of conditions and the following disclaimer
in the documentation and/or other materials provided with the
distribution.
   * Neither the name of Lekane Oy nor the names of its
contributors may be used to endorse or promote products derived from
this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.


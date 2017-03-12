#!/bin/bash

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
java -jar $DIR/target/DropwizardServiceGenerator-1.0.jar "$@"

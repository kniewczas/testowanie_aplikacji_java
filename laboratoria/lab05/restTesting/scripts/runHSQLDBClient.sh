#!/bin/sh

java -cp ./scripts/hsqldb-2.3.3.jar org.hsqldb.util.DatabaseManagerSwing --url jdbc:hsqldb:hsql://localhost/workdb

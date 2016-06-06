#!/bin/bash

java -cp ./scripts/hsqldb-2.3.3.jar org.hsqldb.server.Server --database.0 mem:mydb --dbname.0 workdb

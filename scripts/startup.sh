#!/bin/bash
#
#

echo “application blog deployment started…”

rm -rf /opt/apache-tomcat/webapps/blog.war
rm -rf /opt/apache-tomcat/webapps/blog

cp ../target/blog.war /opt/apache-tomcat/webapps




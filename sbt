SCRIPT_DIR=`dirname $0`
#java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=10005 -Xmx1024M -Dsbt.override.build.repos=true -Dfile.encoding=UTF-8 -XX:+CMSClassUnloadingEnabled -jar "$SCRIPT_DIR/project/sbt-launch.jar" $@
java -Xmx1024M -Dsbt.override.build.repos=true -Dfile.encoding=UTF-8 -XX:+CMSClassUnloadingEnabled -jar "$SCRIPT_DIR/project/sbt-launch.jar" $@

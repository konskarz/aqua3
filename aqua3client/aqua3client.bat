@echo off
setlocal

set "_pf=%PROGRAMFILES%"
if "%PROCESSOR_ARCHITECTURE%"=="AMD64" set "_pf=%ProgramFiles(x86)%"

set "JAVA_HOME=%_pf%\Java\jre6"
set "_java=bin\java.exe"
if exist "%JAVA_HOME%\%_java%" goto :_java
:set_java
set /p "JAVA_HOME=Please enter the path to the Java installation: "
if not exist "%JAVA_HOME%\%_java%" goto :set_java
:_java

set "JBOSS_HOME=%_pf%\jboss-5.0.0.CR2"
set "_client=client\jbossall-client.jar"
if exist "%JBOSS_HOME%\%_jboss%" goto :_jboss
:set_jboss
set /p "JBOSS_HOME=Please enter the path to the JBoss installation: "
if not exist "%JBOSS_HOME%\%_client%" goto :set_jboss
:_jboss

set "JBOSS_BASE=%temp%\aqua3\default"
set "_hibernate=lib\hibernate-core.jar"
if exist "%JBOSS_BASE%\%_hibernate%" goto :_jbossbase
:set_jbossbase
set /p "JBOSS_BASE=Please enter the path to the JBoss base directory: "
if not exist "%JBOSS_BASE%\%_hibernate%" goto :set_jbossbase
:_jbossbase

set CLASSPATH=%~dp0aqua3client.jar;^
%JBOSS_HOME%\%_client%;^
%JBOSS_BASE%\%_hibernate%;^
%JBOSS_BASE%\deploy\aqua3server.jar;^
%CLASSPATH%

"%JAVA_HOME%\%_java%" -Djava.util.logging.config.file=logging.properties ^
main.Aqua3EditorApplication

REM To run applet copy .java.policy to %USERPROFILE%
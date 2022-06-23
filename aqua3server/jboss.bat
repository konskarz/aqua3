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
set "_jboss=bin\run.bat"
if exist "%JBOSS_HOME%\%_jboss%" goto :_jboss
:set_jboss
set /p "JBOSS_HOME=Please enter the path to the JBoss installation: "
if not exist "%JBOSS_HOME%\%_jboss%" goto :set_jboss
:_jboss

set "_conf=default"
set "_base=%temp%\aqua3"
if not exist "%_base%" xcopy /E/I "%JBOSS_HOME%\server\%_conf%" "%_base%\%_conf%"
if not exist "%_base%\%_conf%\deploy\aqua3server.jar" xcopy /E/I/Y "%~dp0jboss" "%_base%\%_conf%"
set "JAVA_OPTS=-Djboss.server.base.dir=%_base% -Djboss.server.base.url=file:/%_base%"

call "%JBOSS_HOME%\%_jboss%" -c %_conf%

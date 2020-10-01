@echo off
setlocal

set SERVICE_NAME=SimpleEchoServer

set PR_INSTALL=%~dp0%prunsrv.exe
set PR_DESCRIPTION="Simple Echo Server Service"

REM Service log configuration
set PR_LOGPREFIX=%SERVICE_NAME%
set PR_LOGPATH=%~dp0%\
set PR_STDOUTPUT=%~dp0%\stdout.txt
set PR_STDERROR=%~dp0%\stderr.txt
set PR_LOGLEVEL=Debug

REM Path to java instllation
set PR_JVM=%JAVA_HOME%\bin\server\jvm.dll
set PR_CLASSPATH=simpleechoserver.jar

REM Startup configuration
set PR_STARTUP=auto
set PR_STARTMODE=jvm
set PR_STARTCLASS=MyService
set PR_STARTMETHOD=ServerStart

REM Shutdown configuration
set PR_STOPMODE=jvm
set PR_STOPCLASS=MyService
set PR_STOPMETHOD=ClientStart
set PR_STOPTIMEOUT=120

REM JVM configuration
set PR_JVMMS=256
set PR_JVVMX=1024
set PR_JVMSS=4000

REM JVM options
set prunsrv_port=8080
set prunsrv_server=localhost

set PR_JVMOPTIONS = -Dprunsrv.port=%prunsrv_port%; -Dprunsrv.server=%prunsrv_server%

REM current file
set "SELF=%~dp%service.bat"
REM current directory
set "CURRENT_DIR=%cd%"


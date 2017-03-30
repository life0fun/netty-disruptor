@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  netty-disruptor startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

@rem Add default JVM options here. You can also use JAVA_OPTS and NETTY_DISRUPTOR_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto init

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto init

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:init
@rem Get command-line arguments, handling Windowz variants

if not "%OS%" == "Windows_NT" goto win9xME_args
if "%@eval[2+2]" == "4" goto 4NT_args

:win9xME_args
@rem Slurp the command line arguments.
set CMD_LINE_ARGS=
set _SKIP=2

:win9xME_args_slurp
if "x%~1" == "x" goto execute

set CMD_LINE_ARGS=%*
goto execute

:4NT_args
@rem Get arguments from the 4NT Shell from JP Software
set CMD_LINE_ARGS=%$

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\cloud-logger-1.0.0.jar;%APP_HOME%\lib\guava-retrying-2.0.0.jar;%APP_HOME%\lib\netty-all-4.0.23.Final.jar;%APP_HOME%\lib\netty-3.10.6.Final.jar;%APP_HOME%\lib\kafka_2.11-0.9.0.1.jar;%APP_HOME%\lib\kafka-clients-0.9.0.1.jar;%APP_HOME%\lib\joda-time-2.2.jar;%APP_HOME%\lib\protobuf-java-2.6.1.jar;%APP_HOME%\lib\mongodb-driver-3.4.2.jar;%APP_HOME%\lib\mongojack-2.6.1.jar;%APP_HOME%\lib\okhttp-3.6.0.jar;%APP_HOME%\lib\metrics-core-3.2.0.jar;%APP_HOME%\lib\jersey-common-2.25.1.jar;%APP_HOME%\lib\jersey-server-2.25.1.jar;%APP_HOME%\lib\disruptor-3.3.6.jar;%APP_HOME%\lib\commons-codec-1.10.jar;%APP_HOME%\lib\swagger-annotations-1.5.12.jar;%APP_HOME%\lib\log4j-api-2.8.jar;%APP_HOME%\lib\log4j-core-2.8.jar;%APP_HOME%\lib\log4j-slf4j-impl-2.8.jar;%APP_HOME%\lib\jbcrypt-0.3m.jar;%APP_HOME%\lib\json-path-2.2.0.jar;%APP_HOME%\lib\java-semver-0.9.0.jar;%APP_HOME%\lib\validation-api-1.1.0.Final.jar;%APP_HOME%\lib\guice-4.1.0.jar;%APP_HOME%\lib\guice-assistedinject-4.1.0.jar;%APP_HOME%\lib\guice-multibindings-4.1.0.jar;%APP_HOME%\lib\jsr305-3.0.0.jar;%APP_HOME%\lib\jackson-databind-2.8.7.jar;%APP_HOME%\lib\uuid-3.2.jar;%APP_HOME%\lib\zkclient-0.7.jar;%APP_HOME%\lib\metrics-core-2.2.0.jar;%APP_HOME%\lib\scala-xml_2.11-1.0.4.jar;%APP_HOME%\lib\scala-library-2.11.7.jar;%APP_HOME%\lib\scala-parser-combinators_2.11-1.0.4.jar;%APP_HOME%\lib\jopt-simple-3.2.jar;%APP_HOME%\lib\slf4j-log4j12-1.7.6.jar;%APP_HOME%\lib\zookeeper-3.4.6.jar;%APP_HOME%\lib\snappy-java-1.1.1.7.jar;%APP_HOME%\lib\lz4-1.2.0.jar;%APP_HOME%\lib\bson-3.4.2.jar;%APP_HOME%\lib\mongodb-driver-core-3.4.2.jar;%APP_HOME%\lib\bson4jackson-2.7.0.jar;%APP_HOME%\lib\persistence-api-1.0.2.jar;%APP_HOME%\lib\commons-io-2.4.jar;%APP_HOME%\lib\okio-1.11.0.jar;%APP_HOME%\lib\javax.ws.rs-api-2.0.1.jar;%APP_HOME%\lib\jersey-guava-2.25.1.jar;%APP_HOME%\lib\hk2-api-2.5.0-b32.jar;%APP_HOME%\lib\javax.inject-2.5.0-b32.jar;%APP_HOME%\lib\hk2-locator-2.5.0-b32.jar;%APP_HOME%\lib\osgi-resource-locator-1.0.1.jar;%APP_HOME%\lib\jersey-client-2.25.1.jar;%APP_HOME%\lib\jersey-media-jaxb-2.25.1.jar;%APP_HOME%\lib\json-smart-2.2.1.jar;%APP_HOME%\lib\javax.inject-1.jar;%APP_HOME%\lib\aopalliance-1.0.jar;%APP_HOME%\lib\jline-0.9.94.jar;%APP_HOME%\lib\hk2-utils-2.5.0-b32.jar;%APP_HOME%\lib\aopalliance-repackaged-2.5.0-b32.jar;%APP_HOME%\lib\javassist-3.20.0-GA.jar;%APP_HOME%\lib\accessors-smart-1.1.jar;%APP_HOME%\lib\junit-3.8.1.jar;%APP_HOME%\lib\asm-5.0.3.jar;%APP_HOME%\lib\slf4j-api-1.7.24.jar;%APP_HOME%\lib\guava-21.0.jar;%APP_HOME%\lib\javax.annotation-api-1.2.jar;%APP_HOME%\lib\log4j-1.2.17.jar;%APP_HOME%\lib\jackson-annotations-2.8.0.jar;%APP_HOME%\lib\jackson-core-2.8.7.jar

@rem Execute netty-disruptor
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %NETTY_DISRUPTOR_OPTS%  -classpath "%CLASSPATH%" com.logicmonitor.research.logserver.server.Main %CMD_LINE_ARGS%

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable NETTY_DISRUPTOR_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%NETTY_DISRUPTOR_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega

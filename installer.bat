@echo off

echo Start installing Tomcat 7
echo NB! It is important to install Wamp in the default directory: "C:\Program Files\Apache Software Foundation\Tomcat 7.0\"
echo NB! It is important to choose HTTP/1.1 Connector port to 8888 and other options to default
%~dp0\install\apache-tomcat-7.0.39.exe


echo Start installing MYSQL
echo NB! It is important to install Wamp in the default directory: "C:\Program Files\MySQL\MySQL Server 5.5\"
%~dp0\install\mysql-5.5.30-win32.msi


echo Starting to copy the project folder to Tomcat Server
DEL /F /S /Q /A "C:\Program Files\Apache Software Foundation\Tomcat 7.0\webapps\ROOT\*"
XCOPY "%~dp0\WebContent" "C:\Program Files\Apache Software Foundation\Tomcat 7.0\webapps\ROOT\" /D /E /C /R /I /K /Y 
XCOPY "%~dp0\build" "C:\Program Files\Apache Software Foundation\Tomcat 7.0\webapps\ROOT\WEB-INF\" /D /E /C /R /I /K /Y 

cd "C:\Program Files\MySQL\MySQL Server 5.5\bin"

echo Database initialisation and setup

echo importing elections database
mysql -u root mysql < %~dp0install\elections.sql

echo starting Tomcat server
"C:\Program Files\Apache Software Foundation\Tomcat 7.0\bin\Tomcat7w.exe"

echo If Tomcat is started, go and try the application from http://localhost:8888/

set /p Finish = Press Enter to close...
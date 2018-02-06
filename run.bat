
@echo off
set base=%~dp0
set cass=%base%bin\cn
rd /s /q %cass%
javac  src\cn\dati\*.java -d bin
set class=%base%\bin
set libs=%base%\libs
set src=%base%src

javaw -classpath %class% cn.dati.HHUI

@pause
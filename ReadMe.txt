//Below command will run the mysqlDB with port 3306
docker run --name mysqldb -e MYSQL_ROOT_PASSWORD=admin -p 3306:3306 -d mysql:latest

//Command to check DB is running on port  (windows)
telnet localhost 3306

//Login goto the mysqlDB container.
//bash is a unix command line.
docker exec -it mysqldb bash

//To login to the DB
 mysql -u root -p

 //To create the EmployeeDB
 CREATE DATABASE IF NOT EXISTS EmployeeDB;

 //it will show all DB's running inside mysql
 show databases
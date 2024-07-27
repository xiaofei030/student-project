
drop table if exists student;
CREATE TABLE student (
                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         number VARCHAR(255),
                         name VARCHAR(255),
                         sex INT,
                         phone VARCHAR(255),
                         qq VARCHAR(255),
                         address VARCHAR(255),
                         update_time DATETIME,
                         create_time DATETIME
) character set = utf8;
drop table if exists sys_user;

CREATE TABLE sys_user (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          phone VARCHAR(255) NOT NULL,
                          password VARCHAR(255) NOT NULL,
                          role ENUM('ADMIN', 'STUDENT','TEACHER') NOT NULL,
                          update_time DATETIME,
                          create_time DATETIME
);

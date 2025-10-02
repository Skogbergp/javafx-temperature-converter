
CREATE DATABASE IF NOT EXISTS javafx_mariadb;

USE javafx_mariadb;


CREATE TABLE IF NOT EXISTS temperature_log (
id INT AUTO_INCREMENT PRIMARY KEY,
input_value DOUBLE NOT NULL,
input_unit VARCHAR(20) NOT NULL,
output_value DOUBLE NOT NULL,
output_unit VARCHAR(20) NOT NULL,
conversion_type VARCHAR(50) NOT NULL,
timestamp DATETIME DEFAULT CURRENT_TIMESTAMP
);

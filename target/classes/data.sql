/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  jesus.a.castellanos
 * Created: Jul 7, 2020
 */
CREATE TABLE PEOPLE (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  rut VARCHAR(12) NOT NULL,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(60) NOT NULL,
  age INT NOT NULL,
  adress VARCHAR(250) NOT NULL
);

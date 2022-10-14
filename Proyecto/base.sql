alter table clientes change cuit cuit varchar (25);
CREATE DATABASE `proyecto` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
DELIMITER //
CREATE PROCEDURE ALTACLIENTE (
razonSocial varchar(45),
cuit varchar (25),
fechadeAlta date,
email varchar(45),
telefono varchar(45),
provincia varchar(45),
localidad varchar(45),
condicionAfip tinyint
)
BEGIN 
INSERT into clientes (razonSocial,cuit,fechadeAlta,email,telefono,provincia,localidad,condicionafip)
values (razonSocial,cuit,fechadeAlta,email,telefono,provincia,localidad,condicionafip);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE ACTUALIZAR_CLIENTE (
nroClientes int,
razonSocial varchar(45),
cuit varchar (25),
fechadeAlta date,
email varchar(45),
telefono varchar(45),
provincia varchar(45),
localidad varchar(45),
condicionAfip tinyint
)
BEGIN 
UPDATE proyecto
SET razonSocial=razonSocial,cuit=cuit,fechadeAlta=fechadeAlta,email=email,telefono=telefono,provincia=provincia,localidad=localidad,condicionafip=condicionafip
WHERE nroClientes=nroClientes;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE ELIMINAR_CLIENTE (
nroClientes int
)
BEGIN 
DELETE FROM proyecto
WHERE nroClientes=nroClientes;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE LISTADO_CLIENTE (
)
BEGIN 
SELECT * FROM proyecto;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE LISTADOS_CLIENTE (
)
BEGIN 
SELECT * FROM clientes;
END //
DELIMITER ;

ALTER TABLE clientes MODIFY condicionAfip SMALLINT;
ALTER TABLE clientes	MODIFY condicionAfip BOOLEAN;


CREATE TABLE Clientes(
tipoIdentificacion int,
numeroIdentificacion varchar(50),
nombre varchar(100) NOT NULL,
apellido varchar(100) NOT NULL,
telefono varchar(50) NOT NULL,
direccion varchar(255) NOT NULL,
email varchar(255) NOT NULL,
PRIMARY KEY (tipoIdentificacion, numeroIdentificacion)
);

CREATE TABLE tipoIdentificacion(
codigo int PRIMARY KEY,
descripcion varchar(50) NOT NULL
);

CREATE TABLE Vehiculos(
matricula varchar(100) PRIMARY KEY,
placa varchar(10) NOT NULL,
marca varchar(100) NOT NULL,
linea varchar(100) NOT NULL,
modelo int NOT NULL,
cilindraje double NOT NULL,
color varchar(50) NOT NULL,
tipoServicio varchar(50) NOT NULL,
claseVehiculo varchar(50) NOT NULL,
tipoCarroceria varchar(100) NOT NULL,
tipoCombustible varchar(50) NOT NULL
);

ALTER TABLE Clientes 
ADD CONSTRAINT Clientes_tipoIdentificacion 
FOREIGN KEY (tipoIdentificacion) 
REFERENCES tipoIdentificacion (codigo) 
ON DELETE NO ACTION 
ON UPDATE CASCADE;
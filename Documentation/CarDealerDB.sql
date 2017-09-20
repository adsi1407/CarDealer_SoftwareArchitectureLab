CREATE TABLE Clientes(
tipoIdentificacion INT,
numeroIdentificacion VARCHAR(50),
nombre VARCHAR(100) NOT NULL,
apellido VARCHAR(100) NOT NULL,
telefono VARCHAR(50) NOT NULL,
direccion VARCHAR(255) NOT NULL,
email VARCHAR(255) NOT NULL,
PRIMARY KEY (tipoIdentificacion, numeroIdentificacion)
);

CREATE TABLE tipoIdentificacion(
codigo INT PRIMARY KEY,
descripcion VARCHAR(50) NOT NULL
);

CREATE TABLE Vehiculos(
matricula VARCHAR(100) PRIMARY KEY,
placa VARCHAR(10) NOT NULL,
marca VARCHAR(100) NOT NULL,
linea VARCHAR(100) NOT NULL,
modelo INT NOT NULL,
cilindraje DOUBLE NOT NULL,
color VARCHAR(50) NOT NULL,
tipoServicio VARCHAR(50) NOT NULL,
claseVehiculo VARCHAR(50) NOT NULL,
tipoCarroceria VARCHAR(100) NOT NULL,
tipoCombustible VARCHAR(50) NOT NULL
);

CREATE TABLE Fotos(
codigo INT PRIMARY KEY,
descripcion VARCHAR(255) NOT NULL,
vehiculo VARCHAR(100) NOT NULL,
url VARCHAR(255) NOT NULL,
fecha DATETIME NOT NULL
);

ALTER TABLE Clientes 
ADD CONSTRAINT Clientes_tipoIdentificacion 
FOREIGN KEY (tipoIdentificacion) 
REFERENCES tipoIdentificacion (codigo) 
ON DELETE NO ACTION 
ON UPDATE CASCADE;
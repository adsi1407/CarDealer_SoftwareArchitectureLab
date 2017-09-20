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
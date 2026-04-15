Drop database if exists DBTienda_in5cm; 
create database DBTienda_in5cm;
use DBTienda_in5cm;

Create Table Clientes(
	dpi_cliente INT not null auto_increment,
    nombre_cliente Varchar(50) not null,
    apellido_cliente Varchar(50) not null,
    direccion varchar(100) not null,
    estado int not null,
    primary key(dpi_cliente)
);

create Table Usuarios(
	codigo_usuario int not null auto_increment,
    username varchar(45) not null,
    password varchar(45) not null,
    email varchar(60) not null,
    rol varchar(45) not null, 
    estado int not null,
    foto varchar(30),
    primary key(codigo_usuario)
);

create table Productos(
	codigo_producto int not null auto_increment,
    nombre_producto varchar(60) not null,
    precio Decimal(10,2) not null,
    stock int not null,
    estado int not null,
    primary key(codigo_producto)
);

create Table Ventas(
	codigo_venta int not null auto_increment,
    fecha_venta date not null,
    total Decimal(10,2) not null,
    estado int not null,
    Clientes_dpi_cliente int not null,
    Usuarios_codigo_usuario int not null,
    constraint fk_ventas_cliente foreign key(Clientes_dpi_cliente) references Clientes(dpi_cliente) on delete cascade,
    constraint fk_ventas_usuario foreign key(Usuarios_codigo_usuario) references Usuarios(codigo_usuario) on delete cascade,
    primary key(codigo_venta)
    
);

create Table detalleventas(
	codigo_detalle_venta int not null auto_increment,
    cantidad int not null,
    precio_unitario Decimal(10,2) not null,
    subtotal Decimal(10,2) not null,
    productos_codigo_producto int,
    ventas_codigo_venta int,
    constraint fk_detalle_producto foreign key(productos_codigo_producto) references Productos(codigo_producto) on delete cascade,
    constraint fk_detalle_venta foreign key(ventas_codigo_venta) references Ventas(codigo_venta) on delete cascade,
    primary key(codigo_detalle_venta)
);

INSERT INTO Usuarios (username, password, email, rol, estado,foto) VALUES
('admin','1234','admin@tienda.com','Administrador',1,"admin.png"),
('caja1','1234','caja1@tienda.com','Cajero',1,"caja1.png"),
('caja2','1234','caja2@tienda.com','Cajero',1,"caja2.png"),
('supervisor','1234','sup@tienda.com','Supervisor',1,"supervisor.png"),
('ventas1','1234','v1@tienda.com','Ventas',1,"ventas1.png"),
('ventas2','1234','v2@tienda.com','Ventas',1,"ventas2.png"),
('inventario','1234','inv@tienda.com','Inventario',1,"inventario.png"),
('user1','1234','u1@tienda.com','Empleado',1,"user1.png"),
('user2','1234','u2@tienda.com','Empleado',1,"user2.png"),
('user3','1234','u3@tienda.com','Empleado',1,"user3.png");

INSERT INTO Clientes (nombre_cliente, apellido_cliente, direccion, estado) VALUES
('Juan','Perez','Zona 1, Ciudad',1),
('Maria','Lopez','Zona 5, Ciudad',1),
('Carlos','Ramirez','Villa Nueva',1),
('Ana','Gomez','Mixco',1),
('Luis','Martinez','Zona 18',1),
('Sofia','Hernandez','Amatitlan',1),
('Pedro','Castillo','Zona 7',1),
('Lucia','Morales','Villa Canales',1),
('Jorge','Ortega','Zona 12',1),
('Elena','Rivas','San Miguel Petapa',1);

INSERT INTO Productos (nombre_producto, precio, stock, estado) VALUES
('Arroz 1kg',8.50,100,1),
('Azucar 1kg',7.25,80,1),
('Frijol 1kg',9.00,60,1),
('Aceite 1L',18.75,50,1),
('Leche 1L',6.80,120,1),
('Pan Molde',12.00,40,1),
('Huevos Docena',15.50,70,1),
('Cafe 250g',22.00,30,1),
('Galletas',5.25,90,1),
('Jabon Barra',4.75,110,1);

INSERT INTO Ventas (fecha_venta, total, estado, Clientes_dpi_cliente, Usuarios_codigo_usuario) VALUES
('2026-03-01',25.50,1,1,2),
('2026-03-02',40.75,1,2,2),
('2026-03-03',18.00,1,3,3),
('2026-03-04',60.20,1,4,3),
('2026-03-05',12.80,1,5,5),
('2026-03-06',33.40,1,6,5),
('2026-03-07',90.00,1,7,6),
('2026-03-08',15.25,1,8,6),
('2026-03-09',47.90,1,9,8),
('2026-03-10',28.60,1,10,9);

INSERT INTO DetalleVentas (cantidad, precio_unitario, subtotal, productos_codigo_producto, ventas_codigo_venta) VALUES
(2,8.50,17.00,1,1),
(1,7.25,7.25,2,2),
(2,9.00,18.00,3,3),
(1,18.75,18.75,4,4),
(2,6.80,13.60,5,5),
(3,12.00,36.00,6,6),
(1,15.50,15.50,7,7),
(2,22.00,44.00,8,8),
(3,5.25,15.75,9,9),
(2,4.75,9.50,10,10);

Select  * from detalleVentas;
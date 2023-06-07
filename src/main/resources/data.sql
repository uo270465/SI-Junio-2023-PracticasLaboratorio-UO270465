INSERT INTO Almacen (almacenId,nombre,direccion) VALUES
	 (1,'Almacén A','Calle Almacén 123'),
	 (2,'Almacén B','Avenida Almacén 456'),
	 (3,'Almacén C','Avenida Almacén 789'),
	 (4,'Almacén D','Calle Almacén 456'),
	 (5,'Almacén E','Calle Almacén 123'),
	 (6,'Almacén F','Avenida Almacén 456'),
	 (7,'Almacén G','Calle Almacén 789');

INSERT INTO Cliente (clienteId,nombre,direccion,telefono,correoElectronico) VALUES
	 (1,'Juan Pérez','Calle Principal 123','123456789','juan@example.com'),
	 (2,'María López','Avenida Central 456','666777888','maria@example.com'),
	 (3,'Ana García','Calle Secundaria 789','999888777','ana@example.com'),
	 (4,'Pedro Rodríguez','Avenida Principal 456','111222333','pedro@example.com'),
	 (5,'Laura Martínez','Calle Secundaria 123','444555666','laura@example.com'),
	 (6,'Carlos Sánchez','Avenida Central 789','777888999','carlos@example.com'),
	 (7,'Sofía González','Calle Principal 456','111222333','sofia@example.com');

INSERT INTO Oficina (oficinaId,nombre,direccion,telefono) VALUES
	 (1,'Oficina A','Avenida Principal 789','123456789'),
	 (2,'Oficina B','Calle Secundaria 456','666777888'),
	 (3,'Oficina C','Avenida Central 123','555-1234'),
	 (4,'Oficina D','Calle Principal 456','555-5678'),
	 (5,'Oficina E','Avenida Principal 789','555-9012'),
	 (6,'Oficina F','Calle Secundaria 456','555-3456'),
	 (7,'Oficina G','Avenida Central 123','555-7890');

INSERT INTO Paquete (paqueteId,descripcion,peso,dimensiones,fechaEnvio,estado) VALUES
	 (1,'Electrónica',2.5,'20x20x10 cm','2023-06-01','En tránsito'),
	 (2,'Ropa',1.8,'30x40x15 cm','2023-06-02','Entregado'),
	 (3,'Libros',4.2,'30x40x20 cm','2023-06-03','En tránsito'),
	 (4,'Electrodomésticos',15.7,'60x80x40 cm','2023-06-04','En tránsito'),
	 (5,'Artículos de decoración',3.0,'15x15x15 cm','2023-06-02','En tránsito'),
	 (6,'Material de oficina',2.2,'25x35x10 cm','2023-06-03','Entregado'),
	 (7,'Juguetes',1.5,'10x20x8 cm','2023-06-04','En tránsito');

INSERT INTO Ruta (rutaId,origen,destino,distancia,duracionEstimada) VALUES
	 (1,'Ciudad A','Ciudad B',200.0,4),
	 (2,'Ciudad B','Ciudad C',150.0,3),
	 (3,'Ciudad C','Ciudad D',300.0,6),
	 (4,'Ciudad D','Ciudad E',250.0,5),
	 (5,'Ciudad E','Ciudad F',400.0,8),
	 (6,'Ciudad F','Ciudad G',350.0,7),
	 (7,'Ciudad G','Ciudad H',300.0,6);

INSERT INTO Tarifa (tarifaId,origen,destino,pesoMaximo,precio) VALUES
	 (1,'Ciudad A','Ciudad B',5.0,10.5),
	 (2,'Ciudad B','Ciudad C',10.0,15.25),
	 (3,'Ciudad C','Ciudad D',7.0,12.75),
	 (4,'Ciudad D','Ciudad E',12.0,18.5),
	 (5,'Ciudad E','Ciudad F',6.0,11.75),
	 (6,'Ciudad F','Ciudad G',8.0,14.5),
	 (7,'Ciudad G','Ciudad H',10.0,17.25);

INSERT INTO Vehiculo (vehiculoId,tipo,capacidadCarga) VALUES
	 (1,'Camión',5000.0),
	 (2,'Furgoneta',2000.0),
	 (3,'Furgoneta',3000.0),
	 (4,'Camión',8000.0),
	 (5,'Furgoneta',2500.0),
	 (6,'Camión',7000.0),
	 (7,'Furgoneta',1800.0);

INSERT INTO SolicitudEnvio (solicitudId,clienteId,paqueteId,rutaId,vehiculoId,fechaSolicitud) VALUES
	 (1,1,1,1,1,'2023-06-03'),
	 (2,2,2,2,2,'2023-06-04'),
	 (3,3,3,3,3,'2023-06-05'),
	 (4,4,4,4,4,'2023-06-06'),
	 (5,5,5,5,5,'2023-06-05'),
	 (6,6,6,6,6,'2023-06-06'),
	 (7,7,7,7,7,'2023-06-07');

INSERT INTO TarifaAlmacen (tarifaId,almacenId) VALUES
	 (1,1),
	 (2,2),
	 (3,3),
	 (4,4),
	 (5,5),
	 (6,6),
	 (7,7);

INSERT INTO TarifaOficina (tarifaId,oficinaId) VALUES
	 (1,1),
	 (2,2),
	 (3,3),
	 (4,4),
	 (5,5),
	 (6,6),
	 (7,7);

INSERT INTO TarifaRuta (tarifaId,rutaId) VALUES
	 (1,1),
	 (2,2),
	 (3,3),
	 (4,4),
	 (5,5),
	 (6,6),
	 (7,7);

INSERT INTO Envio (envioId,solicitudId,fechaRecogida,fechaEntrega,estado) VALUES
	 (1,1,'2023-06-04','2023-06-06','En tránsito'),
	 (2,2,'2023-06-05','2023-06-07','Entregado'),
	 (3,3,'2023-06-06','2023-06-08','En tránsito'),
	 (4,4,'2023-06-07','2023-06-09','En tránsito'),
	 (5,5,'2023-06-06','2023-06-09','En tránsito'),
	 (6,6,'2023-06-07','2023-06-10','Entregado'),
	 (7,7,'2023-06-08','2023-06-11','En tránsito');

INSERT INTO EntregaFallida (entregaId,envioId,fechaEntregaFallida,numeroIntentos) VALUES
	 (1,1,'2023-06-07',1),
	 (2,1,'2023-06-08',2),
	 (3,3,'2023-06-09',1),
	 (4,4,'2023-06-10',2),
	 (5,5,'2023-06-10',1),
	 (6,6,'2023-06-11',2),
	 (7,7,'2023-06-12',3);

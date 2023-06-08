-- Datos de Clientes
INSERT INTO Clientes (nombre, email, direccion) VALUES
('Juan Pérez', 'juanperez@gmail.com', 'Calle Uria, 10, Oviedo'),
('Ana Martínez', 'anamartinez@gmail.com', 'Calle Corrida, 20, Gijón'),
('Carlos Rodríguez', 'carlosrodriguez@gmail.com', 'Avenida de Gijón, 30, Avilés'),
('Laura Fernández', 'laurafernandez@gmail.com', 'Calle Uria, 40, Oviedo'),
('Pedro García', 'pedrogarcia@gmail.com', 'Calle Corrida, 50, Gijón'),
('Sara López', 'saralopez@gmail.com', 'Avenida de Gijón, 60, Avilés'),
('Antonio Torres', 'antonio@gmail.com', 'Calle Uria, 70, Oviedo'),
('María Gómez', 'mariagomez@gmail.com', 'Calle Corrida, 80, Gijón'),
('Luis Cordero', 'luiscordero@gmail.com', 'Avenida de Gijón, 90, Avilés'),
('Isabel Méndez', 'isabelmendez@gmail.com', 'Calle Uria, 100, Oviedo');

-- Datos de Vehículos
INSERT INTO Vehiculos (tipo, capacidad) VALUES
('Furgoneta', 500),
('Camión', 2000),
('Furgoneta', 500),
('Camión', 2000),
('Furgoneta', 500),
('Camión', 2000),
('Furgoneta', 500),
('Camión', 2000),
('Furgoneta', 500),
('Camión', 2000),
('Furgoneta', 500),
('Camión', 2000),
('Furgoneta', 500),
('Camión', 2000),
('Furgoneta', 500),
('Camión', 2000),
('Furgoneta', 500),
('Camión', 2000),
('Furgoneta', 500),
('Camión', 2000);

-- Datos de Transportistas
INSERT INTO Transportistas (nombre, vehiculoId, email) VALUES
('Transportista 1', 1, 'transportista1@gmail.com'),
('Transportista 2', 2, 'transportista2@gmail.com'),
('Transportista 3', 3, 'transportista3@gmail.com'),
('Transportista 4', 4, 'transportista4@gmail.com'),
('Transportista 5', 5, 'transportista5@gmail.com'),
('Transportista 6', 6, 'transportista6@gmail.com'),
('Transportista 7', 7, 'transportista7@gmail.com'),
('Transportista 8', 8, 'transportista8@gmail.com'),
('Transportista 9', 9, 'transportista9@gmail.com'),
('Transportista 10', 10, 'transportista10@gmail.com'),
('Transportista 11', 11, 'transportista11@gmail.com'),
('Transportista 12', 12, 'transportista12@gmail.com'),
('Transportista 13', 13, 'transportista13@gmail.com'),
('Transportista 14', 14, 'transportista14@gmail.com'),
('Transportista 15', 15, 'transportista15@gmail.com'),
('Transportista 16', 16, 'transportista16@gmail.com'),
('Transportista 17', 17, 'transportista17@gmail.com'),
('Transportista 18', 18, 'transportista18@gmail.com'),
('Transportista 19', 19, 'transportista19@gmail.com'),
('Transportista 20', 20, 'transportista20@gmail.com');

-- Datos de AlmacenesOficinas
INSERT INTO AlmacenesOficinas (nombre, direccion, ciudad) VALUES
('Oficina Central Oviedo', 'Plaza de la Escandalera, 1, Oviedo', 'Oviedo'),
('Almacén Oviedo 1', 'Calle del Rosal, 50, Oviedo', 'Oviedo'),
('Almacén Oviedo 2', 'Avenida de Pumarín, 100, Oviedo', 'Oviedo'),
('Oficina Central Gijón', 'Plaza Mayor, 1, Gijón', 'Gijón'),
('Almacén Gijón 1', 'Calle de la Merced, 50, Gijón', 'Gijón'),
('Almacén Gijón 2', 'Avenida de la Costa, 100, Gijón', 'Gijón'),
('Oficina Central Avilés', 'Plaza de España, 1, Avilés', 'Avilés'),
('Almacén Avilés 1', 'Calle de Rivero, 50, Avilés', 'Avilés'),
('Almacén Avilés 2', 'Avenida de Gijón, 100, Avilés', 'Avilés'),
('Almacén Avilés 3', 'Calle de la Estación, 150, Avilés', 'Avilés'),
('Almacén Oviedo 3', 'Calle del Agua, 200, Oviedo', 'Oviedo'),
('Almacén Gijón 3', 'Calle de la Arena, 250, Gijón', 'Gijón'),
('Almacén Avilés 4', 'Calle de la Cámara, 300, Avilés', 'Avilés'),
('Almacén Oviedo 4', 'Calle del Sol, 350, Oviedo', 'Oviedo'),
('Almacén Gijón 4', 'Calle del Mar, 400, Gijón', 'Gijón');

-- Datos de Tarifas
INSERT INTO Tarifas (concepto, precio) VALUES
('Tarifa Básica', 10.00),
('Tarifa Urgente', 20.00),
('Tarifa de Gran Volumen', 30.00),
('Tarifa Internacional', 50.00),
('Tarifa de Fines de Semana', 15.00);

-- Datos de Envíos
INSERT INTO Envios (remitenteId, destinatarioId, origenId, destinoId, fechaSolicitud, fechaRecogida, peso, dimensiones, estado, transportistaId) VALUES
(1, 2, 1, 4, '2023-06-01', '2023-06-02', 5.00, '30x30x30', 'Entregado', 1),
(3, 4, 2, 5, '2023-06-02', NULL, 10.00, '50x50x50', 'En tránsito', 2),
(5, 6, 3, 6, '2023-06-03', '2023-06-04', 15.00, '60x60x60', 'En tránsito', 3),
(7, 8, 4, NULL, '2023-06-04', NULL, 20.00, '70x70x70', 'Esperando recogida', 4),
(9, 10, 5, 7, '2023-06-05', '2023-06-06', 25.00, '80x80x80', 'Entregado', 5);

-- Datos de EnviosTarifas
INSERT INTO EnviosTarifas (envioId, tarifaId) VALUES
(1, 1),
(1, 2),
(2, 3),
(3, 4),
(4, 5),
(5, 1),
(5, 3);

-- Datos de Movimientos
INSERT INTO Movimientos (envioId, fechaHora, ubicacionId, estado) VALUES
(1, '2023-06-02 08:00:00', 1, 'Recogido'),
(1, '2023-06-03 09:00:00', 2, 'En tránsito'),
(1, '2023-06-04 10:00:00', 4, 'Entregado'),
(2, '2023-06-03 11:00:00', 2, 'Recogido'),
(2, '2023-06-04 12:00:00', 3, 'En tránsito'),
(3, '2023-06-04 13:00:00', 3, 'Recogido'),
(3, '2023-06-05 14:00:00', 4, 'En tránsito'),
(3, '2023-06-06 15:00:00', 6, 'En tránsito'),
(4, '2023-06-05 16:00:00', 4, 'Esperando recogida'),
(5, '2023-06-06 17:00:00', 5, 'Recogido'),
(5, '2023-06-07 18:00:00', 6, 'En tránsito'),
(5, '2023-06-08 19:00:00', 7, 'Entregado');

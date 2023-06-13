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
('Furgoneta - Renault Kangoo', 540),
('Furgoneta - Ford Transit', 490),
('Furgoneta - Citroën Berlingo', 520),
('Camión - Renault T-Series', 2050),
('Camión - Ford Cargo', 1980),
('Furgoneta - Renault Master', 530),
('Furgoneta - Ford Custom', 510),
('Camión - Citroën Jumper', 2020),
('Furgoneta - Renault Trafic', 540),
('Camión - DAF XF', 2070),
('Camión - MAN TGX', 2030),
('Furgoneta - Citroën Jumpy', 520),
('Camión - Scania R-Series', 2050),
('Furgoneta - Renault Express', 500),
('Camión - Volvo FH', 1980),
('Furgoneta - Ford Connect', 520),
('Camión - DAF CF', 2060),
('Furgoneta - Renault Kangoo Z.E.', 530),
('Camión - MAN TGS', 2020),
('Furgoneta - Citroën SpaceTourer', 500),
('Camión - Scania P-Series', 1990),
('Furgoneta - Renault Zoe', 510),
('Camión - Volvo FM', 2070),
('Furgoneta - Ford Tourneo', 520),
('Camión - DAF LF', 2030);



-- Datos de Transportistas
INSERT INTO Transportistas (nombre, vehiculoId, email) VALUES
('Juan Pérez', 1, 'jperez@transp.com'),
('María García', 2, 'mgarcia@transp.com'),
('Carlos Rodríguez', 3, 'crodriguez@transp.com'),
('Ana López', 4, 'alopez@transp.com'),
('Pedro Martínez', 5, 'pmartinez@transp.com'),
('Laura Sánchez', 6, 'lsanchez@transp.com'),
('Miguel Torres', 7, 'mtorres@transp.com'),
('Sofía Ramírez', 8, 'sramirez@transp.com'),
('Luis Herrera', 9, 'lherrera@transp.com'),
('Carmen Fernández', 10, 'cfernandez@transp.com'),
('Roberto Morales', 11, 'rmorales@transp.com'),
('Elena Castro', 12, 'ecastro@transp.com'),
('Mario Jiménez', 13, 'mjimenez@transp.com'),
('Silvia Gómez', 14, 'sgomez@transp.com'),
('Andrés Vargas', 15, 'avargas@transp.com'),
('Gabriela Ortega', 16, 'gortega@transp.com'),
('Javier Ríos', 17, 'jrios@transp.com'),
('Valeria Paredes', 18, 'vparedes@transp.com'),
('Óscar Núñez', 19, 'onunez@transp.com'),
('Diana Navarro', 20, 'dnavarro@transp.com');



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
('Tarifa de Fines de Semana', 15.00),
('Tarifa Prioritaria', 25.00),
('Tarifa Económica', 12.00),
('Tarifa Especial', 35.00),
('Tarifa Personalizada', 55.00);







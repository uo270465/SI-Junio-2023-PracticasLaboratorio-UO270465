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
-- Datos de AlmacenesOficinas
INSERT INTO AlmacenesOficinas (nombre, direccion, ciudad) VALUES
-- Almacenes y oficinas en Madrid
('Oficina Central Madrid', 'Calle Gran Vía, 1, Madrid', 'Madrid'),
('Almacén Madrid 1', 'Calle Serrano, 50, Madrid', 'Madrid'),
('Almacén Madrid 2', 'Avenida Castellana, 100, Madrid', 'Madrid'),
('Almacén Madrid 3', 'Calle Alcalá, 200, Madrid', 'Madrid'),
('Almacén Madrid 4', 'Paseo del Prado, 300, Madrid', 'Madrid'),
('Almacén Madrid 5', 'Calle Mayor, 400, Madrid', 'Madrid'),
('Almacén Madrid 6', 'Avenida de América, 500, Madrid', 'Madrid'),
('Almacén Madrid 7', 'Calle del Sol, 600, Madrid', 'Madrid'),
('Almacén Madrid 8', 'Paseo de la Castellana, 700, Madrid', 'Madrid'),
('Almacén Madrid 9', 'Calle Fuencarral, 800, Madrid', 'Madrid'),
('Almacén Madrid 10', 'Avenida de Moncloa, 900, Madrid', 'Madrid'),
('Almacén Madrid 11', 'Calle Princesa, 1000, Madrid', 'Madrid'),
('Almacén Madrid 12', 'Paseo de Recoletos, 1100, Madrid', 'Madrid'),
('Almacén Madrid 13', 'Calle Hortaleza, 1200, Madrid', 'Madrid'),
('Almacén Madrid 14', 'Avenida de Chamartín, 1300, Madrid', 'Madrid'),
('Almacén Madrid 15', 'Calle Goya, 1400, Madrid', 'Madrid'),
-- Almacenes y oficinas en Barcelona
('Oficina Central Barcelona', 'Passeig de Gràcia, 1, Barcelona', 'Barcelona'),
('Almacén Barcelona 1', 'Rambla de Catalunya, 50, Barcelona', 'Barcelona'),
('Almacén Barcelona 2', 'Avinguda Diagonal, 100, Barcelona', 'Barcelona'),
('Almacén Barcelona 3', 'Carrer Balmes, 200, Barcelona', 'Barcelona'),
('Almacén Barcelona 4', 'Plaça de Catalunya, 300, Barcelona', 'Barcelona'),
('Almacén Barcelona 5', 'Carrer Pau Claris, 400, Barcelona', 'Barcelona'),
('Almacén Barcelona 6', 'Avinguda Paral·lel, 500, Barcelona', 'Barcelona'),
('Almacén Barcelona 7', 'Carrer Provença, 600, Barcelona', 'Barcelona'),
('Almacén Barcelona 8', 'Plaça de Sant Jaume, 700, Barcelona', 'Barcelona'),
('Almacén Barcelona 9', 'Carrer Muntaner, 800, Barcelona', 'Barcelona'),
('Almacén Barcelona 10', 'Avinguda Meridiana, 900, Barcelona', 'Barcelona'),
('Almacén Barcelona 11', 'Carrer Gran de Gràcia, 1000, Barcelona', 'Barcelona'),
('Almacén Barcelona 12', 'Plaça Reial, 1100, Barcelona', 'Barcelona'),
('Almacén Barcelona 13', 'Carrer Marina, 1200, Barcelona', 'Barcelona'),
('Almacén Barcelona 14', 'Avinguda Diagonal Mar, 1300, Barcelona', 'Barcelona'),
('Almacén Barcelona 15', 'Carrer Ramon Trias Fargas, 1400, Barcelona', 'Barcelona'),
-- Almacenes y oficinas en Valencia
('Oficina Central Valencia', 'Carrer Colón, 1, Valencia', 'Valencia'),
('Almacén Valencia 1', 'Avinguda del Puerto, 50, Valencia', 'Valencia'),
('Almacén Valencia 2', 'Carrer de Xàtiva, 100, Valencia', 'Valencia'),
('Almacén Valencia 3', 'Carrer de la Pau, 200, Valencia', 'Valencia'),
('Almacén Valencia 4', 'Plaça de Ajuntament, 300, Valencia', 'Valencia'),
('Almacén Valencia 5', 'Carrer Guillem de Castro, 400, Valencia', 'Valencia'),
('Almacén Valencia 6', 'Avinguda de Blasco Ibáñez, 500, Valencia', 'Valencia'),
('Almacén Valencia 7', 'Carrer de la Mar, 600, Valencia', 'Valencia'),
('Almacén Valencia 8', 'Plaça de Cánovas del Castillo, 700, Valencia', 'Valencia'),
('Almacén Valencia 9', 'Carrer de San Vicente Mártir, 800, Valencia', 'Valencia'),
('Almacén Valencia 10', 'Avinguda de les Corts Valencianes, 900, Valencia', 'Valencia'),
('Almacén Valencia 11', 'Carrer dels Cavallers, 1000, Valencia', 'Valencia'),
('Almacén Valencia 12', 'Plaça de Tetuan, 1100, Valencia', 'Valencia'),
('Almacén Valencia 13', 'Carrer de les Barques, 1200, Valencia', 'Valencia'),
('Almacén Valencia 14', 'Avinguda del Port, 1300, Valencia', 'Valencia'),
('Almacén Valencia 15', 'Carrer Eugènia Viñes, 1400, Valencia', 'Valencia'),
-- Almacenes y oficinas en Sevilla
('Oficina Central Sevilla', 'Calle Sierpes, 1, Sevilla', 'Sevilla'),
('Almacén Sevilla 1', 'Avenida de la Constitución, 50, Sevilla', 'Sevilla'),
('Almacén Sevilla 2', 'Calle Tetuán, 100, Sevilla', 'Sevilla'),
('Almacén Sevilla 3', 'Calle San Fernando, 200, Sevilla', 'Sevilla'),
('Almacén Sevilla 4', 'Plaza Nueva, 300, Sevilla', 'Sevilla'),
('Almacén Sevilla 5', 'Calle Feria, 400, Sevilla', 'Sevilla'),
('Almacén Sevilla 6', 'Avenida de la Palmera, 500, Sevilla', 'Sevilla'),
('Almacén Sevilla 7', 'Calle Sánchez Pizjuán, 600, Sevilla', 'Sevilla'),
('Almacén Sevilla 8', 'Paseo de Colón, 700, Sevilla', 'Sevilla'),
('Almacén Sevilla 9', 'Calle Betis, 800, Sevilla', 'Sevilla'),
('Almacén Sevilla 10', 'Avenida Menéndez Pelayo, 900, Sevilla', 'Sevilla'),
('Almacén Sevilla 11', 'Calle Reyes Católicos, 1000, Sevilla', 'Sevilla'),
('Almacén Sevilla 12', 'Plaza de España, 1100, Sevilla', 'Sevilla'),
('Almacén Sevilla 13', 'Calle San Jacinto, 1200, Sevilla', 'Sevilla'),
('Almacén Sevilla 14', 'Avenida de la Buhaira, 1300, Sevilla', 'Sevilla'),
('Almacén Sevilla 15', 'Calle Asunción, 1400, Sevilla', 'Sevilla'),
-- Almacenes y oficinas en Bilbao
('Oficina Central Bilbao', 'Gran Vía, 1, Bilbao', 'Bilbao'),
('Almacén Bilbao 1', 'Calle de Rodríguez Arias, 50, Bilbao', 'Bilbao'),
('Almacén Bilbao 2', 'Avenida de Abandoibarra, 100, Bilbao', 'Bilbao'),
('Almacén Bilbao 3', 'Calle Autonomía, 200, Bilbao', 'Bilbao'),
('Almacén Bilbao 4', 'Plaza Circular, 300, Bilbao', 'Bilbao'),
('Almacén Bilbao 5', 'Calle Ledesma, 400, Bilbao', 'Bilbao'),
('Almacén Bilbao 6', 'Avenida de las Universidades, 500, Bilbao', 'Bilbao'),
('Almacén Bilbao 7', 'Calle Gran Vía de Diego López de Haro, 600, Bilbao', 'Bilbao'),
('Almacén Bilbao 8', 'Paseo Uribitarte, 700, Bilbao', 'Bilbao'),
('Almacén Bilbao 9', 'Calle Ercilla, 800, Bilbao', 'Bilbao'),
('Almacén Bilbao 10', 'Avenida del Ferrocarril, 900, Bilbao', 'Bilbao'),
('Almacén Bilbao 11', 'Calle Alameda de Mazarredo, 1000, Bilbao', 'Bilbao'),
('Almacén Bilbao 12', 'Plaza Moyúa, 1100, Bilbao', 'Bilbao'),
('Almacén Bilbao 13', 'Calle Licenciado Poza, 1200, Bilbao', 'Bilbao'),
('Almacén Bilbao 14', 'Avenida Sabino Arana, 1300, Bilbao', 'Bilbao'),
('Almacén Bilbao 15', 'Calle Iparraguirre, 1400, Bilbao', 'Bilbao'),
-- Continuar añadiendo más almacenes y oficinas en distintas ubicaciones de España
...




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







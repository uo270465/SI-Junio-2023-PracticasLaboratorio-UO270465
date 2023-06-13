-- Tabla Clientes
DROP TABLE IF EXISTS Clientes;
CREATE TABLE Clientes (
    clienteId INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT NOT NULL,
    email TEXT NOT NULL UNIQUE,
    direccion TEXT NOT NULL
);

-- Tabla Vehiculos
DROP TABLE IF EXISTS Vehiculos;
CREATE TABLE Vehiculos (
    vehiculoId INTEGER PRIMARY KEY AUTOINCREMENT,
    tipo TEXT NOT NULL,
    capacidad DECIMAL(6, 2) NOT NULL
);

-- Tabla Transportistas
DROP TABLE IF EXISTS Transportistas;
CREATE TABLE Transportistas (
    transportistaId INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT NOT NULL,
    vehiculoId INTEGER,
    email TEXT NOT NULL UNIQUE,
    FOREIGN KEY(vehiculoId) REFERENCES Vehiculos(vehiculoId)
);

-- Tabla AlmacenesOficinas
DROP TABLE IF EXISTS AlmacenesOficinas;
CREATE TABLE AlmacenesOficinas (
    almacenesOficinasId INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT NOT NULL,
    direccion TEXT NOT NULL,
    ciudad TEXT NOT NULL
);

-- Tabla Tarifas
DROP TABLE IF EXISTS Tarifas;
CREATE TABLE Tarifas (
    tarifaId INTEGER PRIMARY KEY AUTOINCREMENT,
    concepto TEXT NOT NULL,
    precio DECIMAL(6, 2) NOT NULL
);

-- Tabla Envios
DROP TABLE IF EXISTS Envios;
CREATE TABLE Envios (
    envioId TEXT PRIMARY KEY,
    remitenteId INTEGER NOT NULL,
    destinatarioId INTEGER NOT NULL,
    origenId INTEGER NOT NULL,
    destinoId INTEGER,
    fechaSolicitud TEXT NOT NULL,
    fechaRecogida TEXT,
    peso DECIMAL(6, 2) NOT NULL,
    dimensiones TEXT NOT NULL,
    estado TEXT NOT NULL,
    transportistaId INTEGER NOT NULL,
    FOREIGN KEY(remitenteId) REFERENCES Clientes(clienteId),
    FOREIGN KEY(destinatarioId) REFERENCES Clientes(clienteId),
    FOREIGN KEY(origenId) REFERENCES AlmacenesOficinas(almacenesOficinasId),
    FOREIGN KEY(destinoId) REFERENCES AlmacenesOficinas(almacenesOficinasId),
    FOREIGN KEY(transportistaId) REFERENCES Transportistas(transportistaId)
);

-- Tabla EnviosTarifas
DROP TABLE IF EXISTS EnviosTarifas;
CREATE TABLE EnviosTarifas (
    envioId TEXT NOT NULL,
    tarifaId INTEGER NOT NULL,
    PRIMARY KEY(envioId, tarifaId),
    FOREIGN KEY(envioId) REFERENCES Envios(envioId),
    FOREIGN KEY(tarifaId) REFERENCES Tarifas(tarifaId)
);

-- Tabla Movimientos
DROP TABLE IF EXISTS Movimientos;
CREATE TABLE Movimientos (
    movimientoId INTEGER PRIMARY KEY AUTOINCREMENT,
    envioId TEXT NOT NULL,
    fechaHora TEXT NOT NULL,
    ubicacionId INTEGER NOT NULL,
    estado TEXT NOT NULL,
    FOREIGN KEY(envioId) REFERENCES Envios(envioId),
    FOREIGN KEY(ubicacionId) REFERENCES AlmacenesOficinas(almacenesOficinasId)
);

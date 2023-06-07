-- Almacen definition
DROP TABLE IF EXISTS Almacen;
CREATE TABLE Almacen (
  almacenId INTEGER PRIMARY KEY,
  nombre TEXT,
  direccion TEXT
);


-- Cliente definition
DROP TABLE IF EXISTS Cliente;
CREATE TABLE Cliente (
  clienteId INTEGER PRIMARY KEY,
  nombre TEXT,
  direccion TEXT,
  telefono TEXT,
  correoElectronico TEXT
);


-- Oficina definition
DROP TABLE IF EXISTS Oficina;
CREATE TABLE Oficina (
  oficinaId INTEGER PRIMARY KEY,
  nombre TEXT,
  direccion TEXT,
  telefono TEXT
);


-- Paquete definition
DROP TABLE IF EXISTS Paquete;
CREATE TABLE Paquete (
  paqueteId INTEGER PRIMARY KEY,
  descripcion TEXT,
  peso REAL,
  dimensiones TEXT,
  fechaEnvio TEXT,
  estado TEXT
);


-- Ruta definition
DROP TABLE IF EXISTS Ruta;
CREATE TABLE Ruta (
  rutaId INTEGER PRIMARY KEY,
  origen TEXT,
  destino TEXT,
  distancia REAL,
  duracionEstimada NUMBER
);


-- Tarifa definition
DROP TABLE IF EXISTS Tarifa;
CREATE TABLE Tarifa (
  tarifaId INTEGER PRIMARY KEY,
  origen TEXT,
  destino TEXT,
  pesoMaximo REAL,
  precio NUMERIC
);


-- Vehiculo definition
DROP TABLE IF EXISTS Vehiculo;
CREATE TABLE Vehiculo (
  vehiculoId INTEGER PRIMARY KEY,
  tipo TEXT,
  capacidadCarga REAL
);


-- SolicitudEnvio definition
DROP TABLE IF EXISTS SolicitudEnvio;
CREATE TABLE SolicitudEnvio (
  solicitudId INTEGER PRIMARY KEY,
  clienteId INTEGER,
  paqueteId INTEGER,
  rutaId INTEGER,
  vehiculoId INTEGER,
  fechaSolicitud TEXT,
  FOREIGN KEY (clienteId) REFERENCES Cliente(clienteId),
  FOREIGN KEY (paqueteId) REFERENCES Paquete(paqueteId),
  FOREIGN KEY (rutaId) REFERENCES Ruta(rutaId),
  FOREIGN KEY (vehiculoId) REFERENCES Vehiculo(vehiculoId)
);


-- TarifaAlmacen definition
DROP TABLE IF EXISTS TarifaAlmacen;
CREATE TABLE TarifaAlmacen (
  tarifaId INTEGER,
  almacenId INTEGER,
  FOREIGN KEY (tarifaId) REFERENCES Tarifa(tarifaId),
  FOREIGN KEY (almacenId) REFERENCES Almacen(almacenId)
);


-- TarifaOficina definition
DROP TABLE IF EXISTS TarifaOficina;
CREATE TABLE TarifaOficina (
  tarifaId INTEGER,
  oficinaId INTEGER,
  FOREIGN KEY (tarifaId) REFERENCES Tarifa(tarifaId),
  FOREIGN KEY (oficinaId) REFERENCES Oficina(oficinaId)
);


-- TarifaRuta definition
DROP TABLE IF EXISTS TarifaRuta;
CREATE TABLE TarifaRuta (
  tarifaId INTEGER,
  rutaId INTEGER,
  FOREIGN KEY (tarifaId) REFERENCES Tarifa(tarifaId),
  FOREIGN KEY (rutaId) REFERENCES Ruta(rutaId)
);


-- Envio definition
DROP TABLE IF EXISTS Envio;
CREATE TABLE Envio (
  envioId INTEGER PRIMARY KEY,
  solicitudId INTEGER,
  fechaRecogida TEXT,
  fechaEntrega TEXT,
  estado TEXT,
  FOREIGN KEY (solicitudId) REFERENCES SolicitudEnvio(solicitudId)
);


-- EntregaFallida definition
DROP TABLE IF EXISTS EntregaFallida;
CREATE TABLE EntregaFallida (
  entregaId INTEGER PRIMARY KEY,
  envioId INTEGER,
  fechaEntregaFallida TEXT,
  numeroIntentos INTEGER,
  FOREIGN KEY (envioId) REFERENCES Envio(envioId)
);

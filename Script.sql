CREATE DATABASE banco;

CREATE TABLE Persona (
  identificacion VARCHAR(20) PRIMARY KEY,
  nombre VARCHAR(255),
  genero VARCHAR(10),
  edad INT,
  direccion VARCHAR(255),
  telefono VARCHAR(20)
 );
 

 CREATE TABLE Cliente (
  clienteId VARCHAR(20) PRIMARY KEY,
  identificacion VARCHAR(20) UNIQUE NOT NULL,
  contrasena VARCHAR(255),
  estado BOOLEAN,
  FOREIGN KEY (identificacion) REFERENCES Persona(identificacion)
 );
 
  CREATE TABLE Cuenta (
  numero_cuenta VARCHAR(20) PRIMARY KEY,
  tipo_cuenta VARCHAR(50),
  saldo_inicial DECIMAL(10, 2),
  estado BOOLEAN,
  cliente_id VARCHAR(20) 
 );
   CREATE TABLE Movimiento (
  id_movimiento SERIAL PRIMARY KEY, 
  fecha TIMESTAMP,
  tipo_movimiento VARCHAR(20),
  valor_movimiento DECIMAL(10, 2),
  saldo_inicial_cuenta DECIMAL(10, 2),
  saldo_disponible_cuenta DECIMAL(10, 2),
  numero_cuenta_id VARCHAR(20), 
  CONSTRAINT fk_numero_cuenta FOREIGN KEY (numero_cuenta_id) REFERENCES Cuenta(numero_cuenta)
 );
 
 INSERT INTO Persona (identificacion, nombre, genero, edad, direccion, telefono) values ('1725489632', 'Jose Lema', 'Masculino', 30, 'Otavalo sn y principal', '098254785') ON CONFLICT DO NOTHING;
 INSERT INTO Persona (identificacion, nombre, genero, edad, direccion, telefono) values ('1758963214', 'Marianela Montalvo', 'Femenino', 25, 'Amazonas y NNUU', '097548965') ON CONFLICT DO NOTHING;
 INSERT INTO Persona (identificacion, nombre, genero, edad, direccion, telefono) values ('1796325871', 'Juan Osorio', 'Masculino', 40, '13 junio y Equinoccial', '098874587') ON CONFLICT DO NOTHING;
 
 INSERT INTO Cliente (clienteId, identificacion, contrasena, estado) VALUES ('CLI001', '1725489632', '1234', TRUE) ON CONFLICT DO NOTHING;
 INSERT INTO Cliente (clienteId, identificacion, contrasena, estado) values ('CLI002', '1758963214', '5678', TRUE) ON CONFLICT DO NOTHING;
 INSERT INTO Cliente (clienteId, identificacion, contrasena, estado) values ('CLI003', '1796325871', '1245', TRUE) ON CONFLICT DO NOTHING;
 
 INSERT INTO Cuenta (numero_cuenta, tipo_cuenta, saldo_inicial, estado, cliente_id) VALUES ('585545', 'Corriente', 1000.00, TRUE, '1725489632') ON CONFLICT DO NOTHING;
 INSERT INTO Cuenta (numero_cuenta, tipo_cuenta, saldo_inicial, estado, cliente_id) values ('478758', 'Ahorro', 2000.00, TRUE, '1758963214') ON CONFLICT DO NOTHING;
 INSERT INTO Cuenta (numero_cuenta, tipo_cuenta, saldo_inicial, estado, cliente_id) values ('225487', 'Corriente', 100.00, TRUE, '1758963214') ON CONFLICT DO NOTHING;
 INSERT INTO Cuenta (numero_cuenta, tipo_cuenta, saldo_inicial, estado, cliente_id) values ('495878', 'Ahorros', 0.00, TRUE, '1796325871') ON CONFLICT DO NOTHING;    
 INSERT INTO Cuenta (numero_cuenta, tipo_cuenta, saldo_inicial, estado, cliente_id) values ('496825', 'Ahorros', 540.00, TRUE, '1758963214') ON CONFLICT DO NOTHING;
 
 INSERT INTO Movimiento (fecha, tipo_movimiento, valor_movimiento, saldo_inicial_cuenta, saldo_disponible_cuenta, numero_cuenta_id) VALUES ('2022-02-10 09:00:00', 'Deposito', 600.00, 100.00, 700.00, '225487') ON CONFLICT DO NOTHING;
 INSERT INTO Movimiento (fecha, tipo_movimiento, valor_movimiento, saldo_inicial_cuenta, saldo_disponible_cuenta, numero_cuenta_id) VALUES ('2022-02-08 14:30:00', 'Retiro', -540.00, 540.00, 0.00, '496825') ON CONFLICT DO NOTHING;
 INSERT INTO Movimiento (fecha, tipo_movimiento, valor_movimiento, saldo_inicial_cuenta, saldo_disponible_cuenta, numero_cuenta_id) VALUES ('2022-02-09 11:00:00', 'Retiro', -575.00, 2000.00, 1425.00, '478758') ON CONFLICT DO NOTHING;
 INSERT INTO Movimiento (fecha, tipo_movimiento, valor_movimiento, saldo_inicial_cuenta, saldo_disponible_cuenta, numero_cuenta_id) VALUES ('2022-02-09 12:00:00', 'Deposito', 150.00, 0.00, 150.00, '495878') ON CONFLICT DO NOTHING;
  
  
  
  
  
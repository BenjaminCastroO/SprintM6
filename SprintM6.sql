CREATE DATABASE prevencion;
USE prevencion;

-- Tabla "Usuarios"
CREATE TABLE usuario (
 id INT PRIMARY KEY AUTO_INCREMENT,
 nombre VARCHAR(50) NOT NULL,
 username varchar(100) not null,
 password varchar(500) not null
);

CREATE TABLE administrativo (
  id int primary key AUTO_INCREMENT,
  run varchar(11) not null,
  nombre VARCHAR(50) not null,
  apellido varchar(50) not null,
  correo varchar(100) not null,
  area varchar(100),
  usuario_id int,
  FOREIGN key (usuario_id) REFERENCES usuario(id)
);

create table cliente (
  id int primary key AUTO_INCREMENT,
  rut varchar(11) not null,
  nombre VARCHAR(50) not null,
  apellido varchar(50) not null,
  correo varchar(100) not null,
  telefono varchar(20) not null,
  afp varchar(50),
  sistema_salud enum('isapre', 'fonasa'),
  direccion varchar(100),
  comuna varchar(50),
  edad smallint,
  usuario_id int,
  FOREIGN key (usuario_id) REFERENCES usuario(id)
);

create table profesional (
  id int primary key AUTO_INCREMENT,
  run varchar(11) not null,
  nombre VARCHAR(50) not null,
  apellido varchar(50) not null,
  correo varchar(100) not null,
  telefono varchar(20) not null,
  cargo varchar(50),
  usuario_id int,
  FOREIGN key (usuario_id) REFERENCES usuario(id)
);

-- Tabla "Capacitaciones"
CREATE TABLE capacitacion (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  detalle TEXT,
  fecha date,
  hora time,
  lugar varchar(500),
  duracion float,
  cantidad int,
  cliente_id int,
  foreign key (cliente_id) references cliente(id)
);

-- Tabla "Visitas"
CREATE TABLE visita (
  id INT PRIMARY KEY AUTO_INCREMENT,
  cliente_id INT,
  fecha DATE,
  hora time,
  lugar varchar(500),
  realizado boolean,
  detalle TEXT,
  profesional_id INT,
  FOREIGN KEY (cliente_id) REFERENCES cliente(id),
  FOREIGN KEY (profesional_id) REFERENCES profesional(id)
);

-- Tabla "Chequeos"
CREATE TABLE chequeo (
  id INT PRIMARY KEY AUTO_INCREMENT,
  visita_id INT,
  detalle TEXT,
  estado ENUM('Pendiente', 'Completado'),
  FOREIGN KEY (visita_id) REFERENCES visita(id)
);

-- Tabla "Pagos"
CREATE TABLE pago (
  id INT PRIMARY KEY AUTO_INCREMENT,
  cliente_id INT,
  monto DECIMAL(10,2),
  fecha_pago DATE,
  FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

-- Tabla "Asesorias"
CREATE TABLE asesoria (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  detalle TEXT,
  profesional_id INT,
  cliente_id int,
  FOREIGN KEY (profesional_id) REFERENCES profesional(id),
  foreign key (cliente_id) references cliente(id)
);

-- Tabla "Accidentes"
CREATE TABLE accidente (
  id INT PRIMARY KEY AUTO_INCREMENT,
  cliente_id INT,
  fecha_accidente DATE,
  detalle TEXT,
  FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

-- Tabla "Asistentes"
CREATE TABLE asistente (
  capacitacion_id INT,
  usuario_id INT,
  FOREIGN KEY (capacitacion_id) REFERENCES capacitacion(id),
  FOREIGN KEY (usuario_id) REFERENCES usuario(id),
  PRIMARY KEY (capacitacion_id, usuario_id)
);
describe visita;
-- set SQL_SAFE_UPDATES=0;
-- UPDATE usuario
-- SET password = '$2a$12$XOuZ4PkriYv7Sf8.3/su7uCTagMF26nHa6KUA/8EDWYoYcclGfDa2';
-- set SQL_SAFE_UPDATES=1;
-- select * from usuario;
INSERT INTO usuario (nombre, username, password)
VALUES
  ('John Doe', 'administrativo', '$2a$12$XOuZ4PkriYv7Sf8.3/su7uCTagMF26nHa6KUA/8EDWYoYcclGfDa2'),
  ('Jane Smith', 'janesmith', '$2a$12$XOuZ4PkriYv7Sf8.3/su7uCTagMF26nHa6KUA/8EDWYoYcclGfDa2'),
  ('Michael Johnson', 'michaeljohnson', '$2a$12$XOuZ4PkriYv7Sf8.3/su7uCTagMF26nHa6KUA/8EDWYoYcclGfDa2'),
  ('Emily Brown', 'emilybrown', '$2a$12$XOuZ4PkriYv7Sf8.3/su7uCTagMF26nHa6KUA/8EDWYoYcclGfDa2'),
  ('Daniel Miller', 'danielmiller', '$2a$12$XOuZ4PkriYv7Sf8.3/su7uCTagMF26nHa6KUA/8EDWYoYcclGfDa2'),
  ('Olivia Wilson', 'oliviawilson', '$2a$12$XOuZ4PkriYv7Sf8.3/su7uCTagMF26nHa6KUA/8EDWYoYcclGfDa2'),
  ('David Taylor', 'davidtaylor', '$2a$12$XOuZ4PkriYv7Sf8.3/su7uCTagMF26nHa6KUA/8EDWYoYcclGfDa2'),
  ('Sophia Anderson', 'sophiaanderson', '$2a$12$XOuZ4PkriYv7Sf8.3/su7uCTagMF26nHa6KUA/8EDWYoYcclGfDa2'),
  ('James Thomas', 'jamesthomas', '$2a$12$XOuZ4PkriYv7Sf8.3/su7uCTagMF26nHa6KUA/8EDWYoYcclGfDa2'),
  ('Emma Jackson', 'emmajackson', '$2a$12$XOuZ4PkriYv7Sf8.3/su7uCTagMF26nHa6KUA/8EDWYoYcclGfDa2'),
   ('Mary Johnson', 'cliente', '$2a$12$XOuZ4PkriYv7Sf8.3/su7uCTagMF26nHa6KUA/8EDWYoYcclGfDa2'),
  ('William Smith', 'williamsmith', '$2a$12$XOuZ4PkriYv7Sf8.3/su7uCTagMF26nHa6KUA/8EDWYoYcclGfDa2'),
  ('Sophia Miller', 'sophiamiller', '$2a$12$XOuZ4PkriYv7Sf8.3/su7uCTagMF26nHa6KUA/8EDWYoYcclGfDa2'),
  ('James Brown', 'jamesbrown', '$2a$12$XOuZ4PkriYv7Sf8.3/su7uCTagMF26nHa6KUA/8EDWYoYcclGfDa2'),
  ('Olivia Taylor', 'oliviataylor', '$2a$12$XOuZ4PkriYv7Sf8.3/su7uCTagMF26nHa6KUA/8EDWYoYcclGfDa2'),
  ('Liam Anderson', 'liamanderson', '$2a$12$XOuZ4PkriYv7Sf8.3/su7uCTagMF26nHa6KUA/8EDWYoYcclGfDa2'),
  ('Ava Thomas', 'avathomas', '$2a$12$XOuZ4PkriYv7Sf8.3/su7uCTagMF26nHa6KUA/8EDWYoYcclGfDa2'),
  ('Noah Johnson', 'noahjohnson', '$2a$12$XOuZ4PkriYv7Sf8.3/su7uCTagMF26nHa6KUA/8EDWYoYcclGfDa2'),
  ('Isabella Smith', 'isabellasmith', '$2a$12$XOuZ4PkriYv7Sf8.3/su7uCTagMF26nHa6KUA/8EDWYoYcclGfDa2'),
  ('Mia Miller', 'miamiller', '$2a$12$XOuZ4PkriYv7Sf8.3/su7uCTagMF26nHa6KUA/8EDWYoYcclGfDa2'),
  ('Andrew Davis', 'profesional', '$2a$12$XOuZ4PkriYv7Sf8.3/su7uCTagMF26nHa6KUA/8EDWYoYcclGfDa2'),
  ('Emma Wilson', 'emmawilson', '$2a$12$XOuZ4PkriYv7Sf8.3/su7uCTagMF26nHa6KUA/8EDWYoYcclGfDa2'),
  ('Matthew Thomas', 'matthewthomas', '$2a$12$XOuZ4PkriYv7Sf8.3/su7uCTagMF26nHa6KUA/8EDWYoYcclGfDa2'),
  ('Olivia Garcia', 'oliviagarcia', '$2a$12$XOuZ4PkriYv7Sf8.3/su7uCTagMF26nHa6KUA/8EDWYoYcclGfDa2'),
  ('Ethan Martinez', 'ethanmartinez', '$2a$12$XOuZ4PkriYv7Sf8.3/su7uCTagMF26nHa6KUA/8EDWYoYcclGfDa2'),
  ('Sophia Robinson', 'sophiarobinson', '$2a$12$XOuZ4PkriYv7Sf8.3/su7uCTagMF26nHa6KUA/8EDWYoYcclGfDa2'),
  ('Liam Clark', 'liamclark', '$2a$12$XOuZ4PkriYv7Sf8.3/su7uCTagMF26nHa6KUA/8EDWYoYcclGfDa2'),
  ('Ava Hernandez', 'avahernandez', '$2a$12$XOuZ4PkriYv7Sf8.3/su7uCTagMF26nHa6KUA/8EDWYoYcclGfDa2'),
  ('Noah Young', 'noahyoung', '$2a$12$XOuZ4PkriYv7Sf8.3/su7uCTagMF26nHa6KUA/8EDWYoYcclGfDa2'),
  ('Isabella Lee', 'isabellalee', '$2a$12$XOuZ4PkriYv7Sf8.3/su7uCTagMF26nHa6KUA/8EDWYoYcclGfDa2');


INSERT INTO administrativo (run, nombre, apellido, correo, area, usuario_id)
VALUES
  ('111111111', 'John', 'Doe', 'john.doe@example.com', 'HR', 1),
  ('222222222', 'Jane', 'Smith', 'jane.smith@example.com', 'Finance', 2),
  ('333333333', 'Michael', 'Johnson', 'michael.johnson@example.com', 'IT', 3),
  ('444444444', 'Emily', 'Brown', 'emily.brown@example.com', 'Marketing', 4),
  ('555555555', 'Daniel', 'Miller', 'daniel.miller@example.com', 'Operations', 5),
  ('666666666', 'Olivia', 'Wilson', 'olivia.wilson@example.com', 'Sales', 6),
  ('777777777', 'David', 'Taylor', 'david.taylor@example.com', 'HR', 7),
  ('888888888', 'Sophia', 'Anderson', 'sophia.anderson@example.com', 'Finance', 8),
  ('999999999', 'James', 'Thomas', 'james.thomas@example.com', 'IT', 9),
  ('123456789', 'Emma', 'Jackson', 'emma.jackson@example.com', 'Marketing', 10);


INSERT INTO cliente (rut, nombre, apellido, correo, telefono, afp, sistema_salud, direccion, comuna, edad, usuario_id)
VALUES
  ('012345678-9', 'Mary', 'Johnson', 'mary.johnson@example.com', '987654321', 'AFP Provida', 'isapre', '123 Oak St', 'Santiago', 30, 11),
  ('234567890-1', 'William', 'Smith', 'william.smith@example.com', '123456789', 'AFP Capital', 'fonasa', '456 Maple St', 'Valparaíso', 42, 12),
  ('345678901-2', 'Sophia', 'Miller', 'sophia.miller@example.com', '543216789', 'AFP Habitat', 'isapre', '789 Elm St', 'Concepción', 28, 13),
  ('456789012-3', 'James', 'Brown', 'james.brown@example.com', '678912345', 'AFP Modelo', 'fonasa', '987 Pine St', 'La Serena', 35, 14),
  ('567890123-4', 'Olivia', 'Taylor', 'olivia.taylor@example.com', '219876543', 'AFP Cuprum', 'isapre', '654 Cedar St', 'Temuco', 27, 15),
  ('678901234-5', 'Liam', 'Anderson', 'liam.anderson@example.com', '345678912', 'AFP ProVida', 'fonasa', '321 Elm St', 'Copiapó', 39, 16),
  ('789012345-6', 'Ava', 'Thomas', 'ava.thomas@example.com', '891234567', 'AFP Capital', 'isapre', '876 Maple St', 'Rancagua', 33, 17),
  ('890123456-7', 'Noah', 'Johnson', 'noah.johnson@example.com', '456789123', 'AFP Modelo', 'fonasa', '543 Elm St', 'La Serena', 55, 18),
  ('901234567-8', 'Isabella', 'Smith', 'isabella.smith@example.com', '912345678', 'AFP Cuprum', 'isapre', '876 Pine St', 'Temuco', 33, 19),
  ('012345678-9', 'Mia', 'Miller', 'mia.miller@example.com', '234567891', 'AFP ProVida', 'fonasa', '109 Cedar St', 'Copiapó', 48, 20);


INSERT INTO profesional (run, nombre, apellido, correo, telefono, cargo, usuario_id)
VALUES
  ('111111111', 'Andrew', 'Davis', 'andrew.davis@example.com', '123456789', 'Doctor', 21),
  ('222222222', 'Emma', 'Wilson', 'emma.wilson@example.com', '987654321', 'Nurse', 22),
  ('333333333', 'Matthew', 'Thomas', 'matthew.thomas@example.com', '543216789', 'Surgeon', 23),
  ('444444444', 'Olivia', 'Garcia', 'olivia.garcia@example.com', '678912345', 'Dentist', 24),
  ('555555555', 'Ethan', 'Martinez', 'ethan.martinez@example.com', '219876543', 'Psychologist', 25),
  ('666666666', 'Sophia', 'Robinson', 'sophia.robinson@example.com', '345678912', 'Physiotherapist', 26),
  ('777777777', 'Liam', 'Clark', 'liam.clark@example.com', '891234567', 'Nutritionist', 27),
  ('888888888', 'Ava', 'Hernandez', 'ava.hernandez@example.com', '456789123', 'Occupational Therapist', 28),
  ('999999999', 'Noah', 'Young', 'noah.young@example.com', '912345678', 'Speech Therapist', 29),
  ('123456789', 'Isabella', 'Lee', 'isabella.lee@example.com', '234567891', 'Pharmacist', 30);
  
--  select * from cliente;
 -- select id, nombre, detalle, fecha, hora, lugar, duracion, cantidad, cliente_id from capacitacion;

INSERT INTO capacitacion (nombre, detalle, fecha, hora, lugar, duracion, cantidad, cliente_id)
VALUES
  ('Capacitación 1', 'Detalles de la capacitación 1', '2023-07-01', '09:00:00', 'Sala de conferencias A', 2.5, 20, 1),
  ('Capacitación 2', 'Detalles de la capacitación 2', '2023-07-03', '14:30:00', 'Sala de conferencias B', 3.0, 15, 2),
  ('Capacitación 3', 'Detalles de la capacitación 3', '2023-07-05', '10:00:00', 'Sala de capacitaciones C', 2.0, 25, 3),
  ('Capacitación 4', 'Detalles de la capacitación 4', '2023-07-07', '13:00:00', 'Salón de eventos D', 4.5, 30, 4),
  ('Capacitación 5', 'Detalles de la capacitación 5', '2023-07-09', '11:30:00', 'Sala de conferencias E', 2.5, 18, 5);
  

INSERT INTO visita (cliente_id, fecha, hora, lugar, realizado, detalle, profesional_id)
VALUES
  (1, '2023-07-02', '08:30:00', 'Oficina del cliente', true, 'Detalles de la visita 1', 1),
  (2, '2023-07-04', '15:00:00', 'Lugar de trabajo del cliente', true, 'Detalles de la visita 2', 2),
  (3, '2023-07-06', '09:30:00', 'Oficina principal del cliente', false, 'Detalles de la visita 3', 3),
  (4, '2023-07-08', '14:00:00', 'Instalaciones del cliente', false, 'Detalles de la visita 4', 4),
  (5, '2023-07-10', '12:30:00', 'Sitio del proyecto', false, 'Detalles de la visita 5', 5);

INSERT INTO chequeo (visita_id, detalle, estado)
VALUES
  (1, 'Chequeo 1', 'Pendiente'),
  (2, 'Chequeo 2', 'Completado'),
  (1, 'Chequeo 3', 'Pendiente'),
  (3, 'Chequeo 4', 'Completado'),
  (2, 'Chequeo 5', 'Pendiente');


INSERT INTO pago (cliente_id, monto, fecha_pago)
VALUES
  (1, 100.50, '2023-07-01'),
  (2, 75.20, '2023-07-02'),
  (3, 120.75, '2023-07-03'),
  (4, 90.10, '2023-07-04'),
  (5, 150.00, '2023-07-05');


INSERT INTO asesoria (nombre, detalle, profesional_id, cliente_id)
VALUES
  ('Asesoría 1', 'Detalles de la asesoría 1', 1, 1),
  ('Asesoría 2', 'Detalles de la asesoría 2', 2, 2),
  ('Asesoría 3', 'Detalles de la asesoría 3', 3, 3),
  ('Asesoría 4', 'Detalles de la asesoría 4', 4, 4),
  ('Asesoría 5', 'Detalles de la asesoría 5', 5, 5);


INSERT INTO accidente (cliente_id, fecha_accidente, detalle)
VALUES
  (1, '2023-06-28', 'Detalles del accidente 1'),
  (2, '2023-06-29', 'Detalles del accidente 2'),
  (3, '2023-06-30', 'Detalles del accidente 3'),
  (4, '2023-07-01', 'Detalles del accidente 4'),
  (5, '2023-07-02', 'Detalles del accidente 5');


INSERT INTO asistente (capacitacion_id, usuario_id)
VALUES
  (1, 1),
  (1, 2),
  (2, 3),
  (2, 4),
  (3, 5),
  (3, 6),
  (4, 7),
  (4, 8),
  (5, 9),
  (5, 10);


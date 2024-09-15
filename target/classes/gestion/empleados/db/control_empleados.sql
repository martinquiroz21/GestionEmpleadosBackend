create schema if not exists control_empleados;

CREATE TABLE `empleados` (
  `id` bigint(20) NOT NULL,
  `apellido` varchar(60) NOT NULL,
  `email` varchar(60) NOT NULL,
  `nombre` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `empleados` (`id`, `apellido`, `email`, `nombre`) VALUES
(1, 'Endosal', 'male@gmail.com', 'Mali'),
(3, 'Qrueiqwr', 'adsfasfsaf@gmail.com', 'Maritn'),
(4, 'Yayo', 'lasdsad@gmail.com', 'Juan'),
(5, 'Nando', 'Michosdsds@gmail.com', 'Pepo');

ALTER TABLE `empleados`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK6fdpo2x5rmegfbngre7xb3yoh` (`email`);

ALTER TABLE `empleados`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;



-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-12-2024 a las 20:03:35
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `los_pollos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `boletas`
--

CREATE TABLE `boletas` (
  `id_boleta` int(11) NOT NULL,
  `valor_total` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `boletas`
--

INSERT INTO `boletas` (`id_boleta`, `valor_total`) VALUES
(1, 0.00),
(2, 31000.00),
(3, 0.00),
(4, 0.00),
(5, 0.00),
(6, 0.00),
(7, 41000.00),
(8, 24000.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalles_boleta`
--

CREATE TABLE `detalles_boleta` (
  `id` int(11) NOT NULL,
  `id_boleta` int(11) NOT NULL,
  `producto` varchar(255) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `detalles_boleta`
--

INSERT INTO `detalles_boleta` (`id`, `id_boleta`, `producto`, `cantidad`, `precio`) VALUES
(1, 2, 'panqueque', 1, 7000.00),
(2, 2, 'panqueque', 1, 7000.00),
(3, 2, 'zapallo italiano', 1, 7000.00),
(4, 2, 'leche asada', 1, 10000.00),
(5, 7, 'panqueque', 1, 7000.00),
(6, 7, 'zapallo italiano', 1, 7000.00),
(7, 7, 'leche asada', 1, 10000.00),
(8, 7, 'leche asada', 1, 10000.00),
(9, 7, 'zapallo italiano', 1, 7000.00),
(10, 8, 'panqueque', 1, 7000.00),
(11, 8, 'zapallo italiano', 1, 7000.00),
(12, 8, 'leche asada', 1, 10000.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `platillos`
--

CREATE TABLE `platillos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `descripcion` text NOT NULL,
  `valor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `platillos`
--

INSERT INTO `platillos` (`id`, `nombre`, `descripcion`, `valor`) VALUES
(12, 'panqueque', 'yumi', 7000),
(13, 'zapallo italiano', 'iu', 7000),
(14, 'leche asada', 'hapi', 10000),
(15, 'zapallo2', 'adasd', 12);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `boletas`
--
ALTER TABLE `boletas`
  ADD PRIMARY KEY (`id_boleta`);

--
-- Indices de la tabla `detalles_boleta`
--
ALTER TABLE `detalles_boleta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_boleta` (`id_boleta`);

--
-- Indices de la tabla `platillos`
--
ALTER TABLE `platillos`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `boletas`
--
ALTER TABLE `boletas`
  MODIFY `id_boleta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `detalles_boleta`
--
ALTER TABLE `detalles_boleta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `platillos`
--
ALTER TABLE `platillos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalles_boleta`
--
ALTER TABLE `detalles_boleta`
  ADD CONSTRAINT `detalles_boleta_ibfk_1` FOREIGN KEY (`id_boleta`) REFERENCES `boletas` (`id_boleta`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

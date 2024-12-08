-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-12-2024 a las 01:05:59
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `05incidenciasob`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `Id` int(11) NOT NULL,
  `FechaReporte` varchar(255) NOT NULL,
  `NombreObra` varchar(255) NOT NULL,
  `NombresPersonasAsunto` varchar(255) NOT NULL,
  `Motivo` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`Id`, `FechaReporte`, `NombreObra`, `NombresPersonasAsunto`, `Motivo`) VALUES
(64, '23/08/2024', 'Alcantar', 'Albañil, Electricista , Alfarero, Herrero, Maestro de Obra, Ingeniero civil', 'Realizaron destrozos de maquinaria'),
(67, '23/08/2024', 'Alcantar', 'Albañil, Electricista , Alfarero, Herrero, Maestro de Obra, Ingeniero civil', 'Realizaron destrozos de maquinaria'),
(68, '23/08/2024', 'Alcantar', 'Albañil, Electricista , Alfarero, Herrero, Maestro de Obra, Ingeniero civil', 'Realizaron destrozos de maquinaria');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=69;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

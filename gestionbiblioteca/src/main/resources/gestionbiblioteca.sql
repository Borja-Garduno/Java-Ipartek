-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-09-2016 a las 13:20:22
-- Versión del servidor: 10.1.13-MariaDB
-- Versión de PHP: 7.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gestionbiblioteca`
--
CREATE DATABASE IF NOT EXISTS `gestionbiblioteca` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `gestionbiblioteca`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejemplar`
--
-- Creación: 22-09-2016 a las 11:23:54
--

DROP TABLE IF EXISTS `ejemplar`;
CREATE TABLE IF NOT EXISTS `ejemplar` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `codigoLibro` int(11) NOT NULL,
  `editorial` varchar(50) NOT NULL,
  `nPaginas` int(11) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- RELACIONES PARA LA TABLA `ejemplar`:
--

--
-- Truncar tablas antes de insertar `ejemplar`
--

TRUNCATE TABLE `ejemplar`;
--
-- Volcado de datos para la tabla `ejemplar`
--

INSERT INTO `ejemplar` (`codigo`, `codigoLibro`, `editorial`, `nPaginas`) VALUES
(6, 1, 'PLAZA & JANES EDITORES', 500),
(7, 2, 'SALAMANDRA', 300),
(8, 2, 'DE BOLSILLO', 200),
(9, 4, 'RBA LIBROS', 400);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--
-- Creación: 19-09-2016 a las 10:28:43
--

DROP TABLE IF EXISTS `libro`;
CREATE TABLE IF NOT EXISTS `libro` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(50) NOT NULL,
  `autor` varchar(50) NOT NULL,
  `isbn` varchar(20) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- RELACIONES PARA LA TABLA `libro`:
--

--
-- Truncar tablas antes de insertar `libro`
--

TRUNCATE TABLE `libro`;
--
-- Volcado de datos para la tabla `libro`
--

INSERT INTO `libro` (`codigo`, `titulo`, `autor`, `isbn`) VALUES
(1, 'LOS PILARES DE LA TIERRA', 'KEN FOLLET', '9788401328510'),
(2, 'HARRY POTTER Y LA PIEDRA FILOSOFAL', 'J.K. ROWLING', '9788478884452'),
(3, 'LA BIBLIOTECA DE LOS MUERTOS', 'GLENN COOPER', '9788425343902'),
(4, 'DIEZ NEGRITOS', 'AGATHA CHRISTIE', '9788478718573');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--
-- Creación: 23-09-2016 a las 08:28:01
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `codigoEjemplar` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `fNacimiento` date NOT NULL,
  `email` varchar(30) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

--
-- RELACIONES PARA LA TABLA `usuario`:
--

--
-- Truncar tablas antes de insertar `usuario`
--

TRUNCATE TABLE `usuario`;
--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`codigo`, `codigoEjemplar`, `nombre`, `apellidos`, `fNacimiento`, `email`) VALUES
(7, 0, 'JOSU', 'ROJAS MENDEZ', '2016-09-21', 'JOSU@HOTMAIL.COM'),
(13, 0, 'CLAUDIA', 'ROJAS MENDEZ', '2016-09-21', 'CLAUDIA@HOTMAIL.COM'),
(14, 0, 'IGOR', 'MATEO JIMENEZ', '2016-09-19', 'IGOR@HOTMAIL.COM'),
(15, 0, 'NATALIA', 'GARDUÑO SANTAMARIA', '1983-09-07', 'NATALIA@HOTMAIL.COM'),
(16, 0, 'BORJA', 'GARDUÑO SANTAMARIA', '1990-06-24', 'BORJA.GARDUNO@HOTMAIL.COM'),
(17, 0, 'RUBEN', 'FONSECA SANTAMARIA', '2016-09-20', 'RUBEN@HOTMAIL.COM'),
(18, 0, 'CARMEN', 'SANTAMARIA GONZALEZ', '1964-04-14', 'CARMEN@HOTMAIL.COM'),
(19, 0, 'JUAN IGNACIO', 'GARDUÑO GARDUÑO', '1960-02-29', 'JUAN@HOTMAIL.COM'),
(20, 0, 'LOURDES', 'SANTAMARIA GONZALEZ', '2016-09-21', 'LOURDES@HOTMAIL.COM'),
(21, 0, 'ERASMO', 'SEEBOLD', '2016-09-21', 'ERASMO@HOTMAIL.COM'),
(23, 0, 'MARTA', 'RIVERA', '2016-09-21', 'MARTA@HOTMAIL.COM'),
(24, 0, 'EDER', 'IBAÑEZ ROJO', '2016-09-21', 'EDER@HOTMAIL.COM'),
(25, 0, 'ALVARO', 'GANA', '2016-09-22', 'ALVARO@HOTMAIL.COM');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

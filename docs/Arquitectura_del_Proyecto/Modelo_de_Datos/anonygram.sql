CREATE database anonygram;

use anonygram;

CREATE TABLE `usuario` (
  `id` varchar(16) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `usuario` int(11) NOT NULL,
  `nombre` int(11) NOT NULL,
  `rol` int(11) NOT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

CREATE TABLE `chat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usuarioCreador` varchar(16) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `usurioRespuesta` varchar(16) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `fechaCreacion` date NOT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  KEY `usuarioCreador` (`usuarioCreador`) USING BTREE,
  KEY `usurioRespuesta` (`usurioRespuesta`),
  CONSTRAINT `chat_ibfk_1` FOREIGN KEY (`usuarioCreador`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `chat_ibfk_2` FOREIGN KEY (`usurioRespuesta`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

CREATE TABLE `mensaje` (
  `id` bigint(16) NOT NULL AUTO_INCREMENT,
  `mensaje` text COLLATE utf8mb4_spanish2_ci NOT NULL,
  `usuario` varchar(16) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `chat` int(11) NOT NULL,
  `timestamp` date NOT NULL DEFAULT current_timestamp(),
  `activo` tinyint(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  KEY `usuario` (`usuario`),
  KEY `chat` (`chat`),
  CONSTRAINT `mensaje_ibfk_2` FOREIGN KEY (`chat`) REFERENCES `chat` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `mensaje_ibfk_3` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

DROP DATABASE IF EXISTS lomas_alejandro;

CREATE DATABASE lomas_alejandro;

USE lomas_alejandro;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


--
-- Base de datos: `lomas_alejandro`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--


CREATE TABLE IF NOT EXISTS `categorias` (
  `id_categoria` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(80) COLLATE utf8mb4_unicode_ci NOT NULL,
  `descripcion` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `estado` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id_categoria`),
  UNIQUE KEY `nombre` (`nombre`)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `categorias`
--

INSERT INTO `categorias` (`id_categoria`, `nombre`, `descripcion`, `estado`) VALUES
(1, 'Frutales', 'Árboles frutales', 1),
(2, 'Ornamentales', 'Plantas ornamentales', 1),
(3, 'Forestales', 'Árboles forestales', 1),
(4, 'Medicinales', 'Plantas medicinales', 1),
(5, 'Palmeras', 'Palmeras', 1),
(6, 'Insumos', 'Fertilizantes, bolsas y herramientas', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--


CREATE TABLE IF NOT EXISTS `roles` (
  `id_rol` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `descripcion` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id_rol`),
  UNIQUE KEY `nombre` (`nombre`)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`id_rol`, `nombre`, `descripcion`) VALUES
(1, 'Administrador', 'Acceso total al sistema'),
(2, 'Empleado', 'Acceso limitado para ventas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--


CREATE TABLE IF NOT EXISTS `usuarios` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `id_rol` int NOT NULL,
  `nombre` varchar(80) COLLATE utf8mb4_unicode_ci NOT NULL,
  `apellido_paterno` varchar(80) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `apellido_materno` varchar(80) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `usuario` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `contrasena` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `telefono` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `correo` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `estado` tinyint(1) DEFAULT '1',
  `fecha_registro` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_usuario`),
UNIQUE KEY `usuario` (`usuario`),

CONSTRAINT fk_usuario_rol
FOREIGN KEY (`id_rol`)
REFERENCES roles(`id_rol`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `id_rol`, `nombre`, `apellido_paterno`, `apellido_materno`, `usuario`, `contrasena`, `telefono`, `correo`, `estado`, `fecha_registro`) VALUES
(1, 1, 'Gerardo', 'Lomas', 'Alejandro', 'admin', 'admin123', NULL, NULL, 1, '2026-07-12 16:30:55');






CREATE TABLE IF NOT EXISTS proveedores (

    id_proveedor INT AUTO_INCREMENT PRIMARY KEY,

    nombre VARCHAR(100) NOT NULL,

    telefono VARCHAR(20),

    correo VARCHAR(100) DEFAULT NULL,

    direccion VARCHAR(200),

    contacto VARCHAR(100),

    estado BOOLEAN DEFAULT TRUE,

    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP

) ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci;

INSERT INTO proveedores
(nombre,telefono,correo,direccion,contacto)
VALUES

('Vivero El Paraíso',
'7841000001',
'contacto@paraiso.com',
'Papantla, Veracruz',
'Juan Pérez'),

('Injertos del Golfo',
'7841000002',
'ventas@golfo.com',
'Poza Rica, Veracruz',
'María López');

-- --------------------------------------------------------
-- Estructura de tabla para la tabla `clientes`
-- --------------------------------------------------------



CREATE TABLE IF NOT EXISTS clientes (

    id_cliente INT AUTO_INCREMENT PRIMARY KEY,

    nombre VARCHAR(100) NOT NULL,

    telefono VARCHAR(20),

    correo VARCHAR(100),

    direccion VARCHAR(200),

    rfc VARCHAR(13),

    tipo_cliente ENUM('MENUDEO','MAYOREO')
    DEFAULT 'MENUDEO',

    estado BOOLEAN DEFAULT TRUE,

    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP

) ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci;

INSERT INTO clientes
(nombre,telefono,correo,direccion,rfc,tipo_cliente)
VALUES

('Juan Pérez',
'7841234567',
NULL,
'Papantla, Veracruz',
NULL,
'MENUDEO'),

('Constructora Los Pinos',
'7849876543',
NULL,
'Poza Rica, Veracruz',
'XAXX010101000',
'MAYOREO');

-- --------------------------------------------------------
-- Estructura de tabla para la tabla `productos`
-- --------------------------------------------------------



CREATE TABLE IF NOT EXISTS productos (

    id_producto INT AUTO_INCREMENT PRIMARY KEY,

    id_categoria INT NOT NULL,

    nombre VARCHAR(120) NOT NULL,

    variedad VARCHAR(100),

    codigo VARCHAR(30) NOT NULL UNIQUE,

    codigo_barras VARCHAR(50),

    descripcion VARCHAR(255),

    precio_compra DECIMAL(10,2) NOT NULL,

    precio_venta DECIMAL(10,2) NOT NULL,

    stock INT DEFAULT 0,

    stock_minimo INT DEFAULT 10,

    unidad VARCHAR(20) DEFAULT 'Pieza',

    ubicacion VARCHAR(100),

    imagen VARCHAR(255),

    estado BOOLEAN DEFAULT TRUE,

    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_producto_categoria
    FOREIGN KEY (id_categoria)
    REFERENCES categorias(id_categoria)

) ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci;


INSERT INTO productos
(id_categoria,nombre,variedad,codigo,codigo_barras,descripcion,
precio_compra,precio_venta,stock,ubicacion)
VALUES

(1,'Limón Persa','Injertado',
'P001',
'750000000001',
'Árbol frutal',
80,
150,
120,
'Pasillo A'),

(5,'Palma Areca',
NULL,
'P002',
'750000000002',
'Palmera ornamental',
120,
220,
40,
'Pasillo C');

-- --------------------------------------------------------
-- Estructura de tabla para la tabla `compras`
-- --------------------------------------------------------



CREATE TABLE IF NOT EXISTS compras (

    id_compra INT AUTO_INCREMENT PRIMARY KEY,

    id_proveedor INT NOT NULL,

    id_usuario INT NOT NULL,

   numero_factura VARCHAR(50) DEFAULT NULL,

    fecha DATE DEFAULT (CURRENT_DATE),

    total DECIMAL(10,2) NOT NULL,

    observaciones VARCHAR(255),

    estado BOOLEAN DEFAULT TRUE,

    CONSTRAINT fk_compra_proveedor
    FOREIGN KEY(id_proveedor)
    REFERENCES proveedores(id_proveedor),

    CONSTRAINT fk_compra_usuario
    FOREIGN KEY(id_usuario)
    REFERENCES usuarios(id_usuario)

) ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci;


-- --------------------------------------------------------
-- Estructura de tabla para la tabla `detalle_compra`
-- --------------------------------------------------------



CREATE TABLE IF NOT EXISTS detalle_compra (

    id_detalle_compra INT AUTO_INCREMENT PRIMARY KEY,

    id_compra INT NOT NULL,

    id_producto INT NOT NULL,

    cantidad INT NOT NULL,

    precio DECIMAL(10,2) NOT NULL,

    subtotal DECIMAL(10,2) NOT NULL,

    CONSTRAINT fk_detalle_compra
    FOREIGN KEY(id_compra)
    REFERENCES compras(id_compra),

    CONSTRAINT fk_detalle_producto
    FOREIGN KEY(id_producto)
    REFERENCES productos(id_producto)

) ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------
-- Estructura de tabla para la tabla `ventas`
-- --------------------------------------------------------

CREATE TABLE IF NOT EXISTS ventas (

    id_venta INT AUTO_INCREMENT PRIMARY KEY,

    id_cliente INT NOT NULL,

    id_usuario INT NOT NULL,

    fecha DATE DEFAULT (CURRENT_DATE),

    subtotal DECIMAL(10,2) NOT NULL,

    descuento DECIMAL(10,2) DEFAULT 0,

    total DECIMAL(10,2) NOT NULL,

    metodo_pago ENUM('EFECTIVO','TRANSFERENCIA','TARJETA') DEFAULT 'EFECTIVO',

    observaciones VARCHAR(255),

    estado BOOLEAN DEFAULT TRUE,

    CONSTRAINT fk_venta_cliente
    FOREIGN KEY (id_cliente)
    REFERENCES clientes(id_cliente),

    CONSTRAINT fk_venta_usuario
    FOREIGN KEY (id_usuario)
    REFERENCES usuarios(id_usuario)

) ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------
-- Estructura de tabla para la tabla `detalle_venta`
-- --------------------------------------------------------

CREATE TABLE IF NOT EXISTS detalle_venta (

    id_detalle_venta INT AUTO_INCREMENT PRIMARY KEY,

    id_venta INT NOT NULL,

    id_producto INT NOT NULL,

    cantidad INT NOT NULL,

    precio DECIMAL(10,2) NOT NULL,

    subtotal DECIMAL(10,2) NOT NULL,

    CONSTRAINT fk_detalleventa_venta
    FOREIGN KEY (id_venta)
    REFERENCES ventas(id_venta),

    CONSTRAINT fk_detalleventa_producto
    FOREIGN KEY (id_producto)
    REFERENCES productos(id_producto)

) ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------
-- Estructura de tabla para la tabla `movimientos_inventario`
-- --------------------------------------------------------

CREATE TABLE IF NOT EXISTS movimientos_inventario (

    id_movimiento INT AUTO_INCREMENT PRIMARY KEY,

    id_producto INT NOT NULL,

    id_usuario INT NOT NULL,

    tipo_movimiento ENUM('ENTRADA','SALIDA','AJUSTE') NOT NULL,

    cantidad INT NOT NULL,

    motivo VARCHAR(200),

    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_movimiento_producto
    FOREIGN KEY (id_producto)
    REFERENCES productos(id_producto),

    CONSTRAINT fk_movimiento_usuario
    FOREIGN KEY (id_usuario)
    REFERENCES usuarios(id_usuario)

) ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------
-- Estructura de tabla para la tabla `bitacora`
-- --------------------------------------------------------

CREATE TABLE IF NOT EXISTS bitacora (

    id_bitacora INT AUTO_INCREMENT PRIMARY KEY,

    id_usuario INT NOT NULL,

    accion VARCHAR(150) NOT NULL,

    descripcion VARCHAR(255),

    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    ip_equipo VARCHAR(45),

    CONSTRAINT fk_bitacora_usuario
    FOREIGN KEY (id_usuario)
    REFERENCES usuarios(id_usuario)

) ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci;


-- --------------------------------------------------------
-- Estructura de tabla para la tabla `configuracion`
-- --------------------------------------------------------

CREATE TABLE IF NOT EXISTS configuracion (

    id_configuracion INT AUTO_INCREMENT PRIMARY KEY,

    nombre_empresa VARCHAR(150),

    propietario VARCHAR(150),

    telefono VARCHAR(20),

    correo VARCHAR(100),

    direccion VARCHAR(255),

    logo VARCHAR(255),

    moneda VARCHAR(10) DEFAULT '$',

    impuesto DECIMAL(5,2) DEFAULT 0.00

) ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci;

INSERT INTO configuracion
(nombre_empresa, propietario, telefono, correo, direccion)
VALUES
(
'Lomas Alejandro',
'Gerardo Lomas Alejandro',
NULL,
NULL,
'Papantla, Veracruz'
);



COMMIT;




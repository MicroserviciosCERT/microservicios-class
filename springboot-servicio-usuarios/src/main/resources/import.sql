INSERT INTO usuarios (username,password,enabled,nombre,apellido,email) VALUES('luis','$2a$10$5vQbz/F.BxV.TM3xPJtXm.qP/B8p24s5V0Yj1cfufMNC1cxv9i9bC',1,'Luis','Perez','luis@correo.com');
INSERT INTO usuarios (username,password,enabled,nombre,apellido,email) VALUES('admin','$2a$10$5vQbz/F.BxV.TM3xPJtXm.qP/B8p24s5V0Yj1cfufMNC1cxv9i9bC',1,'John','Doe','john.doe@correo.com');

INSERT INTO roles (nombre) VALUES('ROLE_USER');
INSERT INTO roles (nombre) VALUES('ROLE_ADMIN');

INSERT INTO usuarios_roles(usuario_id,role_id) VALUES(1,1);
INSERT INTO usuarios_roles(usuario_id,role_id) VALUES(2,2);
INSERT INTO usuarios_roles(usuario_id,role_id) VALUES(2,1);
INSERT INTO 'users' (name,surname,dni,birthdate,address,email,username,password,enable) VALUES ('Claudio Oscar','Mercado','39.300.525','1996-05-14','Caseros','claudiomercado19@gmail.com','claudio1','',1);
INSERT INTO 'users' (name,surname,dni,birthdate,address,email,username,password,enable) VALUES ('Maria Ines','Toledo','39.905.178','1997-03-20','Caseros','mariainestoledo20397@gmail.com','maria1','',1);

INSERT INTO 'roles' (name) VALUES ('ROLE_USER');
INSERT INTO 'roles' (name) VALUES ('ROLE_ADMIN');

INSERT INTO 'users_roles' (usuario_id, roles_id) VALUES (1,1);
INSERT INTO 'users_roles' (usuario_id, roles_id) VALUES (2,1);
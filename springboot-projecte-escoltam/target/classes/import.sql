/* Creacció usuaris i rols */
INSERT INTO usuaris (username, password, enabled, nom, cognoms, phone, email, gender) VALUES ('Gemma_admin','$2a$10$RmdEsvEfhI7Rcm9f/uZXPebZVCcPC7ZXZwV51efAvMAp1rIaRAfPK',true, 'Gemma', 'Rica', '600000001', 'gemmarica94@gmail.com', 'FEMALE');
INSERT INTO usuaris (username, password, enabled, nom, cognoms, phone, email, gender) VALUES ('Jonatan_admin','$2a$10$RmdEsvEfhI7Rcm9f/uZXPebZVCcPC7ZXZwV51efAvMAp1rIaRAfPK',true, 'Jonatan', 'Chaler', '600000002', 'jonatanchaler@gmail.com', 'MALE');
INSERT INTO usuaris (username, password, enabled, nom, cognoms, phone, email, gender) VALUES ('Jordi_admin','$2a$10$RmdEsvEfhI7Rcm9f/uZXPebZVCcPC7ZXZwV51efAvMAp1rIaRAfPK',true, 'Jordi', 'Gomez', '600000003', 'JoGomLoz@gmail.com', 'MALE');
INSERT INTO usuaris (username, password, enabled, nom, cognoms, phone, email, gender) VALUES ('Maria_prova','$2a$10$RmdEsvEfhI7Rcm9f/uZXPebZVCcPC7ZXZwV51efAvMAp1rIaRAfPK',true, 'Maria', 'Prova', '600000004', 'mariaprova@gmail.com', 'FEMALE');

INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');

INSERT INTO usuaris_roles (usuari_id, role_id) VALUES (1,2);
INSERT INTO usuaris_roles (usuari_id, role_id) VALUES (2,2);
INSERT INTO usuaris_roles (usuari_id, role_id) VALUES (3,2);
INSERT INTO usuaris_roles (usuari_id, role_id) VALUES (4,1);
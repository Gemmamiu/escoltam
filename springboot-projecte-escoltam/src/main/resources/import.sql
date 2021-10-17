/* Creacció usuaris i rols */
/*Password d'usuaris és 12345 - En aquí ja està encriptat*/
INSERT INTO usuaris (username, password, enabled, voice) VALUES ('gemmarica94@gmail.com','$2a$10$RmdEsvEfhI7Rcm9f/uZXPebZVCcPC7ZXZwV51efAvMAp1rIaRAfPK',true, 'FEMALE');
INSERT INTO usuaris (username, password, enabled, voice) VALUES ('jonatanchaler@gmail.com','$2a$10$RmdEsvEfhI7Rcm9f/uZXPebZVCcPC7ZXZwV51efAvMAp1rIaRAfPK',true, 'MALE');
INSERT INTO usuaris (username, password, enabled, voice) VALUES ('JoGomLoz@gmail.com','$2a$10$RmdEsvEfhI7Rcm9f/uZXPebZVCcPC7ZXZwV51efAvMAp1rIaRAfPK',true, 'MALE');
INSERT INTO usuaris (username, password, enabled, voice) VALUES ('mariaprova@gmail.com','$2a$10$RmdEsvEfhI7Rcm9f/uZXPebZVCcPC7ZXZwV51efAvMAp1rIaRAfPK',true, 'FEMALE');

INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');

INSERT INTO usuaris_roles (usuari_id, role_id) VALUES (1,2);
INSERT INTO usuaris_roles (usuari_id, role_id) VALUES (2,2);
INSERT INTO usuaris_roles (usuari_id, role_id) VALUES (3,2);
INSERT INTO usuaris_roles (usuari_id, role_id) VALUES (4,1);
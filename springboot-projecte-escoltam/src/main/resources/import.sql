/* Creacció usuaris i rols */
/*Password d'usuaris és 12345 - En aquí ja està encriptat*/
INSERT INTO usuari (username, password, enabled, voice) VALUES ('gemmarica94@gmail.com','$2a$10$RmdEsvEfhI7Rcm9f/uZXPebZVCcPC7ZXZwV51efAvMAp1rIaRAfPK', true, 'FEMALE');
INSERT INTO usuari (username, password, enabled, voice) VALUES ('jonatanchaler@gmail.com','$2a$10$RmdEsvEfhI7Rcm9f/uZXPebZVCcPC7ZXZwV51efAvMAp1rIaRAfPK', true, 'MALE');
INSERT INTO usuari (username, password, enabled, voice) VALUES ('JoGomLoz@gmail.com','$2a$10$RmdEsvEfhI7Rcm9f/uZXPebZVCcPC7ZXZwV51efAvMAp1rIaRAfPK', true, 'MALE');
INSERT INTO usuari (username, password, enabled, voice) VALUES ('mariaprova@gmail.com','$2a$10$RmdEsvEfhI7Rcm9f/uZXPebZVCcPC7ZXZwV51efAvMAp1rIaRAfPK', true, 'FEMALE');


INSERT INTO role (name) VALUES ('ROLE_USER');
INSERT INTO role (name) VALUES ('ROLE_ADMIN');

INSERT INTO usuari_role (usuari_id, role_id) VALUES (1,2);
INSERT INTO usuari_role (usuari_id, role_id) VALUES (2,2);
INSERT INTO usuari_role (usuari_id, role_id) VALUES (3,2);
INSERT INTO usuari_role (usuari_id, role_id) VALUES (4,1);
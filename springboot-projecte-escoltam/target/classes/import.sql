/* Creacció usuaris i rols */
/*Password d'usuaris és 12345 - En aquí ja està encriptat*/
INSERT INTO usuari (username, password, enabled, voice) VALUES ('gemmarica94@gmail.com','$2a$10$RmdEsvEfhI7Rcm9f/uZXPebZVCcPC7ZXZwV51efAvMAp1rIaRAfPK', true, 'FEMALE');
INSERT INTO usuari (username, password, enabled, voice) VALUES ('jonatanchaler@gmail.com','$2a$10$RmdEsvEfhI7Rcm9f/uZXPebZVCcPC7ZXZwV51efAvMAp1rIaRAfPK', true, 'MALE');
INSERT INTO usuari (username, password, enabled, voice) VALUES ('jogomloz@gmail.com','$2a$10$RmdEsvEfhI7Rcm9f/uZXPebZVCcPC7ZXZwV51efAvMAp1rIaRAfPK', true, 'MALE');
INSERT INTO usuari (username, password, enabled, voice) VALUES ('mariaprova@gmail.com','$2a$10$RmdEsvEfhI7Rcm9f/uZXPebZVCcPC7ZXZwV51efAvMAp1rIaRAfPK', true, 'FEMALE');

INSERT INTO role (name) VALUES ('ROLE_USER');
INSERT INTO role (name) VALUES ('ROLE_ADMIN');

INSERT INTO usuari_role (usuari_id, role_id) VALUES (1,2);
INSERT INTO usuari_role (usuari_id, role_id) VALUES (2,2);
INSERT INTO usuari_role (usuari_id, role_id) VALUES (3,2);
INSERT INTO usuari_role (usuari_id, role_id) VALUES (4,1);

INSERT INTO panellpredefinit (nom, posicio) VALUES ('provaPredefinit',1);

INSERT INTO usuari_panellpredefinit (usuari_id, panellpredefinit_id) VALUES (1,1);
INSERT INTO usuari_panellpredefinit (usuari_id, panellpredefinit_id) VALUES (2,1);
INSERT INTO usuari_panellpredefinit (usuari_id, panellpredefinit_id) VALUES (3,1);
INSERT INTO usuari_panellpredefinit (usuari_id, panellpredefinit_id) VALUES (4,1);


/*CREACIO PANELLS*/
INSERT INTO panell (nom, posicio, favorit, usuari_id) VALUES ('Esports',1,false,1)
INSERT INTO panell (nom, posicio, favorit, usuari_id) VALUES ('Verbs',2,true,1)
INSERT INTO panell (nom, posicio, favorit, usuari_id) VALUES ('Esports',1,true,4)

/*CREACIO ICONES*/
INSERT INTO icona (nom, posicio, panell_id) VALUES ('Futbol',1,1)
INSERT INTO icona (nom, posicio, panell_id) VALUES ('Basquet',2,1)
INSERT INTO icona (nom, posicio, panell_id) VALUES ('anar',1,2)
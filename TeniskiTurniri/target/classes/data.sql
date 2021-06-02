INSERT INTO `user` (id, username, password, role)
              VALUES (1,'miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','ADMIN');
INSERT INTO `user` (id, username, password, role)
              VALUES (2,'tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','KORISNIK');
INSERT INTO `user` (id, username, password, role)
              VALUES (3,'petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','KORISNIK');

              
INSERT INTO formati (id, tip, broj_ucesnika) VALUES (1, 'Grand Slam', 20);
INSERT INTO formati (id, tip, broj_ucesnika) VALUES (2, 'Masters 1000', 25);
INSERT INTO formati (id, tip, broj_ucesnika) VALUES (3, 'Masters 500', 30);
INSERT INTO formati (id, tip, broj_ucesnika) VALUES (4, 'Masters 250', 35);

INSERT INTO takmicenje (id, naziv, mesto_odrzavanja, datum_pocetka, datum_zavrsetka, format_id) VALUES (1, 'Super takmicenje', 'Pariz', '19.05.2021', '31.05.2021', 2);
INSERT INTO takmicenje (id, naziv,mesto_odrzavanja, datum_pocetka, datum_zavrsetka, format_id) VALUES (2, 'Najbolje takmicenje', 'London', '20.06.2021', '31.06.2021', 3);
INSERT INTO takmicenje (id, naziv,mesto_odrzavanja, datum_pocetka, datum_zavrsetka, format_id) VALUES (3, 'Finalno takmicenje', 'Berlin', '18.04.2021', '27.04.2021', 1);
INSERT INTO takmicenje (id, naziv,mesto_odrzavanja, datum_pocetka, datum_zavrsetka, format_id) VALUES (4, 'Prvo takmicenje', 'Moskva', '19.03.2021', '31.03.2021', 4);
INSERT INTO takmicenje (id, naziv,mesto_odrzavanja, datum_pocetka, datum_zavrsetka, format_id) VALUES (5, 'Mutua Madrilenja takmicenje', 'Madrid', '20.10.2021', '31.10.2021', 3);

INSERT INTO prijava (id, drzava, e_mail, datum_prijave, takmicenje_id)  VALUES (1, 'ENG', '1234567@gmail.com', '10.01.2021', 5);
INSERT INTO prijava (id, drzava, e_mail, datum_prijave, takmicenje_id)  VALUES (2, 'SRB', 'noname@gmail.com', '20.01.2021', 3);
INSERT INTO prijava (id, drzava, e_mail, datum_prijave, takmicenje_id)  VALUES (3, 'RUS', 'jkfaslkfdas@gmail.com', '12.01.2021', 4);
INSERT INTO prijava (id, drzava, e_mail, datum_prijave, takmicenje_id)  VALUES (4, 'FRA', 'abcdefg@gmail.com', '15.01.2021', 2);
INSERT INTO prijava (id, drzava, e_mail, datum_prijave, takmicenje_id)  VALUES (5, 'USA', 'double-double@gmail.com', '11.01.2021', 1);
INSERT INTO prijava (id, drzava, e_mail, datum_prijave, takmicenje_id)  VALUES (6, 'AUS', 'oneToMany@gmail.com', '16.01.2021', 5);
insert into Appartement (ID, CAPACITY, APPARTEMENT_NAAM, STAD, IS_PARKING_BESCHIKBAAR, AFSTAND_TOT_CENTRUM, EXTRA_INFO,
                         PRIJS_PER_MAAND,
                         AANTAL_SLAAPKAMERS, OPPERVLAKTE, HUISDIEREN_TOEGELATEN)
values ((nextval('APPARTEMENT_SEQ')), 3, 'app1', 'Antwerpen', true, 50, 'info', 500, 3, 30, true);

insert into Appartement (ID, CAPACITY, APPARTEMENT_NAAM, STAD, IS_PARKING_BESCHIKBAAR, AFSTAND_TOT_CENTRUM, EXTRA_INFO,
                         PRIJS_PER_MAAND,
                         AANTAL_SLAAPKAMERS, OPPERVLAKTE, HUISDIEREN_TOEGELATEN)
values ((nextval('APPARTEMENT_SEQ')), 5, 'app2', 'Antwerpen', false, 20, 'info', 300, 3, 30, false);

insert into Appartement (ID, CAPACITY, APPARTEMENT_NAAM, STAD, IS_PARKING_BESCHIKBAAR, AFSTAND_TOT_CENTRUM, EXTRA_INFO,
                         PRIJS_PER_MAAND,
                         AANTAL_SLAAPKAMERS, OPPERVLAKTE, HUISDIEREN_TOEGELATEN)
values ((nextval('APPARTEMENT_SEQ')), 4, 'app3', 'Antwerpen', true, 30, 'info', 500, 3, 30, false);

insert into Appartement (ID, CAPACITY, APPARTEMENT_NAAM, STAD, IS_PARKING_BESCHIKBAAR, AFSTAND_TOT_CENTRUM, EXTRA_INFO,
                         PRIJS_PER_MAAND,
                         AANTAL_SLAAPKAMERS, OPPERVLAKTE, HUISDIEREN_TOEGELATEN)
values ((nextval('APPARTEMENT_SEQ')), 7, 'app4', 'Mechelen', true, 59, 'info', 500, 4, 30, true);

insert into Appartement (ID, CAPACITY, APPARTEMENT_NAAM, STAD, IS_PARKING_BESCHIKBAAR, AFSTAND_TOT_CENTRUM, EXTRA_INFO,
                         PRIJS_PER_MAAND,
                         AANTAL_SLAAPKAMERS, OPPERVLAKTE, HUISDIEREN_TOEGELATEN)
values ((nextval('APPARTEMENT_SEQ')), 3, 'app5', 'gent', true, 59, 'info', 500, 4, 30, true);

insert into Appartement (ID, CAPACITY, APPARTEMENT_NAAM, STAD, IS_PARKING_BESCHIKBAAR, AFSTAND_TOT_CENTRUM, EXTRA_INFO,
                         PRIJS_PER_MAAND,
                         AANTAL_SLAAPKAMERS, OPPERVLAKTE, HUISDIEREN_TOEGELATEN)
values ((nextval('APPARTEMENT_SEQ')), 2, 'app6', 'Mechelen', false, 10, 'info', 500, 2, 30, true);

insert into Appartement (ID, CAPACITY, APPARTEMENT_NAAM, STAD, IS_PARKING_BESCHIKBAAR, AFSTAND_TOT_CENTRUM, EXTRA_INFO,
                         PRIJS_PER_MAAND,
                         AANTAL_SLAAPKAMERS, OPPERVLAKTE, HUISDIEREN_TOEGELATEN)
values ((nextval('APPARTEMENT_SEQ')), 7, 'app7', 'Mechelen', true, 59, 'info', 500, 4, 30, false);

insert into Appartement (ID, CAPACITY, APPARTEMENT_NAAM, STAD, IS_PARKING_BESCHIKBAAR, AFSTAND_TOT_CENTRUM, EXTRA_INFO,
                         PRIJS_PER_MAAND,
                         AANTAL_SLAAPKAMERS, OPPERVLAKTE, HUISDIEREN_TOEGELATEN)
values ((nextval('APPARTEMENT_SEQ')), 7, 'app8', 'Brussel', true, 59, 'info', 500, 4, 30, true);

insert into Appartement (ID, CAPACITY, APPARTEMENT_NAAM, STAD, IS_PARKING_BESCHIKBAAR, AFSTAND_TOT_CENTRUM, EXTRA_INFO,
                         PRIJS_PER_MAAND,
                         AANTAL_SLAAPKAMERS, OPPERVLAKTE, HUISDIEREN_TOEGELATEN)
values ((nextval('APPARTEMENT_SEQ')), 7, 'app9', 'Brussel', true, 59, 'info', 500, 4, 30, true);

insert into Appartement (ID, CAPACITY, APPARTEMENT_NAAM, STAD, IS_PARKING_BESCHIKBAAR, AFSTAND_TOT_CENTRUM, EXTRA_INFO,
                         PRIJS_PER_MAAND,
                         AANTAL_SLAAPKAMERS, OPPERVLAKTE, HUISDIEREN_TOEGELATEN)
values ((nextval('APPARTEMENT_SEQ')), 7, 'app10', 'Brussel', false, 15, 'info', 500, 4, 30, false );

insert into Boeking (ID, START_DATUM, EIND_DATUM, NUM_DAYS, NUM_GUESTS, APPARTEMENT_ID)
values ((nextval('BOEKING_SEQ')), '2021-04-3', '2021-04-25', 22, 3, 1);

insert into Boeking (ID, START_DATUM, EIND_DATUM, NUM_DAYS, NUM_GUESTS, APPARTEMENT_ID)
values ((nextval('BOEKING_SEQ')), '2021-05-3', '2021-05-13', 10, 4, 2);

insert into Boeking (ID, START_DATUM, EIND_DATUM, NUM_DAYS, NUM_GUESTS, APPARTEMENT_ID)
values ((nextval('BOEKING_SEQ')), '2021-09-3', '2021-09-20', 17, 4, 3);

insert into Boeking (ID, START_DATUM, EIND_DATUM, NUM_DAYS, NUM_GUESTS, APPARTEMENT_ID)
values ((nextval('BOEKING_SEQ')), '2021-09-3', '2021-09-20', 17, 4, 4);

insert into Boeking (ID, START_DATUM, EIND_DATUM, NUM_DAYS, NUM_GUESTS, APPARTEMENT_ID)
values ((nextval('BOEKING_SEQ')), '2021-06-3', '2021-06-23', 20, 3, 5);

insert into Boeking (ID, START_DATUM, EIND_DATUM, NUM_DAYS, NUM_GUESTS, APPARTEMENT_ID)
values ((nextval('BOEKING_SEQ')), '2021-07-5', '2021-07-15', 10, 2, 6);

insert into Boeking (ID, START_DATUM, EIND_DATUM, NUM_DAYS, NUM_GUESTS, APPARTEMENT_ID)
values ((nextval('BOEKING_SEQ')), '2021-08-14', '2021-08-27', 13, 4, 7);

insert into Boeking (ID, START_DATUM, EIND_DATUM, NUM_DAYS, NUM_GUESTS, APPARTEMENT_ID)
values ((nextval('BOEKING_SEQ')), '2021-09-3', '2021-09-20', 17, 4, 8);

insert into Boeking (ID, START_DATUM, EIND_DATUM, NUM_DAYS, NUM_GUESTS, APPARTEMENT_ID)
values ((nextval('BOEKING_SEQ')), '2021-09-3', '2021-09-20', 17, 2, 9);

insert into Boeking (ID, START_DATUM, EIND_DATUM, NUM_DAYS, NUM_GUESTS, APPARTEMENT_ID)
values ((nextval('BOEKING_SEQ')), '2021-10-3', '2021-10-17', 14, 4, 10);

insert into USER (ID, USERNAME, PASSWORD, EMAIL, ROLE)
values ((nextval('USER_SEQ')), 'admin', '$2a$10$9MIX8kYPkuB7uE/H5nHF8.KG6.YdjBA/voOnjSZnZDxLXL/2BIerS',
        'simen@hotmail.be', 'ADMIN');

insert into USER (ID, USERNAME, PASSWORD, EMAIL, ROLE)
values ((nextval('USER_SEQ')), 'simen', '$2a$10$pQnldtWyD5CpMBjWJycMW.jmEOY2zKqjSkCo5V2vKqvW44ORrdpAa',
        'simen@hotmail.be', 'USER');

insert into USER (ID, USERNAME, PASSWORD, EMAIL, ROLE)
values ((nextval('USER_SEQ')), 'stijn', '$2a$10$9MIX8kYPkuB7uE/H5nHF8.KG6.YdjBA/voOnjSZnZDxLXL/2BIerS',
        'stijn@hotmail.be', 'USER');

insert into HUURDER (ID, NAAM, GESLACHT, USER_ID, TELEFOON_NUMMER)
values ((nextval('HUURDER_SEQ')), 'stino', 'man', 3, '04 78 32 85 41');

insert into USER (
    ID, USERNAME, PASSWORD,EMAIL, ROLE)
values (
    (nextval('USER_SEQ')), 'bob', '$2a$10$pQnldtWyD5CpMBjWJycMW.jmEOY2zKqjSkCo5V2vKqvW44ORrdpAa', 'bob@hotmail' ||
    '.be', 'USER');

insert into HUURDER (ID, NAAM, GESLACHT, USER_ID, TELEFOON_NUMMER)
values ((nextval('HUURDER_SEQ')), 'bobi', 'man', 4, '04 85 69 24 35');

insert into USER (ID, USERNAME, PASSWORD, EMAIL, ROLE)
values ((nextval('USER_SEQ')), 'bart', '$2a$10$9MIX8kYPkuB7uE/H5nHF8.KG6.YdjBA/voOnjSZnZDxLXL/2BIerS',
        'bart@hotmail.be', 'USER');

insert into HUURDER (ID, NAAM, GESLACHT, USER_ID, TELEFOON_NUMMER)
values ((nextval('HUURDER_SEQ')), 'bartos', 'man', 5, '04 78 99 85 41');

insert into USER (ID, USERNAME, PASSWORD, EMAIL, ROLE)
values ((nextval('USER_SEQ')), 'loes', '$2a$10$9MIX8kYPkuB7uE/H5nHF8.KG6.YdjBA/voOnjSZnZDxLXL/2BIerS',
        'bart@hotmail.be', 'USER');

insert into HUURDER (ID, NAAM, GESLACHT, USER_ID, TELEFOON_NUMMER)
values ((nextval('HUURDER_SEQ')), 'loesje', 'vrouw', 6, '04 78 99 85 41');

insert into USER (ID, USERNAME, PASSWORD, EMAIL, ROLE)
values ((nextval('USER_SEQ')), 'jos', '$2a$10$9MIX8kYPkuB7uE/H5nHF8.KG6.YdjBA/voOnjSZnZDxLXL/2BIerS',
        'bart@hotmail.be', 'USER');

insert into HUURDER (ID, NAAM, GESLACHT, USER_ID, TELEFOON_NUMMER)
values ((nextval('HUURDER_SEQ')), 'jos', 'man', 7, '04 46 99 85 41');


INSERT INTO HUURDER_BOEKINGEN(HUURDER_ID, BOEKINGEN_ID) values (1,1);
INSERT INTO HUURDER_BOEKINGEN(HUURDER_ID, BOEKINGEN_ID)values (2,2);
INSERT INTO HUURDER_BOEKINGEN(HUURDER_ID, BOEKINGEN_ID)values (2,3);
INSERT INTO HUURDER_BOEKINGEN(HUURDER_ID, BOEKINGEN_ID)values (3,4);
INSERT INTO HUURDER_BOEKINGEN(HUURDER_ID, BOEKINGEN_ID)values (3,5);
INSERT INTO HUURDER_BOEKINGEN(HUURDER_ID, BOEKINGEN_ID)values (4,6);
INSERT INTO HUURDER_BOEKINGEN(HUURDER_ID, BOEKINGEN_ID)values (4,7);
INSERT INTO HUURDER_BOEKINGEN(HUURDER_ID, BOEKINGEN_ID)values (4,8);
INSERT INTO HUURDER_BOEKINGEN(HUURDER_ID, BOEKINGEN_ID)values (5,9);
INSERT INTO HUURDER_BOEKINGEN(HUURDER_ID, BOEKINGEN_ID)values (5,10);




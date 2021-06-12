insert into Appartement (
    ID, CAPACITY, APPARTEMENT_NAAM, STAD, IS_PARKING_BESCHIKBAAR, AFSTAND_TOT_CENTRUM, EXTRA_INFO, PRIJS_PER_MAAND,
    AANTAL_SLAAPKAMERS, OPPERVLAKTE, HUISDIEREN_TOEGELATEN)
values (
           (nextval('APPARTEMENT_SEQ')), 2, 'testnaam', 'Antwerpen', true, 50, 'info', 500, 3, 30, true);

insert into Appartement (
    ID, CAPACITY, APPARTEMENT_NAAM, STAD, IS_PARKING_BESCHIKBAAR, AFSTAND_TOT_CENTRUM, EXTRA_INFO, PRIJS_PER_MAAND,
    AANTAL_SLAAPKAMERS, OPPERVLAKTE, HUISDIEREN_TOEGELATEN)
values (
           (nextval('APPARTEMENT_SEQ')), 5, 'testnaam1', 'Antwerpen', false, 50, 'info', 300, 3, 30, false);

insert into Appartement (
    ID, CAPACITY, APPARTEMENT_NAAM, STAD, IS_PARKING_BESCHIKBAAR, AFSTAND_TOT_CENTRUM, EXTRA_INFO, PRIJS_PER_MAAND,
    AANTAL_SLAAPKAMERS, OPPERVLAKTE, HUISDIEREN_TOEGELATEN)
values (
           (nextval('APPARTEMENT_SEQ')), 2, 'testnaam2', 'Antwerpen', true, 30, 'info', 500, 2, 30, false);

insert into Appartement (
    ID, CAPACITY, APPARTEMENT_NAAM, STAD, IS_PARKING_BESCHIKBAAR, AFSTAND_TOT_CENTRUM, EXTRA_INFO, PRIJS_PER_MAAND,
    AANTAL_SLAAPKAMERS, OPPERVLAKTE, HUISDIEREN_TOEGELATEN)
values (
           (nextval('APPARTEMENT_SEQ')), 5, 'testnaam3', 'Mechelen', true, 59, 'info', 500, 4, 30, true);

insert into Boeking (
    ID, START_DATUM, EIND_DATUM, NUM_DAYS, NUM_GUESTS, APPARTEMENT_ID)
values (
           (nextval('BOEKING_SEQ')), '2021-04-3', '2021-04-25', 22, 4, 1);

insert into Boeking (
    ID, START_DATUM, EIND_DATUM, NUM_DAYS, NUM_GUESTS, APPARTEMENT_ID)
values (
           (nextval('BOEKING_SEQ')), '2021-05-3', '2021-08-25', 22, 4, 2);

insert into Boeking (
    ID, START_DATUM, EIND_DATUM, NUM_DAYS, NUM_GUESTS, APPARTEMENT_ID)
values (
           (nextval('BOEKING_SEQ')), '2021-09-3', '2021-10-25', 22, 4, 3);
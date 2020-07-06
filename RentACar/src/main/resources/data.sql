insert into user_model (username, password, uloga) values ('maki', 'maki', 0);
insert into user_model (username, password, uloga) values ('pera', 'pera', 1);

insert into end_user (id_user, name, surname) values (1, 'Marko', 'Markovic');

insert into renter (id_user) values (2);

insert into manufacturer (name) values ('Toyota');
insert into model (manufacturer_id, name) values (1, 'Yaris');
insert into vehicle_class (name) values ('Karavan');
insert into gas_type (name) values ('Benzin');

insert into vehicle (owner_id, gear_box, mileage, proposed_mileage, cdw, child_seats_no, model_id, gas_type_id, 
vehicle_class_id) values (1, '5', 300, 500, true, 2, 1, 1, 1);

insert into ad (vehicle_id, place, date, valid_tru, valid_from, date_from, date_to) 
values (1, 'Novi Sad', '2020-06-20', '2020-06-21', '2020-06-29', '2020-06-20', '2020-07-14');

insert into company (name, address, poslovni_maticni_broj) values ('Kompanija 1', 'Adresa 1', 'asdf123');


insert into review (ad_id, end_user_id, stars, content, accepted, deleted) values (1, 1, 3, 'OK', false, false);
insert into review (ad_id, end_user_id, stars, content, accepted, deleted) values (1, 1, 5, 'Odlicno', true, false);
insert into review (ad_id, end_user_id, stars, content, accepted, deleted) values (1, 1, 4, 'Dobar', false, false);
insert into review (ad_id, end_user_id, stars, content, accepted, deleted) values (1, 1, 2, 'Onako', false, false);
insert into review (ad_id, end_user_id, stars, content, accepted, deleted) values (1, 1, 1, 'Nista nije valjalo', false, false);









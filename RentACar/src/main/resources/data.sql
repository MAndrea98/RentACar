insert into user_model (username, password, uloga) values ('maki', 'maki', 0);
insert into user_model (username, password, uloga) values ('pera', 'pera', 1);
insert into user_model (username, password, uloga) values ('renter', 'renter', 1);

insert into end_user (id_user, name, surname, additional_price) values (1, 'Marko', 'Markovic', 0);

insert into renter (id_user) values (2);
insert into renter (id_user) values (3);

insert into company (name, address, poslovni_maticni_broj) values ('Kompanija 1', 'Adresa 1', '123');

insert into manufacturer (name) values ('Toyota');
insert into model (manufacturer_id, name) values (1, 'Yaris');

insert into manufacturer (name) values ('Hyundai');
insert into model (manufacturer_id, name) values (2, 'Getz');

insert into manufacturer (name) values ('Volkswagen');
insert into model (manufacturer_id, name) values (3, 'Golf 5');

insert into gas_type (name) values ('Benzin');
insert into gas_type (name) values ('Dizel');

insert into vehicle_class (name) values ('Karavan');
insert into vehicle_class (name) values ('Classic');

insert into vehicle (owner_id, gear_box, mileage, proposed_mileage, cdw, child_seats_no, model_id, gas_type_id, 
vehicle_class_id) values (1, '5', 300, 500, true, 2, 1, 1, 1);
insert into vehicle (owner_id, gear_box, mileage, proposed_mileage, cdw, child_seats_no, model_id, gas_type_id, 
vehicle_class_id) values (1, '5', 400, 600, true, 2, 1, 1, 1);
insert into vehicle (owner_id, gear_box, mileage, proposed_mileage, cdw, child_seats_no, model_id, gas_type_id, 
vehicle_class_id) values (2, '5', 9000, 100000, false, 0, 2, 1, 2);
insert into vehicle (owner_id, gear_box, mileage, proposed_mileage, cdw, child_seats_no, model_id, gas_type_id, 
vehicle_class_id) values (1, '5', 400, 600, true, 2, 3, 2, 2);

insert into ad (vehicle_id, place, date, valid_tru, valid_from, date_from, date_to, mileage_limit, number_of_reviews) 
values (1, 'Novi Sad', '2020-06-20', '2020-06-21', '2020-06-29', '2020-06-20', '2020-07-14', 0, 5);

insert into ad (vehicle_id, place, date, valid_tru, valid_from, date_from, date_to, mileage_limit, number_of_reviews) 
values (2, 'Novi Sad', '2020-06-20', '2020-06-21', '2020-06-30', '2020-06-20', '2020-07-16', 100, 0);

insert into ad (vehicle_id, place, date, valid_tru, valid_from, date_from, date_to, mileage_limit, number_of_reviews) 
values (3, 'Novi Sad', '2020-06-20', '2020-06-21', '2020-06-30', '2020-06-20', '2020-07-16', 200, 0);

insert into ad (vehicle_id, place, date, valid_tru, valid_from, date_from, date_to, mileage_limit, number_of_reviews) 
values (4, 'Novi Sad', '2020-06-20', '2020-06-21', '2020-06-30', '2020-06-20', '2020-07-16', 0, 0);

insert into message(sender_id, reciever_id, subject, content, date, deleted) values (1, 2, 'Proba1','Proba1','2020-6-20',false);

insert into review (ad_id, end_user_id, stars, content, accepted, deleted) values (1, 1, 3, 'OK', false, false);
insert into review (ad_id, end_user_id, stars, content, accepted, deleted) values (1, 1, 5, 'Odlicno', true, false);
insert into review (ad_id, end_user_id, stars, content, accepted, deleted) values (1, 1, 4, 'Dobar', false, false);
insert into review (ad_id, end_user_id, stars, content, accepted, deleted) values (1, 1, 2, 'Onako', false, false);
insert into review (ad_id, end_user_id, stars, content, accepted, deleted) values (1, 1, 1, 'Nista nije valjalo', false, false);

insert into price_list (date_from, date_to, price_per_mile, cdw_price) values ('2020-06-30', '2020-07-01', 50, 20);
insert into price_list (date_from, date_to, price_per_mile, cdw_price) values ('2020-06-30', '2020-07-01', 30, 15);
insert into price_list (date_from, date_to, price_per_mile, cdw_price) values ('2020-06-30', '2020-07-01', 15, 82);

insert into prices_values (price_list_id, name, price) values (1, 'Kilometri', 200);
insert into prices_values (price_list_id, name, price) values (1, 'Benzin', 150);
insert into prices_values (price_list_id, name, price) values (2, 'Po sedistu', 300);

insert into price_list_vehicle (price_list_id, vehicle_id) values (1, 1);
insert into price_list_vehicle (price_list_id, vehicle_id) values (1, 2);

insert into cart (end_user_id) values (1);

insert into ads_carts (ad_id, cart_id) values (2, 1);
insert into ads_carts (ad_id, cart_id) values (3, 1);
insert into ads_carts (ad_id, cart_id) values (4, 1);








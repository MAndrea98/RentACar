insert into price_list (price_per_mile, cdw_price) values (1.0, 2.0); 
insert into price_list (price_per_mile, cdw_price) values (3.0, 5.0); 

insert into user_model (username, password, uloga) values ('maki', 'maki', 0);
insert into user_model (username, password, uloga) values ('pera', 'pera', 1);
insert into user_model (username, password, uloga) values ('renter', 'renter', 1);

insert into end_user (id_user, name, surname) values (1, 'Marko', 'Markovic');

insert into renter (id_user, price_list_id) values (2, 1);
insert into renter (id_user, price_list_id) values (3, 2);

insert into manufacturer (name) values ('manufacturer');

insert into model (name, manufacturer_id) values ('Ford T', 1);
insert into model (name, manufacturer_id) values ('Ford Fiesta', 1);
insert into model (name, manufacturer_id) values ('Ford Ka', 1);

insert into gas_type (name) values ('gas_type');

insert into vehicle_class (name) values ('Vehicle class');

insert into vehicle (model_id, gas_type_id, gear_box, vehicle_class_id, mileage, proposed_mileage, owner_id, cdw, child_seats_no) values  (1, 1, '6', 1, 1, 100000, 1, true, 2);
insert into vehicle (model_id, gas_type_id, gear_box, vehicle_class_id, mileage, proposed_mileage, owner_id, cdw, child_seats_no) values  (2, 1, '5', 1, 1, 100000, 1, false, 2);
insert into vehicle (model_id, gas_type_id, gear_box, vehicle_class_id, mileage, proposed_mileage, owner_id, cdw, child_seats_no) values  (3, 1, '6', 1, 1, 100000, 1, false, 3);
insert into vehicle (model_id, gas_type_id, gear_box, vehicle_class_id, mileage, proposed_mileage, owner_id, cdw, child_seats_no) values  (1, 1, '4', 1, 1, 100000, 2, true, 4);

insert into cart (end_user_id) values (1);
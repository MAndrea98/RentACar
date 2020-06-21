insert into user_model (username, password, uloga) values ('pera', 'pera', 0);
insert into user_model (username, password, uloga) values ('renter', 'renter', 1);
insert into user_model (username, password, uloga) values ('admin', 'admin', 2);

insert into end_user (id_user, name, surname) values (1, 'Marko', 'Markovic');

insert into renter (id_user) values (2);
insert into renter (id_user) values (3);

insert into ad (renter_id, date, valid_from, valid_tru, mileage) values (1, '2020-06-16', '2020-06-01', '2020-06-30', 16);

insert into request (renter_id, end_user_id, status) values (2, 1, 'RESERVED'); 
insert into request (renter_id, end_user_id, status) values (2, 1, 'ENDED'); 
insert into request (renter_id, end_user_id, status) values (1, 1, 'ENDED'); 

insert into review (end_user_id, renter_id, stars, content, accepted, deleted, ad_id) values (1, 2, 5, 'Super', false, false, 1);
insert into review (end_user_id, renter_id, stars, content, accepted, deleted, ad_id) values (1, 2, 3, 'OK', false, false, 1);
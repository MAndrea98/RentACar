insert into user_model (username, password, uloga) values ('maki', 'maki', 0);
insert into user_model (username, password, uloga) values ('pera', 'pera', 1);
insert into user_model (username, password, uloga) values ('renter', 'renter', 1);

insert into end_user (id_user) values (1);

insert into renter (id_user) values (2);
insert into renter (id_user) values (3);

insert into vehicle (owner_id) values (1);
insert into vehicle (owner_id) values (1);
insert into vehicle (owner_id) values (2);
insert into vehicle (owner_id) values (1);

insert into ad (vehicle_id, place, date, valid_tru, valid_from, date_from, date_to) 
values (1, 'Novi Sad', '2020-06-20', '2020-06-21', '2020-06-29', '2020-06-20', '2020-07-14');

insert into ad (vehicle_id, place, date, valid_tru, valid_from, date_from, date_to) 
values (2, 'Novi Sad', '2020-06-20', '2020-06-21', '2020-06-30', '2020-06-20', '2020-07-16');

insert into ad (vehicle_id, place, date, valid_tru, valid_from, date_from, date_to) 
values (3, 'Novi Sad', '2020-06-20', '2020-06-21', '2020-06-30', '2020-06-20', '2020-07-16');

insert into ad (vehicle_id, place, date, valid_tru, valid_from, date_from, date_to) 
values (4, 'Novi Sad', '2020-06-20', '2020-06-21', '2020-06-30', '2020-06-20', '2020-07-16');

insert into message(sender_id, reciever_id, subject, content, date, deleted) values (1, 2, 'Proba1','Proba1','2020-6-20',false);


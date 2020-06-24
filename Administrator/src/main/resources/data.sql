insert into manufacturer (name) values ('Toyota');

insert into model (name, manufacturer_id) values ('Yaris', 1);

insert into user_model (username, password, uloga) values ('maki', 'maki', 0);
insert into user_model (username, password, uloga) values ('pera', 'pera', 1);
insert into user_model (username, password, uloga) values ('renter', 'renter', 1);
insert into user_model (username, password, uloga) values ('admin', 'admin', 3);

insert into end_user (id_user, name, surname) values (1, 'Marko', 'Markovic');

insert into renter (id_user) values (2);
insert into renter (id_user) values (3);

insert into admin (user_id) values (4);

insert into review (end_user_id, renter_id, stars, content, accepted, deleted) values (1, 2, 5, 'Super', false, false);
insert into review (end_user_id, renter_id, stars, content, accepted, deleted) values (1, 2, 3, 'OK', false, false);

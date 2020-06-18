insert into manufacturer(name) values ('toyota');
--insert into model(name, manufacturer)

insert into user_model (username, password, uloga) values ('maki', 'maki', 0);
insert into user_model (username, password, uloga) values ('pera', 'pera', 1);
insert into user_model (username, password, uloga) values ('renter', 'renter', 1);

insert into end_user (id_user, name, surname) values (1, 'Marko', 'Markovic');

insert into renter (id_user) values (2);
insert into renter (id_user) values (3);

insert into review (end_user_id, renter_id, stars, content, accepted, deleted) values (1, 2, 5, 'Super', false, false);
insert into review (end_user_id, renter_id, stars, content, accepted, deleted) values (1, 2, 3, 'OK', false, false);
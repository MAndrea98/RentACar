insert into user_model (username, password, uloga) values ('maki', 'maki', 0);
insert into user_model (username, password, uloga) values ('pera', 'pera', 1);
insert into user_model (username, password, uloga) values ('renter', 'renter', 1);

insert into end_user (id_user, name, surname) values (1, 'Marko', 'Markovic');

insert into renter (id_user) values (2);
insert into renter (id_user) values (3);

insert into ad (vehicle_id, number_of_reviews) values (1, 5);
insert into ad (vehicle_id, number_of_reviews) values (2, 0);
insert into ad (vehicle_id, number_of_reviews) values (3, 0);
insert into ad (vehicle_id, number_of_reviews) values (4, 0);

insert into review (ad_id, end_user_id, stars, content, accepted, deleted) values (1, 1, 3, 'OK', false, false);
insert into review (ad_id, end_user_id, stars, content, accepted, deleted) values (1, 1, 5, 'Odlicno', true, false);
insert into review (ad_id, end_user_id, stars, content, accepted, deleted) values (1, 1, 4, 'Dobar', false, false);
insert into review (ad_id, end_user_id, stars, content, accepted, deleted) values (1, 1, 2, 'Onako', false, false);
insert into review (ad_id, end_user_id, stars, content, accepted, deleted) values (1, 1, 1, 'Nista nije valjalo', false, false);
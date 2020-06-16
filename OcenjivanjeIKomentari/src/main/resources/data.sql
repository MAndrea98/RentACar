insert into user_model (username, password, uloga) values ('pera', 'pera', 0);
insert into user_model (username, password, uloga) values ('renter', 'renter', 1);
insert into user_model (username, password, uloga) values ('admin', 'admin', 2);

insert into renter (id_user) values (1);

insert into ad (renter_id, date, valid_from, valid_tru, mileage) values (1, '2020-06-16', '2020-06-01', '2020-06-30', 16);
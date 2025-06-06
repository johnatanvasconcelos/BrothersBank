alter table accounts
add column status varchar(10);

update accounts
set status = 'ativa';

alter table accounts
alter column status set not null;

alter table accounts
alter column status set default 'ativa';
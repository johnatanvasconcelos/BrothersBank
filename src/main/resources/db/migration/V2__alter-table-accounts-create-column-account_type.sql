alter table accounts
add column account_type varchar(20);

update accounts a
set account_type = 'SAVINGS'
from savings_accounts sa
where a.id = sa.id;

update accounts a
set account_type = 'CHECKING'
from checking_accounts ca
where a.id = ca.id;

alter table accounts
alter column account_type set not null;
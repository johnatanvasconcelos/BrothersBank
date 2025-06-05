create table accounts (
    id bigserial primary key,
    account_number varchar(20) not null unique,
    balance numeric(15,2) not null default 0.00,
    owner_name varchar(100) not null,
    owner_id bigint not null
);

create table checking_accounts(
    id bigint primary key,
    overdraft_limit numeric (15,2) not null default 0.0,
    constraint fk_checking_account foreign key (id) references accounts(id) on delete cascade
);

create table savings_accounts(
    id bigint primary key,
    interest_rate numeric (5,4) not null default 0.0,
    constraint fk_savings_account foreign key (id) references accounts(id) on delete cascade
);
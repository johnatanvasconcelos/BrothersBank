create table bank_account(
    id bigserial primary key,
    account_number varchar(20) unique not null,
    agency_number varchar(10) not null,
    balance numeric(19,2) not null,
    account_type varchar(20) not null,
    owner_name varchar(100) not null,
    cpf varchar(14) unique not null,
    daily_withdrawal_limit numeric(19,2) default 1000.00,
    withdrawals_today numeric(19,2) default 0.00,
    created_at timestamp not null default current_timestamp,
    last_access timestamp
);

create table checking_account(
    id bigint primary key references bank_account(id),
    maintenance_fee numeric(19,2) not null default 10.00
);

create table savings_account(
    id bigint primary key references bank_account(id),
    monthly_interest_rate numeric(5,4) default 0.0100
);

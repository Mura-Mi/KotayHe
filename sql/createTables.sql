DROP TABLE IF EXISTS kotayHe_user	;
DROP TABLE IF EXISTS cash_flow;
DROP TABLE IF EXISTS pay_recieve_type;
-- to initialize, drop the tables.


create table kotayhe_user(
    id INTEGER,
    name VARCHAR(50),
    pass INTEGER,
    PRIMARY KEY (id)
);

create table cash_flow (
    id INTEGER,
    amount DECIMAL,
    pay_recieve INTEGER,
    PRIMARY KEY (id)
);

CREATE TABLE pay_recieve_type (
    id INTEGER,
    description CHAR(4),
    PRIMARY KEY (id)
);

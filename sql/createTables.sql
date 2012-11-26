DROP TABLE kotayHe_user;
DROP TABLE cash_flow;
DROP TABLE cash_flow_category;
DROP TABLE journal;
-- to initialize, drop the tables.


CREATE TABLE kotayhe_user(
    id INTEGER,
    name VARCHAR(50),
    pass INTEGER,
    PRIMARY KEY (id)
);

CREATE TABLE cash_flow (
    id INTEGER,
    amount DECIMAL,
    in_out CHAR(1),
    date DATE,
    categoryId INTEGER,
    description VARCHAR(200),
    journalId INTEGER,
    PRIMARY KEY (id)
);

CREATE TABLE cash_flow_category (
    id INTEGER,
    description VARCHAR(50),
    parent INTEGER,
    PRIMARY KEY (id)
);

CREATE TABLE journal (
    id INTEGER,
    name VARCHAR(200),
    user_id INTEGER,
    PRIMARY KEY (id)
);
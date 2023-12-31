DROP TABLE IF EXISTS  cards;

CREATE TABLE cards (
    card_id int NOT NULL AUTO_INCREMENT,
    card_number varchar(100) NOT NULL,
    customer_id int NOT NULL,
    card_type varchar(100) NOT NULL,
    total_limit int not null,
    amount_used int NOT NULL,
    avaliable_amount int NOT NULL,
    created_date DATE DEFAULT NULL,
    PRIMARY KEY(card_id)
);

INSERT INTO cards (card_number, customer_id, card_type, total_limit, amount_used, avaliable_amount, created_date)
VALUES ('4565XXXX4656', 1, 'Credit', 1000, 500, 9500, CURDATE());

INSERT INTO cards (card_number, customer_id, card_type, total_limit, amount_used, avaliable_amount, created_date)
VALUES ('3455XXXX8673', 1, 'Credit', 7500, 600, 6900, CURDATE());

INSERT INTO cards (card_number, customer_id, card_type, total_limit, amount_used, avaliable_amount, created_date)
VALUES ('2359XXXX9346', 1, 'Credit', 20000, 4000, 16000, CURDATE());
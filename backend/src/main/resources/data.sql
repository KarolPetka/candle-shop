INSERT INTO user (email, password, name, address, phone, role)
VALUES ('customer@mail.com',
        '$2a$12$RLs1fYOdiUP0VzjvrjnCLehuz/CP9bVuobqVkKjbYqgzPV1cJtY32', -- BCrypt hash for "12345"
        'Customer User',
        '123 Main St, Springfield',
        '555-1234',
        'CUSTOMER');

INSERT INTO user (email, password, name, address, phone, role)
VALUES ('admin@mail.com',
        '$2a$12$RLs1fYOdiUP0VzjvrjnCLehuz/CP9bVuobqVkKjbYqgzPV1cJtY32', -- BCrypt hash for "12345"
        'Admin User',
        '123 Main St, Springfield',
        '555-1234',
        'ADMIN');

-- INSERT INTO category (id, name, description)
-- VALUES (1, 'Candles', 'Various scented candles');
-- INSERT INTO category (id, name, description)
-- VALUES (2, 'Accessories', 'Accessories for candle care');
--
-- INSERT INTO product (id, name, description, weight, burn_time, price, stock, category_id)
-- VALUES (1, 'Lavender Candle', 'A relaxing lavender-scented candle.', 0.5, 40, 15.99, 100, 1);



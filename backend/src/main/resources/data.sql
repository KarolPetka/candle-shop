DELETE FROM user;

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


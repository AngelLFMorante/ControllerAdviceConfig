CREATE TABLE IF NOT EXISTS items (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL
);

INSERT INTO items (name, description) VALUES ('Laptop', 'Laptop Dell XPS 15');
INSERT INTO items (name, description) VALUES ('Smartphone', 'iPhone 14 Pro');
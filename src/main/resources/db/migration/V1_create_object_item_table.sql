CREATE TABLE tb_objects (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,       -- ou SERIAL para PostgreSQL
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL,
    image VARCHAR(255),
    category_id BIGINT,                         -- Chave estrangeira (assumindo relacionamento)
    validity TIMESTAMP,

    CONSTRAINT fk_category
        FOREIGN KEY (category_id)
        REFERENCES categories(id)
);
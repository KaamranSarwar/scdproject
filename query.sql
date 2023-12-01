use pos;
CREATE TABLE Category (
                          id INT PRIMARY KEY,
                          cname VARCHAR(100) NOT NULL,
                          des varchar(200),
                          parentId INT,
                          FOREIGN KEY (parentId) REFERENCES Category(id) on update cascade on delete cascade
);
CREATE TABLE pos.product (
                             id INT NOT NULL,
                             pname VARCHAR(45) NULL,
                             price DOUBLE NULL,
                             QinP INT NULL,
                             tP INT NULL,
                             totalQuantity INT NULL,
                             expDate DATE NULL,
                             des VARCHAR(1000) NULL,
                             cId INT NULL,
                             PRIMARY KEY (id),
                             INDEX category_idx (cId ASC) VISIBLE,
                             CONSTRAINT category
                                 FOREIGN KEY (cId)
                                     REFERENCES pos.category (id)
                                     ON DELETE CASCADE
                                     ON UPDATE CASCADE
);


-- Inserting parent categories
INSERT INTO Category (id, cname, des, parentId) VALUES

                                                    (2, 'Medicines', 'Medicines category', NULL),
                                                    (3, 'First Aid', 'First aid supplies', NULL),
-- Add more categories as needed
                                                    (4, 'Pain Relief', 'Medications for pain relief', 2),
                                                    (5, 'Skin Care', 'Products for skincare', 2),
-- Add more categories as needed
                                                    (6, 'Bandages', 'Bandages and wound care', 3),
-- Add more categories as needed
                                                    (7, 'Cold & Flu', 'Medications for cold and flu', 2),
-- Add more categories as needed
                                                    (8, 'Personal Hygiene', 'Products for personal hygiene', NULL),
-- Add more categories as needed
                                                    (9, 'Dental Care', 'Products for dental care', 8),
                                                    (10, 'Eye Care', 'Products for eye care', 8);
-- Add more categories as needed


-- Inserting pharmacy-related products
INSERT INTO Product (id, pname, price, QinP, tP, totalQuantity, expDate, des, cId) VALUES
-- Medicines
(1, 'Aspirin', 5.99, 1, 100, 500, '2024-10-31', 'Pain reliever', 4),
(2, 'Ibuprofen', 6.49, 1, 150, 400, '2024-09-30', 'Pain reliever and fever reducer', 4),
-- Add more products as needed
-- First Aid
(3, 'Adhesive Bandages', 3.99, 1, 200, 800, '2025-12-31', 'Assorted sizes', 6),
-- Add more products as needed
-- Cold & Flu
(4, 'Cold Syrup', 8.99, 1, 100, 300, '2023-11-30', 'Relief from cold symptoms', 7),
-- Add more products as needed
-- Skin Care
(5, 'Moisturizing Lotion', 7.49, 1, 120, 500, '2024-08-31', 'For dry skin', 5),
-- Add more products as needed
-- Dental Care
(6, 'Toothpaste', 4.29, 1, 150, 600, '2024-06-30', 'Cavity protection', 9),
-- Add more products as needed
-- Eye Care
(7, 'Eye Drops', 9.99, 1, 80, 200, '2024-12-31', 'For dry and irritated eyes', 10),
-- Add more products as needed


-- Medicines
(8, 'Paracetamol', 4.99, 1, 200, 600, '2024-11-30', 'For pain and fever relief', 4),
(9, 'Cough Syrup', 6.79, 1, 120, 400, '2023-12-31', 'Relieves cough symptoms', 7),
-- Add more products as needed

-- First Aid
(10, 'Antiseptic Wipes', 3.29, 1, 180, 700, '2025-10-31', 'Cleansing wipes for wounds', 6),
(11, 'Gauze Rolls', 4.49, 1, 100, 300, '2026-08-31', 'For wound dressing', 6),
-- Add more products as needed

-- Skin Care
(12, 'Sunscreen SPF 50', 9.49, 1, 90, 200, '2024-07-31', 'High protection from UV rays', 5),
(13, 'Acne Treatment Cream', 7.99, 1, 150, 500, '2024-09-30', 'For acne-prone skin', 5),
-- Add more products as needed

-- Dental Care
(14, 'Mouthwash', 5.29, 1, 180, 700, '2024-05-31', 'For fresh breath', 9),
(15, 'Dental Floss', 2.99, 1, 250, 800, '2025-03-31', 'Removes plaque between teeth', 9),
-- Add more products as needed

-- Eye Care
(16, 'Contact Lens Solution', 6.99, 1, 100, 300, '2024-10-31', 'For cleaning and storing lenses', 10),
(17, 'Eye Cream', 8.49, 1, 120, 400, '2024-11-30', 'Reduces dark circles and puffiness', 10),
-- Add more products as needed
-- Medicines
(18, 'Ibuprofen Tablets', 5.49, 1, 150, 500, '2024-12-31', 'For pain and inflammation', 4),
(19, 'Allergy Relief Tablets', 6.99, 1, 100, 300, '2023-11-30', 'Relieves allergy symptoms', 4),
-- Add more products as needed

-- First Aid
(20, 'Adhesive Bandages', 2.99, 1, 200, 600, '2025-09-30', 'For minor cuts and wounds', 6),
(21, 'Burn Relief Gel', 7.49, 1, 80, 250, '2023-12-31', 'Soothes minor burns', 6),
-- Add more products as needed

-- Skin Care
(22, 'Moisturizing Lotion', 8.99, 1, 120, 400, '2024-08-31', 'Hydrates dry skin', 5),
(23, 'Anti-Wrinkle Serum', 12.49, 1, 60, 200, '2024-06-30', 'Reduces fine lines', 5),
-- Add more products as needed

-- Dental Care
(24, 'Toothpaste (Fluoride)', 3.79, 1, 180, 700, '2025-04-30', 'Prevents cavities', 9),
(25, 'Toothbrush (Soft Bristles)', 2.49, 1, 250, 800, '2025-02-28', 'Gentle on gums', 9),
-- Add more products as needed

-- Eye Care
(26, 'Preservative-Free Eye Drops', 9.99, 1, 90, 300, '2024-11-30', 'Relieves dry eyes', 10),
(27, 'Vision Health Supplements', 11.99, 1, 60, 200, '2023-12-31', 'Supports eye health', 10),
-- Add more products as needed



-- Medicines
(18, 'Ibuprofen Tablets', 5.49, 50, 10, 500, '2024-12-31', 'For pain and inflammation', 4),
(19, 'Allergy Relief Tablets', 6.99, 30, 10, 300, '2023-11-30', 'Relieves allergy symptoms', 4),
-- Add more products as needed

-- First Aid
(20, 'Adhesive Bandages', 2.99, 100, 6, 600, '2025-09-30', 'For minor cuts and wounds', 6),
(21, 'Burn Relief Gel', 7.49, 20, 12, 240, '2023-12-31', 'Soothes minor burns', 6),
-- Add more products as needed

-- Skin Care
(22, 'Moisturizing Lotion', 8.99, 60, 7, 420, '2024-08-31', 'Hydrates dry skin', 5),
(23, 'Anti-Wrinkle Serum', 12.49, 30, 7, 210, '2024-06-30', 'Reduces fine lines', 5),
-- Add more products as needed

-- Dental Care
(24, 'Toothpaste (Fluoride)', 3.79, 60, 12, 720, '2025-04-30', 'Prevents cavities', 9),
(25, 'Toothbrush (Soft Bristles)', 2.49, 50, 16, 800, '2025-02-28', 'Gentle on gums', 9),
-- Add more products as needed

-- Eye Care
(26, 'Preservative-Free Eye Drops', 9.99, 30, 10, 300, '2024-11-30', 'Relieves dry eyes', 10),
(27, 'Vision Health Supplements', 11.99, 30, 7, 210, '2023-12-31', 'Supports eye health', 10);

-- Add more products as needed

CREATE TABLE pos.orders (
                            Id INT NOT NULL AUTO_INCREMENT,
                            orderPrice INT NULL,
                            customer VARCHAR(45) NULL,
                            orderDate TIMESTAMP NULL,
                            PRIMARY KEY (Id));


use pos;
select * from orderitem;CREATE TABLE orderitem (
                                                   id int NOT NULL AUTO_INCREMENT,
                                                   Name varchar(100) DEFAULT NULL,
                                                   price double DEFAULT NULL,
                                                   totalQuantity int DEFAULT NULL,
                                                   totalPrice double DEFAULT NULL,
                                                   orderId int DEFAULT NULL,
                                                   PRIMARY KEY (id),
                                                   KEY ordersitems_idx (orderId),
                                                   CONSTRAINT ordersitems FOREIGN KEY (orderId) REFERENCES orders (Id) ON DELETE CASCADE ON UPDATE CASCADE
                        )


SELECT o.Id, o.orderPrice, o.customer, o.orderDate, i.Name AS productName FROM orders o
                   JOIN orderitem i ON o.Id = i.orderId;


select * from expired_products

create table if not exists pos.expired_products
(
    id            int auto_increment
        primary key,
    pname         varchar(45)   null,
    price         double        null,
    expired_date  date          null,
    description   varchar(1000) null,
    QinP          int           null,
    tP            int           null,
    totalQuantity int           null,
    expDate       date          null,
    des           varchar(1000) null,
    cname         varchar(100)  null
);

INSERT INTO expired_products (pname, price, expired_date, description, cname) VALUES ('Amoxicillin', 15.99, '2023-12-01', 'Broad-spectrum antibiotic', 'Personal Care Products');

INSERT INTO expired_products (pname, price, expired_date, description, cname) VALUES ('Vitamin C', 12.95, '2023-11-15', 'Immune system support', 'Personal Care Products');

INSERT INTO expired_products (pname, price, expired_date, description, cname) VALUES ('Entox Tablets', 5.49, '2023-11-01', 'For pain', 'Personal Care Products');

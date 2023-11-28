use pos;
CREATE TABLE Category (
                          id INT PRIMARY KEY,
                          cname VARCHAR(100) NOT NULL,
                          des varchar(200),
                          parentId INT,
                          FOREIGN KEY (parentId) REFERENCES Category(id) on update cascade on delete cascade
);
CREATE TABLE `pos`.`product` (
                                 `id` INT NOT NULL,
                                 `pname` VARCHAR(45) NULL,
                                 `price` DOUBLE NULL,
                                 `QinP` INT NULL,
                                 `tP` INT NULL,
                                 `totalQuantity` INT NULL,
                                 `expDate` DATE NULL,
                                 `des` VARCHAR(1000) NULL,
                                 `cId` INT NULL,
                                 PRIMARY KEY (`id`),
                                 INDEX `category_idx` (`cId` ASC) VISIBLE,
                                 CONSTRAINT `category`
                                     FOREIGN KEY (`cId`)
                                         REFERENCES `pos`.`category` (`id`)
                                         ON DELETE CASCADE
                                         ON UPDATE CASCADE
                             );


-- Inserting parent categories
-- Inserting Pharmacy Category

-- Inserting Subcategories under Pharmacy (if any)
-- Add more subcategories as needed
-- Inserting More Categories related to Pharmacy
INSERT INTO Category (id, cname, des, parentId)
VALUES (3, 'Personal Care', 'Personal Care Products', NULL);

INSERT INTO Category (id, cname, des, parentId)
VALUES (4, 'Health Supplements', 'Supplements Category', NULL);

-- Inserting Subcategories under 'Personal Care'
INSERT INTO Category (id, cname, des, parentId)
VALUES (5, 'Skincare', 'Skincare Products', 3);

INSERT INTO Category (id, cname, des, parentId)
VALUES (6, 'Hair Care', 'Hair Care Products', 3);

-- Inserting Subcategories under 'Health Supplements'
INSERT INTO Category (id, cname, des, parentId)
VALUES (7, 'Vitamins', 'Vitamin Supplements', 4);

INSERT INTO Category (id, cname, des, parentId)
VALUES (8, 'Proteins', 'Protein Supplements', 4);

-- Add more products as needed

-- Inserting Products related to 'Personal Care'
INSERT INTO Product (id, pname, price, QinP, tP, totalQuantity, expDate, des, cId)
VALUES
    (101, 'Face Wash', 5.99, 2, 5, 10, '2023-12-10', 'Gentle Face Wash', 5),
    (102, 'Shaving Cream', 3.50, 3, 8, 24, '2023-12-15', 'Sensitive Skin Shaving Cream', 6)
    -- Add more 'Personal Care' products

-- Inserting Products related to 'Health Supplements'
    INSERT INTO Product (id, pname, price, QinP, tP, totalQuantity, expDate, des, cId)
VALUES
    (103, 'Multivitamin Tablets', 12.75, 1, 60, 60, '2024-01-01', 'Daily Health Supplement', 7),
    (104, 'Whey Protein Powder', 29.99, 1, 20, 20, '2023-12-20', 'Vanilla Whey Protein', 8)
-- Add more 'Health Supplements' products

-- Add more products for other categories as needed
-- More Products related to 'Personal Care'
    INSERT INTO Product (id, pname, price, QinP, tP, totalQuantity, expDate, des, cId)
VALUES
    (105, 'Moisturizing Lotion', 8.99, 2, 7, 14, '2023-12-25', 'Hydrating Skin Lotion', 5),
    (106, 'Hair Conditioner', 6.50, 1, 15, 15, '2023-12-30', 'Nourishing Hair Conditioner', 6),
    -- Add more 'Personal Care' products

-- More Products related to 'Health Supplements'
    INSERT INTO Product (id, pname, price, QinP, tP, totalQuantity, expDate, des, cId)
VALUES
    (107, 'Omega-3 Fish Oil Capsules', 18.75, 1, 30, 30, '2024-01-10', 'Essential Fatty Acids', 7)
    (108, 'Pre-workout Supplement', 24.99, 1, 10, 10, '2023-12-18', 'Energy Boosting Supplement', 8)
-- Add more 'Health Supplements' products

-- More Products related to other categories
-- Add additional products for 'Skincare', 'Hair Care', 'Vitamins', 'Proteins' or any other categories as needed
-- More Products related to 'Skincare'
    INSERT INTO Product (id, pname, price, QinP, tP, totalQuantity, expDate, des, cId)
VALUES
    (109, 'Acne Spot Treatment', 7.25, 1, 12, 12, '2023-12-28', 'Spot Treatment Gel', 5),
    (110, 'Sunscreen Lotion', 9.99, 1, 20, 20, '2024-01-05', 'SPF 50 Sun Protection', 5),
    -- Add more 'Skincare' products

-- More Products related to 'Hair Care'
    INSERT INTO Product (id, pname, price, QinP, tP, totalQuantity, expDate, des, cId)
VALUES
    (111, 'Hair Serum', 11.50, 1, 15, 15, '2023-12-31', 'Frizz Control Serum', 6),
    (112, 'Hair Mask', 14.75, 1, 8, 8, '2024-01-15', 'Repairing Hair Mask', 6),
    -- Add more 'Hair Care' products

-- More Products related to 'Vitamins'
    INSERT INTO Product (id, pname, price, QinP, tP, totalQuantity, expDate, des, cId)
VALUES
    (113, 'Vitamin C Tablets', 6.99, 1, 30, 30, '2024-01-08', 'Antioxidant Support', 7),
    (114, 'Vitamin D3 Capsules', 5.50, 1, 60, 60, '2024-01-20', 'Bone Health Supplement', 7),
    -- Add more 'Vitamins' products

-- More Products related to 'Proteins'
    INSERT INTO Product (id, pname, price, QinP, tP, totalQuantity, expDate, des, cId)
VALUES
    (115, 'Plant-Based Protein Powder', 22.99, 1, 18, 18, '2023-12-22', 'Vegan Protein Supplement', 8),
    (116, 'Casein Protein Bars', 14.25, 1, 12, 12, '2024-01-02', 'Slow Release Protein Snack', 8);
-- Add more 'Proteins' products


-- More Products related to 'Skincare'
INSERT INTO Product (id, pname, price, QinP, tP, totalQuantity, expDate, des, cId)
VALUES
    (117, 'Facial Cleanser', 8.50, 1, 10, 10, '2023-12-28', 'Gentle Foaming Cleanser', 5),
    (118, 'Night Cream', 12.99, 1, 8, 8, '2024-01-05', 'Hydrating Night Cream', 5),
    -- Add more 'Skincare' products

-- More Products related to 'Hair Care'
    INSERT INTO Product (id, pname, price, QinP, tP, totalQuantity, expDate, des, cId)
VALUES
    (119, 'Hair Oil', 9.75, 1, 15, 15, '2023-12-31', 'Nourishing Hair Oil', 6),
    (120, 'Dry Shampoo', 7.25, 1, 10, 10, '2024-01-15', 'Instant Refresh Dry Shampoo', 6),
    -- Add more 'Hair Care' products

-- More Products related to 'Vitamins'
    INSERT INTO Product (id, pname, price, QinP, tP, totalQuantity, expDate, des, cId)
VALUES
    (121, 'Biotin Supplement', 11.99, 1, 30, 30, '2024-01-08', 'Supports Hair & Nail Health', 7),
    (127, 'Calcium & Magnesium Tablets', 8.50, 1, 60, 60, '2024-01-20', 'Bone Health Support', 7),
    -- Add more 'Vitamins' products

-- More Products related to 'Proteins'
    INSERT INTO Product (id, pname, price, QinP, tP, totalQuantity, expDate, des, cId)
VALUES
    (128, 'Collagen Peptides Powder', 19.99, 1, 20, 20, '2023-12-22', 'Supports Skin Health', 8),
    (129, 'Whey Isolate Protein Bars', 16.25, 1, 12, 12, '2024-01-02', 'Low Carb Protein Snack', 8);
-- Add more 'Proteins' products

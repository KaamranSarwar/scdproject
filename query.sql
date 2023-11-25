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

USE filmdb;

CREATE TABLE films
(
    id int(10) PRIMARY KEY AUTO_INCREMENT,
    tittle VARCHAR(100) NOT NULL,
    year int (4),
    genre VARCHAR(20)
)
COLLATE ='utf8_general_ci';
CREATE UNIQUE INDEX films_tittle_uindex ON films(tittle);

INSERT INTO `films` (`tittle`,`year`,`genre`)
VALUES
    ("Inception", 2010, "sci-fi"),
    ("The Lord of the Rings: The Fellowship of the Ring", 2001, "fantasy"),
    ("Tag", 2018, "comedy"),
    ("Gunfight at the O.K. Corral", 1957, "western"),
    ("Die Hard", 1988, "action");
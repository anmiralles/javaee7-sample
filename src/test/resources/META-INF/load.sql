LOCK TABLES Customer WRITE;
INSERT INTO Customer VALUES (2,'Nuestra Señora de Regla','6','SV','anmiralles@yahoo.es','Angel Miralles','676767360'),(3,'Americo Vespucio','10','SV','angel.miralles.exts@juntadeandalucia.es','Juan Pedro','955124356');
UNLOCK TABLES;

LOCK TABLES Permission WRITE;
INSERT INTO Permission VALUES (1,'ROLE_USER');
UNLOCK TABLES;


LOCK TABLES User WRITE;
INSERT INTO User VALUES (1,'5b5855f2e2829df31a10cb5145bd1013b11237e2','amiralles',1);
UNLOCK TABLES;
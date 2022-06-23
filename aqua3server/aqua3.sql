DROP TABLE IF EXISTS `SZENARIEN`;
CREATE TABLE `SZENARIEN` (
	`SZENARIEN_ID` BIGINT NOT NULL AUTO_INCREMENT,
	`NAME` VARCHAR(255) NOT NULL,
	`SHORTNAME` VARCHAR(6) NOT NULL,
	`TEMPMIN` DOUBLE NOT NULL,
	`TEMPMAX` DOUBLE NOT NULL,
	`PHMIN` DOUBLE NOT NULL,
	`PHMAX` DOUBLE NOT NULL,
	`LICHTEIN` VARCHAR(5) NOT NULL,
	`LICHTAUS` VARCHAR(5) NOT NULL,
	`DIMENSIONEN_ID` BIGINT NOT NULL,
	PRIMARY KEY (`SZENARIEN_ID`)
) ENGINE=MyISAM;

INSERT INTO `SZENARIEN` VALUES (1,'Default Szenario','Defaul','22.0','28.0','5.0','8.0','05:00','21:00',7);

DROP TABLE IF EXISTS `DIMENSIONEN`;
CREATE TABLE `DIMENSIONEN` (
	`DIMENSIONEN_ID` BIGINT NOT NULL AUTO_INCREMENT,
	`LAENGE` INT,
	`BREITE` INT,
	`HOEHE` INT,
	`VOLUMEN` INT,
	PRIMARY KEY (`DIMENSIONEN_ID`)
) ENGINE=MyISAM;

INSERT INTO `DIMENSIONEN` VALUES (1,40,20,30,24),(2,50,25,35,44),(3,60,30,45,81),(4,70,35,53,129),(5,80,40,60,192),(6,90,45,68,275),(7,100,50,75,375),(8,120,60,90,648);

DROP TABLE IF EXISTS `LEBEWESEN`;
SET @saved_cs_client = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `LEBEWESEN` (
	`LEBEWESEN_ID` BIGINT NOT NULL AUTO_INCREMENT,
	`NAME` VARCHAR(150) NOT NULL,
	`TYPEN_ID` BIGINT NOT NULL,
	`TEMPWERTE_ID` BIGINT,
	`PHWERTE_ID` BIGINT,
	`INFO` VARCHAR(255),
	`PHOTO` VARCHAR(150),
	`KANTENAB` INT,
	PRIMARY KEY (`LEBEWESEN_ID`)
) ENGINE=MyISAM;

INSERT INTO `LEBEWESEN` VALUES (1,'Alternanthera reineckii Rot',1,2,NULL,NULL,NULL,50),(2,'Alternanthera reineckii Bronze',1,2,NULL,NULL,NULL,50),(3,'Alternanthera reineckii Burgunderrot',1,2,NULL,NULL,NULL,50),(4,'Ammannia gracilis',1,2,NULL,NULL,NULL,50),(5,'Anubias gilletii',1,2,NULL,NULL,NULL,40),(6,'Anubias spec. Heterophylla',1,10,NULL,NULL,NULL,60),(7,'Anubias afzelii',1,2,NULL,NULL,NULL,30),(8,'Anubias hastifolia',1,10,NULL,NULL,NULL,50),(9,'Anubias gracilis',1,10,NULL,NULL,NULL,15),(10,'Anubias barteri Ubangi',1,10,NULL,NULL,NULL,15),(11,'Anubias barteri',1,2,NULL,NULL,NULL,35),(12,'Anubias barteri Oriental',1,2,NULL,NULL,NULL,35),(13,'Anubias barteri Kompakt',1,10,NULL,NULL,NULL,30),(14,'Anubias congensis',1,2,NULL,NULL,NULL,60),(15,'Anubias b. v. nana Auslese',1,2,NULL,NULL,NULL,15),(16,'Aponogeton madagascariensis',1,28,NULL,NULL,NULL,40),(17,'Aponogeton henkelianus',1,3,NULL,NULL,NULL,70),(18,'Bacopa monnieri II',1,29,NULL,NULL,NULL,50),(19,'Cabomba caroliniana',1,4,NULL,NULL,NULL,50),(20,'Cardamine lyrata',1,28,NULL,NULL,NULL,40),(21,'Cladophora aegagropila',1,30,NULL,NULL,NULL,20),(22,'Cryptocoryne x willisii',1,29,NULL,NULL,NULL,15),(23,'Echinodorus argentinensis',1,4,NULL,NULL,NULL,30),(24,'Eleocharis acicularis',1,4,NULL,NULL,NULL,25),(25,'Egeria densa',1,4,NULL,NULL,NULL,60),(26,'Hydrocotyle leucocephala',1,2,NULL,NULL,NULL,60),(27,'Hygrophila difformis',1,2,NULL,NULL,NULL,50),(28,'Cyperus alternifolius',1,31,NULL,NULL,NULL,80),(29,'Arnoldichthys spilopterus (Afrik. Großschuppensalmler)',2,1,2,NULL,NULL,100),(30,'Brycinus longipinnis (Langflossensalmler)',2,2,2,NULL,NULL,100),(31,'Phenogrammus interruptus (Kongosalmler) ',2,1,2,NULL,NULL,100),(32,'Aphyocharax anisitsi (Rotflossensalmler)',2,3,2,NULL,NULL,60),(33,'Gymnocorymbus ternetzi (Trauermantelsalmler)',2,4,2,NULL,NULL,60),(34,'Hasemania nana (Kupfermantelsalmler)',2,2,4,NULL,NULL,60),(35,'Hemigrammus caudovittatus (Rautenflecksalmler)',2,4,4,'Frißt Pflanzen',NULL,80),(36,'Hemigrammus erythrozonus (Glühlichtsalmler)',2,5,4,NULL,NULL,60),(37,'Hemigrammus ocellifer (Schlußlichtsalmler)',2,5,4,NULL,NULL,60),(38,'Hemigrammus pulcher (Karfunkelsalmler)',2,5,4,NULL,NULL,60),(39,'Hemigrammus rhodostomus (Rotmaulsalmler)',2,5,1,NULL,NULL,80),(40,'Hyphessobrycon bentosi (Schmucksalmler)',2,5,4,NULL,NULL,60),(41,'Hyphessobrycon callistus (Blutsalmler)',2,6,4,'Aggressivität',NULL,60),(42,'Hyphessobrycon erythrostigma (Kirschflecksalmler)',2,1,1,NULL,NULL,80),(43,'Hyphessobrycon flammeus (Roter von Rio)',2,7,4,'Bis 25 dGH',NULL,60),(44,'Hyphessobrycon herbertaxelrodi (Schwarzer Neon)',2,1,4,NULL,NULL,60),(61,'Carnegiella strigata (Marmorierter Beilbauchfisch)',2,8,4,'Aquariumabdeckung',NULL,80),(62,'Gasteropelecus sternicla (Silberbeilbauchfisch)',2,5,4,'Aquariumabdeckung',NULL,80),(63,'Thoracocharax securis (Platinbeilbauch)',2,1,4,'Aquariumabdeckung',NULL,100),(64,'Nannostomus eques (Spitzmaul-Ziersalmler)',2,8,4,NULL,NULL,60),(65,'Nannostomus beckfordi (Längsbinden-Ziersalmler)',2,8,4,NULL,NULL,60),(66,'Nannostomus marginatus (Zwerg-Ziersalmler)',2,8,4,NULL,NULL,60),(67,'Acanthopsis sp. (Pferdekopfschmerle)',2,1,2,'Feiner Kies (Sand) als Boden',NULL,100),(68,'Botia macracanthus (Prachtschmerle)',2,1,4,'Aggressiv!',NULL,150),(69,'Pangio spp. (Dornaugen)',3,1,4,'Feiner Kies (Sand) als Boden',NULL,60),(70,'Gyrinocheilus aymonieri (Siames. Saugschmerle)',2,2,2,'Pflanzliche Kost, im Alter revierbildend',NULL,100),(71,'Balantiocheilus melanopterus (Haibarbe)',2,2,2,'Größe! Schwimmbedürfnis',NULL,150),(72,'Brachydanio albolineatus (Schillerbärbling)',2,9,2,NULL,NULL,60),(73,'Brachydanio frankei (Leopardbärbling)',2,4,2,NULL,NULL,60),(74,'Brachydanio rerio (Zebrabärbling)',2,4,2,NULL,NULL,60),(75,'Crossocheilus spp. (Algenfresser)',2,2,2,'Pflanzliche Kost',NULL,100),(76,'Danio aequipinnatus (Malabarbärbling)',2,7,2,NULL,NULL,100),(77,'Epalzeorhynchus bicolor (Feuerschwanz)',4,2,2,'Revierbildend, nur bedingt geeignet als Aquarienfisch',NULL,120),(78,'Epalzeorhynchus kallopterus (Schönflossenbarbe)',4,10,2,'Revierbildend',NULL,100),(79,'Epalzeorhynchus frenatus (Grüner Fransenlipper)',2,2,2,NULL,NULL,120),(80,'Puntius conchonius (Prachtbarbe)',2,11,2,NULL,NULL,80),(81,'Puntius nigrofasciatus (Purpurkopfbarbe)',2,12,2,NULL,NULL,80),(82,'Puntius \"schuberti\" (Messingbarbe)',2,13,2,NULL,NULL,60),(83,'Puntius tetrazona (Sumatrabarbe)',2,14,2,'Nicht mit langflossigen Fischen vergesellschaften',NULL,60),(84,'Puntius ticto (Odessa-, Rubinbarbe)',2,15,2,NULL,NULL,60),(85,'Puntius titteya (Bitterlingsbarbe)',2,16,2,NULL,NULL,60),(86,'Rasbora heteromorpha (Keilfleckbarbe)',2,17,1,NULL,NULL,60),(87,'Tanichthys albonubes (Kardinalfisch)',2,18,2,NULL,NULL,60),(88,'Arius seemanni (Minihai)',4,19,3,'Nicht geeignet als Aquarienfisch! Geschlechtsreife Tiere müssen in Meerwasser gehalten werden',NULL,150),(89,'Dysichthys bicolor (Zweif. Bratpfannenwels)',2,20,4,'feiner Kies (Sand) als Boden',NULL,80),(90,'Callichthys callichthys (Schwielenwels)',2,21,4,NULL,NULL,120),(91,'Corydoras aeneus (Metallpanzerwels)',2,9,4,NULL,NULL,60),(92,'Corydoras paleatus (Marmorierter Panzerwels)',2,11,4,NULL,NULL,60),(93,'Corydoras trilineatus (i.d.R. verkauft als C.julii)',2,22,4,NULL,NULL,60),(94,'Ancistrus spp. (Antennenwels)',2,11,2,'Pflanzliche Kost und Wurzeln',NULL,80),(95,'Farlowella acus (Nadelwels)',2,23,1,'Pflanzliche Kost und Wurzeln',NULL,80),(96,'Glyptopterichthys gibbiceps (Wabenschilderwels)',2,22,4,'Größe!',NULL,150),(97,'Hoplosternum thoracatum (Gemalter Panzerwels)',2,22,4,NULL,NULL,120),(98,'Hypostomus punctatus (Punktierter Schilderwels)',2,22,4,'Pflanzliche Kost und Wurzeln',NULL,120),(99,'Otocinclus affinis (Kleiner Saugwels)',2,22,4,'Pflanzliche Kost und Wurzeln',NULL,60),(100,'Panaque nigrolineatus (Rotaugen-Panaque)',2,22,4,'Pflanzliche Kost und Wurzeln; Größe!',NULL,120),(101,'Peckoltia vittata (Gebänderter Schilderwels)',2,2,4,'Pflanzliche Kost und Wurzeln',NULL,80),(102,'Rineloricaria lanceolata (Lanzenharnischwels)',2,22,4,'Pflanzliche Kost und Wurzeln',NULL,80),(103,'Sturisoma aureum (Goldbartwels)',2,22,4,'Pflanzliche Kost und Wurzeln',NULL,100),(104,'Synodontis nigriventris (Rückenschw. Kongowels)',2,2,4,NULL,NULL,80),(105,'Pangasius sutchi (Haiwels)',2,20,2,'Nur bedingt geeignet als Aquarienfisch',NULL,150),(106,'Pimelodus pictus (Gemalter Antennenwels)',4,19,1,'Nur bedingt geeignet als Aquarienfisch',NULL,120),(107,'Kryptopterus bicirrhis (Indischer Glaswels)',3,1,4,NULL,NULL,100),(108,'Glossolepis inciscus (Lachsroter Regenbogenfisch)',2,2,2,NULL,NULL,100),(109,'Melanotaenia boesemani (Boesemans Regenbogenfisch)',2,2,4,NULL,NULL,80),(110,'Melanotaenia praecox (Neon Regenbogenfisch)',2,2,4,NULL,NULL,80),(111,'Iriatherina werneri (Filigranährenfisch)',2,2,1,NULL,NULL,60),(112,'Aphyosemion australe (Kap Lopez)',2,24,4,NULL,NULL,60),(114,'Aphyosemion gardneri (Blauer Prachtkärpfling)',2,2,2,NULL,NULL,60),(115,'Aplocheilus lineatus (Streifenhechtling)',2,22,2,NULL,NULL,80),(116,'Epiplatys sexfasciatus (Querbandhechtling)',2,2,2,NULL,NULL,80),(117,'Poecilia reticulata (Guppy)',2,9,5,NULL,NULL,60),(118,'Poecilia sphenops (Black Molly, Zuchtform)',2,25,2,NULL,NULL,60),(119,'Poecilia velifera (Segelkärpfling)',2,26,3,NULL,NULL,100),(120,'Xiphophorus helleri (Schwertträger)',4,22,5,'Männchen unter- einander aggressiv',NULL,80),(121,'Xiphophorus maculatus (Platys)',2,11,5,NULL,NULL,60),(122,'Xiphophorus variatus (Pagaeienplaty, Zuchtform)',2,22,5,NULL,NULL,60),(123,'Betta splendens (Schleierkampffisch)',5,26,2,'Artspezifische Aggressivität',NULL,60),(124,'Colisa chuna (Honiggurami)',5,26,2,NULL,NULL,60),(125,'Colisa labiosa (Dicklippiger Fadenfisch)',5,26,2,NULL,NULL,100),(126,'Colisa lalia (Zwergfadenfisch)',5,26,2,NULL,NULL,60),(127,'Macropodus opercularis (Makropode)',5,11,2,NULL,NULL,80),(128,'Trichogaster leerii (Mosaikfadenfisch)',5,26,4,NULL,NULL,120),(129,'Trichogaster trichopterus (Blauer Fadenfisch)',5,26,4,NULL,NULL,100),(130,'Helostoma temminckii (Küssender Gurami)',6,26,2,'Nur bedingt geeignet als Aquarienfisch',NULL,150),(131,'Aequidens pulcher (Blaupunktbarsch)',6,8,2,NULL,NULL,100),(132,'Apistogramma agassizii (Agassiz´Zwergbuntbarsch)',5,22,4,NULL,NULL,60),(133,'Apistogramma borelli (Borellis Zwergbuntbarsch)',6,9,4,NULL,NULL,60),(134,'Apistogramma cacatuoides (Kakadu - Zwergbuntbarsch)',6,22,2,NULL,NULL,60),(135,'Apistogramma macmasteri (Villavicencio Zwergbuntbarsch)',5,8,4,NULL,NULL,60),(136,'Archocentrus nigrofasciatus (Zebrabuntbarsch)',6,9,2,NULL,NULL,80),(137,'Dicrossus filamentosus (Gabelschwanz-Schachbrettcichlide)',6,8,1,NULL,NULL,80),(138,'Laetacara curviceps (Tüpfelbuntbarsch)',6,8,4,NULL,NULL,60),(139,'Nannacara anomala (Glänzender Zwergbuntbarsch)',5,8,4,NULL,NULL,80),(140,'Papiliochromis ramirezi (Schmetterlingsbuntbarsch)',6,22,4,NULL,NULL,60),(141,'Pterophyllum scalare (Segelflosser)',2,26,4,'zur Fortpflanzung in kleinere Becken',NULL,100),(142,'Symphysodon aequifasciatus (Diskusbuntbarsch)',2,27,1,'paarweise halten',NULL,120),(143,'Thorichthys meeki (Feuermaulbuntbarsch)',2,8,2,NULL,NULL,100),(144,'Hemichromis spp. (Rote Cichlide)',6,8,4,'Aggressivität',NULL,100),(145,'Pelvicachromis pulcher (Purpurprachtbuntbarsch)',6,8,4,NULL,NULL,80),(146,'Pelvicachromis taeniatus (Smaragd - Prachtbuntbarsch)',6,8,1,NULL,NULL,80),(147,'Steatocranus casuaris (Buckelkopfbuntbarsch)',6,8,4,NULL,NULL,80),(148,'Cyphotilapia frontosa (Tanganjikabeulenkopf)',5,8,3,'Größe!',NULL,200),(149,'Julidochromis spp. (Schlankcichliden)',6,8,3,NULL,NULL,60),(150,'Lamprologus ocellatus (Kleiner Schneckenbuntbarsch)',6,8,3,'Leere Schneckenhäuser',NULL,60),(151,'Neolamprologus brichardi (Feenbarsch)',6,8,3,'Komplexe Sozial- strukturnull',NULL,80),(152,'Neolamprologus leleupi (Tanganjika - Goldcichlide)',5,8,3,NULL,NULL,80),(153,'Tropheus spp. (Brabantbuntbarsche)',5,8,3,'Aufwuchsfresser',NULL,150),(154,'Aulonocara spp. (Kaiserbuntbarsche)',5,8,3,NULL,NULL,100),(155,'Haplochromis spp. (Copadichromis sp., Nimbochromis sp. )',5,8,3,NULL,NULL,120),(156,'Labidochromis caeruleus',5,8,3,NULL,NULL,80),(157,'Melanochromis auratus (Türkisgoldbarsch)',5,8,3,'Innerartliche Aggressivität',NULL,100),(158,'Pseudotropheus estherae (Roter Zebrabuntbarsch)',5,8,3,NULL,NULL,120),(159,'Brachygobius xanthozona (Goldringelgrundel)',2,16,5,NULL,NULL,60),(160,'Carassius auratus (Goldfisch)',2,9,5,NULL,NULL,100),(161,'Chanda ranga (Indischer Glasbarsch)',2,26,2,NULL,NULL,60),(162,'Cyprinus carpio (Koi, Farbkarpfen)',2,9,5,'Nur bedingt geeignet als Aquarienfisch Teichfisch!',NULL,200),(163,'Gnathonemus petersi (Elefantenrüsselfisch)',2,26,1,'Nur bedingt geeignet als Aquarienfisch',NULL,150),(164,'Leucaspius delineatus (Moderlieschen)',3,9,5,'Nur bedingt geeignet als Aquarienfisch',NULL,100),(165,'Leuciscus idus (Goldorfe)',3,9,5,'Nur bedingt geeignet als Aquarienfisch',NULL,200),(166,'Tetraodon nigroviridis (Grüner Kugelfisch)',4,2,5,'Aggressiv, Salzzusatz',NULL,100);

DROP TABLE IF EXISTS `TEMPWERTE`;
CREATE TABLE `TEMPWERTE` (
	`TEMPWERTE_ID` BIGINT NOT NULL AUTO_INCREMENT,
	`VON` DOUBLE NOT NULL,
	`BIS` DOUBLE NOT NULL,
	PRIMARY KEY (`TEMPWERTE_ID`)
) ENGINE=MyISAM;

INSERT INTO `TEMPWERTE` VALUES (1,'23.0','28.0'),(2,'22.0','28.0'),(3,'20.0','26.0'),(4,'18.0','28.0'),(5,'23.0','29.0'),(6,'18.0','29.0'),(7,'20.0','28.0'),(8,'23.0','30.0'),(9,'20.0','30.0'),(10,'24.0','28.0'),(11,'18.0','30.0'),(12,'20.0','27.0'),(13,'18.0','27.0'),(14,'21.0','28.0'),(15,'16.0','26.0'),(16,'22.0','29.0'),(17,'24.0','29.0'),(18,'16.0','30.0'),(19,'22.0','26.0'),(20,'22.0','27.0'),(21,'28.0','28.0'),(22,'22.0','30.0'),(23,'24.0','27.0'),(24,'21.0','26.0'),(25,'25.0','30.0'),(26,'24.0','30.0'),(27,'26.0','30.0'),(28,'18.0','24.0'),(29,'18.0','26.0'),(30,'10.0','24.0'),(31,'10.0','26.0');

DROP TABLE IF EXISTS `PHWERTE`;
CREATE TABLE `PHWERTE` (
	`PHWERTE_ID` BIGINT NOT NULL AUTO_INCREMENT,
	`VON` DOUBLE NOT NULL,
	`BIS` DOUBLE NOT NULL,
	PRIMARY KEY (`PHWERTE_ID`)
) ENGINE=MyISAM;

INSERT INTO `PHWERTE` VALUES (1,'5.0','7.0'),(2,'6.0','8.0'),(3,'7.0','9.0'),(4,'5.0','8.0'),(5,'6.0','9.0');

DROP TABLE IF EXISTS `TYPEN`;
CREATE TABLE `TYPEN` (
	`TYPEN_ID` BIGINT NOT NULL AUTO_INCREMENT,
	`BEZEICHNUNG` VARCHAR(50) NOT NULL,
	`BRAUCHTTEMP` INT NOT NULL,
	`BRAUCHTPH` INT NOT NULL,
	`SOZIALVERHALTEN` CHAR(1),
	`KANTENAB` CHAR(1),
	`EINHEITTXT` VARCHAR(50),
	PRIMARY KEY (`TYPEN_ID`)
) ENGINE=MyISAM;

INSERT INTO `TYPEN` VALUES (2,'Fisch',1,1,'A','L',NULL),(1,'Pflanze',1,0,NULL,'H',NULL),(3,'Fisch',1,1,'B','L',NULL),(4,'Fisch',1,1,'C','L',NULL),(5,'Fisch',1,1,'D','L',NULL),(6,'Fisch',1,1,'E','L',NULL);

DROP TABLE IF EXISTS `SZENARIEN_FUTTERZEITEN`;
CREATE TABLE `SZENARIEN_FUTTERZEITEN` (
	`FUTTERZEITEN_ID` BIGINT NOT NULL AUTO_INCREMENT,
	`SZENARIEN_ID` BIGINT NOT NULL,
	`UHRZEIT` VARCHAR(5) NOT NULL,
	PRIMARY KEY (FUTTERZEITEN_ID)
) ENGINE=MyISAM;

INSERT INTO `SZENARIEN_FUTTERZEITEN` VALUES (1,1,'08:00'),(2,1,'20:00');

DROP TABLE IF EXISTS `SZENARIEN_LEBEWESEN`;
CREATE TABLE `SZENARIEN_LEBEWESEN` (
	`SZENARIEN_ID` BIGINT NOT NULL,
	`LEBEWESEN_ID` BIGINT NOT NULL,
	`LEBEWESENMENGE` INT NOT NULL,
	PRIMARY KEY (`SZENARIEN_ID`,`LEBEWESEN_ID`)
) ENGINE=MyISAM;

INSERT INTO `SZENARIEN_LEBEWESEN` VALUES (1,32,3),(1,33,1),(1,117,4),(1,16,6),(1,27,1),(1,7,1);

DROP TABLE IF EXISTS `STATISTIK`;
CREATE TABLE `STATISTIK` (
	`STATISTIK_ID` INT NOT NULL AUTO_INCREMENT,
	`ZEIT` VARCHAR(20) NOT NULL,
	`TEMPIST` DECIMAL(10 , 1) NOT NULL,
	`PHIST` DECIMAL(10 , 1) NOT NULL,
	`MOTOEINAUS` INT NOT NULL,
	PRIMARY KEY (`STATISTIK_ID`)
) ENGINE=MyISAM;

DROP TABLE IF EXISTS `DIMENSIONEN_TYPEN`;
CREATE TABLE `DIMENSIONEN_TYPEN` (
	`DIMENSIONEN_ID` INT NOT NULL,
	`TYPEN_ID` INT NOT NULL,
	`MAXWERT` INT NOT NULL,
	PRIMARY KEY (`DIMENSIONEN_ID`,`TYPEN_ID`)
) ENGINE=MyISAM;

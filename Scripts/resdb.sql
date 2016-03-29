USE Restaurant;

DROP TABLE IF EXISTS Restaurants;
DROP TABLE IF EXISTS ResAdmin; 
DROP TABLE IF EXISTS Customers;
DROP TABLE IF EXISTS Favorites;
DROP TABLE IF EXISTS Credits;
DROP TABLE IF EXISTS Sections;
DROP TABLE IF EXISTS Items;
DROP TABLE IF EXISTS Choices;
DROP TABLE IF EXISTS ChValues;
DROP TABLE IF EXISTS LineItems;
DROP TABLE IF EXISTS Orders;
DROP TABLE IF EXISTS Transactions;

DROP TABLE IF EXISTS Associates;
DROP TABLE IF EXISTS AssocPerf;
DROP TABLE IF EXISTS Admins;
DROP TABLE IF EXISTS ResReviews;
DROP TABLE IF EXISTS SiteReviews;
DROP TABLE IF EXISTS CustLedgers;
DROP TABLE IF EXISTS ResLedgers;
DROP TABLE IF EXISTS AdminLedgers;
DROP TABLE IF EXISTS AssocLedgers;
DROP TABLE IF EXISTS Messages;

DROP TABLE IF EXISTS Hirings;
DROP TABLE IF EXISTS ForSales;

-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS Restaurants (
		
	resID		int AUTO_INCREMENT PRIMARY KEY,
	resName		varchar(50) NOT NULL,
	altName		varchar(50),
	foundYear	year,
	categories	varchar(100) NOT NULL,
	insertDate	datetime NOT NULL,
	cancelDate	datetime,
	hasMenu		varchar(5),
	inputBy		varchar(50),
	note		text,

	
	telephoneNumber varchar(20) NOT NULL,
  	otherPhone	varchar(20),
  	addrStNum 	varchar(100) NOT NULL,
  	city 		varchar(30) NOT NULL,
  	state 		varchar(20) NOT NULL,
  	zip		varchar(10) NOT NULL,
	
  	latitude	float(10,6) ,
  	longitude	float(10,6) ,
	
  	emailAddress 	varchar(100) NOT NULL,
  	passwd		varchar(20) NOT NULL,
	question	tinyint NOT NULL,
	answer		varchar(30),
	website		varchar(100),
	
	
	monFrom		time,
  	monTo		time,
  	tueFrom		time,
  	tueTo 		time,
  	wedFrom		time,
  	wedTo		time,
  	thuFrom		time,
  	thuTo		time,
  	friFrom		time,
  	friTo		time,
  	satFrom		time,
  	satTo		time,
  	sunFrom		time,
  	sunTo		time,
	closedDays	varchar(200),
	
	
	delivery	varchar(5),
	deliBy		varchar(50),
	deliMin		decimal(4,2),
	deliFee		decimal(4,2),
	deliPolicy	varchar(50),
	deliRadius	float,
	deliZips	varchar(100),
	deliStreets	text,
	
	
	pickup		varchar(5),
	dineIn		varchar(5),
	reserve		varchar(5),
	forKids		varchar(5),
	forGroup	varchar(5),
	parking		varchar(5),
	wifi		varchar(5),
	breakfast	varchar(5),
	lunch		varchar(5),
	dinner		varchar(5),
	lateNight	varchar(5),
	coupon		varchar(5),
	

	bankName	varchar(50),
	bankPhone	varchar(20),
	bankAddr	varchar(200),
  	bankRouteNum	varchar(20),
 	bankAccNum	varchar(20),

  	mgrName		varchar(50),
  	mgrPhone	varchar(20),
  	mgrEmail	varchar(100),
	mgrPasswd	varchar(30)
	
);


-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS ResAdmin (
		-- Basic Info
	resID		int PRIMARY KEY references Restaurants,
	

	-- stats - -
	sales		float,
	numOrders	int,
	popularity	float,
	
	likes		int,
	
	dislikes	int,
	
	numRev		int,
	
	avgStar		float,
	
	numYelp		int,
	
	yelpStar	float,
	priceRange	char(5),
	

	-- promotion Info
	recomenderID	int,
	recomType	varchar(15),
	commissionType	varchar(10),
	promoCode	varchar(10),
	adChannel	varchar(30),
	numCust		int,
	numRes		int
	
);

-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS Sections (

	resID		int references Restaurants,
	secName		varchar(100) references Items,
	numItem 	tinyint,
	PRIMARY KEY (resID, secName)
);

-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS Items (

	resID		int references Restaurants,
	itemNum		int AUTO_INCREMENT PRIMARY KEY,
	secName		varchar(100),
	itemName	varchar(100) NOT NULL, -- can mix English and Chinese
	description	text,
	basePrice	float,
	numChoice	tinyint
	
);


-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS Choices (

	resID		int references Restaurants,
	itemNum		int references Items,
	chNum		int AUTO_INCREMENT PRIMARY KEY,
	chTitle		varchar(50),
	chType		varchar(50),
	required	boolean,
	numValue	tinyint
	
);


-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS ChValues(

	resID		int references Restaurants,
	chNum		int references Choices,
	valueId		int AUTO_INCREMENT PRIMARY KEY,
	valueName	varchar(30),
	valuePrice	float,
	extra		boolean
	
);


-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS Customers (

	-- basic info
	custID		int AUTO_INCREMENT PRIMARY KEY,
	insertDate	date not null,
	cancelDate	date,
  	firstName 	varchar(20) NOT NULL,
  	middleName	varchar(20),
  	lastName	varchar(20) NOT NULL,
  	nickName	varchar(20),

	-- contact, home address
	telephoneNumber varchar(20) NOT NULL,
  	otherPhone	varchar(20),
  	addrStNum 	varchar(100) NOT NULL,
  	city 		varchar(30) NOT NULL,
  	state 		varchar(20) NOT NULL,
  	zip		varchar(10) NOT NULL,
  	latitude	float(10,6),
  	longitude	float(10,6) ,
  	emailAddress 	varchar(100) NOT NULL,
  	password	varchar(20) NOT NULL,

	-- financial info
	cardNumber	varchar(20),
  	cardType 	varchar(20),
  	cardName	varchar(50),
  	cardExp		date,
  	cardCode	varchar(10),
	billZip		varchar(20),
  	billAddr	varchar(300),
	cardNumber1	varchar(20),
  	cardType1 	varchar(20),
  	cardName1	varchar(50),
  	cardExp1	date,
  	cardCode1	varchar(10),
	billZip1	varchar(20),
  	billAddr1	varchar(300),
  	paypalNum	varchar(20),

	-- promotion Info
	recomenderID	int,
	recomType	varchar(15),
	promoCode	varchar(10),
	adChannel	varchar(30)
);






-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS Favorites (	
	custId		int references Customers, 
	favID		int references Restaurants(resID),
	favName		varchar(50),
	PRIMARY KEY (custID, favID)
);

-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS Credits (	
	custID		int references Customers, 
	addr2		varchar(300),
	addr3		varchar(300),
	addr4		varchar(300),
	numCust		int,
	numRes		int,
	numRev		int,
	numOrders	int,
	totCredits	int,
	
	creditBal	int,
	PRIMARY KEY (custID)
);


-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS Associates (

	-- basic info
	assocID		int AUTO_INCREMENT PRIMARY KEY,
	joinDate	date NOT NULL,
	
	leaveDate	date,
  	firstName 	varchar(20) NOT NULL,
  	middleName	varchar(20),
  	lastName	varchar(20) NOT NULL,
  	nickName	varchar(20),
	
	

	-- contact
	telephoneNumber varchar(20) NOT NULL,
  	otherPhone	varchar(20),
  	addrStNum 	varchar(100) NOT NULL,
  	city 		varchar(30) NOT NULL,
  	state 		varchar(20) NOT NULL,
  	zip		varchar(20) NOT NULL,
  	emailAddress 	varchar(100) NOT NULL,
  	password	varchar(20) NOT NULL,

	-- financial info
	bankName	varchar(50),
  	bankRouteNum	varchar(20),
 	bankAccNum	varchar(20),
	
	comType		varchar(20),
	
	preTye		varchar(20),
	
	chgDate		date,

	-- up and downline Info
	uplineID	int references Associates(assocID),
	
	uplineName	varchar(50),
	
	gparID		int references Associates(assocID),
	
	gparName	varchar(50),
	
	ggparID		int references Associates(assocID),
	
	ggparName	varchar(50),
		
		
	
	-- promo and performance info
	promoCode	varchar(10),
	adChannel	varchar(20)
	
);



-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS AssocPerf(

	-- basic info
	assocID		int references Associates, 
	
	runStart	date,
	assocTitle	varchar(10),

			-- A, SA, MD, SMD, CEO	
	titleDate	date,
	
	downIDs		varchar(3000),
	

	numCust		int,
	
	numRes		int,
	personScore	int,
	teamScore	int
);



-- -------------------------------------------------------

CREATE TABLE IF NOT EXISTS `Admins` (
  adminID 	int auto_increment primary key,
  insertDate	datetime not null,
  firstName 	varchar(20) NOT NULL,
  middleName	varchar(20),
  lastName	varchar(20) NOT NULL,
  telephoneNumber varchar(20) NOT NULL,
  otherPhone	varchar(20),
  mailAddr	varchar(300) NOT NULL,
  emailAddress 	varchar(100) NOT NULL,
  password	varchar(20) NOT NULL,
  question	tinyint not null,
  answer	varchar(30) not null

);	
	

-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS `Orders` (
	-- active orders
	resID		int references Restaurants,
	orderNum	int NOT NULL,
	custId		int references Customers, 
	custName	varchar(50),
	resName		varchar(50),
	orderType	varchar(20),

	-- order detail
	orderTime	datetime NOT NULL,
	numberOfLines	int,
	itemName	varchar(50),	
	subTot		float,
	discountPercentage	float,
	taxRatePercent	float,
	taxAmount	float,
	tip		float,
	deliFee		float,
	totPrice	float,

	-- status
	receiverName	varchar(50),
	deliAddr	varchar(300),
	status		varchar(30),
	msgToCust	text,
	msgToRes	text,
	nonSmoke	boolean,
	resTable	varchar(30),
	resPeople	tinyint,
	resTime		time,
	pickTime	time,
	arriveTime	time,
	agentName	varchar(50),
	notes		varchar(200),
  	PRIMARY KEY (resID, orderNum)
);

-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS `Transactions` (
	-- committed orders, the same structure of Orders
	resID		int references Restaurants,
	orderNum	int NOT NULL,
	custId		int references Customers, 
	custName	varchar(50),
	resName		varchar(50),
	orderType	varchar(20),

	-- order detail
	orderTime	datetime NOT NULL,
	numberOfLines	int,
	itemName	varchar(50),
	subTot		float,
	discountPercentage	float,
	taxRatePercent	float,
	taxAmount	float,
	tip		float,
	deliFee		float,
	totPrice	float,

	-- status
	receiverName	varchar(50),
	deliAddr	varchar(300),
	status		varchar(30),
	msgToCust	text,
	msgToStore	text,
	nonSmoke	boolean,
	groupOrder	boolean,
	paySeperate	boolean,
	resTable	varchar(30),
	resPeople	tinyint,
	resTime		time,
	pickTime	time,
	arriveTime	time,
	agentName	varchar(50),
	notes		varchar(200),
  	PRIMARY KEY (resID, orderNum)
);


-- --------------------------------------------------------	
CREATE TABLE IF NOT EXISTS LineItems (
	resID		int references Restaurants,
	orderNum	int references Orders,
	lineNum		int NOT NULL,
	itemNum		int references Items, -- may be removed if use auto xml file for menu generation
	itemName	varchar(50),
	choiceText	varchar(200),
	quantity	int default 1,
	price		float,
	note		varchar(200),
	
	PRIMARY KEY (resID, orderNum, lineNum)
);
	


-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS ResReviews (
		
	resID		int references Restaurants,
	custID		int references Customers(custID), 
	custName	varchar(50),
	resName		varchar(50),	
	revDate		date,
	foodQuality	float,
	price		float,
	prompt		float,
	overall		float,
	revTitle	varchar(100),
  	comment 	text,
	resReply	text,
	helpful		int,
	noHelp		int,
	numFbk		int,
	feedback	text,
	
	PRIMARY KEY (resID, custID, revDate)
);
	

-- --------------------------------------------------------

--
-- Table structure for table `SiteReviews`
--

CREATE TABLE IF NOT EXISTS `SiteReviews` (
	revName		varchar(50),
  	revTime 	datetime NOT NULL,
	
	likes		int,
	
	dislikes	int,
  	siteStars	float not null,
	phoneStars	float not null,
	revTitle	varchar(100),
  	comment 	text,
	ourReply	text,
	helpful		int,
	noHelp		int,
	numFbk		int,
	feedback	text,
	
	PRIMARY KEY (revName, revTime)
);


-- -------------------------------------------------------

CREATE TABLE IF NOT EXISTS Messages (
	name		varchar(50) not null,
	email		varchar(100) not null,
	phone		varchar(20),
	msgTime		datetime,
	subject		varchar(100),
	msgText		text,
	replyText	text,
	replied		boolean,
	replyTime	datetime,
	status		varchar(20),
	
	PRIMARY KEY (name, msgTime)
);	
	

-- -------------------------------------------------------
CREATE TABLE IF NOT EXISTS CustLedgers (
	custId		int references Customers, 
	custName	varchar(50),
	ledgerNum	int,
	ledgerDate	date,
	
	resID		int references Restaurants,
	
	orderNum	int references Orders,
	resName		varchar(50),
	
	chargeAmt	float,
	PayAmt		float,
	payMethod	varchar(20),
	note		text,
	balance		float,
	PRIMARY KEY (custID, ledgerNum)
);



-- -------------------------------------------------------

CREATE TABLE IF NOT EXISTS ResLedgers (
	resID		int references Restaurants,
	
	orderNum	int references Orders,
	resName		varchar(50),
	ledgerNum	int,
	ledgerDate	date,

	custName	varchar(50),
	chargeAmt	float,
	PayAmt		float,
	payMethod	varchar(20),
	checkNum	varchar(10),
	note		text,
	balance		float,
	PRIMARY KEY (resID, ledgerNum)
);


-- -------------------------------------------------------

CREATE TABLE IF NOT EXISTS AssocLedgers (
	assocID		int references Associates,
	
	assocName	varchar(50),
	
	resID		int references Restaurants,
	resName		varchar(50),
	ledgerNum	int,
	ledgerDate	date,
	
	comAmt		float,
	
	overrideAmt	float,
	
	overrideID	int references Associates(assocID),
	
	overrideName	varchar(50),
	
	chargeAmt	float,
	PayAmt		float,
	payMethod	varchar(20),
	checkNum	varchar(10),
	note		text,
	balance		float,
	PRIMARY KEY (assocID, ledgerNum)
);

-- -------------------------------------------------------

CREATE TABLE IF NOT EXISTS AdminLedgers (
	ledgerID	bigint auto_increment primary key,
	custID		int references Customers,
	custName	varchar(50),
	resID		int references Restaurants,
	resName		varchar(50),
	
	assocID		int references Associates,
	
	assocName	varchar(50),
	
	orderNum	int references Orders,
	ledgerNum	int,
	ledgerDate	date,

	income		float,
	inMethod	varchar(20),
	inNote		varchar(100),
	expense		float,
	exMethod	varchar(20),
	exNote		varchar(100),
	note		varchar(200),
	balance		float
);

-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS Hirings(
	hireID		int auto_increment primary key,
	resID		int references Restaurants,
	resName		varchar(50),

	title		varchar(100),
	hireType	varchar(30),  -- Receptionist, Waitress, Chef, Helper, Manager, Deliverer
	insertDate	date,
	jobDesc		text,
	payRate		float,
	payPer		varchar(10), -- hour, week, month, year
	workTimes	varchar(100)
);


-- --------------------------------------------------------
CREATE TABLE IF NOT EXISTS ForSales(
	saleID		int auto_increment primary key,
	resID		int references Restaurants,
	resName		varchar(50),

	title		varchar(100),
	availDate	date,
	type		varchar(100), -- fast food, Chinese, Coffee shop
	insertDate	date,
	saleDesc	text,
	salePrice	float
);

	
-- -------------------------------------------------------	



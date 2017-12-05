/*
Created		05.12.2017
Modified		05.12.2017
Project		
Model		
Company		
Author		
Version		
Database		mySQL 5 
*/


drop table IF EXISTS Task;


Create table Task (
	id Int NOT NULL,
	name Char(255) NOT NULL,
	ownerId Int NOT NULL,
	assignedId Int,
	startDate Date,
	timeEstimate Time,
	priority Int NOT NULL,
	status Enum() NOT NULL,
	description Text,
	UNIQUE (id),
 Primary Key (id)) ENGINE = MyISAM;


/* Users permissions */



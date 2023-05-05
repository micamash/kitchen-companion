BEGIN TRANSACTION;

DROP TABLE IF EXISTS meal_plan_recipe;
DROP TABLE IF EXISTS shopping_list;
DROP TABLE IF EXISTS recipe_item;
DROP TABLE IF EXISTS meal_plan;
DROP TABLE IF EXISTS shopping_list;
DROP TABLE IF EXISTS recipe;
DROP TABLE IF EXISTS inventory;
DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS users;

CREATE TABLE item (
	item_id serial,
	name varchar(200) NOT NULL,
	storage_location varchar(200) NOT NULL,
	expiration_date date,
	item_size varchar(200),
	image_name varchar(200),
	CONSTRAINT PK_item PRIMARY KEY(item_id)
);

CREATE TABLE users (
	user_id serial,
	username varchar(15),
	password_hash varchar(200),
	role varchar,
	CONSTRAINT PK_user PRIMARY KEY(user_id)
);

CREATE TABLE inventory (
	inventory_id serial,
	user_id int NOT NULL,
	item_id int NOT NULL,
	quantity int NOT NULL,
	date_added date,
	CONSTRAINT PK_inventory PRIMARY KEY(inventory_id),
	CONSTRAINT FK_user FOREIGN KEY(user_id) REFERENCES users(user_id),
	CONSTRAINT FK_item FOREIGN KEY(item_id) REFERENCES item(item_id)
);

CREATE TABLE recipe (
	recipe_id serial,
	user_id int,
	recipe_name varchar(200) NOT NULL,
	cuisine_type varchar(200)  NOT NULL,
	description varchar(200) NOT NULL,
	servings int,
	cook_minutes int,
	instruction varchar(5000),
	image_name varchar(200),
	CONSTRAINT PK_recipe PRIMARY KEY(recipe_id),
	CONSTRAINT FK_user FOREIGN KEY(user_id) REFERENCES users(user_id)
);

CREATE TABLE recipe_item (
	recipe_id int,
	item_id int,
	CONSTRAINT PK_recipe_item PRIMARY KEY(recipe_id, item_id),
	CONSTRAINT FK_recipe FOREIGN KEY(recipe_id) REFERENCES recipe(recipe_id),
	CONSTRAINT FK_item FOREIGN KEY(item_id) REFERENCES item(item_id)
);

CREATE TABLE shopping_list (
	shopping_list_id serial,
	user_id int,
	name varchar(200),
	date_created date,
	CONSTRAINT PK_shopping_list PRIMARY KEY(shopping_list_id),
	CONSTRAINT FK_user FOREIGN KEY(user_id) REFERENCES users(user_id)
);

CREATE TABLE shopping_list_item (
	shopping_list_id int,
	item_id int,
	CONSTRAINT PK_shopping_list_item PRIMARY KEY(shopping_list_id, item_id),
	CONSTRAINT FK_shopping_list FOREIGN KEY(shopping_list_id) REFERENCES shopping_list(shopping_list_id),
	CONSTRAINT FK_item FOREIGN KEY(item_id) REFERENCES item(item_id)
);

CREATE TABLE meal_plan (
	meal_plan_id serial,
	user_id int,
	name varchar(200),
	date_created date,
	CONSTRAINT PK_meal_plan PRIMARY KEY(meal_plan_id),
	CONSTRAINT FK_user FOREIGN KEY(user_id) REFERENCES users(user_id)
);

CREATE TABLE meal_plan_recipe (
	meal_plan_id int,
	recipe_id int,
	CONSTRAINT PK_meal_plan_recipe PRIMARY KEY(meal_plan_id, recipe_id),
	CONSTRAINT FK_meal_plan FOREIGN KEY(meal_plan_id) REFERENCES meal_plan(meal_plan_id),
	CONSTRAINT FK_recipe FOREIGN KEY(recipe_id) REFERENCES recipe(recipe_id)
);

COMMIT;
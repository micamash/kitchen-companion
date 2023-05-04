BEGIN TRANSACTION;

DROP TABLE IF EXISTS food_item, inventory, recipe, shopping_list, meal_plan CASCADE;

CREATE TABLE food_item(
	food_item_id serial,
	storage_location varchar(200) NOT NULL,
	expiration_date date NOT NULL,
	image_name varchar(200),
	item_size varchar(200)
	foreword_by int,
	CONSTRAINT PK_food_item PRIMARY KEY(food_item_id),
    CONSTRAINT FK_food_item_recipe FOREIGN KEY(recipe_id) REFERENCES recipe(recipe_id)
);

CREATE TABLE recipe(
	recipe_id serial,
	recipe_name varchar(200) NOT NULL,
	recipe_description varchar(200) NOT NULL,
	cuisine_type varchar(200)  NOT NULL,
	image_name varchar(200),
	servings int,
	cook_time time 
	CONSTRAINT PK_recipe PRIMARY KEY(recipe_id),
);
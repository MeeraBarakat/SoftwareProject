Feature: Search about suitable home
  
Background: The System has a repository of homes with their specifications (type-material-placement-pets-amenties-price-area-bedrooms-bathrooms-leaselength)
Given  these homes are contained in the system
           
            |HOUSE_WOOD_VILLAGE_NO_GARAGEPARKING,FIREPLACE,ELEVATOR|510_150_3_2_6|
            |APARTMENT_BRICK_CITY_NO_ELEVATOR|230_120_4_2_12|         
Scenario: Search home by placement
When I search about home by "City"
Then A list of homes that matches the placement specification should be returned and printed on the console


Scenario: Search home by material
When I search about home by "Brick"
Then A list of homes that matches the material specification should be returned and printed on the console

Scenario: Search about home with less than a specific price
When I search about home with price less than 400
Then A list of homes that matches the price specification should be returned and printed on the console

Scenario: Search home by range of prices
When I search about home with price more than 300 and less than 600
Then A list of homes that matches the price specification should be returned and printed on the console

Scenario: Search about home with less than a specific area
When I search about home with area less than 140
Then A list of homes that matches the area specification should be returned and printed on the console

Scenario: Search home by range of areas 
When I search about home with area more than 140 and less than 170
Then A list of homes that matches the area specification should be returned and printed on the console

Scenario: Search home by type
When I search about home by "HOUSE"
Then A list of homes that matches the type specification should be returned and printed on the console


Scenario: Search about home By Number of bedrooms
When I search about home with 4 Number of bedrooms 
Then A list of homes that matches the bedrooms specification should be returned and printed on the console 
    
 
Scenario: Search about home By Number of bathrooms
When I search about home with 2 Number of bathrooms
Then A list of homes that matches the bathrooms specification should be returned and printed on the console 
    
 
Scenario: Search about home By Allow Pets
When I search about home By "NO" Allow Pets
Then A list of homes that matches the pets specification should be returned and printed on the console 
    
 
Scenario: Search about home By Lease Length
When I search about home By 6 Lease Length
Then A list of homes that matches the leaselength specification should be returned and printed on the console 
    
  
Scenario: Search about home by amenties
When I search about home by "ELEVATOR"  
Then A list of homes that matches the amenties specification should be returned and printed on the console 
    
 
Scenario: Search about home using MultiSpec
When I search about home by "HOUSE"
And I search about home by "wood"
And I search about home By "NO" Allow Pets 
And I search about home by "ELEVATOR" 
And  I search about home by "village"
And I search about home with 3 Number of bedrooms 
And I search about home with 2 Number of bathrooms
And I search about home By 6 Lease Length
And I search about home with price less than 520 
#And I search about home with area less than 160   
#And I search about home with price more than 140 and less than 600
And I search about home with area more than 145 and less than 200
Then A list of homes that matches the multiple specification should be returned and printed on the console

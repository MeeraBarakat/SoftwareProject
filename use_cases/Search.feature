Feature: Search about suitable home
  
Background: The System has a repository of homes with their specifications (type-material-placement-pets-amenties-price-area-bedrooms-bathrooms-leaselength)
Given  these homes are contained in the system
           
            |HOUSE_WOOD_VILLAGE_NO_GARAGEPARKING,FIREPLACE,ELEVATOR|510_150_3_2_6|
            |APARTMENT_BRICK_CITY_NO_ELEVATOR|230_120_4_2_12|         
Scenario Outline: Search home by placement
When I search about home by <placement>
Then A list of homes that matches the placement specification should be returned and printed on the console

Examples:
|placement|
|"City"|
|"Village"|

Scenario Outline: Search home by material
When I search about home by <Material> material
Then A list of homes that matches the material specification should be returned and printed on the console
Examples:
|Material|
|"Stone"|
|"Brick"|
|"Wood"|

Scenario Outline: Search about home with less than a specific price
When I search about home with price less than <price>
Then A list of homes that matches the price specification should be returned and printed on the console
Examples:
|price|
|520|
|240|
|20|

Scenario Outline: Search home by range of prices
When I search about home with price more than <price1> and less than <price2>
Then A list of homes that matches the price specification should be returned and printed on the console
  Examples:
  |price1|price2|
  |210   |520  |
  |210   |240  |
  |500   |520  |
  |20    |20   |
  
Scenario Outline: Search about home with less than a specific area
When I search about home with area less than <area>
Then A list of homes that matches the area specification should be returned and printed on the console
Examples:
|area|
|160|
|130|
|20|

Scenario Outline: Search home by range of areas 
When I search about home with area more than <area1> and less than <area2>
Then A list of homes that matches the area specification should be returned and printed on the console
  
  Examples:
  |area1|area2|
  |100  |200  |
  |90   |130  |
  |140  |180  |
  |20   |20   |

Scenario Outline: Search home by type
When I search about home by <type> type
Then A list of homes that matches the type specification should be returned and printed on the console

Examples:
|type|
|"HOUSE"|
|"APARTMENT"|

Scenario Outline: Search about home By Number of bedrooms
When I search about home with <bedrooms> Number of bedrooms 
Then A list of homes that matches the bedrooms specification should be returned and printed on the console 
      Examples:
  |bedrooms|
  |1|
  |2|
  |3|
  |4|
  |5|
 
Scenario Outline: Search about home By Number of bathrooms
When I search about home with <bathrooms> Number of bathrooms
Then A list of homes that matches the bathrooms specification should be returned and printed on the console 
    Examples:
  |bathrooms|
  |1|
  |2|
  |3|
 
Scenario Outline: Search about home By Allow Pets
When I search about home By <pets> Allow Pets
Then A list of homes that matches the pets specification should be returned and printed on the console 
    Examples:
  |pets|
  |"NO"|
  |"Yes"| 
 
Scenario Outline: Search about home By Lease Length
When I search about home By <leaselength> Lease Length
Then A list of homes that matches the leaselength specification should be returned and printed on the console 
     Examples:
  |leaselength|
  |6|
  |12|
  
Scenario Outline: Search about home by amenties
When I search about home by <amenties> amenties  
Then A list of homes that matches the amenties specification should be returned and printed on the console
      Examples:
  |amenties|
  |"GARAGEPARKING"|
  |"FIREPLACE"|
  |"ELEVATOR"|
  |"AirConditioning"|
  |"Balcony"|
  |"SwimmingPool"|

Scenario: Search about home using MultiSpec
When I search about home by "ELEVATOR" and by "city" By "APARTMENT" 
Then A list of homes that matches the multiple specification should be returned and printed on the console
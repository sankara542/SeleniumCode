Feature: Search and place the order for products

@SearchOrder
Scenario Outline: Search and experence for product search in both home and offer page

Given User is in Greencart Landing page
When User search with short name <Names> and extract the actual name of product
Then Click on Top Deals and secrch with short <Names> in offer page if product exit or not

Examples: 
| Names |
| Tom  |


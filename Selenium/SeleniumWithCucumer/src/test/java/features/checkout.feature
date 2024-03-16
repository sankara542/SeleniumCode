Feature: Verify no.of fruits and amount in checkout page by adding fruits.

@CheckOut
Scenario Outline: Select number of fruits in greencart and click on check out
  Given User is in Greencart Landing page
  When User search with short name <Name> and extract the actual name of product
  And Added on <Qty> items of selected products to cart
  When User in checkout page verify totalamout and product name and quantity as <Qty>
  And verify user has ability to enter promo code and place the order
Examples: 

  | Name | Qty |
  | Tom  | 3   |
 

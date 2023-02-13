# swissre assessment
## Coffee Corner

### Assumptions

---
*Customer stamp card, where every 5th beverage is for free.*

I will assume the stamp card is part of the input including the number of stamps, as there is no persistence.
Example: *large coffee with extra milk, stamp card 5*

I will assume stamps are not given per product, only one card can be stamped, and no stamp transfers are allowed.

I will assume the most expensive beverage is excluded from the items to make the customer happy.

I will assume the extras are not free in this case, only the beverage.

---
*If a customer orders a beverage and a snack, one of the extra's is free.*

I will assume both beverage and one of the extras are free when the stamp card has 5 stamps.

I will assume the most expensive extra is excluded from the items to make the customer happy.

---
*Output is formatted like a items.*

I will assume item quantity, free of charge (quantity), description, unit price and total are shown in the items, with an additional grand total at the end.

I will assume no new stamps or updates to the stamp card are required in the output.

I will assume no new stamp card has to be issued when the input includes a 5-stamp card and no mention of this is required in the output.

---
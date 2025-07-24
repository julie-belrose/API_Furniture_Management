## 🪑 Exercise: Develop a Furniture Management API

**Objective**:

Build a complete API for furniture sales, including stock management and shopping cart functionality, using Spring and Spring Data JPA.

### Entities:

1. Create the `Furniture` entity with at least the following attributes:

    * `id` (UUID)
    * `name` (String)
    * `description` (String)
    * `price` (Double)
    * `stock` (int)

2. Create the `CartItem` entity with at least the following attributes:

    * `id` (UUID)
    * `furniture` (reference to `Furniture`)
    * `quantity` (int)

### Repositories:

1. Create `FurnitureRepository` by extending `JpaRepository<Furniture, UUID>`.
2. Create `CartItemRepository` by extending `JpaRepository<CartItem, UUID>`.

### Services:

1. Create `FurnitureService` with the following methods:

    * `getAllFurniture()`
    * `saveFurniture()`
    * `getFurnitureById()`
    * `deleteFurniture()`

2. Create `CartService` with the following methods:

    * `getAllCartItems()` (returns: cart item ID, furniture name, furniture description, furniture price, and quantity)
    * `addCartItem()`
    * `removeCartItem()`
    * `clearCart()` (empties the cart)

### REST Endpoints:

#### Furniture:

```
GET     /api/furniture           → Get all furniture items
GET     /api/furniture/{id}      → Get a furniture item by ID
POST    /api/furniture           → Create/add a new furniture item
DELETE  /api/furniture/{id}      → Delete a furniture item by ID
```

#### Cart:

```
GET     /api/cart                → Get all items in the cart
POST    /api/cart/add            → Add a furniture item to the cart
DELETE  /api/cart/remove/{id}    → Remove a specific item from the cart by ID
DELETE  /api/cart/clear          → Clear the entire cart (delete all CartItems)
```
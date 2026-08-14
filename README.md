# OrderBook

# Java Order Book & Matching Engine
This project is a financial order book and matching engine built in Java. It is designed to handle double auctions (bids and asks) with custom priority queue sorting and also partial execution logic

## Features
**0(1) Order lookups:** Utilises a Hashmap feature to track and manage active orders by their key unique orderIds

**Price-Time Priority Queues:** Implements custom PriorityQueue comparators to ensure the best bids and best asks are always matched at the front of the book

**Continuous Matching Engine:** checks for price crosses and executes trades.

**Partial Fills & Order Lifecycle Management:** It handles exact matches, partial fills (when orders can't entirely completed), queue polling, and map cleanups dynamically.

## Classes
`Order.java`: Represents an individual order (ID, symbol, price, quantity, side).

`OrderBook.java`: Manages the state of the book, queue routing, and the `matchOrders()` execution loop.


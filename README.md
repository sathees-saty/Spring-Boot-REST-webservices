# Spring-Boot-REST-webservices
Spring-Boot-REST-WebServices
Creating GET/POST/PUT/DELETE Endpoints with Spring Boot web services
The program uses in-memory data instead of database for data.

1)	Open Spring Tool  Suite 4
2)	Create Spring starter project called Delete
3)	Add Spring Web and Thymelleaf from https://start.spring.io
4)	Click finish
5)	Create Product POJO class
6)	Create a ProductRepository class
7)	Create a ProductService
8)	Create  ProductController class
9)	run the main class as “spring boot app”
10)	Delete an existing product using potman
11)	Select DELETE and send below request
12)	http://localhost:8080/products/1
13)	You will get status 200 = success 
14)	Delete non-existing product
15)	Select DELETE and send below request
16)	http://localhost:8080/products/100 
17)	You will get status 400 = not found
18)	PUT request
19)	http://localhost:8080/products/ , You will get status 200 = success 

Type of REST web services
	GET - Used to retrieve data from a server. - code implemented
	POST - Used to send (add) data to an API. – code implemented
	PUT - Used to modify a resource. - code implemented
	DELETE- Removes a record from the database - code implemented

Output for all products GET (don’t end URL with /)
http://localhost:8080/products
[
    {
        "id": 1,
        "name": "Samsung",
        "price": 20.12
    },
    {
        "id": 2,
        "name": "iPhone",
        "price": 40.99
    },
    {
        "id": 3,
        "name": "Realme",
        "price": 7.98
    },
    {
        "id": 5,
        "name": "Redme",
        "price": 14.56
    },
    {
        "id": 6,
        "name": "Nothing",
        "price": 39.94
    }
]
Output for product 1 GET
http://localhost:8080/products/1
{
    "id": 1,
    "name": "Samsung",
    "price": 20.12
}
Input for product PUT to modify record 6 in Body-Raw
http://localhost:8080/products

{
    "id": 6,
    "name": "iPhone 10",
    "price": 2022.12
}

DELETE http://localhost:8080/products/6 You will get status 200 = success
If you run the same again you will get 404 = Not Found

Select POST and type http://localhost:8080/products add record in Body-Raw and submit
Input for POST
{
    "id": 6,
    "name": "iPhone 10",
    "price": 2022.12
}

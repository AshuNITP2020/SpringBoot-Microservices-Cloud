# E-Commerce Microservices Platform

An e-commerce platform built using Spring Boot, providing a scalable and modular solution for online retail.


## Introduction
The E-Commerce Microservices Platform is designed to provide a robust and flexible solution for online retailers looking to manage their product catalog, customer orders. It leverages the power of microservices architecture to ensure scalability, fault tolerance, and easy maintainability.

## Features
- User authentication and authorization.
- Product catalog management with CRUD operations.
- Shopping cart functionality.
- Order processing and tracking.

## Technologies Used
- Spring Boot: Rapid application development framework.
- Spring Security: User authentication and authorization.
- Spring Data JPA: Database access and management.
- Netflix Eureka: Service discovery.
- Docker: Containerization for deployment.
- MongoDB:  database for persistent storage.

# Prerequisites
- Java 11 or higher.
- Maven.
- IDE configured with libraries like Lombok etc.
- PostMan
- Docker (for local container-based deployment).
- 

## Usage
1. Start the Eureka server for service discovery: `cd eureka-server && mvn spring-boot:run`
2. Start other microservices (product, order, Inventory etc.) similarly.
3. Access the web UI at: `http://localhost:default port`

## Architecture
The platform follows a microservices architecture, where each microservice focuses on a specific functionality. The services communicate with each other via REST APIs, and service discovery is managed by Eureka. Spring Cloud Gateway provides the API gateway for external access.

## Microservices
- **eureka-server:** Service registry and discovery server.
- **product-service:** Manages the product catalog.
- **order-service:** Handles customer orders and processing.
- **inventory-service:** Integrates with inventory service for availability tracing gateways.

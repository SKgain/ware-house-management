# 🏭 WareSafe — Warehouse Management System

![Java](https://img.shields.io/badge/Java-21-orange?style=flat-square&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?style=flat-square&logo=springboot)
![Spring Security](https://img.shields.io/badge/Security-Spring%20Security-6DB33F?style=flat-square&logo=springsecurity)
![JPA](https://img.shields.io/badge/ORM-Spring%20Data%20JPA-yellow?style=flat-square)
![Swagger](https://img.shields.io/badge/Docs-Swagger%20UI-85EA2D?style=flat-square&logo=swagger)
![Lombok](https://img.shields.io/badge/Lombok-Enabled-red?style=flat-square)

A structured **Warehouse Management REST API** built with Spring Boot. Manages warehouses, stock, suppliers, items, shipments, employees, customers, and transport vehicles — secured with role-based access control using Spring Security.

---

## 📌 Table of Contents

- [Overview](#-overview)
- [Features](#-features)
- [Tech Stack](#-tech-stack)
- [Architecture](#-architecture)
- [Entity Relationships](#-entity-relationships)
- [Security Model](#-security-model)
- [API Reference](#-api-reference)
- [Getting Started](#-getting-started)

---

## 🧩 Overview

WareSafe is a REST API for managing the full lifecycle of warehouse operations — from registering warehouses and tracking stock, to managing supplier items, scheduling shipments, and assigning employees and transport vehicles. Access to each domain is controlled by role, with five distinct roles each mapped to their own set of endpoints.

---

## ✨ Features

| Category | Capability |
|---|---|
| 🏭 Warehouse | Register, update, list, delete warehouses |
| 📦 Stock | Track item quantities per warehouse |
| 🚚 Shipment | Create shipments linking warehouse, employee, customer, vehicle, and schedule |
| 📋 Shipment Items | Assign items and quantities to shipments |
| 🏷️ Items | Manage inventory items linked to suppliers |
| 🤝 Suppliers | Register and manage suppliers |
| 👷 Employees | Manage employee profiles and roles |
| 🧑‍💼 Customers | Admit and manage customers |
| 🚗 Transport Vehicles | Register vehicles with driver and capacity info |
| 📅 Schedules | Create date/time slot schedules for shipments |
| 👑 Admin | Admin profile management |
| 🔒 Security | Role-based access control — 5 roles, endpoint-level enforcement |
| 📖 Docs | Swagger UI (publicly accessible) |

---

## 🛠️ Tech Stack

- **Java 21**, Spring Boot 3.x
- **Spring Security** — in-memory user store, role-based endpoint authorization
- **Spring Data JPA** — `JpaRepository` for all entities
- **Jackson** — `@JsonManagedReference` / `@JsonBackReference` for circular reference handling
- **Lombok** — `@Getter`, `@Setter`, `@RequiredArgsConstructor`, `@NoArgsConstructor`
- **SpringDoc OpenAPI** — Swagger UI at `/swagger-ui/**`

---

## 🏗️ Architecture

```
com.waresafe.warehousemanagement/
│
├── config/
│   └── SecurityConfig              # InMemoryUserDetailsManager + SecurityFilterChain
│
├── controller/
│   ├── AdminController             # /admin — add, update admin
│   ├── CustomerController          # /customer — CRUD
│   ├── EmployeeController          # /employee — CRUD
│   ├── ItemController              # /item — CRUD
│   ├── ScheduleController          # /schedule — CRUD
│   ├── ShipmentController          # /shipment — CRUD (links 5 entities)
│   ├── ShipmentItemController      # /shipment-item — CRUD
│   ├── StockController             # /stock — CRUD
│   ├── SupplierController          # /supplier — CRUD
│   ├── TransportVehicleController  # /transport-vehicle — CRUD
│   └── WarehouseController         # /warehouse — CRUD
│
├── entity/
│   ├── Admin
│   ├── Customer                    # OneToMany Shipments
│   ├── Employee                    # OneToMany Shipments
│   ├── Item                        # ManyToOne Supplier, OneToMany Stock + ShipmentItems
│   ├── Schedule                    # OneToMany Shipments
│   ├── Shipment                    # Central entity — links Warehouse, Employee, Customer, Vehicle, Schedule
│   ├── ShipmentItem                # ManyToOne Shipment + Item (join)
│   ├── Stock                       # ManyToOne Item + Warehouse
│   ├── Supplier                    # OneToMany Items
│   ├── TransportVehicle            # OneToMany Shipments
│   └── Warehouse                   # OneToMany Stock + Shipments
│
├── requestDTO/                     # Input DTOs (decoupled from entities)
│   ├── AdminRequestDTO
│   ├── CustomerRequestDTO
│   ├── EmployeeRequestDTO
│   ├── ItemRequestDTO
│   ├── ScheduleRequestDTO
│   ├── ShipmentRequestDTO
│   ├── ShipmentItemRequestDTO
│   ├── StockRequestDTO
│   ├── SupplierRequestDTO
│   ├── TransportVehicleRequestDTO
│   └── WarehouseRequestDTO
│
├── repository/                     # JpaRepository per entity
│   ├── AdminRepository
│   ├── CustomerRepository
│   ├── EmployeeRepository
│   ├── ItemRepository
│   ├── ScheduleRepository
│   ├── ShipmentRepository
│   ├── ShipmentItemRepository
│   ├── StockRepository
│   ├── SupplierRepository
│   ├── TransportVehicleRepository
│   └── WarehouseRepository
│
└── service/                        # Business logic per entity
    ├── AdminService
    ├── CustomerService
    ├── EmployeeService
    ├── ItemService
    ├── ScheduleService
    ├── ShipmentService             # Resolves 5 FK relationships before saving
    ├── ShipmentItemService
    ├── StockService
    ├── SupplierService
    ├── TransportVehicleService
    └── WarehouseService
```

---

## 🔗 Entity Relationships

```
Supplier
  └── OneToMany → Item
            ├── OneToMany → Stock → ManyToOne Warehouse
            └── OneToMany → ShipmentItem → ManyToOne Shipment

Warehouse
  ├── OneToMany → Stock
  └── OneToMany → Shipment

Shipment  ← Central entity
  ├── ManyToOne → Warehouse
  ├── ManyToOne → Employee
  ├── ManyToOne → Customer
  ├── ManyToOne → TransportVehicle
  ├── ManyToOne → Schedule
  └── OneToMany → ShipmentItem

Customer  → OneToMany → Shipment
Employee  → OneToMany → Shipment
Schedule  → OneToMany → Shipment
TransportVehicle → OneToMany → Shipment
```

`Shipment` is the most complex entity — it aggregates references to Warehouse, Employee, Customer, TransportVehicle, and Schedule in a single operation. `ShipmentService` resolves all five foreign keys via repository lookups before persisting.

Circular JSON serialization is handled throughout using `@JsonManagedReference` (parent side) and `@JsonBackReference` (child side).

---

## 🔒 Security Model

Spring Security with **in-memory user store** and **endpoint-level role enforcement**:

| Role | Accessible Endpoints |
|---|---|
| `ADMIN` | All endpoints (`/admin/**`, `/customer/**`, `/supplier/**`, `/employee/**`, `/warehouse/**`) |
| `CUSTOMER` | `/customer/**` |
| `SUPPLIER` | `/supplier/**` |
| `EMPLOYEE` | `/employee/**` |
| `WAREHOUSE` | `/warehouse/**` |
| Public | `/public/**`, `/swagger-ui/**`, `/v3/api-docs/**` |

Authentication via **HTTP Basic** and **Form Login**. Swagger UI is publicly accessible without authentication.

---

## 📡 API Reference

### 🏭 Warehouse — `/warehouse`
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/add-warehouse` | Register a warehouse |
| GET | `/get-all-warehouse` | List all warehouses |
| GET | `/get-warehouse/filter/{id}` | Get warehouse by ID |
| PUT | `/update-warehouse/{id}` | Update warehouse |
| DELETE | `/delete-warehouse/{id}` | Delete warehouse |

### 📦 Stock — `/stock`
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/add-stock` | Add stock (item + warehouse + quantity) |
| GET | `/get-all-stock` | List all stock entries |
| GET | `/get-stock/filter/{id}` | Get stock by ID |
| PUT | `/update-stock/{id}` | Update stock quantity |
| DELETE | `/delete-stock/{id}` | Delete stock entry |

### 🚚 Shipment — `/shipment`
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/add-shipment` | Create shipment (links 5 entities) |
| GET | `/get-all-shipment` | List all shipments |
| GET | `/get-shipment/{id}` | Get shipment by ID |
| PUT | `/update-shipment/{id}` | Update shipment status/date |
| DELETE | `/delete-shipment/{id}` | Delete shipment |

### 📋 Shipment Items — `/shipment-item`
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/add-shipment-item` | Link item + quantity to shipment |
| GET | `/get-all-shipment-item` | List all shipment items |
| GET | `/get-shipment-item/filter/{id}` | Get by ID |
| PUT | `/update-shipment-item/{id}` | Update quantity |
| DELETE | `/delete-shipment-item/{id}` | Remove from shipment |

### 🏷️ Item — `/item`
`POST /add-item` · `GET /get-all-item` · `GET /get-item/filter/{id}` · `PUT /update-item/{id}` · `DELETE /delete-item/{id}`

### 🤝 Supplier — `/supplier`
`POST /add-supplier` · `GET /get-all-supplier` · `PUT /update-profile/{id}` · `DELETE /delete-supplier/{id}`

### 👷 Employee — `/employee`
`POST /add-employee` · `GET /get-all-employee` · `GET /get-employee/filter/{id}` · `PUT /update-profile/{id}` · `DELETE /delete-employee/{id}`

### 🧑‍💼 Customer — `/customer`
`POST /add-customer` · `GET /get-all-customer` · `GET /get-customer/filter/{id}` · `PUT /update-profile/{id}` · `DELETE /delete-customer/{id}`

### 🚗 Transport Vehicle — `/transport-vehicle`
`POST /add-transport-vehicle` · `GET /get-all-transport-vehicle` · `GET /get-transport-vehicle/{id}` · `PUT /update-transport-vehicle/{id}` · `DELETE /delete-transport-vehicle/{id}`

### 📅 Schedule — `/schedule`
`POST /add-schedule` · `GET /get-all-schedule` · `GET /get-schedule/{id}` · `PUT /update-schedule/{id}` · `DELETE /delete-schedule/{id}`

### 👑 Admin — `/admin`
`POST /add-admin` · `PUT /update-admin-profile/{id}`

---

## 🚀 Getting Started

### Prerequisites
- Java 21+
- Maven 3.8+
- MySQL / PostgreSQL

### Run

```bash
git clone https://github.com/yourusername/warehouse-management.git
cd warehouse-management
mvn spring-boot:run
```

### Default Credentials

| Username | Password | Role |
|----------|----------|------|
| `admin` | `password2` | ADMIN |
| `customer` | `password1` | CUSTOMER |
| `supplier` | `password3` | SUPPLIER |
| `employee` | `password4` | EMPLOYEE |
| `warehouse` | `password5` | WAREHOUSE |

### Swagger UI
```
http://localhost:8080/swagger-ui/index.html
```

---

## 👨‍💻 Author

Built by **Saikat Kumar Gain** — a backend-focused Java developer passionate about clean architecture, scalable APIs, and developer-friendly codebases.

> 📬 Open to full-time backend / Java / Spring Boot roles.

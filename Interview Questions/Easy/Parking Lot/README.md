🔹 Step 1: Clarify Requirements
Functional Requirements
✅ Users should be able to park and unpark their vehicles.
✅ Different vehicle types (Bike, Car, Truck) require different parking spots.
✅ The system should track available and occupied spots.
✅ Payment should be calculated based on time spent in the parking lot.

Non-Functional Requirements
✅ The system should be scalable (support multiple parking lots).
✅ It should handle concurrent vehicle check-ins/check-outs.
✅ The system should support automated ticketing & payments.

🔹 Step 2: Identify Core Components
1️⃣ ParkingLot → Manages multiple parking floors.
2️⃣ ParkingFloor → Contains multiple parking spots.
3️⃣ ParkingSpot → Individual parking space (allocated to vehicle).
4️⃣ Vehicle → Represents a vehicle (Bike, Car, Truck).
5️⃣ Ticket → Issued when a vehicle enters, used for checkout.
6️⃣ Payment → Handles payment processing.
7️⃣ ParkingAttendant → Manages the operations.

🔹 Step 3: Choose Design Patterns
Factory Pattern → To create different types of parking spots.
Strategy Pattern → To calculate parking fees dynamically.
Singleton Pattern → To ensure one instance of ParkingLot per location.

🔹 Step 4: Class Diagram (Basic UML)

🔹 Step 5: Implementation

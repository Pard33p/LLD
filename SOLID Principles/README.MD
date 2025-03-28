# SOLID Principles in Software Design

The **SOLID** principles help developers design maintainable, scalable, and robust software. These principles improve code readability, reusability, and flexibility.

## 1. Single Responsibility Principle (SRP)

**A class should have only one reason to change.** Each class should have a single, well-defined responsibility.

### Example (Bad - Violating SRP):

```python
class Report:
    def __init__(self, data):
        self.data = data

    def generate_report(self):
        return f"Report Data: {self.data}"

    def save_to_file(self, filename):
        with open(filename, "w") as file:
            file.write(self.generate_report())

    def print_report(self):
        print(self.generate_report())
```

🚨 **Problem:** The `Report` class has multiple responsibilities:

- Generating the report
- Saving the report to a file
- Printing the report

### ✅ Fix (Following SRP):

```python
class Report:
    def __init__(self, data):
        self.data = data

    def generate_report(self):
        return f"Report Data: {self.data}"

class ReportSaver:
    def save_to_file(self, report: Report, filename):
        with open(filename, "w") as file:
            file.write(report.generate_report())

class ReportPrinter:
    def print_report(self, report: Report):
        print(report.generate_report())
```

✅ **Fix:** Separated concerns into `Report`, `ReportSaver`, and `ReportPrinter`.

---

## 2. Open/Closed Principle (OCP)

**A class should be open for extension but closed for modification.**

### Example (Bad - Violating OCP):

```python
class Discount:
    def apply_discount(self, amount, discount_type):
        if discount_type == "percentage":
            return amount * 0.90  # 10% discount
        elif discount_type == "fixed":
            return amount - 50  # Fixed discount
```

### ✅ Fix (Using Strategy Pattern):

```python
from abc import ABC, abstractmethod

class DiscountStrategy(ABC):
    @abstractmethod
    def apply_discount(self, amount):
        pass

class PercentageDiscount(DiscountStrategy):
    def apply_discount(self, amount):
        return amount * 0.90  # 10% discount

class FixedDiscount(DiscountStrategy):
    def apply_discount(self, amount):
        return amount - 50

def get_final_amount(amount, discount_strategy: DiscountStrategy):
    return discount_strategy.apply_discount(amount)
```

---

## 3. Liskov Substitution Principle (LSP)

**Subtypes must be substitutable for their base types without breaking functionality.**

### Example (Bad - Violating LSP):

```python
class Bird:
    def fly(self):
        print("Flying")

class Penguin(Bird):
    def fly(self):
        raise Exception("Penguins can't fly!")
```

### ✅ Fix:

```python
class Bird:
    pass

class FlyingBird(Bird):
    def fly(self):
        print("Flying")

class Penguin(Bird):
    def swim(self):
        print("Swimming")
```

---

## 4. Interface Segregation Principle (ISP)

**Clients should not be forced to depend on interfaces they do not use.**

### Example (Bad - Violating ISP):

```python
class Worker:
    def work(self):
        pass

    def eat(self):
        pass

class Robot(Worker):
    def work(self):
        print("Working")

    def eat(self):
        raise Exception("Robots don't eat!")
```

### ✅ Fix:

```python
class Workable:
    def work(self):
        pass

class Eatable:
    def eat(self):
        pass

class Human(Workable, Eatable):
    def work(self):
        print("Working")

    def eat(self):
        print("Eating")

class Robot(Workable):
    def work(self):
        print("Working")
```

---

## 5. Dependency Inversion Principle (DIP)

**High-level modules should not depend on low-level modules. Both should depend on abstractions.**

### Example (Bad - Violating DIP):

```python
class MySQLDatabase:
    def connect(self):
        print("Connecting to MySQL")

class UserService:
    def __init__(self):
        self.db = MySQLDatabase()  # Tight coupling

    def fetch_users(self):
        self.db.connect()
```

### ✅ Fix (Using Dependency Injection & Abstraction):

```python
from abc import ABC, abstractmethod

class Database(ABC):
    @abstractmethod
    def connect(self):
        pass

class MySQLDatabase(Database):
    def connect(self):
        print("Connecting to MySQL")

class PostgreSQLDatabase(Database):
    def connect(self):
        print("Connecting to PostgreSQL")

class UserService:
    def __init__(self, db: Database):
        self.db = db  # Loosely coupled

    def fetch_users(self):
        self.db.connect()
```

---

## Conclusion

By following **SOLID** principles:
✅ Code becomes **modular** and **maintainable**  
✅ Enhancements are **easier**  
✅ Code is **loosely coupled** and **scalable**

📌 **For more details, check out this blog post:** [SOLID Principles Explained with Code](https://blog.algomaster.io/p/solid-principles-explained-with-code)

---

This guide can be saved in your **GitHub repository** for easy reference. 🚀

# Point of Sale (POS) System - Java

Simple Point of Sale (POS) application with category, product, customer, transaction, and user authentication management features.

## 📋 Main Features
1. **Authentication**
   - Login & Logout with username and password.
2. **Category Management**
   - Add, edit, delete, and view product categories.
3. **Customer Management**
   - Manage customer data (CRUD).
4. **Product Management**
   - Manage products and their categories.
5. **Transaction System**
   - Payment with 3 methods:
     - 💵 Cash
     - 💳 Card
     - 📱 QRIS (Digital Payment)
6. **Transaction History**
   - View transaction history with date filter.
7. **User Profile**
   - Display the profile of the user who is currently logged in.

## 🚀 How to Run the Program

### Prerequisites
  - JDK 8+ (check with `javac -version`)

### 🔧 Step 1: Compile Program
Open terminal/CMD in **root project folder**, then run:
```bash
javac -cp "lib/mysql-connector-j-9.3.0.jar" src/Main.java -d build/
```

Note: The .class file will be saved in the out/ folder.

🏃 Step 3: Run the Program
```bash
java -cp "build:lib/mysql-connector-j-9.3.0.jar" Main
```

(Windows: Replace : with ;)

```bash
java -cp "build;lib/mysql-connector-j-9.3.0.jar" Main
```

💡 Example of Usage
Log in with the following credentials.
username: `admin`
password: `admin1234`

⚠️ Troubleshooting
Error "No suitable driver found"?
Make sure the path to the connector JAR is correct in the classpath (-cp).

INSERT INTO Users (user_id, address, contact, email, name, password, role)
VALUES
(1, '1234 Elm St', '123-456-7890', 'john.doe@example.com', 'John Doe', 'password123', 'Doctor'),
(2, '5678 Oak St', '098-765-4321', 'jane.doe@example.com', 'Jane Doe', 'password456', 'Patient'),
(3, '9101 Maple St', '111-222-3333', 'robert.smith@example.com', 'Robert Smith', 'password789', 'Patient'),
(4, '1122 Pine St', '444-555-6666', 'sarah.connor@example.com', 'Sarah Connor', 'password321', 'Doctor'),
(5,'Hospital','011379999','admin@hospital.com','Admin1','admin1@123','Admin');


INSERT INTO Patients (user_id, name, age, address, phone_number)
VALUES
(2, 'Jane Doe', 29, '5678 Oak St', '098-765-4321'),  -- User ID from user_entity table
(3, 'Robert Smith', 35, '9101 Maple St', '111-222-3333');  -- User ID from user_entity table


INSERT INTO Doctors (user_id, name, specialization, available)
VALUES
(1, 'Dr. John Doe', 'Cardiology', true),  -- User ID from user_entity table
(4, 'Dr. Sarah Connor', 'Neurology', false);  -- User ID from user_entity table


INSERT INTO Appointments ( appointment_date, patient_id, reason, doctor_id)
VALUES
( '2024-09-20',1, 'Pain', 1),
( '2024-09-21',2, 'Hard Pain',2);


INSERT INTO Shifts (doctor_id, shift_time, shift_day)
VALUES
(1, '09:00 AM - 05:00 PM', 'Monday'),
(1, '09:00 AM - 05:00 PM', 'Wednesday'),
(2, '06:00 PM - 02:00 AM', 'Tuesday'),
(2, '06:00 PM - 02:00 AM', 'Thursday');

INSERT INTO Inventory (item_name, category, quantity_in_stock, expiry_date, supplier_info)
VALUES
('Paracetamol', 'Medicine', 100, '2025-12-31', 'ABC Pharmaceuticals'),
('Syringe', 'Injection', 500, '2027-06-30', 'XYZ Medical Supplies'),
('Surgical Mask', 'Equipment', 1000, NULL, 'Medicare Supplies'),
('Aspirin', 'Medicine', 200, '2024-11-30', 'HealthFirst Pharma'),
('IV Drip Set', 'Equipment', 150, NULL, 'Global Medical Solutions');





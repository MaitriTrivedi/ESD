-- Insert dummy data into Domain table
INSERT INTO Domain (domain_id) VALUES
(1),
(2);

-- Insert dummy data into Specialisation table
INSERT INTO Specialisation (specialisation_id) VALUES
(1),
(2);

-- Insert dummy data into Placements table
INSERT INTO Placements (placement_id) VALUES
(1),
(2);

-- Insert dummy data into Grades table
INSERT INTO Grades (grade_id) VALUES
(1),
(2);

-- Insert dummy data into Departments table
INSERT INTO Departments (department_id) VALUES
(1),
(2);

-- Insert dummy data into Courses table
INSERT INTO Courses (course_code, name, description, year, term, faculty, credits, capacity) VALUES
('CS101', 'Introduction to Computer Science', 'Basic computer science course', 2024, 1, 'Dr. John Doe', 3, 50),
('CS102', 'Data Structures', 'Introduction to data structures', 2024, 2, 'Dr. Jane Smith', 4, 50);

-- Insert dummy data into Employees table
INSERT INTO Employees (first_name, last_name, email, title, photograph_path, department_id) VALUES
('Alice', 'Brown', 'alice.brown@example.com', 'Professor', '/images/alice.jpg', 1),
('Bob', 'Johnson', 'bob.johnson@example.com', 'Lecturer', '/images/bob.jpg', 2);

-- Insert dummy data into Students table
INSERT INTO Students (roll_number, first_name, last_name, email, photograph_path, cgpa, total_credits, graduation_year, domain_id, specialisation_id, placement_id, password) VALUES
(101, 'John', 'Doe', 'john.doe@example.com', '/images/john.jpg', 3.8, 120, 2024, 1, 1, 1, 'hashed_password_1'),
(102, 'Jane', 'Smith', 'jane.smith@example.com', '/images/jane.jpg', 3.6, 110, 2025, 2, 2, 2, 'hashed_password_2');

-- Insert dummy data into Course_Prerequisite table
INSERT INTO Course_Prerequisite (course_id, prerequisite_id, description) VALUES
(2, 1, 'CS101 is a prerequisite for CS102');

-- Insert dummy data into Student_Courses table
INSERT INTO Student_Courses (student_id, course_id, grade_id, comments) VALUES
(1, 1, 1, 'Excellent performance'),
(2, 2, 2, 'Good performance');

-- Insert dummy data into Faculty_Courses table
INSERT INTO Faculty_Courses (faculty, course_id) VALUES
(1, 1),
(2, 2);

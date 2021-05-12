package com.example.demo.DB;
import com.example.demo.models.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
        private String jdbcURL;
        private String jdbcUsername;
        private String jdbcPassword;
        private Connection jdbcConnection;
        public StudentDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
            this.jdbcURL = jdbcURL;
            this.jdbcUsername = jdbcUsername;
            this.jdbcPassword = jdbcPassword;
        }
        protected void connect() throws SQLException {
            if (jdbcConnection == null || jdbcConnection.isClosed()) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException e) {
                    throw new SQLException(e);
                }

                jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            }
        }
        protected void disconnect() throws SQLException {
            if (jdbcConnection != null && !jdbcConnection.isClosed()) {
                jdbcConnection.close();
            }
        }
        public boolean insertStudent(Student student) throws SQLException {
            String sql = "INSERT INTO student (firstName, lastName, gender) VALUES (?, ?, ?)";
            connect();
            PreparedStatement statement = jdbcConnection.prepareStatement(sql);
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getLastName());
            statement.setString(3, student.getGender());
            boolean rowInserted = statement.executeUpdate() > 0;
            statement.close();
            disconnect();
            return rowInserted;
        }
        public List<Student> listAllStudents() throws SQLException {
            List<Student> listStudent = new ArrayList<Student>();
            String sql = "SELECT * FROM student";
            connect();
            Statement statement = jdbcConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String gender = resultSet.getString("gender");
                Student Student = new Student(id, firstName, lastName, gender);
                listStudent.add(Student);
            }
            resultSet.close();
            statement.close();
            disconnect();
            return listStudent;
        }
        public boolean deleteStudent(Student student) throws SQLException {
            String sql = "DELETE FROM student where id = ?";
            connect();
            PreparedStatement statement = jdbcConnection.prepareStatement(sql);
            statement.setInt(1, student.getId().intValue());
            boolean rowDeleted = statement.executeUpdate() > 0;
            statement.close();
            disconnect();
            return rowDeleted;
        }
        public boolean updateStudent(Student Student) throws SQLException {
            String sql = "UPDATE student SET firstName = ?, lastName = ?, gender = ?";
            sql += " WHERE id = ?";
            connect();
            PreparedStatement statement = jdbcConnection.prepareStatement(sql);
            statement.setString(1, Student.getFirstName());
            statement.setString(2, Student.getLastName());
            statement.setString(3, Student.getGender());
            statement.setLong(4, Student.getId());
            boolean rowUpdated = statement.executeUpdate() > 0;
            statement.close();
            disconnect();
            return rowUpdated;
        }
        public Student getStudent(int id) throws SQLException {
            Student student = null;
            String sql = "SELECT * FROM student WHERE id = ?";
            connect();
            Long stdId = Long.valueOf(id + "");
            PreparedStatement statement = jdbcConnection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String gender = resultSet.getString("gender");
                student = new Student(stdId, firstName, lastName, gender);
            }
            resultSet.close();
            statement.close();
            return student;
        }
}

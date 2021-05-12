package com.example.demo.models;

public class Student {
        private Long id;
        private String firstName;
        private String lastName;
        private String gender;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public Student() {}

        public Student(String firstName, String lastName , String gender) {
            this.firstName = firstName;
            this.gender = gender;
            this.lastName = lastName;
        }
        public Student(Long id){
            this.id = id;
        }
        public Student(Long id, String firstName, String lastName , String gender) {
            this.id = id;
            this.firstName = firstName;
            this.gender = gender;
            this.lastName = lastName;
        }

}

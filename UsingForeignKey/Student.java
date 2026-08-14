package com.venki.UsingForiegnKey;

import java.util.Objects;

public class student {

    int id;
    String name;
    String gender;
    int age;
    String collage;
    String university;
    int tenthmarks;
    int twelfthmarks;
    int degreemarks;

    address addr;

    public student() {
        super();
    }

    public student(int id, String name, String gender, int age,
                   String collage, String university,
                   int tenthmarks, int twelfthmarks,
                   int degreemarks, address addr) {

        super();

        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.collage = collage;
        this.university = university;
        this.tenthmarks = tenthmarks;
        this.twelfthmarks = twelfthmarks;
        this.degreemarks = degreemarks;
        this.addr = addr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCollage() {
        return collage;
    }

    public void setCollage(String collage) {
        this.collage = collage;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public int getTenthmarks() {
        return tenthmarks;
    }

    public void setTenthmarks(int tenthmarks) {
        this.tenthmarks = tenthmarks;
    }

    public int getTwelfthmarks() {
        return twelfthmarks;
    }

    public void setTwelfthmarks(int twelfthmarks) {
        this.twelfthmarks = twelfthmarks;
    }

    public int getDegreemarks() {
        return degreemarks;
    }

    public void setDegreemarks(int degreemarks) {
        this.degreemarks = degreemarks;
    }

    public address getAddr() {
        return addr;
    }

    public void setAddr(address addr) {
        this.addr = addr;
    }

    @Override
    public int hashCode() {

        return Objects.hash(
                age,
                collage,
                degreemarks,
                gender,
                id,
                name,
                tenthmarks,
                twelfthmarks,
                university,
                addr
        );
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        student other = (student) obj;

        return age == other.age
                && Objects.equals(collage, other.collage)
                && degreemarks == other.degreemarks
                && Objects.equals(gender, other.gender)
                && id == other.id
                && Objects.equals(name, other.name)
                && tenthmarks == other.tenthmarks
                && twelfthmarks == other.twelfthmarks
                && Objects.equals(university, other.university)
                && Objects.equals(addr, other.addr);
    }

    @Override
    public String toString() {

        return "student [id=" + id
                + ", name=" + name
                + ", gender=" + gender
                + ", age=" + age
                + ", collage=" + collage
                + ", university=" + university
                + ", tenthmarks=" + tenthmarks
                + ", twelfthmarks=" + twelfthmarks
                + ", degreemarks=" + degreemarks
                + ", addr=" + addr + "]";
    }
}

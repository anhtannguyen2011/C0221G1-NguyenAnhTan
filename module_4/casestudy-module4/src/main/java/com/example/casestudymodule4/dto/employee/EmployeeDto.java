package com.example.casestudymodule4.dto.employee;

import com.example.casestudymodule4.model.entity.employee.AppUser;
import com.example.casestudymodule4.model.entity.employee.Division;
import com.example.casestudymodule4.model.entity.employee.EducationDegree;
import com.example.casestudymodule4.model.entity.employee.Position;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class EmployeeDto {

    private Integer employeeId;
    @NotEmpty(message = "Employee not empty")
    private String employeeName;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotEmpty(message = "Format YYYY/MM/YY and Not empty" )
    private String employeeBirthDay;
    @NotNull
    @Pattern(regexp = "^[\\d]{9}|[\\d]{12}$",
            message = "Customer ID Card must contain 9 or 12 digits!\n Example : 205145365")
    private String employeeIdCard;

    @Pattern(regexp = "^[\\d]+(\\.[\\d]+)?$", message = "Salary must be positive! Example : 750 or 750.0")
    private String employeeSalary;

    @Pattern(regexp = "^(091|090|\\(84\\)\\+90|\\(84\\)\\+91)[\\d]{7}$",
            message = "Phone start with 090 or 091 or (84)+90 or (84)+91 \nExample : 0905456121 or (84)+912365478")
    private String employeePhone;

    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$",
            message = "Email must be in abc@abc.abc format!")
    private String employeeEmail;


    private String employeeAddress;


    private Position position;


    private EducationDegree educationDegree;


    private Division division;


    private AppUser user;

    private Integer flag = 1;

    public EmployeeDto() {
    }
    public EmployeeDto(Integer employeeId, String employeeName, String employeeBirthDay, String employeeIdCard, String employeeSalary, String employeePhone, String employeeEmail, String employeeAddress, Position position, EducationDegree educationDegree, Division division, AppUser user, Integer flag) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeBirthDay = employeeBirthDay;
        this.employeeIdCard = employeeIdCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
        this.user = user;
        this.flag = flag;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthDay() {
        return employeeBirthDay;
    }

    public void setEmployeeBirthDay(String employeeBirthDay) {
        this.employeeBirthDay = employeeBirthDay;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public String getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(String employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }
}

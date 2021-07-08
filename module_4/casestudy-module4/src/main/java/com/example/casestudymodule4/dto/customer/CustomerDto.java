package com.example.casestudymodule4.dto.customer;

import com.example.casestudymodule4.model.entity.contract.Contract;
import com.example.casestudymodule4.model.entity.customer.Customer;
import com.example.casestudymodule4.model.entity.customer.CustomerType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CustomerDto implements Validator {
    private Integer customerId;
    @NotEmpty(message = "Customer Code can not be empty")
    @Pattern(regexp = "^KH-[\\d]{4}$",
            message = "Customer ID must be in KH-XXXX format !\n Example : KH-4569")
    private String customerCode;
    @NotEmpty(message = "Customer Name can not be empty")
    private String customerName;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotEmpty(message = "Format YYYY/MM/YY")
    private String customerBirthday;

    private boolean customerGender;
    @NotNull
    @Pattern(regexp = "^[\\d]{9}|[\\d]{12}$",
            message = "Customer ID Card must contain 9 or 12 digits!\n Example : 205145365")
    private String customerIdCard;
    @Pattern(regexp = "^(091|090|\\(84\\)\\+90|\\(84\\)\\+91)[\\d]{7}$",
            message = "Phone start with 090 or 091 or (84)+90 or (84)+91 \nExample : 0905456121 or (84)+912365478")
    private String customerPhone;
    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$",
            message = "Email must be in abc@abc.abc format!")
    private String customerEmail;

    private String customerAddress;

    private CustomerType customerType;

    private Integer flag = 1;

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    private List<Contract> contractList;

    public CustomerDto() {
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public boolean isCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(boolean customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;

        try {
            Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse(customerDto.getCustomerBirthday());
            Date currentDate = new Date();
            if (birthday.after(currentDate)){
                errors.rejectValue("customerBirthday", "cus.birthday.afterCurrent");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

package com.example.casestudymodule4.dto.contract;

import com.example.casestudymodule4.model.entity.contract.ContractDetail;
import com.example.casestudymodule4.model.entity.customer.Customer;
import com.example.casestudymodule4.model.entity.employee.Employee;
import com.example.casestudymodule4.model.entity.service.Service;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.Validation;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ContractDto implements Validator {

    private Integer contractId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotEmpty(message = "Format YYYY/MM/YY AND Not Empty")
    private String contractStartDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotEmpty(message = "Format YYYY/MM/YY AND Not Empty")
    private String contractEndDate;

    @Pattern(regexp = "^[\\d]+(\\.[\\d]+)?$", message = "Contract Deposit must be a number! \nExample : 1000 or 1000.0")
    private String contractDeposit;


    private double contractTotalMoney;


    private Service service;


    private Employee employee;


    private Customer customer;

    private Integer flag = 1;

    private List<ContractDetail> contractDetailList;

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public ContractDto() {
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public String getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(String contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public double getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(double contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<ContractDetail> getContractDetailList() {
        return contractDetailList;
    }

    public void setContractDetailList(List<ContractDetail> contractDetailList) {
        this.contractDetailList = contractDetailList;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contract = (ContractDto) target;
        try {
            Date start = new SimpleDateFormat("yyyy-MM-dd").parse(contract.getContractStartDate());
            Date end = new SimpleDateFormat("yyyy-MM-dd").parse(contract.getContractEndDate());

            Date currentDate = new Date();

            if (start.after(end)) {
                errors.rejectValue("contractStartDate", "con.start.afterEnd");
            }
            if (end.before(start)) {
                errors.rejectValue("contractEndDate", "con.end.beforeStart");
            }
            if (end.before(currentDate)){
                errors.rejectValue("contractEndDate", "con.end.beforeCurrent");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

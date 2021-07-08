package com.example.casestudymodule4.dto.service;

import com.example.casestudymodule4.model.entity.contract.Contract;
import com.example.casestudymodule4.model.entity.service.RentType;
import com.example.casestudymodule4.model.entity.service.ServiceType;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

public class ServiceDto {

    private Integer serviceId;
    @NotEmpty(message = "Not Empty")
    @Pattern(regexp = "^DV-[\\d]{4}$", message = "Service ID must be in DV-XXXX format !\nExample : DV-0306")
    private String serviceCode;

    @NotEmpty(message = "Not Empty")
    private String serviceName;
    @Min(value = 0,message = "Min Area = 0")
    private String serviceArea;
    @Min(value = 0,message = "Min Area = 0")
    private String serviceCost;

    @Min(value = 0,message = "Min Area = 0")
    private String serviceMaxPeople;


    private String standardRoom;


    private String description;

    @Min(value = 0,message = "Min Area = 0")
    private String poolArea;

    @Min(value = 0,message = "Min Area = 0")
    private String numberOfFloor;


    private RentType rentType;


    private ServiceType serviceType;


    private List<Contract> contractList;

    private Integer flag = 1;

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public ServiceDto() {
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(String serviceArea) {
        this.serviceArea = serviceArea;
    }

    public String getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(String serviceCost) {
        this.serviceCost = serviceCost;
    }

    public String getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(String serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(String numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }
}

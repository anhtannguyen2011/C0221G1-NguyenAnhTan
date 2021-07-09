package com.example.casestudymodule4.controller.contract;

import com.example.casestudymodule4.dto.contract.ContractDto;
import com.example.casestudymodule4.model.entity.contract.Contract;
import com.example.casestudymodule4.model.entity.customer.Customer;
import com.example.casestudymodule4.model.service.contract.IContractDetailService;
import com.example.casestudymodule4.model.service.contract.IContractService;
import com.example.casestudymodule4.model.service.customer.ICustomerService;
import com.example.casestudymodule4.model.service.employee.IEmployeeService;
import com.example.casestudymodule4.model.service.service.IServiceService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("employeeSession")
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    IEmployeeService employeeService;
    @Autowired
    ICustomerService customerService;
    @Autowired
    IServiceService serviceService;
    @Autowired
    IContractService contractService;

    @Autowired
    IContractDetailService contractDetailService;

    @GetMapping(value = "/create-contract")
    public String showCreate(Model model){
        model.addAttribute("employeeList",employeeService.listEmployee());
        model.addAttribute("customerList",customerService.findAll());
        model.addAttribute("serviceList",serviceService.findAll());
        model.addAttribute("contract",new ContractDto());
        return "/contract/create";
    }
    @PostMapping(value = "/create")
    public String createContract(@Validated  @ModelAttribute("contract") ContractDto contract, BindingResult bindingResult,Model model){
        new ContractDto().validate(contract,bindingResult);
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("employeeList",employeeService.listEmployee());
            model.addAttribute("customerList",customerService.findAll());
            model.addAttribute("serviceList",serviceService.findAll());
            model.addAttribute("contract",contract);
            return "/contract/create";
        }
        Contract contract1 = new Contract();
        BeanUtils.copyProperties(contract,contract1);
        this.contractService.save(contract1);
        return "/contract/create";
    }

    @GetMapping(value = "/")
    public String showListContract(@PageableDefault(value = 3)Pageable pageable,@RequestParam(name = "nameSearch") Optional<String> nameSearch,Model model) {
        Page<Contract> contractList;
        String keywordValue = "";
        if(nameSearch.isPresent()){
            keywordValue = nameSearch.get();
            model.addAttribute("keywordValue",keywordValue);
            model.addAttribute("contractList",this.contractService.searchEmployeeName(keywordValue,pageable));
        }else {
            contractList = this.contractService.findAllContract(pageable);
            model.addAttribute("contractList", contractList);
            model.addAttribute("keywordValue",keywordValue);
        }


        return "contract/list";
    }

    @GetMapping("/view")
    public String showViewDetail(@RequestParam int id,Model model){
        Contract contract = this.contractService.findById(id);
        model.addAttribute("contract",contract);
        model.addAttribute("detailList",this.contractDetailService.findAllByContract(contract));
        return "/contract/view_detail";
    }
    @GetMapping("/edit")
    public String showEditContract(@RequestParam int id, Model model){
        ContractDto contractDto = new ContractDto();
        Contract contract = this.contractService.findById(id);
        BeanUtils.copyProperties(contract,contractDto);
        model.addAttribute("contract",contractDto);
        model.addAttribute("employeeList",employeeService.listEmployee());
        model.addAttribute("customerList",customerService.findAll());
        model.addAttribute("serviceList",serviceService.findAll());
        return "contract/edit";
    }

    @PostMapping("/edit")
    public String editContract(@Validated @ModelAttribute("contract") ContractDto contract,BindingResult bindingResult,Model model){
        new ContractDto().validate(contract,bindingResult);
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("contract",contract);
            model.addAttribute("employeeList",employeeService.listEmployee());
            model.addAttribute("customerList",customerService.findAll());
            model.addAttribute("serviceList",serviceService.findAll());
            return "contract/edit";
        }
        Contract contract1 = new Contract();
        BeanUtils.copyProperties(contract,contract1);
        this.contractService.edit(contract1);
        return "redirect:/contract/";
    }

    @GetMapping("/delete")
    public String deleteContract(@RequestParam int id){
        this.contractService.deleleContract(id);
        return "redirect:/contract/";
    }

//    @GetMapping("/search")
//    public String searchContract(@PageableDefault(value = 2) Pageable pageable,@RequestParam("nameSearch") String nameSearch,Model model){
//        model.addAttribute("contractList",this.contractService.searchEmployeeName(nameSearch,pageable));
//        return "/contract/list";
//    }
}

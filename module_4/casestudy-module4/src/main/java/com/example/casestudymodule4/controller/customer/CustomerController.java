package com.example.casestudymodule4.controller.customer;

import com.example.casestudymodule4.dto.customer.CustomerDto;
import com.example.casestudymodule4.model.entity.customer.Customer;
import com.example.casestudymodule4.model.service.customer.ICustomerService;
import com.example.casestudymodule4.model.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;
    @GetMapping("/home")
    public String showhome(){
        return "homePage";
    }
    @GetMapping("/")
    public ModelAndView showListCustomer(@PageableDefault(value = 5)Pageable pageable, @RequestParam(name = "nameSearch") Optional<String> nameSearch){
        String keywordValue = "";
        Page<Customer> customerList;
        ModelAndView modelAndView = new ModelAndView("customer/list_customer");
        if(nameSearch.isPresent()){
            keywordValue = nameSearch.get();
        }
        customerList = this.customerService.findAllByNameBlogContaining(keywordValue,pageable);
        modelAndView.addObject("keywordValue",keywordValue);
        modelAndView.addObject("customerList",customerList);
        return modelAndView;
    }

    @GetMapping("/create-customer")
    public String showListCustomer(Model model){
        model.addAttribute("customerType",this.customerTypeService.findAll());
        model.addAttribute("customer",new CustomerDto());
        return "customer/create";
    }
    @PostMapping("/create")
    public String createCustomer(@Validated @ModelAttribute(name = "customer") CustomerDto customer, BindingResult bindingResult,Model model){
        new CustomerDto().validate(customer,bindingResult);
        Customer customer1 = new Customer();
        BeanUtils.copyProperties(customer,customer1);

        if(bindingResult.hasFieldErrors()) {
            model.addAttribute("customer",customer);
            model.addAttribute("customerType",this.customerTypeService.findAll());
            return "customer/create";
        }
        this.customerService.save(customer1);
        return "redirect:/customer/";
    }

    @GetMapping("/edit")
    public String showEdit(@RequestParam int id,Model model){
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(this.customerService.findById(id),customerDto);
        model.addAttribute("customer",customerDto);
        model.addAttribute("customerType",this.customerTypeService.findAll());
        return "customer/edit";
    }

    @PostMapping("/edit-customer")
    public String editCustomer(@Validated @ModelAttribute(name = "customer") CustomerDto customer,BindingResult bindingResult,Model model){
        new CustomerDto().validate(customer,bindingResult);
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("customerType",this.customerTypeService.findAll());
            model.addAttribute("customer",customer);
            return "customer/edit";
        }
        Customer customer1 = new Customer();
        BeanUtils.copyProperties(customer,customer1);
        this.customerService.edit(customer1);
        return "redirect:/customer/";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam int id){
        this.customerService.remove(id);
        return "redirect:/customer/";
    }

}

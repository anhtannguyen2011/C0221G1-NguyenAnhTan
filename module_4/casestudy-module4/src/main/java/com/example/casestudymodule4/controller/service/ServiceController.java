package com.example.casestudymodule4.controller.service;

import com.example.casestudymodule4.dto.service.ServiceDto;
import com.example.casestudymodule4.model.entity.contract.Contract;
import com.example.casestudymodule4.model.entity.service.Service;
import com.example.casestudymodule4.model.service.service.IRentTypeService;
import com.example.casestudymodule4.model.service.service.IServiceService;
import com.example.casestudymodule4.model.service.service.IServiceTypeService;
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

@Controller
@SessionAttributes("employeeSession")
@RequestMapping(value = "/service")
public class ServiceController {

    @Autowired
    IServiceService serviceService;
    @Autowired
    IServiceTypeService serviceTypeService;

    @Autowired
    IRentTypeService rentTypeService;

    @GetMapping(value = "/")
    public ModelAndView showListService(@PageableDefault(value = 3) Pageable pageable) {
        Page<Service> servicesList;
        ModelAndView modelAndView = new ModelAndView("service/list");
        servicesList = this.serviceService.findAllByService(pageable);
//        modelAndView.addObject("keywordValue", keywordValue);
        modelAndView.addObject("serviceList", servicesList);
        return modelAndView;
    }
    @GetMapping("/create-service")
    public String showCreate(Model model){
        model.addAttribute("serviceType",this.serviceTypeService.findAll());
        model.addAttribute("rentType",this.rentTypeService.findAll());
        model.addAttribute("service",new ServiceDto());
        return "service/create";
    }
    @PostMapping("/create")
    public String createService(@Validated  @ModelAttribute("service") ServiceDto service, BindingResult bindingResult,Model model){




        if(service.getStandardRoom() == null){
            service.setStandardRoom("0");
        }
        if(service.getDescription() == null){
            service.setDescription("0");
        }
        if(service.getPoolArea() == null){
            service.setPoolArea("0");
        }
        if(service.getNumberOfFloor() == null){
            service.setNumberOfFloor("0");
        }


        if(bindingResult.hasFieldErrors()){
            model.addAttribute("service",service);
            model.addAttribute("serviceType",this.serviceTypeService.findAll());
            model.addAttribute("rentType",this.rentTypeService.findAll());
           return  "service/create";
        }
        Service service1 = new Service();
        BeanUtils.copyProperties(service,service1);
        this.serviceService.save(service1);
        return "/service/create";
    }
}

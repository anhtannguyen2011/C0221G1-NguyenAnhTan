package com.example.casestudymodule4.controller.employee;

import com.example.casestudymodule4.dto.employee.EmployeeDto;
import com.example.casestudymodule4.model.entity.customer.Customer;
import com.example.casestudymodule4.model.entity.employee.AppUser;
import com.example.casestudymodule4.model.entity.employee.Employee;
import com.example.casestudymodule4.model.service.employee.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("employeeSession")
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;
    @Autowired
    IEducationDegreeService educationDegreeService;
    @Autowired
    IPositionService positionService;
    @Autowired
    IDivisionService divisionService;
    @Autowired
    IAppRoleService appRoleService;

    @Autowired
    IAppUserService appUserService;
    @Autowired
    BCryptPasswordEncoder cryptPasswordEncoder;
    @Autowired
    IUserRoleService userRoleService;


    @RequestMapping(value = "/create-employee")
    public String showCreate(Model model){
        model.addAttribute("educationList",educationDegreeService.findAdd());
        model.addAttribute("positionList",positionService.findAll());
        model.addAttribute("divisionList",divisionService.findAdd());
        model.addAttribute("employee",new EmployeeDto());
        model.addAttribute("user",new AppUser());
        model.addAttribute("roleList",appRoleService.findAll());
        return "/employee/create";
    }

    @PostMapping(value = "/create")
    public String createEmployee(@Validated @ModelAttribute("employee") EmployeeDto employee, BindingResult bindingResult, @ModelAttribute(name = "user") AppUser user, Model model,
                                 @RequestParam Long[] role){
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("educationList",educationDegreeService.findAdd());
            model.addAttribute("positionList",positionService.findAll());
            model.addAttribute("divisionList",divisionService.findAdd());
            model.addAttribute("employee",employee);
            model.addAttribute("user",new AppUser());
            model.addAttribute("roleList",appRoleService.findAll());
            return "/employee/create";
        }

        Employee employee1 = new Employee();
        BeanUtils.copyProperties(employee,employee1);

        for(AppUser appUser : appUserService.findAll()){
            if(appUser.getUserName().equals(user.getUserName())){
                model.addAttribute("message","Error");
                return "/employee/list_employee";
            }
        }
        user.setEncrytedPassword(cryptPasswordEncoder.encode(user.getEncrytedPassword()));
        user.setEnabled(true);
        appUserService.save(user);
        employee1.setUser(user);
        employeeService.save(employee1);
        for(int i = 0 ; i < role.length;i++){
            userRoleService.save(user,role[i].longValue());
        }
        model.addAttribute("message","Successfull");
        return "redirect:/employee/";
    }

    @GetMapping(value = "/")
    public ModelAndView showListEmployee(@PageableDefault(value = 5) Pageable pageable, @RequestParam(name = "nameSearch") Optional<String> nameSearch){
        String keywordValue = "";
        Page<Employee> employeeList;
        ModelAndView modelAndView = new ModelAndView("employee/list_employee");
        if(nameSearch.isPresent()){
            keywordValue = nameSearch.get();
        }
        employeeList = this.employeeService.findAll(pageable,keywordValue);
        modelAndView.addObject("keywordValue",keywordValue);
        modelAndView.addObject("employeeList",employeeList);
        return modelAndView;
    }
    @GetMapping("/edit")
    public String showEditEmployee(@RequestParam int id, Model model){
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employeeService.findById(id),employeeDto);
        model.addAttribute("employee",employeeDto);
        model.addAttribute("educationList",educationDegreeService.findAdd());
        model.addAttribute("positionList",positionService.findAll());
        model.addAttribute("divisionList",divisionService.findAdd());
        return "employee/edit";
    }
    @PostMapping(value = "/edit")
    public String editEmployee(@Validated @ModelAttribute("employee") EmployeeDto employee,BindingResult bindingResult,Model model){
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("employee",employee);
            model.addAttribute("educationList",educationDegreeService.findAdd());
            model.addAttribute("positionList",positionService.findAll());
            model.addAttribute("divisionList",divisionService.findAdd());
            return "employee/edit";
        }
        Employee employee1 = new Employee();
        BeanUtils.copyProperties(employee,employee1);
        this.employeeService.edit(employee1);
        return "redirect:/employee/";
    }
    @GetMapping(value = "/delete")
    public String deleteEmployee(@RequestParam int id){
        this.employeeService.delete(id);
        return "redirect:/employee/";
    }
}

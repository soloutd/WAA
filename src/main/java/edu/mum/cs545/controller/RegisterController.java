package edu.mum.cs545.controller;

import edu.mum.cs545.model.Role;
import edu.mum.cs545.model.User;
import edu.mum.cs545.service.RoleService;
import edu.mum.cs545.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RegisterController {
    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @RequestMapping(value ="/register" , method = RequestMethod.POST)
    public String saveUser(@Valid @ModelAttribute("user")User user, BindingResult br, RedirectAttributes ra, Model model) {

        if(br.hasErrors()) {
            List<Role> roles = roleService.getRoleNotAdmin();
            model.addAttribute("roles",roles);
            return "register";
        }
        user.setRole(roleService.getRoleById(user.getRole().getId()));
        userService.save(user);
        ra.addFlashAttribute("user",user);
        return "redirect:/login";
    }


}
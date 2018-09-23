package edu.mum.cs545.controller;

import edu.mum.cs545.exception.SaveErrorException;
import edu.mum.cs545.factory.CarFactory;
import edu.mum.cs545.model.Car;
import edu.mum.cs545.model.CarImage;
import edu.mum.cs545.model.User;
import edu.mum.cs545.model.dto.CarDto;
import edu.mum.cs545.service.CarService;
import edu.mum.cs545.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes("currentUser")
@RequestMapping(value = {"/cars"})
public class CarController {
    @Autowired
    private CarService carService;

    @Autowired
    ServletContext servletContext;

    @Autowired
    UserService userService;

    @RequestMapping(value = {"","/list"})
    public String listCars(Model model){
        model.addAttribute("cars",carService.findAll());
        return "cars";
    }


    @RequestMapping(value="/add" ,method = RequestMethod.GET)
    public String doAdd(@ModelAttribute("newCar") CarDto carDto, Model model){
        return "/addCar";
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String doSave(@Valid @ModelAttribute("newCar") CarDto carDto, BindingResult result, RedirectAttributes redirectAttributes, Model model, HttpSession httpSession){
        if(result.hasErrors()){
            return "/addCar";
        }
        User loginUser = new User();

        if(httpSession.getAttribute("currentUser") != null){
            loginUser = (User) httpSession.getAttribute("currentUser");
        }
        Car create = CarFactory.getInstance().createUserFromDto(carDto);
        create.setUser(loginUser);
        List<CarImage> imagesDb = new ArrayList<CarImage>();
        List<MultipartFile> images = carDto.getInputImages();
        String imageName = null;

        for (MultipartFile image : images) {
            if (image != null && !image.isEmpty()) {
                try {
                    manageDirectory("c:\\images");
                    imageName = (new Date()).getTime() + "_" + image.getOriginalFilename();
                    image.transferTo(new File("c:\\images\\" + imageName));
                    imagesDb.add(new CarImage(imageName));

                } catch (Exception e) {
//                    throw new FileNotFoundException("Unable to save image: " + image.getOriginalFilename());
                }
            }
        }
        create.setImages(imagesDb);
        if (imagesDb.size() > 0)
            create.setMainPicturePath(imagesDb.get(0).getUrl());
        try {
            create = carService.save(create);
        } catch (SaveErrorException s) {
            s.setMessage("Save error");
        }
        redirectAttributes.addFlashAttribute("car", create);
        return "redirect:/cars";
    }

    private void manageDirectory(String directoryName) {
        File directory = new File(directoryName);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }

}

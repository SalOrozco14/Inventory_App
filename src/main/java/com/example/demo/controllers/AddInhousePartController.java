package com.example.demo.controllers;

import ch.qos.logback.classic.util.StatusViaSLF4JLoggerFactory;
import com.example.demo.domain.InhousePart;
import com.example.demo.domain.Part;
import com.example.demo.service.InhousePartService;
import com.example.demo.service.InhousePartServiceImpl;
import com.example.demo.service.PartService;
import com.example.demo.service.PartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 *
 *
 *
 *
 */
@Controller
public class AddInhousePartController{
    @Autowired
    private ApplicationContext context;

    @GetMapping("/showFormAddInPart")
    public String showFormAddInhousePart(Model theModel){
        InhousePart inhousepart=new InhousePart();
        theModel.addAttribute("inhousepart",inhousepart);
        return "InhousePartForm";
    }

    @PostMapping("/showFormAddInPart")
    public String submitForm(@Valid @ModelAttribute("inhousepart") InhousePart part, BindingResult theBindingResult, Model theModel){
        theModel.addAttribute("inhousepart",part);

        //TASK G: enforce Inventory to be between the min and max
        if(part.getInv() > part.getMaxInv() || part.getInv() < part.getMinInv()) {
            theBindingResult.addError(new FieldError("inhousepart", "inv", "Inventory must be between the min: "+part.getMinInv() +" and max: "+part.getMaxInv()));
        }

        //TASK H: Inventory error if it's lower or higher of min/max
        if(part.getInv() > part.getMaxInv() ) {
            theBindingResult.addError(new FieldError("outsourcedpart", "inv", "Inventory can not be more then the Max: " +part.getMaxInv()));
        }

        if(part.getInv() < part.getMinInv() ) {
            theBindingResult.addError(new FieldError("outsourcedpart", "inv", "Inventory can not be less then the Min: " +part.getMinInv()));
        }

        if(theBindingResult.hasErrors()){
            return "InhousePartForm";
        }
        else{
        InhousePartService repo=context.getBean(InhousePartServiceImpl.class);
        InhousePart ip=repo.findById((int)part.getId());
        if(ip!=null)part.setProducts(ip.getProducts());
            repo.save(part);

        return "confirmationaddpart";}
    }

}

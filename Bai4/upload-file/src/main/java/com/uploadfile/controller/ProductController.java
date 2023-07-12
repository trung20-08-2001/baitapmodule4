package com.uploadfile.controller;

import com.uploadfile.model.Product;
import com.uploadfile.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
public class ProductController {
    @Autowired
    IProductService productService;

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("/index", "products", productService.findAll());
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Product product,MultipartFile imgFile) {
        String fileName = imgFile.getOriginalFilename();
        try {
            imgFile.transferTo((new File("C:/Users/trung/Codegym/Md4/Bai4/upload-file/src/main/webapp/WEB-INF/file/" + fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        product.setImage(fileName);
        productService.save(product);
        return "redirect:/";
    }
}

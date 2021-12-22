package controller;


import model.Category;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.category.ICategoryService;
import service.product.IProductService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService iCategoryService;

    @ModelAttribute("category")
    public Iterable<Category> categories() {
        return iCategoryService.findAll();
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/create-product")
    public String saveProduct(Product product, @RequestParam MultipartFile image1) {
            String fileName = image1.getOriginalFilename();
            try {
                FileCopyUtils.copy(image1.getBytes(),
                        new File("E:\\Personal\\C0821I1_LeVuDuy\\Module Web Back-end Development with Spring MVC 2.0\\spring-repository-crud-2table\\src\\main\\webapp\\WEB-INF\\img\\" + fileName));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            product.setImage(fileName);
            productService.save(product);
            return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        Optional<Product> product = productService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/product/edit");
        Product product1 = product.get();
        modelAndView.addObject("product", product1);
        return modelAndView;
    }

    @PostMapping("/edit-product")
    public String editProduct(Product product, @RequestParam MultipartFile image1) {
        String fileName = image1.getOriginalFilename();
        try {
            FileCopyUtils.copy(image1.getBytes(),
                    new File("E:\\Personal\\C0821I1_LeVuDuy\\Module Web Back-end Development with Spring MVC 2.0\\spring-repository-crud-2table\\src\\main\\webapp\\WEB-INF\\img\\" + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        product.setImage(fileName);
        productService.save(product);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id) {
        Optional<Product> product = productService.findById(id);
        if (product != null) {
            ModelAndView modelAndView = new ModelAndView("/product/delete");
            modelAndView.addObject("product", product);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-product")
    public String deleteProduct(Product product) {
        productService.remove(product.getId());
        return "redirect:/products";
    }

    @GetMapping("")
    public ModelAndView showList(String search, @PageableDefault(value = 5) Pageable pageable) {
        Page<Product> products;
        if (search == null) {
            products = productService.findAll(pageable);
        } else {
            products = productService.findByName(search, pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/product/list");
        modelAndView.addObject("products", products);
        modelAndView.addObject("search", search);
        return modelAndView;
    }
//
//    @PostMapping("")
//    public ModelAndView showListSorted(String Search, Pageable pageable) {
//        Iterable<Product> products = new ArrayList<>();
//        ModelAndView modelAndView = new ModelAndView("/product/list");
//        if (Search == null) {
//            products = productService.findAllByOrderByPrice();
//        } else {
//            products = productService.findByName(Search, pageable);
//        }
//        modelAndView.addObject("products", products);
//        return modelAndView;
//    }
}

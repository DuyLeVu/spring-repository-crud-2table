package controller;


import model.Category;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.category.ICategoryService;
import service.product.IProductService;
import service.product.ProductService;

import java.util.List;

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
    public String saveProduct(Product product) {
        productService.save(product);
        return "redirect:/products";
    }
    //    @GetMapping("create")
//    public ModelAndView createForm() {
//        ModelAndView modelAndView = new ModelAndView("create");
//        modelAndView.addObject("product", new Product());
//        return modelAndView;
//    }
//
//    @PostMapping("create")
//    public String create(Product product) {
//        iProductService.save(product);
//        return "redirect:/";
//    }
    @GetMapping("")
    public ModelAndView listCustomers() {
        Iterable<Product> products = productService.findAll();
        ModelAndView modelAndView = new ModelAndView("/product/list");
        modelAndView.addObject("products", products);
        return modelAndView;
    }
}

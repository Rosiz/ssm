package com.gdpi.ssm.controller;

import com.gdpi.ssm.domain.Product;
import com.gdpi.ssm.service.IProductService;
import com.gdpi.ssm.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @RequestMapping("/findAll")
    public String findAll(Map<String,Object> map) throws Exception {
        map.put("product",iProductService.findAll());
        return "product-list";

    }
    @RequestMapping("/toSave")
    public String toSave(Map<String,Object> map){
        map.put("product",new Product());
        return "product-add";
    }

    @RequestMapping("/save")
    public String save(Product product){
        System.out.println(product.getId());
        iProductService.save(product);
        return "redirect:/product/findAll";
    }

    @RequestMapping(value = "toUpdate",params = "id")
    public String toUpdate(String id,Map<String,Object> map){
        map.put("product",iProductService.select(id));
        return "product-update";

    }

    @RequestMapping("/update")
    public String update(Product product){
        System.out.println("修改方法执行了");
        iProductService.update(product);
        return "redirect:/product/findAll";
    }

    @RequestMapping(value = "/delete",params = "id")
    public String delete(String id){
        iProductService.delete(id);
        return "redirect:/product/findAll";
    }
}

package com.gdpi.ssm.controller;

import com.gdpi.ssm.service.IOrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOrdersService iOrdersService;
    //查询所有未分页
//    @RequestMapping("/findAll")
//    public String findAll(Map<String,Object> map) throws Exception {
//        map.put("orders",iOrdersService.findAll());
//        return "orders-list";
//    }

    @RequestMapping("/findAll")
    public String findAll(@RequestParam(name="page",required = true,defaultValue = "1") int page,
                          @RequestParam(name="size",required = true,defaultValue = "4") int size,
                          Map<String,Object> map) throws Exception {
        map.put("orders",new PageInfo(iOrdersService.findAll(page,size)));
        return "orders-page-list";
    }

    @RequestMapping(value = "/findById")
    public String findById(@RequestParam(name = "id",required = true) String ordersId,
                           Map<String,Object> map) throws Exception {
        map.put("orders",iOrdersService.findById(ordersId));
        return "orders-show";
    }
}

package com.gdpi.ssm.service.impl;

import com.gdpi.ssm.dao.IProductDao;
import com.gdpi.ssm.domain.Product;
import com.gdpi.ssm.service.IProductService;
import com.gdpi.ssm.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao iProductDao;

    @Override
    public List<Product> findAll() throws Exception {
        return iProductDao.findAll();
    }

    @Override
    public void save(Product product) {
        product.setId(DateUtil.getUUID());
        iProductDao.save(product);
    }

    @Override
    public Product select(String id) {
        return iProductDao.select(id);
    }

    @Override
    public void update(Product product) {
        iProductDao.update(product);
    }

    @Override
    public void delete(String id) {
        iProductDao.delete(id);
    }

}

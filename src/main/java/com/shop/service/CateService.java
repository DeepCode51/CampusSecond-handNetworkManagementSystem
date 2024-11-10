package com.shop.service;


import com.shop.entity.Category;
import com.shop.entity.CategoryExample;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CateService")
public interface CateService {
    public List<Category> selectByExample(CategoryExample example);
    public void insertSelective(Category category);

    public List<Category> selectByExampleLimit(CategoryExample digCategoryExample);

    public Category selectById(Integer category);

    public void updateByPrimaryKeySelective(Category category);

    public void deleteByPrimaryKey(Integer cateid);
}

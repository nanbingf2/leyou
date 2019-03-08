package com.leyou.service.item.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.leyou.common.vo.PageResult;
import com.leyou.service.item.mapper.BrandMapper;
import com.leyou.service.item.pojo.Brand;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author rogercw
 * @Date 2019/3/8
 * @Version 1.0
 **/
@Service
public class BrandService {

    @Autowired
    private BrandMapper brandMapper;

    /**
     * 根据关键字查询并进行分页和排序
     * @param page
     * @param size
     * @param sortBy
     * @param isDesc
     * @param key
     * @return
     */
    public PageResult<Brand> findBrandList(Integer page,Integer size,String sortBy,boolean isDesc,String key){
        //开始分页
        PageHelper.startPage(page,size);
        //根据条件查询
        Example example=new Example(Brand.class);
        if (StringUtils.isNotBlank(key)){
            Example.Criteria criteria = example.createCriteria();
            criteria.andLike("name","%"+key+"%").orEqualTo("letter",key);
        }
        //排序
        if (StringUtils.isNotBlank(sortBy)){
            String orderByClause=sortBy+(isDesc?" desc":" asc");
            example.setOrderByClause(orderByClause);
        }
        Page<Brand> result= (Page<Brand>) brandMapper.selectByExample(example);
        return new PageResult<>(result.getTotal(),result.getResult());
    }
}

package com.iamhanao.mall.service;

import com.iamhanao.mall.nosql.elasticsearch.document.EsProduct;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 商品管理搜索 Service
 */
public interface EsProductService {

    /**
     * 导入数据库中所有商品到 ES
     * @return
     */
    Integer importAll();

    /**
     * 根据 id 删除商品
     * @param id
     */
    void delete(Long id);

    /**
     * 根据 id 批量删除商品
     * @param ids
     */
    void delete(List<Long> ids);

    /**
     * 根据 id 创建商品
     * @param id
     * @return
     */
    EsProduct create(Long id);

    /**
     * 简单搜索商品
     * @param keyword
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize);

}

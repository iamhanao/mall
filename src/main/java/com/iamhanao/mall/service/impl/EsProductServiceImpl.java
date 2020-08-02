package com.iamhanao.mall.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.iamhanao.mall.dao.EsProductDao;
import com.iamhanao.mall.nosql.elasticsearch.document.EsProduct;
import com.iamhanao.mall.nosql.elasticsearch.repository.EsProductRepository;
import com.iamhanao.mall.service.EsProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 商品搜索管理Service实现类
 */
@Service
public class EsProductServiceImpl implements EsProductService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EsProductServiceImpl.class);

    @Autowired
    private EsProductDao esProductDao;
    @Autowired
    private EsProductRepository esProductRepository;

    @Override
    public Integer importAll() {
        List<EsProduct> esProductList = esProductDao.getAllEsProductList(null);
        Iterable<EsProduct> esProducts = esProductRepository.saveAll(esProductList);
        Iterator<EsProduct> iterator = esProducts.iterator();
        int result = 0;
        while (iterator.hasNext()){
            result++;
            iterator.next();
        }
        return result;
    }

    @Override
    public void delete(Long id) {
        esProductRepository.deleteById(id);
    }

    @Override
    public void delete(List<Long> ids) {
        if (!CollectionUtil.isEmpty(ids)) {
            List<EsProduct> list = new ArrayList<>();
            for (Long id : ids) {
                EsProduct esProduct = new EsProduct();
                esProduct.setId(id);
                list.add(esProduct);
            }
            esProductRepository.deleteAll(list);
        }
    }

    @Override
    public EsProduct create(Long id) {
        EsProduct result = null;
        List<EsProduct> list = esProductDao.getAllEsProductList(id);
        if (list!=null && list.size()>0) {
            result = list.get(0);
            esProductRepository.save(result);
        }
        return result;
    }

    @Override
    public Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize) {
        PageRequest pageable = PageRequest.of(pageNum, pageSize);
        return esProductRepository.findByNameOrSubTitleOrKeywords(keyword, keyword, keyword, pageable);
    }
}

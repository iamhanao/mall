package com.iamhanao.mall.controller;

import com.iamhanao.mall.common.api.CommonPage;
import com.iamhanao.mall.common.api.CommonResult;
import com.iamhanao.mall.mbg.model.PmsBrand;
import com.iamhanao.mall.service.PmsBrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("brand")
public class PmsBrandController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);

    @Autowired
    private PmsBrandService pmsBrandService;

    @GetMapping("listAll")
    @ResponseBody
    public CommonResult<List<PmsBrand>> getBrandList() {
        return CommonResult.success(pmsBrandService.listAllBrand());
    }

    @PostMapping("create")
    @ResponseBody
    public CommonResult createBrand(@RequestBody PmsBrand pmsBrand) {
        int count = pmsBrandService.createBrand(pmsBrand);
        CommonResult result;
        if (count > 0) {
            result = CommonResult.success(pmsBrand);
            LOGGER.debug("createBrand success: {}", pmsBrand);
        } else {
            result = CommonResult.failed("操作失败");
            LOGGER.debug("createBrand failed: {}", pmsBrand);
        }
        return result;
    }

    @PostMapping("update/{id}")
    @ResponseBody
    public CommonResult updateBrand(@PathVariable Long id, @RequestBody PmsBrand pmsBrand) {
        int count = pmsBrandService.updateBrand(id, pmsBrand);
        CommonResult result;
        if (count > 0) {
            result = CommonResult.success(pmsBrand);
            LOGGER.debug("updateBrand success: {}", pmsBrand);
        } else {
            result = CommonResult.failed("操作失败");
            LOGGER.debug("updateBrand failed: {}", pmsBrand);
        }
        return result;
    }

    @GetMapping("delete/{id}")
    @ResponseBody
    public CommonResult deleteBrand(@PathVariable Long id) {
        int count = pmsBrandService.deleteBrand(id);
        CommonResult result;
        if (count > 0) {
            result = CommonResult.success(null);
            LOGGER.debug("deleteBrand success: id{}", id);
        } else {
            result = CommonResult.failed("操作失败");
            LOGGER.debug("deleteBrand failed: id{}", id);
        }
        return result;
    }

    @GetMapping("list")
    @ResponseBody
    public CommonResult<CommonPage<PmsBrand>> list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                             @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        List<PmsBrand> list = pmsBrandService.listBrand(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @GetMapping("{id}")
    @ResponseBody
    public CommonResult<PmsBrand> brand(@PathVariable("id") Long id) {
        return CommonResult.success(pmsBrandService.getBrand(id));
    }
}

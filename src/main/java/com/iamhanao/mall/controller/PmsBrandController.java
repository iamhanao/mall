package com.iamhanao.mall.controller;

import com.iamhanao.mall.common.api.CommonResult;
import com.iamhanao.mall.mbg.model.PmsBrand;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/brand")
public class PmsBrandController {

    @GetMapping("listAll")
    public CommonResult<List<PmsBrand>> getBrandList() {
        return null;
    }
}

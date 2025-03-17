package com.putao_seo.api.controller;

import com.putao_seo.api.service.ReturnTestService;
import com.putao_seo.api.utils.BaseBizResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : tangtonglong
 * 2019/5/16 16:06
 * @return
 */
@CrossOrigin(origins = "*", maxAge = 3600) //支持跨域
@RestController
@RequestMapping(path = "/seoregion", produces = {"application/json;charset=UTF-8"})
public class TestQueryController {

    private static final Logger logger = LoggerFactory.getLogger(TestQueryController.class);

    @Autowired
    ReturnTestService returnTestService;

    @GetMapping(value = "/abc")
    public BaseBizResult<Map<String,Object>> queryShowCreateTable(@RequestParam(value = "regionCode",required = false)String regionCode,
                                                                  HttpServletRequest request) {

        try {
            Map<String, Object> map = new HashMap<String, Object>();
            returnTestService.showCreateTable();

            return BaseBizResult.success(map);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return BaseBizResult.error(e.getMessage());
        }

    }


}

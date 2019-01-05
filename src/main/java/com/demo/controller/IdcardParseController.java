package com.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.demo.domain.AreaDTO;
import com.demo.enums.IdcardResultEnum;
import com.demo.enums.ResultEnum;
import com.demo.exception.IdcardException;
import com.demo.exception.ServiceException;
import com.demo.result.ResultBody;
import com.demo.service.IdcardService;
import com.demo.utils.ResultUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: ${FILE_NAME}
 * @Package: com.demo.controller
 * @Description:
 * @author: Minsky
 * @date: 2018/5/19 15:26
 */
@RestController
@RequestMapping("idcard")
public class IdcardParseController {

    private static final Logger logger = LoggerFactory.getLogger(IdcardParseController.class);

    @Autowired
    IdcardService idcardService;

    @PostMapping("parse")
    public ResultBody parseIdcard(@RequestBody String idcardObject) throws ServiceException {
        logger.info("传入参数为：{}", idcardObject);
        JSONObject json = JSONObject.parseObject(idcardObject);
        String idcard = json.getString("idcard");

        // 身份证校验
        if (!idcardService.checkIdcard(idcard)) {
            throw new IdcardException(IdcardResultEnum.ERROR_IDCARD);
        }

        // 查询该编号对应地区
        String area = idcardService.getAreaInfo(idcard);
        if (StringUtils.isEmpty(area)) {
            throw new IdcardException(IdcardResultEnum.ERROR_AREACODE);
        }

        // 解析生日
        String birthday = idcardService.getBirthday(idcard);
        if (StringUtils.isEmpty(area)) {
            throw new IdcardException(IdcardResultEnum.ERROR_BIRTHDAY);
        }

        String gender = idcardService.getGender(idcard);

        AreaDTO areaDTO = getAreaDto(area, birthday, gender);
        return ResultUtil.success(areaDTO);
    }

    @GetMapping("generate")
    public ResultBody generateIdcard(){
        String validIdCard = idcardService.generateIdcard();
        Map<String,String> map  = new HashMap<>();
        map.put("idcard",validIdCard);
        return ResultUtil.success(map);
    }

    private AreaDTO getAreaDto(String area, String birthday, String gender) {
        AreaDTO dto = new AreaDTO();
        dto.setAreaName(area);
        dto.setBirthday(birthday);
        dto.setGender(gender);
        return dto;
    }
}

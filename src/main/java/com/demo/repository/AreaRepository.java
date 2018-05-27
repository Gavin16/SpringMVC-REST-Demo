package com.demo.repository;

import com.demo.domain.SysAreaDTO;


/**
 * @Title: ${FILE_NAME}
 * @Package: com.demo.repository
 * @Description:
 * @author: Minsky
 * @date: 2018/5/19 20:02
 */
public interface AreaRepository {

    SysAreaDTO getLocationByCodeLv3(long areaCode);

    SysAreaDTO getLocationByCodeLv2(long areaCode);

    Long getAreaCodeById(long id);
}

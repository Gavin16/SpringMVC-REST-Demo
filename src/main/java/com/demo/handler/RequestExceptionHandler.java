package com.demo.handler;

import com.demo.enums.ResultEnum;
import com.demo.exception.AddressException;
import com.demo.exception.IdcardException;
import com.demo.result.ResultBody;
import com.demo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.PrintWriter;
import java.io.StringWriter;

@ControllerAdvice
public class RequestExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(RequestExceptionHandler.class);

    @ExceptionHandler(value = IdcardException.class)
    @ResponseBody
    public ResultBody handleIdcardException(IdcardException e) {
        logger.error(e.getMsg());
        return ResultUtil.error(e.getCode(), e.getMsg());
    }

    @ExceptionHandler(value = AddressException.class)
    @ResponseBody
    public ResultBody handleAddressException(AddressException e) {
        logger.error(e.getMsg());
        return ResultUtil.error(e.getCode(), e.getMsg());
    }

    /**
     * 控制层返回的异常统一放在此处理
     * 匹配不同返回类型 返回不同的错误编码与描述
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultBody handleException(Exception e) {
        // 异常信息保存在 StringWriter 中
        StringWriter writer = new StringWriter();
        e.printStackTrace(new PrintWriter(writer));

        if (e instanceof AddressException) {
            AddressException addressException = (AddressException) e;
            logger.error(writer.getBuffer().toString());
            return ResultUtil.error(addressException.getCode(), addressException.getMsg());
        }

        if (e instanceof IdcardException) {
            IdcardException idcardException = (IdcardException) e;
            logger.error(writer.getBuffer().toString());
            return ResultUtil.error(idcardException.getCode(), idcardException.getMsg());
        }


        logger.error(writer.getBuffer().toString());
        return ResultUtil.error(ResultEnum.QUERY_FAILURE);

    }

}

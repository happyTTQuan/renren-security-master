/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.common.exception;

import io.renren.common.utils.AR;
import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理器
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestControllerAdvice
public class RRExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 处理自定义异常
	 */
	@ExceptionHandler(RRException.class)
	public AR handleRRException(RRException e){
		AR r = new AR();
		r.put("code", e.getCode());
		r.put("msg", e.getMessage());

		return r;
	}

	@ExceptionHandler(DuplicateKeyException.class)
	public AR handleDuplicateKeyException(DuplicateKeyException e){
		logger.error(e.getMessage(), e);
		return AR.error("数据库中已存在该记录");
	}

	@ExceptionHandler(AuthorizationException.class)
	public AR handleAuthorizationException(AuthorizationException e){
		logger.error(e.getMessage(), e);
		return AR.error("没有权限，请联系管理员授权");
	}

	@ExceptionHandler(Exception.class)
	public AR handleException(Exception e){
		logger.error(e.getMessage(), e);
		return AR.error();
	}
}

package com.Lizhiyu.player.handle;

import com.Lizhiyu.player.domain.Result;
import com.Lizhiyu.player.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lzy on 17-8-1.
 */
@ControllerAdvice
public class ExceptionHandle {

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Result handle(Exception e) {
		return ResultUtil.error(100,e.getMessage());
	}
}

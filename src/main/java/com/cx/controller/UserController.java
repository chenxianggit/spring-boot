package com.cx.controller;

import com.cx.request.GetUserRequest;
import com.cx.request.SaveUserRequest;
import com.cx.response.UserDTO;
import com.cx.service.UserService;
import com.cx.web.Response;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@Transactional
@RequestMapping("/user")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;
	
	/**
	 * 情绪列表接口
	 * @param request
	 * @return
	 */
	@ApiOperation(value="获取用户", notes="")
	@ResponseBody
	@RequestMapping(value = "getUser/{id}", method = RequestMethod.GET)
	public Response<UserDTO> getUser(@ApiParam(value = "用户主键") @PathVariable int id){
		return userService.getUser(id);
	}
	/**
	 * 情绪列表接口
	 * @param request
	 * @return
	 */
	@ApiOperation(value="获取用户", notes="")
	@ResponseBody
	@RequestMapping(value = "getUser1", method = RequestMethod.POST)
	public Response<UserDTO> getUser1(@RequestBody GetUserRequest request){
		return userService.getUser(request.getId());
	}
	@ModelAttribute
	/**
	 * 情绪列表接口
	 * @param user
	 * @return
	 */
	@ApiOperation(value="保存用户", notes="")
	@ResponseBody
	@RequestMapping(value = "saveUser", method = RequestMethod.POST)
	public Response saveUser(@RequestBody SaveUserRequest saveUserRequest){
		return userService.saveUser(saveUserRequest);
	}
}

package com.model2.mvc.service.user;

import java.util.HashMap;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.user.vo.UserVO;


public interface UserService {
	
	public void addUser(UserVO user) throws Exception;
	
	public UserVO loginUser(UserVO user) throws Exception;
	
	public UserVO getUser(String userId) throws Exception;
	
	public HashMap<String, Object> getUserList(Search searchVO) throws Exception;
	
	public void updateUser(UserVO user) throws Exception;
	
	public boolean checkDuplication(String userId) throws Exception;
	
}
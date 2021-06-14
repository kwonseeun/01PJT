package com.model2.mvc.service.user.impl;

import java.util.HashMap;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.user.UserService;
import com.model2.mvc.service.user.dao.UserDAO;
import com.model2.mvc.service.user.vo.UserVO;


public class UserServiceImpl implements UserService{
	
	private UserDAO userDAO;
	
	public UserServiceImpl() {
		userDAO=new UserDAO();
	}

	public void addUser(UserVO user) throws Exception {
		userDAO.insertUser(user);
	}

	public UserVO loginUser(UserVO user) throws Exception {
			UserVO dbUser=userDAO.findUser(user.getUserId());

			if(! dbUser.getPassword().equals(user.getPassword()))
				throw new Exception("로그인에 실패했습니다.");
			
			return dbUser;
	}

	public UserVO getUser(String userId) throws Exception {
		return userDAO.findUser(userId);
	}

	public HashMap<String,Object> getUserList(Search searchVO) throws Exception {
		return userDAO.getUserList(searchVO);
	}

	public void updateUser(UserVO user) throws Exception {
		userDAO.updateUser(user);
	}

	public boolean checkDuplication(String userId) throws Exception {
		boolean result=true;
		UserVO user=userDAO.findUser(userId);
		if(user != null) {
			result=false;
		}
		return result;
	}
}
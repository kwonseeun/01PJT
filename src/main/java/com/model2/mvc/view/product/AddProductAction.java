package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;
import com.model2.mvc.service.user.UserService;
import com.model2.mvc.service.user.impl.UserServiceImpl;

public class AddProductAction extends Action {

	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		ProductVO productvo =new ProductVO();
		productvo.setProdName(request.getParameter("prodName"));
		productvo.setProdDetail(request.getParameter("prodDetail"));
		productvo.setManuDate(request.getParameter("manufactureDay"));
		productvo.setPrice(Integer.parseInt(request.getParameter("price")));
		productvo.setFileName(request.getParameter("imageFile"));
		
		System.out.println(productvo);
		
		ProductService service=new ProductServiceImpl();
		service.addProduct(productvo);
		
		request.setAttribute("vo", productvo);
		
		return "forward:/product/addProduct.jsp";
	}
}
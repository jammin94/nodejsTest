package com.mvc.forrest.controller.wishlist;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.forrest.config.auth.LoginUser;
import com.mvc.forrest.service.domain.Page;
import com.mvc.forrest.service.domain.Search;
import com.mvc.forrest.service.domain.User;
import com.mvc.forrest.service.domain.WishList;
import com.mvc.forrest.service.rental.RentalService;
import com.mvc.forrest.service.user.UserService;
import com.mvc.forrest.service.wishlist.WishListService;


//==> ȸ������ Controller
@Controller
@RequestMapping("/wishlist/*")
public class WishListController {
	
	@Autowired
	public WishListService wishlistService;
	
	@Autowired
	public UserService userService;
	
	

//	@Autowired
//	public CouponService couponService;  ( 대기 )
	
	@Value("5")
	int pageUnit;
	
	@Value("10")
	int pageSize;
	
	
	
	//-----------장바구니 추가 ------------//
	
		@PostMapping("addWishList")
		public String addWishList( ) throws Exception{
			
			return null;
		}
	
	//-----------장바구니 삭제------------//
	
		@PostMapping("deleteWishList")
		public String deleteWishList( ) throws Exception{
			
			return null;
		}
			

	//-----------장바구니 리스트 화면------------//
		@GetMapping("getWishList")
		public String getWishListView(@ModelAttribute("search") Search search , Model model ) throws Exception{

			System.out.println("listRentalProfitView 테스트");
			
			if(search.getCurrentPage() ==0 ){
				search.setCurrentPage(1);
			}
			search.setPageSize(pageSize);
		
//			String userId = ((User)session.getAttribute("user")).getUserId();
			
			//세션에 있는 유저아이디 꺼낸다
			LoginUser loginUser= (LoginUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		    String userId= loginUser.getUser().getUserId();
		      
			System.out.println("userId:"+userId);
			
			//"세션아이디" 와 일치하는 것의 리스트들을 꺼낸다 (장바구니 목록)
			Map<String, Object> mapWishList =	wishlistService.getWishList(search,userId);
			System.out.println("listRentalProfitView 테스트2");
		    Page resultPage = new Page(search.getCurrentPage(), ((Integer)mapWishList.get("totalCount")).intValue(), pageUnit, pageSize );
			
			// Model 과 View 연결
			
			model.addAttribute("list", mapWishList.get("list"));
		model.addAttribute("resultPage", resultPage);
			model.addAttribute("search", search);
			
			System.out.println("모델리스트"+mapWishList.get("list"));
			
			return "wishList/wishList";
		}
		
		@PostMapping("getWishList")
		public String getWishList( ) throws Exception{
			
			return null;
		}
}
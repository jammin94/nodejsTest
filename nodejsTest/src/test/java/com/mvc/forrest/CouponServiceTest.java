package com.mvc.forrest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.mvc.forrest.service.coupon.CouponService;
import com.mvc.forrest.service.domain.Coupon;
import com.mvc.forrest.service.domain.OwnCoupon;
import com.mvc.forrest.service.domain.Search;
import com.mvc.forrest.service.domain.User;
import com.mvc.forrest.service.user.UserService;


//@RunWith(SpringJUnit4ClassRunner.class)


@SpringBootTest 
public class CouponServiceTest {

	@Autowired
	private CouponService couponService;
	
//	@Test
	public void testAddCoupon() throws Exception{
		Coupon c = new Coupon();
		Calendar cal = Calendar.getInstance();
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		Timestamp ts2 = new Timestamp(System.currentTimeMillis());
		
		cal.setTime(ts);
		cal.add(Calendar.DATE,30);
		ts2.setTime(cal.getTime().getTime());

		System.out.println("###ts : "+ts);
		System.out.println("###ts2 : "+ts2);
		
		c.setCouponCreDate(ts);
		c.setCouponDelDate(ts2);
		c.setCouponName("[TEST]테스트용 쿠폰");
		c.setDiscount(0.9);
		
		couponService.addCoupon(c);
		
	}

//	@Test
	public void testGetCoupon() throws Exception{
		Coupon c = new Coupon();
		c = couponService.getCoupon(4);
		
		System.out.println(c);
		
	}
	
//	@Test
	public void testGetCouponList() throws Exception{
		
		Search search = new Search();
		
		Map<String,Object> map = couponService.getCouponList(search);
		 
		System.out.println("\n"+map+"\n");
		System.out.println("\n"+map.get("list")+"\n");
	}
	
	@Test
	public void testGetOwnCouponList() throws Exception{
		
		User user = new User();
		String userId = "user01@naver.com"; 
		user.setUserId(userId);
		
		Map<String,Object> map = couponService.getOwnCouponList(user.getUserId());
		
		System.out.println("map : "+map);
		
	}
	

}
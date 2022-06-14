package com.mvc.forrest.service.domain;

import lombok.Data;


//@Data

//==>리스트화면을 모델링(추상화/캡슐화)한 Bean 
@Data

public class Search {
	
	///Field
	private int currentPage;
	private String searchCondition;
	private String searchKeyword;
	private String searchCategory;
	private String searchProductCondition;
	private int pageSize;
	//==> 리스트화면 currentPage에 해당하는 회원정보를 ROWNUM 사용 SELECT 위해 추가된 Field 
	//==> UserMapper.xml 의 
	//==> <select  id="getUserList"  parameterType="search"	resultMap="userSelectMap">
	//==> 참조
	private int endRowNum;
	private int startRowNum;
	private String orderCondition;
	

	
}
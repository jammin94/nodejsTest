package com.mvc.forrest.dao.old;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mvc.forrest.service.domain.Old;
import com.mvc.forrest.service.domain.Search;

@Repository
@Mapper
public interface OldDAO {
	public void addOld(Old old) throws Exception ;
	
	public Old getOld(int oldNo) throws Exception ;
	
	public void updateOld(Old old) throws Exception ;
	
	public void deleteOld(int oldNo) throws Exception ;	

	public int getTotalCount(Search search) throws Exception;

	public List<Old> getOldList(Search search) throws Exception; 
	
	public List<Old> getOldListForIndex( ) throws Exception;
	
}

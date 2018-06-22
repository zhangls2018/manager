package com.manager.mapper;

import java.util.List;

import com.manager.entity.TSUser;

public interface TSUserMapper {
	
	TSUser get(String id);
	
	TSUser getByName(String name);
	
	int insert(TSUser tSUser);
	
	int update(TSUser tSUser);
	
	int delete(String id);
	
	List<TSUser> listByIdList(List<String> idList);

}
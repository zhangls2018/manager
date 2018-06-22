package com.manager.mapper;

import java.util.List;

import com.manager.entity.TSAccount;

public interface TSAccountMapper {
	
	TSAccount get(String id);
	
	TSAccount getByName(String name);
	
	int insert(TSAccount tSAccount);
	
	int update(TSAccount tSAccount);
	
	int delete(String id);
	
	List<TSAccount> listByIdList(List<String> idList);

}
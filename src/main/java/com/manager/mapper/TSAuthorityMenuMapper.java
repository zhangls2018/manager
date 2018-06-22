package com.manager.mapper;

import java.util.List;

import com.manager.entity.TSAuthorityMenu;

public interface TSAuthorityMenuMapper {
	
	TSAuthorityMenu get(String id);
	
	int insert(TSAuthorityMenu tSAuthorityMenu);
	
	int update(TSAuthorityMenu tSAuthorityMenu);
	
	int delete(String id);
	
	List<TSAuthorityMenu> listByIdList(List<String> idList);
	
	List<TSAuthorityMenu> listAll();

	List<TSAuthorityMenu> listLv1();

}
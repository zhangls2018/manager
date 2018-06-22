package com.manager.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.manager.entity.TSAuthorityMenu;
import com.manager.mapper.TSAuthorityMenuMapper;

@Service
public class MenuService {
	
	@Autowired
	private TSAuthorityMenuMapper tsAuthorityMenuMapper;

	public List<TSAuthorityMenu> listAll(){
		List<TSAuthorityMenu> list = tsAuthorityMenuMapper.listAll();
		buildTree(list);
		return list;
	}

	public List<TSAuthorityMenu> listByUserId(String userId) {
		return null;
	}
	
	public List<TSAuthorityMenu> listLv1() {
		List<TSAuthorityMenu> list = tsAuthorityMenuMapper.listLv1();
		return list;
	}
	
	
	private List<TSAuthorityMenu> buildTree(List<TSAuthorityMenu> list){
		if(CollectionUtils.isNotEmpty(list)){
			Map<String,List<TSAuthorityMenu>> childrenMap = Maps.newHashMap();
			
			Iterator<TSAuthorityMenu> it = list.iterator();
			while (it.hasNext()) {
				TSAuthorityMenu menu = it.next();
				if(StringUtils.isNotBlank(menu.getParentId())){
					String parentId = menu.getParentId();
					if(childrenMap.containsKey(parentId)){
						childrenMap.get(parentId).add(menu);
					}else{
						childrenMap.put(parentId, Lists.newArrayList(menu));
					}
					it.remove();
				}
			}
			
			for (TSAuthorityMenu menu : list) {
				String id = menu.getId();
				List<TSAuthorityMenu> children = childrenMap.get(id);
				menu.setChildren(children);
			}
			
		}
		return list;
	}
}

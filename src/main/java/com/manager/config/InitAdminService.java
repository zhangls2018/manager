package com.manager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manager.entity.TSAccount;
import com.manager.entity.TSAuthorityMenu;
import com.manager.entity.TSUser;
import com.manager.enums.AccountStatusEnum;
import com.manager.enums.MenuTypeEnum;
import com.manager.mapper.TSAccountMapper;
import com.manager.mapper.TSAuthorityMenuMapper;
import com.manager.mapper.TSUserMapper;
import com.manager.util.Tools;

@Service
public class InitAdminService {
	
	public static final String admin = "admin";
	
	public static final String default_password = "111111";
	
	@Autowired
	private TSUserMapper tsUserMapper;
	
	@Autowired
	private TSAccountMapper tsAccountMapper;
	
	@Autowired
	private TSAuthorityMenuMapper tsAuthorityMenuMapper;

	@Transactional
	public void init() throws Exception{

		TSUser user = tsUserMapper.getByName(admin);
		if(user == null){
			System.err.println("-----init admin start----");
			/**
			 * 初始化admin账户，user，和菜单管理(入口)
			 */
			user = new TSUser();
			String userId = Tools.uuid();
			user.setId(userId);
			user.setName(admin);
			boolean isSuc = tsUserMapper.insert(user) == 1;
			if(isSuc){
				TSAccount account = new TSAccount();
				account.setId(Tools.uuid());
				account.setName(admin);
				account.setPassword(Tools.hexPassword(default_password));
				account.setStatus(AccountStatusEnum.valid.getCode());
				account.setUserId(userId);
				isSuc = tsAccountMapper.insert(account) == 1;
				if(isSuc){
					String menuId = Tools.uuid();
					TSAuthorityMenu menu = new TSAuthorityMenu();
					menu.setId(menuId);
					menu.setIcon("&#xe681;");
					menu.setName("系统管理");
					menu.setType(MenuTypeEnum.menu.getCode());
					menu.setUrl("#");
					isSuc = tsAuthorityMenuMapper.insert(menu) == 1;
					if(isSuc){
						TSAuthorityMenu menuItem = new TSAuthorityMenu();
						menuItem.setId(Tools.uuid());
						menuItem.setName("菜单列表");
						menuItem.setParentId(menuId);
						menuItem.setType(MenuTypeEnum.link.getCode());
						menuItem.setUrl("/menu/list");
						
						isSuc = tsAuthorityMenuMapper.insert(menuItem) == 1;
						if(isSuc){
							System.err.println("-----init admin end----");
							return;
						}
					}
				}
			}
			throw new RuntimeException("----insert admin fail");
			
		}else{
			System.err.println("----admin is exist");
		}
	}

	public static boolean isAdmin(String uname){
		return admin.equals(uname);
	}
}

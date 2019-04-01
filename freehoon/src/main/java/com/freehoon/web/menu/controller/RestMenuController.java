package com.freehoon.web.menu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.freehoon.web.menu.model.MenuVO;
import com.freehoon.web.menu.service.MenuService;

@RestController
@RequestMapping("/restMenu")
public class RestMenuController {

	private static final Logger logger = LoggerFactory.getLogger(RestMenuController.class);
	
	@Inject
	private MenuService menuService;
	
	@RequestMapping(value = "/getMenuList", method = RequestMethod.POST)
	public Map<String, Object> getMenuList() throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		
		List<MenuVO> menuList = new ArrayList<MenuVO>();
		
		try {
			menuList = menuService.getMenuList();
			result.put("status", "OK");
			result.put("menuList", menuList);
		} catch (Exception e) {
			result.put("status",  "False");
			logger.info(e.getMessage());
		}
		
		return result;
	}
	
	@RequestMapping(value = "/saveMenu", method = RequestMethod.POST)
	public Map<String, Object> saveMenu(MenuVO menuVO) throws Exception	{
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		logger.info("menuVO : " + menuVO.toString());
		
		try {
			menuService.saveMenu(menuVO);
			result.put("status",  "OK");
		} catch (Exception e) {
			result.put("status",  "False");
			logger.info(e.getMessage());
		}
		return result;
	}
	
}

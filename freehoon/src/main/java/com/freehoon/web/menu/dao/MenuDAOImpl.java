package com.freehoon.web.menu.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.freehoon.common.Search;
import com.freehoon.web.menu.model.MenuVO;

@Repository
public class MenuDAOImpl implements MenuDAO {
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<MenuVO> getMenuList(Search search) throws Exception {
		return sqlSession.selectList("com.freehoon.web.menu.menuMapper.getMenuList", search);
	}

	@Override
	public int saveMenu(MenuVO menuVO) throws Exception {
		return sqlSession.insert("com.freehoon.web.menu.menuMapper.insertMenu", menuVO);
	}

	@Override
	public int updateMenu(MenuVO menuVO) throws Exception {
		return sqlSession.update("com.freehoon.web.menu.menuMapper.updateMenu", menuVO);
	}

	@Override
	public int deleteMenu(String code) throws Exception {
		return sqlSession.delete("com.freehoon.web.menu.menuMapper.deleteMenu", code);
	}

	@Override
	public int getMenuListCnt(Search search) throws Exception {
		return sqlSession.selectOne("com.freehoon.web.menu.menuMapper.getMenuListCnt", search);
	}
	

}

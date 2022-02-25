package com.menu.menuserver.service;

import com.menu.menuserver.model.Menu;
import com.menu.menuserver.model.User;
import com.menu.menuserver.repository.MenuRepository;
import com.menu.menuserver.repository.projection.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuRepository menuRepository;

    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public Menu saveMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public void deleteMenu(Long id) {
        menuRepository.deleteById(id);
    }

    @Override
    public Optional<Menu> findById(Long menuId) {
        return menuRepository.findById(menuId);
    }

    @Override
    public Optional<MenuItem> findMenuById(Long menuId)
    {
        return menuRepository.findSingleMenuById(menuId);
    }

    @Override
    public List<MenuItem> findMenusByUserId(Long userId) {
        return menuRepository.findAllMenusByUserId(userId);
    }
}

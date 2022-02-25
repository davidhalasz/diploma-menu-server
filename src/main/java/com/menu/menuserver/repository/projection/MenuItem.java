package com.menu.menuserver.repository.projection;

public interface MenuItem {
    Long getId();
    Long getUserId();
    String getCompanyName();
    String[] getTypes();
    String[] getProducts();
    Integer[] getPrices();
}

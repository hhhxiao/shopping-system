package com.xhy.shoppingsystem.service;


import com.xhy.shoppingsystem.mapper.ItemMapper;
import com.xhy.shoppingsystem.pojo.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
@Service("ItemService")
public class ItemServiceImpl implements ItemService{

    Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);
    @Autowired
    private ItemMapper itemMapper;

    @Override
    public ArrayList<Item> getAllItem() {
        return itemMapper.getAllItem();
    }

    @Override
    public ArrayList<Item> selectItemsByName(String name) {
        return itemMapper.selectItemsByName(name);
    }

    @Override
    public boolean addItem(Item item) {
        return itemMapper.addItem(item);
    }

    @Override
    public Item selectItemById(Integer id) {
        return itemMapper.selectItemById(id);
    }

    @Override
    public boolean deleteItemById(Integer id) {
        return itemMapper.deleteItemById(id);
    }

    @Override
    public void updateItemsInRepository(Item item) {
        itemMapper.updateItemsInRepository(item);
    }


}

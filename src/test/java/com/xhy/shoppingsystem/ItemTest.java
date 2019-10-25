package com.xhy.shoppingsystem;

import com.xhy.shoppingsystem.mapper.ItemMapper;
import com.xhy.shoppingsystem.pojo.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemTest {
    @Autowired
    private ItemMapper itemMapper;

    @Test
    public void getAllItem() {
        ArrayList<Item> allItem = itemMapper.getAllItem();
        for (Item item : allItem) {
            System.out.println(item);
        }
    }

    @Test
    public void selectItemsByName() {//
        ArrayList<Item> pens = itemMapper.selectItemsByName("pen");
        for (Item pen : pens) {
            System.out.println(pen);
        }
    }

    @Test
    public void addItem() {
        Item item = new Item();
        item.setItemName("phone");
        item.setFactory("huaWei");
        item.setPrice(3000.0);
        item.setStock(50);
        System.out.println(itemMapper.addItem(item));
    }
}

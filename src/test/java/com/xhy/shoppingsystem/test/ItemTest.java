package com.xhy.shoppingsystem.test;

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
    public void getAllItem(){
        ArrayList<Item> allItem = itemMapper.getAllItem();
        for (Item item : allItem) {
            System.out.println(item);
        }
    }

    @Test
    public void selectItemsByName(){
        ArrayList<Item> pens = itemMapper.selectItemsByName("pen");
        for (Item pen : pens) {
            System.out.println(pen);
        }
    }

    @Test
    public void addItem(){
        Item item=new Item();
        item.setItemName("phone");
        item.setFactory("huaWei");
        item.setPrice(3000.0);
        item.setStock(50);
        System.out.println(itemMapper.addItem(item));
    }

    @Test
    public void deleteItemById(){
        System.out.println(itemMapper.deleteItemById(1));
    }

    @Test
    public void selectItemById(){
        Item item = itemMapper.selectItemById(5);
        System.out.println(item);
    }

    @Test
    public void updateItemsInRepository(){
        Item item=new Item();
        item.setItemId(13);
        item.setStock(1000);
        itemMapper.updateItemsInRepository(item);

    }

    @Test
    public void updateItemSold(){
        Item item=new Item();
        item.setSold(500);
        item.setItemId(10);
        itemMapper.updateItemSold(item);
    }
}

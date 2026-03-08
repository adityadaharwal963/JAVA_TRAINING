package org.example;

import java.util.HashMap;
import java.util.Map;

public class Product {
    String name;
    String description;
    int price;
    public Product(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    static void test(){
        HashMap<String,String[]> products =  new HashMap<String,String[]>();
        products.put("name",new String[]{"name","description","price"});
        products.put("description",new String[]{"description","price"});
        products.put("price",new String[]{"price","description"});
        products.put("name",new String[]{"name","description","price"});
        for (Map.Entry<String,String[]> p : products.entrySet()) {
            String name = p.getKey();
            String[] description = p.getValue();
            /*
            <h3>Name : <%= name %> </h3>
            <h3>Price : <%= description[0] %> </h3>
            <h3>Desc : <%= description[1] %> </h3>
             */
        }
    }
}

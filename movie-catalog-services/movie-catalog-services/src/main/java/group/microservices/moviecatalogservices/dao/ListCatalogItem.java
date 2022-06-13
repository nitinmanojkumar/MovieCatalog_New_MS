package group.microservices.moviecatalogservices.dao;

import java.util.List;

public class ListCatalogItem {
    private List<CustomCatalogItem> listCustomCatalogItem;

    public List<CustomCatalogItem> getListCatalogItem() {
        return listCustomCatalogItem;
    }

    public void setListCatalogItem(List<CustomCatalogItem> listCustomCatalogItem) {
        this.listCustomCatalogItem = listCustomCatalogItem;
    }
}

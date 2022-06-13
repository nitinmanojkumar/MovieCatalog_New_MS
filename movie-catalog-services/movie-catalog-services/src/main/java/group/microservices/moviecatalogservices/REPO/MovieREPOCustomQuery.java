package group.microservices.moviecatalogservices.REPO;

import java.util.List;

import group.microservices.moviecatalogservices.dao.CatalogItem;

//Method needs to be further modified in IMPL class should alone be provided here
public interface MovieREPOCustomQuery {
	
	List<CatalogItem> findAllByProduction(String productionName);
	
		
}
	
package group.microservices.moviecatalogservices.REPO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Service;

import group.microservices.moviecatalogservices.dao.CatalogItem_toREPO;
import group.microservices.moviecatalogservices.dao.ResponseClass;

//Method needs to be further modified in IMPL class should alone be provided here
public interface MovieREPOCustomQuery {
	
	List<CatalogItem_toREPO> findAllByProduction(String productionName);
	
		
}
	
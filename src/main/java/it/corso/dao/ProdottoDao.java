package it.corso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.corso.model.Prodotto;

//estendiamo le operazioni crud (tipo di dato gestito, tipo dell'id)
public interface ProdottoDao extends CrudRepository<Prodotto, Integer>{
	List<Prodotto> findByDescrizione(String descrizione);
	
	@Query (value = "SELECT * FROM prodotti where descrizione = :d",
			nativeQuery = true)
	List<Prodotto> dammiProdotti(@Param("d")String desc);
}

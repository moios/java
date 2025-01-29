package persistence.crud;

import java.util.List;
import java.util.Optional;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import persistence.entity.Producto;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer>{
	
	//@Query(value = "select * from productos where id_categoria = ?", nativeQuery = true)
	//List<Producto> getByCategoria(int idCategoria);
	
	//Query Methods
	List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);
	
	Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
	
	
	
	
	
}

package persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import persistence.crud.ProductoCrudRepository;
import persistence.entity.Producto;

@Repository //interactua con la BD, puede tambien usarse @Component
public class ProductoRepository {
	//de la interfaz
	private ProductoCrudRepository productoCrudRepository;
	
	//recuperar lista de producto
	public List<Producto> getAll(){
		return (List<Producto>) productoCrudRepository.findAll();
	}
	
	public List<Producto> getByCategoria(int idCategoria){
		return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
	}
	
	public Optional<List<Producto>> getEscasos(int cantidad, boolean estado){
		return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, estado);
	}
	
	public Optional<Producto> getProducto(int id){
		return productoCrudRepository.findById(id);
	}
	
	public Producto saveProducto(Producto p) {
		return productoCrudRepository.save(p);
	}
	
	public void deleteProducto(int id) {
		productoCrudRepository.deleteById(id);
	} 
}

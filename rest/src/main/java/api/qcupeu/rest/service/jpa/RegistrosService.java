package api.qcupeu.rest.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.qcupeu.rest.entity.Registros;
import api.qcupeu.rest.repository.RegistrosRepository;
import api.qcupeu.rest.service.IRegistrosService;

@Service
public class RegistrosService implements IRegistrosService {
	
   @Autowired
	private RegistrosRepository repoRegistros;
    public  List<Registros> buscarTodos(){
    return repoRegistros.findAll();
    }
    public void guardar(Registros registro) {
    	repoRegistros.save(registro);
    }
    public void modificar(Registros registro) {
    	repoRegistros.save(registro);
    }
    public Optional<Registros> buscarId(Integer id){ 
      return repoRegistros.findById(id);
    }
    public void eliminar (Integer id) {
    	repoRegistros.deleteById(id);
    }
}

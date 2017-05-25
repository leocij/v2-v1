package v2v1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import v2v1.entity.Controle;
import v2v1.exception.ControleNotFoundException;
import v2v1.repository.ControleRepository;

@Service
public class ControleService {

	@Autowired
	private ControleRepository controleRepository;

	@Transactional(readOnly = true)
	public List<Controle> findAll() {
		return controleRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Controle findById(Long id) {
		if (!exist(id)) {
			throw new ControleNotFoundException("Controle com esse id não existe: " + id);
		}
		return controleRepository.findOne(id);
	}

	@Transactional(readOnly = true)
	private boolean exist(Long id) {
		return controleRepository.exists(id);
	}

	@Transactional(readOnly = false)
	public Controle save(Controle build) {
		if (build.getId() != null && exist(build.getId())) {
			throw new ControleNotFoundException("Controle com esse id não existe: " + build.getId());
		}
		return controleRepository.save(build);
	}

	@Transactional(readOnly = false)
	public Controle update(Controle build) {
		if (!exist(build.getId())) {
			throw new ControleNotFoundException("Controle com esse id não existe: " + build.getId());
		}
		return controleRepository.save(build);
	}

	@Transactional(readOnly = false)
	public void delete(Controle controle) {
		controleRepository.delete(controle);
	}

}

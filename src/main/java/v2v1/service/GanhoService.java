package v2v1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import v2v1.entity.Ganho;
import v2v1.exception.GanhoNotFoundException;
import v2v1.repository.GanhoRepository;

@Service
public class GanhoService {

	@Autowired
	private GanhoRepository ganhoRepository;

	@Transactional(readOnly = true)
	public List<Ganho> findAll() {
		return ganhoRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Ganho findById(Long id) {
		if (!exist(id)) {
			throw new GanhoNotFoundException("Ganho com esse id não existe: " + id);
		}
		return ganhoRepository.findOne(id);
	}

	@Transactional(readOnly = true)
	private boolean exist(Long id) {
		return ganhoRepository.exists(id);
	}

	@Transactional(readOnly = false)
	public Ganho save(Ganho build) {
		if (build.getId() != null && exist(build.getId())) {
			throw new GanhoNotFoundException("Ganho com esse id não existe: " + build.getId());
		}
		return ganhoRepository.save(build);
	}

	@Transactional(readOnly = false)
	public Ganho update(Ganho build) {
		if (!exist(build.getId())) {
			throw new GanhoNotFoundException("Ganho com esse id não existe: " + build.getId());
		}
		return ganhoRepository.save(build);
	}

	@Transactional(readOnly = false)
	public void delete(Ganho ganho) {
		ganhoRepository.delete(ganho);
	}

}

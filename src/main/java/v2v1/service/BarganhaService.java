package v2v1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import v2v1.entity.Barganha;
import v2v1.exception.BarganhaNotFoundException;
import v2v1.repository.BarganhaRepository;

@Service
public class BarganhaService {

	@Autowired
	private BarganhaRepository barganhaRepository;

	@Transactional(readOnly = true)
	public List<Barganha> findAll() {
		return barganhaRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Barganha findById(Long id) {
		if (!exist(id)) {
			throw new BarganhaNotFoundException("Barganha com esse id não existe: " + id);
		}
		return barganhaRepository.findOne(id);
	}

	@Transactional(readOnly = true)
	private boolean exist(Long id) {
		return barganhaRepository.exists(id);
	}

	@Transactional(readOnly = false)
	public Barganha save(Barganha build) {
		if (build.getId() != null && exist(build.getId())) {
			throw new BarganhaNotFoundException("Barganha com esse id não existe: " + build.getId());
		}
		return barganhaRepository.save(build);
	}

	@Transactional(readOnly = false)
	public Barganha update(Barganha build) {
		if (!exist(build.getId())) {
			throw new BarganhaNotFoundException("Barganha com esse id não existe: " + build.getId());
		}
		return barganhaRepository.save(build);
	}

	@Transactional(readOnly = false)
	public void delete(Barganha barganha) {
		barganhaRepository.delete(barganha);
	}

}

package v2v1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import v2v1.entity.Emprestimo;
import v2v1.exception.EmprestimoNotFoundException;
import v2v1.repository.EmprestimoRepository;

@Service
public class EmprestimoService {

	@Autowired
	private EmprestimoRepository emprestimoRepository;

	@Transactional(readOnly = true)
	public List<Emprestimo> findAll() {
		return emprestimoRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Emprestimo findById(Long id) {
		if (!exist(id)) {
			throw new EmprestimoNotFoundException("Emprestimo com esse id não existe: " + id);
		}
		return emprestimoRepository.findOne(id);
	}

	@Transactional(readOnly = true)
	private boolean exist(Long id) {
		return emprestimoRepository.exists(id);
	}

	@Transactional(readOnly = false)
	public Emprestimo save(Emprestimo build) {
		if (build.getId() != null && exist(build.getId())) {
			throw new EmprestimoNotFoundException("Emprestimo com esse id não existe: " + build.getId());
		}
		return emprestimoRepository.save(build);
	}

	@Transactional(readOnly = false)
	public Emprestimo update(Emprestimo build) {
		if (!exist(build.getId())) {
			throw new EmprestimoNotFoundException("Emprestimo com esse id não existe: " + build.getId());
		}
		return emprestimoRepository.save(build);
	}

	@Transactional(readOnly = false)
	public void delete(Emprestimo emprestimo) {
		emprestimoRepository.delete(emprestimo);
	}

}

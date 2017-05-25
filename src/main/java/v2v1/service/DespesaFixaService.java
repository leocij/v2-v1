package v2v1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import v2v1.entity.DespesaFixa;
import v2v1.exception.DespesaFixaNotFoundException;
import v2v1.repository.DespesaFixaRepository;

@Service
public class DespesaFixaService {

	@Autowired
	private DespesaFixaRepository despesaFixaRepository;

	@Transactional(readOnly = true)
	public List<DespesaFixa> findAll() {
		return despesaFixaRepository.findAll();
	}

	@Transactional(readOnly = true)
	public DespesaFixa findById(Long id) {
		if (!exist(id)) {
			throw new DespesaFixaNotFoundException("DespesaFixa com esse id não existe: " + id);
		}
		return despesaFixaRepository.findOne(id);
	}

	@Transactional(readOnly = true)
	private boolean exist(Long id) {
		return despesaFixaRepository.exists(id);
	}

	@Transactional(readOnly = false)
	public DespesaFixa save(DespesaFixa build) {
		if (build.getId() != null && exist(build.getId())) {
			throw new DespesaFixaNotFoundException("DespesaFixa com esse id não existe: " + build.getId());
		}
		return despesaFixaRepository.save(build);
	}

	@Transactional(readOnly = false)
	public DespesaFixa update(DespesaFixa build) {
		if (!exist(build.getId())) {
			throw new DespesaFixaNotFoundException("DespesaFixa com esse id não existe: " + build.getId());
		}
		return despesaFixaRepository.save(build);
	}

	@Transactional(readOnly = false)
	public void delete(DespesaFixa despesaFixa) {
		despesaFixaRepository.delete(despesaFixa);
	}

}

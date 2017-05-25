package v2v1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import v2v1.entity.Parcelamento;
import v2v1.exception.ParcelamentoNotFoundException;
import v2v1.repository.ParcelamentoRepository;

@Service
public class ParcelamentoService {

	@Autowired
	private ParcelamentoRepository parcelamentoRepository;

	@Transactional(readOnly = true)
	public List<Parcelamento> findAll() {
		return parcelamentoRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Parcelamento findById(Long id) {
		if (!exist(id)) {
			throw new ParcelamentoNotFoundException("Parcelamento com esse id não existe: " + id);
		}
		return parcelamentoRepository.findOne(id);
	}

	@Transactional(readOnly = true)
	private boolean exist(Long id) {
		return parcelamentoRepository.exists(id);
	}

	@Transactional(readOnly = false)
	public Parcelamento save(Parcelamento build) {
		if (build.getId() != null && exist(build.getId())) {
			throw new ParcelamentoNotFoundException("Parcelamento com esse id não existe: " + build.getId());
		}
		return parcelamentoRepository.save(build);
	}

	@Transactional(readOnly = false)
	public Parcelamento update(Parcelamento build) {
		if (!exist(build.getId())) {
			throw new ParcelamentoNotFoundException("Parcelamento com esse id não existe: " + build.getId());
		}
		return parcelamentoRepository.save(build);
	}

	@Transactional(readOnly = false)
	public void delete(Parcelamento parcelamento) {
		parcelamentoRepository.delete(parcelamento);
	}

}

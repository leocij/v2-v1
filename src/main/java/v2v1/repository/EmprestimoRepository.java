package v2v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import v2v1.entity.Emprestimo;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

}

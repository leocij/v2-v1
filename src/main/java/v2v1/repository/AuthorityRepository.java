package v2v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import v2v1.entity.Authorities;

public interface AuthorityRepository extends JpaRepository<Authorities, String> {

}

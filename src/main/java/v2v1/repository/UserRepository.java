package v2v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import v2v1.entity.Users;

public interface UserRepository extends JpaRepository<Users, String> {

}

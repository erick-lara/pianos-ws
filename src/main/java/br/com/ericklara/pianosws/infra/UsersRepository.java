package br.com.ericklara.pianosws.infra;

import br.com.ericklara.pianosws.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {

}

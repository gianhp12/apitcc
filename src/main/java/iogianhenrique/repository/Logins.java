package iogianhenrique.repository;

import iogianhenrique.entity.Login;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface Logins extends CrudRepository<Login,Integer> {
    @Query(value = "select * from logins where email = :email and senha = :senha",nativeQuery = true)
    public Login acesso(String email,String senha);

}

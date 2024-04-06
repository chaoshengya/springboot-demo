package ka.shardingjdbc.repo;

import ka.shardingjdbc.entity.TmPhoneP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TmPhoneRepository extends JpaRepository<TmPhoneP, Long> {

    TmPhoneP findByPhone(Long phone);

    TmPhoneP findByEncryptPhone(String encryptPhone);


}
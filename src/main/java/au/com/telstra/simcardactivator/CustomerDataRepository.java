package au.com.telstra.simcardactivator;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CustomerDataRepository extends CrudRepository<CustomerData, Long> {

    List<CustomerData> findByIccid(String iccid);

    CustomerData findById(long id);

}

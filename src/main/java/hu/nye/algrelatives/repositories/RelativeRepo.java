package hu.nye.algrelatives.repositories;

import java.util.List;

import hu.nye.algrelatives.model.Relative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RelativeRepo extends JpaRepository<Relative, Integer> {

    @Query(value = "SELECT relative_data.complete_name,kinship_types.sd_name" +
            " FROM relative_data INNER JOIN direct_relatives ON relative_data.relative_id=direct_relatives.relative_id2" +
            " INNER JOIN kinship_types ON direct_relatives.direct_kinship_type_id=kinship_types.direct_name_id" +
            " WHERE direct_relatives.relative_id1=1", nativeQuery = true)
    public List<String[]> findByAdmin();


}

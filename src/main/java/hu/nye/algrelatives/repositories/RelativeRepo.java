package hu.nye.algrelatives.repositories;

import java.util.List;

import hu.nye.algrelatives.model.Relative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface RelativeRepo extends JpaRepository<Relative, Integer> {

    @Query(value = "SELECT relative_id FROM relative_data WHERE complete_name=?1", nativeQuery = true)
    public String getRelativeId(String keyword);

    @Query(value = "SELECT direct_name_id FROM kinship_types WHERE origin_name=?1", nativeQuery = true)
    public String getDirectNameId(String valakije);

    @Query(value = "SELECT indirect_name_id FROM indirect_names WHERE indirect_original_name=?1", nativeQuery = true)
    public String getIndirectNameId(String valakije1);

//    @Query(value = "SELECT sd_name FROM kinship_types WHERE sd_name=?1", nativeQuery = true)
//    public String getsdname(String valakije);

    @Query(value = "SELECT relative_data.complete_name,kinship_types.origin_name" +
            " FROM relative_data INNER JOIN direct_relatives ON relative_data.relative_id=direct_relatives.relative_id1" +
            " INNER JOIN kinship_types ON direct_relatives.direct_kinship_type_id=kinship_types.direct_name_id" +
            " WHERE direct_relatives.relative_id2=?1", nativeQuery = true)
    public List<String[]> listByName(String id);

    @Query(value = "SELECT relative_data.complete_name,kinship_types.origin_name" +
            " FROM relative_data INNER JOIN direct_relatives ON relative_data.relative_id=direct_relatives.relative_id2" +
            " INNER JOIN kinship_types ON direct_relatives.direct_kinship_type_id=kinship_types.direct_name_id" +
            " WHERE direct_relatives.relative_id1=?1", nativeQuery = true)
    public List<String[]> listByName2(String id);

    @Query(value = "SELECT relative_data.complete_name,indirect_names.indirect_original_name" +
            " FROM relative_data INNER JOIN indirect_relatives ON relative_data.relative_id=indirect_relatives.relative_id2" +
            " INNER JOIN indirect_names ON indirect_relatives.indirect_kinship_type_id=indirect_names.indirect_name_id" +
            " WHERE indirect_relatives.relative_id1=?1", nativeQuery = true)
    public List<String[]> listByName3(String id);

    @Query(value = "SELECT relative_data.complete_name,indirect_names.indirect_original_name" +
            " FROM relative_data INNER JOIN indirect_relatives ON relative_data.relative_id=indirect_relatives.relative_id1" +
            " INNER JOIN indirect_names ON indirect_relatives.indirect_kinship_type_id=indirect_names.indirect_name_id" +
            " WHERE indirect_relatives.relative_id2=?1", nativeQuery = true)
    public List<String[]> listByName4(String id);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO relative_data (gender,complete_name,birth_complete_name,birth_date,birth_place, " +
            "city) VALUES (?6,?1,?2,?5,?4,?3)", nativeQuery = true)
    public void insertNewRelative(String name, String birth_name, String address, String birth_place,
                                            String date_of_birth, String gender);

    @Query(value = "SELECT complete_name,relative_id FROM relative_data", nativeQuery = true)
    public List<String[]> getName();

    @Query(value = "SELECT relative_id FROM relative_data WHERE complete_name=?1", nativeQuery = true)
    public String getName1(String name);

    @Query(value = "SELECT relative_id1 FROM indirect_relatives WHERE relative_id1=?1 AND relative_id2=?2", nativeQuery = true)
    public String getName2(String name2, String name3);

    @Query(value = "SELECT relative_id1 FROM direct_relatives WHERE relative_id1=?1 AND relative_id2=?2", nativeQuery = true)
    public String getName3(String name4, String name5);

//    @Query(value = "SELECT relative_id2 FROM indirect_relatives WHERE relative_id2=?1", nativeQuery = true)
//    public String getName3(String name3);

    @Query(value = "SELECT origin_name, direct_name_id FROM kinship_types", nativeQuery = true)
    public List<String[]> getRel();

    @Query(value = "SELECT indirect_original_name, indirect_name_id FROM indirect_names", nativeQuery = true)
    public List<String[]> getRel1();

    @Query(value = "SELECT origin_name FROM kinship_types WHERE origin_name=?1", nativeQuery = true)
    public String getRel2(String name6);

    @Query(value = "SELECT indirect_original_name FROM indirect_names WHERE indirect_original_name=?1", nativeQuery = true)
    public String getRel3(String name7);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO direct_relatives (relative_id1, relative_id2, direct_kinship_type_id) " +
            "SELECT ?1,?2,?3 FROM DUAL WHERE (SELECT COUNT(*) FROM kinship_types " +
            "WHERE origin_name=?4) > 0;\n", nativeQuery = true)
    public void insertNewRel(String neki, String o, String valakije, String fdname);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO indirect_relatives (relative_id1, relative_id2, indirect_kinship_type_id) " +
            "SELECT ?1,?2,?3 FROM DUAL WHERE (SELECT COUNT(*) FROM indirect_names " +
            "WHERE indirect_original_name=?4) > 0;\n", nativeQuery = true)
    public void insertNewRel1(String neki, String o, String valakije1, String fdname1);

}

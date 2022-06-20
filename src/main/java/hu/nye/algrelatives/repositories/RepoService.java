package hu.nye.algrelatives.repositories;

import hu.nye.algrelatives.model.Relative;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class RepoService implements RelativeRepo{

  @Autowired
  private RelativeRepo repo;

  @Override
  public List<String[]> listByName(String id) {
    return repo.listByName(id);
  }

  @Override
  public List<String[]> listByName2(String id) {
    return repo.listByName2(id);
  }

  @Override
  public List<String[]> listByName3(String id) {
    return repo.listByName3(id);
  }

  @Override
  public List<String[]> listByName4(String id) {
    return repo.listByName4(id);
  }

  @Override
  public void insertNewRelative(String gender, String complete_name, String birth_complete_name, String birth_date,
                                String birth_place, String city) {

  }

  @Override
  public List<String[]> getName() {
    return repo.getName();
  }

  @Override
  public String getName1(String name) {
    return repo.getName1(name);
  }

  @Override
  public String getName2(String name2, String name3) {
    return repo.getName2(name2, name3);
  }

  @Override
  public String getName3(String name4, String name5) {
    return repo.getName3(name4,name5);
  }

//  @Override
//  public String getName3(String name3) {
//    return repo.getName3(name3);
//  }

  @Override
  public List<String[]> getRel() {
    return repo.getRel();
  }

  @Override
  public List<String[]> getRel1() {
    return repo.getRel1();
  }

  @Override
  public String getRel2(String name6) {
    return repo.getRel2(name6);
  }

  @Override
  public String getRel3(String name7) {
    return repo.getRel3(name7);
  }

  @Override
  public void insertNewRel(String neki, String o, String valakije, String fdname) {

  }

  @Override
  public void insertNewRel1(String neki, String o, String valakije1, String fdname1) {

  }

  @Override
  public String getRelativeId(String keyword) {
    return repo.getRelativeId(keyword);
  }

  @Override
  public String getDirectNameId(String valakije) {
    return repo.getDirectNameId(valakije);
  }

  @Override
  public String getIndirectNameId(String valakije1) {
    return repo.getIndirectNameId(valakije1);
  }

//  @Override
//  public String getsdname(String valakije) {
//    return repo.getsdname(valakije);
//  }

  @Override
  public List<Relative> findAll() {
    return null;
  }

  @Override
  public List<Relative> findAll(Sort sort) {
    return null;
  }

  @Override
  public Page<Relative> findAll(Pageable pageable) {
    return null;
  }

  @Override
  public List<Relative> findAllById(Iterable<Integer> integers) {
    return null;
  }

  @Override
  public long count() {
    return 0;
  }

  @Override
  public void deleteById(Integer integer) {

  }

  @Override
  public void delete(Relative entity) {

  }

  @Override
  public void deleteAllById(Iterable<? extends Integer> integers) {

  }

  @Override
  public void deleteAll(Iterable<? extends Relative> entities) {

  }

  @Override
  public void deleteAll() {

  }

  @Override
  public <S extends Relative> S save(S entity) {
    return null;
  }

  @Override
  public <S extends Relative> List<S> saveAll(Iterable<S> entities) {
    return null;
  }

  @Override
  public Optional<Relative> findById(Integer integer) {
    return Optional.empty();
  }

  @Override
  public boolean existsById(Integer integer) {
    return false;
  }

  @Override
  public void flush() {

  }

  @Override
  public <S extends Relative> S saveAndFlush(S entity) {
    return null;
  }

  @Override
  public <S extends Relative> List<S> saveAllAndFlush(Iterable<S> entities) {
    return null;
  }

  @Override
  public void deleteAllInBatch(Iterable<Relative> entities) {

  }

  @Override
  public void deleteAllByIdInBatch(Iterable<Integer> integers) {

  }

  @Override
  public void deleteAllInBatch() {

  }

  @Override
  public Relative getOne(Integer integer) {
    return null;
  }

  @Override
  public Relative getById(Integer integer) {
    return null;
  }

  @Override
  public <S extends Relative> Optional<S> findOne(Example<S> example) {
    return Optional.empty();
  }

  @Override
  public <S extends Relative> List<S> findAll(Example<S> example) {
    return null;
  }

  @Override
  public <S extends Relative> List<S> findAll(Example<S> example, Sort sort) {
    return null;
  }

  @Override
  public <S extends Relative> Page<S> findAll(Example<S> example, Pageable pageable) {
    return null;
  }

  @Override
  public <S extends Relative> long count(Example<S> example) {
    return 0;
  }

  @Override
  public <S extends Relative> boolean exists(Example<S> example) {
    return false;
  }

  @Override
  public <S extends Relative, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
    return null;
  }
}

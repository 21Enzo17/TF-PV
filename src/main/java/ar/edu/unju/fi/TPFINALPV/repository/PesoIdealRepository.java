package ar.edu.unju.fi.TPFINALPV.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.TPFINALPV.entity.PesoIdeal;


@Repository
public interface PesoIdealRepository extends CrudRepository<PesoIdeal,Long> {

    public List<PesoIdeal> findByEstado(boolean estado);
}

package dao;

import javax.ejb.Remote;

import domain.Dimensionen;


@Remote
public interface DimensionenDao extends GenericDAO<Dimensionen, Integer> {}

package dao.ejb;

import javax.ejb.Stateless;

import dao.DimensionenDao;
import domain.Dimensionen;


public @Stateless class DimensionenDaoBean extends GenericEJB3DAO<Dimensionen, Integer> implements DimensionenDao {}

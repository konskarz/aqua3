package dao.ejb;

import javax.ejb.Stateless;

import dao.SzenarienDao;
import domain.Szenarien;


public @Stateless class SzenarienDaoBean extends GenericEJB3DAO<Szenarien, Integer> implements SzenarienDao {}
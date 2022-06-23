package dao.ejb;

import javax.ejb.Stateless;

import dao.LebewesenDao;
import domain.Lebewesen;


public @Stateless class LebewesenDaoBean extends GenericEJB3DAO<Lebewesen, Integer> implements LebewesenDao {}

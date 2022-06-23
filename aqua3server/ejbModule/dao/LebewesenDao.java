package dao;

import javax.ejb.Remote;

import domain.Lebewesen;


@Remote
public interface LebewesenDao extends GenericDAO<Lebewesen, Integer> {}

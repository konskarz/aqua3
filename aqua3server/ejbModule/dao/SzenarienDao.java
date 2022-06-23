package dao;

import javax.ejb.Remote;

import domain.Szenarien;


@Remote
public interface SzenarienDao extends GenericDAO<Szenarien, Integer> {}

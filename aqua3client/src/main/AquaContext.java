package main;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import dao.DimensionenDao;
import dao.LebewesenDao;
import dao.SzenarienDao;


public class AquaContext {

	public static final String SZENARIENDAO = "SzenarienDaoBean/remote";
	public static final String DIMENSIONENDAO = "DimensionenDaoBean/remote";
	public static final String LEBEWESENDAO = "LebewesenDaoBean/remote";
	private SzenarienDao szenarienDao = null;
	private DimensionenDao dimensionenDao = null;
	private LebewesenDao lebewesenDao = null;

	public AquaContext() throws NamingException {
		InitialContext context = new InitialContext();
		Object ref = context.lookup(SZENARIENDAO);
		szenarienDao = (SzenarienDao)PortableRemoteObject.narrow(ref,SzenarienDao.class);
		ref = context.lookup(DIMENSIONENDAO);
		dimensionenDao = (DimensionenDao)PortableRemoteObject.narrow(ref,DimensionenDao.class);
		ref = context.lookup(LEBEWESENDAO);
		lebewesenDao = (LebewesenDao)PortableRemoteObject.narrow(ref,LebewesenDao.class);
	}

	public SzenarienDao getSzenarienDao() {
		return szenarienDao;
	}

	public DimensionenDao getDimensionenDao() {
		return dimensionenDao;
	}

	public LebewesenDao getLebewesenDao() {
		return lebewesenDao;
	}

}

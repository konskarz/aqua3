package model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxEditor;
import javax.swing.ComboBoxModel;
import javax.swing.MutableComboBoxModel;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import dao.SzenarienDao;
import domain.Dimensionen;
import domain.Szenarien;


/**
 * ComboBoxModel Klasse für Szenarien-Verwaltung
 * @author Konstantin Karzanov
 * 28.08.2008
 */
public class SzenarienModel extends AbstractListModel implements MutableComboBoxModel, Serializable {
	
	private static final long serialVersionUID = -7888833300976707376L;
	private SzenarienDao dao;
	private List<Szenarien> szenarien;
	private Object selectedItem;
	private ComboBoxModel dimensionenModel;
	private FutterzeitModel futterzeitModel;
	private SzenarienLebewesenModel szLebewesenModel;
	private ComboBoxEditor nameEditor = new SzenarienNameEditor();
	private final SpinnerModel[] tempWerteModels = new SpinnerModel[] {
			new SpinnerNumberModel(22.0,15.0,35.0,0.5),
			new SpinnerNumberModel(28.0,15.0,35.0,0.5)
			};
	private final SpinnerModel[] phWerteModels = new SpinnerModel[] {
			new SpinnerNumberModel(5.0,0.0,10.0,0.5),
			new SpinnerNumberModel(8.0,0.0,10.0,0.5)
			};
	private final SpinnerModel[] lichtWerteModels = new SpinnerModel[] {
			new SpinnerDateModel(new Date(), null, null, Calendar.HOUR_OF_DAY),
			new SpinnerDateModel(new Date(), null, null, Calendar.HOUR_OF_DAY)
			};
	public static final String PATTERN = "HH:mm";

	public SzenarienModel(SzenarienDao dao) {
		this.dao = dao;
		this.szenarien = dao.findAll();
		this.setSelectedItem(szenarien.get(szenarien.size()-1));
	}

	@Override
	public void addElement(Object obj) {
		if(obj instanceof Szenarien) {
			szenarien.add((Szenarien)obj);
			fireIntervalAdded(this, szenarien.size()-1, szenarien.size()-1);
			if (szenarien.size()==1 && selectedItem==null )
				setSelectedItem(obj);
		}
	}

	@Override
	public void insertElementAt(Object obj, int index) {
		if(obj instanceof Szenarien) {
			szenarien.add(index, (Szenarien)obj);
			fireIntervalAdded(this, index, index);
		}
	}

	@Override
	public void removeElement(Object obj) {
		int index = szenarien.indexOf(obj);
		if (index!=-1) {
			removeElementAt(index);
		}
	}

	@Override
	public void removeElementAt(int index) {
		if (getElementAt(index)==selectedItem) {
			if (index==0)
				setSelectedItem(getSize()==1 ? null : getElementAt(index+1));
			else
				setSelectedItem(getElementAt(index-1));
		}
		szenarien.remove(index);
		fireIntervalRemoved(this, index, index);
	}

	@Override
	public Object getSelectedItem() {
		return selectedItem;
	}

	@Override
	public void setSelectedItem(Object anItem) {
		if ((selectedItem!=null && !selectedItem.equals(anItem)) ||
				selectedItem == null && anItem!=null) {
			selectedItem = anItem;
			fireContentsChanged(this, -1, -1);
		}
	}

	@Override
	public Object getElementAt(int index) {
		if (index>=0 && index<szenarien.size())
			return szenarien.get(index);
		else
			return null;
	}

	@Override
	public int getSize() {
		return szenarien.size();
	}

	public ComboBoxEditor getNameEditor() {
		return nameEditor;
	}

	public SpinnerModel[] getTempWerteModels() {
		return tempWerteModels;
	}

	public SpinnerModel[] getPhWerteModels() {
		return phWerteModels;
	}

	public SpinnerModel[] getLichtWerteModels() {
		return lichtWerteModels;
	}

	public void setModels(DimensionenModel dimensionenModel, 
			FutterzeitModel futterzeitModel, 
			SzenarienLebewesenModel szLebewesenModel) {
		this.dimensionenModel = dimensionenModel;
		this.futterzeitModel = futterzeitModel;
		this.szLebewesenModel = szLebewesenModel;
	}

	public void refreshModels() {
		Szenarien s = (Szenarien)getSelectedItem();
		s.getTempWerte().refreshWerte(tempWerteModels);
		s.getPhWerte().refreshWerte(phWerteModels);
		s.getLichtWerte().refreshWerte(lichtWerteModels);
		dimensionenModel.setSelectedItem(s.getDimensionen());
		futterzeitModel.setSzenarienFutterzeiten(s.getSzenarienFutterzeiten());
		szLebewesenModel.buildSzLebewesenTree(s, s.getSzenarienLebewesen());
	}

	public void createNewSzenario() {
		Szenarien newSzenario;
		try {
			newSzenario = dao.makePersistent(szenarien.get(0).clone());
		} catch (CloneNotSupportedException e) {
			newSzenario = dao.makePersistent(new Szenarien());
		}
		addElement(newSzenario);
		setSelectedItem(newSzenario);
		refreshModels();
	}

	public void saveSelectedSzenario() {
		Szenarien s = (Szenarien)getSelectedItem();
		s.getTempWerte().saveWerte(tempWerteModels);
		s.getPhWerte().saveWerte(phWerteModels);
		s.getLichtWerte().saveWerte(lichtWerteModels);
		s.setDimensionen((Dimensionen)(dimensionenModel.getSelectedItem()));
		Szenarien savedSzenario = dao.makePersistent(s);
		int index = szenarien.indexOf(s);
		szenarien.set(index, savedSzenario);
		setSelectedItem(savedSzenario);
		refreshModels();
	}

	public void deleteSelectedSzenario() {
		if(!getSelectedItem().equals(szenarien.get(0))) {
			Szenarien s = (Szenarien)getSelectedItem();
			dao.makeTransient(s);
			removeElement(s);
		}
	}

	public boolean isInSzenario(Dimensionen d) {
		for(Szenarien s : szenarien) {
			if(s.getDimensionen().equals(d))
				return true;
		}
		return false;
	}

}

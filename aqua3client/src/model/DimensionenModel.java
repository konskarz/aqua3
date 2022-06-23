package model;

import java.io.Serializable;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.MutableComboBoxModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import dao.DimensionenDao;
import domain.Dimensionen;


/**
 * ComboBoxModel Klasse für Dimensionen-Verwaltung 
 * @author Konstantin Karzanov
 * 28.08.2008
 */
public class DimensionenModel extends AbstractListModel implements MutableComboBoxModel, Serializable {
	
	private static final long serialVersionUID = -7888833300976707376L;
	private DimensionenDao dao;
	private List<Dimensionen> dimensionen;
	private Object selectedItem;
	private Dimensionen newDimensionen;
	private SzenarienModel szenarienModel;
	private final SpinnerModel[] spinnerModels = new SpinnerModel[] {
			new SpinnerNumberModel(100,20,6485,5),
			new SpinnerNumberModel(50,20,6485,5),
			new SpinnerNumberModel(75,20,6485,5)
			};

	public DimensionenModel(DimensionenDao dao) {
		this.dao = dao;
		this.dimensionen = dao.findAll();
	}

	@Override
	public void addElement(Object obj) {
		if(obj instanceof Dimensionen) {
			dimensionen.add((Dimensionen) obj);
			fireIntervalAdded(this, dimensionen.size()-1, dimensionen.size()-1);
			if (dimensionen.size()==1 && selectedItem==null )
				setSelectedItem(obj);
		}
	}

	@Override
	public void insertElementAt(Object obj, int index) {
		if(obj instanceof Dimensionen) {
			dimensionen.add(index, (Dimensionen)obj);
			fireIntervalAdded(this, index, index);
		}
	}

	@Override
	public void removeElement(Object obj) {
		int index = dimensionen.indexOf(obj);
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
		dimensionen.remove(index);
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
		if (index>=0 && index<dimensionen.size())
			return dimensionen.get(index);
		else
			return null;
	}

	@Override
	public int getSize() {
		return dimensionen.size();
	}

	public void setModels(SzenarienModel szenarienModel) {
		this.szenarienModel = szenarienModel;
	}

	public SpinnerModel[] getSpinnerModels() {
		return spinnerModels;
	}
	
	public void refreshModels() {
		Dimensionen d = (Dimensionen)getSelectedItem();
		d.refreshWerte(spinnerModels);
	}
	
	public void createNewDimensionen() {
		Dimensionen d = (Dimensionen)getSelectedItem();
		if(d!=null) {
			try {
				newDimensionen = d.clone();
				newDimensionen.refreshWerte(spinnerModels);
			} catch (CloneNotSupportedException e) {
				newDimensionen = new Dimensionen();
			}
		}
		else
			newDimensionen = new Dimensionen();
	}
	
	public void deleteIfNew() {
		if(newDimensionen!=null)
			newDimensionen=null;
	}

	public void saveDimensionen() {
		if(newDimensionen!=null) {
			newDimensionen.saveWerte(spinnerModels);
			Dimensionen d = dao.makePersistent(newDimensionen);
			addElement(d);
			setSelectedItem(d);
			newDimensionen = null;
		}
		else {
			Dimensionen d = (Dimensionen)getSelectedItem();
			d.saveWerte(spinnerModels);
			dao.makePersistent(d);
		}
	}

	public void deleteSelectedDimensionen() {
		Dimensionen d = (Dimensionen)getSelectedItem();
		if(!szenarienModel.isInSzenario(d)) {
			dao.makeTransient(d);
			removeElement(d);
		}
	}

}

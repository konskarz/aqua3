package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerDateModel;

import domain.SzenarienFutterzeiten;


/**
 * ListModell Klasse für Futterzeiten verwaltung
 * @author Konstantin Karzanov
 * 28.08.2008
 */
public class FutterzeitModel extends AbstractListModel {

	private static final long serialVersionUID = -4823111994559081489L;
	private List<SzenarienFutterzeiten> szenarienFutterzeiten;
	private final ListSelectionModel selectionModel = new DefaultListSelectionModel();
	private final SpinnerDateModel spinnerModel = new SpinnerDateModel(new Date(), null, null, Calendar.HOUR_OF_DAY);
	public static final String PATTERN = "HH:mm";
	public static final SimpleDateFormat FORMATER = new SimpleDateFormat(PATTERN);
//	public static final long PAUSE = 30*60*1000;
//	public static final String DEFAULTZEIT = "04:00";

	@Override
	public Object getElementAt(int index) {
		if(szenarienFutterzeiten!=null)
			return szenarienFutterzeiten.get(index);
		return null;
	}

	@Override
	public int getSize() {
		if(szenarienFutterzeiten!=null)
			return szenarienFutterzeiten.size();
		return 0;
	}

	public void setSzenarienFutterzeiten(List<SzenarienFutterzeiten> szenarienFutterzeiten) {
		this.szenarienFutterzeiten = szenarienFutterzeiten;
		fireContentsChanged(this, -1, -1);
	}
	
	public ListSelectionModel getSelectionModel() {
		return selectionModel;
	}

	public SpinnerDateModel getSpinnerModel() {
		return spinnerModel;
	}

	public void addFutterzeit() {
		Object date = spinnerModel.getValue();
		if(date instanceof Date) {
			String zeit = FORMATER.format((Date)date);
			SzenarienFutterzeiten szfz = new SzenarienFutterzeiten();
			szfz.setUhrzeit(zeit);
			szenarienFutterzeiten.add(szfz);
			fireIntervalAdded(this, szenarienFutterzeiten.size()-1, szenarienFutterzeiten.size()-1);
		}
	}

	public void deleteFutterzeit() {
		int minIndex = selectionModel.getMinSelectionIndex();
		int maxIndex = selectionModel.getMaxSelectionIndex();
		for (int index=maxIndex; index>=minIndex; index--) {
			System.out.println(index);
			if (selectionModel.isSelectedIndex(index)) {
				System.out.println(index);
				szenarienFutterzeiten.remove(index);
				fireIntervalRemoved(this, index, index);
			}
		}
	}
}

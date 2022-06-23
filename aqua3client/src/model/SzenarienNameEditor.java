package model;

import javax.swing.plaf.basic.BasicComboBoxEditor;

import domain.Szenarien;


public class SzenarienNameEditor extends BasicComboBoxEditor {

	private Object oldValue;

	@Override
	public Object getItem() {
		Object newValue = editor.getText();
		if (oldValue != null && !(oldValue instanceof String)) {
			if (newValue.equals(oldValue.toString()))
				return oldValue;
			else {
				Szenarien s = (Szenarien)oldValue;
				s.saveName((String)newValue);
				newValue = s;
			}
		}
		return newValue;
	}

	@Override
	public void setItem(Object anObject) {
		super.setItem(anObject);
		this.oldValue = anObject;
	}
	
}

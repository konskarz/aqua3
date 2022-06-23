package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import model.SzenarienModel;


public class SzenarienComboBoxAction extends AbstractAction {
	
	private static final long serialVersionUID = 1L;
	private SzenarienModel model;
	
	public SzenarienComboBoxAction(SzenarienModel model) {
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		model.refreshModels();
	}
}


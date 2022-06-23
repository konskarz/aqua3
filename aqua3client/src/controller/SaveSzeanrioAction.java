package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import main.Resources;
import model.SzenarienModel;


public class SaveSzeanrioAction extends AbstractAction {
	
	private static final long serialVersionUID = 1L;
	private SzenarienModel model;

	public SaveSzeanrioAction(SzenarienModel model) {
		super(Resources.getString("Szen.saveButton"));
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		model.saveSelectedSzenario();
	}
}


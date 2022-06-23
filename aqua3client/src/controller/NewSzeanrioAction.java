package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import main.Resources;
import model.SzenarienModel;


public class NewSzeanrioAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private SzenarienModel model;
	
	public NewSzeanrioAction(SzenarienModel model) {
		super(Resources.getString("Szen.newButton"));
		this.model = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		model.createNewSzenario();
	}
}


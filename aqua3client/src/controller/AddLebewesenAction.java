package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.Aqua3EditorViewRoot;

import main.Resources;
import model.LebewesenModel;
import model.SzenarienLebewesenModel;

import domain.Lebewesen;


public class AddLebewesenAction extends AbstractAction {
	
	private static final long serialVersionUID = 1L;
	private Aqua3EditorViewRoot view;
	private LebewesenModel dbLebewesen;
	private SzenarienLebewesenModel szLebewesen;
	
	public AddLebewesenAction(Aqua3EditorViewRoot view, LebewesenModel[] models) {
	}
	
	public AddLebewesenAction(Aqua3EditorViewRoot view,
			LebewesenModel dbLebewesenModel,
			SzenarienLebewesenModel szLebewesenModel) {
		super(Resources.getString("Szen.lwp_addButton"));
		this.view = view;
		dbLebewesen = dbLebewesenModel;
		szLebewesen = szLebewesenModel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Lebewesen[] lebewesen = dbLebewesen.getSelectedLebewesen();
		if(lebewesen!=null && lebewesen.length!=0) {
			for(Lebewesen l : lebewesen) {
				int menge = view.getLebewesenMenge(l.toString(), 1);
				szLebewesen.addLebewesen(l, menge);
			}
		}
	}
}


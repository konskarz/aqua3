package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.Aqua3EditorViewRoot;

import main.Resources;
import model.DimensionenModel;


public class CancelDimensionenEditAction extends AbstractAction {
	
	private static final long serialVersionUID = 1L;
	private Aqua3EditorViewRoot view;
	private DimensionenModel model;
	
	public CancelDimensionenEditAction(Aqua3EditorViewRoot view, DimensionenModel model) {
		super(Resources.getString("DimPanel.cancelButton"));
		this.view = view;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		model.deleteIfNew();
		view.hideDimensionenDialog();
	}

}


package controller;

import java.awt.Container;

import javax.swing.Action;

import view.Aqua3EditorViewRoot;

import main.AquaContext;
import main.Resources;
import model.DimensionenModel;
import model.FutterzeitModel;
import model.LebewesenModel;
import model.SzenarienLebewesenModel;
import model.SzenarienModel;


public class Aqua3EditorController {

	private Container parent;
	private Aqua3EditorViewRoot rootPanel;
	private AquaContext context;

	private SzenarienModel szenarienModel;
	private DimensionenModel dimensionenModel;
	private FutterzeitModel futterzeitModel;
	private LebewesenModel dbLebewesenModel;
	private SzenarienLebewesenModel szLebewesenModel;

	public Aqua3EditorController(Container parent, Aqua3EditorViewRoot rootPanel, AquaContext context) {
		this.parent = parent;
		this.rootPanel = rootPanel;
		this.context = context;
		initModels();
		initActions();
	}

	private void initModels() {
		szenarienModel = new SzenarienModel(context.getSzenarienDao());
		dimensionenModel = new DimensionenModel(context.getDimensionenDao());
		futterzeitModel = new FutterzeitModel();
		dbLebewesenModel = new LebewesenModel(Resources.getString("Szen.lwp_treeRoot"), context.getLebewesenDao());
		szLebewesenModel = new SzenarienLebewesenModel(Resources.getString("Szen.lwszp_treeRoot"));

		szenarienModel.setModels(dimensionenModel, futterzeitModel, szLebewesenModel);
		dimensionenModel.setModels(szenarienModel);
		szenarienModel.refreshModels();

		rootPanel.setSzenarienModels(szenarienModel, szenarienModel.getNameEditor());
		rootPanel.setAquariumModels(dimensionenModel, null);
		rootPanel.setTempModels(szenarienModel.getTempWerteModels());
		rootPanel.setPhModels(szenarienModel.getPhWerteModels());
		rootPanel.setLichtModels(szenarienModel.getLichtWerteModels(), SzenarienModel.PATTERN);
		rootPanel.setFutterzeitModels(futterzeitModel, futterzeitModel.getSelectionModel(), futterzeitModel.getSpinnerModel(), FutterzeitModel.PATTERN);
		rootPanel.setDimensionenModels(dimensionenModel.getSpinnerModels());
		rootPanel.setDbLebewesenModels(dbLebewesenModel, dbLebewesenModel.getSelectionModel());
		rootPanel.setSzLebewesenModels(szLebewesenModel, szLebewesenModel.getSelectionModel());
	}

	private void initActions() {
		Action programExitAction = new ProgramExitAction(parent);
		Action szenarienComboBoxAction = new SzenarienComboBoxAction(szenarienModel);
		Action dimensionenComboBoxAction = new DimensionenComboBoxAction();
		Action newSzeanrioAction = new NewSzeanrioAction(szenarienModel);
		Action saveSzeanrioAction = new SaveSzeanrioAction(szenarienModel);
		Action deleteSzeanrioAction = new DeleteSzeanrioAction(szenarienModel);
		Action newDimensionenAction = new NewDimensionenAction(rootPanel, dimensionenModel);
		Action editDimensionenAction = new EditDimensionenAction(rootPanel, dimensionenModel);
		Action deleteDimensionenAction = new DeleteDimensionenAction(dimensionenModel);
		Action addFutterzeitAction = new AddFutterzeitAction(futterzeitModel);
		Action deleteFutterzeitAction = new DeleteFutterzeitAction(futterzeitModel);
		Action saveDimensionenEditAction = new SaveDimensionenEditAction(rootPanel, dimensionenModel);
		Action cancelDimensionenEditAction = new CancelDimensionenEditAction(rootPanel, dimensionenModel);
		Action addLebewesenAction = new AddLebewesenAction(rootPanel, dbLebewesenModel, szLebewesenModel);
		Action removeLebewesenAction = new RemoveLebewesenAction(szLebewesenModel);

		rootPanel.addMenuProgramItem(programExitAction);
		rootPanel.setSzenarienActions(new Action[] {szenarienComboBoxAction, newSzeanrioAction, saveSzeanrioAction, deleteSzeanrioAction});
		rootPanel.setAquariumActions(new Action[] {dimensionenComboBoxAction, newDimensionenAction, editDimensionenAction, deleteDimensionenAction});
		rootPanel.setFutterzeitActions(new Action[] {addFutterzeitAction, deleteFutterzeitAction});
		rootPanel.setLebewesenActions(new Action[] {addLebewesenAction, removeLebewesenAction});
		rootPanel.setDimensionenActions(new Action[] {saveDimensionenEditAction, cancelDimensionenEditAction});
	}

}
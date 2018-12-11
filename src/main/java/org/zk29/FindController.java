package org.zk29;

import java.util.List;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zul.*;
import org.zkoss.zul.ext.Selectable;
import base.People;
import java.util.Set;

public class FindController extends SelectorComposer<Component>{
private static final long serialVersionUID = 1L;
	
	@Wire
	private Textbox keywordBox;
	@Wire
	private Listbox peopleListbox;
	@Wire
	private Label nameLabel;
	@Wire
	private Label lastNameLabel;
			
	private PeopleService bookService = new PeopleServiceImpl();
	
	@Listen("onClick = #findButton")
	public void search(){
		String keyword = keywordBox.getValue();
		List<People> result = bookService.find(keyword);
		peopleListbox.setModel(new ListModelList<People>(result));
	}
	
	@Listen("onSelect = #peopleListbox")
	public void showDetail(){
		Set<People> selection = ((Selectable<People>)peopleListbox.getModel()).getSelection();
		if (selection!=null && !selection.isEmpty()){
			People selected = selection.iterator().next();
			nameLabel.setValue(selected.getName());
			lastNameLabel.setValue(selected.getLastName());
		}
	}
}

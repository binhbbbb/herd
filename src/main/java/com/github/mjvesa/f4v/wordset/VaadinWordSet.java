package com.github.mjvesa.f4v.wordset;

import com.github.mjvesa.f4v.BaseWord;
import com.github.mjvesa.f4v.Interpreter;
import com.github.mjvesa.f4v.Word;

public class VaadinWordSet extends WordSet {

	protected Word[] words = {

	new BaseWord("", "") {

		@Override
		public void execute(Interpreter interpreter) {
		}
	},

			// case NEWBUTTON:
			// btn = new Button("", this);
			// dataStack.push(btn);
			// break;

			new BaseWord("", "") {

				@Override
				public void execute(Interpreter interpreter) {
				}
			},

			// case SETCLICKLISTENER:
			// o = dataStack.pop();
			// btn = (Button) dataStack.pop();
			// btn.setData(o);
			// dataStack.push(btn);
			// break;

			new BaseWord("", "") {

				@Override
				public void execute(Interpreter interpreter) {
				}
			},

			// case NEWHL:
			// HorizontalLayout hl = new HorizontalLayout();
			// hl.setSpacing(true);
			// dataStack.push(hl);
			// break;

			new BaseWord("", "") {

				@Override
				public void execute(Interpreter interpreter) {
				}
			},

			// case NEWVL:
			// VerticalLayout vl = new VerticalLayout();
			// vl.setSpacing(true);
			// dataStack.push(vl);
			// break;

			new BaseWord("", "") {

				@Override
				public void execute(Interpreter interpreter) {
				}
			},

			// case NEWGL: // ( x y - gl )
			// b = (Integer) dataStack.pop();
			// a = (Integer) dataStack.pop();
			// dataStack.push(new GridLayout(a, b));
			// break;

			new BaseWord("", "") {

				@Override
				public void execute(Interpreter interpreter) {
				}
			},

			// case GLNEWLINE:
			// ((GridLayout) dataStack.get(0)).newLine();
			// break;

			new BaseWord("", "") {

				@Override
				public void execute(Interpreter interpreter) {
				}
			},

			// case NEWWINDOW:
			// w = new Window();
			// ((VerticalLayout) w.getContent()).setSpacing(true);
			// dataStack.push(w);
			// break;
			new BaseWord("", "") {

				@Override
				public void execute(Interpreter interpreter) {
				}
			},

			// case MAINPANEL:
			// dataStack.push(mainComponentContainer);
			// break;

			new BaseWord("", "") {

				@Override
				public void execute(Interpreter interpreter) {
				}
			},

			// case ADDWINDOW:
			// w = (Window) dataStack.pop();
			// guiEventListener.getUI().addWindow(w);
			// break;

			new BaseWord("", "") {

				@Override
				public void execute(Interpreter interpreter) {
				}
			},

			// case ADDCOMPONENT:
			// Component comp = (Component) dataStack.pop();
			// cc = (ComponentContainer) dataStack.pop();
			// cc.addComponent(comp);
			// dataStack.push(cc);
			// break;
			new BaseWord("", "") {

				@Override
				public void execute(Interpreter interpreter) {
				}
			},

			// case SETCAPTION:
			// str = (String) dataStack.pop();
			// comp = (Component) dataStack.pop();
			// comp.setCaption(str);
			// dataStack.push(comp);
			// break;

			new BaseWord("", "") {

				@Override
				public void execute(Interpreter interpreter) {
				}
			},

			// case SETVALUE:
			// o = dataStack.pop();
			// f = (Field) dataStack.pop();
			// f.setValue(o);
			// dataStack.push(f);
			// break;

			new BaseWord("", "") {

				@Override
				public void execute(Interpreter interpreter) {
				}
			},

			// case GETVALUE:
			// f = (Field) dataStack.pop();
			// dataStack.push(f);
			// dataStack.push(f.getValue());
			// break;

			new BaseWord("", "") {

				@Override
				public void execute(Interpreter interpreter) {
				}
			},

			// case SETSIZEFULL:
			// comp = (Component) dataStack.pop();
			// comp.setSizeFull();
			// dataStack.push(comp);
			// break;

			new BaseWord("", "") {

				@Override
				public void execute(Interpreter interpreter) {
				}
			},

			// case SETSIZEUNDEFINED:
			// comp = (Component) dataStack.pop();
			// comp.setSizeUndefined();
			// dataStack.push(comp);
			// break;

			new BaseWord("", "") {

				@Override
				public void execute(Interpreter interpreter) {
				}
			},

			// case SETHEIGHT:
			// str = (String) dataStack.pop();
			// comp = (Component) dataStack.pop();
			// comp.setHeight(str);
			// dataStack.push(comp);
			// break;

			new BaseWord("", "") {

				@Override
				public void execute(Interpreter interpreter) {
				}
			},

			// case SETWIDTH:
			// str = (String) dataStack.pop();
			// comp = (Component) dataStack.pop();
			// comp.setWidth(str);
			// dataStack.push(comp);
			// break;

			new BaseWord("", "") {

				@Override
				public void execute(Interpreter interpreter) {
				}
			},

			// case CLEARCONTAINER:
			// cc = (ComponentContainer) dataStack.pop();
			// cc.removeAllComponents();
			// break;
			new BaseWord("", "") {

				@Override
				public void execute(Interpreter interpreter) {
				}
			},

			// case NEWCHECKBOX:
			// dataStack.push(new CheckBox());
			// break;
			new BaseWord("", "") {

				@Override
				public void execute(Interpreter interpreter) {
				}
			},

			// case NEWDATEFIELD:
			// dataStack.push(new DateField());
			// final String dfCommand = (String) dataStack.pop();
			// DateField df = new DateField();
			// df.setImmediate(true);
			// df.addListener(new ValueChangeListener() {
			// public void valueChange(ValueChangeEvent event) {
			// dataStack.push(event.getProperty().getValue());
			// interpret(dfCommand);
			// }
			// });
			// dataStack.push(df);
			// break;
			new BaseWord("", "") {

				@Override
				public void execute(Interpreter interpreter) {
				}
			},

			// case NEWLABEL:
			// dataStack.push(new Label());
			// break;
			new BaseWord("", "") {

				@Override
				public void execute(Interpreter interpreter) {
				}
			},

			// case NEWTEXTFIELD: // ( caption -- textfield)
			// final String tfCommand = getNextNonNopWord();
			// TextField tf = new TextField();
			// tf.setCaption((String) dataStack.pop());
			// tf.setValue("");
			// tf.setImmediate(true);
			// tf.addValueChangeListener(new ValueChangeListener() {
			// /**
			// *
			// */
			// private static final long serialVersionUID =
			// 4325104922208051065L;
			//
			// public void valueChange(ValueChangeEvent event) {
			// dataStack.push(event.getProperty().getValue());
			// interpret(tfCommand);
			// }
			// });
			// dataStack.push(tf);
			// break;
			new BaseWord("", "") {

				@Override
				public void execute(Interpreter interpreter) {
				}
			},

			// /* Tables */
			// case NEWTABLE:
			// final String tableCommand = getNextNonNopWord();
			// table = new Table();
			// table.setCaption((String) dataStack.pop());
			// table.setImmediate(true);
			// table.setSelectable(true);
			// table.addListener(new ItemClickListener() {
			//
			// /**
			// *
			// */
			// private static final long serialVersionUID =
			// 3585546076571010729L;
			//
			// public void itemClick(ItemClickEvent event) {
			//
			// dataStack.push(event.getItem());
			// executeDefinedWord(dictionary.get(tableCommand));
			// }
			// });
			// dataStack.push(table);
			// break;
			//
			new BaseWord("", "") {

				@Override
				public void execute(Interpreter interpreter) {
				}
			},

			// case NEWCOMBOBOX:
			// final String newItemCommand = getNextNonNopWord();
			// final String itemSelectedCommand = getNextNonNopWord();
			// final ComboBox cb = new ComboBox();
			// cb.setImmediate(true);
			// str = (String) dataStack.pop();
			// cb.setNullSelectionAllowed(false);
			// cb.setCaption(str);
			// cb.setItemCaptionMode(AbstractSelect.ITEM_CAPTION_MODE_ITEM);
			// cb.setNewItemsAllowed(true);
			// cb.setNewItemHandler(new NewItemHandler() {
			//
			// /**
			// *
			// */
			// private static final long serialVersionUID =
			// 3340658590351611289L;
			//
			// public void addNewItem(String newItemCaption) {
			// cb.setImmediate(false);
			// dataStack.push(newItemCaption);
			// interpret(newItemCommand);
			// cb.setImmediate(true);
			// }
			// });
			//
			// cb.addValueChangeListener(new ValueChangeListener() {
			//
			// /**
			// *
			// */
			// private static final long serialVersionUID =
			// 2706579869793251379L;
			//
			// public void valueChange(ValueChangeEvent event) {
			// dataStack.push(cb.getContainerDataSource().getItem(
			// event.getProperty().getValue()));
			// interpret(itemSelectedCommand);
			// }
			// });
			// dataStack.push(cb);
			// break;
			new BaseWord("", "") {

				@Override
				public void execute(Interpreter interpreter) {
				}
			},

			// case NEWSELECT:
			// final String selCommand = getNextNonNopWord();
			// final Select sel = new Select();
			// sel.setCaption((String) dataStack.pop());
			// sel.setItemCaptionMode(AbstractSelect.ITEM_CAPTION_MODE_ITEM);
			// sel.setNullSelectionAllowed(false);
			// sel.setImmediate(true);
			// sel.addValueChangeListener(new ValueChangeListener() {
			// /**
			// *
			// */
			// private static final long serialVersionUID =
			// -7705548618092166199L;
			//
			// public void valueChange(ValueChangeEvent event) {
			// Item item = sel.getContainerDataSource().getItem(
			// event.getProperty().getValue());
			// dataStack.push(item);
			// interpret(selCommand);
			// }
			// });
			// dataStack.push(sel);
			// break;
			new BaseWord("", "") {
				@Override
				public void execute(Interpreter interpreter) {
				}
			},

			// case NEWLISTSELECT:
			// final String lselCommand = getNextNonNopWord();
			// final ListSelect lsel = new ListSelect();
			// lsel.setCaption((String) dataStack.pop());
			// lsel.setItemCaptionMode(AbstractSelect.ITEM_CAPTION_MODE_ITEM);
			// lsel.setNullSelectionAllowed(false);
			// lsel.setImmediate(true);
			// lsel.addValueChangeListener(new ValueChangeListener() {
			// /**
			// *
			// */
			// private static final long serialVersionUID =
			// -5523488417834167806L;
			//
			// public void valueChange(ValueChangeEvent event) {
			// Item item = lsel.getContainerDataSource().getItem(
			// event.getProperty().getValue());
			// dataStack.push(item);
			// interpret(lselCommand);
			// }
			// });
			// dataStack.push(lsel);
			// break;
			new BaseWord("", "") {
				@Override
				public void execute(Interpreter interpreter) {
				}
			},

			// case SETCONTAINERDATASOURCE:
			// Container cont = (Container) dataStack.pop();
			// AbstractSelect as = (AbstractSelect) dataStack.pop();
			// as.setContainerDataSource(cont);
			// dataStack.push(as);
			// break;
			new BaseWord("", "") {
				@Override
				public void execute(Interpreter interpreter) {
				}
			},

			// case SETCOLUMHEADERS:
			// table = (Table) dataStack.pop();
			// table.setColumnHeaders((String[]) sql
			// .getArrayFromList(new String[0]));
			// break;
			new BaseWord("", "") {
				@Override
				public void execute(Interpreter interpreter) {
				}
			}

	// case SETVISIBLECOLUMNS:
	// table = (Table) dataStack.pop();
	// table.setVisibleColumns((String[]) sql
	// .getArrayFromList(new String[0]));
	// break;
	//

	};

}
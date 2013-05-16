package com.github.mjvesa.f4v.wordset;

import com.github.mjvesa.f4v.BaseWord;
import com.github.mjvesa.f4v.Interpreter;
import com.github.mjvesa.f4v.Word;
import com.vaadin.data.Item;

public class SQLWordSet extends WordSet {

	@Override
	public Word[] getWords() {
		return new Word[] {

		new BaseWord("create-SQL-container", "", Word.POSTPONED) {
			@Override
			public void execute(Interpreter interpreter) {

				String str = (String) interpreter.popData();
				interpreter.pushData(interpreter.getSQL()
						.createIndexedContainerFromQuery(str, false));

			}
		},

		new BaseWord("create-filtered-SQL-container", "", Word.POSTPONED) {
			@Override
			public void execute(Interpreter interpreter) {
				String str = (String) interpreter.popData();
				interpreter.pushData(interpreter.getSQL()
						.createIndexedContainerFromQuery(str, true));
			}
		},

		new BaseWord("do-query", "", Word.POSTPONED) {
			@Override
			public void execute(Interpreter interpreter) {
				interpreter.getSQL().doQuery((String) interpreter.popData());
			}
		},

		new BaseWord("get-property", "", Word.POSTPONED) {
			@Override
			public void execute(Interpreter interpreter) {
				String str = (String) interpreter.popData();
				Item item = (Item) interpreter.popData();
				interpreter.pushData(item);
				interpreter.pushData(item.getItemProperty(str).getValue());
			}
		},

		new BaseWord("set-property", "", Word.POSTPONED) {
			@Override
			public void execute(Interpreter interpreter) {
				String value = (String) interpreter.popData();
				String property = (String) interpreter.popData();
				Item item = (Item) interpreter.popData();
				item.getItemProperty(property).setValue(value);
			}
		}

		};
	}

}

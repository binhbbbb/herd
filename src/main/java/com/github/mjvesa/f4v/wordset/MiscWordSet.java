package com.github.mjvesa.f4v.wordset;

import com.github.mjvesa.f4v.BaseWord;
import com.github.mjvesa.f4v.Interpreter;
import com.github.mjvesa.f4v.Parser;
import com.github.mjvesa.f4v.Util;
import com.github.mjvesa.f4v.Word;

public class MiscWordSet extends WordSet {

	protected Word[] words = {

			new BaseWord(
					"LITERAL",
					"Literal, which simply pushes its parameter field onto the data stack.",
					Word.POSTPONED) {
				@Override
				public void execute(Interpreter interpreter) {
					interpreter.pushData(interpreter.getCurrentParam());
				}
			},

			new BaseWord("PRINT", "", Word.POSTPONED) {
				@Override
				public void execute(Interpreter interpreter) {
					interpreter.print(interpreter.popData().toString());
				}
			},

			new BaseWord("(", "Begins a comment", Word.POSTPONED) {
				@Override
				public void execute(Interpreter interpreter) {
					Parser parser = interpreter.getParser();
					String str = parser.getNextWord();
					while (!")".equals(str)) {
						str = parser.getNextWord();
					}
				}
			},

			new BaseWord("NULL", "Pushes null onto the stack", Word.POSTPONED) {
				@Override
				public void execute(Interpreter interpreter) {
					interpreter.pushData(Util.NULL_OBJECT);
				}
			},

			new BaseWord("EQUALS", "Checks the equality of two objects",
					Word.POSTPONED) {
				@Override
				public void execute(Interpreter interpreter) {
					Object o1 = interpreter.popData();
					Object o2 = interpreter.popData();
					interpreter.pushData(o1.equals(o2));

				}
			},

			new BaseWord("LIST_TERMINATOR", "", Word.POSTPONED) {
				@Override
				public void execute(Interpreter interpreter) {
					interpreter.pushData(Util.LIST_TERMINATOR);
				}
			},

			new BaseWord("REQUIRE", "Loads a source file and executes it",
					Word.POSTPONED) {
				@Override
				public void execute(Interpreter interpreter) {
					String str = (String) interpreter.popData();
					interpreter.interpret(interpreter.getSource(str));
				}
			},

			new BaseWord("PRINTSTACK", "", Word.POSTPONED) {
				@Override
				public void execute(Interpreter interpreter) {
					interpreter.printStack();
				}
			}, new BaseWord("LOG", "", Word.POSTPONED) {
				@Override
				public void execute(Interpreter interpreter) {
					interpreter.print((String) interpreter.popData());
				}
			} };

}

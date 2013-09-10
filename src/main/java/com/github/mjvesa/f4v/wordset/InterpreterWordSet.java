/*
 *  Copyright 2012 Matti Vesa
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you
 *  may not use this file except in compliance with the License. You may
 *  obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *  implied. See the License for the specific language governing
 *  permissions and limitations under the License.
 */
package com.github.mjvesa.f4v.wordset;

import com.github.mjvesa.f4v.BaseWord;
import com.github.mjvesa.f4v.CompiledWord;
import com.github.mjvesa.f4v.DefinedWord;
import com.github.mjvesa.f4v.Interpreter;
import com.github.mjvesa.f4v.Word;

public class InterpreterWordSet extends WordSet {

	@Override
	public Word[] getWords() {
		return new Word[] {

				new BaseWord("[", "BEGININTERPRET", Word.IMMEDIATE) {

					@Override
					public void execute(Interpreter interpreter) {
						interpreter.setCompiling(false);
					}
				},

				new BaseWord("]", "ENDINTERPRET", Word.IMMEDIATE) {

					@Override
					public void execute(Interpreter interpreter) {
						interpreter.setCompiling(true);
					}
				},

				new BaseWord(
						"'",
						"Resolves the next word in the stream to a word in the dictionary",
						Word.POSTPONED) {

					@Override
					public void execute(Interpreter interpreter) {
						interpreter.pushData(interpreter.getNextWord());
					}
				},

				new BaseWord(
						"[']",
						"Resolves the next word in the stream to a word in the dictionary. Immediate version of ' (TICK)",
						Word.IMMEDIATE) {

					@Override
					public void execute(Interpreter interpreter) {
						interpreter.pushData(interpreter.getNextWord());
					}
				},

				new BaseWord("find",
						"Resolves the word defined by the string at TOS",
						Word.POSTPONED) {

					@Override
					public void execute(Interpreter interpreter) {
						String s = (String) interpreter.popData();
						Word word = interpreter.getDictionary().get(s);
						interpreter.pushData(word);
					}
				},

				new BaseWord("execute", "Executes the word at TOS",
						Word.POSTPONED) {

					@Override
					public void execute(Interpreter interpreter) {
						Word word = (Word) interpreter.popData();
						interpreter.execute(word);
					}
				},

				new BaseWord("word", "Parses the next word in the stream",
						Word.POSTPONED) {

					@Override
					public void execute(Interpreter interpreter) {
						String s = interpreter.getParser().getNextWord();
						interpreter.pushData(s);
					}
				},

				new BaseWord("create", "", Word.POSTPONED) {

					@Override
					public void execute(Interpreter interpreter) {
						interpreter.create();
					}
				},

				new BaseWord("stack-create", "", Word.POSTPONED) {

					@Override
					public void execute(Interpreter interpreter) {
						interpreter.createFromStack();
					}
				},

				new BaseWord("does>", "", Word.POSTPONED) {

					@Override
					public void execute(Interpreter interpreter) {
						CompiledWord[] code = interpreter.getCode();

						// Find where DOES> is
						int i = code.length - 1;
						while (!"does>".equals(code[i].getName())) {
							i--;
						}
						i++; // We don't want to copy DOES> now do we
						// Copy words over TODO use array stuff for this?
						for (; i < code.length; i++) {
							interpreter.addToCurrentDefinition(code[i]);
						}
						interpreter.finishCompilation();
						interpreter.setIp(code.length); // Don't execute stuff
														// after
														// DOES>
					}
				},

				new BaseWord("immediate",
						"Marks the current definition as immediate",
						Word.POSTPONED) {

					@Override
					public void execute(Interpreter interpreter) {
						interpreter.getCurrentDefinition().setImmediate(true);
					}
				},

				new BaseWord(
						"compile",
						"When executed, adds the compiled word at TOS to the current definition",
						Word.POSTPONED) {

					@Override
					public void execute(Interpreter interpreter) {
						interpreter
								.addToCurrentDefinition((CompiledWord) interpreter
										.popData());
					}
				},

				new BaseWord(":", "Creates a new definition", Word.IMMEDIATE) {

					@Override
					public void execute(Interpreter interpreter) {
						interpreter.create();
					}
				},

				new BaseWord(
						"anon-create",
						"Creates a definition without a name, an anonymous definition",
						Word.POSTPONED) {
					@Override
					public void execute(Interpreter interpreter) {
						interpreter.anonCreate();
					}
				},

				new BaseWord(";", "Finish compilation", Word.IMMEDIATE) {

					@Override
					public void execute(Interpreter interpreter) {
						interpreter.finishCompilation();
					}
				},

				new BaseWord("xt?", "", Word.POSTPONED) {

					@Override
					public void execute(Interpreter interpreter) {
						interpreter
								.pushData(interpreter.popData() instanceof Word);
					}
				},

				new BaseWord(
						",",
						"Generates a literal word into the current definition from a value at TOS",
						Word.POSTPONED) {

					@Override
					public void execute(Interpreter interpreter) {
						interpreter.generateLiteral(interpreter.popData());
					}
				},
				
				new BaseWord(
						"require",
						"Executes the buffer defined by the next word in the stream",
						Word.POSTPONED) {

					@Override
					public void execute(Interpreter interpreter) {
						String bufferName = interpreter.getParser().getNextWord();
						String source = interpreter.getSource(bufferName);
						interpreter.interpret(source);
					}
				} };

	}
}

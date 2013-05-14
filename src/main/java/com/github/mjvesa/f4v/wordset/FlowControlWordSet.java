package com.github.mjvesa.f4v.wordset;

import com.github.mjvesa.f4v.BaseWord;
import com.github.mjvesa.f4v.CompiledWord;
import com.github.mjvesa.f4v.Interpreter;
import com.github.mjvesa.f4v.Word;

public class FlowControlWordSet extends WordSet {

	protected static Word[] words = {

			new BaseWord(
					"DO",
					"Beginning of DO loop. (n1 n2 -- ) Expects begin and end counter values to be at TOS and NOS",
					Word.POSTPONED) {

				@Override
				public void execute(Interpreter interpreter) {
					interpreter.pushReturn(interpreter.getIp());
				}
			},

			new BaseWord("LOOP", "", Word.POSTPONED) {

				@Override
				public void execute(Interpreter interpreter) {
					Integer a = (Integer) interpreter.popData();
					a++;
					Integer b = (Integer) interpreter.popData();
					if (a < b) {
						Integer ip = interpreter.popReturn();
						interpreter.pushReturn(ip);
						interpreter.pushData(b);
						interpreter.pushData(a);
					} else {
						interpreter.popReturn();
					}
				}
			},

			new BaseWord("IF", "", Word.POSTPONED) {

				@Override
				public void execute(Interpreter interpreter) {
					Boolean bool = (Boolean) interpreter.popData();
					// If false, skip to endif
					if (!bool) {
						// TODO The same thing is done in ELSE, could it be
						// moved to Interpreter?
						interpreter.setIp(interpreter.getIp()
								+ (Integer) ((CompiledWord) interpreter
										.getExecutedWord()).getParameter());
					}
				}
			},

			new BaseWord("ELSE", "", Word.POSTPONED) {

				@Override
				public void execute(Interpreter interpreter) {
					interpreter.setIp(interpreter.getIp()
							+ (Integer) ((CompiledWord) interpreter
									.getExecutedWord()).getParameter());
				}
			},

			new BaseWord("ENDIF", "", Word.IMMEDIATE) {

				@Override
				public void execute(Interpreter interpreter) {
					// Find latest IF
					// set current address minus one as parameter
					int i = interpreter.getCurrentDefinitionSize() - 1;
					int jumpDest = i;
					while (!"IF".equals(interpreter.getFromCurrentDefinition(i)
							.getName()) && (i >= 0)) {
						CompiledWord word = interpreter
								.getFromCurrentDefinition(i);
						if ("ELSE".equals(word.getName())) {
							word.setParameter(jumpDest - i);
							jumpDest = i; // IF jumps to word after else
						}
						i--;
					}
					if (i < 0) {
						throw new RuntimeException();
					}
					interpreter.getFromCurrentDefinition(i).setParameter(
							jumpDest - i);
				}
			},

			new BaseWord("BEGIN", "", Word.POSTPONED) {

				@Override
				public void execute(Interpreter interpreter) {
					interpreter.pushReturn(interpreter.getIp());
				}
			},

			new BaseWord("WHILE", "", Word.POSTPONED) {

				@Override
				public void execute(Interpreter interpreter) {
					Boolean bool = (Boolean) interpreter.popData();
					if (!bool) {
						Word[] code = interpreter.getCode();
						int ip = interpreter.getIp();
						while (!"REPEAT".equals(code[ip].getName())) {
							ip++;
						}
						interpreter.setIp(ip);
						interpreter.popReturn();
					}
				}
			},

			new BaseWord("REPEAT", "", Word.IMMEDIATE) {

				@Override
				public void execute(Interpreter interpreter) {
					interpreter.pushReturn(interpreter.getIp());
				}
			},

			new BaseWord("<0", "LESSTHANZERO", Word.POSTPONED) {

				@Override
				public void execute(Interpreter interpreter) {
					interpreter.pushData((Boolean) ((Integer) interpreter
							.popData() < 0));
				}
			},

			new BaseWord("=0", "ZERO", Word.POSTPONED) {

				@Override
				public void execute(Interpreter interpreter) {
					interpreter.pushData((Boolean) ((Integer) interpreter
							.popData() == 0));

				}
			},

			new BaseWord(">0", "GREATERTHANZERO", Word.POSTPONED) {

				@Override
				public void execute(Interpreter interpreter) {
					interpreter.pushData((Boolean) ((Integer) interpreter
							.popData() > 0));
				}
			},

			new BaseWord("", "", Word.POSTPONED) {

				@Override
				public void execute(Interpreter interpreter) {
				}
			},

			// case LESSTHAN:
			// a = (Integer) dataStack.pop();
			// b = (Integer) dataStack.pop();
			// dataStack.push((Boolean) (b < a));
			// break;

			new BaseWord("", "", Word.POSTPONED) {

				@Override
				public void execute(Interpreter interpreter) {
				}
			},

			// case EQUALS:
			// a = (Integer) dataStack.pop();
			// b = (Integer) dataStack.pop();
			// dataStack.push((Boolean) (b.intValue() == a.intValue()));
			// break;

			new BaseWord("", "", Word.POSTPONED) {

				@Override
				public void execute(Interpreter interpreter) {
				}
			},

			// case GREATERTHAN: // (a b -- a > b )
			// b = (Integer) dataStack.pop();
			// a = (Integer) dataStack.pop();
			// dataStack.push((Boolean) (a > b));
			// break;
			//

			new BaseWord("", "", Word.POSTPONED) {

				@Override
				public void execute(Interpreter interpreter) {
				}

			}
	// case NOT:
	// bool = (Boolean) dataStack.pop();
	// dataStack.push(!bool);
	// break;

	};

}

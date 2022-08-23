package org.example;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import gen.spiqLexer;
import gen.spiqParser;

public class Main {
	public static void main(String[] args) {
		System.err.println(nlJoin("",
" ________  ________  ___  ________      ",
"|\\  _____\\|\\   __  \\|\\  \\|\\   __  \\     ",
"\\ \\  \\____| \\  \\_\\  \\ \\  \\ \\  \\ \\  \\    ",
" \\ \\_____  \\ \\   ____\\ \\  \\ \\  \\ \\  \\   ",
"  \\|____|\\  \\ \\  \\___|\\ \\  \\ \\  \\_\\  \\  ",
"     ___\\_\\  \\ \\__\\    \\ \\__\\ \\_____  \\ ",
"    |\\________\\|__|     \\|__|\\|___| \\__\\",
"    \\|_________|                   \\|__|\n"));
		
		if(args.length < 2) {
			System.err.println("\nError: No input files specified.\n");
			System.err.flush();
			System.exit(-1);
		}

		final String filename = args[1];
		System.out.println("Reading \"" + filename + "\"");

		CharStream chars = getCharStreamFromFile(filename);
    	spiqLexer lexer = new spiqLexer(chars);
    	CommonTokenStream tokens = new CommonTokenStream(lexer);
    	spiqParser parser = new spiqParser(tokens);

    	System.out.println("Generating ST via lexer and parser.");
    	ParseTree st = parser.prog();
    	System.out.println("You had " + lexer.lexicalErrors + " lexical errors and " + parser.getNumberOfSyntaxErrors() + " syntax errors.\\n");
	}

	private static CharStream getCharStreamFromFile(final String filename) {
		try {
			return CharStreams.fromFileName(filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String nlJoin(String... lines) {
		String code = null;
		for (final String line : lines) {
			if (line != null) code = (code == null ? "" : code + "\n") + line;
		}
		return code;
	}
}
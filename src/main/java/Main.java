import java.io.IOException;

import org.antlr.v4.runtime.CharStreams;

import compiler.SpiqCompiler;

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

		String filename;
		
		if(args.length < 2) {
			//System.err.println("\nError: No input files specified.\n");
			//System.err.flush();
			//System.exit(-1);
			filename = "prova.spiq";
		} else {
			filename = args[1];
		}

		System.out.println("Reading \"" + filename + "\"");

		try {
			SpiqCompiler.getInstance().compile(CharStreams.fromFileName(filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String nlJoin(String... lines) {
		String code = null;
		for (final String line : lines) {
			if (line != null) code = (code == null ? "" : code + "\n") + line;
		}
		return code;
	}
}
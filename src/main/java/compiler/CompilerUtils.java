package compiler;

public class CompilerUtils {

	public static String extractNodeName(String s) { // s is in the form compiler.AST$NameNode
    	return s.substring(s.lastIndexOf('$')+1, s.length()-4);
    }

	public static String extractCtxName(String s) { // s is in the form compiler.FOOLParser$NameContext
		return s.substring(s.lastIndexOf('$')+1, s.length()-7);
    }
	
	public static String lowerizeFirstChar(String s) {
    	return Character.toLowerCase(s.charAt(0)) + s.substring(1);
    }
    
	public static int typeErrors = 0;

	// crea un'unica stringa a partire da un insieme di stringhe concatenadole e 
	// introducendo, all'interno, dei newline "\n" come separatore tra le stringhe
	public static String nlJoin(String... lines) { //argomenti null ignorati 
		String code = null;
		for (final String line : lines) {
			if (line != null) code = (code == null ? "" : code + "\n") + line;
		}
		return code;
	}

	private static int labCount = 0;

	public static String freshLabel() {
		return "label" + (labCount++);
	}

	private static int funlabCount = 0;

	public static String freshFunLabel() {
		return "function" + (funlabCount++);
	}

	private static String funCode = null;

	public static void putCode(String c) {
		funCode = nlJoin(funCode, "", c); //linea vuota di separazione prima di codice funzione
	}

	public static String getCode() {
		return funCode;
	}
}
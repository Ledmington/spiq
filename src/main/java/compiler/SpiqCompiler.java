package compiler;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import compiler.ast.Node;
import gen.spiqLexer;
import gen.spiqParser;

public class SpiqCompiler {
    
    private static SpiqCompiler compiler = null;

    private SpiqCompiler() {}

    public static SpiqCompiler getInstance() {
        if(compiler == null) {
            compiler = new SpiqCompiler();
        }
        return compiler;
    }

    public int compile(final CharStream stream) {
        return this.compile(stream.toString());
    }

    public int compile(final String code) {
        CharStream chars = CharStreams.fromString(code);
    	spiqLexer lexer = new spiqLexer(chars);
    	CommonTokenStream tokens = new CommonTokenStream(lexer);
    	spiqParser parser = new spiqParser(tokens);

        ParseTree st = parser.prog();

        ASTGenerationSTVisitor visitor = new ASTGenerationSTVisitor(); // use true to visualize the ST
    	Node ast = visitor.visit(st);

        return lexer.lexicalErrors;
    }
}

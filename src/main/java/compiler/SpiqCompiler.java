package compiler;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import compiler.ast.Node;
import gen.spiqLexer;
import gen.spiqParser;

public class SpiqCompiler {

    public SpiqCompiler() {
    }

    public int compile(final CharStream stream) {
        return this.compile(stream.toString());
    }

    public int compile(final String code) {
        CharStream chars = CharStreams.fromString(code);
        spiqLexer lexer = new spiqLexer(chars);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        for (Token token : tokens.getTokens()) {
            System.out.println(token);
        }
        spiqParser parser = new spiqParser(tokens);

        ParseTree st = parser.prog();

        ASTGenerationSTVisitor visitor = new ASTGenerationSTVisitor(); // use true to visualize the ST
        Node ast = visitor.visit(st); // TODO fix unused "ast"

        return lexer.lexicalErrors;
    }
}

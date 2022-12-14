/*
 * Copyright (C) 2022-2022 Filippo Barbari <filippo.barbari@gmail.com>
 *
 * This file is part of spiq.
 *
 * spiq can not be copied and/or distributed without
 * the express permission of Filippo Barbari.
 */
package com.ledmington.spiq.interpreter;

public record CompilationResult(
        int lexicalErrors, int parserErrors, int symtableErrors, /*int typeErrors,*/ int runtimeErrors) {
    public boolean ok() {
        return lexicalErrors == 0
                && parserErrors == 0
                && symtableErrors == 0
                && /*typeErrors == 0 &&*/ runtimeErrors == 0;
    }
}

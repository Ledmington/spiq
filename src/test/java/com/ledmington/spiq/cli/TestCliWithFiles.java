/*
 * Copyright (C) 2022-2022 Filippo Barbari <filippo.barbari@gmail.com>
 *
 * This file is part of spiq.
 *
 * spiq can not be copied and/or distributed without
 * the express permission of Filippo Barbari.
 */
package com.ledmington.spiq.cli;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.nio.file.Path;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import picocli.CommandLine;

import com.ledmington.spiq.SpiqCli;
import com.ledmington.spiq.utils.SpiqUtils;

public final class TestCliWithFiles {

    private File input;

    @TempDir
    private Path folder;

    @BeforeEach
    public void setup() {
        final Path path = folder.resolve("prova.spiq");
        input = path.toFile();
    }

    @Test
    public void passAFile() {
        assertEquals(0, new CommandLine(new SpiqCli()).execute(SpiqUtils.split(input.getAbsolutePath())));
    }
}

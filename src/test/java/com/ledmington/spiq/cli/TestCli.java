/*
 * Copyright (C) 2022-2024 Filippo Barbari <filippo.barbari@gmail.com>
 *
 * This file is part of spiq.
 *
 * spiq can not be copied and/or distributed without
 * the express permission of Filippo Barbari.
 */
package com.ledmington.spiq.cli;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import picocli.CommandLine;

import com.ledmington.spiq.SpiqCli;
import com.ledmington.spiq.utils.SpiqUtils;

public final class TestCli {
    @ParameterizedTest
    @ValueSource(strings = {"-h", "--help"})
    public void printHelp(final String s) {
        assertEquals(0, new CommandLine(new SpiqCli()).execute(SpiqUtils.split(s)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-V", "--version"})
    public void printVersion(final String s) {
        assertEquals(0, new CommandLine(new SpiqCli()).execute(SpiqUtils.split(s)));
    }
}

/*
 * Copyright (C) 2022-2022 Filippo Barbari <filippo.barbari@gmail.com>
 *
 * This file is part of spiq.
 *
 * spiq can not be copied and/or distributed without
 * the express permission of Filippo Barbari.
 */
package com.ledmington.spiq.utils;

public final class SpiqUtils {
    public static String nlJoin(final String... lines) {
        String code = null;
        for (final String line : lines) {
            if (line != null) code = (code == null ? "" : code + "\n") + line;
        }
        return code;
    }

    public static String[] split(final String line) {
        return line.trim().split("[ \t]+");
    }
}

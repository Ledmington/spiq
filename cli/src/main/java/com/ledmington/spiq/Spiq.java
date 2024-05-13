/*
* spiq - Human readable programming language
* Copyright (C) 2022-2024 Filippo Barbari <filippo.barbari@gmail.com>
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package com.ledmington.spiq;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public final class Spiq {

    public static void main(final String[] args) {
        System.err.println(String.join(
                "\n",
                "",
                " ________  ________  ___  ________      ",
                "|\\  _____\\|\\   __  \\|\\  \\|\\   __  \\     ",
                "\\ \\  \\____| \\  \\_\\  \\ \\  \\ \\  \\ \\  \\    ",
                " \\ \\_____  \\ \\   ____\\ \\  \\ \\  \\ \\  \\   ",
                "  \\|____|\\  \\ \\  \\___|\\ \\  \\ \\  \\_\\  \\  ",
                "     ___\\_\\  \\ \\__\\    \\ \\__\\ \\_____  \\ ",
                "    |\\________\\|__|     \\|__|\\|___| \\__\\",
                "    \\|_________|                   \\|__|\n"));

        final String filename;
        if (args.length == 0) {
            System.err.println("Expected a filename.");
            System.exit(-1);
        }

        filename = args[0];

        System.out.println("Reading \"" + filename + "\"");

        try {
            System.out.println(Files.readString(new File(filename).toPath()));
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }
}

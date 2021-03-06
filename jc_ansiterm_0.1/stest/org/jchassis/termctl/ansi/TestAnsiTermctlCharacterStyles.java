/***************************************************************************

    Copyright (C) 2004 Sam Stainsby. All rights reserved.

    This file is part of the JChassis Project.

    JChassis is free software; you can redistribute it and/or
    modify it under the terms of version 2.1 of the GNU Lesser
    General Public License as published by the Free Software Foundation.

    JChassis is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
    Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public
    License along with this library; if not, write to:

        Free Software Foundation, Inc.,
        59 Temple Place, Suite 330, Boston, MA  02111-1307 USA

    At the time of writing, the license can also be found on the
    world-wide web at:

        http://www.fsf.org/licenses/lgpl.txt

    JChassis project management can be contacted via email sent to
    sjstainsby@yahoo.com.au.

***************************************************************************/

package org.jchassis.termctl.ansi;

import org.jchassis.geom.int2d.*;
import org.jchassis.termctl.*;


/**
 * tests the motion of the cursor under the ANSI/VT100TerminalController
 * implementation
 *
 * <P><FONT SIZE=-1 COLOR="GRAY">
 * Copyright &copy; 2004 Sam Stainsby.<BR>
 * Verbatim copying and distribution of this entire generated javadoc
 * document is permitted in any medium, provided this notice is preserved.
 * </FONT>
 */
public class TestAnsiTermctlCharacterStyles extends TestAnsiTermctlBase {

    public static void main(String[] args) throws Exception {
        TestAnsiTermctlBase test = new TestAnsiTermctlCharacterStyles();
        test.init();
        test.run();
        test.end();
    }

    public void run() throws Exception {

        TerminalController terminal = getTerminal();
        
        terminal.setForegroundColor(CharacterColor.CYAN);
        terminal.setBackgroundColor(CharacterColor.BLUE);
        terminal.putCharacters("foreground is CYAN, background is BLUE");
        
        StyledCharacterTerminal styles = (StyledCharacterTerminal) terminal;

        int row = 1; // screen row

        boolean reverseVideo = false;
        // loop: reverseVideo = false then true
        for (int i = 0; i < 2; i++) {

            styles.setReverseVideo(reverseVideo);

            boolean blink = false;
            // loop: blink = false then true
            for (int j = 0; j < 2; j++) {

                styles.setBlink(blink);

                boolean underscore = false;
                // loop: underscore = false then true
                for (int m = 0; m < 2; m++) {

                    styles.setUnderscore(underscore);

                    boolean bold = false;
                    // loop: bold = false then true
                    for (int n = 0; n < 2; n++) {

                        styles.setBold(bold);

                        Point rowStart = new ConstantPoint(0, row);

                        terminal.setCursorPosition(rowStart);
                        terminal.putCharacters("bold="
                                               + makeString(bold));
                        terminal.putCharacters(",");
                        terminal.putCharacters("underscore="
                                               + makeString(underscore));
                        terminal.putCharacters(",");
                        terminal.putCharacters("blink="
                                               + makeString(blink));
                        terminal.putCharacters(",");
                        terminal.putCharacters("reverseVideo="
                                               + makeString(reverseVideo));

                        row++;

                        bold = !bold;
                    }

                    underscore = !underscore;
                }

                blink = !blink;
            }

            reverseVideo = !reverseVideo;
        }

        styles.clearCharacterStyles();

        // one more line in normal

        Point rowStart = new ConstantPoint(0, row);
        terminal.setCursorPosition(rowStart);
        terminal.putCharacters("ALL CHARACTER STYLES OFF");
        row++;
        rowStart = new ConstantPoint(0, row);
        terminal.setCursorPosition(rowStart);
    }

    private String makeString(boolean value) {
        return (value ? "true " : "false");
    }
}

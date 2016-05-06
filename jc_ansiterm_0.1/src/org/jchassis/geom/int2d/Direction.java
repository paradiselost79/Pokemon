/***************************************************************************

    Copyright (C) 2003-2005 Sam Stainsby. All rights reserved.

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

package org.jchassis.geom.int2d;

/**
 * A direction (also called a vector) in the space of point i x j, where
 * i and j are Java 'int' values.
 * Commonly used "directions" (vectors of length 1) are presented as convenient 
 * contants.
 *
 * <P><FONT SIZE=-1 COLOR="GRAY">
 * Copyright &copy; 2003-2005 Sam Stainsby.<BR>
 * Verbatim copying and distribution of this entire generated javadoc
 * document is permitted in any medium, provided this notice is preserved.
 * </FONT>
 */
public final class Direction extends ConstantPoint {

    /** the 'up' direction (0, 1) */
    public static final Direction UP = new Direction(0, 1);
    
    /** the 'down' direction (0, -1) */
    public static final Direction DOWN = new Direction(0, -1);
    
    /** the 'left' direction (-1, 0) */
    public static final Direction LEFT = new Direction(-1, 0);
    
    /** the 'right' direction (1, 0) */
    public static final Direction RIGHT = new Direction(1, 0);

    private Direction(int x, int y) {
        super(x, y);
    }
}

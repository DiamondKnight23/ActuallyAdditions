/*
 * This file ("INEIRecipeHandler.java") is part of the Actually Additions Mod for Minecraft.
 * It is created and owned by Ellpeck and distributed
 * under the Actually Additions License to be found at
 * http://ellpeck.de/actaddlicense/
 * View the source code at https://github.com/Ellpeck/ActuallyAdditions
 *
 * © 2016 Ellpeck
 */

package de.ellpeck.actuallyadditions.nei;

import de.ellpeck.actuallyadditions.booklet.page.BookletPage;

public interface INEIRecipeHandler{

    BookletPage getPageForInfo(int neiIndex);
}

/*
 * This file ("ISmileyCloudEasterEgg.java") is part of the Actually Additions Mod for Minecraft.
 * It is created and owned by Ellpeck and distributed
 * under the Actually Additions License to be found at
 * http://ellpeck.de/actaddlicense/
 * View the source code at https://github.com/Ellpeck/ActuallyAdditions
 *
 * © 2016 Ellpeck
 */

package de.ellpeck.actuallyadditions.misc.cloud;

public interface ISmileyCloudEasterEgg{

    /**
     * Extra rendering function
     */
    void renderExtra(float f);

    /**
     * The name the cloud has to have for this effect to occur
     */
    String[] getTriggerNames();
}

package ellpeck.actuallyadditions.proxy;


import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import ellpeck.actuallyadditions.blocks.InitBlocks;
import ellpeck.actuallyadditions.blocks.render.*;
import ellpeck.actuallyadditions.config.values.ConfigBoolValues;
import ellpeck.actuallyadditions.config.values.ConfigIntValues;
import ellpeck.actuallyadditions.event.RenderPlayerEventAA;
import ellpeck.actuallyadditions.tile.*;
import ellpeck.actuallyadditions.update.UpdateChecker;
import ellpeck.actuallyadditions.util.ModUtil;
import ellpeck.actuallyadditions.util.Util;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.MinecraftForgeClient;

@SuppressWarnings("unused")
public class ClientProxy implements IProxy{

    public static int COMPOST_RENDER_ID;
    public static int FISHING_NET_RENDER_ID;
    public static int FURNACE_SOLAR_RENDER_ID;
    public static int COFFEE_MACHINE_RENDER_ID;
    public static int PHANTOM_BOOSTER_RENDER_ID;
    public static int SMILEY_CLOUD_RENDER_ID;

    @Override
    public void preInit(){
        ModUtil.LOGGER.info("PreInitializing ClientProxy...");

        if(ConfigBoolValues.DO_UPDATE_CHECK.isEnabled()){
            new UpdateChecker().init();
        }
    }

    @Override
    public void init(){
        ModUtil.LOGGER.info("Initializing ClientProxy...");

        COMPOST_RENDER_ID = RenderingRegistry.getNextAvailableRenderId();
        FISHING_NET_RENDER_ID = RenderingRegistry.getNextAvailableRenderId();
        FURNACE_SOLAR_RENDER_ID = RenderingRegistry.getNextAvailableRenderId();
        COFFEE_MACHINE_RENDER_ID = RenderingRegistry.getNextAvailableRenderId();
        PHANTOM_BOOSTER_RENDER_ID = RenderingRegistry.getNextAvailableRenderId();
        SMILEY_CLOUD_RENDER_ID = RenderingRegistry.getNextAvailableRenderId();

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCompost.class, new RenderTileEntity(new ModelCompost()));
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(InitBlocks.blockCompost), new RenderItems(new ModelCompost()));

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFishingNet.class, new RenderTileEntity(new ModelFishingNet()));
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(InitBlocks.blockFishingNet), new RenderItems(new ModelFishingNet()));

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFurnaceSolar.class, new RenderTileEntity(new ModelFurnaceSolar()));
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(InitBlocks.blockFurnaceSolar), new RenderItems(new ModelFurnaceSolar()));

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCoffeeMachine.class, new RenderTileEntity(new ModelCoffeeMachine()));
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(InitBlocks.blockCoffeeMachine), new RenderItems(new ModelCoffeeMachine()));

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPhantomBooster.class, new RenderTileEntity(new ModelPhantomBooster()));
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(InitBlocks.blockPhantomBooster), new RenderItems(new ModelPhantomBooster()));

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySmileyCloud.class, new RenderSmileyCloud(new ModelSmileyCloud()));
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(InitBlocks.blockSmileyCloud), new RenderItems(new ModelSmileyCloud()));

        VillagerRegistry.instance().registerVillagerSkin(ConfigIntValues.JAM_VILLAGER_ID.getValue(), new ResourceLocation(ModUtil.MOD_ID_LOWER, "textures/entity/villager/jamVillager.png"));

        Util.registerEvent(new RenderPlayerEventAA());
    }

    @Override
    public void postInit(){
        ModUtil.LOGGER.info("PostInitializing ClientProxy...");
    }
}

package net.steveson.solidgoldstairs.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(LightningEntity.class)
public abstract class LightningBoltMixin extends Entity {
    public LightningBoltMixin(EntityType<?> type, World world) {
        super(type, world);
    }

//	@Inject(at = @At("HEAD"), method = "loadLevel")
//	private void init(CallbackInfo info) {
//		// This code is injected into the start of MinecraftServer.loadLevel()V
//	}
}
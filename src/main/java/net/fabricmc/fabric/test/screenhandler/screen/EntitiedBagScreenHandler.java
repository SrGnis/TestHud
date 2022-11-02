/*
 * Copyright (c) 2016, 2017, 2018, 2019 FabricMC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.fabricmc.fabric.test.screenhandler.screen;

import net.fabricmc.fabric.test.screenhandler.ScreenHandlerTest;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.UUID;

import static net.fabricmc.fabric.test.screenhandler.ScreenHandlerTest.LOGGER;

public class EntitiedBagScreenHandler extends BagScreenHandler {
	private final LivingEntity entity;

	public EntitiedBagScreenHandler(int syncId, PlayerInventory playerInventory, PacketByteBuf buf) {
		this(syncId, playerInventory, new SimpleInventory(9), readEntity(buf, playerInventory.player.world));
		LOGGER.warn("EntitiedBagScreenHandler buf");

	}

	public EntitiedBagScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, LivingEntity entity) {
		super(ScreenHandlerTest.ENTITIED_BAG_SCREEN_HANDLER, syncId, playerInventory, inventory);
		LOGGER.warn("EntitiedBagScreenHandler entity");
		this.entity = entity;
	}

	private static LivingEntity readEntity(PacketByteBuf buf, World world) {
		LOGGER.warn("EntitiedBagScreenHandler.readEntity");
		int id = buf.readInt();
		return (LivingEntity) world.getEntityById(id);
	}

	public LivingEntity getEntity() {
		LOGGER.warn("EntitiedBagScreenHandler.getEntity");
		return entity;
	}
}

/*
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package ai.door;

import lineage2.commons.geometry.Rectangle;
import lineage2.gameserver.ai.DoorAI;
import lineage2.gameserver.model.Player;
import lineage2.gameserver.model.Territory;
import lineage2.gameserver.model.instances.DoorInstance;
import lineage2.gameserver.model.instances.NpcInstance;
import lineage2.gameserver.utils.Util;

/**
 * @author Mobius
 * @version $Revision: 1.0 $
 */
public final class SSQDoor extends DoorAI
{
	private static final Territory room1 = new Territory().add(new Rectangle(-89696, 217741, -88858, 218085).setZmin(-7520).setZmax(-7320));
	private static final Territory room2 = new Territory().add(new Rectangle(-88773, 220765, -88429, 219596).setZmin(-7520).setZmax(-7320));
	private static final Territory room3 = new Territory().add(new Rectangle(-87485, 220463, -86501, 220804).setZmin(-7520).setZmax(-7320));
	private static final Territory room4 = new Territory().add(new Rectangle(-85646, 219054, -84787, 219408).setZmin(-7520).setZmax(-7320));
	private static final Territory room5 = new Territory().add(new Rectangle(-87739, 216646, -87159, 217842).setZmin(-7520).setZmax(-7320));
	private static final int[] ssqDoors =
	{
		17240102,
		17240104,
		17240106,
		17240108,
		17240110
	};
	
	/**
	 * Constructor for SSQDoor.
	 * @param actor DoorInstance
	 */
	public SSQDoor(DoorInstance actor)
	{
		super(actor);
	}
	
	/**
	 * Method onEvtTwiceClick.
	 * @param player Player
	 */
	@Override
	public void onEvtTwiceClick(final Player player)
	{
		final DoorInstance door = getActor();
		
		if (door.getReflection().isDefault())
		{
			return;
		}
		
		if (!Util.contains(ssqDoors, door.getDoorId()))
		{
			return;
		}
		
		if (!player.isInRange(door, 150))
		{
			return;
		}
		
		switch (door.getDoorId())
		{
			case 17240102:
				for (NpcInstance n : door.getReflection().getNpcs())
				{
					if (room1.isInside(n.getX(), n.getY(), n.getZ()) && !n.isDead())
					{
						return;
					}
				}
				
				break;
			
			case 17240104:
				for (NpcInstance n : door.getReflection().getNpcs())
				{
					if (room2.isInside(n.getX(), n.getY(), n.getZ()) && !n.isDead())
					{
						return;
					}
				}
				
				break;
			
			case 17240106:
				for (NpcInstance n : door.getReflection().getNpcs())
				{
					if (room3.isInside(n.getX(), n.getY(), n.getZ()) && !n.isDead())
					{
						return;
					}
				}
				
				break;
			
			case 17240108:
				for (NpcInstance n : door.getReflection().getNpcs())
				{
					if (room4.isInside(n.getX(), n.getY(), n.getZ()) && !n.isDead())
					{
						return;
					}
				}
				
				break;
			
			case 17240110:
				for (NpcInstance n : door.getReflection().getNpcs())
				{
					if (room5.isInside(n.getX(), n.getY(), n.getZ()) && !n.isDead())
					{
						return;
					}
				}
				
				break;
		}
		
		door.getReflection().openDoor(door.getDoorId());
	}
}
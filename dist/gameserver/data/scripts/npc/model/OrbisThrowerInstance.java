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
package npc.model;

import lineage2.gameserver.model.instances.MonsterInstance;
import lineage2.gameserver.templates.npc.NpcTemplate;

public final class OrbisThrowerInstance extends MonsterInstance
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int _weaponId;
	
	public OrbisThrowerInstance(int ObjectID, NpcTemplate temp)
	{
		super(ObjectID, temp);
		_weaponId = getParameter("weapon_id", 17372);
	}
	
	@Override
	public void startAttackStanceTask()
	{
		equipWeapon();
		super.startAttackStanceTask();
	}
	
	@Override
	public void stopAttackStanceTask()
	{
		unequipWeapon();
		super.stopAttackStanceTask();
	}
	
	private void unequipWeapon()
	{
		if (isAlikeDead())
		{
			return;
		}
		
		setRHandId(0);
		broadcastCharInfoImpl();
	}
	
	private void equipWeapon()
	{
		setRHandId(_weaponId);
		broadcastCharInfoImpl();
	}
}
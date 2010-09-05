package netsurfers.gicp.net.common;

public class Constants {
	public static final int SCREEM_WIDTH = 320;
	public static final int SCREEM_HEIGHT = 480;
	public static final long FRAME_INTERVAL = 150;
	public static final String DATABASE_TABLE_NAME[] = {
		"character",				// 0玩家存档表
		"character_equipmentsets",	// 1玩家装备表
		"character_inventory",		// 2玩家背包物品表
		"character_quest",			// 3玩家任务表
		"character_spell",			// 4玩家武功表
		"creature",					// 5生物分布表
		"creature_ai",				// 6生物AI表
		"creature_loot_template",	// 7生物掉落表
		"creature_template",		// 8生物信息表
		"gameobject",				// 9游戏物件分布表
		"gameobject_questrelation",	//10游戏物件任务表
		"gameobject_loot_template",	//11游戏物件掉落表
		"gameobject_template",		//12游戏物件信息表
		"item_template",			//13物品信息表
		"npc_trainer",				//14npc训练师表
		"npc_vendor",				//15npc售货师表
		"playercreateinfo",			//16人物创建信息表
		"playercreateinfo_item",	//17人物创建物品表
		"playercreateinfo_spell",	//18人物创建武功表
		"quest_template",			//19任务信息表
		"spell_chain"				//20武功属性表
	};
	public static final String DATABASE_TABLE00_COLUMN_NAME[] = {
		"guid",
		"test"
	};
}

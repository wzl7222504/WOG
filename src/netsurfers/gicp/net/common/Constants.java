package netsurfers.gicp.net.common;

/**
 * Constants of this application program
 * 
 * @author Ziliang Wang
 * @author E-mail: Lional.King@gmail.com
 */
public class Constants {

	public static float SCREEM_WIDTH_DEFAULT = 320F;
	public static float SCREEM_HEIGHT_DEFAULT = 480F;
	public static float SCREEM_HALF_WIDTH = SCREEM_WIDTH_DEFAULT / 2;
	public static float SCREEM_HALF_HEIGHT = SCREEM_HEIGHT_DEFAULT / 2;

	public static final long FRAME_INTERVAL = 65;

	public static final String DATABASE_TABLE_NAME[] = { "character",
			"character_equipmentsets", "character_inventory",
			"character_quest", "character_spell", "creature", "creature_ai",
			"creature_loot_template", "creature_template", "gameobject",
			"gameobject_questrelation", "gameobject_loot_template",
			"gameobject_template", "item_template", "npc_trainer",
			"npc_vendor", "playercreateinfo", "playercreateinfo_item",
			"playercreateinfo_spell", "quest_template", "spell_chain", };

	public static final String DATABASE_TABLE00_COLUMN_NAME[] = { "guid",
			"name", "class", "level", "xp", "money", "potential", "health",
			"mana", "power", "stamina", "energy", "agile", "intellect",
			"position_x", "position_y", "orientation", "map", };

	public static final String DATABASE_TABLE01_COLUMN_NAME[] = { "guid",
			"setguid", "item0", "item1", "item2", "item3", "item4", "item5",
			"item6", "item7", "item8", };

	public static final String DATABASE_TABLE02_COLUMN_NAME[] = { "guid",
			"bagslot", "item", "item_template", "quickslot", };

	public static final String DATABASE_TABLE03_COLUMN_NAME[] = { "guid",
			"quest", "status", };

	public static final String DATABASE_TABLE04_COLUMN_NAME[] = { "guid",
			"spell", "quickslot", };

	public static final String DATABASE_TABLE05_COLUMN_NAME[] = { "guid", "id",
			"map", "position_x", "position_y", "orientation", "spawntimesecs",
			"state", };

	public static final String DATABASE_TABLE06_COLUMN_NAME[] = { "id",
			"eventtype", "action", "quest", "words", };

	public static final String DATABASE_TABLE07_COLUMN_NAME[] = { "entry",
			"item", "chance", };

	public static final String DATABASE_TABLE08_COLUMN_NAME[] = { "entry",
			"modelid", "name", "level", "health", "mana", "npcflag",
			"attackpower", "trainer_spell", "trainer_class", "vendor_item",
			"spell1", "spell2", "spell3", "ai", "gold", };

	public static final String DATABASE_TABLE09_COLUMN_NAME[] = { "guid", "id",
			"map", "position_x", "position_y", "spawntimesecs", "state", };

	public static final String DATABASE_TABLE10_COLUMN_NAME[] = { "id",
			"quest", };

	public static final String DATABASE_TABLE11_COLUMN_NAME[] = { "entry",
			"item", "chance", };

	public static final String DATABASE_TABLE12_COLUMN_NAME[] = { "entry",
			"type", "displayid", "name", "size", };

	public static final String DATABASE_TABLE13_COLUMN_NAME[] = { "entry",
			"type", "displayid", "name", "quality", "buyprice", "sellprice",
			"requiredlevel", "maxcount", "health", "mana", "attack", "defence",
			"attackodds", };

	public static final String DATABASE_TABLE14_COLUMN_NAME[] = { "id",
			"spell", };

	public static final String DATABASE_TABLE15_COLUMN_NAME[] = { "id", "item", };

	public static final String DATABASE_TABLE16_COLUMN_NAME[] = { "class",
			"map", "position_x", "position_y", };

	public static final String DATABASE_TABLE17_COLUMN_NAME[] = { "id",
			"class", "item", };

	public static final String DATABASE_TABLE18_COLUMN_NAME[] = { "class",
			"spell", };

	public static final String DATABASE_TABLE19_COLUMN_NAME[] = { "entry",
			"req_class", "minlevel", "prev_quest_id", "next_quest_id", "title",
			"details0", "details1", "details2", "req_item0", "req_item1",
			"req_item2", "req_icount0", "req_icount1", "req_icount2",
			"req_creature0", "req_creature1", "req_creature2", "req_ccount0",
			"req_ccount1", "req_ccount2", "rew_item0", "rew_item1",
			"rew_item2", "rew_icount0", "rew_icount1", "rew_icount2",
			"rew_money", "rew_xp", "rew_spell", };

	public static final String DATABASE_TABLE20_COLUMN_NAME[] = { "spell_id",
			"displayid", "name", "prev_spell", "first_spell", "req_spell",
			"damage", "class", "type", "cost", "req_level", "audio", };

	public static enum ORIENTATION {
		DEFAULT, UP, DOWN, LEFT, RIGHT
	};
	
	public static final int RESULT_OK=-1;
	public static final int RESULT_CANCELED=0;
	public static final int RESULT_STOP=1;
}

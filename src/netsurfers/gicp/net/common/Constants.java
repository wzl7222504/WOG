package netsurfers.gicp.net.common;

import android.net.Uri;

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

	public static final String AUTHORRITIES = "netsurfers.gicp.net.provider";
	
	public static final Uri DATABASE_CONTENT_URI[] = {
		 Uri.parse("content://" + Constants.AUTHORRITIES+"/character"),					//table  0
		 Uri.parse("content://" + Constants.AUTHORRITIES+"/character_equipmentsets"),	//table  1
		 Uri.parse("content://" + Constants.AUTHORRITIES+"/character_inventory"),		//table  2
		 Uri.parse("content://" + Constants.AUTHORRITIES+"/character_quest"),			//table  3
		 Uri.parse("content://" + Constants.AUTHORRITIES+"/character_spell"),			//table  4
		 Uri.parse("content://" + Constants.AUTHORRITIES+"/creature"),					//table  5
		 Uri.parse("content://" + Constants.AUTHORRITIES+"/creature_ai"),				//table  6
		 Uri.parse("content://" + Constants.AUTHORRITIES+"/creature_loot_template"),	//table  7
		 Uri.parse("content://" + Constants.AUTHORRITIES+"/creature_template"),			//table  8
		 Uri.parse("content://" + Constants.AUTHORRITIES+"/gameobject"),				//table  9
		 Uri.parse("content://" + Constants.AUTHORRITIES+"/gameobject_questrelation"),	//table 10
		 Uri.parse("content://" + Constants.AUTHORRITIES+"/gameobject_loot_template"),	//table 11
		 Uri.parse("content://" + Constants.AUTHORRITIES+"/gameobject_template"),		//table 12
		 Uri.parse("content://" + Constants.AUTHORRITIES+"/item_template"),				//table 13
		 Uri.parse("content://" + Constants.AUTHORRITIES+"/npc_trainer"),				//table 14
		 Uri.parse("content://" + Constants.AUTHORRITIES+"/npc_vendor"),				//table 15
		 Uri.parse("content://" + Constants.AUTHORRITIES+"/playercreateinfo"),			//table 16
		 Uri.parse("content://" + Constants.AUTHORRITIES+"/playercreateinfo_item"),		//table 17
		 Uri.parse("content://" + Constants.AUTHORRITIES+"/playercreateinfo_spell"),	//table 18
		 Uri.parse("content://" + Constants.AUTHORRITIES+"/quest_template"),			//table 19
		 Uri.parse("content://" + Constants.AUTHORRITIES+"/spell_chain")				//table 20
	};
	
	public static final String DATABASE_TABLE_NAME[] = { "character",
			"character_equipmentsets", "character_inventory",
			"character_quest", "character_spell", "creature", "creature_ai",
			"creature_loot_template", "creature_template", "gameobject",
			"gameobject_questrelation", "gameobject_loot_template",
			"gameobject_template", "item_template", "npc_trainer",
			"npc_vendor", "playercreateinfo", "playercreateinfo_item",
			"playercreateinfo_spell", "quest_template", "spell_chain", };
	
	public static final String DATABASE_CONTENT_TYPE[] = { 
		"vnd.android.cursor.dir/vnd.netsurfers.character",
		"vnd.android.cursor.dir/vnd.netsurfers.character_equipmentsets", 
		"vnd.android.cursor.dir/vnd.netsurfers.character_inventory",
		"vnd.android.cursor.dir/vnd.netsurfers.character_quest", 
		"vnd.android.cursor.dir/vnd.netsurfers.character_spell", 
		"vnd.android.cursor.dir/vnd.netsurfers.creature", 
		"vnd.android.cursor.dir/vnd.netsurfers.creature_ai",
		"vnd.android.cursor.dir/vnd.netsurfers.creature_loot_template", 
		"vnd.android.cursor.dir/vnd.netsurfers.creature_template", 
		"vnd.android.cursor.dir/vnd.netsurfers.gameobject",
		"vnd.android.cursor.dir/vnd.netsurfers.gameobject_questrelation", 
		"vnd.android.cursor.dir/vnd.netsurfers.gameobject_loot_template",
		"vnd.android.cursor.dir/vnd.netsurfers.gameobject_template", 
		"vnd.android.cursor.dir/vnd.netsurfers.item_template", 
		"vnd.android.cursor.dir/vnd.netsurfers.npc_trainer",
		"vnd.android.cursor.dir/vnd.netsurfers.npc_vendor", 
		"vnd.android.cursor.dir/vnd.netsurfers.playercreateinfo", 
		"vnd.android.cursor.dir/vnd.netsurfers.playercreateinfo_item",
		"vnd.android.cursor.dir/vnd.netsurfers.playercreateinfo_spell", 
		"vnd.android.cursor.dir/vnd.netsurfers.quest_template", 
		"vnd.android.cursor.dir/vnd.netsurfers.spell_chain", };

	public static final String DATABASE_TABLE00_COLUMN_NAME[] = { "_id",
			"name", "sex", "class", "level", "xp", "money", "potential", "health",
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
	public static final int RESULT_NEW_OK=2;
	public static final int RESULT_LOAD_OK=3;
}

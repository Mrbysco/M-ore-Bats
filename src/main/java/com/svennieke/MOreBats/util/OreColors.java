package com.svennieke.MOreBats.util;

import java.awt.Color;

public class OreColors {
	
	public static Color getColor(String name) {	
		if(name.equals("oreGold")){return createColor(16766720);}
		if(name.equals("oreIron")){return createColor(8329497);}
		if(name.equals("oreLapis")){return createColor(2515356);}
		if(name.equals("oreDiamond")){return createColor(12186367);}
		if(name.equals("oreRedstone")){return createColor(16724530);}
		if(name.equals("oreEmerald")){return createColor(5294200);}
		if(name.equals("oreQuartz")){return createColor(12895428);}
		if(name.equals("oreCoal")){return createColor(6052701);}
		if(name.equals("oreTin")){return createColor(13882581);}
		if(name.equals("oreCopper")){return createColor(12088115);}
		if(name.equals("oreSilver")){return createColor(12632256);}
		if(name.equals("oreLead")){return createColor(7170661);}
		if(name.equals("oreAluminum")){return createColor(11383485);}
		if(name.equals("oreNickel")){return createColor(11908789);}
		if(name.equals("orePlatinum")){return createColor(15066338);}
		if(name.equals("oreIridium")){return createColor(16777215);}
		if(name.equals("oreMithril")){return createColor(11451355);}
		else
		{
			return Color.MAGENTA;
		}
	}
	
	public static Color createColor(int color)
	{
		return new Color(color);
	}
}

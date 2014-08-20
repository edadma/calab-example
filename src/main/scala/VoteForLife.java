package ca.hyperreal.calabexample;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.HashSet;
import java.util.Set;

import ca.hyperreal.color.HSL;
import ca.hyperreal.calab.CAEngineConstructor;
import ca.hyperreal.calab.CAEngine;

import scala.*;


public class VoteForLife implements CAEngineConstructor
{
	final Pattern RULE = Pattern.compile( "(\\d+)" );
	final Option<CAEngine> None = Option.empty();
	
	public Option<CAEngine> instance( String rule )
	{
	Matcher m = RULE.matcher( rule );
		
		if (m.matches())
		{
		HashSet<Integer> lives = new HashSet<Integer>();
		
			for (int i = 0; i < rule.length(); i++)
				lives.add( rule.charAt(i) - '0' );
				
			return new Some( new VoteForLifeEngine(lives) );
		}
		else
			return None;
	}
	
	public String toString()
	{
		return "Vote";
	}
}
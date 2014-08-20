package ca.hyperreal.calabexample;

import java.util.Set;
import java.awt.Color;

import ca.hyperreal.calab.Universe;
import ca.hyperreal.calab.CAEngine;


public class VoteForLifeEngine implements CAEngine
{
	Set<Integer> lives;
	Color[] colors = new Color[] {Color.DARK_GRAY.darker().darker(), Color.WHITE};	
	int maxValue = 1;
	
	public VoteForLifeEngine( Set<Integer> lives )
	{
		this.lives = lives;
	}
	
	public void update( int x, int y, Universe u )
	{
	int neighbours = 0;
	
		for (int i = -1; i <= 1; i++)
			for (int j = -1; j <= 1; j++)
				neighbours += u.read( x + i, y + j );

		u.write( x, y, lives.contains( neighbours ) ? 1 : 0 );
	}
	
	public Color[] colors()
	{
		return colors;
	}
	
	public int maxValue()
	{
		return maxValue;
	}
	
	public String toString()
	{
		return "Vote for Life [lives: " + lives + "]";
	}
}
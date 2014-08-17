package ca.hyperreal.calabexample

import java.awt.Color
import Color._
import ca.hyperreal.color.HSL

import  ca.hyperreal.calab.{CAEngineConstructor, CAEngine, Universe}


class CyclicCA extends CAEngineConstructor
{
	val RULE = """R(\d+)/T(\d+)/C(\d+)/N(N|M)"""r
	
	def apply( rule: String ) =
	{
		if (RULE.pattern.matcher( rule ).matches)
		{
		val RULE(r, t, c, n) = rule
		
			Some( new CyclicCAEngine(r.toInt, t.toInt, c.toInt, n == "M") )
		}
		else
			None
	}
	
	override def toString = "Cycl"
}

class CyclicCAEngine( range: Int, threshold: Int, count: Int, moore: Boolean ) extends CAEngine
{
	def apply( x: Int, y: Int, u: Universe )
	{
	var neighbours = 0
	val state = u.read( x, y )
	val next = (state + 1)%count
	
		for (i <- -range to range; j <- -range to range if !(i == 0 && j == 0))
			if (u.read( x + i, y + j ) == next)
				neighbours += 1 

		u.write( x, y, if (neighbours >= threshold) next else state )
	}
	
	val maxValue = count - 1
	
	val colors = Seq( DARK_GRAY.darker.darker ) ++ HSL.shading( .6, 1, maxValue, .3 )
	
	override def toString = s"""Cyclic CA [range: $range, threshold: $threshold, count: $count, neighbourhood: ${if (moore) "Moore" else "von Neumann"}]"""
}
package ca.hyperreal.calabexample

import java.awt.Color
import Color._
import ca.hyperreal.hsl.HSL

import ca.hyperreal.calab.{CAEngineConstructor, CAEngine, Universe}


class CyclicCA extends CAEngineConstructor
{
	val RULE = """R(\d+)/T(\d+)/C(\d+)/N(N|M)(?:/(GH))?"""r
	
	def instance( rule: String ) =
	{
		if (RULE.pattern.matcher( rule ).matches)
		{
		val RULE(r, t, c, n, g) = rule
		
			Some( new CyclicCAEngine(r.toInt, t.toInt, c.toInt, n == "M", g == "GH") )
		}
		else
			None
	}
	
	override def toString = "Cycl"
}

class CyclicCAEngine( range: Int, threshold: Int, count: Int, moore: Boolean, gh: Boolean ) extends CAEngine
{
	def update( x: Int, y: Int, u: Universe )
	{
	var neighbours = 0
	val state = u.read( x, y )
	val next = (state + 1)%count
	
		def incr( xoffset: Int, yoffset: Int ) =
			if (u.read( x + xoffset, y + yoffset ) == next)
				neighbours += 1 

		if (!gh || gh && state == 0)
		{
			if (moore)
				for (i <- -range to range; j <- -range to range if !(i == 0 && j == 0))
					incr( i, j )
			else
			{
				for (i <- -range + 1 to range - 1; j <- -range + 1 to range - 1 if !(i == 0 && j == 0))
					incr( i, j )
				
				for ((i, j) <- List((-range,0), (0, -range), (range, 0 ), (0, range)))
					incr( i, j )
			}

			u.write( x, y, if (neighbours >= threshold) next else state )
		}
		else
			u.write( x, y, next )
	}
	
	val maxValue = count - 1
	
	val colors = Array( DARK_GRAY.darker.darker ) ++ HSL.shading( .6, 1, maxValue, .3 )
	
	override def toString = s"""Cyclic CA [range: $range, threshold: $threshold, count: $count, neighbourhood: ${if (moore) "Moore" else "von Neumann"}""" +
		(if (gh) ", Greenberg-Hastings" else "")
}